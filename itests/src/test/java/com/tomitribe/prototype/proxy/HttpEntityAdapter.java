package com.tomitribe.prototype.proxy;

import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.CloneUtils;
import org.apache.http.concurrent.Cancellable;
import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.conn.ConnectionReleaseTrigger;
import org.apache.http.params.HttpParams;

import java.net.URI;

public class HttpEntityAdapter extends HttpRequestBase implements HttpEntityEnclosingRequest {
    private HttpEntity entity;
    private final HttpRequestBase request;

    public HttpEntityAdapter(final HttpRequestBase request) {
        this.request = request;
    }

    public HttpEntity getEntity() {
        return this.entity;
    }

    public void setEntity(HttpEntity entity) {
        this.entity = entity;
    }

    public boolean expectContinue() {
        Header expect = this.getFirstHeader("Expect");
        return expect != null && "100-continue".equalsIgnoreCase(expect.getValue());
    }

    @Override
    public String getMethod() {
        return request.getMethod();
    }

    @Override
    public void setProtocolVersion(final ProtocolVersion version) {
        request.setProtocolVersion(version);
    }

    @Override
    public ProtocolVersion getProtocolVersion() {
        return request.getProtocolVersion();
    }

    @Override
    public URI getURI() {
        return request.getURI();
    }

    @Override
    public RequestLine getRequestLine() {
        return request.getRequestLine();
    }

    @Override
    public RequestConfig getConfig() {
        return request.getConfig();
    }

    @Override
    public void setConfig(final RequestConfig config) {
        request.setConfig(config);
    }

    @Override
    public void setURI(final URI uri) {
        request.setURI(uri);
    }

    @Override
    public void started() {
        request.started();
    }

    @Override
    public void releaseConnection() {
        request.releaseConnection();
    }

    @Override
    public String toString() {
        return request.toString();
    }

    @Override
    @Deprecated
    public void setConnectionRequest(final ClientConnectionRequest connRequest) {
        request.setConnectionRequest(connRequest);
    }

    @Override
    @Deprecated
    public void setReleaseTrigger(final ConnectionReleaseTrigger releaseTrigger) {
        request.setReleaseTrigger(releaseTrigger);
    }

    @Override
    public void abort() {
        request.abort();
    }

    @Override
    public boolean isAborted() {
        return request.isAborted();
    }

    @Override
    public void setCancellable(final Cancellable cancellable) {
        request.setCancellable(cancellable);
    }

    public Object clone() throws CloneNotSupportedException {
        HttpEntityAdapter clone = (HttpEntityAdapter) super.clone();
        if (this.entity != null) {
            clone.entity = (HttpEntity) CloneUtils.cloneObject(this.entity);
        }

        return clone;
    }

    @Override
    public void completed() {
        request.completed();
    }

    @Override
    public void reset() {
        request.reset();
    }

    @Override
    public boolean containsHeader(final String name) {
        return request.containsHeader(name);
    }

    @Override
    public Header[] getHeaders(final String name) {
        return request.getHeaders(name);
    }

    @Override
    public Header getFirstHeader(final String name) {
        return request.getFirstHeader(name);
    }

    @Override
    public Header getLastHeader(final String name) {
        return request.getLastHeader(name);
    }

    @Override
    public Header[] getAllHeaders() {
        return request.getAllHeaders();
    }

    @Override
    public void addHeader(final Header header) {
        request.addHeader(header);
    }

    @Override
    public void addHeader(final String name, final String value) {
        request.addHeader(name, value);
    }

    @Override
    public void setHeader(final Header header) {
        request.setHeader(header);
    }

    @Override
    public void setHeader(final String name, final String value) {
        request.setHeader(name, value);
    }

    @Override
    public void setHeaders(final Header[] headers) {
        request.setHeaders(headers);
    }

    @Override
    public void removeHeader(final Header header) {
        request.removeHeader(header);
    }

    @Override
    public void removeHeaders(final String name) {
        request.removeHeaders(name);
    }

    @Override
    public HeaderIterator headerIterator() {
        return request.headerIterator();
    }

    @Override
    public HeaderIterator headerIterator(final String name) {
        return request.headerIterator(name);
    }

    @Override
    @Deprecated
    public HttpParams getParams() {
        return request.getParams();
    }

    @Override
    @Deprecated
    public void setParams(final HttpParams params) {
        request.setParams(params);
    }
}
