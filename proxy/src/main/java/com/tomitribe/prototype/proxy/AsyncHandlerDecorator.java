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

import io.netty.channel.Channel;
import org.asynchttpclient.AsyncHandler;
import org.asynchttpclient.HttpResponseBodyPart;
import org.asynchttpclient.HttpResponseHeaders;
import org.asynchttpclient.HttpResponseStatus;
import org.asynchttpclient.handler.AsyncHandlerExtensions;
import org.asynchttpclient.netty.request.NettyRequest;

import java.net.InetSocketAddress;
import java.util.List;

public class AsyncHandlerDecorator<T> implements AsyncHandler<T>, AsyncHandlerExtensions {

    private final AsyncHandler<T> handler;
    private final AsyncHandlerExtensions extensions;

    public AsyncHandlerDecorator(AsyncHandler<T> handler) {
        this.handler = handler;
        this.extensions = (handler instanceof AsyncHandlerExtensions) ? (AsyncHandlerExtensions) handler : new NullAsyncHandlerExtensions();
    }

    @Override
    public void onThrowable(Throwable throwable) {
        handler.onThrowable(throwable);
    }

    @Override
    public State onBodyPartReceived(HttpResponseBodyPart httpResponseBodyPart) throws Exception {
        return handler.onBodyPartReceived(httpResponseBodyPart);
    }

    @Override
    public State onStatusReceived(HttpResponseStatus httpResponseStatus) throws Exception {
        return handler.onStatusReceived(httpResponseStatus);
    }

    @Override
    public State onHeadersReceived(HttpResponseHeaders httpResponseHeaders) throws Exception {
        return handler.onHeadersReceived(httpResponseHeaders);
    }

    @Override
    public T onCompleted() throws Exception {
        return handler.onCompleted();
    }

    @Override
    public void onHostnameResolutionAttempt(String s) {
        extensions.onHostnameResolutionAttempt(s);
    }

    @Override
    public void onHostnameResolutionSuccess(String s, List<InetSocketAddress> list) {
        extensions.onHostnameResolutionSuccess(s, list);
    }

    @Override
    public void onHostnameResolutionFailure(String s, Throwable throwable) {
        extensions.onHostnameResolutionFailure(s, throwable);
    }

    @Override
    public void onTcpConnectAttempt(InetSocketAddress inetSocketAddress) {
        extensions.onTcpConnectAttempt(inetSocketAddress);
    }

    @Override
    public void onTcpConnectSuccess(InetSocketAddress inetSocketAddress, Channel channel) {
        extensions.onTcpConnectSuccess(inetSocketAddress, channel);
    }

    @Override
    public void onTcpConnectFailure(InetSocketAddress inetSocketAddress, Throwable throwable) {
        extensions.onTcpConnectFailure(inetSocketAddress, throwable);
    }

    @Override
    public void onTlsHandshakeAttempt() {
        extensions.onTlsHandshakeAttempt();
    }

    @Override
    public void onTlsHandshakeSuccess() {
        extensions.onTlsHandshakeSuccess();
    }

    @Override
    public void onTlsHandshakeFailure(Throwable throwable) {
        extensions.onTlsHandshakeFailure(throwable);
    }

    @Override
    public void onConnectionPoolAttempt() {
        extensions.onConnectionPoolAttempt();
    }

    @Override
    public void onConnectionPooled(Channel channel) {
        extensions.onConnectionPooled(channel);
    }

    @Override
    public void onConnectionOffer(Channel channel) {
        extensions.onConnectionOffer(channel);
    }

    @Override
    public void onRequestSend(NettyRequest nettyRequest) {
        extensions.onRequestSend(nettyRequest);
    }

    @Override
    public void onRetry() {
        extensions.onRetry();
    }

    private static final class NullAsyncHandlerExtensions implements AsyncHandlerExtensions {
        @Override
        public void onHostnameResolutionAttempt(String s) {

        }

        @Override
        public void onHostnameResolutionSuccess(String s, List<InetSocketAddress> list) {

        }

        @Override
        public void onHostnameResolutionFailure(String s, Throwable throwable) {

        }

        @Override
        public void onTcpConnectAttempt(InetSocketAddress inetSocketAddress) {

        }

        @Override
        public void onTcpConnectSuccess(InetSocketAddress inetSocketAddress, Channel channel) {

        }

        @Override
        public void onTcpConnectFailure(InetSocketAddress inetSocketAddress, Throwable throwable) {

        }

        @Override
        public void onTlsHandshakeAttempt() {

        }

        @Override
        public void onTlsHandshakeSuccess() {

        }

        @Override
        public void onTlsHandshakeFailure(Throwable throwable) {

        }

        @Override
        public void onConnectionPoolAttempt() {

        }

        @Override
        public void onConnectionPooled(Channel channel) {

        }

        @Override
        public void onConnectionOffer(Channel channel) {

        }

        @Override
        public void onRequestSend(NettyRequest nettyRequest) {

        }

        @Override
        public void onRetry() {

        }
    }
}
