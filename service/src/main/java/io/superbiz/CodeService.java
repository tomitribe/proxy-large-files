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

import javax.ejb.Lock;
import javax.ejb.Singleton;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import static javax.ejb.LockType.READ;

/**
 * The proxy should not be opinionated about the status code and
 * attempt to interpret it or change it.
 *
 * This endpoint allows us to test that the proxy will in fact
 * return any status code.  From the client, we can iterate
 * from 100 to 599 and theoretically every single response code
 * should come through the proxy untouched.
 *
 */
@Lock(READ)
@Singleton
@Path("/code")
public class CodeService {

    @Context
    private HttpServletRequest request;

    public CodeService() {
    }

    @GET
    @Path("{code}")
    @Consumes("*/*")
    public Response get(final @PathParam("code") int code) {
        return Response.status(code).header("code", code).build();
    }

    @POST
    @Path("{code}")
    @Consumes("*/*")
    public Response post(final @PathParam("code") int code) {
        return Response.status(code).header("code", code).build();
    }

    @PUT
    @Path("{code}")
    @Consumes("*/*")
    public Response put(final @PathParam("code") int code) {
        return Response.status(code).header("code", code).build();
    }

    @DELETE
    @Path("{code}")
    @Consumes("*/*")
    public Response delete(final @PathParam("code") int code) {
        return Response.status(code).header("code", code).build();
    }

    @OPTIONS
    @Path("{code}")
    @Consumes("*/*")
    public Response options(final @PathParam("code") int code) {
        return Response.status(code).header("code", code).build();
    }

    @HEAD
    @Path("{code}")
    @Consumes("*/*")
    public Response head(final @PathParam("code") int code) {
        return Response.status(code).header("code", code).build();
    }
}
