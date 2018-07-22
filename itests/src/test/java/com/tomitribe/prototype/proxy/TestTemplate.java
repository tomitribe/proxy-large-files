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
import org.junit.Test;

import static com.tomitribe.prototype.proxy.Method.DELETE;
import static com.tomitribe.prototype.proxy.Method.GET;
import static com.tomitribe.prototype.proxy.Method.HEAD;
import static com.tomitribe.prototype.proxy.Method.OPTIONS;
import static com.tomitribe.prototype.proxy.Method.POST;
import static com.tomitribe.prototype.proxy.Method.PUT;

/**
 * Goals: A proxy should or should not do X or Y and this
 * test uses Y and Z to ensure this is happening.
 *
 * To assert we send an HTTP request like the following:
 *
 * ----Request---
 * GET /code/234 HTTP/1.1
 *
 * --------------
 *
 * We expect back a message from our service:
 *
 * ----Response---
 * HTTP/1.1 234 Something
 * Code: 234
 * Method: GET
 * --------------
 *
 * Here we verify that the proxy did not change or block the
 * method incoming method and will allow it to return the
 * expected status code
 */
public class TestTemplate {

    private final Proxy.Location proxy = Proxy.location();

    public void assertCode(final int code, final Method method) throws java.io.IOException {
        final CloseableHttpResponse response = proxy.request(method)
                .path("code", code)
                .header("code", code)
                .execute();

        Assert.that(response)
                .path("code")
                .header("code", code)
                .header("method", method)
                .statusCode(code)
                .close();
    }

    @Test
    public void test200_GET() throws Exception {
        assertCode(200, GET);
    }

    @Test
    public void test200_POST() throws Exception {
        assertCode(200, POST);
    }

    @Test
    public void test200_PUT() throws Exception {
        assertCode(200, PUT);
    }

    @Test
    public void test200_DELETE() throws Exception {
        assertCode(200, DELETE);
    }

    @Test
    public void test200_OPTIONS() throws Exception {
        assertCode(200, OPTIONS);
    }

    @Test
    public void test200_HEAD() throws Exception {
        assertCode(200, HEAD);
    }
}
