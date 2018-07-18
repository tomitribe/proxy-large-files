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

import org.apache.http.client.RedirectStrategy;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.openejb.util.Join;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Proxy {

    public static Location location() {
        return Location.from(Host.get());
    }

    public static class Location {
        private final URI uri;

        public Location(final URI uri) {
            this.uri = uri;
        }

        public static Location from(final URI uri) {
            return new Location(uri);
        }

        public <H extends HttpRequestBase> Request<H> request(final Function<URI, ? extends HttpRequestBase> method) {
            return new Request(method.apply(uri));
        }

        public URI getUri() {
            return uri;
        }
    }

    public static class Request<H extends HttpRequestBase> {

        private final Map<String, String> variables = new HashMap<>();
        private final H base;

        public Request(final H base) {
            this.base = base;
        }

        public Request<H> var(final String name, final Object value) {
            variables.put(e(name), e("" + value));
            return this;
        }

        public Request<H> header(final String name, final Object value) {
            base.setHeader(e(name), e("" + value));
            return this;
        }

        public Request<H> path(final Object... path) {
            final URI uri = base.getURI().resolve(e(Join.join("/", path)));
            base.setURI(uri);
            return this;
        }

        private String e(final String template) {
            return StringTemplate.of(template).apply(variables);
        }

        public CloseableHttpResponse execute(final CloseableHttpClient closeableHttpClient) throws IOException {
            return closeableHttpClient.execute(base);
        }

        public CloseableHttpResponse execute() throws IOException {
            return execute(HttpClientBuilder.create().disableRedirectHandling().build());
        }
    }
}
