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
import org.apache.openejb.loader.IO;
import org.asynchttpclient.AsyncHandler;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.BoundRequestBuilder;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClientConfig;
import org.asynchttpclient.HttpResponseBodyPart;
import org.asynchttpclient.HttpResponseStatus;
import org.asynchttpclient.Response;
import org.tomitribe.util.Duration;

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
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.ConnectException;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Collections.list;

/**
 * The parts of this code we should definitely keep are:
 *
 *  - Use of AsyncHttpClient AsyncHandler
 *  - Use of Servlet AsyncContext
 *
 */
@WebServlet(value = "/proxy/*", asyncSupported = true)
public class ProxyServlet extends HttpServlet {

    private final AsyncHttpClient asyncHttpClient;
    private final AtomicLong count = new AtomicLong(1000);

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
        log(request);


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

                list(request.getHeaderNames()).stream()
                        .filter(name -> name.equalsIgnoreCase("User-Agent"))
                        .filter(name -> name.equalsIgnoreCase("Host"))
                        .forEach(name -> {
                            System.out.printf("AddHeader{name='%s', value='%s'}%n", name, request.getHeader(name));
                            builder.addHeader(name, request.getHeader(name));
                        });
            }

            /**
             * After we have copied over the headers, we switch to async mode.
             *
             * The remainder of the execution will be done driven by the AsyncHttpClient
             * and this thread will terminate and return to the pool.
             *
             * This is a performance improvement we should attempt to copy over to
             * our Tribestream implementation.
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

            { // Copy incoming Requesty Body

                if (request.getContentLength() > 0) {
                    System.out.println("GetInputStream{}");
                    builder.setBody(async.getRequest().getInputStream());
                }
            }

            final Supplier<ServletOutputStream> out;
            { // Lazily get the ServletOutputStream when needed

                out = new Supplier<ServletOutputStream>() {
                    // thread-safe, just in case
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
                public State onHeadersReceived(final HttpHeaders headers) throws Exception {
                    System.out.println("AsyncHandler.onHeadersReceived");
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
            e.printStackTrace(System.out);
            throw new IOException(e);
        }
    }


    private void log(final HttpServletRequest request) throws FileNotFoundException {
        final File file = new File(String.format("/tmp/requests/request-%s-%s.log", trim(), count.incrementAndGet()));
        final PrintStream out = new PrintStream(IO.write(file));

        try {
            {
                final List<Method> methods = Stream.of(request.getClass().getMethods())
                        .filter(method -> method.getParameters().length == 0)
                        .filter(method -> method.getName().startsWith("get"))
                        .filter(method -> Modifier.isPublic(method.getModifiers()))
                        .filter(method -> !Modifier.isStatic(method.getModifiers()))
                        .filter(method -> !method.getName().equals("getInputStream"))
                        .filter(method -> !method.getName().equals("getReader"))
                        .filter(method -> !method.getName().equals("getLocales"))
                        .filter(method -> !method.getName().equals("getHeaderNames"))
                        .filter(method -> !method.getName().equals("getSession"))
                        .filter(method -> !method.getName().equals("getServletContext"))
                        .filter(method -> !method.getName().equals("getAttributeNames"))
                        .filter(method -> !method.getName().equals("getParameterNames"))
                        .filter(method -> !method.getName().equals("getParameterMap"))
                        .collect(Collectors.toList());

                for (final Method method : methods) {
                    try {
                        out.printf("%s : %s%n", method.getName(), method.invoke(request));
                    } catch (Exception e) {
                        throw new IllegalStateException(e);
                    }
                }
            }
            out.println("-headers--------------------------------------");
            for (final String name : list(request.getHeaderNames())) {
                out.printf("%s : %s%n", name, request.getHeader(name));
            }

            out.println("-parameters-----------------------------------");
            for (final String name : list(request.getParameterNames())) {
                out.printf("%s : %s%n", name, request.getParameter(name));
            }


            if (request.getCookies() != null) for (final Cookie cookie : request.getCookies()) {
                final List<Method> methods = Stream.of(cookie.getClass().getMethods())
                        .filter(method -> method.getParameters().length == 0)
                        .filter(method -> method.getName().startsWith("get"))
                        .filter(method -> Modifier.isPublic(method.getModifiers()))
                        .filter(method -> !Modifier.isStatic(method.getModifiers()))
                        .collect(Collectors.toList());
                for (final Method method : methods) {
                    try {
                        out.printf("%s : %s%n", method.getName(), method.invoke(request));
                    } catch (Exception e) {
                        throw new IllegalStateException(e);
                    }
                }
            }
        } finally {
            out.flush();
            out.close();
        }

    }

    private String trim() {
        final String now = System.currentTimeMillis() + "";
        return now.substring(5);
    }
}
