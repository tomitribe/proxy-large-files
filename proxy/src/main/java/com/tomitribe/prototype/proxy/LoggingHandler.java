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

import io.netty.handler.codec.http.HttpRequest;
import org.asynchttpclient.AsyncHandler;
import org.asynchttpclient.HttpResponseHeaders;
import org.asynchttpclient.HttpResponseStatus;
import org.asynchttpclient.netty.request.NettyRequest;

import java.io.PrintStream;
import java.util.Map;

public class LoggingHandler<T> extends AsyncHandlerDecorator<T> {

    private final PrintStream out;

    public LoggingHandler(final AsyncHandler<T> handler, final PrintStream out) {
        super(handler);
        this.out = out;
    }

    //--- Request Logging -------------------------------------------

    @Override
    public void onRequestSend(final NettyRequest request) {
        final HttpRequest httpRequest = request.getHttpRequest();
        out.print(httpRequest.getMethod());
        out.print(" ");
        out.print(httpRequest.getUri());
        out.print(" ");
        out.println(httpRequest.getProtocolVersion());

        for (final Map.Entry<String, String> entry : httpRequest.headers()) {
            out.print(entry.getKey());
            out.print(": ");
            out.println(entry.getValue());
        }
        out.println();
    }

    //--- Response Logging ------------------------------------------

    @Override
    public State onStatusReceived(final HttpResponseStatus httpResponseStatus) throws Exception {
        out.print(httpResponseStatus.getStatusCode());
        out.print(" ");
        out.println(httpResponseStatus.getStatusText());
        return super.onStatusReceived(httpResponseStatus);
    }

    @Override
    public State onHeadersReceived(final HttpResponseHeaders headers) throws Exception {
        for (final Map.Entry<String, String> entry : headers.getHeaders().entries()) {
            out.print(entry.getKey());
            out.print(": ");
            out.println(entry.getValue());
        }
        out.println();
        return super.onHeadersReceived(headers);
    }

    @Override
    public T onCompleted() throws Exception {
        out.flush();
        return super.onCompleted();
    }

    @Override
    public void onThrowable(Throwable throwable) {
        throwable.printStackTrace(out);
        super.onThrowable(throwable);
    }
}
