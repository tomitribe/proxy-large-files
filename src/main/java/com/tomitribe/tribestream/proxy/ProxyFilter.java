/*
 * Tomitribe Confidential
 *
 * Copyright Tomitribe Corporation. 2017
 *
 * The source code for this program is not published or otherwise divested 
 * of its trade secrets, irrespective of what has been deposited with the 
 * U.S. Copyright Office.
 */
package com.tomitribe.tribestream.proxy;

import io.netty.handler.codec.http.HttpHeaders;
import org.asynchttpclient.AsyncHandler;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.BoundRequestBuilder;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.asynchttpclient.HttpResponseBodyPart;
import org.asynchttpclient.HttpResponseHeaders;
import org.asynchttpclient.HttpResponseStatus;
import org.asynchttpclient.ListenableFuture;
import org.asynchttpclient.Response;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;


@WebFilter("/proxy/*")
public class ProxyFilter implements javax.servlet.Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        filter((HttpServletRequest) request, (HttpServletResponse) response, chain);
    }

    public void filter(final HttpServletRequest request, final HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            final AsyncHttpClient asyncHttpClient = new DefaultAsyncHttpClient();

            final URI uri;
            { // Proxy all requests to localhost:7000 for this prototype

                final String requestURI = request.getRequestURI().replaceFirst(".*/proxy/", "");
                System.out.printf("RequestUri{%s}%n", requestURI);
                uri = URI.create("http://localhost:7000/").resolve(requestURI);
            }

            final Supplier<ServletOutputStream> out;
            { // Lazily get the ServletOutputStream when needed

                out = new Supplier<ServletOutputStream>() {
                    volatile ServletOutputStream outputStream;

                    @Override
                    public ServletOutputStream get() {
                        try {
                            if (outputStream == null) {
                                System.out.println("OpenStream{}");
                                outputStream = response.getOutputStream();
                            }
                            return outputStream;
                        } catch (IOException e) {
                            throw new IllegalStateException(e);
                        }
                    }
                };
            }


            final BoundRequestBuilder builder;
            { // Use the Appropriate HTTP Request Method

                final String method = request.getMethod().toUpperCase();
                if ("GET".equals(method)) {
                    builder = asyncHttpClient.prepareGet(uri.toASCIIString());
                } else if ("CONNECT".equals(method)) {
                    builder = asyncHttpClient.prepareConnect(uri.toASCIIString());
                } else if ("OPTIONS".equals(method)) {
                    builder = asyncHttpClient.prepareOptions(uri.toASCIIString());
                } else if ("HEAD".equals(method)) {
                    builder = asyncHttpClient.prepareHead(uri.toASCIIString());
                } else if ("POST".equals(method)) {
                    builder = asyncHttpClient.preparePost(uri.toASCIIString());
                } else if ("PUT".equals(method)) {
                    builder = asyncHttpClient.preparePut(uri.toASCIIString());
                } else if ("DELETE".equals(method)) {
                    builder = asyncHttpClient.prepareDelete(uri.toASCIIString());
                } else if ("PATCH".equals(method)) {
                    builder = asyncHttpClient.preparePatch(uri.toASCIIString());
                } else {
                    throw new IllegalStateException("Unkown HTTP Method " + method);
                }
            }

            { // Copy all the incoming Request Headers

                Collections.list(request.getHeaderNames()).stream()
                        .filter(name -> name.equalsIgnoreCase("User-Agent"))
                        .filter(name -> name.equalsIgnoreCase("Host"))
                        .forEach(name -> {
                            System.out.printf("AddHeader{name='%s', value='%s'}%n", name, request.getHeader(name));
                            builder.addHeader(name, request.getHeader(name));
                        });
            }

            { // Copy incoming Requesty Body

                if (request.getContentLength() > 0) {
                    builder.setBody(request.getInputStream());
                }
            }

            // And away we go
            final ListenableFuture<Response> execute = builder.execute(new AsyncHandler<Response>() {
                @Override
                public void onThrowable(Throwable throwable) {
                    System.out.println("AsyncHandler.onThrowable");
                }

                @Override
                public State onBodyPartReceived(HttpResponseBodyPart part) throws Exception {
                    System.out.printf("AsyncHandler.onBodyPartReceived %s - %s%n", part.length(), part.isLast());
                    out.get().write(part.getBodyPartBytes());
                    return State.CONTINUE;
                }

                @Override
                public State onStatusReceived(HttpResponseStatus status) throws Exception {
                    System.out.printf("AsyncHandler.onStatusReceived %s - %s%n", status.getStatusCode(), status.getStatusText());
                    response.setStatus(status.getStatusCode(), status.getStatusText());
                    return State.CONTINUE;
                }

                @Override
                public State onHeadersReceived(HttpResponseHeaders httpResponseHeaders) throws Exception {
                    System.out.println("AsyncHandler.onHeadersReceived");
                    final HttpHeaders headers = httpResponseHeaders.getHeaders();
                    for (final Map.Entry<String, String> entry : headers.entries()) {
                        final String key = entry.getKey();
                        final String value = entry.getValue();
                        System.out.printf(" %s: %s%n", key, value);
                        response.setHeader(key, value);
                    }
                    return State.CONTINUE;
                }

                @Override
                public Response onCompleted() throws Exception {
                    out.get().flush();
                    out.get().close();
                    System.out.println("AsyncHandler.onCompleted!");
                    return null;
                }
            });

            System.out.println("AsyncHandler.toCompletableFuture");
            final CompletableFuture<Response> future = execute.toCompletableFuture();
            future.get();
        } catch (InterruptedException e) {
            Thread.interrupted();
            throw new IOException(e);
        } catch (ExecutionException e) {
            throw new IOException(e);
        }
    }

    @Override
    public void destroy() {

    }
}
