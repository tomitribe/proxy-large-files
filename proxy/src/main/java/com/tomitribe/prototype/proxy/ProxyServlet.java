/*
 * Tomitribe Confidential
 *
 * Copyright Tomitribe Corporation. 2017
 *
 * The source code for this program is not published or otherwise divested 
 * of its trade secrets, irrespective of what has been deposited with the 
 * U.S. Copyright Office.
 */
package com.tomitribe.prototype.proxy;

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
import org.tomitribe.util.Files;
import org.tomitribe.util.IO;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ConnectException;
import java.net.URI;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static java.util.Collections.list;

/**
 * To set the host without a recompile:
 *
 * curl -v "http://localhost:8080?host=http://director.downloads.raspberrypi.org"
 *
 * If you do this in a browser, it will set a cookie that can be used remember
 * which location you want to proxy for that browser session.
 */
@WebServlet(value = "/*", asyncSupported = true)
public class ProxyServlet extends HttpServlet {

    private final AsyncHttpClient asyncHttpClient;
    private final AtomicLong count = new AtomicLong(1000);
    private final AtomicReference<URI> lastHost = new AtomicReference<>(URI.create("http://localhost:7000/"));

    public ProxyServlet() {
        final DefaultAsyncHttpClientConfig.Builder config = new DefaultAsyncHttpClientConfig.Builder()
                .setRequestTimeout(t("1 hour"))
                .setReadTimeout(t("10 seconds"));

        asyncHttpClient = new DefaultAsyncHttpClient(config.build());
    }

    private int t(String expression) {
        return (int) new Duration(expression).getTime(TimeUnit.MILLISECONDS);
    }

    @Override
    protected void service(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {

        final PrintStream log = log(request);

        String host = lastHost.get().toString();

        if (request.getCookies() != null) {
            final Optional<Cookie> hostCookie = Stream.of(request.getCookies())
                    .filter(cookie -> cookie.getName().equals("host"))
                    .findFirst();

            if (hostCookie.isPresent()) {
                host = hostCookie.get().getValue();
            }
        }

        if (request.getParameter("host") != null) {
            host = request.getParameter("host");
            final Cookie cookie = new Cookie("host", host);
            response.addCookie(cookie);
            lastHost.set(URI.create(host));
        }

        try {

            final URI uri;
            { // Proxy all requests to localhost:7000 for this prototype

                final String requestURI = request.getRequestURI().replaceFirst(".*/proxy/?", "");
                System.out.printf("RequestUri{%s}%n", requestURI);
                uri = URI.create(host).resolve(requestURI);
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

                list(request.getHeaderNames()).stream()
                        .filter(name -> !name.equalsIgnoreCase("host"))
                        .filter(name -> !name.equalsIgnoreCase("referer"))
                        .forEach(name -> {
                            builder.addHeader(name, request.getHeader(name));
                        });
            }

            { // Copy all the query parameters

                list(request.getParameterNames()).stream()
                        .forEach(name -> {
                            System.out.printf("AddParameter{name='%s', value='%s'}%n", name, request.getHeader(name));
                            builder.addHeader(name, request.getParameter(name));
                        });
            }

            { // set the host

                builder.setHeader("Host", uri.getHost());
            }

            { // update the referer, if any

                final String referer = request.getHeader("referer");
                if (referer != null && referer.contains("localhost")) {
                    final String hostWithNoSlash = host.toString().replaceAll("/?$", "");
                    final String newReferer = referer.replace("http://localhost:8080", hostWithNoSlash);
                    builder.setHeader("referer", newReferer);
                }
            }

            /**
             * After we have copied over the headers, we switch to async mode.
             *
             * The remainder of the execution will be done driven by the AsyncHttpClient
             * and this thread will terminate and return to the pool.
             */
            System.out.println("StartAsync{}");
            final AsyncContext async = request.startAsync();

            /**
             * Tomcat will attempt to timeout async connections that do not show activity
             * for 10 seconds.  The result of this is an HTTP 500 Internal Server Error
             *
             * We opt to let the AsyncHttpClient exclusively handle the timeouts and set
             * Tomcat's timeout to effectively infinite.
             */
            async.setTimeout(Long.MAX_VALUE);

            /**
             * We must not set an InputStream on AsyncHttpClient or it will force a
             * `Transfer-Encoding: chunked` header into the request even if the input
             * stream has no contents.
             */
            if (hasBody(request)) {
                builder.setBody(async.getRequest().getInputStream());
            }

            System.out.println("Execute{}");

            /**
             * And away we go.  Hand-off the AsyncContext to AsyncHttpClient
             */

            builder.execute(new LoggingHandler(new ResponseAsyncHandler(async), log));

            /**
             * At this moment the request is happening inside AsyncHttpClient's
             * thread pool and this thread is free to return.  Reaching this line
             * does not mean the request is complete and that we know the outcome
             */

            System.out.println("ProxyServlet Completed");

        } catch (Exception e) {
            e.printStackTrace(System.out);
            throw new IOException(e);
        }
    }

    private boolean hasBody(final HttpServletRequest request) {
        if (request.getHeader("Content-Length") != null) return true;
        if (request.getHeader("Transfer-Encoding") != null) return true;
        return false;
    }

    private PrintStream log(final HttpServletRequest request) throws FileNotFoundException {
        final String uri = request.getRequestURI().replace('/', '.').replaceAll("^\\.$", "");
        final File file = new File(String.format("/tmp/requests/request-%s-%s%s.log", trim(), count.incrementAndGet(), uri));
        Files.mkdir(file.getParentFile());
        return new PrintStream(IO.write(file));
    }

    private String trim() {
        final String now = System.currentTimeMillis() + "";
        return now.substring(5);
    }

    private static class ServletOutputStreamSupplier implements Supplier<ServletOutputStream> {
        private final AsyncContext async;
        // thread-safe, just in case
        volatile ServletOutputStream outputStream;

        public ServletOutputStreamSupplier(AsyncContext async) {
            this.async = async;
        }

        @Override
        public ServletOutputStream get() {
            try {
                if (outputStream == null) {
                    System.out.println("OpenStream{}");
                    return outputStream = async.getResponse().getOutputStream();
//                                outputStream = new LoggingServletOutputStream(async.getResponse().getOutputStream(), log);
                }
                return outputStream;
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    private static class ResponseAsyncHandler implements AsyncHandler<Response> {
        private final AsyncContext async;
        private final Supplier<ServletOutputStream> out;

        public ResponseAsyncHandler(final AsyncContext async) {
            this.out = new ServletOutputStreamSupplier(async);
            this.async = async;
        }

        @Override
        public void onThrowable(Throwable throwable) {
            try {
                if (throwable instanceof ConnectException) {
                    // The server is not up and listening

                    try {
                        ((HttpServletResponse) async.getResponse()).sendError(503, "Service Unavailable");
                    } catch (IOException e) {
                        throw new IllegalStateException(e);
                    }

                } else if (throwable instanceof java.util.concurrent.TimeoutException) {
                    // The server is not up and listening
                    // The setRequestTimeout or setReadTimeout
                    try {
                        // This will not change the status code to 504 in situations where significant
                        // data has been written to the outputstream already.  In these situations, the
                        // response code and headers will be flushed so writing the body may start.
                        // After this point is no longer possible to change the status code.
                        ((HttpServletResponse) async.getResponse()).sendError(504, "Gateway Timeout");
                    } catch (IOException e) {
                        throw new IllegalStateException(e);
                    }
                } else {
                    throwable.printStackTrace(System.out);
                }
            } finally {
                async.complete();
            }

            System.out.printf("AsyncHandler.onThrowable %s %s%n", throwable.getClass().getName(), throwable.getMessage());
        }

        @Override
        public State onBodyPartReceived(HttpResponseBodyPart part) throws Exception {
//                    System.out.printf("AsyncHandler.onBodyPartReceived %s - %s%n", part.length(), part.isLast());
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
        public State onHeadersReceived(final HttpResponseHeaders headers) throws Exception {
            System.out.println("AsyncHandler.onHeadersReceived");
            for (final Map.Entry<String, String> entry : headers.getHeaders().entries()) {
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
    }
}
