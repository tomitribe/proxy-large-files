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

import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;

import java.net.URI;
import java.util.function.Function;

public class Methods {
    public static final Function<URI, HttpGet> GET = HttpGet::new;
    public static final Function<URI, HttpPost> POST = HttpPost::new;
    public static final Function<URI, HttpPut> PUT = HttpPut::new;
    public static final Function<URI, HttpDelete> DELETE = HttpDelete::new;
    public static final Function<URI, HttpHead> HEAD = HttpHead::new;
    public static final Function<URI, HttpOptions> OPTIONS = HttpOptions::new;
}
