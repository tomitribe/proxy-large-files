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

import org.apache.http.Header;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.apache.openejb.util.Join;

import java.io.IOException;

public class Assert {

    public static Response that(CloseableHttpResponse response) {
        return new Response(response);
    }

    public static class Response {
        private final CloseableHttpResponse response;

        public Response(final CloseableHttpResponse response) {
            this.response = response;
        }

        public Response header(final String name, final Object value) {
            final Header header = response.getFirstHeader(name);
            org.junit.Assert.assertNotNull("Missing header: " + name, header);
            org.junit.Assert.assertEquals("" + value, header.getValue());
            return this;
        }

        public Response path(final String... path) {
            final String s = "/" + Join.join("/", path);
            return header("~path", s);
        }

        public Response method(final Method method) {
            return header("~method", method.name());
        }

        public Response statusCode(final int code) {
            final StatusLine statusLine = response.getStatusLine();
            org.junit.Assert.assertEquals(code, statusLine.getStatusCode());
            return this;
        }

        public Response close() throws IOException {
            EntityUtils.consume(response.getEntity());
            response.close();
            return this;
        }

        public Response missing(final String headerName) {
            final Header header = response.getFirstHeader(headerName);
            org.junit.Assert.assertNull("Unexpected header: " + headerName, header);
            return this;
        }
    }


}
