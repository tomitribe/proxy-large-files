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
import org.tomitribe.util.Size;
import org.tomitribe.util.SizeUnit;

import static com.tomitribe.prototype.proxy.Method.POST;
import static com.tomitribe.prototype.proxy.Method.PUT;

public class BigPostTest {

    private final Proxy.Location proxy = Proxy.location();

    public void assertChunked(final int code, final Method method, final String size) throws java.io.IOException {
        final Body body = Body.generate(Size.parse(size).getSize(SizeUnit.BYTES));
        final CloseableHttpResponse response = proxy.request(method)
                .path("payload")
                .chunked(body)
                .execute();

        Assert.that(response)
                .path("payload")
                .method(method)
                .statusCode(code)
                .header("@transfer-encoding", "chunked")
                .missing("@content-length")
                .header("hash", body.getHash())
                .close();
    }

    public void assertContentLength(final int code, final Method method, final String size) throws java.io.IOException {
        final Body body = Body.generate(Size.parse(size).getSize(SizeUnit.BYTES));
        final CloseableHttpResponse response = proxy.request(method)
                .path("payload")
                .content(body)
                .execute();

        Assert.that(response)
                .path("payload")
                .method(method)
                .statusCode(code)
                .header("@content-length", body.getLength())
                .missing("@transfer-encoding")
                .header("hash", body.getHash())
                .close();
    }

    @Test
    public void test1MBPost() throws Exception {
        assertContentLength(200, POST, "1MB");
    }

    @Test
    public void test1GBPost() throws Exception {
        assertContentLength(200, POST, "1GB");
    }

    @Test
    public void test2GBPost() throws Exception {
        assertContentLength(200, POST, "2GB");
    }

    @Test
    public void test4GBPost() throws Exception {
        assertContentLength(200, POST, "4GB");
    }

    @Test
    public void test8GBPost() throws Exception {
        assertContentLength(200, POST, "8GB");
    }

    @Test
    public void test16GBPost() throws Exception {
        assertContentLength(200, POST, "16GB");
    }

    @Test
    public void test1GBPut() throws Exception {
        assertContentLength(200, PUT, "1GB");
    }

    @Test
    public void test2GBPut() throws Exception {
        assertContentLength(200, PUT, "2GB");
    }

    @Test
    public void test4GBPut() throws Exception {
        assertContentLength(200, PUT, "4GB");
    }

    @Test
    public void test8GBPut() throws Exception {
        assertContentLength(200, PUT, "8GB");
    }

    @Test
    public void test16GBPut() throws Exception {
        assertContentLength(200, PUT, "16GB");
    }

    @Test
    public void test1GBPostChunked() throws Exception {
        assertChunked(200, POST, "1GB");
    }

    @Test
    public void test2GBPostChunked() throws Exception {
        assertChunked(200, POST, "2GB");
    }

    @Test
    public void test4GBPostChunked() throws Exception {
        assertChunked(200, POST, "4GB");
    }

    @Test
    public void test8GBPostChunked() throws Exception {
        assertChunked(200, POST, "8GB");
    }

    @Test
    public void test16GBPostChunked() throws Exception {
        assertChunked(200, POST, "16GB");
    }

    @Test
    public void test1GBPutChunked() throws Exception {
        assertChunked(200, PUT, "1GB");
    }

    @Test
    public void test2GBPutChunked() throws Exception {
        assertChunked(200, PUT, "2GB");
    }

    @Test
    public void test4GBPutChunked() throws Exception {
        assertChunked(200, PUT, "4GB");
    }

    @Test
    public void test8GBPutChunked() throws Exception {
        assertChunked(200, PUT, "8GB");
    }

    @Test
    public void test16GBPutChunked() throws Exception {
        assertChunked(200, PUT, "16GB");
    }
}
