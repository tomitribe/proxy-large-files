/* =====================================================================
 *
 * Copyright (c) 2011 David Blevins.  All rights reserved.
 *
 * =====================================================================
 */
package io.superbiz;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;
import java.util.Collections;

public class Services {

    public static Response.ResponseBuilder response(final HttpServletRequest request) {
        return echoHeaders(Response.ok(), request);
    }

    public static Response.ResponseBuilder echoHeaders(final Response.ResponseBuilder response, final HttpServletRequest request) {
        response.header("~Path", request.getRequestURI());
        response.header("~Method", request.getMethod());
        for (final String name : Collections.list(request.getHeaderNames())) {
            response.header("@" + name, request.getHeader(name));
        }
        return response;
    }
}
