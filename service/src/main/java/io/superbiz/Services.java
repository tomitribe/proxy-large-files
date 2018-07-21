/* =====================================================================
 *
 * Copyright (c) 2011 David Blevins.  All rights reserved.
 *
 * =====================================================================
 */
package io.superbiz;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;
import java.util.Collections;

public class Services {

    public static Response.ResponseBuilder response(final HttpServletRequest request) {
        return process(Response.ok(), request);
    }

    public static Response.ResponseBuilder process(final Response.ResponseBuilder response, final HttpServletRequest request) {
        if (request.getHeader("Code") != null) {
            response.status(Integer.parseInt(request.getHeader("Code")));
        }
        response.header("~Path", request.getRequestURI());
        response.header("~Method", request.getMethod());
        for (final String name : Collections.list(request.getHeaderNames())) {
            response.header("@" + name, request.getHeader(name));
        }
        return response;
    }

    public static void process(final HttpServletRequest request, final HttpServletResponse response) {
        if (request.getHeader("Code") != null) {
            response.setStatus(Integer.parseInt(request.getHeader("Code")));
        }
        response.addHeader("~Path", request.getRequestURI());
        response.addHeader("~Method", request.getMethod());
        for (final String name : Collections.list(request.getHeaderNames())) {
            response.addHeader("@" + name, request.getHeader(name));
        }
    }
}
