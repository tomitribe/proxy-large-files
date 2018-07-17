/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.superbiz;

import org.tomitribe.util.Duration;
import org.tomitribe.util.Hex;
import org.tomitribe.util.IO;
import org.tomitribe.util.Size;
import org.tomitribe.util.SizeUnit;
import org.tomitribe.util.TimeUtils;

import javax.ejb.Lock;
import javax.ejb.Singleton;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.StreamingOutput;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

import static javax.ejb.LockType.READ;
import static javax.ejb.LockType.WRITE;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Lock(READ)
@Singleton
@Path("/color")
public class ColorService {

    @Context
    private HttpServletRequest request;

    private AtomicReference<String> color;

    public ColorService() {
        this.color = new AtomicReference<>("green");
    }

    @GET
    public String getColor() {
        return color.get();
    }

    @Lock(WRITE)
    @Path("{color}")
    @POST
    public void setColor(@PathParam("color") String color) {
        this.color.getAndSet(color);
    }

    @Path("object")
    @GET
    @Produces({APPLICATION_JSON})
    public Color getColorObject() {
        return new Color("orange", 0xE7, 0x71, 0x00);
    }

    /**
     * Emits a steady and fast stream of data until the specified size is reached
     *
     * Intended for happy-path verification that we can send large files through
     * the proxy.
     */
    @Path("send/{size}")
    @GET
    public StreamingOutput send(final @PathParam("size") Size size) {
        final long bytesWanted = size.getSize(SizeUnit.BYTES);

        final byte[] generatedData = new byte[1024];
        for (int i = 0; i < generatedData.length; i++) generatedData[i] = 'A';

        return os -> {

            final int blocks = (int) (bytesWanted / generatedData.length);
            for (int i = 0; i < blocks; i++) os.write(generatedData);

            final int remainder = (int) (bytesWanted % generatedData.length);
            os.write(generatedData, 0, remainder);
        };
    }

    /**
     * Emits data at a steady pace, pausing every 4k bytes by the specified 'pause' duration
     *
     * Intended to allow testing that a slow responder that stays within the tolerance of
     * the timeouts is allowed to keep sending data.
     */
    @Path("slow/{size}/{pause}")
    @GET
    public StreamingOutput slow(final @PathParam("size") Size size, final @PathParam("pause") Duration pause) {
        final long bytesWanted = size.getSize(SizeUnit.BYTES);
        final long sleep = pause.getTime(TimeUnit.MILLISECONDS);

        final byte[] generatedData = new byte[1024 * 4];
        for (int i = 0; i < generatedData.length; i++) generatedData[i] = 'A';

        return os -> {

            final int blocks = (int) (bytesWanted / generatedData.length);
            for (int i = 0; i < blocks; i++) {
                os.write(generatedData);
                try {
                    Thread.sleep(sleep);
                } catch (InterruptedException e) {
                    Thread.interrupted();
                }
            }

            final int remainder = (int) (bytesWanted % generatedData.length);
            os.write(generatedData, 0, remainder);
        };
    }

    /**
     * Emits no output whatsoever until the passed in timeout has elapsed
     *
     * Intended to help test situations were we are trying to contact a server
     * that is not responding.
     *
     * @param sleep
     * @return
     */
    @Path("sleep/{sleep}")
    @GET
    public StreamingOutput sleep(final @PathParam("sleep") Duration sleep) {
        return os -> {
            try {
                Thread.sleep(sleep.getTime(TimeUnit.MILLISECONDS));
            } catch (InterruptedException e) {
                Thread.interrupted();
            }
            os.write("Done".getBytes());
        };
    }

    /**
     * Emits output at an increasingly slow pace, not exceeding the passed in timeout
     *
     * Intended to help test read timeouts.  We can verify things do not timeout for
     * pauses below the timeout.  We can veryify our behavior when a server does respond,
     * but begins sending data very slowly.
     */
    @Path("slowdown/{timeout}")
    @GET
    public StreamingOutput slowdown(final @PathParam("timeout") Duration timeout) {
        System.out.printf("Timeout %s%n", TimeUtils.abbreviateMillis(timeout.getTime(TimeUnit.MILLISECONDS)));

        final byte[] generatedData = new byte[128];
        for (int i = 0; i < generatedData.length; i++) generatedData[i] = 'A';

        return os -> {
            final long time = timeout.getTime(TimeUnit.MILLISECONDS);
            for (long i = 100; i < time; i *= 2) {
                os.write(generatedData);
                os.write(String.format("%nSleep %s%n", TimeUtils.abbreviateMillis(i)).getBytes());
                System.out.printf("Sleep %s%n", TimeUtils.abbreviateMillis(i));
                try {
                    Thread.sleep(i);
                } catch (InterruptedException e) {
                    Thread.interrupted();
                    e.printStackTrace();
                }
            }
            os.write(String.format("%nDone%n").getBytes());
        };
    }

    @POST
    @Path("echo")
    @Consumes("*/*")
    public StreamingOutput echo() {

        final InputStream from;
        try {
            final File file = File.createTempFile("request", ".bin");
            System.out.printf("Buffer{%s}%n", file.getAbsolutePath());
            IO.copy(request.getInputStream(), file);

            from = IO.read(file);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }

        return os -> {
            byte[] buffer = new byte[1024 * 8];
            int length;

            while ((length = from.read(buffer)) != -1) {
                final String string = new String(buffer);

                final String replaced = string.replace('A', 'B');

                os.write(replaced.getBytes(), 0, length);
            }

            os.flush();
        };
    }

    @POST
    @Path("hash")
    @Consumes("*/*")
    public String hash() throws NoSuchAlgorithmException {
        final MessageDigest instance = MessageDigest.getInstance("SHA-256");
        try {
            IO.copy(request.getInputStream(), new OutputStream() {
                @Override
                public void write(final byte[] b) throws IOException {
                    instance.update(b);
                }

                @Override
                public void write(final byte[] b, final int off, final int len) throws IOException {
                    instance.update(b, off, len);
                }

                @Override
                public void write(final int b) throws IOException {
                    instance.update((byte) b);
                }
            });

            final byte[] digest = instance.digest();
            return Hex.toString(digest);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
