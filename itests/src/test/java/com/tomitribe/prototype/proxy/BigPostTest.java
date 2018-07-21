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

import com.tomitribe.prototype.proxy.util.Chance;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.junit.Test;
import org.tomitribe.util.Size;
import org.tomitribe.util.SizeUnit;

import java.io.IOException;

import static com.tomitribe.prototype.proxy.Method.DELETE;
import static com.tomitribe.prototype.proxy.Method.GET;
import static com.tomitribe.prototype.proxy.Method.HEAD;
import static com.tomitribe.prototype.proxy.Method.OPTIONS;
import static com.tomitribe.prototype.proxy.Method.POST;
import static com.tomitribe.prototype.proxy.Method.PUT;

public class BigPostTest {

    private final Proxy.Location proxy = Proxy.location();

    public void assertChunked(final int code, final Method method, final String size) throws java.io.IOException {
        assertChunked(code, method, Size.parse(size).getSize(SizeUnit.BYTES));
    }

    private void assertChunked(final int codeRange, final Method method, final long size) throws IOException {
        // Respond in a range, say 200-299
        final int code = Chance.range(codeRange, codeRange + 99);

        // Generate a payload that is within 30% of the requested size
        final Body body = Body.generate(Chance.deviate(size, 0.3f));

        final CloseableHttpResponse response = proxy.request(method)
                .path("payload")
                .header("code", code)
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
        assertContentLength(code, method, Size.parse(size).getSize(SizeUnit.BYTES));
    }

    private void assertContentLength(final int codeRange, final Method method, final long size) throws IOException {
        // Respond in a range, say 200-299
        final int code = Chance.range(codeRange, codeRange + 99);

        // Generate a payload that is within 30% of the requested size
        final Body body = Body.generate(Chance.deviate(size, 0.3f));

        final CloseableHttpResponse response = proxy.request(method)
                .path("payload")
                .header("code", code)
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

    //---- GET : Content-Length ------------//

    @Test
    public void test1GBGet() throws Exception {
        assertContentLength(200, GET, "1GB");
    }

    @Test
    public void test2GBGet() throws Exception {
        assertContentLength(200, GET, "2GB");
    }

    @Test
    public void test4GBGet() throws Exception {
        assertContentLength(200, GET, "4GB");
    }

    @Test
    public void test8GBGet() throws Exception {
        assertContentLength(200, GET, "8GB");
    }

    @Test
    public void test16GBGet() throws Exception {
        assertContentLength(200, GET, "16GB");
    }

    @Test
    public void test16GBGet300() throws Exception {
        assertContentLength(300, GET, "16GB");
    }

    @Test
    public void test16GBGet400() throws Exception {
        assertContentLength(400, GET, "16GB");
    }

    @Test
    public void test16GBGet500() throws Exception {
        assertContentLength(500, GET, "16GB");
    }

    //---- GET : Chunked ------------//

    @Test
    public void test1GBGetChunked() throws Exception {
        assertChunked(200, GET, "1GB");
    }

    @Test
    public void test2GBGetChunked() throws Exception {
        assertChunked(200, GET, "2GB");
    }

    @Test
    public void test4GBGetChunked() throws Exception {
        assertChunked(200, GET, "4GB");
    }

    @Test
    public void test8GBGetChunked() throws Exception {
        assertChunked(200, GET, "8GB");
    }

    @Test
    public void test16GBGetChunked() throws Exception {
        assertChunked(200, GET, "16GB");
    }

    @Test
    public void test16GBGetChunked300() throws Exception {
        assertContentLength(300, GET, "16GB");
    }

    @Test
    public void test16GBGetChunked400() throws Exception {
        assertContentLength(400, GET, "16GB");
    }

    @Test
    public void test16GBGetChunked500() throws Exception {
        assertContentLength(500, GET, "16GB");
    }
    //---- POST : Content-Length ------------//

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
    public void test16GBPost300() throws Exception {
        assertContentLength(300, POST, "16GB");
    }

    @Test
    public void test16GBPost400() throws Exception {
        assertContentLength(400, POST, "16GB");
    }

    @Test
    public void test16GBPost500() throws Exception {
        assertContentLength(500, POST, "16GB");
    }

    //---- POST : Chunked ------------//

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
    public void test16GBPostChunked300() throws Exception {
        assertContentLength(300, POST, "16GB");
    }

    @Test
    public void test16GBPostChunked400() throws Exception {
        assertContentLength(400, POST, "16GB");
    }

    @Test
    public void test16GBPostChunked500() throws Exception {
        assertContentLength(500, POST, "16GB");
    }

    //---- PUT : Content-Length ------------//

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
    public void test16GBPut300() throws Exception {
        assertContentLength(300, PUT, "16GB");
    }

    @Test
    public void test16GBPut400() throws Exception {
        assertContentLength(400, PUT, "16GB");
    }

    @Test
    public void test16GBPut500() throws Exception {
        assertContentLength(500, PUT, "16GB");
    }

    //---- PUT : Chunked ------------//

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

    @Test
    public void test16GBPutChunked300() throws Exception {
        assertContentLength(300, PUT, "16GB");
    }

    @Test
    public void test16GBPutChunked400() throws Exception {
        assertContentLength(400, PUT, "16GB");
    }

    @Test
    public void test16GBPutChunked500() throws Exception {
        assertContentLength(500, PUT, "16GB");
    }

    //---- DELETE : Content-Length ------------//

    @Test
    public void test1GBDelete() throws Exception {
        assertContentLength(200, DELETE, "1GB");
    }

    @Test
    public void test2GBDelete() throws Exception {
        assertContentLength(200, DELETE, "2GB");
    }

    @Test
    public void test4GBDelete() throws Exception {
        assertContentLength(200, DELETE, "4GB");
    }

    @Test
    public void test8GBDelete() throws Exception {
        assertContentLength(200, DELETE, "8GB");
    }

    @Test
    public void test16GBDelete() throws Exception {
        assertContentLength(200, DELETE, "16GB");
    }

    @Test
    public void test16GBDelete300() throws Exception {
        assertContentLength(300, DELETE, "16GB");
    }

    @Test
    public void test16GBDelete400() throws Exception {
        assertContentLength(400, DELETE, "16GB");
    }

    @Test
    public void test16GBDelete500() throws Exception {
        assertContentLength(500, DELETE, "16GB");
    }

    //---- DELETE : Chunked ------------//

    @Test
    public void test1GBDeleteChunked() throws Exception {
        assertChunked(200, DELETE, "1GB");
    }

    @Test
    public void test2GBDeleteChunked() throws Exception {
        assertChunked(200, DELETE, "2GB");
    }

    @Test
    public void test4GBDeleteChunked() throws Exception {
        assertChunked(200, DELETE, "4GB");
    }

    @Test
    public void test8GBDeleteChunked() throws Exception {
        assertChunked(200, DELETE, "8GB");
    }

    @Test
    public void test16GBDeleteChunked() throws Exception {
        assertChunked(200, DELETE, "16GB");
    }

    @Test
    public void test16GBDeleteChunked300() throws Exception {
        assertContentLength(300, DELETE, "16GB");
    }

    @Test
    public void test16GBDeleteChunked400() throws Exception {
        assertContentLength(400, DELETE, "16GB");
    }

    @Test
    public void test16GBDeleteChunked500() throws Exception {
        assertContentLength(500, DELETE, "16GB");
    }

    //---- OPTIONS : Content-Length ------------//

    @Test
    public void test1GBOptions() throws Exception {
        assertContentLength(200, OPTIONS, "1GB");
    }

    @Test
    public void test2GBOptions() throws Exception {
        assertContentLength(200, OPTIONS, "2GB");
    }

    @Test
    public void test4GBOptions() throws Exception {
        assertContentLength(200, OPTIONS, "4GB");
    }

    @Test
    public void test8GBOptions() throws Exception {
        assertContentLength(200, OPTIONS, "8GB");
    }

    @Test
    public void test16GBOptions() throws Exception {
        assertContentLength(200, OPTIONS, "16GB");
    }

    @Test
    public void test16GBOptions300() throws Exception {
        assertContentLength(300, OPTIONS, "16GB");
    }

    @Test
    public void test16GBOptions400() throws Exception {
        assertContentLength(400, OPTIONS, "16GB");
    }

    @Test
    public void test16GBOptions500() throws Exception {
        assertContentLength(500, OPTIONS, "16GB");
    }

    //---- OPTIONS : Chunked ------------//

    @Test
    public void test1GBOptionsChunked() throws Exception {
        assertChunked(200, OPTIONS, "1GB");
    }

    @Test
    public void test2GBOptionsChunked() throws Exception {
        assertChunked(200, OPTIONS, "2GB");
    }

    @Test
    public void test4GBOptionsChunked() throws Exception {
        assertChunked(200, OPTIONS, "4GB");
    }

    @Test
    public void test8GBOptionsChunked() throws Exception {
        assertChunked(200, OPTIONS, "8GB");
    }

    @Test
    public void test16GBOptionsChunked() throws Exception {
        assertChunked(200, OPTIONS, "16GB");
    }

    @Test
    public void test16GBOptionsChunked300() throws Exception {
        assertContentLength(300, OPTIONS, "16GB");
    }

    @Test
    public void test16GBOptionsChunked400() throws Exception {
        assertContentLength(400, OPTIONS, "16GB");
    }

    @Test
    public void test16GBOptionsChunked500() throws Exception {
        assertContentLength(500, OPTIONS, "16GB");
    }

    //---- HEAD : Content-Length ------------//

    @Test
    public void test1GBHead() throws Exception {
        assertContentLength(200, HEAD, "1GB");
    }

    @Test
    public void test2GBHead() throws Exception {
        assertContentLength(200, HEAD, "2GB");
    }

    @Test
    public void test4GBHead() throws Exception {
        assertContentLength(200, HEAD, "4GB");
    }

    @Test
    public void test8GBHead() throws Exception {
        assertContentLength(200, HEAD, "8GB");
    }

    @Test
    public void test16GBHead() throws Exception {
        assertContentLength(200, HEAD, "16GB");
    }

    @Test
    public void test16GBHead300() throws Exception {
        assertContentLength(300, HEAD, "16GB");
    }

    @Test
    public void test16GBHead400() throws Exception {
        assertContentLength(400, HEAD, "16GB");
    }

    @Test
    public void test16GBHead500() throws Exception {
        assertContentLength(500, HEAD, "16GB");
    }

    //---- HEAD : Chunked ------------//

    @Test
    public void test1GBHeadChunked() throws Exception {
        assertChunked(200, HEAD, "1GB");
    }

    @Test
    public void test2GBHeadChunked() throws Exception {
        assertChunked(200, HEAD, "2GB");
    }

    @Test
    public void test4GBHeadChunked() throws Exception {
        assertChunked(200, HEAD, "4GB");
    }

    @Test
    public void test8GBHeadChunked() throws Exception {
        assertChunked(200, HEAD, "8GB");
    }

    @Test
    public void test16GBHeadChunked() throws Exception {
        assertChunked(200, HEAD, "16GB");
    }

    @Test
    public void test16GBHeadChunked300() throws Exception {
        assertContentLength(300, HEAD, "16GB");
    }

    @Test
    public void test16GBHeadChunked400() throws Exception {
        assertContentLength(400, HEAD, "16GB");
    }

    @Test
    public void test16GBHeadChunked500() throws Exception {
        assertContentLength(500, HEAD, "16GB");
    }
}
