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
package io.superbiz;


import io.airlift.slice.XxHash64;
import org.tomitribe.util.Longs;

import javax.ejb.Lock;
import javax.ejb.Singleton;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import static javax.ejb.LockType.READ;

/**
 * The proxy should stream data to the endpoint, and should work with large
 * payloads irrespective of how they are sent.
 *
 * For example, if the payload is sent as a single request with a
 * content-length header, the content-length header should not be changed,
 * and the transfer-encoding should not be changed to chunked.
 *
 * If the request is sent to the proxy using chunked encoding, the onwards
 * request to the endpoint should also be sent with chunked encoding.
 *
 * This endpoint returns no response payload, but copies all request
 * headers to the response, prefixed with "X-Request-Header-", and
 * adds a "X-Request-Payload-Size" header which has the number of bytes
 * read from the inputstream on the request.
 */
@Lock(READ)
@Singleton
@Path("/payload")
public class PayloadService {

    public PayloadService() {
    }

    @POST
    @Consumes("*/*")
    public Response post(final @Context HttpServletRequest request) throws Exception {
        return process(request);
    }

    @PUT
    @Consumes("*/*")
    public Response put(final @Context HttpServletRequest request) throws Exception {
        return process(request);
    }

    private Response process(@Context HttpServletRequest request) throws IOException, NoSuchAlgorithmException {
        final XxHash64 hash = new XxHash64();
        byte[] buffer = new byte[10 * 1024 * 1024]; // 10 MB
        int bytesRead = 0;

        final ServletInputStream inputStream = request.getInputStream();
        while ((bytesRead = inputStream.read(buffer)) > -1) {
            hash.update(buffer, 0, bytesRead);
        }

        return Services.response(request).header("hash", Longs.toHex(hash.hash())).build();
    }
}
