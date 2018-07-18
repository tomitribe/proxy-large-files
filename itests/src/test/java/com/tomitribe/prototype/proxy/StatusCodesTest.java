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
import org.apache.http.client.methods.HttpGet;
import org.junit.Test;

public class StatusCodesTest {

    private final Proxy.Location proxy = Proxy.location();

    @Test
    public void test200() throws Exception {
        final int code = 205;

        final CloseableHttpResponse response = proxy.request(HttpGet::new)
                .header("code", code)
                .path("code", code)
                .execute();

        Assert.that(response)
                .header("code", code)
                .statusCode(code)
                .close();
    }
}
