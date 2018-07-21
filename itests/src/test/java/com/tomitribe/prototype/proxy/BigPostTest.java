/*
 * Tomitribe Confidential
 *
 * Copyright Tomitribe Corporation. 2018
 *
 * The source code for this program is not published or otherwise divested 
 * of its trade secrets, irrespective of what has been deposited with the 
 * U.S. Copyright Office.
 */
package com.tomitribe.prototype.proxy;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.entity.InputStreamEntity;
import org.junit.Test;
import org.tomitribe.util.SizeUnit;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import static com.tomitribe.prototype.proxy.Method.*;
import static org.junit.Assert.assertEquals;

public class BigPostTest {

    private final Proxy.Location proxy = Proxy.location();

    public void assertReceived(final int code, final Method method, final long size, final boolean chunked) throws java.io.IOException {

        final Body body = Body.generate(size);
        final CloseableHttpResponse response;
        if (chunked) {
            response = proxy.request(method)
                    .path("payload")
                    .chunked(body)
                    .execute();
        } else {
            response = proxy.request(method)
                    .path("payload")
                    .content(body)
                    .execute();
        }


        if (chunked) {
            assertEquals(0, response.getHeaders("X-Request-Header-content-length").length);
            assertEquals("chunked", response.getHeaders("X-Request-Header-transfer-encoding")[0].getValue());
        } else {
            assertEquals(String.valueOf(size), response.getHeaders("X-Request-Header-content-length")[0].getValue());
            assertEquals(0, response.getHeaders("X-Request-Header-transfer-encoding").length);
        }

        Assert.that(response)
                .header("hash", body.getHash())
                .statusCode(code)
                .close();
    }

    public class RandomInputStream extends InputStream {

        private long remaining;
        private final byte[] generated;
        private final Random random;

        public RandomInputStream(final long length) {
            this.remaining = length;
            this.random = new Random();
            this.generated = new byte[(int) Math.min(length, 1024 * 8)];

            for (int i = 0; i < generated.length; i++) {
                generated[i] = (byte) random.nextInt();
            }
        }

        @Override
        public int read(byte[] b) throws IOException {
            return read(b, 0, b.length);
        }

        @Override
        public int read(byte[] b, int offset, int length) throws IOException {
            if (remaining <= 0) return -1;

            // we can't write more bytes than we've generated
            length = Math.min(generated.length, length);

            // we can't write more bytes than are remaining
            length = (int) Math.min(remaining, length);

            // copy what we can into the buffer
            System.arraycopy(generated, 0, b, offset, length);

            remaining -= length;
            return length;
        }

        public int read() throws IOException {
            if (remaining <= 0) return -1;
            remaining--;
            return random.nextInt();
        }
    }

    @Test
    public void test1GBPost() throws Exception {
        final long size = SizeUnit.GIGABYTES.toBytes(1);
        assertReceived(200, POST, size, false);
    }

    @Test
    public void test2GBPost() throws Exception {
        final long size = SizeUnit.GIGABYTES.toBytes(2);
        assertReceived(200, POST, size, false);
    }

    @Test
    public void test4GBPost() throws Exception {
        final long size = SizeUnit.GIGABYTES.toBytes(4);
        assertReceived(200, POST, size, false);
    }

    @Test
    public void test8GBPost() throws Exception {
        final long size = SizeUnit.GIGABYTES.toBytes(8);
        assertReceived(200, POST, size, false);
    }

    @Test
    public void test16GBPost() throws Exception {
        final long size = SizeUnit.GIGABYTES.toBytes(16);
        assertReceived(200, POST, size, false);
    }

    @Test
    public void test1GBPut() throws Exception {
        final long size = SizeUnit.GIGABYTES.toBytes(1);
        assertReceived(200, PUT, size, false);
    }

    @Test
    public void test2GBPut() throws Exception {
        final long size = SizeUnit.GIGABYTES.toBytes(2);
        assertReceived(200, PUT, size, false);
    }

    @Test
    public void test4GBPut() throws Exception {
        final long size = SizeUnit.GIGABYTES.toBytes(4);
        assertReceived(200, PUT, size, false);
    }

    @Test
    public void test8GBPut() throws Exception {
        final long size = SizeUnit.GIGABYTES.toBytes(8);
        assertReceived(200, PUT, size, false);
    }

    @Test
    public void test16GBPut() throws Exception {
        final long size = SizeUnit.GIGABYTES.toBytes(16);
        assertReceived(200, PUT, size, false);
    }

    @Test
    public void test1GBPostChunked() throws Exception {
        final long size = SizeUnit.GIGABYTES.toBytes(1);
        assertReceived(200, POST, size, true);
    }

    @Test
    public void test2GBPostChunked() throws Exception {
        final long size = SizeUnit.GIGABYTES.toBytes(2);
        assertReceived(200, POST, size, true);
    }

    @Test
    public void test4GBPostChunked() throws Exception {
        final long size = SizeUnit.GIGABYTES.toBytes(4);
        assertReceived(200, POST, size, true);
    }

    @Test
    public void test8GBPostChunked() throws Exception {
        final long size = SizeUnit.GIGABYTES.toBytes(8);
        assertReceived(200, POST, size, true);
    }

    @Test
    public void test16GBPostChunked() throws Exception {
        final long size = SizeUnit.GIGABYTES.toBytes(16);
        assertReceived(200, POST, size, true);
    }

    @Test
    public void test1GBPutChunked() throws Exception {
        final long size = SizeUnit.GIGABYTES.toBytes(1);
        assertReceived(200, PUT, size, true);
    }

    @Test
    public void test2GBPutChunked() throws Exception {
        final long size = SizeUnit.GIGABYTES.toBytes(2);
        assertReceived(200, PUT, size, true);
    }

    @Test
    public void test4GBPutChunked() throws Exception {
        final long size = SizeUnit.GIGABYTES.toBytes(4);
        assertReceived(200, PUT, size, true);
    }

    @Test
    public void test8GBPutChunked() throws Exception {
        final long size = SizeUnit.GIGABYTES.toBytes(8);
        assertReceived(200, PUT, size, true);
    }

    @Test
    public void test16GBPutChunked() throws Exception {
        final long size = SizeUnit.GIGABYTES.toBytes(16);
        assertReceived(200, PUT, size, true);
    }
}
