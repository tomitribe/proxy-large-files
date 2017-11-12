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
import org.asynchttpclient.DefaultAsyncHttpClientConfig;
import org.asynchttpclient.HttpResponseBodyPart;
import org.asynchttpclient.HttpResponseHeaders;
import org.asynchttpclient.HttpResponseStatus;
import org.asynchttpclient.Response;
import org.tomitribe.util.Duration;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.ConnectException;
import java.net.URI;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

@WebServlet(value = "/proxy/*", asyncSupported = true)
public class ProxyServlet extends HttpServlet {

    private final AsyncHttpClient asyncHttpClient;

    public ProxyServlet() {
        final DefaultAsyncHttpClientConfig.Builder config = new DefaultAsyncHttpClientConfig.Builder()
                .setRequestTimeout(t("1 hour"))
                .setReadTimeout(t("10 seconds"))
                ;

        asyncHttpClient = new DefaultAsyncHttpClient(config.build());
    }

    private int t(String expression) {
        return (int) new Duration(expression).getTime(TimeUnit.MILLISECONDS);
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            final URI uri;
            { // Proxy all requests to localhost:7000 for this prototype

                final String requestURI = request.getRequestURI().replaceFirst(".*/proxy/", "");
                System.out.printf("RequestUri{%s}%n", requestURI);
                uri = URI.create("http://localhost:7000/").resolve(requestURI);
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

            System.out.println("StartAsync{}");
            final AsyncContext async = request.startAsync();
            // The timeouts of AsyncHttpClient are reliable and should win
            async.setTimeout(Long.MAX_VALUE);
            System.out.println("StartAsync{} - Post");

            { // Copy incoming Requesty Body

                if (request.getContentLength() > 0) {
                    System.out.println("GetInputStream{}");
                    builder.setBody(async.getRequest().getInputStream());
                }
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
                                outputStream = async.getResponse().getOutputStream();
                            }
                            return outputStream;
                        } catch (IOException e) {
                            throw new IllegalStateException(e);
                        }
                    }
                };
            }


            System.out.println("Execute{}");
            // And away we go
            builder.execute(new AsyncHandler<Response>() {
                @Override
                public void onThrowable(Throwable throwable) {
                    System.out.printf("AsyncHandler.onThrowable %s %s%n", throwable.getClass().getName(), throwable.getMessage());

                    if (throwable instanceof ConnectException) {
                        // The server is not up and listening

                        try {
                            ((HttpServletResponse) async.getResponse()).sendError(503, "Service Unavailable");
                        } catch (IOException e) {
                            throw new IllegalStateException(e);
                        } finally {
                            async.complete();
                        }

                    } else if (throwable instanceof java.util.concurrent.TimeoutException) {
                        // The server is not up and listening

                        try {
                            ((HttpServletResponse) async.getResponse()).sendError(504, "Gateway Timeout");
                        } catch (IOException e) {
                            throw new IllegalStateException(e);
                        } finally {
                            async.complete();
                        }
                    } else {
                        throwable.printStackTrace(System.out);
                    }
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
                    ((HttpServletResponse) async.getResponse()).setStatus(status.getStatusCode(), status.getStatusText());
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
                        ((HttpServletResponse) async.getResponse()).setHeader(key, value);
                    }
                    return State.CONTINUE;
                }

                @Override
                public Response onCompleted() throws Exception {
                    out.get().flush();
                    out.get().close();
                    System.out.println("AsyncHandler.onCompleted!");
                    async.complete();
                    return null;
                }
            });

            System.out.println("ProxyServlet Completed");
        } catch (Exception e) {
            throw new IOException(e);
        }
    }
}
