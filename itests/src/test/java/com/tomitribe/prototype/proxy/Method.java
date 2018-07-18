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

import org.apache.http.client.methods.HttpRequestBase;

import java.net.URI;
import java.util.function.Function;

public enum Method {
    GET(Methods.GET),
    POST(Methods.POST),
    PUT(Methods.PUT),
    DELETE(Methods.DELETE),
    OPTIONS(Methods.OPTIONS),
    HEAD(Methods.HEAD)
    ;
    private final Function<URI, ? extends HttpRequestBase> request;

    Method(final Function<URI, ? extends HttpRequestBase> request) {
        this.request = request;
    }

    public <T extends HttpRequestBase> T create(final URI uri) {
        return (T) request.apply(uri);
    }

    public Function<URI, ? extends HttpRequestBase> getRequest() {
        return request;
    }
}
