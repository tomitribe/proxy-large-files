/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.tomitribe.tribestream.httpclient;

import io.netty.handler.codec.http.HttpHeaders;
import org.asynchttpclient.AsyncHandler;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.BoundRequestBuilder;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClientConfig;
import org.asynchttpclient.HttpResponseBodyPart;
import org.asynchttpclient.HttpResponseStatus;
import org.asynchttpclient.ListenableFuture;
import org.asynchttpclient.Response;
import org.junit.Test;
import org.tomitribe.util.Duration;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class GetTest {


    @Test
    public void test() throws Exception {
        final DefaultAsyncHttpClientConfig.Builder config = new DefaultAsyncHttpClientConfig.Builder()
                .setRequestTimeout(t("1 hour"))
                .setReadTimeout(t("10 seconds"));

        final AsyncHttpClient asyncHttpClient = new DefaultAsyncHttpClient(config.build());

        final BoundRequestBuilder get = asyncHttpClient.prepareGet("http://director.downloads.raspberrypi.org//raspbian/images/raspbian-2018-04-19/2018-04-18-raspbian-stretch.zip");

        final ListenableFuture<Response> execute = get.execute(new AsyncHandler<Response>() {
            @Override
            public State onStatusReceived(HttpResponseStatus responseStatus) throws Exception {
                System.out.print(responseStatus.getStatusCode());
                System.out.print(" ");
                System.out.println(responseStatus.getStatusText());
                return State.CONTINUE;
            }

            @Override
            public State onHeadersReceived(HttpHeaders headers) throws Exception {
                for (final Map.Entry<String, String> header : headers) {
                    System.out.print(header.getKey());
                    System.out.print(": ");
                    System.out.println(header.getValue());
                }
                return State.CONTINUE;
            }

            @Override
            public State onBodyPartReceived(HttpResponseBodyPart bodyPart) throws Exception {
                return State.CONTINUE;
            }

            @Override
            public void onThrowable(Throwable t) {

            }

            @Override
            public Response onCompleted() throws Exception {
                return null;
            }
        });

        execute.get();
    }


    private int t(String expression) {
        return (int) new Duration(expression).getTime(TimeUnit.MILLISECONDS);
    }
}
