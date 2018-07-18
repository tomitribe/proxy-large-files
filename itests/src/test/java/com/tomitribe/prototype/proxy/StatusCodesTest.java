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

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import org.junit.Test;

import java.net.URI;
import java.util.function.Function;

import static com.tomitribe.prototype.proxy.Methods.DELETE;
import static com.tomitribe.prototype.proxy.Methods.GET;
import static com.tomitribe.prototype.proxy.Methods.HEAD;
import static com.tomitribe.prototype.proxy.Methods.OPTIONS;
import static com.tomitribe.prototype.proxy.Methods.POST;
import static com.tomitribe.prototype.proxy.Methods.PUT;

/**
 * Here we verify that our client can recieve any kind of
 * HTTP status code from our service
 */
public class StatusCodesTest {

    private final Proxy.Location proxy = Proxy.location();

    public void assertCode(final int code, final Function<URI, ? extends HttpRequestBase> method) throws java.io.IOException {
        final CloseableHttpResponse response = proxy.request(method)
                .header("code", code)
                .path("code", code)
                .execute();

        Assert.that(response)
                .header("code", code)
                .statusCode(code)
                .close();
    }

    @Test
    public void test200_GET() throws Exception {
        assertCode(200, GET);
    }
    @Test
    public void test200_POST() throws Exception {
        assertCode(200, POST);
    }
    @Test
    public void test200_PUT() throws Exception {
        assertCode(200, PUT);
    }
    @Test
    public void test200_DELETE() throws Exception {
        assertCode(200, DELETE);
    }
    @Test
    public void test200_OPTIONS() throws Exception {
        assertCode(200, OPTIONS);
    }
    @Test
    public void test200_HEAD() throws Exception {
        assertCode(200, HEAD);
    }
    @Test
    public void test201_GET() throws Exception {
        assertCode(201, GET);
    }
    @Test
    public void test201_POST() throws Exception {
        assertCode(201, POST);
    }
    @Test
    public void test201_PUT() throws Exception {
        assertCode(201, PUT);
    }
    @Test
    public void test201_DELETE() throws Exception {
        assertCode(201, DELETE);
    }
    @Test
    public void test201_OPTIONS() throws Exception {
        assertCode(201, OPTIONS);
    }
    @Test
    public void test201_HEAD() throws Exception {
        assertCode(201, HEAD);
    }
    @Test
    public void test202_GET() throws Exception {
        assertCode(202, GET);
    }
    @Test
    public void test202_POST() throws Exception {
        assertCode(202, POST);
    }
    @Test
    public void test202_PUT() throws Exception {
        assertCode(202, PUT);
    }
    @Test
    public void test202_DELETE() throws Exception {
        assertCode(202, DELETE);
    }
    @Test
    public void test202_OPTIONS() throws Exception {
        assertCode(202, OPTIONS);
    }
    @Test
    public void test202_HEAD() throws Exception {
        assertCode(202, HEAD);
    }
    @Test
    public void test203_GET() throws Exception {
        assertCode(203, GET);
    }
    @Test
    public void test203_POST() throws Exception {
        assertCode(203, POST);
    }
    @Test
    public void test203_PUT() throws Exception {
        assertCode(203, PUT);
    }
    @Test
    public void test203_DELETE() throws Exception {
        assertCode(203, DELETE);
    }
    @Test
    public void test203_OPTIONS() throws Exception {
        assertCode(203, OPTIONS);
    }
    @Test
    public void test203_HEAD() throws Exception {
        assertCode(203, HEAD);
    }
    @Test
    public void test204_GET() throws Exception {
        assertCode(204, GET);
    }
    @Test
    public void test204_POST() throws Exception {
        assertCode(204, POST);
    }
    @Test
    public void test204_PUT() throws Exception {
        assertCode(204, PUT);
    }
    @Test
    public void test204_DELETE() throws Exception {
        assertCode(204, DELETE);
    }
    @Test
    public void test204_OPTIONS() throws Exception {
        assertCode(204, OPTIONS);
    }
    @Test
    public void test204_HEAD() throws Exception {
        assertCode(204, HEAD);
    }
    @Test
    public void test205_GET() throws Exception {
        assertCode(205, GET);
    }
    @Test
    public void test205_POST() throws Exception {
        assertCode(205, POST);
    }
    @Test
    public void test205_PUT() throws Exception {
        assertCode(205, PUT);
    }
    @Test
    public void test205_DELETE() throws Exception {
        assertCode(205, DELETE);
    }
    @Test
    public void test205_OPTIONS() throws Exception {
        assertCode(205, OPTIONS);
    }
    @Test
    public void test205_HEAD() throws Exception {
        assertCode(205, HEAD);
    }
    @Test
    public void test206_GET() throws Exception {
        assertCode(206, GET);
    }
    @Test
    public void test206_POST() throws Exception {
        assertCode(206, POST);
    }
    @Test
    public void test206_PUT() throws Exception {
        assertCode(206, PUT);
    }
    @Test
    public void test206_DELETE() throws Exception {
        assertCode(206, DELETE);
    }
    @Test
    public void test206_OPTIONS() throws Exception {
        assertCode(206, OPTIONS);
    }
    @Test
    public void test206_HEAD() throws Exception {
        assertCode(206, HEAD);
    }
    @Test
    public void test207_GET() throws Exception {
        assertCode(207, GET);
    }
    @Test
    public void test207_POST() throws Exception {
        assertCode(207, POST);
    }
    @Test
    public void test207_PUT() throws Exception {
        assertCode(207, PUT);
    }
    @Test
    public void test207_DELETE() throws Exception {
        assertCode(207, DELETE);
    }
    @Test
    public void test207_OPTIONS() throws Exception {
        assertCode(207, OPTIONS);
    }
    @Test
    public void test207_HEAD() throws Exception {
        assertCode(207, HEAD);
    }
    @Test
    public void test208_GET() throws Exception {
        assertCode(208, GET);
    }
    @Test
    public void test208_POST() throws Exception {
        assertCode(208, POST);
    }
    @Test
    public void test208_PUT() throws Exception {
        assertCode(208, PUT);
    }
    @Test
    public void test208_DELETE() throws Exception {
        assertCode(208, DELETE);
    }
    @Test
    public void test208_OPTIONS() throws Exception {
        assertCode(208, OPTIONS);
    }
    @Test
    public void test208_HEAD() throws Exception {
        assertCode(208, HEAD);
    }
    @Test
    public void test209_GET() throws Exception {
        assertCode(209, GET);
    }
    @Test
    public void test209_POST() throws Exception {
        assertCode(209, POST);
    }
    @Test
    public void test209_PUT() throws Exception {
        assertCode(209, PUT);
    }
    @Test
    public void test209_DELETE() throws Exception {
        assertCode(209, DELETE);
    }
    @Test
    public void test209_OPTIONS() throws Exception {
        assertCode(209, OPTIONS);
    }
    @Test
    public void test209_HEAD() throws Exception {
        assertCode(209, HEAD);
    }
    @Test
    public void test210_GET() throws Exception {
        assertCode(210, GET);
    }
    @Test
    public void test210_POST() throws Exception {
        assertCode(210, POST);
    }
    @Test
    public void test210_PUT() throws Exception {
        assertCode(210, PUT);
    }
    @Test
    public void test210_DELETE() throws Exception {
        assertCode(210, DELETE);
    }
    @Test
    public void test210_OPTIONS() throws Exception {
        assertCode(210, OPTIONS);
    }
    @Test
    public void test210_HEAD() throws Exception {
        assertCode(210, HEAD);
    }
    @Test
    public void test211_GET() throws Exception {
        assertCode(211, GET);
    }
    @Test
    public void test211_POST() throws Exception {
        assertCode(211, POST);
    }
    @Test
    public void test211_PUT() throws Exception {
        assertCode(211, PUT);
    }
    @Test
    public void test211_DELETE() throws Exception {
        assertCode(211, DELETE);
    }
    @Test
    public void test211_OPTIONS() throws Exception {
        assertCode(211, OPTIONS);
    }
    @Test
    public void test211_HEAD() throws Exception {
        assertCode(211, HEAD);
    }
    @Test
    public void test212_GET() throws Exception {
        assertCode(212, GET);
    }
    @Test
    public void test212_POST() throws Exception {
        assertCode(212, POST);
    }
    @Test
    public void test212_PUT() throws Exception {
        assertCode(212, PUT);
    }
    @Test
    public void test212_DELETE() throws Exception {
        assertCode(212, DELETE);
    }
    @Test
    public void test212_OPTIONS() throws Exception {
        assertCode(212, OPTIONS);
    }
    @Test
    public void test212_HEAD() throws Exception {
        assertCode(212, HEAD);
    }
    @Test
    public void test213_GET() throws Exception {
        assertCode(213, GET);
    }
    @Test
    public void test213_POST() throws Exception {
        assertCode(213, POST);
    }
    @Test
    public void test213_PUT() throws Exception {
        assertCode(213, PUT);
    }
    @Test
    public void test213_DELETE() throws Exception {
        assertCode(213, DELETE);
    }
    @Test
    public void test213_OPTIONS() throws Exception {
        assertCode(213, OPTIONS);
    }
    @Test
    public void test213_HEAD() throws Exception {
        assertCode(213, HEAD);
    }
    @Test
    public void test214_GET() throws Exception {
        assertCode(214, GET);
    }
    @Test
    public void test214_POST() throws Exception {
        assertCode(214, POST);
    }
    @Test
    public void test214_PUT() throws Exception {
        assertCode(214, PUT);
    }
    @Test
    public void test214_DELETE() throws Exception {
        assertCode(214, DELETE);
    }
    @Test
    public void test214_OPTIONS() throws Exception {
        assertCode(214, OPTIONS);
    }
    @Test
    public void test214_HEAD() throws Exception {
        assertCode(214, HEAD);
    }
    @Test
    public void test215_GET() throws Exception {
        assertCode(215, GET);
    }
    @Test
    public void test215_POST() throws Exception {
        assertCode(215, POST);
    }
    @Test
    public void test215_PUT() throws Exception {
        assertCode(215, PUT);
    }
    @Test
    public void test215_DELETE() throws Exception {
        assertCode(215, DELETE);
    }
    @Test
    public void test215_OPTIONS() throws Exception {
        assertCode(215, OPTIONS);
    }
    @Test
    public void test215_HEAD() throws Exception {
        assertCode(215, HEAD);
    }
    @Test
    public void test216_GET() throws Exception {
        assertCode(216, GET);
    }
    @Test
    public void test216_POST() throws Exception {
        assertCode(216, POST);
    }
    @Test
    public void test216_PUT() throws Exception {
        assertCode(216, PUT);
    }
    @Test
    public void test216_DELETE() throws Exception {
        assertCode(216, DELETE);
    }
    @Test
    public void test216_OPTIONS() throws Exception {
        assertCode(216, OPTIONS);
    }
    @Test
    public void test216_HEAD() throws Exception {
        assertCode(216, HEAD);
    }
    @Test
    public void test217_GET() throws Exception {
        assertCode(217, GET);
    }
    @Test
    public void test217_POST() throws Exception {
        assertCode(217, POST);
    }
    @Test
    public void test217_PUT() throws Exception {
        assertCode(217, PUT);
    }
    @Test
    public void test217_DELETE() throws Exception {
        assertCode(217, DELETE);
    }
    @Test
    public void test217_OPTIONS() throws Exception {
        assertCode(217, OPTIONS);
    }
    @Test
    public void test217_HEAD() throws Exception {
        assertCode(217, HEAD);
    }
    @Test
    public void test218_GET() throws Exception {
        assertCode(218, GET);
    }
    @Test
    public void test218_POST() throws Exception {
        assertCode(218, POST);
    }
    @Test
    public void test218_PUT() throws Exception {
        assertCode(218, PUT);
    }
    @Test
    public void test218_DELETE() throws Exception {
        assertCode(218, DELETE);
    }
    @Test
    public void test218_OPTIONS() throws Exception {
        assertCode(218, OPTIONS);
    }
    @Test
    public void test218_HEAD() throws Exception {
        assertCode(218, HEAD);
    }
    @Test
    public void test219_GET() throws Exception {
        assertCode(219, GET);
    }
    @Test
    public void test219_POST() throws Exception {
        assertCode(219, POST);
    }
    @Test
    public void test219_PUT() throws Exception {
        assertCode(219, PUT);
    }
    @Test
    public void test219_DELETE() throws Exception {
        assertCode(219, DELETE);
    }
    @Test
    public void test219_OPTIONS() throws Exception {
        assertCode(219, OPTIONS);
    }
    @Test
    public void test219_HEAD() throws Exception {
        assertCode(219, HEAD);
    }
    @Test
    public void test220_GET() throws Exception {
        assertCode(220, GET);
    }
    @Test
    public void test220_POST() throws Exception {
        assertCode(220, POST);
    }
    @Test
    public void test220_PUT() throws Exception {
        assertCode(220, PUT);
    }
    @Test
    public void test220_DELETE() throws Exception {
        assertCode(220, DELETE);
    }
    @Test
    public void test220_OPTIONS() throws Exception {
        assertCode(220, OPTIONS);
    }
    @Test
    public void test220_HEAD() throws Exception {
        assertCode(220, HEAD);
    }
    @Test
    public void test221_GET() throws Exception {
        assertCode(221, GET);
    }
    @Test
    public void test221_POST() throws Exception {
        assertCode(221, POST);
    }
    @Test
    public void test221_PUT() throws Exception {
        assertCode(221, PUT);
    }
    @Test
    public void test221_DELETE() throws Exception {
        assertCode(221, DELETE);
    }
    @Test
    public void test221_OPTIONS() throws Exception {
        assertCode(221, OPTIONS);
    }
    @Test
    public void test221_HEAD() throws Exception {
        assertCode(221, HEAD);
    }
    @Test
    public void test222_GET() throws Exception {
        assertCode(222, GET);
    }
    @Test
    public void test222_POST() throws Exception {
        assertCode(222, POST);
    }
    @Test
    public void test222_PUT() throws Exception {
        assertCode(222, PUT);
    }
    @Test
    public void test222_DELETE() throws Exception {
        assertCode(222, DELETE);
    }
    @Test
    public void test222_OPTIONS() throws Exception {
        assertCode(222, OPTIONS);
    }
    @Test
    public void test222_HEAD() throws Exception {
        assertCode(222, HEAD);
    }
    @Test
    public void test223_GET() throws Exception {
        assertCode(223, GET);
    }
    @Test
    public void test223_POST() throws Exception {
        assertCode(223, POST);
    }
    @Test
    public void test223_PUT() throws Exception {
        assertCode(223, PUT);
    }
    @Test
    public void test223_DELETE() throws Exception {
        assertCode(223, DELETE);
    }
    @Test
    public void test223_OPTIONS() throws Exception {
        assertCode(223, OPTIONS);
    }
    @Test
    public void test223_HEAD() throws Exception {
        assertCode(223, HEAD);
    }
    @Test
    public void test224_GET() throws Exception {
        assertCode(224, GET);
    }
    @Test
    public void test224_POST() throws Exception {
        assertCode(224, POST);
    }
    @Test
    public void test224_PUT() throws Exception {
        assertCode(224, PUT);
    }
    @Test
    public void test224_DELETE() throws Exception {
        assertCode(224, DELETE);
    }
    @Test
    public void test224_OPTIONS() throws Exception {
        assertCode(224, OPTIONS);
    }
    @Test
    public void test224_HEAD() throws Exception {
        assertCode(224, HEAD);
    }
    @Test
    public void test225_GET() throws Exception {
        assertCode(225, GET);
    }
    @Test
    public void test225_POST() throws Exception {
        assertCode(225, POST);
    }
    @Test
    public void test225_PUT() throws Exception {
        assertCode(225, PUT);
    }
    @Test
    public void test225_DELETE() throws Exception {
        assertCode(225, DELETE);
    }
    @Test
    public void test225_OPTIONS() throws Exception {
        assertCode(225, OPTIONS);
    }
    @Test
    public void test225_HEAD() throws Exception {
        assertCode(225, HEAD);
    }
    @Test
    public void test226_GET() throws Exception {
        assertCode(226, GET);
    }
    @Test
    public void test226_POST() throws Exception {
        assertCode(226, POST);
    }
    @Test
    public void test226_PUT() throws Exception {
        assertCode(226, PUT);
    }
    @Test
    public void test226_DELETE() throws Exception {
        assertCode(226, DELETE);
    }
    @Test
    public void test226_OPTIONS() throws Exception {
        assertCode(226, OPTIONS);
    }
    @Test
    public void test226_HEAD() throws Exception {
        assertCode(226, HEAD);
    }
    @Test
    public void test227_GET() throws Exception {
        assertCode(227, GET);
    }
    @Test
    public void test227_POST() throws Exception {
        assertCode(227, POST);
    }
    @Test
    public void test227_PUT() throws Exception {
        assertCode(227, PUT);
    }
    @Test
    public void test227_DELETE() throws Exception {
        assertCode(227, DELETE);
    }
    @Test
    public void test227_OPTIONS() throws Exception {
        assertCode(227, OPTIONS);
    }
    @Test
    public void test227_HEAD() throws Exception {
        assertCode(227, HEAD);
    }
    @Test
    public void test228_GET() throws Exception {
        assertCode(228, GET);
    }
    @Test
    public void test228_POST() throws Exception {
        assertCode(228, POST);
    }
    @Test
    public void test228_PUT() throws Exception {
        assertCode(228, PUT);
    }
    @Test
    public void test228_DELETE() throws Exception {
        assertCode(228, DELETE);
    }
    @Test
    public void test228_OPTIONS() throws Exception {
        assertCode(228, OPTIONS);
    }
    @Test
    public void test228_HEAD() throws Exception {
        assertCode(228, HEAD);
    }
    @Test
    public void test229_GET() throws Exception {
        assertCode(229, GET);
    }
    @Test
    public void test229_POST() throws Exception {
        assertCode(229, POST);
    }
    @Test
    public void test229_PUT() throws Exception {
        assertCode(229, PUT);
    }
    @Test
    public void test229_DELETE() throws Exception {
        assertCode(229, DELETE);
    }
    @Test
    public void test229_OPTIONS() throws Exception {
        assertCode(229, OPTIONS);
    }
    @Test
    public void test229_HEAD() throws Exception {
        assertCode(229, HEAD);
    }
    @Test
    public void test230_GET() throws Exception {
        assertCode(230, GET);
    }
    @Test
    public void test230_POST() throws Exception {
        assertCode(230, POST);
    }
    @Test
    public void test230_PUT() throws Exception {
        assertCode(230, PUT);
    }
    @Test
    public void test230_DELETE() throws Exception {
        assertCode(230, DELETE);
    }
    @Test
    public void test230_OPTIONS() throws Exception {
        assertCode(230, OPTIONS);
    }
    @Test
    public void test230_HEAD() throws Exception {
        assertCode(230, HEAD);
    }
    @Test
    public void test231_GET() throws Exception {
        assertCode(231, GET);
    }
    @Test
    public void test231_POST() throws Exception {
        assertCode(231, POST);
    }
    @Test
    public void test231_PUT() throws Exception {
        assertCode(231, PUT);
    }
    @Test
    public void test231_DELETE() throws Exception {
        assertCode(231, DELETE);
    }
    @Test
    public void test231_OPTIONS() throws Exception {
        assertCode(231, OPTIONS);
    }
    @Test
    public void test231_HEAD() throws Exception {
        assertCode(231, HEAD);
    }
    @Test
    public void test232_GET() throws Exception {
        assertCode(232, GET);
    }
    @Test
    public void test232_POST() throws Exception {
        assertCode(232, POST);
    }
    @Test
    public void test232_PUT() throws Exception {
        assertCode(232, PUT);
    }
    @Test
    public void test232_DELETE() throws Exception {
        assertCode(232, DELETE);
    }
    @Test
    public void test232_OPTIONS() throws Exception {
        assertCode(232, OPTIONS);
    }
    @Test
    public void test232_HEAD() throws Exception {
        assertCode(232, HEAD);
    }
    @Test
    public void test233_GET() throws Exception {
        assertCode(233, GET);
    }
    @Test
    public void test233_POST() throws Exception {
        assertCode(233, POST);
    }
    @Test
    public void test233_PUT() throws Exception {
        assertCode(233, PUT);
    }
    @Test
    public void test233_DELETE() throws Exception {
        assertCode(233, DELETE);
    }
    @Test
    public void test233_OPTIONS() throws Exception {
        assertCode(233, OPTIONS);
    }
    @Test
    public void test233_HEAD() throws Exception {
        assertCode(233, HEAD);
    }
    @Test
    public void test234_GET() throws Exception {
        assertCode(234, GET);
    }
    @Test
    public void test234_POST() throws Exception {
        assertCode(234, POST);
    }
    @Test
    public void test234_PUT() throws Exception {
        assertCode(234, PUT);
    }
    @Test
    public void test234_DELETE() throws Exception {
        assertCode(234, DELETE);
    }
    @Test
    public void test234_OPTIONS() throws Exception {
        assertCode(234, OPTIONS);
    }
    @Test
    public void test234_HEAD() throws Exception {
        assertCode(234, HEAD);
    }
    @Test
    public void test235_GET() throws Exception {
        assertCode(235, GET);
    }
    @Test
    public void test235_POST() throws Exception {
        assertCode(235, POST);
    }
    @Test
    public void test235_PUT() throws Exception {
        assertCode(235, PUT);
    }
    @Test
    public void test235_DELETE() throws Exception {
        assertCode(235, DELETE);
    }
    @Test
    public void test235_OPTIONS() throws Exception {
        assertCode(235, OPTIONS);
    }
    @Test
    public void test235_HEAD() throws Exception {
        assertCode(235, HEAD);
    }
    @Test
    public void test236_GET() throws Exception {
        assertCode(236, GET);
    }
    @Test
    public void test236_POST() throws Exception {
        assertCode(236, POST);
    }
    @Test
    public void test236_PUT() throws Exception {
        assertCode(236, PUT);
    }
    @Test
    public void test236_DELETE() throws Exception {
        assertCode(236, DELETE);
    }
    @Test
    public void test236_OPTIONS() throws Exception {
        assertCode(236, OPTIONS);
    }
    @Test
    public void test236_HEAD() throws Exception {
        assertCode(236, HEAD);
    }
    @Test
    public void test237_GET() throws Exception {
        assertCode(237, GET);
    }
    @Test
    public void test237_POST() throws Exception {
        assertCode(237, POST);
    }
    @Test
    public void test237_PUT() throws Exception {
        assertCode(237, PUT);
    }
    @Test
    public void test237_DELETE() throws Exception {
        assertCode(237, DELETE);
    }
    @Test
    public void test237_OPTIONS() throws Exception {
        assertCode(237, OPTIONS);
    }
    @Test
    public void test237_HEAD() throws Exception {
        assertCode(237, HEAD);
    }
    @Test
    public void test238_GET() throws Exception {
        assertCode(238, GET);
    }
    @Test
    public void test238_POST() throws Exception {
        assertCode(238, POST);
    }
    @Test
    public void test238_PUT() throws Exception {
        assertCode(238, PUT);
    }
    @Test
    public void test238_DELETE() throws Exception {
        assertCode(238, DELETE);
    }
    @Test
    public void test238_OPTIONS() throws Exception {
        assertCode(238, OPTIONS);
    }
    @Test
    public void test238_HEAD() throws Exception {
        assertCode(238, HEAD);
    }
    @Test
    public void test239_GET() throws Exception {
        assertCode(239, GET);
    }
    @Test
    public void test239_POST() throws Exception {
        assertCode(239, POST);
    }
    @Test
    public void test239_PUT() throws Exception {
        assertCode(239, PUT);
    }
    @Test
    public void test239_DELETE() throws Exception {
        assertCode(239, DELETE);
    }
    @Test
    public void test239_OPTIONS() throws Exception {
        assertCode(239, OPTIONS);
    }
    @Test
    public void test239_HEAD() throws Exception {
        assertCode(239, HEAD);
    }
    @Test
    public void test240_GET() throws Exception {
        assertCode(240, GET);
    }
    @Test
    public void test240_POST() throws Exception {
        assertCode(240, POST);
    }
    @Test
    public void test240_PUT() throws Exception {
        assertCode(240, PUT);
    }
    @Test
    public void test240_DELETE() throws Exception {
        assertCode(240, DELETE);
    }
    @Test
    public void test240_OPTIONS() throws Exception {
        assertCode(240, OPTIONS);
    }
    @Test
    public void test240_HEAD() throws Exception {
        assertCode(240, HEAD);
    }
    @Test
    public void test241_GET() throws Exception {
        assertCode(241, GET);
    }
    @Test
    public void test241_POST() throws Exception {
        assertCode(241, POST);
    }
    @Test
    public void test241_PUT() throws Exception {
        assertCode(241, PUT);
    }
    @Test
    public void test241_DELETE() throws Exception {
        assertCode(241, DELETE);
    }
    @Test
    public void test241_OPTIONS() throws Exception {
        assertCode(241, OPTIONS);
    }
    @Test
    public void test241_HEAD() throws Exception {
        assertCode(241, HEAD);
    }
    @Test
    public void test242_GET() throws Exception {
        assertCode(242, GET);
    }
    @Test
    public void test242_POST() throws Exception {
        assertCode(242, POST);
    }
    @Test
    public void test242_PUT() throws Exception {
        assertCode(242, PUT);
    }
    @Test
    public void test242_DELETE() throws Exception {
        assertCode(242, DELETE);
    }
    @Test
    public void test242_OPTIONS() throws Exception {
        assertCode(242, OPTIONS);
    }
    @Test
    public void test242_HEAD() throws Exception {
        assertCode(242, HEAD);
    }
    @Test
    public void test243_GET() throws Exception {
        assertCode(243, GET);
    }
    @Test
    public void test243_POST() throws Exception {
        assertCode(243, POST);
    }
    @Test
    public void test243_PUT() throws Exception {
        assertCode(243, PUT);
    }
    @Test
    public void test243_DELETE() throws Exception {
        assertCode(243, DELETE);
    }
    @Test
    public void test243_OPTIONS() throws Exception {
        assertCode(243, OPTIONS);
    }
    @Test
    public void test243_HEAD() throws Exception {
        assertCode(243, HEAD);
    }
    @Test
    public void test244_GET() throws Exception {
        assertCode(244, GET);
    }
    @Test
    public void test244_POST() throws Exception {
        assertCode(244, POST);
    }
    @Test
    public void test244_PUT() throws Exception {
        assertCode(244, PUT);
    }
    @Test
    public void test244_DELETE() throws Exception {
        assertCode(244, DELETE);
    }
    @Test
    public void test244_OPTIONS() throws Exception {
        assertCode(244, OPTIONS);
    }
    @Test
    public void test244_HEAD() throws Exception {
        assertCode(244, HEAD);
    }
    @Test
    public void test245_GET() throws Exception {
        assertCode(245, GET);
    }
    @Test
    public void test245_POST() throws Exception {
        assertCode(245, POST);
    }
    @Test
    public void test245_PUT() throws Exception {
        assertCode(245, PUT);
    }
    @Test
    public void test245_DELETE() throws Exception {
        assertCode(245, DELETE);
    }
    @Test
    public void test245_OPTIONS() throws Exception {
        assertCode(245, OPTIONS);
    }
    @Test
    public void test245_HEAD() throws Exception {
        assertCode(245, HEAD);
    }
    @Test
    public void test246_GET() throws Exception {
        assertCode(246, GET);
    }
    @Test
    public void test246_POST() throws Exception {
        assertCode(246, POST);
    }
    @Test
    public void test246_PUT() throws Exception {
        assertCode(246, PUT);
    }
    @Test
    public void test246_DELETE() throws Exception {
        assertCode(246, DELETE);
    }
    @Test
    public void test246_OPTIONS() throws Exception {
        assertCode(246, OPTIONS);
    }
    @Test
    public void test246_HEAD() throws Exception {
        assertCode(246, HEAD);
    }
    @Test
    public void test247_GET() throws Exception {
        assertCode(247, GET);
    }
    @Test
    public void test247_POST() throws Exception {
        assertCode(247, POST);
    }
    @Test
    public void test247_PUT() throws Exception {
        assertCode(247, PUT);
    }
    @Test
    public void test247_DELETE() throws Exception {
        assertCode(247, DELETE);
    }
    @Test
    public void test247_OPTIONS() throws Exception {
        assertCode(247, OPTIONS);
    }
    @Test
    public void test247_HEAD() throws Exception {
        assertCode(247, HEAD);
    }
    @Test
    public void test248_GET() throws Exception {
        assertCode(248, GET);
    }
    @Test
    public void test248_POST() throws Exception {
        assertCode(248, POST);
    }
    @Test
    public void test248_PUT() throws Exception {
        assertCode(248, PUT);
    }
    @Test
    public void test248_DELETE() throws Exception {
        assertCode(248, DELETE);
    }
    @Test
    public void test248_OPTIONS() throws Exception {
        assertCode(248, OPTIONS);
    }
    @Test
    public void test248_HEAD() throws Exception {
        assertCode(248, HEAD);
    }
    @Test
    public void test249_GET() throws Exception {
        assertCode(249, GET);
    }
    @Test
    public void test249_POST() throws Exception {
        assertCode(249, POST);
    }
    @Test
    public void test249_PUT() throws Exception {
        assertCode(249, PUT);
    }
    @Test
    public void test249_DELETE() throws Exception {
        assertCode(249, DELETE);
    }
    @Test
    public void test249_OPTIONS() throws Exception {
        assertCode(249, OPTIONS);
    }
    @Test
    public void test249_HEAD() throws Exception {
        assertCode(249, HEAD);
    }
    @Test
    public void test250_GET() throws Exception {
        assertCode(250, GET);
    }
    @Test
    public void test250_POST() throws Exception {
        assertCode(250, POST);
    }
    @Test
    public void test250_PUT() throws Exception {
        assertCode(250, PUT);
    }
    @Test
    public void test250_DELETE() throws Exception {
        assertCode(250, DELETE);
    }
    @Test
    public void test250_OPTIONS() throws Exception {
        assertCode(250, OPTIONS);
    }
    @Test
    public void test250_HEAD() throws Exception {
        assertCode(250, HEAD);
    }
    @Test
    public void test251_GET() throws Exception {
        assertCode(251, GET);
    }
    @Test
    public void test251_POST() throws Exception {
        assertCode(251, POST);
    }
    @Test
    public void test251_PUT() throws Exception {
        assertCode(251, PUT);
    }
    @Test
    public void test251_DELETE() throws Exception {
        assertCode(251, DELETE);
    }
    @Test
    public void test251_OPTIONS() throws Exception {
        assertCode(251, OPTIONS);
    }
    @Test
    public void test251_HEAD() throws Exception {
        assertCode(251, HEAD);
    }
    @Test
    public void test252_GET() throws Exception {
        assertCode(252, GET);
    }
    @Test
    public void test252_POST() throws Exception {
        assertCode(252, POST);
    }
    @Test
    public void test252_PUT() throws Exception {
        assertCode(252, PUT);
    }
    @Test
    public void test252_DELETE() throws Exception {
        assertCode(252, DELETE);
    }
    @Test
    public void test252_OPTIONS() throws Exception {
        assertCode(252, OPTIONS);
    }
    @Test
    public void test252_HEAD() throws Exception {
        assertCode(252, HEAD);
    }
    @Test
    public void test253_GET() throws Exception {
        assertCode(253, GET);
    }
    @Test
    public void test253_POST() throws Exception {
        assertCode(253, POST);
    }
    @Test
    public void test253_PUT() throws Exception {
        assertCode(253, PUT);
    }
    @Test
    public void test253_DELETE() throws Exception {
        assertCode(253, DELETE);
    }
    @Test
    public void test253_OPTIONS() throws Exception {
        assertCode(253, OPTIONS);
    }
    @Test
    public void test253_HEAD() throws Exception {
        assertCode(253, HEAD);
    }
    @Test
    public void test254_GET() throws Exception {
        assertCode(254, GET);
    }
    @Test
    public void test254_POST() throws Exception {
        assertCode(254, POST);
    }
    @Test
    public void test254_PUT() throws Exception {
        assertCode(254, PUT);
    }
    @Test
    public void test254_DELETE() throws Exception {
        assertCode(254, DELETE);
    }
    @Test
    public void test254_OPTIONS() throws Exception {
        assertCode(254, OPTIONS);
    }
    @Test
    public void test254_HEAD() throws Exception {
        assertCode(254, HEAD);
    }
    @Test
    public void test255_GET() throws Exception {
        assertCode(255, GET);
    }
    @Test
    public void test255_POST() throws Exception {
        assertCode(255, POST);
    }
    @Test
    public void test255_PUT() throws Exception {
        assertCode(255, PUT);
    }
    @Test
    public void test255_DELETE() throws Exception {
        assertCode(255, DELETE);
    }
    @Test
    public void test255_OPTIONS() throws Exception {
        assertCode(255, OPTIONS);
    }
    @Test
    public void test255_HEAD() throws Exception {
        assertCode(255, HEAD);
    }
    @Test
    public void test256_GET() throws Exception {
        assertCode(256, GET);
    }
    @Test
    public void test256_POST() throws Exception {
        assertCode(256, POST);
    }
    @Test
    public void test256_PUT() throws Exception {
        assertCode(256, PUT);
    }
    @Test
    public void test256_DELETE() throws Exception {
        assertCode(256, DELETE);
    }
    @Test
    public void test256_OPTIONS() throws Exception {
        assertCode(256, OPTIONS);
    }
    @Test
    public void test256_HEAD() throws Exception {
        assertCode(256, HEAD);
    }
    @Test
    public void test257_GET() throws Exception {
        assertCode(257, GET);
    }
    @Test
    public void test257_POST() throws Exception {
        assertCode(257, POST);
    }
    @Test
    public void test257_PUT() throws Exception {
        assertCode(257, PUT);
    }
    @Test
    public void test257_DELETE() throws Exception {
        assertCode(257, DELETE);
    }
    @Test
    public void test257_OPTIONS() throws Exception {
        assertCode(257, OPTIONS);
    }
    @Test
    public void test257_HEAD() throws Exception {
        assertCode(257, HEAD);
    }
    @Test
    public void test258_GET() throws Exception {
        assertCode(258, GET);
    }
    @Test
    public void test258_POST() throws Exception {
        assertCode(258, POST);
    }
    @Test
    public void test258_PUT() throws Exception {
        assertCode(258, PUT);
    }
    @Test
    public void test258_DELETE() throws Exception {
        assertCode(258, DELETE);
    }
    @Test
    public void test258_OPTIONS() throws Exception {
        assertCode(258, OPTIONS);
    }
    @Test
    public void test258_HEAD() throws Exception {
        assertCode(258, HEAD);
    }
    @Test
    public void test259_GET() throws Exception {
        assertCode(259, GET);
    }
    @Test
    public void test259_POST() throws Exception {
        assertCode(259, POST);
    }
    @Test
    public void test259_PUT() throws Exception {
        assertCode(259, PUT);
    }
    @Test
    public void test259_DELETE() throws Exception {
        assertCode(259, DELETE);
    }
    @Test
    public void test259_OPTIONS() throws Exception {
        assertCode(259, OPTIONS);
    }
    @Test
    public void test259_HEAD() throws Exception {
        assertCode(259, HEAD);
    }
    @Test
    public void test260_GET() throws Exception {
        assertCode(260, GET);
    }
    @Test
    public void test260_POST() throws Exception {
        assertCode(260, POST);
    }
    @Test
    public void test260_PUT() throws Exception {
        assertCode(260, PUT);
    }
    @Test
    public void test260_DELETE() throws Exception {
        assertCode(260, DELETE);
    }
    @Test
    public void test260_OPTIONS() throws Exception {
        assertCode(260, OPTIONS);
    }
    @Test
    public void test260_HEAD() throws Exception {
        assertCode(260, HEAD);
    }
    @Test
    public void test261_GET() throws Exception {
        assertCode(261, GET);
    }
    @Test
    public void test261_POST() throws Exception {
        assertCode(261, POST);
    }
    @Test
    public void test261_PUT() throws Exception {
        assertCode(261, PUT);
    }
    @Test
    public void test261_DELETE() throws Exception {
        assertCode(261, DELETE);
    }
    @Test
    public void test261_OPTIONS() throws Exception {
        assertCode(261, OPTIONS);
    }
    @Test
    public void test261_HEAD() throws Exception {
        assertCode(261, HEAD);
    }
    @Test
    public void test262_GET() throws Exception {
        assertCode(262, GET);
    }
    @Test
    public void test262_POST() throws Exception {
        assertCode(262, POST);
    }
    @Test
    public void test262_PUT() throws Exception {
        assertCode(262, PUT);
    }
    @Test
    public void test262_DELETE() throws Exception {
        assertCode(262, DELETE);
    }
    @Test
    public void test262_OPTIONS() throws Exception {
        assertCode(262, OPTIONS);
    }
    @Test
    public void test262_HEAD() throws Exception {
        assertCode(262, HEAD);
    }
    @Test
    public void test263_GET() throws Exception {
        assertCode(263, GET);
    }
    @Test
    public void test263_POST() throws Exception {
        assertCode(263, POST);
    }
    @Test
    public void test263_PUT() throws Exception {
        assertCode(263, PUT);
    }
    @Test
    public void test263_DELETE() throws Exception {
        assertCode(263, DELETE);
    }
    @Test
    public void test263_OPTIONS() throws Exception {
        assertCode(263, OPTIONS);
    }
    @Test
    public void test263_HEAD() throws Exception {
        assertCode(263, HEAD);
    }
    @Test
    public void test264_GET() throws Exception {
        assertCode(264, GET);
    }
    @Test
    public void test264_POST() throws Exception {
        assertCode(264, POST);
    }
    @Test
    public void test264_PUT() throws Exception {
        assertCode(264, PUT);
    }
    @Test
    public void test264_DELETE() throws Exception {
        assertCode(264, DELETE);
    }
    @Test
    public void test264_OPTIONS() throws Exception {
        assertCode(264, OPTIONS);
    }
    @Test
    public void test264_HEAD() throws Exception {
        assertCode(264, HEAD);
    }
    @Test
    public void test265_GET() throws Exception {
        assertCode(265, GET);
    }
    @Test
    public void test265_POST() throws Exception {
        assertCode(265, POST);
    }
    @Test
    public void test265_PUT() throws Exception {
        assertCode(265, PUT);
    }
    @Test
    public void test265_DELETE() throws Exception {
        assertCode(265, DELETE);
    }
    @Test
    public void test265_OPTIONS() throws Exception {
        assertCode(265, OPTIONS);
    }
    @Test
    public void test265_HEAD() throws Exception {
        assertCode(265, HEAD);
    }
    @Test
    public void test266_GET() throws Exception {
        assertCode(266, GET);
    }
    @Test
    public void test266_POST() throws Exception {
        assertCode(266, POST);
    }
    @Test
    public void test266_PUT() throws Exception {
        assertCode(266, PUT);
    }
    @Test
    public void test266_DELETE() throws Exception {
        assertCode(266, DELETE);
    }
    @Test
    public void test266_OPTIONS() throws Exception {
        assertCode(266, OPTIONS);
    }
    @Test
    public void test266_HEAD() throws Exception {
        assertCode(266, HEAD);
    }
    @Test
    public void test267_GET() throws Exception {
        assertCode(267, GET);
    }
    @Test
    public void test267_POST() throws Exception {
        assertCode(267, POST);
    }
    @Test
    public void test267_PUT() throws Exception {
        assertCode(267, PUT);
    }
    @Test
    public void test267_DELETE() throws Exception {
        assertCode(267, DELETE);
    }
    @Test
    public void test267_OPTIONS() throws Exception {
        assertCode(267, OPTIONS);
    }
    @Test
    public void test267_HEAD() throws Exception {
        assertCode(267, HEAD);
    }
    @Test
    public void test268_GET() throws Exception {
        assertCode(268, GET);
    }
    @Test
    public void test268_POST() throws Exception {
        assertCode(268, POST);
    }
    @Test
    public void test268_PUT() throws Exception {
        assertCode(268, PUT);
    }
    @Test
    public void test268_DELETE() throws Exception {
        assertCode(268, DELETE);
    }
    @Test
    public void test268_OPTIONS() throws Exception {
        assertCode(268, OPTIONS);
    }
    @Test
    public void test268_HEAD() throws Exception {
        assertCode(268, HEAD);
    }
    @Test
    public void test269_GET() throws Exception {
        assertCode(269, GET);
    }
    @Test
    public void test269_POST() throws Exception {
        assertCode(269, POST);
    }
    @Test
    public void test269_PUT() throws Exception {
        assertCode(269, PUT);
    }
    @Test
    public void test269_DELETE() throws Exception {
        assertCode(269, DELETE);
    }
    @Test
    public void test269_OPTIONS() throws Exception {
        assertCode(269, OPTIONS);
    }
    @Test
    public void test269_HEAD() throws Exception {
        assertCode(269, HEAD);
    }
    @Test
    public void test270_GET() throws Exception {
        assertCode(270, GET);
    }
    @Test
    public void test270_POST() throws Exception {
        assertCode(270, POST);
    }
    @Test
    public void test270_PUT() throws Exception {
        assertCode(270, PUT);
    }
    @Test
    public void test270_DELETE() throws Exception {
        assertCode(270, DELETE);
    }
    @Test
    public void test270_OPTIONS() throws Exception {
        assertCode(270, OPTIONS);
    }
    @Test
    public void test270_HEAD() throws Exception {
        assertCode(270, HEAD);
    }
    @Test
    public void test271_GET() throws Exception {
        assertCode(271, GET);
    }
    @Test
    public void test271_POST() throws Exception {
        assertCode(271, POST);
    }
    @Test
    public void test271_PUT() throws Exception {
        assertCode(271, PUT);
    }
    @Test
    public void test271_DELETE() throws Exception {
        assertCode(271, DELETE);
    }
    @Test
    public void test271_OPTIONS() throws Exception {
        assertCode(271, OPTIONS);
    }
    @Test
    public void test271_HEAD() throws Exception {
        assertCode(271, HEAD);
    }
    @Test
    public void test272_GET() throws Exception {
        assertCode(272, GET);
    }
    @Test
    public void test272_POST() throws Exception {
        assertCode(272, POST);
    }
    @Test
    public void test272_PUT() throws Exception {
        assertCode(272, PUT);
    }
    @Test
    public void test272_DELETE() throws Exception {
        assertCode(272, DELETE);
    }
    @Test
    public void test272_OPTIONS() throws Exception {
        assertCode(272, OPTIONS);
    }
    @Test
    public void test272_HEAD() throws Exception {
        assertCode(272, HEAD);
    }
    @Test
    public void test273_GET() throws Exception {
        assertCode(273, GET);
    }
    @Test
    public void test273_POST() throws Exception {
        assertCode(273, POST);
    }
    @Test
    public void test273_PUT() throws Exception {
        assertCode(273, PUT);
    }
    @Test
    public void test273_DELETE() throws Exception {
        assertCode(273, DELETE);
    }
    @Test
    public void test273_OPTIONS() throws Exception {
        assertCode(273, OPTIONS);
    }
    @Test
    public void test273_HEAD() throws Exception {
        assertCode(273, HEAD);
    }
    @Test
    public void test274_GET() throws Exception {
        assertCode(274, GET);
    }
    @Test
    public void test274_POST() throws Exception {
        assertCode(274, POST);
    }
    @Test
    public void test274_PUT() throws Exception {
        assertCode(274, PUT);
    }
    @Test
    public void test274_DELETE() throws Exception {
        assertCode(274, DELETE);
    }
    @Test
    public void test274_OPTIONS() throws Exception {
        assertCode(274, OPTIONS);
    }
    @Test
    public void test274_HEAD() throws Exception {
        assertCode(274, HEAD);
    }
    @Test
    public void test275_GET() throws Exception {
        assertCode(275, GET);
    }
    @Test
    public void test275_POST() throws Exception {
        assertCode(275, POST);
    }
    @Test
    public void test275_PUT() throws Exception {
        assertCode(275, PUT);
    }
    @Test
    public void test275_DELETE() throws Exception {
        assertCode(275, DELETE);
    }
    @Test
    public void test275_OPTIONS() throws Exception {
        assertCode(275, OPTIONS);
    }
    @Test
    public void test275_HEAD() throws Exception {
        assertCode(275, HEAD);
    }
    @Test
    public void test276_GET() throws Exception {
        assertCode(276, GET);
    }
    @Test
    public void test276_POST() throws Exception {
        assertCode(276, POST);
    }
    @Test
    public void test276_PUT() throws Exception {
        assertCode(276, PUT);
    }
    @Test
    public void test276_DELETE() throws Exception {
        assertCode(276, DELETE);
    }
    @Test
    public void test276_OPTIONS() throws Exception {
        assertCode(276, OPTIONS);
    }
    @Test
    public void test276_HEAD() throws Exception {
        assertCode(276, HEAD);
    }
    @Test
    public void test277_GET() throws Exception {
        assertCode(277, GET);
    }
    @Test
    public void test277_POST() throws Exception {
        assertCode(277, POST);
    }
    @Test
    public void test277_PUT() throws Exception {
        assertCode(277, PUT);
    }
    @Test
    public void test277_DELETE() throws Exception {
        assertCode(277, DELETE);
    }
    @Test
    public void test277_OPTIONS() throws Exception {
        assertCode(277, OPTIONS);
    }
    @Test
    public void test277_HEAD() throws Exception {
        assertCode(277, HEAD);
    }
    @Test
    public void test278_GET() throws Exception {
        assertCode(278, GET);
    }
    @Test
    public void test278_POST() throws Exception {
        assertCode(278, POST);
    }
    @Test
    public void test278_PUT() throws Exception {
        assertCode(278, PUT);
    }
    @Test
    public void test278_DELETE() throws Exception {
        assertCode(278, DELETE);
    }
    @Test
    public void test278_OPTIONS() throws Exception {
        assertCode(278, OPTIONS);
    }
    @Test
    public void test278_HEAD() throws Exception {
        assertCode(278, HEAD);
    }
    @Test
    public void test279_GET() throws Exception {
        assertCode(279, GET);
    }
    @Test
    public void test279_POST() throws Exception {
        assertCode(279, POST);
    }
    @Test
    public void test279_PUT() throws Exception {
        assertCode(279, PUT);
    }
    @Test
    public void test279_DELETE() throws Exception {
        assertCode(279, DELETE);
    }
    @Test
    public void test279_OPTIONS() throws Exception {
        assertCode(279, OPTIONS);
    }
    @Test
    public void test279_HEAD() throws Exception {
        assertCode(279, HEAD);
    }
    @Test
    public void test280_GET() throws Exception {
        assertCode(280, GET);
    }
    @Test
    public void test280_POST() throws Exception {
        assertCode(280, POST);
    }
    @Test
    public void test280_PUT() throws Exception {
        assertCode(280, PUT);
    }
    @Test
    public void test280_DELETE() throws Exception {
        assertCode(280, DELETE);
    }
    @Test
    public void test280_OPTIONS() throws Exception {
        assertCode(280, OPTIONS);
    }
    @Test
    public void test280_HEAD() throws Exception {
        assertCode(280, HEAD);
    }
    @Test
    public void test281_GET() throws Exception {
        assertCode(281, GET);
    }
    @Test
    public void test281_POST() throws Exception {
        assertCode(281, POST);
    }
    @Test
    public void test281_PUT() throws Exception {
        assertCode(281, PUT);
    }
    @Test
    public void test281_DELETE() throws Exception {
        assertCode(281, DELETE);
    }
    @Test
    public void test281_OPTIONS() throws Exception {
        assertCode(281, OPTIONS);
    }
    @Test
    public void test281_HEAD() throws Exception {
        assertCode(281, HEAD);
    }
    @Test
    public void test282_GET() throws Exception {
        assertCode(282, GET);
    }
    @Test
    public void test282_POST() throws Exception {
        assertCode(282, POST);
    }
    @Test
    public void test282_PUT() throws Exception {
        assertCode(282, PUT);
    }
    @Test
    public void test282_DELETE() throws Exception {
        assertCode(282, DELETE);
    }
    @Test
    public void test282_OPTIONS() throws Exception {
        assertCode(282, OPTIONS);
    }
    @Test
    public void test282_HEAD() throws Exception {
        assertCode(282, HEAD);
    }
    @Test
    public void test283_GET() throws Exception {
        assertCode(283, GET);
    }
    @Test
    public void test283_POST() throws Exception {
        assertCode(283, POST);
    }
    @Test
    public void test283_PUT() throws Exception {
        assertCode(283, PUT);
    }
    @Test
    public void test283_DELETE() throws Exception {
        assertCode(283, DELETE);
    }
    @Test
    public void test283_OPTIONS() throws Exception {
        assertCode(283, OPTIONS);
    }
    @Test
    public void test283_HEAD() throws Exception {
        assertCode(283, HEAD);
    }
    @Test
    public void test284_GET() throws Exception {
        assertCode(284, GET);
    }
    @Test
    public void test284_POST() throws Exception {
        assertCode(284, POST);
    }
    @Test
    public void test284_PUT() throws Exception {
        assertCode(284, PUT);
    }
    @Test
    public void test284_DELETE() throws Exception {
        assertCode(284, DELETE);
    }
    @Test
    public void test284_OPTIONS() throws Exception {
        assertCode(284, OPTIONS);
    }
    @Test
    public void test284_HEAD() throws Exception {
        assertCode(284, HEAD);
    }
    @Test
    public void test285_GET() throws Exception {
        assertCode(285, GET);
    }
    @Test
    public void test285_POST() throws Exception {
        assertCode(285, POST);
    }
    @Test
    public void test285_PUT() throws Exception {
        assertCode(285, PUT);
    }
    @Test
    public void test285_DELETE() throws Exception {
        assertCode(285, DELETE);
    }
    @Test
    public void test285_OPTIONS() throws Exception {
        assertCode(285, OPTIONS);
    }
    @Test
    public void test285_HEAD() throws Exception {
        assertCode(285, HEAD);
    }
    @Test
    public void test286_GET() throws Exception {
        assertCode(286, GET);
    }
    @Test
    public void test286_POST() throws Exception {
        assertCode(286, POST);
    }
    @Test
    public void test286_PUT() throws Exception {
        assertCode(286, PUT);
    }
    @Test
    public void test286_DELETE() throws Exception {
        assertCode(286, DELETE);
    }
    @Test
    public void test286_OPTIONS() throws Exception {
        assertCode(286, OPTIONS);
    }
    @Test
    public void test286_HEAD() throws Exception {
        assertCode(286, HEAD);
    }
    @Test
    public void test287_GET() throws Exception {
        assertCode(287, GET);
    }
    @Test
    public void test287_POST() throws Exception {
        assertCode(287, POST);
    }
    @Test
    public void test287_PUT() throws Exception {
        assertCode(287, PUT);
    }
    @Test
    public void test287_DELETE() throws Exception {
        assertCode(287, DELETE);
    }
    @Test
    public void test287_OPTIONS() throws Exception {
        assertCode(287, OPTIONS);
    }
    @Test
    public void test287_HEAD() throws Exception {
        assertCode(287, HEAD);
    }
    @Test
    public void test288_GET() throws Exception {
        assertCode(288, GET);
    }
    @Test
    public void test288_POST() throws Exception {
        assertCode(288, POST);
    }
    @Test
    public void test288_PUT() throws Exception {
        assertCode(288, PUT);
    }
    @Test
    public void test288_DELETE() throws Exception {
        assertCode(288, DELETE);
    }
    @Test
    public void test288_OPTIONS() throws Exception {
        assertCode(288, OPTIONS);
    }
    @Test
    public void test288_HEAD() throws Exception {
        assertCode(288, HEAD);
    }
    @Test
    public void test289_GET() throws Exception {
        assertCode(289, GET);
    }
    @Test
    public void test289_POST() throws Exception {
        assertCode(289, POST);
    }
    @Test
    public void test289_PUT() throws Exception {
        assertCode(289, PUT);
    }
    @Test
    public void test289_DELETE() throws Exception {
        assertCode(289, DELETE);
    }
    @Test
    public void test289_OPTIONS() throws Exception {
        assertCode(289, OPTIONS);
    }
    @Test
    public void test289_HEAD() throws Exception {
        assertCode(289, HEAD);
    }
    @Test
    public void test290_GET() throws Exception {
        assertCode(290, GET);
    }
    @Test
    public void test290_POST() throws Exception {
        assertCode(290, POST);
    }
    @Test
    public void test290_PUT() throws Exception {
        assertCode(290, PUT);
    }
    @Test
    public void test290_DELETE() throws Exception {
        assertCode(290, DELETE);
    }
    @Test
    public void test290_OPTIONS() throws Exception {
        assertCode(290, OPTIONS);
    }
    @Test
    public void test290_HEAD() throws Exception {
        assertCode(290, HEAD);
    }
    @Test
    public void test291_GET() throws Exception {
        assertCode(291, GET);
    }
    @Test
    public void test291_POST() throws Exception {
        assertCode(291, POST);
    }
    @Test
    public void test291_PUT() throws Exception {
        assertCode(291, PUT);
    }
    @Test
    public void test291_DELETE() throws Exception {
        assertCode(291, DELETE);
    }
    @Test
    public void test291_OPTIONS() throws Exception {
        assertCode(291, OPTIONS);
    }
    @Test
    public void test291_HEAD() throws Exception {
        assertCode(291, HEAD);
    }
    @Test
    public void test292_GET() throws Exception {
        assertCode(292, GET);
    }
    @Test
    public void test292_POST() throws Exception {
        assertCode(292, POST);
    }
    @Test
    public void test292_PUT() throws Exception {
        assertCode(292, PUT);
    }
    @Test
    public void test292_DELETE() throws Exception {
        assertCode(292, DELETE);
    }
    @Test
    public void test292_OPTIONS() throws Exception {
        assertCode(292, OPTIONS);
    }
    @Test
    public void test292_HEAD() throws Exception {
        assertCode(292, HEAD);
    }
    @Test
    public void test293_GET() throws Exception {
        assertCode(293, GET);
    }
    @Test
    public void test293_POST() throws Exception {
        assertCode(293, POST);
    }
    @Test
    public void test293_PUT() throws Exception {
        assertCode(293, PUT);
    }
    @Test
    public void test293_DELETE() throws Exception {
        assertCode(293, DELETE);
    }
    @Test
    public void test293_OPTIONS() throws Exception {
        assertCode(293, OPTIONS);
    }
    @Test
    public void test293_HEAD() throws Exception {
        assertCode(293, HEAD);
    }
    @Test
    public void test294_GET() throws Exception {
        assertCode(294, GET);
    }
    @Test
    public void test294_POST() throws Exception {
        assertCode(294, POST);
    }
    @Test
    public void test294_PUT() throws Exception {
        assertCode(294, PUT);
    }
    @Test
    public void test294_DELETE() throws Exception {
        assertCode(294, DELETE);
    }
    @Test
    public void test294_OPTIONS() throws Exception {
        assertCode(294, OPTIONS);
    }
    @Test
    public void test294_HEAD() throws Exception {
        assertCode(294, HEAD);
    }
    @Test
    public void test295_GET() throws Exception {
        assertCode(295, GET);
    }
    @Test
    public void test295_POST() throws Exception {
        assertCode(295, POST);
    }
    @Test
    public void test295_PUT() throws Exception {
        assertCode(295, PUT);
    }
    @Test
    public void test295_DELETE() throws Exception {
        assertCode(295, DELETE);
    }
    @Test
    public void test295_OPTIONS() throws Exception {
        assertCode(295, OPTIONS);
    }
    @Test
    public void test295_HEAD() throws Exception {
        assertCode(295, HEAD);
    }
    @Test
    public void test296_GET() throws Exception {
        assertCode(296, GET);
    }
    @Test
    public void test296_POST() throws Exception {
        assertCode(296, POST);
    }
    @Test
    public void test296_PUT() throws Exception {
        assertCode(296, PUT);
    }
    @Test
    public void test296_DELETE() throws Exception {
        assertCode(296, DELETE);
    }
    @Test
    public void test296_OPTIONS() throws Exception {
        assertCode(296, OPTIONS);
    }
    @Test
    public void test296_HEAD() throws Exception {
        assertCode(296, HEAD);
    }
    @Test
    public void test297_GET() throws Exception {
        assertCode(297, GET);
    }
    @Test
    public void test297_POST() throws Exception {
        assertCode(297, POST);
    }
    @Test
    public void test297_PUT() throws Exception {
        assertCode(297, PUT);
    }
    @Test
    public void test297_DELETE() throws Exception {
        assertCode(297, DELETE);
    }
    @Test
    public void test297_OPTIONS() throws Exception {
        assertCode(297, OPTIONS);
    }
    @Test
    public void test297_HEAD() throws Exception {
        assertCode(297, HEAD);
    }
    @Test
    public void test298_GET() throws Exception {
        assertCode(298, GET);
    }
    @Test
    public void test298_POST() throws Exception {
        assertCode(298, POST);
    }
    @Test
    public void test298_PUT() throws Exception {
        assertCode(298, PUT);
    }
    @Test
    public void test298_DELETE() throws Exception {
        assertCode(298, DELETE);
    }
    @Test
    public void test298_OPTIONS() throws Exception {
        assertCode(298, OPTIONS);
    }
    @Test
    public void test298_HEAD() throws Exception {
        assertCode(298, HEAD);
    }
    @Test
    public void test299_GET() throws Exception {
        assertCode(299, GET);
    }
    @Test
    public void test299_POST() throws Exception {
        assertCode(299, POST);
    }
    @Test
    public void test299_PUT() throws Exception {
        assertCode(299, PUT);
    }
    @Test
    public void test299_DELETE() throws Exception {
        assertCode(299, DELETE);
    }
    @Test
    public void test299_OPTIONS() throws Exception {
        assertCode(299, OPTIONS);
    }
    @Test
    public void test299_HEAD() throws Exception {
        assertCode(299, HEAD);
    }
    @Test
    public void test300_GET() throws Exception {
        assertCode(300, GET);
    }
    @Test
    public void test300_POST() throws Exception {
        assertCode(300, POST);
    }
    @Test
    public void test300_PUT() throws Exception {
        assertCode(300, PUT);
    }
    @Test
    public void test300_DELETE() throws Exception {
        assertCode(300, DELETE);
    }
    @Test
    public void test300_OPTIONS() throws Exception {
        assertCode(300, OPTIONS);
    }
    @Test
    public void test300_HEAD() throws Exception {
        assertCode(300, HEAD);
    }
    @Test
    public void test301_GET() throws Exception {
        assertCode(301, GET);
    }
    @Test
    public void test301_POST() throws Exception {
        assertCode(301, POST);
    }
    @Test
    public void test301_PUT() throws Exception {
        assertCode(301, PUT);
    }
    @Test
    public void test301_DELETE() throws Exception {
        assertCode(301, DELETE);
    }
    @Test
    public void test301_OPTIONS() throws Exception {
        assertCode(301, OPTIONS);
    }
    @Test
    public void test301_HEAD() throws Exception {
        assertCode(301, HEAD);
    }
    @Test
    public void test302_GET() throws Exception {
        assertCode(302, GET);
    }
    @Test
    public void test302_POST() throws Exception {
        assertCode(302, POST);
    }
    @Test
    public void test302_PUT() throws Exception {
        assertCode(302, PUT);
    }
    @Test
    public void test302_DELETE() throws Exception {
        assertCode(302, DELETE);
    }
    @Test
    public void test302_OPTIONS() throws Exception {
        assertCode(302, OPTIONS);
    }
    @Test
    public void test302_HEAD() throws Exception {
        assertCode(302, HEAD);
    }
    @Test
    public void test303_GET() throws Exception {
        assertCode(303, GET);
    }
    @Test
    public void test303_POST() throws Exception {
        assertCode(303, POST);
    }
    @Test
    public void test303_PUT() throws Exception {
        assertCode(303, PUT);
    }
    @Test
    public void test303_DELETE() throws Exception {
        assertCode(303, DELETE);
    }
    @Test
    public void test303_OPTIONS() throws Exception {
        assertCode(303, OPTIONS);
    }
    @Test
    public void test303_HEAD() throws Exception {
        assertCode(303, HEAD);
    }
    @Test
    public void test304_GET() throws Exception {
        assertCode(304, GET);
    }
    @Test
    public void test304_POST() throws Exception {
        assertCode(304, POST);
    }
    @Test
    public void test304_PUT() throws Exception {
        assertCode(304, PUT);
    }
    @Test
    public void test304_DELETE() throws Exception {
        assertCode(304, DELETE);
    }
    @Test
    public void test304_OPTIONS() throws Exception {
        assertCode(304, OPTIONS);
    }
    @Test
    public void test304_HEAD() throws Exception {
        assertCode(304, HEAD);
    }
    @Test
    public void test305_GET() throws Exception {
        assertCode(305, GET);
    }
    @Test
    public void test305_POST() throws Exception {
        assertCode(305, POST);
    }
    @Test
    public void test305_PUT() throws Exception {
        assertCode(305, PUT);
    }
    @Test
    public void test305_DELETE() throws Exception {
        assertCode(305, DELETE);
    }
    @Test
    public void test305_OPTIONS() throws Exception {
        assertCode(305, OPTIONS);
    }
    @Test
    public void test305_HEAD() throws Exception {
        assertCode(305, HEAD);
    }
    @Test
    public void test306_GET() throws Exception {
        assertCode(306, GET);
    }
    @Test
    public void test306_POST() throws Exception {
        assertCode(306, POST);
    }
    @Test
    public void test306_PUT() throws Exception {
        assertCode(306, PUT);
    }
    @Test
    public void test306_DELETE() throws Exception {
        assertCode(306, DELETE);
    }
    @Test
    public void test306_OPTIONS() throws Exception {
        assertCode(306, OPTIONS);
    }
    @Test
    public void test306_HEAD() throws Exception {
        assertCode(306, HEAD);
    }
    @Test
    public void test307_GET() throws Exception {
        assertCode(307, GET);
    }
    @Test
    public void test307_POST() throws Exception {
        assertCode(307, POST);
    }
    @Test
    public void test307_PUT() throws Exception {
        assertCode(307, PUT);
    }
    @Test
    public void test307_DELETE() throws Exception {
        assertCode(307, DELETE);
    }
    @Test
    public void test307_OPTIONS() throws Exception {
        assertCode(307, OPTIONS);
    }
    @Test
    public void test307_HEAD() throws Exception {
        assertCode(307, HEAD);
    }
    @Test
    public void test308_GET() throws Exception {
        assertCode(308, GET);
    }
    @Test
    public void test308_POST() throws Exception {
        assertCode(308, POST);
    }
    @Test
    public void test308_PUT() throws Exception {
        assertCode(308, PUT);
    }
    @Test
    public void test308_DELETE() throws Exception {
        assertCode(308, DELETE);
    }
    @Test
    public void test308_OPTIONS() throws Exception {
        assertCode(308, OPTIONS);
    }
    @Test
    public void test308_HEAD() throws Exception {
        assertCode(308, HEAD);
    }
    @Test
    public void test309_GET() throws Exception {
        assertCode(309, GET);
    }
    @Test
    public void test309_POST() throws Exception {
        assertCode(309, POST);
    }
    @Test
    public void test309_PUT() throws Exception {
        assertCode(309, PUT);
    }
    @Test
    public void test309_DELETE() throws Exception {
        assertCode(309, DELETE);
    }
    @Test
    public void test309_OPTIONS() throws Exception {
        assertCode(309, OPTIONS);
    }
    @Test
    public void test309_HEAD() throws Exception {
        assertCode(309, HEAD);
    }
    @Test
    public void test310_GET() throws Exception {
        assertCode(310, GET);
    }
    @Test
    public void test310_POST() throws Exception {
        assertCode(310, POST);
    }
    @Test
    public void test310_PUT() throws Exception {
        assertCode(310, PUT);
    }
    @Test
    public void test310_DELETE() throws Exception {
        assertCode(310, DELETE);
    }
    @Test
    public void test310_OPTIONS() throws Exception {
        assertCode(310, OPTIONS);
    }
    @Test
    public void test310_HEAD() throws Exception {
        assertCode(310, HEAD);
    }
    @Test
    public void test311_GET() throws Exception {
        assertCode(311, GET);
    }
    @Test
    public void test311_POST() throws Exception {
        assertCode(311, POST);
    }
    @Test
    public void test311_PUT() throws Exception {
        assertCode(311, PUT);
    }
    @Test
    public void test311_DELETE() throws Exception {
        assertCode(311, DELETE);
    }
    @Test
    public void test311_OPTIONS() throws Exception {
        assertCode(311, OPTIONS);
    }
    @Test
    public void test311_HEAD() throws Exception {
        assertCode(311, HEAD);
    }
    @Test
    public void test312_GET() throws Exception {
        assertCode(312, GET);
    }
    @Test
    public void test312_POST() throws Exception {
        assertCode(312, POST);
    }
    @Test
    public void test312_PUT() throws Exception {
        assertCode(312, PUT);
    }
    @Test
    public void test312_DELETE() throws Exception {
        assertCode(312, DELETE);
    }
    @Test
    public void test312_OPTIONS() throws Exception {
        assertCode(312, OPTIONS);
    }
    @Test
    public void test312_HEAD() throws Exception {
        assertCode(312, HEAD);
    }
    @Test
    public void test313_GET() throws Exception {
        assertCode(313, GET);
    }
    @Test
    public void test313_POST() throws Exception {
        assertCode(313, POST);
    }
    @Test
    public void test313_PUT() throws Exception {
        assertCode(313, PUT);
    }
    @Test
    public void test313_DELETE() throws Exception {
        assertCode(313, DELETE);
    }
    @Test
    public void test313_OPTIONS() throws Exception {
        assertCode(313, OPTIONS);
    }
    @Test
    public void test313_HEAD() throws Exception {
        assertCode(313, HEAD);
    }
    @Test
    public void test314_GET() throws Exception {
        assertCode(314, GET);
    }
    @Test
    public void test314_POST() throws Exception {
        assertCode(314, POST);
    }
    @Test
    public void test314_PUT() throws Exception {
        assertCode(314, PUT);
    }
    @Test
    public void test314_DELETE() throws Exception {
        assertCode(314, DELETE);
    }
    @Test
    public void test314_OPTIONS() throws Exception {
        assertCode(314, OPTIONS);
    }
    @Test
    public void test314_HEAD() throws Exception {
        assertCode(314, HEAD);
    }
    @Test
    public void test315_GET() throws Exception {
        assertCode(315, GET);
    }
    @Test
    public void test315_POST() throws Exception {
        assertCode(315, POST);
    }
    @Test
    public void test315_PUT() throws Exception {
        assertCode(315, PUT);
    }
    @Test
    public void test315_DELETE() throws Exception {
        assertCode(315, DELETE);
    }
    @Test
    public void test315_OPTIONS() throws Exception {
        assertCode(315, OPTIONS);
    }
    @Test
    public void test315_HEAD() throws Exception {
        assertCode(315, HEAD);
    }
    @Test
    public void test316_GET() throws Exception {
        assertCode(316, GET);
    }
    @Test
    public void test316_POST() throws Exception {
        assertCode(316, POST);
    }
    @Test
    public void test316_PUT() throws Exception {
        assertCode(316, PUT);
    }
    @Test
    public void test316_DELETE() throws Exception {
        assertCode(316, DELETE);
    }
    @Test
    public void test316_OPTIONS() throws Exception {
        assertCode(316, OPTIONS);
    }
    @Test
    public void test316_HEAD() throws Exception {
        assertCode(316, HEAD);
    }
    @Test
    public void test317_GET() throws Exception {
        assertCode(317, GET);
    }
    @Test
    public void test317_POST() throws Exception {
        assertCode(317, POST);
    }
    @Test
    public void test317_PUT() throws Exception {
        assertCode(317, PUT);
    }
    @Test
    public void test317_DELETE() throws Exception {
        assertCode(317, DELETE);
    }
    @Test
    public void test317_OPTIONS() throws Exception {
        assertCode(317, OPTIONS);
    }
    @Test
    public void test317_HEAD() throws Exception {
        assertCode(317, HEAD);
    }
    @Test
    public void test318_GET() throws Exception {
        assertCode(318, GET);
    }
    @Test
    public void test318_POST() throws Exception {
        assertCode(318, POST);
    }
    @Test
    public void test318_PUT() throws Exception {
        assertCode(318, PUT);
    }
    @Test
    public void test318_DELETE() throws Exception {
        assertCode(318, DELETE);
    }
    @Test
    public void test318_OPTIONS() throws Exception {
        assertCode(318, OPTIONS);
    }
    @Test
    public void test318_HEAD() throws Exception {
        assertCode(318, HEAD);
    }
    @Test
    public void test319_GET() throws Exception {
        assertCode(319, GET);
    }
    @Test
    public void test319_POST() throws Exception {
        assertCode(319, POST);
    }
    @Test
    public void test319_PUT() throws Exception {
        assertCode(319, PUT);
    }
    @Test
    public void test319_DELETE() throws Exception {
        assertCode(319, DELETE);
    }
    @Test
    public void test319_OPTIONS() throws Exception {
        assertCode(319, OPTIONS);
    }
    @Test
    public void test319_HEAD() throws Exception {
        assertCode(319, HEAD);
    }
    @Test
    public void test320_GET() throws Exception {
        assertCode(320, GET);
    }
    @Test
    public void test320_POST() throws Exception {
        assertCode(320, POST);
    }
    @Test
    public void test320_PUT() throws Exception {
        assertCode(320, PUT);
    }
    @Test
    public void test320_DELETE() throws Exception {
        assertCode(320, DELETE);
    }
    @Test
    public void test320_OPTIONS() throws Exception {
        assertCode(320, OPTIONS);
    }
    @Test
    public void test320_HEAD() throws Exception {
        assertCode(320, HEAD);
    }
    @Test
    public void test321_GET() throws Exception {
        assertCode(321, GET);
    }
    @Test
    public void test321_POST() throws Exception {
        assertCode(321, POST);
    }
    @Test
    public void test321_PUT() throws Exception {
        assertCode(321, PUT);
    }
    @Test
    public void test321_DELETE() throws Exception {
        assertCode(321, DELETE);
    }
    @Test
    public void test321_OPTIONS() throws Exception {
        assertCode(321, OPTIONS);
    }
    @Test
    public void test321_HEAD() throws Exception {
        assertCode(321, HEAD);
    }
    @Test
    public void test322_GET() throws Exception {
        assertCode(322, GET);
    }
    @Test
    public void test322_POST() throws Exception {
        assertCode(322, POST);
    }
    @Test
    public void test322_PUT() throws Exception {
        assertCode(322, PUT);
    }
    @Test
    public void test322_DELETE() throws Exception {
        assertCode(322, DELETE);
    }
    @Test
    public void test322_OPTIONS() throws Exception {
        assertCode(322, OPTIONS);
    }
    @Test
    public void test322_HEAD() throws Exception {
        assertCode(322, HEAD);
    }
    @Test
    public void test323_GET() throws Exception {
        assertCode(323, GET);
    }
    @Test
    public void test323_POST() throws Exception {
        assertCode(323, POST);
    }
    @Test
    public void test323_PUT() throws Exception {
        assertCode(323, PUT);
    }
    @Test
    public void test323_DELETE() throws Exception {
        assertCode(323, DELETE);
    }
    @Test
    public void test323_OPTIONS() throws Exception {
        assertCode(323, OPTIONS);
    }
    @Test
    public void test323_HEAD() throws Exception {
        assertCode(323, HEAD);
    }
    @Test
    public void test324_GET() throws Exception {
        assertCode(324, GET);
    }
    @Test
    public void test324_POST() throws Exception {
        assertCode(324, POST);
    }
    @Test
    public void test324_PUT() throws Exception {
        assertCode(324, PUT);
    }
    @Test
    public void test324_DELETE() throws Exception {
        assertCode(324, DELETE);
    }
    @Test
    public void test324_OPTIONS() throws Exception {
        assertCode(324, OPTIONS);
    }
    @Test
    public void test324_HEAD() throws Exception {
        assertCode(324, HEAD);
    }
    @Test
    public void test325_GET() throws Exception {
        assertCode(325, GET);
    }
    @Test
    public void test325_POST() throws Exception {
        assertCode(325, POST);
    }
    @Test
    public void test325_PUT() throws Exception {
        assertCode(325, PUT);
    }
    @Test
    public void test325_DELETE() throws Exception {
        assertCode(325, DELETE);
    }
    @Test
    public void test325_OPTIONS() throws Exception {
        assertCode(325, OPTIONS);
    }
    @Test
    public void test325_HEAD() throws Exception {
        assertCode(325, HEAD);
    }
    @Test
    public void test326_GET() throws Exception {
        assertCode(326, GET);
    }
    @Test
    public void test326_POST() throws Exception {
        assertCode(326, POST);
    }
    @Test
    public void test326_PUT() throws Exception {
        assertCode(326, PUT);
    }
    @Test
    public void test326_DELETE() throws Exception {
        assertCode(326, DELETE);
    }
    @Test
    public void test326_OPTIONS() throws Exception {
        assertCode(326, OPTIONS);
    }
    @Test
    public void test326_HEAD() throws Exception {
        assertCode(326, HEAD);
    }
    @Test
    public void test327_GET() throws Exception {
        assertCode(327, GET);
    }
    @Test
    public void test327_POST() throws Exception {
        assertCode(327, POST);
    }
    @Test
    public void test327_PUT() throws Exception {
        assertCode(327, PUT);
    }
    @Test
    public void test327_DELETE() throws Exception {
        assertCode(327, DELETE);
    }
    @Test
    public void test327_OPTIONS() throws Exception {
        assertCode(327, OPTIONS);
    }
    @Test
    public void test327_HEAD() throws Exception {
        assertCode(327, HEAD);
    }
    @Test
    public void test328_GET() throws Exception {
        assertCode(328, GET);
    }
    @Test
    public void test328_POST() throws Exception {
        assertCode(328, POST);
    }
    @Test
    public void test328_PUT() throws Exception {
        assertCode(328, PUT);
    }
    @Test
    public void test328_DELETE() throws Exception {
        assertCode(328, DELETE);
    }
    @Test
    public void test328_OPTIONS() throws Exception {
        assertCode(328, OPTIONS);
    }
    @Test
    public void test328_HEAD() throws Exception {
        assertCode(328, HEAD);
    }
    @Test
    public void test329_GET() throws Exception {
        assertCode(329, GET);
    }
    @Test
    public void test329_POST() throws Exception {
        assertCode(329, POST);
    }
    @Test
    public void test329_PUT() throws Exception {
        assertCode(329, PUT);
    }
    @Test
    public void test329_DELETE() throws Exception {
        assertCode(329, DELETE);
    }
    @Test
    public void test329_OPTIONS() throws Exception {
        assertCode(329, OPTIONS);
    }
    @Test
    public void test329_HEAD() throws Exception {
        assertCode(329, HEAD);
    }
    @Test
    public void test330_GET() throws Exception {
        assertCode(330, GET);
    }
    @Test
    public void test330_POST() throws Exception {
        assertCode(330, POST);
    }
    @Test
    public void test330_PUT() throws Exception {
        assertCode(330, PUT);
    }
    @Test
    public void test330_DELETE() throws Exception {
        assertCode(330, DELETE);
    }
    @Test
    public void test330_OPTIONS() throws Exception {
        assertCode(330, OPTIONS);
    }
    @Test
    public void test330_HEAD() throws Exception {
        assertCode(330, HEAD);
    }
    @Test
    public void test331_GET() throws Exception {
        assertCode(331, GET);
    }
    @Test
    public void test331_POST() throws Exception {
        assertCode(331, POST);
    }
    @Test
    public void test331_PUT() throws Exception {
        assertCode(331, PUT);
    }
    @Test
    public void test331_DELETE() throws Exception {
        assertCode(331, DELETE);
    }
    @Test
    public void test331_OPTIONS() throws Exception {
        assertCode(331, OPTIONS);
    }
    @Test
    public void test331_HEAD() throws Exception {
        assertCode(331, HEAD);
    }
    @Test
    public void test332_GET() throws Exception {
        assertCode(332, GET);
    }
    @Test
    public void test332_POST() throws Exception {
        assertCode(332, POST);
    }
    @Test
    public void test332_PUT() throws Exception {
        assertCode(332, PUT);
    }
    @Test
    public void test332_DELETE() throws Exception {
        assertCode(332, DELETE);
    }
    @Test
    public void test332_OPTIONS() throws Exception {
        assertCode(332, OPTIONS);
    }
    @Test
    public void test332_HEAD() throws Exception {
        assertCode(332, HEAD);
    }
    @Test
    public void test333_GET() throws Exception {
        assertCode(333, GET);
    }
    @Test
    public void test333_POST() throws Exception {
        assertCode(333, POST);
    }
    @Test
    public void test333_PUT() throws Exception {
        assertCode(333, PUT);
    }
    @Test
    public void test333_DELETE() throws Exception {
        assertCode(333, DELETE);
    }
    @Test
    public void test333_OPTIONS() throws Exception {
        assertCode(333, OPTIONS);
    }
    @Test
    public void test333_HEAD() throws Exception {
        assertCode(333, HEAD);
    }
    @Test
    public void test334_GET() throws Exception {
        assertCode(334, GET);
    }
    @Test
    public void test334_POST() throws Exception {
        assertCode(334, POST);
    }
    @Test
    public void test334_PUT() throws Exception {
        assertCode(334, PUT);
    }
    @Test
    public void test334_DELETE() throws Exception {
        assertCode(334, DELETE);
    }
    @Test
    public void test334_OPTIONS() throws Exception {
        assertCode(334, OPTIONS);
    }
    @Test
    public void test334_HEAD() throws Exception {
        assertCode(334, HEAD);
    }
    @Test
    public void test335_GET() throws Exception {
        assertCode(335, GET);
    }
    @Test
    public void test335_POST() throws Exception {
        assertCode(335, POST);
    }
    @Test
    public void test335_PUT() throws Exception {
        assertCode(335, PUT);
    }
    @Test
    public void test335_DELETE() throws Exception {
        assertCode(335, DELETE);
    }
    @Test
    public void test335_OPTIONS() throws Exception {
        assertCode(335, OPTIONS);
    }
    @Test
    public void test335_HEAD() throws Exception {
        assertCode(335, HEAD);
    }
    @Test
    public void test336_GET() throws Exception {
        assertCode(336, GET);
    }
    @Test
    public void test336_POST() throws Exception {
        assertCode(336, POST);
    }
    @Test
    public void test336_PUT() throws Exception {
        assertCode(336, PUT);
    }
    @Test
    public void test336_DELETE() throws Exception {
        assertCode(336, DELETE);
    }
    @Test
    public void test336_OPTIONS() throws Exception {
        assertCode(336, OPTIONS);
    }
    @Test
    public void test336_HEAD() throws Exception {
        assertCode(336, HEAD);
    }
    @Test
    public void test337_GET() throws Exception {
        assertCode(337, GET);
    }
    @Test
    public void test337_POST() throws Exception {
        assertCode(337, POST);
    }
    @Test
    public void test337_PUT() throws Exception {
        assertCode(337, PUT);
    }
    @Test
    public void test337_DELETE() throws Exception {
        assertCode(337, DELETE);
    }
    @Test
    public void test337_OPTIONS() throws Exception {
        assertCode(337, OPTIONS);
    }
    @Test
    public void test337_HEAD() throws Exception {
        assertCode(337, HEAD);
    }
    @Test
    public void test338_GET() throws Exception {
        assertCode(338, GET);
    }
    @Test
    public void test338_POST() throws Exception {
        assertCode(338, POST);
    }
    @Test
    public void test338_PUT() throws Exception {
        assertCode(338, PUT);
    }
    @Test
    public void test338_DELETE() throws Exception {
        assertCode(338, DELETE);
    }
    @Test
    public void test338_OPTIONS() throws Exception {
        assertCode(338, OPTIONS);
    }
    @Test
    public void test338_HEAD() throws Exception {
        assertCode(338, HEAD);
    }
    @Test
    public void test339_GET() throws Exception {
        assertCode(339, GET);
    }
    @Test
    public void test339_POST() throws Exception {
        assertCode(339, POST);
    }
    @Test
    public void test339_PUT() throws Exception {
        assertCode(339, PUT);
    }
    @Test
    public void test339_DELETE() throws Exception {
        assertCode(339, DELETE);
    }
    @Test
    public void test339_OPTIONS() throws Exception {
        assertCode(339, OPTIONS);
    }
    @Test
    public void test339_HEAD() throws Exception {
        assertCode(339, HEAD);
    }
    @Test
    public void test340_GET() throws Exception {
        assertCode(340, GET);
    }
    @Test
    public void test340_POST() throws Exception {
        assertCode(340, POST);
    }
    @Test
    public void test340_PUT() throws Exception {
        assertCode(340, PUT);
    }
    @Test
    public void test340_DELETE() throws Exception {
        assertCode(340, DELETE);
    }
    @Test
    public void test340_OPTIONS() throws Exception {
        assertCode(340, OPTIONS);
    }
    @Test
    public void test340_HEAD() throws Exception {
        assertCode(340, HEAD);
    }
    @Test
    public void test341_GET() throws Exception {
        assertCode(341, GET);
    }
    @Test
    public void test341_POST() throws Exception {
        assertCode(341, POST);
    }
    @Test
    public void test341_PUT() throws Exception {
        assertCode(341, PUT);
    }
    @Test
    public void test341_DELETE() throws Exception {
        assertCode(341, DELETE);
    }
    @Test
    public void test341_OPTIONS() throws Exception {
        assertCode(341, OPTIONS);
    }
    @Test
    public void test341_HEAD() throws Exception {
        assertCode(341, HEAD);
    }
    @Test
    public void test342_GET() throws Exception {
        assertCode(342, GET);
    }
    @Test
    public void test342_POST() throws Exception {
        assertCode(342, POST);
    }
    @Test
    public void test342_PUT() throws Exception {
        assertCode(342, PUT);
    }
    @Test
    public void test342_DELETE() throws Exception {
        assertCode(342, DELETE);
    }
    @Test
    public void test342_OPTIONS() throws Exception {
        assertCode(342, OPTIONS);
    }
    @Test
    public void test342_HEAD() throws Exception {
        assertCode(342, HEAD);
    }
    @Test
    public void test343_GET() throws Exception {
        assertCode(343, GET);
    }
    @Test
    public void test343_POST() throws Exception {
        assertCode(343, POST);
    }
    @Test
    public void test343_PUT() throws Exception {
        assertCode(343, PUT);
    }
    @Test
    public void test343_DELETE() throws Exception {
        assertCode(343, DELETE);
    }
    @Test
    public void test343_OPTIONS() throws Exception {
        assertCode(343, OPTIONS);
    }
    @Test
    public void test343_HEAD() throws Exception {
        assertCode(343, HEAD);
    }
    @Test
    public void test344_GET() throws Exception {
        assertCode(344, GET);
    }
    @Test
    public void test344_POST() throws Exception {
        assertCode(344, POST);
    }
    @Test
    public void test344_PUT() throws Exception {
        assertCode(344, PUT);
    }
    @Test
    public void test344_DELETE() throws Exception {
        assertCode(344, DELETE);
    }
    @Test
    public void test344_OPTIONS() throws Exception {
        assertCode(344, OPTIONS);
    }
    @Test
    public void test344_HEAD() throws Exception {
        assertCode(344, HEAD);
    }
    @Test
    public void test345_GET() throws Exception {
        assertCode(345, GET);
    }
    @Test
    public void test345_POST() throws Exception {
        assertCode(345, POST);
    }
    @Test
    public void test345_PUT() throws Exception {
        assertCode(345, PUT);
    }
    @Test
    public void test345_DELETE() throws Exception {
        assertCode(345, DELETE);
    }
    @Test
    public void test345_OPTIONS() throws Exception {
        assertCode(345, OPTIONS);
    }
    @Test
    public void test345_HEAD() throws Exception {
        assertCode(345, HEAD);
    }
    @Test
    public void test346_GET() throws Exception {
        assertCode(346, GET);
    }
    @Test
    public void test346_POST() throws Exception {
        assertCode(346, POST);
    }
    @Test
    public void test346_PUT() throws Exception {
        assertCode(346, PUT);
    }
    @Test
    public void test346_DELETE() throws Exception {
        assertCode(346, DELETE);
    }
    @Test
    public void test346_OPTIONS() throws Exception {
        assertCode(346, OPTIONS);
    }
    @Test
    public void test346_HEAD() throws Exception {
        assertCode(346, HEAD);
    }
    @Test
    public void test347_GET() throws Exception {
        assertCode(347, GET);
    }
    @Test
    public void test347_POST() throws Exception {
        assertCode(347, POST);
    }
    @Test
    public void test347_PUT() throws Exception {
        assertCode(347, PUT);
    }
    @Test
    public void test347_DELETE() throws Exception {
        assertCode(347, DELETE);
    }
    @Test
    public void test347_OPTIONS() throws Exception {
        assertCode(347, OPTIONS);
    }
    @Test
    public void test347_HEAD() throws Exception {
        assertCode(347, HEAD);
    }
    @Test
    public void test348_GET() throws Exception {
        assertCode(348, GET);
    }
    @Test
    public void test348_POST() throws Exception {
        assertCode(348, POST);
    }
    @Test
    public void test348_PUT() throws Exception {
        assertCode(348, PUT);
    }
    @Test
    public void test348_DELETE() throws Exception {
        assertCode(348, DELETE);
    }
    @Test
    public void test348_OPTIONS() throws Exception {
        assertCode(348, OPTIONS);
    }
    @Test
    public void test348_HEAD() throws Exception {
        assertCode(348, HEAD);
    }
    @Test
    public void test349_GET() throws Exception {
        assertCode(349, GET);
    }
    @Test
    public void test349_POST() throws Exception {
        assertCode(349, POST);
    }
    @Test
    public void test349_PUT() throws Exception {
        assertCode(349, PUT);
    }
    @Test
    public void test349_DELETE() throws Exception {
        assertCode(349, DELETE);
    }
    @Test
    public void test349_OPTIONS() throws Exception {
        assertCode(349, OPTIONS);
    }
    @Test
    public void test349_HEAD() throws Exception {
        assertCode(349, HEAD);
    }
    @Test
    public void test350_GET() throws Exception {
        assertCode(350, GET);
    }
    @Test
    public void test350_POST() throws Exception {
        assertCode(350, POST);
    }
    @Test
    public void test350_PUT() throws Exception {
        assertCode(350, PUT);
    }
    @Test
    public void test350_DELETE() throws Exception {
        assertCode(350, DELETE);
    }
    @Test
    public void test350_OPTIONS() throws Exception {
        assertCode(350, OPTIONS);
    }
    @Test
    public void test350_HEAD() throws Exception {
        assertCode(350, HEAD);
    }
    @Test
    public void test351_GET() throws Exception {
        assertCode(351, GET);
    }
    @Test
    public void test351_POST() throws Exception {
        assertCode(351, POST);
    }
    @Test
    public void test351_PUT() throws Exception {
        assertCode(351, PUT);
    }
    @Test
    public void test351_DELETE() throws Exception {
        assertCode(351, DELETE);
    }
    @Test
    public void test351_OPTIONS() throws Exception {
        assertCode(351, OPTIONS);
    }
    @Test
    public void test351_HEAD() throws Exception {
        assertCode(351, HEAD);
    }
    @Test
    public void test352_GET() throws Exception {
        assertCode(352, GET);
    }
    @Test
    public void test352_POST() throws Exception {
        assertCode(352, POST);
    }
    @Test
    public void test352_PUT() throws Exception {
        assertCode(352, PUT);
    }
    @Test
    public void test352_DELETE() throws Exception {
        assertCode(352, DELETE);
    }
    @Test
    public void test352_OPTIONS() throws Exception {
        assertCode(352, OPTIONS);
    }
    @Test
    public void test352_HEAD() throws Exception {
        assertCode(352, HEAD);
    }
    @Test
    public void test353_GET() throws Exception {
        assertCode(353, GET);
    }
    @Test
    public void test353_POST() throws Exception {
        assertCode(353, POST);
    }
    @Test
    public void test353_PUT() throws Exception {
        assertCode(353, PUT);
    }
    @Test
    public void test353_DELETE() throws Exception {
        assertCode(353, DELETE);
    }
    @Test
    public void test353_OPTIONS() throws Exception {
        assertCode(353, OPTIONS);
    }
    @Test
    public void test353_HEAD() throws Exception {
        assertCode(353, HEAD);
    }
    @Test
    public void test354_GET() throws Exception {
        assertCode(354, GET);
    }
    @Test
    public void test354_POST() throws Exception {
        assertCode(354, POST);
    }
    @Test
    public void test354_PUT() throws Exception {
        assertCode(354, PUT);
    }
    @Test
    public void test354_DELETE() throws Exception {
        assertCode(354, DELETE);
    }
    @Test
    public void test354_OPTIONS() throws Exception {
        assertCode(354, OPTIONS);
    }
    @Test
    public void test354_HEAD() throws Exception {
        assertCode(354, HEAD);
    }
    @Test
    public void test355_GET() throws Exception {
        assertCode(355, GET);
    }
    @Test
    public void test355_POST() throws Exception {
        assertCode(355, POST);
    }
    @Test
    public void test355_PUT() throws Exception {
        assertCode(355, PUT);
    }
    @Test
    public void test355_DELETE() throws Exception {
        assertCode(355, DELETE);
    }
    @Test
    public void test355_OPTIONS() throws Exception {
        assertCode(355, OPTIONS);
    }
    @Test
    public void test355_HEAD() throws Exception {
        assertCode(355, HEAD);
    }
    @Test
    public void test356_GET() throws Exception {
        assertCode(356, GET);
    }
    @Test
    public void test356_POST() throws Exception {
        assertCode(356, POST);
    }
    @Test
    public void test356_PUT() throws Exception {
        assertCode(356, PUT);
    }
    @Test
    public void test356_DELETE() throws Exception {
        assertCode(356, DELETE);
    }
    @Test
    public void test356_OPTIONS() throws Exception {
        assertCode(356, OPTIONS);
    }
    @Test
    public void test356_HEAD() throws Exception {
        assertCode(356, HEAD);
    }
    @Test
    public void test357_GET() throws Exception {
        assertCode(357, GET);
    }
    @Test
    public void test357_POST() throws Exception {
        assertCode(357, POST);
    }
    @Test
    public void test357_PUT() throws Exception {
        assertCode(357, PUT);
    }
    @Test
    public void test357_DELETE() throws Exception {
        assertCode(357, DELETE);
    }
    @Test
    public void test357_OPTIONS() throws Exception {
        assertCode(357, OPTIONS);
    }
    @Test
    public void test357_HEAD() throws Exception {
        assertCode(357, HEAD);
    }
    @Test
    public void test358_GET() throws Exception {
        assertCode(358, GET);
    }
    @Test
    public void test358_POST() throws Exception {
        assertCode(358, POST);
    }
    @Test
    public void test358_PUT() throws Exception {
        assertCode(358, PUT);
    }
    @Test
    public void test358_DELETE() throws Exception {
        assertCode(358, DELETE);
    }
    @Test
    public void test358_OPTIONS() throws Exception {
        assertCode(358, OPTIONS);
    }
    @Test
    public void test358_HEAD() throws Exception {
        assertCode(358, HEAD);
    }
    @Test
    public void test359_GET() throws Exception {
        assertCode(359, GET);
    }
    @Test
    public void test359_POST() throws Exception {
        assertCode(359, POST);
    }
    @Test
    public void test359_PUT() throws Exception {
        assertCode(359, PUT);
    }
    @Test
    public void test359_DELETE() throws Exception {
        assertCode(359, DELETE);
    }
    @Test
    public void test359_OPTIONS() throws Exception {
        assertCode(359, OPTIONS);
    }
    @Test
    public void test359_HEAD() throws Exception {
        assertCode(359, HEAD);
    }
    @Test
    public void test360_GET() throws Exception {
        assertCode(360, GET);
    }
    @Test
    public void test360_POST() throws Exception {
        assertCode(360, POST);
    }
    @Test
    public void test360_PUT() throws Exception {
        assertCode(360, PUT);
    }
    @Test
    public void test360_DELETE() throws Exception {
        assertCode(360, DELETE);
    }
    @Test
    public void test360_OPTIONS() throws Exception {
        assertCode(360, OPTIONS);
    }
    @Test
    public void test360_HEAD() throws Exception {
        assertCode(360, HEAD);
    }
    @Test
    public void test361_GET() throws Exception {
        assertCode(361, GET);
    }
    @Test
    public void test361_POST() throws Exception {
        assertCode(361, POST);
    }
    @Test
    public void test361_PUT() throws Exception {
        assertCode(361, PUT);
    }
    @Test
    public void test361_DELETE() throws Exception {
        assertCode(361, DELETE);
    }
    @Test
    public void test361_OPTIONS() throws Exception {
        assertCode(361, OPTIONS);
    }
    @Test
    public void test361_HEAD() throws Exception {
        assertCode(361, HEAD);
    }
    @Test
    public void test362_GET() throws Exception {
        assertCode(362, GET);
    }
    @Test
    public void test362_POST() throws Exception {
        assertCode(362, POST);
    }
    @Test
    public void test362_PUT() throws Exception {
        assertCode(362, PUT);
    }
    @Test
    public void test362_DELETE() throws Exception {
        assertCode(362, DELETE);
    }
    @Test
    public void test362_OPTIONS() throws Exception {
        assertCode(362, OPTIONS);
    }
    @Test
    public void test362_HEAD() throws Exception {
        assertCode(362, HEAD);
    }
    @Test
    public void test363_GET() throws Exception {
        assertCode(363, GET);
    }
    @Test
    public void test363_POST() throws Exception {
        assertCode(363, POST);
    }
    @Test
    public void test363_PUT() throws Exception {
        assertCode(363, PUT);
    }
    @Test
    public void test363_DELETE() throws Exception {
        assertCode(363, DELETE);
    }
    @Test
    public void test363_OPTIONS() throws Exception {
        assertCode(363, OPTIONS);
    }
    @Test
    public void test363_HEAD() throws Exception {
        assertCode(363, HEAD);
    }
    @Test
    public void test364_GET() throws Exception {
        assertCode(364, GET);
    }
    @Test
    public void test364_POST() throws Exception {
        assertCode(364, POST);
    }
    @Test
    public void test364_PUT() throws Exception {
        assertCode(364, PUT);
    }
    @Test
    public void test364_DELETE() throws Exception {
        assertCode(364, DELETE);
    }
    @Test
    public void test364_OPTIONS() throws Exception {
        assertCode(364, OPTIONS);
    }
    @Test
    public void test364_HEAD() throws Exception {
        assertCode(364, HEAD);
    }
    @Test
    public void test365_GET() throws Exception {
        assertCode(365, GET);
    }
    @Test
    public void test365_POST() throws Exception {
        assertCode(365, POST);
    }
    @Test
    public void test365_PUT() throws Exception {
        assertCode(365, PUT);
    }
    @Test
    public void test365_DELETE() throws Exception {
        assertCode(365, DELETE);
    }
    @Test
    public void test365_OPTIONS() throws Exception {
        assertCode(365, OPTIONS);
    }
    @Test
    public void test365_HEAD() throws Exception {
        assertCode(365, HEAD);
    }
    @Test
    public void test366_GET() throws Exception {
        assertCode(366, GET);
    }
    @Test
    public void test366_POST() throws Exception {
        assertCode(366, POST);
    }
    @Test
    public void test366_PUT() throws Exception {
        assertCode(366, PUT);
    }
    @Test
    public void test366_DELETE() throws Exception {
        assertCode(366, DELETE);
    }
    @Test
    public void test366_OPTIONS() throws Exception {
        assertCode(366, OPTIONS);
    }
    @Test
    public void test366_HEAD() throws Exception {
        assertCode(366, HEAD);
    }
    @Test
    public void test367_GET() throws Exception {
        assertCode(367, GET);
    }
    @Test
    public void test367_POST() throws Exception {
        assertCode(367, POST);
    }
    @Test
    public void test367_PUT() throws Exception {
        assertCode(367, PUT);
    }
    @Test
    public void test367_DELETE() throws Exception {
        assertCode(367, DELETE);
    }
    @Test
    public void test367_OPTIONS() throws Exception {
        assertCode(367, OPTIONS);
    }
    @Test
    public void test367_HEAD() throws Exception {
        assertCode(367, HEAD);
    }
    @Test
    public void test368_GET() throws Exception {
        assertCode(368, GET);
    }
    @Test
    public void test368_POST() throws Exception {
        assertCode(368, POST);
    }
    @Test
    public void test368_PUT() throws Exception {
        assertCode(368, PUT);
    }
    @Test
    public void test368_DELETE() throws Exception {
        assertCode(368, DELETE);
    }
    @Test
    public void test368_OPTIONS() throws Exception {
        assertCode(368, OPTIONS);
    }
    @Test
    public void test368_HEAD() throws Exception {
        assertCode(368, HEAD);
    }
    @Test
    public void test369_GET() throws Exception {
        assertCode(369, GET);
    }
    @Test
    public void test369_POST() throws Exception {
        assertCode(369, POST);
    }
    @Test
    public void test369_PUT() throws Exception {
        assertCode(369, PUT);
    }
    @Test
    public void test369_DELETE() throws Exception {
        assertCode(369, DELETE);
    }
    @Test
    public void test369_OPTIONS() throws Exception {
        assertCode(369, OPTIONS);
    }
    @Test
    public void test369_HEAD() throws Exception {
        assertCode(369, HEAD);
    }
    @Test
    public void test370_GET() throws Exception {
        assertCode(370, GET);
    }
    @Test
    public void test370_POST() throws Exception {
        assertCode(370, POST);
    }
    @Test
    public void test370_PUT() throws Exception {
        assertCode(370, PUT);
    }
    @Test
    public void test370_DELETE() throws Exception {
        assertCode(370, DELETE);
    }
    @Test
    public void test370_OPTIONS() throws Exception {
        assertCode(370, OPTIONS);
    }
    @Test
    public void test370_HEAD() throws Exception {
        assertCode(370, HEAD);
    }
    @Test
    public void test371_GET() throws Exception {
        assertCode(371, GET);
    }
    @Test
    public void test371_POST() throws Exception {
        assertCode(371, POST);
    }
    @Test
    public void test371_PUT() throws Exception {
        assertCode(371, PUT);
    }
    @Test
    public void test371_DELETE() throws Exception {
        assertCode(371, DELETE);
    }
    @Test
    public void test371_OPTIONS() throws Exception {
        assertCode(371, OPTIONS);
    }
    @Test
    public void test371_HEAD() throws Exception {
        assertCode(371, HEAD);
    }
    @Test
    public void test372_GET() throws Exception {
        assertCode(372, GET);
    }
    @Test
    public void test372_POST() throws Exception {
        assertCode(372, POST);
    }
    @Test
    public void test372_PUT() throws Exception {
        assertCode(372, PUT);
    }
    @Test
    public void test372_DELETE() throws Exception {
        assertCode(372, DELETE);
    }
    @Test
    public void test372_OPTIONS() throws Exception {
        assertCode(372, OPTIONS);
    }
    @Test
    public void test372_HEAD() throws Exception {
        assertCode(372, HEAD);
    }
    @Test
    public void test373_GET() throws Exception {
        assertCode(373, GET);
    }
    @Test
    public void test373_POST() throws Exception {
        assertCode(373, POST);
    }
    @Test
    public void test373_PUT() throws Exception {
        assertCode(373, PUT);
    }
    @Test
    public void test373_DELETE() throws Exception {
        assertCode(373, DELETE);
    }
    @Test
    public void test373_OPTIONS() throws Exception {
        assertCode(373, OPTIONS);
    }
    @Test
    public void test373_HEAD() throws Exception {
        assertCode(373, HEAD);
    }
    @Test
    public void test374_GET() throws Exception {
        assertCode(374, GET);
    }
    @Test
    public void test374_POST() throws Exception {
        assertCode(374, POST);
    }
    @Test
    public void test374_PUT() throws Exception {
        assertCode(374, PUT);
    }
    @Test
    public void test374_DELETE() throws Exception {
        assertCode(374, DELETE);
    }
    @Test
    public void test374_OPTIONS() throws Exception {
        assertCode(374, OPTIONS);
    }
    @Test
    public void test374_HEAD() throws Exception {
        assertCode(374, HEAD);
    }
    @Test
    public void test375_GET() throws Exception {
        assertCode(375, GET);
    }
    @Test
    public void test375_POST() throws Exception {
        assertCode(375, POST);
    }
    @Test
    public void test375_PUT() throws Exception {
        assertCode(375, PUT);
    }
    @Test
    public void test375_DELETE() throws Exception {
        assertCode(375, DELETE);
    }
    @Test
    public void test375_OPTIONS() throws Exception {
        assertCode(375, OPTIONS);
    }
    @Test
    public void test375_HEAD() throws Exception {
        assertCode(375, HEAD);
    }
    @Test
    public void test376_GET() throws Exception {
        assertCode(376, GET);
    }
    @Test
    public void test376_POST() throws Exception {
        assertCode(376, POST);
    }
    @Test
    public void test376_PUT() throws Exception {
        assertCode(376, PUT);
    }
    @Test
    public void test376_DELETE() throws Exception {
        assertCode(376, DELETE);
    }
    @Test
    public void test376_OPTIONS() throws Exception {
        assertCode(376, OPTIONS);
    }
    @Test
    public void test376_HEAD() throws Exception {
        assertCode(376, HEAD);
    }
    @Test
    public void test377_GET() throws Exception {
        assertCode(377, GET);
    }
    @Test
    public void test377_POST() throws Exception {
        assertCode(377, POST);
    }
    @Test
    public void test377_PUT() throws Exception {
        assertCode(377, PUT);
    }
    @Test
    public void test377_DELETE() throws Exception {
        assertCode(377, DELETE);
    }
    @Test
    public void test377_OPTIONS() throws Exception {
        assertCode(377, OPTIONS);
    }
    @Test
    public void test377_HEAD() throws Exception {
        assertCode(377, HEAD);
    }
    @Test
    public void test378_GET() throws Exception {
        assertCode(378, GET);
    }
    @Test
    public void test378_POST() throws Exception {
        assertCode(378, POST);
    }
    @Test
    public void test378_PUT() throws Exception {
        assertCode(378, PUT);
    }
    @Test
    public void test378_DELETE() throws Exception {
        assertCode(378, DELETE);
    }
    @Test
    public void test378_OPTIONS() throws Exception {
        assertCode(378, OPTIONS);
    }
    @Test
    public void test378_HEAD() throws Exception {
        assertCode(378, HEAD);
    }
    @Test
    public void test379_GET() throws Exception {
        assertCode(379, GET);
    }
    @Test
    public void test379_POST() throws Exception {
        assertCode(379, POST);
    }
    @Test
    public void test379_PUT() throws Exception {
        assertCode(379, PUT);
    }
    @Test
    public void test379_DELETE() throws Exception {
        assertCode(379, DELETE);
    }
    @Test
    public void test379_OPTIONS() throws Exception {
        assertCode(379, OPTIONS);
    }
    @Test
    public void test379_HEAD() throws Exception {
        assertCode(379, HEAD);
    }
    @Test
    public void test380_GET() throws Exception {
        assertCode(380, GET);
    }
    @Test
    public void test380_POST() throws Exception {
        assertCode(380, POST);
    }
    @Test
    public void test380_PUT() throws Exception {
        assertCode(380, PUT);
    }
    @Test
    public void test380_DELETE() throws Exception {
        assertCode(380, DELETE);
    }
    @Test
    public void test380_OPTIONS() throws Exception {
        assertCode(380, OPTIONS);
    }
    @Test
    public void test380_HEAD() throws Exception {
        assertCode(380, HEAD);
    }
    @Test
    public void test381_GET() throws Exception {
        assertCode(381, GET);
    }
    @Test
    public void test381_POST() throws Exception {
        assertCode(381, POST);
    }
    @Test
    public void test381_PUT() throws Exception {
        assertCode(381, PUT);
    }
    @Test
    public void test381_DELETE() throws Exception {
        assertCode(381, DELETE);
    }
    @Test
    public void test381_OPTIONS() throws Exception {
        assertCode(381, OPTIONS);
    }
    @Test
    public void test381_HEAD() throws Exception {
        assertCode(381, HEAD);
    }
    @Test
    public void test382_GET() throws Exception {
        assertCode(382, GET);
    }
    @Test
    public void test382_POST() throws Exception {
        assertCode(382, POST);
    }
    @Test
    public void test382_PUT() throws Exception {
        assertCode(382, PUT);
    }
    @Test
    public void test382_DELETE() throws Exception {
        assertCode(382, DELETE);
    }
    @Test
    public void test382_OPTIONS() throws Exception {
        assertCode(382, OPTIONS);
    }
    @Test
    public void test382_HEAD() throws Exception {
        assertCode(382, HEAD);
    }
    @Test
    public void test383_GET() throws Exception {
        assertCode(383, GET);
    }
    @Test
    public void test383_POST() throws Exception {
        assertCode(383, POST);
    }
    @Test
    public void test383_PUT() throws Exception {
        assertCode(383, PUT);
    }
    @Test
    public void test383_DELETE() throws Exception {
        assertCode(383, DELETE);
    }
    @Test
    public void test383_OPTIONS() throws Exception {
        assertCode(383, OPTIONS);
    }
    @Test
    public void test383_HEAD() throws Exception {
        assertCode(383, HEAD);
    }
    @Test
    public void test384_GET() throws Exception {
        assertCode(384, GET);
    }
    @Test
    public void test384_POST() throws Exception {
        assertCode(384, POST);
    }
    @Test
    public void test384_PUT() throws Exception {
        assertCode(384, PUT);
    }
    @Test
    public void test384_DELETE() throws Exception {
        assertCode(384, DELETE);
    }
    @Test
    public void test384_OPTIONS() throws Exception {
        assertCode(384, OPTIONS);
    }
    @Test
    public void test384_HEAD() throws Exception {
        assertCode(384, HEAD);
    }
    @Test
    public void test385_GET() throws Exception {
        assertCode(385, GET);
    }
    @Test
    public void test385_POST() throws Exception {
        assertCode(385, POST);
    }
    @Test
    public void test385_PUT() throws Exception {
        assertCode(385, PUT);
    }
    @Test
    public void test385_DELETE() throws Exception {
        assertCode(385, DELETE);
    }
    @Test
    public void test385_OPTIONS() throws Exception {
        assertCode(385, OPTIONS);
    }
    @Test
    public void test385_HEAD() throws Exception {
        assertCode(385, HEAD);
    }
    @Test
    public void test386_GET() throws Exception {
        assertCode(386, GET);
    }
    @Test
    public void test386_POST() throws Exception {
        assertCode(386, POST);
    }
    @Test
    public void test386_PUT() throws Exception {
        assertCode(386, PUT);
    }
    @Test
    public void test386_DELETE() throws Exception {
        assertCode(386, DELETE);
    }
    @Test
    public void test386_OPTIONS() throws Exception {
        assertCode(386, OPTIONS);
    }
    @Test
    public void test386_HEAD() throws Exception {
        assertCode(386, HEAD);
    }
    @Test
    public void test387_GET() throws Exception {
        assertCode(387, GET);
    }
    @Test
    public void test387_POST() throws Exception {
        assertCode(387, POST);
    }
    @Test
    public void test387_PUT() throws Exception {
        assertCode(387, PUT);
    }
    @Test
    public void test387_DELETE() throws Exception {
        assertCode(387, DELETE);
    }
    @Test
    public void test387_OPTIONS() throws Exception {
        assertCode(387, OPTIONS);
    }
    @Test
    public void test387_HEAD() throws Exception {
        assertCode(387, HEAD);
    }
    @Test
    public void test388_GET() throws Exception {
        assertCode(388, GET);
    }
    @Test
    public void test388_POST() throws Exception {
        assertCode(388, POST);
    }
    @Test
    public void test388_PUT() throws Exception {
        assertCode(388, PUT);
    }
    @Test
    public void test388_DELETE() throws Exception {
        assertCode(388, DELETE);
    }
    @Test
    public void test388_OPTIONS() throws Exception {
        assertCode(388, OPTIONS);
    }
    @Test
    public void test388_HEAD() throws Exception {
        assertCode(388, HEAD);
    }
    @Test
    public void test389_GET() throws Exception {
        assertCode(389, GET);
    }
    @Test
    public void test389_POST() throws Exception {
        assertCode(389, POST);
    }
    @Test
    public void test389_PUT() throws Exception {
        assertCode(389, PUT);
    }
    @Test
    public void test389_DELETE() throws Exception {
        assertCode(389, DELETE);
    }
    @Test
    public void test389_OPTIONS() throws Exception {
        assertCode(389, OPTIONS);
    }
    @Test
    public void test389_HEAD() throws Exception {
        assertCode(389, HEAD);
    }
    @Test
    public void test390_GET() throws Exception {
        assertCode(390, GET);
    }
    @Test
    public void test390_POST() throws Exception {
        assertCode(390, POST);
    }
    @Test
    public void test390_PUT() throws Exception {
        assertCode(390, PUT);
    }
    @Test
    public void test390_DELETE() throws Exception {
        assertCode(390, DELETE);
    }
    @Test
    public void test390_OPTIONS() throws Exception {
        assertCode(390, OPTIONS);
    }
    @Test
    public void test390_HEAD() throws Exception {
        assertCode(390, HEAD);
    }
    @Test
    public void test391_GET() throws Exception {
        assertCode(391, GET);
    }
    @Test
    public void test391_POST() throws Exception {
        assertCode(391, POST);
    }
    @Test
    public void test391_PUT() throws Exception {
        assertCode(391, PUT);
    }
    @Test
    public void test391_DELETE() throws Exception {
        assertCode(391, DELETE);
    }
    @Test
    public void test391_OPTIONS() throws Exception {
        assertCode(391, OPTIONS);
    }
    @Test
    public void test391_HEAD() throws Exception {
        assertCode(391, HEAD);
    }
    @Test
    public void test392_GET() throws Exception {
        assertCode(392, GET);
    }
    @Test
    public void test392_POST() throws Exception {
        assertCode(392, POST);
    }
    @Test
    public void test392_PUT() throws Exception {
        assertCode(392, PUT);
    }
    @Test
    public void test392_DELETE() throws Exception {
        assertCode(392, DELETE);
    }
    @Test
    public void test392_OPTIONS() throws Exception {
        assertCode(392, OPTIONS);
    }
    @Test
    public void test392_HEAD() throws Exception {
        assertCode(392, HEAD);
    }
    @Test
    public void test393_GET() throws Exception {
        assertCode(393, GET);
    }
    @Test
    public void test393_POST() throws Exception {
        assertCode(393, POST);
    }
    @Test
    public void test393_PUT() throws Exception {
        assertCode(393, PUT);
    }
    @Test
    public void test393_DELETE() throws Exception {
        assertCode(393, DELETE);
    }
    @Test
    public void test393_OPTIONS() throws Exception {
        assertCode(393, OPTIONS);
    }
    @Test
    public void test393_HEAD() throws Exception {
        assertCode(393, HEAD);
    }
    @Test
    public void test394_GET() throws Exception {
        assertCode(394, GET);
    }
    @Test
    public void test394_POST() throws Exception {
        assertCode(394, POST);
    }
    @Test
    public void test394_PUT() throws Exception {
        assertCode(394, PUT);
    }
    @Test
    public void test394_DELETE() throws Exception {
        assertCode(394, DELETE);
    }
    @Test
    public void test394_OPTIONS() throws Exception {
        assertCode(394, OPTIONS);
    }
    @Test
    public void test394_HEAD() throws Exception {
        assertCode(394, HEAD);
    }
    @Test
    public void test395_GET() throws Exception {
        assertCode(395, GET);
    }
    @Test
    public void test395_POST() throws Exception {
        assertCode(395, POST);
    }
    @Test
    public void test395_PUT() throws Exception {
        assertCode(395, PUT);
    }
    @Test
    public void test395_DELETE() throws Exception {
        assertCode(395, DELETE);
    }
    @Test
    public void test395_OPTIONS() throws Exception {
        assertCode(395, OPTIONS);
    }
    @Test
    public void test395_HEAD() throws Exception {
        assertCode(395, HEAD);
    }
    @Test
    public void test396_GET() throws Exception {
        assertCode(396, GET);
    }
    @Test
    public void test396_POST() throws Exception {
        assertCode(396, POST);
    }
    @Test
    public void test396_PUT() throws Exception {
        assertCode(396, PUT);
    }
    @Test
    public void test396_DELETE() throws Exception {
        assertCode(396, DELETE);
    }
    @Test
    public void test396_OPTIONS() throws Exception {
        assertCode(396, OPTIONS);
    }
    @Test
    public void test396_HEAD() throws Exception {
        assertCode(396, HEAD);
    }
    @Test
    public void test397_GET() throws Exception {
        assertCode(397, GET);
    }
    @Test
    public void test397_POST() throws Exception {
        assertCode(397, POST);
    }
    @Test
    public void test397_PUT() throws Exception {
        assertCode(397, PUT);
    }
    @Test
    public void test397_DELETE() throws Exception {
        assertCode(397, DELETE);
    }
    @Test
    public void test397_OPTIONS() throws Exception {
        assertCode(397, OPTIONS);
    }
    @Test
    public void test397_HEAD() throws Exception {
        assertCode(397, HEAD);
    }
    @Test
    public void test398_GET() throws Exception {
        assertCode(398, GET);
    }
    @Test
    public void test398_POST() throws Exception {
        assertCode(398, POST);
    }
    @Test
    public void test398_PUT() throws Exception {
        assertCode(398, PUT);
    }
    @Test
    public void test398_DELETE() throws Exception {
        assertCode(398, DELETE);
    }
    @Test
    public void test398_OPTIONS() throws Exception {
        assertCode(398, OPTIONS);
    }
    @Test
    public void test398_HEAD() throws Exception {
        assertCode(398, HEAD);
    }
    @Test
    public void test399_GET() throws Exception {
        assertCode(399, GET);
    }
    @Test
    public void test399_POST() throws Exception {
        assertCode(399, POST);
    }
    @Test
    public void test399_PUT() throws Exception {
        assertCode(399, PUT);
    }
    @Test
    public void test399_DELETE() throws Exception {
        assertCode(399, DELETE);
    }
    @Test
    public void test399_OPTIONS() throws Exception {
        assertCode(399, OPTIONS);
    }
    @Test
    public void test399_HEAD() throws Exception {
        assertCode(399, HEAD);
    }
    @Test
    public void test400_GET() throws Exception {
        assertCode(400, GET);
    }
    @Test
    public void test400_POST() throws Exception {
        assertCode(400, POST);
    }
    @Test
    public void test400_PUT() throws Exception {
        assertCode(400, PUT);
    }
    @Test
    public void test400_DELETE() throws Exception {
        assertCode(400, DELETE);
    }
    @Test
    public void test400_OPTIONS() throws Exception {
        assertCode(400, OPTIONS);
    }
    @Test
    public void test400_HEAD() throws Exception {
        assertCode(400, HEAD);
    }
    @Test
    public void test401_GET() throws Exception {
        assertCode(401, GET);
    }
    @Test
    public void test401_POST() throws Exception {
        assertCode(401, POST);
    }
    @Test
    public void test401_PUT() throws Exception {
        assertCode(401, PUT);
    }
    @Test
    public void test401_DELETE() throws Exception {
        assertCode(401, DELETE);
    }
    @Test
    public void test401_OPTIONS() throws Exception {
        assertCode(401, OPTIONS);
    }
    @Test
    public void test401_HEAD() throws Exception {
        assertCode(401, HEAD);
    }
    @Test
    public void test402_GET() throws Exception {
        assertCode(402, GET);
    }
    @Test
    public void test402_POST() throws Exception {
        assertCode(402, POST);
    }
    @Test
    public void test402_PUT() throws Exception {
        assertCode(402, PUT);
    }
    @Test
    public void test402_DELETE() throws Exception {
        assertCode(402, DELETE);
    }
    @Test
    public void test402_OPTIONS() throws Exception {
        assertCode(402, OPTIONS);
    }
    @Test
    public void test402_HEAD() throws Exception {
        assertCode(402, HEAD);
    }
    @Test
    public void test403_GET() throws Exception {
        assertCode(403, GET);
    }
    @Test
    public void test403_POST() throws Exception {
        assertCode(403, POST);
    }
    @Test
    public void test403_PUT() throws Exception {
        assertCode(403, PUT);
    }
    @Test
    public void test403_DELETE() throws Exception {
        assertCode(403, DELETE);
    }
    @Test
    public void test403_OPTIONS() throws Exception {
        assertCode(403, OPTIONS);
    }
    @Test
    public void test403_HEAD() throws Exception {
        assertCode(403, HEAD);
    }
    @Test
    public void test404_GET() throws Exception {
        assertCode(404, GET);
    }
    @Test
    public void test404_POST() throws Exception {
        assertCode(404, POST);
    }
    @Test
    public void test404_PUT() throws Exception {
        assertCode(404, PUT);
    }
    @Test
    public void test404_DELETE() throws Exception {
        assertCode(404, DELETE);
    }
    @Test
    public void test404_OPTIONS() throws Exception {
        assertCode(404, OPTIONS);
    }
    @Test
    public void test404_HEAD() throws Exception {
        assertCode(404, HEAD);
    }
    @Test
    public void test405_GET() throws Exception {
        assertCode(405, GET);
    }
    @Test
    public void test405_POST() throws Exception {
        assertCode(405, POST);
    }
    @Test
    public void test405_PUT() throws Exception {
        assertCode(405, PUT);
    }
    @Test
    public void test405_DELETE() throws Exception {
        assertCode(405, DELETE);
    }
    @Test
    public void test405_OPTIONS() throws Exception {
        assertCode(405, OPTIONS);
    }
    @Test
    public void test405_HEAD() throws Exception {
        assertCode(405, HEAD);
    }
    @Test
    public void test406_GET() throws Exception {
        assertCode(406, GET);
    }
    @Test
    public void test406_POST() throws Exception {
        assertCode(406, POST);
    }
    @Test
    public void test406_PUT() throws Exception {
        assertCode(406, PUT);
    }
    @Test
    public void test406_DELETE() throws Exception {
        assertCode(406, DELETE);
    }
    @Test
    public void test406_OPTIONS() throws Exception {
        assertCode(406, OPTIONS);
    }
    @Test
    public void test406_HEAD() throws Exception {
        assertCode(406, HEAD);
    }
    @Test
    public void test407_GET() throws Exception {
        assertCode(407, GET);
    }
    @Test
    public void test407_POST() throws Exception {
        assertCode(407, POST);
    }
    @Test
    public void test407_PUT() throws Exception {
        assertCode(407, PUT);
    }
    @Test
    public void test407_DELETE() throws Exception {
        assertCode(407, DELETE);
    }
    @Test
    public void test407_OPTIONS() throws Exception {
        assertCode(407, OPTIONS);
    }
    @Test
    public void test407_HEAD() throws Exception {
        assertCode(407, HEAD);
    }
    @Test
    public void test408_GET() throws Exception {
        assertCode(408, GET);
    }
    @Test
    public void test408_POST() throws Exception {
        assertCode(408, POST);
    }
    @Test
    public void test408_PUT() throws Exception {
        assertCode(408, PUT);
    }
    @Test
    public void test408_DELETE() throws Exception {
        assertCode(408, DELETE);
    }
    @Test
    public void test408_OPTIONS() throws Exception {
        assertCode(408, OPTIONS);
    }
    @Test
    public void test408_HEAD() throws Exception {
        assertCode(408, HEAD);
    }
    @Test
    public void test409_GET() throws Exception {
        assertCode(409, GET);
    }
    @Test
    public void test409_POST() throws Exception {
        assertCode(409, POST);
    }
    @Test
    public void test409_PUT() throws Exception {
        assertCode(409, PUT);
    }
    @Test
    public void test409_DELETE() throws Exception {
        assertCode(409, DELETE);
    }
    @Test
    public void test409_OPTIONS() throws Exception {
        assertCode(409, OPTIONS);
    }
    @Test
    public void test409_HEAD() throws Exception {
        assertCode(409, HEAD);
    }
    @Test
    public void test410_GET() throws Exception {
        assertCode(410, GET);
    }
    @Test
    public void test410_POST() throws Exception {
        assertCode(410, POST);
    }
    @Test
    public void test410_PUT() throws Exception {
        assertCode(410, PUT);
    }
    @Test
    public void test410_DELETE() throws Exception {
        assertCode(410, DELETE);
    }
    @Test
    public void test410_OPTIONS() throws Exception {
        assertCode(410, OPTIONS);
    }
    @Test
    public void test410_HEAD() throws Exception {
        assertCode(410, HEAD);
    }
    @Test
    public void test411_GET() throws Exception {
        assertCode(411, GET);
    }
    @Test
    public void test411_POST() throws Exception {
        assertCode(411, POST);
    }
    @Test
    public void test411_PUT() throws Exception {
        assertCode(411, PUT);
    }
    @Test
    public void test411_DELETE() throws Exception {
        assertCode(411, DELETE);
    }
    @Test
    public void test411_OPTIONS() throws Exception {
        assertCode(411, OPTIONS);
    }
    @Test
    public void test411_HEAD() throws Exception {
        assertCode(411, HEAD);
    }
    @Test
    public void test412_GET() throws Exception {
        assertCode(412, GET);
    }
    @Test
    public void test412_POST() throws Exception {
        assertCode(412, POST);
    }
    @Test
    public void test412_PUT() throws Exception {
        assertCode(412, PUT);
    }
    @Test
    public void test412_DELETE() throws Exception {
        assertCode(412, DELETE);
    }
    @Test
    public void test412_OPTIONS() throws Exception {
        assertCode(412, OPTIONS);
    }
    @Test
    public void test412_HEAD() throws Exception {
        assertCode(412, HEAD);
    }
    @Test
    public void test413_GET() throws Exception {
        assertCode(413, GET);
    }
    @Test
    public void test413_POST() throws Exception {
        assertCode(413, POST);
    }
    @Test
    public void test413_PUT() throws Exception {
        assertCode(413, PUT);
    }
    @Test
    public void test413_DELETE() throws Exception {
        assertCode(413, DELETE);
    }
    @Test
    public void test413_OPTIONS() throws Exception {
        assertCode(413, OPTIONS);
    }
    @Test
    public void test413_HEAD() throws Exception {
        assertCode(413, HEAD);
    }
    @Test
    public void test414_GET() throws Exception {
        assertCode(414, GET);
    }
    @Test
    public void test414_POST() throws Exception {
        assertCode(414, POST);
    }
    @Test
    public void test414_PUT() throws Exception {
        assertCode(414, PUT);
    }
    @Test
    public void test414_DELETE() throws Exception {
        assertCode(414, DELETE);
    }
    @Test
    public void test414_OPTIONS() throws Exception {
        assertCode(414, OPTIONS);
    }
    @Test
    public void test414_HEAD() throws Exception {
        assertCode(414, HEAD);
    }
    @Test
    public void test415_GET() throws Exception {
        assertCode(415, GET);
    }
    @Test
    public void test415_POST() throws Exception {
        assertCode(415, POST);
    }
    @Test
    public void test415_PUT() throws Exception {
        assertCode(415, PUT);
    }
    @Test
    public void test415_DELETE() throws Exception {
        assertCode(415, DELETE);
    }
    @Test
    public void test415_OPTIONS() throws Exception {
        assertCode(415, OPTIONS);
    }
    @Test
    public void test415_HEAD() throws Exception {
        assertCode(415, HEAD);
    }
    @Test
    public void test416_GET() throws Exception {
        assertCode(416, GET);
    }
    @Test
    public void test416_POST() throws Exception {
        assertCode(416, POST);
    }
    @Test
    public void test416_PUT() throws Exception {
        assertCode(416, PUT);
    }
    @Test
    public void test416_DELETE() throws Exception {
        assertCode(416, DELETE);
    }
    @Test
    public void test416_OPTIONS() throws Exception {
        assertCode(416, OPTIONS);
    }
    @Test
    public void test416_HEAD() throws Exception {
        assertCode(416, HEAD);
    }
    @Test
    public void test417_GET() throws Exception {
        assertCode(417, GET);
    }
    @Test
    public void test417_POST() throws Exception {
        assertCode(417, POST);
    }
    @Test
    public void test417_PUT() throws Exception {
        assertCode(417, PUT);
    }
    @Test
    public void test417_DELETE() throws Exception {
        assertCode(417, DELETE);
    }
    @Test
    public void test417_OPTIONS() throws Exception {
        assertCode(417, OPTIONS);
    }
    @Test
    public void test417_HEAD() throws Exception {
        assertCode(417, HEAD);
    }
    @Test
    public void test418_GET() throws Exception {
        assertCode(418, GET);
    }
    @Test
    public void test418_POST() throws Exception {
        assertCode(418, POST);
    }
    @Test
    public void test418_PUT() throws Exception {
        assertCode(418, PUT);
    }
    @Test
    public void test418_DELETE() throws Exception {
        assertCode(418, DELETE);
    }
    @Test
    public void test418_OPTIONS() throws Exception {
        assertCode(418, OPTIONS);
    }
    @Test
    public void test418_HEAD() throws Exception {
        assertCode(418, HEAD);
    }
    @Test
    public void test419_GET() throws Exception {
        assertCode(419, GET);
    }
    @Test
    public void test419_POST() throws Exception {
        assertCode(419, POST);
    }
    @Test
    public void test419_PUT() throws Exception {
        assertCode(419, PUT);
    }
    @Test
    public void test419_DELETE() throws Exception {
        assertCode(419, DELETE);
    }
    @Test
    public void test419_OPTIONS() throws Exception {
        assertCode(419, OPTIONS);
    }
    @Test
    public void test419_HEAD() throws Exception {
        assertCode(419, HEAD);
    }
    @Test
    public void test420_GET() throws Exception {
        assertCode(420, GET);
    }
    @Test
    public void test420_POST() throws Exception {
        assertCode(420, POST);
    }
    @Test
    public void test420_PUT() throws Exception {
        assertCode(420, PUT);
    }
    @Test
    public void test420_DELETE() throws Exception {
        assertCode(420, DELETE);
    }
    @Test
    public void test420_OPTIONS() throws Exception {
        assertCode(420, OPTIONS);
    }
    @Test
    public void test420_HEAD() throws Exception {
        assertCode(420, HEAD);
    }
    @Test
    public void test421_GET() throws Exception {
        assertCode(421, GET);
    }
    @Test
    public void test421_POST() throws Exception {
        assertCode(421, POST);
    }
    @Test
    public void test421_PUT() throws Exception {
        assertCode(421, PUT);
    }
    @Test
    public void test421_DELETE() throws Exception {
        assertCode(421, DELETE);
    }
    @Test
    public void test421_OPTIONS() throws Exception {
        assertCode(421, OPTIONS);
    }
    @Test
    public void test421_HEAD() throws Exception {
        assertCode(421, HEAD);
    }
    @Test
    public void test422_GET() throws Exception {
        assertCode(422, GET);
    }
    @Test
    public void test422_POST() throws Exception {
        assertCode(422, POST);
    }
    @Test
    public void test422_PUT() throws Exception {
        assertCode(422, PUT);
    }
    @Test
    public void test422_DELETE() throws Exception {
        assertCode(422, DELETE);
    }
    @Test
    public void test422_OPTIONS() throws Exception {
        assertCode(422, OPTIONS);
    }
    @Test
    public void test422_HEAD() throws Exception {
        assertCode(422, HEAD);
    }
    @Test
    public void test423_GET() throws Exception {
        assertCode(423, GET);
    }
    @Test
    public void test423_POST() throws Exception {
        assertCode(423, POST);
    }
    @Test
    public void test423_PUT() throws Exception {
        assertCode(423, PUT);
    }
    @Test
    public void test423_DELETE() throws Exception {
        assertCode(423, DELETE);
    }
    @Test
    public void test423_OPTIONS() throws Exception {
        assertCode(423, OPTIONS);
    }
    @Test
    public void test423_HEAD() throws Exception {
        assertCode(423, HEAD);
    }
    @Test
    public void test424_GET() throws Exception {
        assertCode(424, GET);
    }
    @Test
    public void test424_POST() throws Exception {
        assertCode(424, POST);
    }
    @Test
    public void test424_PUT() throws Exception {
        assertCode(424, PUT);
    }
    @Test
    public void test424_DELETE() throws Exception {
        assertCode(424, DELETE);
    }
    @Test
    public void test424_OPTIONS() throws Exception {
        assertCode(424, OPTIONS);
    }
    @Test
    public void test424_HEAD() throws Exception {
        assertCode(424, HEAD);
    }
    @Test
    public void test425_GET() throws Exception {
        assertCode(425, GET);
    }
    @Test
    public void test425_POST() throws Exception {
        assertCode(425, POST);
    }
    @Test
    public void test425_PUT() throws Exception {
        assertCode(425, PUT);
    }
    @Test
    public void test425_DELETE() throws Exception {
        assertCode(425, DELETE);
    }
    @Test
    public void test425_OPTIONS() throws Exception {
        assertCode(425, OPTIONS);
    }
    @Test
    public void test425_HEAD() throws Exception {
        assertCode(425, HEAD);
    }
    @Test
    public void test426_GET() throws Exception {
        assertCode(426, GET);
    }
    @Test
    public void test426_POST() throws Exception {
        assertCode(426, POST);
    }
    @Test
    public void test426_PUT() throws Exception {
        assertCode(426, PUT);
    }
    @Test
    public void test426_DELETE() throws Exception {
        assertCode(426, DELETE);
    }
    @Test
    public void test426_OPTIONS() throws Exception {
        assertCode(426, OPTIONS);
    }
    @Test
    public void test426_HEAD() throws Exception {
        assertCode(426, HEAD);
    }
    @Test
    public void test427_GET() throws Exception {
        assertCode(427, GET);
    }
    @Test
    public void test427_POST() throws Exception {
        assertCode(427, POST);
    }
    @Test
    public void test427_PUT() throws Exception {
        assertCode(427, PUT);
    }
    @Test
    public void test427_DELETE() throws Exception {
        assertCode(427, DELETE);
    }
    @Test
    public void test427_OPTIONS() throws Exception {
        assertCode(427, OPTIONS);
    }
    @Test
    public void test427_HEAD() throws Exception {
        assertCode(427, HEAD);
    }
    @Test
    public void test428_GET() throws Exception {
        assertCode(428, GET);
    }
    @Test
    public void test428_POST() throws Exception {
        assertCode(428, POST);
    }
    @Test
    public void test428_PUT() throws Exception {
        assertCode(428, PUT);
    }
    @Test
    public void test428_DELETE() throws Exception {
        assertCode(428, DELETE);
    }
    @Test
    public void test428_OPTIONS() throws Exception {
        assertCode(428, OPTIONS);
    }
    @Test
    public void test428_HEAD() throws Exception {
        assertCode(428, HEAD);
    }
    @Test
    public void test429_GET() throws Exception {
        assertCode(429, GET);
    }
    @Test
    public void test429_POST() throws Exception {
        assertCode(429, POST);
    }
    @Test
    public void test429_PUT() throws Exception {
        assertCode(429, PUT);
    }
    @Test
    public void test429_DELETE() throws Exception {
        assertCode(429, DELETE);
    }
    @Test
    public void test429_OPTIONS() throws Exception {
        assertCode(429, OPTIONS);
    }
    @Test
    public void test429_HEAD() throws Exception {
        assertCode(429, HEAD);
    }
    @Test
    public void test430_GET() throws Exception {
        assertCode(430, GET);
    }
    @Test
    public void test430_POST() throws Exception {
        assertCode(430, POST);
    }
    @Test
    public void test430_PUT() throws Exception {
        assertCode(430, PUT);
    }
    @Test
    public void test430_DELETE() throws Exception {
        assertCode(430, DELETE);
    }
    @Test
    public void test430_OPTIONS() throws Exception {
        assertCode(430, OPTIONS);
    }
    @Test
    public void test430_HEAD() throws Exception {
        assertCode(430, HEAD);
    }
    @Test
    public void test431_GET() throws Exception {
        assertCode(431, GET);
    }
    @Test
    public void test431_POST() throws Exception {
        assertCode(431, POST);
    }
    @Test
    public void test431_PUT() throws Exception {
        assertCode(431, PUT);
    }
    @Test
    public void test431_DELETE() throws Exception {
        assertCode(431, DELETE);
    }
    @Test
    public void test431_OPTIONS() throws Exception {
        assertCode(431, OPTIONS);
    }
    @Test
    public void test431_HEAD() throws Exception {
        assertCode(431, HEAD);
    }
    @Test
    public void test432_GET() throws Exception {
        assertCode(432, GET);
    }
    @Test
    public void test432_POST() throws Exception {
        assertCode(432, POST);
    }
    @Test
    public void test432_PUT() throws Exception {
        assertCode(432, PUT);
    }
    @Test
    public void test432_DELETE() throws Exception {
        assertCode(432, DELETE);
    }
    @Test
    public void test432_OPTIONS() throws Exception {
        assertCode(432, OPTIONS);
    }
    @Test
    public void test432_HEAD() throws Exception {
        assertCode(432, HEAD);
    }
    @Test
    public void test433_GET() throws Exception {
        assertCode(433, GET);
    }
    @Test
    public void test433_POST() throws Exception {
        assertCode(433, POST);
    }
    @Test
    public void test433_PUT() throws Exception {
        assertCode(433, PUT);
    }
    @Test
    public void test433_DELETE() throws Exception {
        assertCode(433, DELETE);
    }
    @Test
    public void test433_OPTIONS() throws Exception {
        assertCode(433, OPTIONS);
    }
    @Test
    public void test433_HEAD() throws Exception {
        assertCode(433, HEAD);
    }
    @Test
    public void test434_GET() throws Exception {
        assertCode(434, GET);
    }
    @Test
    public void test434_POST() throws Exception {
        assertCode(434, POST);
    }
    @Test
    public void test434_PUT() throws Exception {
        assertCode(434, PUT);
    }
    @Test
    public void test434_DELETE() throws Exception {
        assertCode(434, DELETE);
    }
    @Test
    public void test434_OPTIONS() throws Exception {
        assertCode(434, OPTIONS);
    }
    @Test
    public void test434_HEAD() throws Exception {
        assertCode(434, HEAD);
    }
    @Test
    public void test435_GET() throws Exception {
        assertCode(435, GET);
    }
    @Test
    public void test435_POST() throws Exception {
        assertCode(435, POST);
    }
    @Test
    public void test435_PUT() throws Exception {
        assertCode(435, PUT);
    }
    @Test
    public void test435_DELETE() throws Exception {
        assertCode(435, DELETE);
    }
    @Test
    public void test435_OPTIONS() throws Exception {
        assertCode(435, OPTIONS);
    }
    @Test
    public void test435_HEAD() throws Exception {
        assertCode(435, HEAD);
    }
    @Test
    public void test436_GET() throws Exception {
        assertCode(436, GET);
    }
    @Test
    public void test436_POST() throws Exception {
        assertCode(436, POST);
    }
    @Test
    public void test436_PUT() throws Exception {
        assertCode(436, PUT);
    }
    @Test
    public void test436_DELETE() throws Exception {
        assertCode(436, DELETE);
    }
    @Test
    public void test436_OPTIONS() throws Exception {
        assertCode(436, OPTIONS);
    }
    @Test
    public void test436_HEAD() throws Exception {
        assertCode(436, HEAD);
    }
    @Test
    public void test437_GET() throws Exception {
        assertCode(437, GET);
    }
    @Test
    public void test437_POST() throws Exception {
        assertCode(437, POST);
    }
    @Test
    public void test437_PUT() throws Exception {
        assertCode(437, PUT);
    }
    @Test
    public void test437_DELETE() throws Exception {
        assertCode(437, DELETE);
    }
    @Test
    public void test437_OPTIONS() throws Exception {
        assertCode(437, OPTIONS);
    }
    @Test
    public void test437_HEAD() throws Exception {
        assertCode(437, HEAD);
    }
    @Test
    public void test438_GET() throws Exception {
        assertCode(438, GET);
    }
    @Test
    public void test438_POST() throws Exception {
        assertCode(438, POST);
    }
    @Test
    public void test438_PUT() throws Exception {
        assertCode(438, PUT);
    }
    @Test
    public void test438_DELETE() throws Exception {
        assertCode(438, DELETE);
    }
    @Test
    public void test438_OPTIONS() throws Exception {
        assertCode(438, OPTIONS);
    }
    @Test
    public void test438_HEAD() throws Exception {
        assertCode(438, HEAD);
    }
    @Test
    public void test439_GET() throws Exception {
        assertCode(439, GET);
    }
    @Test
    public void test439_POST() throws Exception {
        assertCode(439, POST);
    }
    @Test
    public void test439_PUT() throws Exception {
        assertCode(439, PUT);
    }
    @Test
    public void test439_DELETE() throws Exception {
        assertCode(439, DELETE);
    }
    @Test
    public void test439_OPTIONS() throws Exception {
        assertCode(439, OPTIONS);
    }
    @Test
    public void test439_HEAD() throws Exception {
        assertCode(439, HEAD);
    }
    @Test
    public void test440_GET() throws Exception {
        assertCode(440, GET);
    }
    @Test
    public void test440_POST() throws Exception {
        assertCode(440, POST);
    }
    @Test
    public void test440_PUT() throws Exception {
        assertCode(440, PUT);
    }
    @Test
    public void test440_DELETE() throws Exception {
        assertCode(440, DELETE);
    }
    @Test
    public void test440_OPTIONS() throws Exception {
        assertCode(440, OPTIONS);
    }
    @Test
    public void test440_HEAD() throws Exception {
        assertCode(440, HEAD);
    }
    @Test
    public void test441_GET() throws Exception {
        assertCode(441, GET);
    }
    @Test
    public void test441_POST() throws Exception {
        assertCode(441, POST);
    }
    @Test
    public void test441_PUT() throws Exception {
        assertCode(441, PUT);
    }
    @Test
    public void test441_DELETE() throws Exception {
        assertCode(441, DELETE);
    }
    @Test
    public void test441_OPTIONS() throws Exception {
        assertCode(441, OPTIONS);
    }
    @Test
    public void test441_HEAD() throws Exception {
        assertCode(441, HEAD);
    }
    @Test
    public void test442_GET() throws Exception {
        assertCode(442, GET);
    }
    @Test
    public void test442_POST() throws Exception {
        assertCode(442, POST);
    }
    @Test
    public void test442_PUT() throws Exception {
        assertCode(442, PUT);
    }
    @Test
    public void test442_DELETE() throws Exception {
        assertCode(442, DELETE);
    }
    @Test
    public void test442_OPTIONS() throws Exception {
        assertCode(442, OPTIONS);
    }
    @Test
    public void test442_HEAD() throws Exception {
        assertCode(442, HEAD);
    }
    @Test
    public void test443_GET() throws Exception {
        assertCode(443, GET);
    }
    @Test
    public void test443_POST() throws Exception {
        assertCode(443, POST);
    }
    @Test
    public void test443_PUT() throws Exception {
        assertCode(443, PUT);
    }
    @Test
    public void test443_DELETE() throws Exception {
        assertCode(443, DELETE);
    }
    @Test
    public void test443_OPTIONS() throws Exception {
        assertCode(443, OPTIONS);
    }
    @Test
    public void test443_HEAD() throws Exception {
        assertCode(443, HEAD);
    }
    @Test
    public void test444_GET() throws Exception {
        assertCode(444, GET);
    }
    @Test
    public void test444_POST() throws Exception {
        assertCode(444, POST);
    }
    @Test
    public void test444_PUT() throws Exception {
        assertCode(444, PUT);
    }
    @Test
    public void test444_DELETE() throws Exception {
        assertCode(444, DELETE);
    }
    @Test
    public void test444_OPTIONS() throws Exception {
        assertCode(444, OPTIONS);
    }
    @Test
    public void test444_HEAD() throws Exception {
        assertCode(444, HEAD);
    }
    @Test
    public void test445_GET() throws Exception {
        assertCode(445, GET);
    }
    @Test
    public void test445_POST() throws Exception {
        assertCode(445, POST);
    }
    @Test
    public void test445_PUT() throws Exception {
        assertCode(445, PUT);
    }
    @Test
    public void test445_DELETE() throws Exception {
        assertCode(445, DELETE);
    }
    @Test
    public void test445_OPTIONS() throws Exception {
        assertCode(445, OPTIONS);
    }
    @Test
    public void test445_HEAD() throws Exception {
        assertCode(445, HEAD);
    }
    @Test
    public void test446_GET() throws Exception {
        assertCode(446, GET);
    }
    @Test
    public void test446_POST() throws Exception {
        assertCode(446, POST);
    }
    @Test
    public void test446_PUT() throws Exception {
        assertCode(446, PUT);
    }
    @Test
    public void test446_DELETE() throws Exception {
        assertCode(446, DELETE);
    }
    @Test
    public void test446_OPTIONS() throws Exception {
        assertCode(446, OPTIONS);
    }
    @Test
    public void test446_HEAD() throws Exception {
        assertCode(446, HEAD);
    }
    @Test
    public void test447_GET() throws Exception {
        assertCode(447, GET);
    }
    @Test
    public void test447_POST() throws Exception {
        assertCode(447, POST);
    }
    @Test
    public void test447_PUT() throws Exception {
        assertCode(447, PUT);
    }
    @Test
    public void test447_DELETE() throws Exception {
        assertCode(447, DELETE);
    }
    @Test
    public void test447_OPTIONS() throws Exception {
        assertCode(447, OPTIONS);
    }
    @Test
    public void test447_HEAD() throws Exception {
        assertCode(447, HEAD);
    }
    @Test
    public void test448_GET() throws Exception {
        assertCode(448, GET);
    }
    @Test
    public void test448_POST() throws Exception {
        assertCode(448, POST);
    }
    @Test
    public void test448_PUT() throws Exception {
        assertCode(448, PUT);
    }
    @Test
    public void test448_DELETE() throws Exception {
        assertCode(448, DELETE);
    }
    @Test
    public void test448_OPTIONS() throws Exception {
        assertCode(448, OPTIONS);
    }
    @Test
    public void test448_HEAD() throws Exception {
        assertCode(448, HEAD);
    }
    @Test
    public void test449_GET() throws Exception {
        assertCode(449, GET);
    }
    @Test
    public void test449_POST() throws Exception {
        assertCode(449, POST);
    }
    @Test
    public void test449_PUT() throws Exception {
        assertCode(449, PUT);
    }
    @Test
    public void test449_DELETE() throws Exception {
        assertCode(449, DELETE);
    }
    @Test
    public void test449_OPTIONS() throws Exception {
        assertCode(449, OPTIONS);
    }
    @Test
    public void test449_HEAD() throws Exception {
        assertCode(449, HEAD);
    }
    @Test
    public void test450_GET() throws Exception {
        assertCode(450, GET);
    }
    @Test
    public void test450_POST() throws Exception {
        assertCode(450, POST);
    }
    @Test
    public void test450_PUT() throws Exception {
        assertCode(450, PUT);
    }
    @Test
    public void test450_DELETE() throws Exception {
        assertCode(450, DELETE);
    }
    @Test
    public void test450_OPTIONS() throws Exception {
        assertCode(450, OPTIONS);
    }
    @Test
    public void test450_HEAD() throws Exception {
        assertCode(450, HEAD);
    }
    @Test
    public void test451_GET() throws Exception {
        assertCode(451, GET);
    }
    @Test
    public void test451_POST() throws Exception {
        assertCode(451, POST);
    }
    @Test
    public void test451_PUT() throws Exception {
        assertCode(451, PUT);
    }
    @Test
    public void test451_DELETE() throws Exception {
        assertCode(451, DELETE);
    }
    @Test
    public void test451_OPTIONS() throws Exception {
        assertCode(451, OPTIONS);
    }
    @Test
    public void test451_HEAD() throws Exception {
        assertCode(451, HEAD);
    }
    @Test
    public void test452_GET() throws Exception {
        assertCode(452, GET);
    }
    @Test
    public void test452_POST() throws Exception {
        assertCode(452, POST);
    }
    @Test
    public void test452_PUT() throws Exception {
        assertCode(452, PUT);
    }
    @Test
    public void test452_DELETE() throws Exception {
        assertCode(452, DELETE);
    }
    @Test
    public void test452_OPTIONS() throws Exception {
        assertCode(452, OPTIONS);
    }
    @Test
    public void test452_HEAD() throws Exception {
        assertCode(452, HEAD);
    }
    @Test
    public void test453_GET() throws Exception {
        assertCode(453, GET);
    }
    @Test
    public void test453_POST() throws Exception {
        assertCode(453, POST);
    }
    @Test
    public void test453_PUT() throws Exception {
        assertCode(453, PUT);
    }
    @Test
    public void test453_DELETE() throws Exception {
        assertCode(453, DELETE);
    }
    @Test
    public void test453_OPTIONS() throws Exception {
        assertCode(453, OPTIONS);
    }
    @Test
    public void test453_HEAD() throws Exception {
        assertCode(453, HEAD);
    }
    @Test
    public void test454_GET() throws Exception {
        assertCode(454, GET);
    }
    @Test
    public void test454_POST() throws Exception {
        assertCode(454, POST);
    }
    @Test
    public void test454_PUT() throws Exception {
        assertCode(454, PUT);
    }
    @Test
    public void test454_DELETE() throws Exception {
        assertCode(454, DELETE);
    }
    @Test
    public void test454_OPTIONS() throws Exception {
        assertCode(454, OPTIONS);
    }
    @Test
    public void test454_HEAD() throws Exception {
        assertCode(454, HEAD);
    }
    @Test
    public void test455_GET() throws Exception {
        assertCode(455, GET);
    }
    @Test
    public void test455_POST() throws Exception {
        assertCode(455, POST);
    }
    @Test
    public void test455_PUT() throws Exception {
        assertCode(455, PUT);
    }
    @Test
    public void test455_DELETE() throws Exception {
        assertCode(455, DELETE);
    }
    @Test
    public void test455_OPTIONS() throws Exception {
        assertCode(455, OPTIONS);
    }
    @Test
    public void test455_HEAD() throws Exception {
        assertCode(455, HEAD);
    }
    @Test
    public void test456_GET() throws Exception {
        assertCode(456, GET);
    }
    @Test
    public void test456_POST() throws Exception {
        assertCode(456, POST);
    }
    @Test
    public void test456_PUT() throws Exception {
        assertCode(456, PUT);
    }
    @Test
    public void test456_DELETE() throws Exception {
        assertCode(456, DELETE);
    }
    @Test
    public void test456_OPTIONS() throws Exception {
        assertCode(456, OPTIONS);
    }
    @Test
    public void test456_HEAD() throws Exception {
        assertCode(456, HEAD);
    }
    @Test
    public void test457_GET() throws Exception {
        assertCode(457, GET);
    }
    @Test
    public void test457_POST() throws Exception {
        assertCode(457, POST);
    }
    @Test
    public void test457_PUT() throws Exception {
        assertCode(457, PUT);
    }
    @Test
    public void test457_DELETE() throws Exception {
        assertCode(457, DELETE);
    }
    @Test
    public void test457_OPTIONS() throws Exception {
        assertCode(457, OPTIONS);
    }
    @Test
    public void test457_HEAD() throws Exception {
        assertCode(457, HEAD);
    }
    @Test
    public void test458_GET() throws Exception {
        assertCode(458, GET);
    }
    @Test
    public void test458_POST() throws Exception {
        assertCode(458, POST);
    }
    @Test
    public void test458_PUT() throws Exception {
        assertCode(458, PUT);
    }
    @Test
    public void test458_DELETE() throws Exception {
        assertCode(458, DELETE);
    }
    @Test
    public void test458_OPTIONS() throws Exception {
        assertCode(458, OPTIONS);
    }
    @Test
    public void test458_HEAD() throws Exception {
        assertCode(458, HEAD);
    }
    @Test
    public void test459_GET() throws Exception {
        assertCode(459, GET);
    }
    @Test
    public void test459_POST() throws Exception {
        assertCode(459, POST);
    }
    @Test
    public void test459_PUT() throws Exception {
        assertCode(459, PUT);
    }
    @Test
    public void test459_DELETE() throws Exception {
        assertCode(459, DELETE);
    }
    @Test
    public void test459_OPTIONS() throws Exception {
        assertCode(459, OPTIONS);
    }
    @Test
    public void test459_HEAD() throws Exception {
        assertCode(459, HEAD);
    }
    @Test
    public void test460_GET() throws Exception {
        assertCode(460, GET);
    }
    @Test
    public void test460_POST() throws Exception {
        assertCode(460, POST);
    }
    @Test
    public void test460_PUT() throws Exception {
        assertCode(460, PUT);
    }
    @Test
    public void test460_DELETE() throws Exception {
        assertCode(460, DELETE);
    }
    @Test
    public void test460_OPTIONS() throws Exception {
        assertCode(460, OPTIONS);
    }
    @Test
    public void test460_HEAD() throws Exception {
        assertCode(460, HEAD);
    }
    @Test
    public void test461_GET() throws Exception {
        assertCode(461, GET);
    }
    @Test
    public void test461_POST() throws Exception {
        assertCode(461, POST);
    }
    @Test
    public void test461_PUT() throws Exception {
        assertCode(461, PUT);
    }
    @Test
    public void test461_DELETE() throws Exception {
        assertCode(461, DELETE);
    }
    @Test
    public void test461_OPTIONS() throws Exception {
        assertCode(461, OPTIONS);
    }
    @Test
    public void test461_HEAD() throws Exception {
        assertCode(461, HEAD);
    }
    @Test
    public void test462_GET() throws Exception {
        assertCode(462, GET);
    }
    @Test
    public void test462_POST() throws Exception {
        assertCode(462, POST);
    }
    @Test
    public void test462_PUT() throws Exception {
        assertCode(462, PUT);
    }
    @Test
    public void test462_DELETE() throws Exception {
        assertCode(462, DELETE);
    }
    @Test
    public void test462_OPTIONS() throws Exception {
        assertCode(462, OPTIONS);
    }
    @Test
    public void test462_HEAD() throws Exception {
        assertCode(462, HEAD);
    }
    @Test
    public void test463_GET() throws Exception {
        assertCode(463, GET);
    }
    @Test
    public void test463_POST() throws Exception {
        assertCode(463, POST);
    }
    @Test
    public void test463_PUT() throws Exception {
        assertCode(463, PUT);
    }
    @Test
    public void test463_DELETE() throws Exception {
        assertCode(463, DELETE);
    }
    @Test
    public void test463_OPTIONS() throws Exception {
        assertCode(463, OPTIONS);
    }
    @Test
    public void test463_HEAD() throws Exception {
        assertCode(463, HEAD);
    }
    @Test
    public void test464_GET() throws Exception {
        assertCode(464, GET);
    }
    @Test
    public void test464_POST() throws Exception {
        assertCode(464, POST);
    }
    @Test
    public void test464_PUT() throws Exception {
        assertCode(464, PUT);
    }
    @Test
    public void test464_DELETE() throws Exception {
        assertCode(464, DELETE);
    }
    @Test
    public void test464_OPTIONS() throws Exception {
        assertCode(464, OPTIONS);
    }
    @Test
    public void test464_HEAD() throws Exception {
        assertCode(464, HEAD);
    }
    @Test
    public void test465_GET() throws Exception {
        assertCode(465, GET);
    }
    @Test
    public void test465_POST() throws Exception {
        assertCode(465, POST);
    }
    @Test
    public void test465_PUT() throws Exception {
        assertCode(465, PUT);
    }
    @Test
    public void test465_DELETE() throws Exception {
        assertCode(465, DELETE);
    }
    @Test
    public void test465_OPTIONS() throws Exception {
        assertCode(465, OPTIONS);
    }
    @Test
    public void test465_HEAD() throws Exception {
        assertCode(465, HEAD);
    }
    @Test
    public void test466_GET() throws Exception {
        assertCode(466, GET);
    }
    @Test
    public void test466_POST() throws Exception {
        assertCode(466, POST);
    }
    @Test
    public void test466_PUT() throws Exception {
        assertCode(466, PUT);
    }
    @Test
    public void test466_DELETE() throws Exception {
        assertCode(466, DELETE);
    }
    @Test
    public void test466_OPTIONS() throws Exception {
        assertCode(466, OPTIONS);
    }
    @Test
    public void test466_HEAD() throws Exception {
        assertCode(466, HEAD);
    }
    @Test
    public void test467_GET() throws Exception {
        assertCode(467, GET);
    }
    @Test
    public void test467_POST() throws Exception {
        assertCode(467, POST);
    }
    @Test
    public void test467_PUT() throws Exception {
        assertCode(467, PUT);
    }
    @Test
    public void test467_DELETE() throws Exception {
        assertCode(467, DELETE);
    }
    @Test
    public void test467_OPTIONS() throws Exception {
        assertCode(467, OPTIONS);
    }
    @Test
    public void test467_HEAD() throws Exception {
        assertCode(467, HEAD);
    }
    @Test
    public void test468_GET() throws Exception {
        assertCode(468, GET);
    }
    @Test
    public void test468_POST() throws Exception {
        assertCode(468, POST);
    }
    @Test
    public void test468_PUT() throws Exception {
        assertCode(468, PUT);
    }
    @Test
    public void test468_DELETE() throws Exception {
        assertCode(468, DELETE);
    }
    @Test
    public void test468_OPTIONS() throws Exception {
        assertCode(468, OPTIONS);
    }
    @Test
    public void test468_HEAD() throws Exception {
        assertCode(468, HEAD);
    }
    @Test
    public void test469_GET() throws Exception {
        assertCode(469, GET);
    }
    @Test
    public void test469_POST() throws Exception {
        assertCode(469, POST);
    }
    @Test
    public void test469_PUT() throws Exception {
        assertCode(469, PUT);
    }
    @Test
    public void test469_DELETE() throws Exception {
        assertCode(469, DELETE);
    }
    @Test
    public void test469_OPTIONS() throws Exception {
        assertCode(469, OPTIONS);
    }
    @Test
    public void test469_HEAD() throws Exception {
        assertCode(469, HEAD);
    }
    @Test
    public void test470_GET() throws Exception {
        assertCode(470, GET);
    }
    @Test
    public void test470_POST() throws Exception {
        assertCode(470, POST);
    }
    @Test
    public void test470_PUT() throws Exception {
        assertCode(470, PUT);
    }
    @Test
    public void test470_DELETE() throws Exception {
        assertCode(470, DELETE);
    }
    @Test
    public void test470_OPTIONS() throws Exception {
        assertCode(470, OPTIONS);
    }
    @Test
    public void test470_HEAD() throws Exception {
        assertCode(470, HEAD);
    }
    @Test
    public void test471_GET() throws Exception {
        assertCode(471, GET);
    }
    @Test
    public void test471_POST() throws Exception {
        assertCode(471, POST);
    }
    @Test
    public void test471_PUT() throws Exception {
        assertCode(471, PUT);
    }
    @Test
    public void test471_DELETE() throws Exception {
        assertCode(471, DELETE);
    }
    @Test
    public void test471_OPTIONS() throws Exception {
        assertCode(471, OPTIONS);
    }
    @Test
    public void test471_HEAD() throws Exception {
        assertCode(471, HEAD);
    }
    @Test
    public void test472_GET() throws Exception {
        assertCode(472, GET);
    }
    @Test
    public void test472_POST() throws Exception {
        assertCode(472, POST);
    }
    @Test
    public void test472_PUT() throws Exception {
        assertCode(472, PUT);
    }
    @Test
    public void test472_DELETE() throws Exception {
        assertCode(472, DELETE);
    }
    @Test
    public void test472_OPTIONS() throws Exception {
        assertCode(472, OPTIONS);
    }
    @Test
    public void test472_HEAD() throws Exception {
        assertCode(472, HEAD);
    }
    @Test
    public void test473_GET() throws Exception {
        assertCode(473, GET);
    }
    @Test
    public void test473_POST() throws Exception {
        assertCode(473, POST);
    }
    @Test
    public void test473_PUT() throws Exception {
        assertCode(473, PUT);
    }
    @Test
    public void test473_DELETE() throws Exception {
        assertCode(473, DELETE);
    }
    @Test
    public void test473_OPTIONS() throws Exception {
        assertCode(473, OPTIONS);
    }
    @Test
    public void test473_HEAD() throws Exception {
        assertCode(473, HEAD);
    }
    @Test
    public void test474_GET() throws Exception {
        assertCode(474, GET);
    }
    @Test
    public void test474_POST() throws Exception {
        assertCode(474, POST);
    }
    @Test
    public void test474_PUT() throws Exception {
        assertCode(474, PUT);
    }
    @Test
    public void test474_DELETE() throws Exception {
        assertCode(474, DELETE);
    }
    @Test
    public void test474_OPTIONS() throws Exception {
        assertCode(474, OPTIONS);
    }
    @Test
    public void test474_HEAD() throws Exception {
        assertCode(474, HEAD);
    }
    @Test
    public void test475_GET() throws Exception {
        assertCode(475, GET);
    }
    @Test
    public void test475_POST() throws Exception {
        assertCode(475, POST);
    }
    @Test
    public void test475_PUT() throws Exception {
        assertCode(475, PUT);
    }
    @Test
    public void test475_DELETE() throws Exception {
        assertCode(475, DELETE);
    }
    @Test
    public void test475_OPTIONS() throws Exception {
        assertCode(475, OPTIONS);
    }
    @Test
    public void test475_HEAD() throws Exception {
        assertCode(475, HEAD);
    }
    @Test
    public void test476_GET() throws Exception {
        assertCode(476, GET);
    }
    @Test
    public void test476_POST() throws Exception {
        assertCode(476, POST);
    }
    @Test
    public void test476_PUT() throws Exception {
        assertCode(476, PUT);
    }
    @Test
    public void test476_DELETE() throws Exception {
        assertCode(476, DELETE);
    }
    @Test
    public void test476_OPTIONS() throws Exception {
        assertCode(476, OPTIONS);
    }
    @Test
    public void test476_HEAD() throws Exception {
        assertCode(476, HEAD);
    }
    @Test
    public void test477_GET() throws Exception {
        assertCode(477, GET);
    }
    @Test
    public void test477_POST() throws Exception {
        assertCode(477, POST);
    }
    @Test
    public void test477_PUT() throws Exception {
        assertCode(477, PUT);
    }
    @Test
    public void test477_DELETE() throws Exception {
        assertCode(477, DELETE);
    }
    @Test
    public void test477_OPTIONS() throws Exception {
        assertCode(477, OPTIONS);
    }
    @Test
    public void test477_HEAD() throws Exception {
        assertCode(477, HEAD);
    }
    @Test
    public void test478_GET() throws Exception {
        assertCode(478, GET);
    }
    @Test
    public void test478_POST() throws Exception {
        assertCode(478, POST);
    }
    @Test
    public void test478_PUT() throws Exception {
        assertCode(478, PUT);
    }
    @Test
    public void test478_DELETE() throws Exception {
        assertCode(478, DELETE);
    }
    @Test
    public void test478_OPTIONS() throws Exception {
        assertCode(478, OPTIONS);
    }
    @Test
    public void test478_HEAD() throws Exception {
        assertCode(478, HEAD);
    }
    @Test
    public void test479_GET() throws Exception {
        assertCode(479, GET);
    }
    @Test
    public void test479_POST() throws Exception {
        assertCode(479, POST);
    }
    @Test
    public void test479_PUT() throws Exception {
        assertCode(479, PUT);
    }
    @Test
    public void test479_DELETE() throws Exception {
        assertCode(479, DELETE);
    }
    @Test
    public void test479_OPTIONS() throws Exception {
        assertCode(479, OPTIONS);
    }
    @Test
    public void test479_HEAD() throws Exception {
        assertCode(479, HEAD);
    }
    @Test
    public void test480_GET() throws Exception {
        assertCode(480, GET);
    }
    @Test
    public void test480_POST() throws Exception {
        assertCode(480, POST);
    }
    @Test
    public void test480_PUT() throws Exception {
        assertCode(480, PUT);
    }
    @Test
    public void test480_DELETE() throws Exception {
        assertCode(480, DELETE);
    }
    @Test
    public void test480_OPTIONS() throws Exception {
        assertCode(480, OPTIONS);
    }
    @Test
    public void test480_HEAD() throws Exception {
        assertCode(480, HEAD);
    }
    @Test
    public void test481_GET() throws Exception {
        assertCode(481, GET);
    }
    @Test
    public void test481_POST() throws Exception {
        assertCode(481, POST);
    }
    @Test
    public void test481_PUT() throws Exception {
        assertCode(481, PUT);
    }
    @Test
    public void test481_DELETE() throws Exception {
        assertCode(481, DELETE);
    }
    @Test
    public void test481_OPTIONS() throws Exception {
        assertCode(481, OPTIONS);
    }
    @Test
    public void test481_HEAD() throws Exception {
        assertCode(481, HEAD);
    }
    @Test
    public void test482_GET() throws Exception {
        assertCode(482, GET);
    }
    @Test
    public void test482_POST() throws Exception {
        assertCode(482, POST);
    }
    @Test
    public void test482_PUT() throws Exception {
        assertCode(482, PUT);
    }
    @Test
    public void test482_DELETE() throws Exception {
        assertCode(482, DELETE);
    }
    @Test
    public void test482_OPTIONS() throws Exception {
        assertCode(482, OPTIONS);
    }
    @Test
    public void test482_HEAD() throws Exception {
        assertCode(482, HEAD);
    }
    @Test
    public void test483_GET() throws Exception {
        assertCode(483, GET);
    }
    @Test
    public void test483_POST() throws Exception {
        assertCode(483, POST);
    }
    @Test
    public void test483_PUT() throws Exception {
        assertCode(483, PUT);
    }
    @Test
    public void test483_DELETE() throws Exception {
        assertCode(483, DELETE);
    }
    @Test
    public void test483_OPTIONS() throws Exception {
        assertCode(483, OPTIONS);
    }
    @Test
    public void test483_HEAD() throws Exception {
        assertCode(483, HEAD);
    }
    @Test
    public void test484_GET() throws Exception {
        assertCode(484, GET);
    }
    @Test
    public void test484_POST() throws Exception {
        assertCode(484, POST);
    }
    @Test
    public void test484_PUT() throws Exception {
        assertCode(484, PUT);
    }
    @Test
    public void test484_DELETE() throws Exception {
        assertCode(484, DELETE);
    }
    @Test
    public void test484_OPTIONS() throws Exception {
        assertCode(484, OPTIONS);
    }
    @Test
    public void test484_HEAD() throws Exception {
        assertCode(484, HEAD);
    }
    @Test
    public void test485_GET() throws Exception {
        assertCode(485, GET);
    }
    @Test
    public void test485_POST() throws Exception {
        assertCode(485, POST);
    }
    @Test
    public void test485_PUT() throws Exception {
        assertCode(485, PUT);
    }
    @Test
    public void test485_DELETE() throws Exception {
        assertCode(485, DELETE);
    }
    @Test
    public void test485_OPTIONS() throws Exception {
        assertCode(485, OPTIONS);
    }
    @Test
    public void test485_HEAD() throws Exception {
        assertCode(485, HEAD);
    }
    @Test
    public void test486_GET() throws Exception {
        assertCode(486, GET);
    }
    @Test
    public void test486_POST() throws Exception {
        assertCode(486, POST);
    }
    @Test
    public void test486_PUT() throws Exception {
        assertCode(486, PUT);
    }
    @Test
    public void test486_DELETE() throws Exception {
        assertCode(486, DELETE);
    }
    @Test
    public void test486_OPTIONS() throws Exception {
        assertCode(486, OPTIONS);
    }
    @Test
    public void test486_HEAD() throws Exception {
        assertCode(486, HEAD);
    }
    @Test
    public void test487_GET() throws Exception {
        assertCode(487, GET);
    }
    @Test
    public void test487_POST() throws Exception {
        assertCode(487, POST);
    }
    @Test
    public void test487_PUT() throws Exception {
        assertCode(487, PUT);
    }
    @Test
    public void test487_DELETE() throws Exception {
        assertCode(487, DELETE);
    }
    @Test
    public void test487_OPTIONS() throws Exception {
        assertCode(487, OPTIONS);
    }
    @Test
    public void test487_HEAD() throws Exception {
        assertCode(487, HEAD);
    }
    @Test
    public void test488_GET() throws Exception {
        assertCode(488, GET);
    }
    @Test
    public void test488_POST() throws Exception {
        assertCode(488, POST);
    }
    @Test
    public void test488_PUT() throws Exception {
        assertCode(488, PUT);
    }
    @Test
    public void test488_DELETE() throws Exception {
        assertCode(488, DELETE);
    }
    @Test
    public void test488_OPTIONS() throws Exception {
        assertCode(488, OPTIONS);
    }
    @Test
    public void test488_HEAD() throws Exception {
        assertCode(488, HEAD);
    }
    @Test
    public void test489_GET() throws Exception {
        assertCode(489, GET);
    }
    @Test
    public void test489_POST() throws Exception {
        assertCode(489, POST);
    }
    @Test
    public void test489_PUT() throws Exception {
        assertCode(489, PUT);
    }
    @Test
    public void test489_DELETE() throws Exception {
        assertCode(489, DELETE);
    }
    @Test
    public void test489_OPTIONS() throws Exception {
        assertCode(489, OPTIONS);
    }
    @Test
    public void test489_HEAD() throws Exception {
        assertCode(489, HEAD);
    }
    @Test
    public void test490_GET() throws Exception {
        assertCode(490, GET);
    }
    @Test
    public void test490_POST() throws Exception {
        assertCode(490, POST);
    }
    @Test
    public void test490_PUT() throws Exception {
        assertCode(490, PUT);
    }
    @Test
    public void test490_DELETE() throws Exception {
        assertCode(490, DELETE);
    }
    @Test
    public void test490_OPTIONS() throws Exception {
        assertCode(490, OPTIONS);
    }
    @Test
    public void test490_HEAD() throws Exception {
        assertCode(490, HEAD);
    }
    @Test
    public void test491_GET() throws Exception {
        assertCode(491, GET);
    }
    @Test
    public void test491_POST() throws Exception {
        assertCode(491, POST);
    }
    @Test
    public void test491_PUT() throws Exception {
        assertCode(491, PUT);
    }
    @Test
    public void test491_DELETE() throws Exception {
        assertCode(491, DELETE);
    }
    @Test
    public void test491_OPTIONS() throws Exception {
        assertCode(491, OPTIONS);
    }
    @Test
    public void test491_HEAD() throws Exception {
        assertCode(491, HEAD);
    }
    @Test
    public void test492_GET() throws Exception {
        assertCode(492, GET);
    }
    @Test
    public void test492_POST() throws Exception {
        assertCode(492, POST);
    }
    @Test
    public void test492_PUT() throws Exception {
        assertCode(492, PUT);
    }
    @Test
    public void test492_DELETE() throws Exception {
        assertCode(492, DELETE);
    }
    @Test
    public void test492_OPTIONS() throws Exception {
        assertCode(492, OPTIONS);
    }
    @Test
    public void test492_HEAD() throws Exception {
        assertCode(492, HEAD);
    }
    @Test
    public void test493_GET() throws Exception {
        assertCode(493, GET);
    }
    @Test
    public void test493_POST() throws Exception {
        assertCode(493, POST);
    }
    @Test
    public void test493_PUT() throws Exception {
        assertCode(493, PUT);
    }
    @Test
    public void test493_DELETE() throws Exception {
        assertCode(493, DELETE);
    }
    @Test
    public void test493_OPTIONS() throws Exception {
        assertCode(493, OPTIONS);
    }
    @Test
    public void test493_HEAD() throws Exception {
        assertCode(493, HEAD);
    }
    @Test
    public void test494_GET() throws Exception {
        assertCode(494, GET);
    }
    @Test
    public void test494_POST() throws Exception {
        assertCode(494, POST);
    }
    @Test
    public void test494_PUT() throws Exception {
        assertCode(494, PUT);
    }
    @Test
    public void test494_DELETE() throws Exception {
        assertCode(494, DELETE);
    }
    @Test
    public void test494_OPTIONS() throws Exception {
        assertCode(494, OPTIONS);
    }
    @Test
    public void test494_HEAD() throws Exception {
        assertCode(494, HEAD);
    }
    @Test
    public void test495_GET() throws Exception {
        assertCode(495, GET);
    }
    @Test
    public void test495_POST() throws Exception {
        assertCode(495, POST);
    }
    @Test
    public void test495_PUT() throws Exception {
        assertCode(495, PUT);
    }
    @Test
    public void test495_DELETE() throws Exception {
        assertCode(495, DELETE);
    }
    @Test
    public void test495_OPTIONS() throws Exception {
        assertCode(495, OPTIONS);
    }
    @Test
    public void test495_HEAD() throws Exception {
        assertCode(495, HEAD);
    }
    @Test
    public void test496_GET() throws Exception {
        assertCode(496, GET);
    }
    @Test
    public void test496_POST() throws Exception {
        assertCode(496, POST);
    }
    @Test
    public void test496_PUT() throws Exception {
        assertCode(496, PUT);
    }
    @Test
    public void test496_DELETE() throws Exception {
        assertCode(496, DELETE);
    }
    @Test
    public void test496_OPTIONS() throws Exception {
        assertCode(496, OPTIONS);
    }
    @Test
    public void test496_HEAD() throws Exception {
        assertCode(496, HEAD);
    }
    @Test
    public void test497_GET() throws Exception {
        assertCode(497, GET);
    }
    @Test
    public void test497_POST() throws Exception {
        assertCode(497, POST);
    }
    @Test
    public void test497_PUT() throws Exception {
        assertCode(497, PUT);
    }
    @Test
    public void test497_DELETE() throws Exception {
        assertCode(497, DELETE);
    }
    @Test
    public void test497_OPTIONS() throws Exception {
        assertCode(497, OPTIONS);
    }
    @Test
    public void test497_HEAD() throws Exception {
        assertCode(497, HEAD);
    }
    @Test
    public void test498_GET() throws Exception {
        assertCode(498, GET);
    }
    @Test
    public void test498_POST() throws Exception {
        assertCode(498, POST);
    }
    @Test
    public void test498_PUT() throws Exception {
        assertCode(498, PUT);
    }
    @Test
    public void test498_DELETE() throws Exception {
        assertCode(498, DELETE);
    }
    @Test
    public void test498_OPTIONS() throws Exception {
        assertCode(498, OPTIONS);
    }
    @Test
    public void test498_HEAD() throws Exception {
        assertCode(498, HEAD);
    }
    @Test
    public void test499_GET() throws Exception {
        assertCode(499, GET);
    }
    @Test
    public void test499_POST() throws Exception {
        assertCode(499, POST);
    }
    @Test
    public void test499_PUT() throws Exception {
        assertCode(499, PUT);
    }
    @Test
    public void test499_DELETE() throws Exception {
        assertCode(499, DELETE);
    }
    @Test
    public void test499_OPTIONS() throws Exception {
        assertCode(499, OPTIONS);
    }
    @Test
    public void test499_HEAD() throws Exception {
        assertCode(499, HEAD);
    }
    @Test
    public void test500_GET() throws Exception {
        assertCode(500, GET);
    }
    @Test
    public void test500_POST() throws Exception {
        assertCode(500, POST);
    }
    @Test
    public void test500_PUT() throws Exception {
        assertCode(500, PUT);
    }
    @Test
    public void test500_DELETE() throws Exception {
        assertCode(500, DELETE);
    }
    @Test
    public void test500_OPTIONS() throws Exception {
        assertCode(500, OPTIONS);
    }
    @Test
    public void test500_HEAD() throws Exception {
        assertCode(500, HEAD);
    }
    @Test
    public void test501_GET() throws Exception {
        assertCode(501, GET);
    }
    @Test
    public void test501_POST() throws Exception {
        assertCode(501, POST);
    }
    @Test
    public void test501_PUT() throws Exception {
        assertCode(501, PUT);
    }
    @Test
    public void test501_DELETE() throws Exception {
        assertCode(501, DELETE);
    }
    @Test
    public void test501_OPTIONS() throws Exception {
        assertCode(501, OPTIONS);
    }
    @Test
    public void test501_HEAD() throws Exception {
        assertCode(501, HEAD);
    }
    @Test
    public void test502_GET() throws Exception {
        assertCode(502, GET);
    }
    @Test
    public void test502_POST() throws Exception {
        assertCode(502, POST);
    }
    @Test
    public void test502_PUT() throws Exception {
        assertCode(502, PUT);
    }
    @Test
    public void test502_DELETE() throws Exception {
        assertCode(502, DELETE);
    }
    @Test
    public void test502_OPTIONS() throws Exception {
        assertCode(502, OPTIONS);
    }
    @Test
    public void test502_HEAD() throws Exception {
        assertCode(502, HEAD);
    }
    @Test
    public void test503_GET() throws Exception {
        assertCode(503, GET);
    }
    @Test
    public void test503_POST() throws Exception {
        assertCode(503, POST);
    }
    @Test
    public void test503_PUT() throws Exception {
        assertCode(503, PUT);
    }
    @Test
    public void test503_DELETE() throws Exception {
        assertCode(503, DELETE);
    }
    @Test
    public void test503_OPTIONS() throws Exception {
        assertCode(503, OPTIONS);
    }
    @Test
    public void test503_HEAD() throws Exception {
        assertCode(503, HEAD);
    }
    @Test
    public void test504_GET() throws Exception {
        assertCode(504, GET);
    }
    @Test
    public void test504_POST() throws Exception {
        assertCode(504, POST);
    }
    @Test
    public void test504_PUT() throws Exception {
        assertCode(504, PUT);
    }
    @Test
    public void test504_DELETE() throws Exception {
        assertCode(504, DELETE);
    }
    @Test
    public void test504_OPTIONS() throws Exception {
        assertCode(504, OPTIONS);
    }
    @Test
    public void test504_HEAD() throws Exception {
        assertCode(504, HEAD);
    }
    @Test
    public void test505_GET() throws Exception {
        assertCode(505, GET);
    }
    @Test
    public void test505_POST() throws Exception {
        assertCode(505, POST);
    }
    @Test
    public void test505_PUT() throws Exception {
        assertCode(505, PUT);
    }
    @Test
    public void test505_DELETE() throws Exception {
        assertCode(505, DELETE);
    }
    @Test
    public void test505_OPTIONS() throws Exception {
        assertCode(505, OPTIONS);
    }
    @Test
    public void test505_HEAD() throws Exception {
        assertCode(505, HEAD);
    }
    @Test
    public void test506_GET() throws Exception {
        assertCode(506, GET);
    }
    @Test
    public void test506_POST() throws Exception {
        assertCode(506, POST);
    }
    @Test
    public void test506_PUT() throws Exception {
        assertCode(506, PUT);
    }
    @Test
    public void test506_DELETE() throws Exception {
        assertCode(506, DELETE);
    }
    @Test
    public void test506_OPTIONS() throws Exception {
        assertCode(506, OPTIONS);
    }
    @Test
    public void test506_HEAD() throws Exception {
        assertCode(506, HEAD);
    }
    @Test
    public void test507_GET() throws Exception {
        assertCode(507, GET);
    }
    @Test
    public void test507_POST() throws Exception {
        assertCode(507, POST);
    }
    @Test
    public void test507_PUT() throws Exception {
        assertCode(507, PUT);
    }
    @Test
    public void test507_DELETE() throws Exception {
        assertCode(507, DELETE);
    }
    @Test
    public void test507_OPTIONS() throws Exception {
        assertCode(507, OPTIONS);
    }
    @Test
    public void test507_HEAD() throws Exception {
        assertCode(507, HEAD);
    }
    @Test
    public void test508_GET() throws Exception {
        assertCode(508, GET);
    }
    @Test
    public void test508_POST() throws Exception {
        assertCode(508, POST);
    }
    @Test
    public void test508_PUT() throws Exception {
        assertCode(508, PUT);
    }
    @Test
    public void test508_DELETE() throws Exception {
        assertCode(508, DELETE);
    }
    @Test
    public void test508_OPTIONS() throws Exception {
        assertCode(508, OPTIONS);
    }
    @Test
    public void test508_HEAD() throws Exception {
        assertCode(508, HEAD);
    }
    @Test
    public void test509_GET() throws Exception {
        assertCode(509, GET);
    }
    @Test
    public void test509_POST() throws Exception {
        assertCode(509, POST);
    }
    @Test
    public void test509_PUT() throws Exception {
        assertCode(509, PUT);
    }
    @Test
    public void test509_DELETE() throws Exception {
        assertCode(509, DELETE);
    }
    @Test
    public void test509_OPTIONS() throws Exception {
        assertCode(509, OPTIONS);
    }
    @Test
    public void test509_HEAD() throws Exception {
        assertCode(509, HEAD);
    }
    @Test
    public void test510_GET() throws Exception {
        assertCode(510, GET);
    }
    @Test
    public void test510_POST() throws Exception {
        assertCode(510, POST);
    }
    @Test
    public void test510_PUT() throws Exception {
        assertCode(510, PUT);
    }
    @Test
    public void test510_DELETE() throws Exception {
        assertCode(510, DELETE);
    }
    @Test
    public void test510_OPTIONS() throws Exception {
        assertCode(510, OPTIONS);
    }
    @Test
    public void test510_HEAD() throws Exception {
        assertCode(510, HEAD);
    }
    @Test
    public void test511_GET() throws Exception {
        assertCode(511, GET);
    }
    @Test
    public void test511_POST() throws Exception {
        assertCode(511, POST);
    }
    @Test
    public void test511_PUT() throws Exception {
        assertCode(511, PUT);
    }
    @Test
    public void test511_DELETE() throws Exception {
        assertCode(511, DELETE);
    }
    @Test
    public void test511_OPTIONS() throws Exception {
        assertCode(511, OPTIONS);
    }
    @Test
    public void test511_HEAD() throws Exception {
        assertCode(511, HEAD);
    }
    @Test
    public void test512_GET() throws Exception {
        assertCode(512, GET);
    }
    @Test
    public void test512_POST() throws Exception {
        assertCode(512, POST);
    }
    @Test
    public void test512_PUT() throws Exception {
        assertCode(512, PUT);
    }
    @Test
    public void test512_DELETE() throws Exception {
        assertCode(512, DELETE);
    }
    @Test
    public void test512_OPTIONS() throws Exception {
        assertCode(512, OPTIONS);
    }
    @Test
    public void test512_HEAD() throws Exception {
        assertCode(512, HEAD);
    }
    @Test
    public void test513_GET() throws Exception {
        assertCode(513, GET);
    }
    @Test
    public void test513_POST() throws Exception {
        assertCode(513, POST);
    }
    @Test
    public void test513_PUT() throws Exception {
        assertCode(513, PUT);
    }
    @Test
    public void test513_DELETE() throws Exception {
        assertCode(513, DELETE);
    }
    @Test
    public void test513_OPTIONS() throws Exception {
        assertCode(513, OPTIONS);
    }
    @Test
    public void test513_HEAD() throws Exception {
        assertCode(513, HEAD);
    }
    @Test
    public void test514_GET() throws Exception {
        assertCode(514, GET);
    }
    @Test
    public void test514_POST() throws Exception {
        assertCode(514, POST);
    }
    @Test
    public void test514_PUT() throws Exception {
        assertCode(514, PUT);
    }
    @Test
    public void test514_DELETE() throws Exception {
        assertCode(514, DELETE);
    }
    @Test
    public void test514_OPTIONS() throws Exception {
        assertCode(514, OPTIONS);
    }
    @Test
    public void test514_HEAD() throws Exception {
        assertCode(514, HEAD);
    }
    @Test
    public void test515_GET() throws Exception {
        assertCode(515, GET);
    }
    @Test
    public void test515_POST() throws Exception {
        assertCode(515, POST);
    }
    @Test
    public void test515_PUT() throws Exception {
        assertCode(515, PUT);
    }
    @Test
    public void test515_DELETE() throws Exception {
        assertCode(515, DELETE);
    }
    @Test
    public void test515_OPTIONS() throws Exception {
        assertCode(515, OPTIONS);
    }
    @Test
    public void test515_HEAD() throws Exception {
        assertCode(515, HEAD);
    }
    @Test
    public void test516_GET() throws Exception {
        assertCode(516, GET);
    }
    @Test
    public void test516_POST() throws Exception {
        assertCode(516, POST);
    }
    @Test
    public void test516_PUT() throws Exception {
        assertCode(516, PUT);
    }
    @Test
    public void test516_DELETE() throws Exception {
        assertCode(516, DELETE);
    }
    @Test
    public void test516_OPTIONS() throws Exception {
        assertCode(516, OPTIONS);
    }
    @Test
    public void test516_HEAD() throws Exception {
        assertCode(516, HEAD);
    }
    @Test
    public void test517_GET() throws Exception {
        assertCode(517, GET);
    }
    @Test
    public void test517_POST() throws Exception {
        assertCode(517, POST);
    }
    @Test
    public void test517_PUT() throws Exception {
        assertCode(517, PUT);
    }
    @Test
    public void test517_DELETE() throws Exception {
        assertCode(517, DELETE);
    }
    @Test
    public void test517_OPTIONS() throws Exception {
        assertCode(517, OPTIONS);
    }
    @Test
    public void test517_HEAD() throws Exception {
        assertCode(517, HEAD);
    }
    @Test
    public void test518_GET() throws Exception {
        assertCode(518, GET);
    }
    @Test
    public void test518_POST() throws Exception {
        assertCode(518, POST);
    }
    @Test
    public void test518_PUT() throws Exception {
        assertCode(518, PUT);
    }
    @Test
    public void test518_DELETE() throws Exception {
        assertCode(518, DELETE);
    }
    @Test
    public void test518_OPTIONS() throws Exception {
        assertCode(518, OPTIONS);
    }
    @Test
    public void test518_HEAD() throws Exception {
        assertCode(518, HEAD);
    }
    @Test
    public void test519_GET() throws Exception {
        assertCode(519, GET);
    }
    @Test
    public void test519_POST() throws Exception {
        assertCode(519, POST);
    }
    @Test
    public void test519_PUT() throws Exception {
        assertCode(519, PUT);
    }
    @Test
    public void test519_DELETE() throws Exception {
        assertCode(519, DELETE);
    }
    @Test
    public void test519_OPTIONS() throws Exception {
        assertCode(519, OPTIONS);
    }
    @Test
    public void test519_HEAD() throws Exception {
        assertCode(519, HEAD);
    }
    @Test
    public void test520_GET() throws Exception {
        assertCode(520, GET);
    }
    @Test
    public void test520_POST() throws Exception {
        assertCode(520, POST);
    }
    @Test
    public void test520_PUT() throws Exception {
        assertCode(520, PUT);
    }
    @Test
    public void test520_DELETE() throws Exception {
        assertCode(520, DELETE);
    }
    @Test
    public void test520_OPTIONS() throws Exception {
        assertCode(520, OPTIONS);
    }
    @Test
    public void test520_HEAD() throws Exception {
        assertCode(520, HEAD);
    }
    @Test
    public void test521_GET() throws Exception {
        assertCode(521, GET);
    }
    @Test
    public void test521_POST() throws Exception {
        assertCode(521, POST);
    }
    @Test
    public void test521_PUT() throws Exception {
        assertCode(521, PUT);
    }
    @Test
    public void test521_DELETE() throws Exception {
        assertCode(521, DELETE);
    }
    @Test
    public void test521_OPTIONS() throws Exception {
        assertCode(521, OPTIONS);
    }
    @Test
    public void test521_HEAD() throws Exception {
        assertCode(521, HEAD);
    }
    @Test
    public void test522_GET() throws Exception {
        assertCode(522, GET);
    }
    @Test
    public void test522_POST() throws Exception {
        assertCode(522, POST);
    }
    @Test
    public void test522_PUT() throws Exception {
        assertCode(522, PUT);
    }
    @Test
    public void test522_DELETE() throws Exception {
        assertCode(522, DELETE);
    }
    @Test
    public void test522_OPTIONS() throws Exception {
        assertCode(522, OPTIONS);
    }
    @Test
    public void test522_HEAD() throws Exception {
        assertCode(522, HEAD);
    }
    @Test
    public void test523_GET() throws Exception {
        assertCode(523, GET);
    }
    @Test
    public void test523_POST() throws Exception {
        assertCode(523, POST);
    }
    @Test
    public void test523_PUT() throws Exception {
        assertCode(523, PUT);
    }
    @Test
    public void test523_DELETE() throws Exception {
        assertCode(523, DELETE);
    }
    @Test
    public void test523_OPTIONS() throws Exception {
        assertCode(523, OPTIONS);
    }
    @Test
    public void test523_HEAD() throws Exception {
        assertCode(523, HEAD);
    }
    @Test
    public void test524_GET() throws Exception {
        assertCode(524, GET);
    }
    @Test
    public void test524_POST() throws Exception {
        assertCode(524, POST);
    }
    @Test
    public void test524_PUT() throws Exception {
        assertCode(524, PUT);
    }
    @Test
    public void test524_DELETE() throws Exception {
        assertCode(524, DELETE);
    }
    @Test
    public void test524_OPTIONS() throws Exception {
        assertCode(524, OPTIONS);
    }
    @Test
    public void test524_HEAD() throws Exception {
        assertCode(524, HEAD);
    }
    @Test
    public void test525_GET() throws Exception {
        assertCode(525, GET);
    }
    @Test
    public void test525_POST() throws Exception {
        assertCode(525, POST);
    }
    @Test
    public void test525_PUT() throws Exception {
        assertCode(525, PUT);
    }
    @Test
    public void test525_DELETE() throws Exception {
        assertCode(525, DELETE);
    }
    @Test
    public void test525_OPTIONS() throws Exception {
        assertCode(525, OPTIONS);
    }
    @Test
    public void test525_HEAD() throws Exception {
        assertCode(525, HEAD);
    }
    @Test
    public void test526_GET() throws Exception {
        assertCode(526, GET);
    }
    @Test
    public void test526_POST() throws Exception {
        assertCode(526, POST);
    }
    @Test
    public void test526_PUT() throws Exception {
        assertCode(526, PUT);
    }
    @Test
    public void test526_DELETE() throws Exception {
        assertCode(526, DELETE);
    }
    @Test
    public void test526_OPTIONS() throws Exception {
        assertCode(526, OPTIONS);
    }
    @Test
    public void test526_HEAD() throws Exception {
        assertCode(526, HEAD);
    }
    @Test
    public void test527_GET() throws Exception {
        assertCode(527, GET);
    }
    @Test
    public void test527_POST() throws Exception {
        assertCode(527, POST);
    }
    @Test
    public void test527_PUT() throws Exception {
        assertCode(527, PUT);
    }
    @Test
    public void test527_DELETE() throws Exception {
        assertCode(527, DELETE);
    }
    @Test
    public void test527_OPTIONS() throws Exception {
        assertCode(527, OPTIONS);
    }
    @Test
    public void test527_HEAD() throws Exception {
        assertCode(527, HEAD);
    }
    @Test
    public void test528_GET() throws Exception {
        assertCode(528, GET);
    }
    @Test
    public void test528_POST() throws Exception {
        assertCode(528, POST);
    }
    @Test
    public void test528_PUT() throws Exception {
        assertCode(528, PUT);
    }
    @Test
    public void test528_DELETE() throws Exception {
        assertCode(528, DELETE);
    }
    @Test
    public void test528_OPTIONS() throws Exception {
        assertCode(528, OPTIONS);
    }
    @Test
    public void test528_HEAD() throws Exception {
        assertCode(528, HEAD);
    }
    @Test
    public void test529_GET() throws Exception {
        assertCode(529, GET);
    }
    @Test
    public void test529_POST() throws Exception {
        assertCode(529, POST);
    }
    @Test
    public void test529_PUT() throws Exception {
        assertCode(529, PUT);
    }
    @Test
    public void test529_DELETE() throws Exception {
        assertCode(529, DELETE);
    }
    @Test
    public void test529_OPTIONS() throws Exception {
        assertCode(529, OPTIONS);
    }
    @Test
    public void test529_HEAD() throws Exception {
        assertCode(529, HEAD);
    }
    @Test
    public void test530_GET() throws Exception {
        assertCode(530, GET);
    }
    @Test
    public void test530_POST() throws Exception {
        assertCode(530, POST);
    }
    @Test
    public void test530_PUT() throws Exception {
        assertCode(530, PUT);
    }
    @Test
    public void test530_DELETE() throws Exception {
        assertCode(530, DELETE);
    }
    @Test
    public void test530_OPTIONS() throws Exception {
        assertCode(530, OPTIONS);
    }
    @Test
    public void test530_HEAD() throws Exception {
        assertCode(530, HEAD);
    }
    @Test
    public void test531_GET() throws Exception {
        assertCode(531, GET);
    }
    @Test
    public void test531_POST() throws Exception {
        assertCode(531, POST);
    }
    @Test
    public void test531_PUT() throws Exception {
        assertCode(531, PUT);
    }
    @Test
    public void test531_DELETE() throws Exception {
        assertCode(531, DELETE);
    }
    @Test
    public void test531_OPTIONS() throws Exception {
        assertCode(531, OPTIONS);
    }
    @Test
    public void test531_HEAD() throws Exception {
        assertCode(531, HEAD);
    }
    @Test
    public void test532_GET() throws Exception {
        assertCode(532, GET);
    }
    @Test
    public void test532_POST() throws Exception {
        assertCode(532, POST);
    }
    @Test
    public void test532_PUT() throws Exception {
        assertCode(532, PUT);
    }
    @Test
    public void test532_DELETE() throws Exception {
        assertCode(532, DELETE);
    }
    @Test
    public void test532_OPTIONS() throws Exception {
        assertCode(532, OPTIONS);
    }
    @Test
    public void test532_HEAD() throws Exception {
        assertCode(532, HEAD);
    }
    @Test
    public void test533_GET() throws Exception {
        assertCode(533, GET);
    }
    @Test
    public void test533_POST() throws Exception {
        assertCode(533, POST);
    }
    @Test
    public void test533_PUT() throws Exception {
        assertCode(533, PUT);
    }
    @Test
    public void test533_DELETE() throws Exception {
        assertCode(533, DELETE);
    }
    @Test
    public void test533_OPTIONS() throws Exception {
        assertCode(533, OPTIONS);
    }
    @Test
    public void test533_HEAD() throws Exception {
        assertCode(533, HEAD);
    }
    @Test
    public void test534_GET() throws Exception {
        assertCode(534, GET);
    }
    @Test
    public void test534_POST() throws Exception {
        assertCode(534, POST);
    }
    @Test
    public void test534_PUT() throws Exception {
        assertCode(534, PUT);
    }
    @Test
    public void test534_DELETE() throws Exception {
        assertCode(534, DELETE);
    }
    @Test
    public void test534_OPTIONS() throws Exception {
        assertCode(534, OPTIONS);
    }
    @Test
    public void test534_HEAD() throws Exception {
        assertCode(534, HEAD);
    }
    @Test
    public void test535_GET() throws Exception {
        assertCode(535, GET);
    }
    @Test
    public void test535_POST() throws Exception {
        assertCode(535, POST);
    }
    @Test
    public void test535_PUT() throws Exception {
        assertCode(535, PUT);
    }
    @Test
    public void test535_DELETE() throws Exception {
        assertCode(535, DELETE);
    }
    @Test
    public void test535_OPTIONS() throws Exception {
        assertCode(535, OPTIONS);
    }
    @Test
    public void test535_HEAD() throws Exception {
        assertCode(535, HEAD);
    }
    @Test
    public void test536_GET() throws Exception {
        assertCode(536, GET);
    }
    @Test
    public void test536_POST() throws Exception {
        assertCode(536, POST);
    }
    @Test
    public void test536_PUT() throws Exception {
        assertCode(536, PUT);
    }
    @Test
    public void test536_DELETE() throws Exception {
        assertCode(536, DELETE);
    }
    @Test
    public void test536_OPTIONS() throws Exception {
        assertCode(536, OPTIONS);
    }
    @Test
    public void test536_HEAD() throws Exception {
        assertCode(536, HEAD);
    }
    @Test
    public void test537_GET() throws Exception {
        assertCode(537, GET);
    }
    @Test
    public void test537_POST() throws Exception {
        assertCode(537, POST);
    }
    @Test
    public void test537_PUT() throws Exception {
        assertCode(537, PUT);
    }
    @Test
    public void test537_DELETE() throws Exception {
        assertCode(537, DELETE);
    }
    @Test
    public void test537_OPTIONS() throws Exception {
        assertCode(537, OPTIONS);
    }
    @Test
    public void test537_HEAD() throws Exception {
        assertCode(537, HEAD);
    }
    @Test
    public void test538_GET() throws Exception {
        assertCode(538, GET);
    }
    @Test
    public void test538_POST() throws Exception {
        assertCode(538, POST);
    }
    @Test
    public void test538_PUT() throws Exception {
        assertCode(538, PUT);
    }
    @Test
    public void test538_DELETE() throws Exception {
        assertCode(538, DELETE);
    }
    @Test
    public void test538_OPTIONS() throws Exception {
        assertCode(538, OPTIONS);
    }
    @Test
    public void test538_HEAD() throws Exception {
        assertCode(538, HEAD);
    }
    @Test
    public void test539_GET() throws Exception {
        assertCode(539, GET);
    }
    @Test
    public void test539_POST() throws Exception {
        assertCode(539, POST);
    }
    @Test
    public void test539_PUT() throws Exception {
        assertCode(539, PUT);
    }
    @Test
    public void test539_DELETE() throws Exception {
        assertCode(539, DELETE);
    }
    @Test
    public void test539_OPTIONS() throws Exception {
        assertCode(539, OPTIONS);
    }
    @Test
    public void test539_HEAD() throws Exception {
        assertCode(539, HEAD);
    }
    @Test
    public void test540_GET() throws Exception {
        assertCode(540, GET);
    }
    @Test
    public void test540_POST() throws Exception {
        assertCode(540, POST);
    }
    @Test
    public void test540_PUT() throws Exception {
        assertCode(540, PUT);
    }
    @Test
    public void test540_DELETE() throws Exception {
        assertCode(540, DELETE);
    }
    @Test
    public void test540_OPTIONS() throws Exception {
        assertCode(540, OPTIONS);
    }
    @Test
    public void test540_HEAD() throws Exception {
        assertCode(540, HEAD);
    }
    @Test
    public void test541_GET() throws Exception {
        assertCode(541, GET);
    }
    @Test
    public void test541_POST() throws Exception {
        assertCode(541, POST);
    }
    @Test
    public void test541_PUT() throws Exception {
        assertCode(541, PUT);
    }
    @Test
    public void test541_DELETE() throws Exception {
        assertCode(541, DELETE);
    }
    @Test
    public void test541_OPTIONS() throws Exception {
        assertCode(541, OPTIONS);
    }
    @Test
    public void test541_HEAD() throws Exception {
        assertCode(541, HEAD);
    }
    @Test
    public void test542_GET() throws Exception {
        assertCode(542, GET);
    }
    @Test
    public void test542_POST() throws Exception {
        assertCode(542, POST);
    }
    @Test
    public void test542_PUT() throws Exception {
        assertCode(542, PUT);
    }
    @Test
    public void test542_DELETE() throws Exception {
        assertCode(542, DELETE);
    }
    @Test
    public void test542_OPTIONS() throws Exception {
        assertCode(542, OPTIONS);
    }
    @Test
    public void test542_HEAD() throws Exception {
        assertCode(542, HEAD);
    }
    @Test
    public void test543_GET() throws Exception {
        assertCode(543, GET);
    }
    @Test
    public void test543_POST() throws Exception {
        assertCode(543, POST);
    }
    @Test
    public void test543_PUT() throws Exception {
        assertCode(543, PUT);
    }
    @Test
    public void test543_DELETE() throws Exception {
        assertCode(543, DELETE);
    }
    @Test
    public void test543_OPTIONS() throws Exception {
        assertCode(543, OPTIONS);
    }
    @Test
    public void test543_HEAD() throws Exception {
        assertCode(543, HEAD);
    }
    @Test
    public void test544_GET() throws Exception {
        assertCode(544, GET);
    }
    @Test
    public void test544_POST() throws Exception {
        assertCode(544, POST);
    }
    @Test
    public void test544_PUT() throws Exception {
        assertCode(544, PUT);
    }
    @Test
    public void test544_DELETE() throws Exception {
        assertCode(544, DELETE);
    }
    @Test
    public void test544_OPTIONS() throws Exception {
        assertCode(544, OPTIONS);
    }
    @Test
    public void test544_HEAD() throws Exception {
        assertCode(544, HEAD);
    }
    @Test
    public void test545_GET() throws Exception {
        assertCode(545, GET);
    }
    @Test
    public void test545_POST() throws Exception {
        assertCode(545, POST);
    }
    @Test
    public void test545_PUT() throws Exception {
        assertCode(545, PUT);
    }
    @Test
    public void test545_DELETE() throws Exception {
        assertCode(545, DELETE);
    }
    @Test
    public void test545_OPTIONS() throws Exception {
        assertCode(545, OPTIONS);
    }
    @Test
    public void test545_HEAD() throws Exception {
        assertCode(545, HEAD);
    }
    @Test
    public void test546_GET() throws Exception {
        assertCode(546, GET);
    }
    @Test
    public void test546_POST() throws Exception {
        assertCode(546, POST);
    }
    @Test
    public void test546_PUT() throws Exception {
        assertCode(546, PUT);
    }
    @Test
    public void test546_DELETE() throws Exception {
        assertCode(546, DELETE);
    }
    @Test
    public void test546_OPTIONS() throws Exception {
        assertCode(546, OPTIONS);
    }
    @Test
    public void test546_HEAD() throws Exception {
        assertCode(546, HEAD);
    }
    @Test
    public void test547_GET() throws Exception {
        assertCode(547, GET);
    }
    @Test
    public void test547_POST() throws Exception {
        assertCode(547, POST);
    }
    @Test
    public void test547_PUT() throws Exception {
        assertCode(547, PUT);
    }
    @Test
    public void test547_DELETE() throws Exception {
        assertCode(547, DELETE);
    }
    @Test
    public void test547_OPTIONS() throws Exception {
        assertCode(547, OPTIONS);
    }
    @Test
    public void test547_HEAD() throws Exception {
        assertCode(547, HEAD);
    }
    @Test
    public void test548_GET() throws Exception {
        assertCode(548, GET);
    }
    @Test
    public void test548_POST() throws Exception {
        assertCode(548, POST);
    }
    @Test
    public void test548_PUT() throws Exception {
        assertCode(548, PUT);
    }
    @Test
    public void test548_DELETE() throws Exception {
        assertCode(548, DELETE);
    }
    @Test
    public void test548_OPTIONS() throws Exception {
        assertCode(548, OPTIONS);
    }
    @Test
    public void test548_HEAD() throws Exception {
        assertCode(548, HEAD);
    }
    @Test
    public void test549_GET() throws Exception {
        assertCode(549, GET);
    }
    @Test
    public void test549_POST() throws Exception {
        assertCode(549, POST);
    }
    @Test
    public void test549_PUT() throws Exception {
        assertCode(549, PUT);
    }
    @Test
    public void test549_DELETE() throws Exception {
        assertCode(549, DELETE);
    }
    @Test
    public void test549_OPTIONS() throws Exception {
        assertCode(549, OPTIONS);
    }
    @Test
    public void test549_HEAD() throws Exception {
        assertCode(549, HEAD);
    }
    @Test
    public void test550_GET() throws Exception {
        assertCode(550, GET);
    }
    @Test
    public void test550_POST() throws Exception {
        assertCode(550, POST);
    }
    @Test
    public void test550_PUT() throws Exception {
        assertCode(550, PUT);
    }
    @Test
    public void test550_DELETE() throws Exception {
        assertCode(550, DELETE);
    }
    @Test
    public void test550_OPTIONS() throws Exception {
        assertCode(550, OPTIONS);
    }
    @Test
    public void test550_HEAD() throws Exception {
        assertCode(550, HEAD);
    }
    @Test
    public void test551_GET() throws Exception {
        assertCode(551, GET);
    }
    @Test
    public void test551_POST() throws Exception {
        assertCode(551, POST);
    }
    @Test
    public void test551_PUT() throws Exception {
        assertCode(551, PUT);
    }
    @Test
    public void test551_DELETE() throws Exception {
        assertCode(551, DELETE);
    }
    @Test
    public void test551_OPTIONS() throws Exception {
        assertCode(551, OPTIONS);
    }
    @Test
    public void test551_HEAD() throws Exception {
        assertCode(551, HEAD);
    }
    @Test
    public void test552_GET() throws Exception {
        assertCode(552, GET);
    }
    @Test
    public void test552_POST() throws Exception {
        assertCode(552, POST);
    }
    @Test
    public void test552_PUT() throws Exception {
        assertCode(552, PUT);
    }
    @Test
    public void test552_DELETE() throws Exception {
        assertCode(552, DELETE);
    }
    @Test
    public void test552_OPTIONS() throws Exception {
        assertCode(552, OPTIONS);
    }
    @Test
    public void test552_HEAD() throws Exception {
        assertCode(552, HEAD);
    }
    @Test
    public void test553_GET() throws Exception {
        assertCode(553, GET);
    }
    @Test
    public void test553_POST() throws Exception {
        assertCode(553, POST);
    }
    @Test
    public void test553_PUT() throws Exception {
        assertCode(553, PUT);
    }
    @Test
    public void test553_DELETE() throws Exception {
        assertCode(553, DELETE);
    }
    @Test
    public void test553_OPTIONS() throws Exception {
        assertCode(553, OPTIONS);
    }
    @Test
    public void test553_HEAD() throws Exception {
        assertCode(553, HEAD);
    }
    @Test
    public void test554_GET() throws Exception {
        assertCode(554, GET);
    }
    @Test
    public void test554_POST() throws Exception {
        assertCode(554, POST);
    }
    @Test
    public void test554_PUT() throws Exception {
        assertCode(554, PUT);
    }
    @Test
    public void test554_DELETE() throws Exception {
        assertCode(554, DELETE);
    }
    @Test
    public void test554_OPTIONS() throws Exception {
        assertCode(554, OPTIONS);
    }
    @Test
    public void test554_HEAD() throws Exception {
        assertCode(554, HEAD);
    }
    @Test
    public void test555_GET() throws Exception {
        assertCode(555, GET);
    }
    @Test
    public void test555_POST() throws Exception {
        assertCode(555, POST);
    }
    @Test
    public void test555_PUT() throws Exception {
        assertCode(555, PUT);
    }
    @Test
    public void test555_DELETE() throws Exception {
        assertCode(555, DELETE);
    }
    @Test
    public void test555_OPTIONS() throws Exception {
        assertCode(555, OPTIONS);
    }
    @Test
    public void test555_HEAD() throws Exception {
        assertCode(555, HEAD);
    }
    @Test
    public void test556_GET() throws Exception {
        assertCode(556, GET);
    }
    @Test
    public void test556_POST() throws Exception {
        assertCode(556, POST);
    }
    @Test
    public void test556_PUT() throws Exception {
        assertCode(556, PUT);
    }
    @Test
    public void test556_DELETE() throws Exception {
        assertCode(556, DELETE);
    }
    @Test
    public void test556_OPTIONS() throws Exception {
        assertCode(556, OPTIONS);
    }
    @Test
    public void test556_HEAD() throws Exception {
        assertCode(556, HEAD);
    }
    @Test
    public void test557_GET() throws Exception {
        assertCode(557, GET);
    }
    @Test
    public void test557_POST() throws Exception {
        assertCode(557, POST);
    }
    @Test
    public void test557_PUT() throws Exception {
        assertCode(557, PUT);
    }
    @Test
    public void test557_DELETE() throws Exception {
        assertCode(557, DELETE);
    }
    @Test
    public void test557_OPTIONS() throws Exception {
        assertCode(557, OPTIONS);
    }
    @Test
    public void test557_HEAD() throws Exception {
        assertCode(557, HEAD);
    }
    @Test
    public void test558_GET() throws Exception {
        assertCode(558, GET);
    }
    @Test
    public void test558_POST() throws Exception {
        assertCode(558, POST);
    }
    @Test
    public void test558_PUT() throws Exception {
        assertCode(558, PUT);
    }
    @Test
    public void test558_DELETE() throws Exception {
        assertCode(558, DELETE);
    }
    @Test
    public void test558_OPTIONS() throws Exception {
        assertCode(558, OPTIONS);
    }
    @Test
    public void test558_HEAD() throws Exception {
        assertCode(558, HEAD);
    }
    @Test
    public void test559_GET() throws Exception {
        assertCode(559, GET);
    }
    @Test
    public void test559_POST() throws Exception {
        assertCode(559, POST);
    }
    @Test
    public void test559_PUT() throws Exception {
        assertCode(559, PUT);
    }
    @Test
    public void test559_DELETE() throws Exception {
        assertCode(559, DELETE);
    }
    @Test
    public void test559_OPTIONS() throws Exception {
        assertCode(559, OPTIONS);
    }
    @Test
    public void test559_HEAD() throws Exception {
        assertCode(559, HEAD);
    }
    @Test
    public void test560_GET() throws Exception {
        assertCode(560, GET);
    }
    @Test
    public void test560_POST() throws Exception {
        assertCode(560, POST);
    }
    @Test
    public void test560_PUT() throws Exception {
        assertCode(560, PUT);
    }
    @Test
    public void test560_DELETE() throws Exception {
        assertCode(560, DELETE);
    }
    @Test
    public void test560_OPTIONS() throws Exception {
        assertCode(560, OPTIONS);
    }
    @Test
    public void test560_HEAD() throws Exception {
        assertCode(560, HEAD);
    }
    @Test
    public void test561_GET() throws Exception {
        assertCode(561, GET);
    }
    @Test
    public void test561_POST() throws Exception {
        assertCode(561, POST);
    }
    @Test
    public void test561_PUT() throws Exception {
        assertCode(561, PUT);
    }
    @Test
    public void test561_DELETE() throws Exception {
        assertCode(561, DELETE);
    }
    @Test
    public void test561_OPTIONS() throws Exception {
        assertCode(561, OPTIONS);
    }
    @Test
    public void test561_HEAD() throws Exception {
        assertCode(561, HEAD);
    }
    @Test
    public void test562_GET() throws Exception {
        assertCode(562, GET);
    }
    @Test
    public void test562_POST() throws Exception {
        assertCode(562, POST);
    }
    @Test
    public void test562_PUT() throws Exception {
        assertCode(562, PUT);
    }
    @Test
    public void test562_DELETE() throws Exception {
        assertCode(562, DELETE);
    }
    @Test
    public void test562_OPTIONS() throws Exception {
        assertCode(562, OPTIONS);
    }
    @Test
    public void test562_HEAD() throws Exception {
        assertCode(562, HEAD);
    }
    @Test
    public void test563_GET() throws Exception {
        assertCode(563, GET);
    }
    @Test
    public void test563_POST() throws Exception {
        assertCode(563, POST);
    }
    @Test
    public void test563_PUT() throws Exception {
        assertCode(563, PUT);
    }
    @Test
    public void test563_DELETE() throws Exception {
        assertCode(563, DELETE);
    }
    @Test
    public void test563_OPTIONS() throws Exception {
        assertCode(563, OPTIONS);
    }
    @Test
    public void test563_HEAD() throws Exception {
        assertCode(563, HEAD);
    }
    @Test
    public void test564_GET() throws Exception {
        assertCode(564, GET);
    }
    @Test
    public void test564_POST() throws Exception {
        assertCode(564, POST);
    }
    @Test
    public void test564_PUT() throws Exception {
        assertCode(564, PUT);
    }
    @Test
    public void test564_DELETE() throws Exception {
        assertCode(564, DELETE);
    }
    @Test
    public void test564_OPTIONS() throws Exception {
        assertCode(564, OPTIONS);
    }
    @Test
    public void test564_HEAD() throws Exception {
        assertCode(564, HEAD);
    }
    @Test
    public void test565_GET() throws Exception {
        assertCode(565, GET);
    }
    @Test
    public void test565_POST() throws Exception {
        assertCode(565, POST);
    }
    @Test
    public void test565_PUT() throws Exception {
        assertCode(565, PUT);
    }
    @Test
    public void test565_DELETE() throws Exception {
        assertCode(565, DELETE);
    }
    @Test
    public void test565_OPTIONS() throws Exception {
        assertCode(565, OPTIONS);
    }
    @Test
    public void test565_HEAD() throws Exception {
        assertCode(565, HEAD);
    }
    @Test
    public void test566_GET() throws Exception {
        assertCode(566, GET);
    }
    @Test
    public void test566_POST() throws Exception {
        assertCode(566, POST);
    }
    @Test
    public void test566_PUT() throws Exception {
        assertCode(566, PUT);
    }
    @Test
    public void test566_DELETE() throws Exception {
        assertCode(566, DELETE);
    }
    @Test
    public void test566_OPTIONS() throws Exception {
        assertCode(566, OPTIONS);
    }
    @Test
    public void test566_HEAD() throws Exception {
        assertCode(566, HEAD);
    }
    @Test
    public void test567_GET() throws Exception {
        assertCode(567, GET);
    }
    @Test
    public void test567_POST() throws Exception {
        assertCode(567, POST);
    }
    @Test
    public void test567_PUT() throws Exception {
        assertCode(567, PUT);
    }
    @Test
    public void test567_DELETE() throws Exception {
        assertCode(567, DELETE);
    }
    @Test
    public void test567_OPTIONS() throws Exception {
        assertCode(567, OPTIONS);
    }
    @Test
    public void test567_HEAD() throws Exception {
        assertCode(567, HEAD);
    }
    @Test
    public void test568_GET() throws Exception {
        assertCode(568, GET);
    }
    @Test
    public void test568_POST() throws Exception {
        assertCode(568, POST);
    }
    @Test
    public void test568_PUT() throws Exception {
        assertCode(568, PUT);
    }
    @Test
    public void test568_DELETE() throws Exception {
        assertCode(568, DELETE);
    }
    @Test
    public void test568_OPTIONS() throws Exception {
        assertCode(568, OPTIONS);
    }
    @Test
    public void test568_HEAD() throws Exception {
        assertCode(568, HEAD);
    }
    @Test
    public void test569_GET() throws Exception {
        assertCode(569, GET);
    }
    @Test
    public void test569_POST() throws Exception {
        assertCode(569, POST);
    }
    @Test
    public void test569_PUT() throws Exception {
        assertCode(569, PUT);
    }
    @Test
    public void test569_DELETE() throws Exception {
        assertCode(569, DELETE);
    }
    @Test
    public void test569_OPTIONS() throws Exception {
        assertCode(569, OPTIONS);
    }
    @Test
    public void test569_HEAD() throws Exception {
        assertCode(569, HEAD);
    }
    @Test
    public void test570_GET() throws Exception {
        assertCode(570, GET);
    }
    @Test
    public void test570_POST() throws Exception {
        assertCode(570, POST);
    }
    @Test
    public void test570_PUT() throws Exception {
        assertCode(570, PUT);
    }
    @Test
    public void test570_DELETE() throws Exception {
        assertCode(570, DELETE);
    }
    @Test
    public void test570_OPTIONS() throws Exception {
        assertCode(570, OPTIONS);
    }
    @Test
    public void test570_HEAD() throws Exception {
        assertCode(570, HEAD);
    }
    @Test
    public void test571_GET() throws Exception {
        assertCode(571, GET);
    }
    @Test
    public void test571_POST() throws Exception {
        assertCode(571, POST);
    }
    @Test
    public void test571_PUT() throws Exception {
        assertCode(571, PUT);
    }
    @Test
    public void test571_DELETE() throws Exception {
        assertCode(571, DELETE);
    }
    @Test
    public void test571_OPTIONS() throws Exception {
        assertCode(571, OPTIONS);
    }
    @Test
    public void test571_HEAD() throws Exception {
        assertCode(571, HEAD);
    }
    @Test
    public void test572_GET() throws Exception {
        assertCode(572, GET);
    }
    @Test
    public void test572_POST() throws Exception {
        assertCode(572, POST);
    }
    @Test
    public void test572_PUT() throws Exception {
        assertCode(572, PUT);
    }
    @Test
    public void test572_DELETE() throws Exception {
        assertCode(572, DELETE);
    }
    @Test
    public void test572_OPTIONS() throws Exception {
        assertCode(572, OPTIONS);
    }
    @Test
    public void test572_HEAD() throws Exception {
        assertCode(572, HEAD);
    }
    @Test
    public void test573_GET() throws Exception {
        assertCode(573, GET);
    }
    @Test
    public void test573_POST() throws Exception {
        assertCode(573, POST);
    }
    @Test
    public void test573_PUT() throws Exception {
        assertCode(573, PUT);
    }
    @Test
    public void test573_DELETE() throws Exception {
        assertCode(573, DELETE);
    }
    @Test
    public void test573_OPTIONS() throws Exception {
        assertCode(573, OPTIONS);
    }
    @Test
    public void test573_HEAD() throws Exception {
        assertCode(573, HEAD);
    }
    @Test
    public void test574_GET() throws Exception {
        assertCode(574, GET);
    }
    @Test
    public void test574_POST() throws Exception {
        assertCode(574, POST);
    }
    @Test
    public void test574_PUT() throws Exception {
        assertCode(574, PUT);
    }
    @Test
    public void test574_DELETE() throws Exception {
        assertCode(574, DELETE);
    }
    @Test
    public void test574_OPTIONS() throws Exception {
        assertCode(574, OPTIONS);
    }
    @Test
    public void test574_HEAD() throws Exception {
        assertCode(574, HEAD);
    }
    @Test
    public void test575_GET() throws Exception {
        assertCode(575, GET);
    }
    @Test
    public void test575_POST() throws Exception {
        assertCode(575, POST);
    }
    @Test
    public void test575_PUT() throws Exception {
        assertCode(575, PUT);
    }
    @Test
    public void test575_DELETE() throws Exception {
        assertCode(575, DELETE);
    }
    @Test
    public void test575_OPTIONS() throws Exception {
        assertCode(575, OPTIONS);
    }
    @Test
    public void test575_HEAD() throws Exception {
        assertCode(575, HEAD);
    }
    @Test
    public void test576_GET() throws Exception {
        assertCode(576, GET);
    }
    @Test
    public void test576_POST() throws Exception {
        assertCode(576, POST);
    }
    @Test
    public void test576_PUT() throws Exception {
        assertCode(576, PUT);
    }
    @Test
    public void test576_DELETE() throws Exception {
        assertCode(576, DELETE);
    }
    @Test
    public void test576_OPTIONS() throws Exception {
        assertCode(576, OPTIONS);
    }
    @Test
    public void test576_HEAD() throws Exception {
        assertCode(576, HEAD);
    }
    @Test
    public void test577_GET() throws Exception {
        assertCode(577, GET);
    }
    @Test
    public void test577_POST() throws Exception {
        assertCode(577, POST);
    }
    @Test
    public void test577_PUT() throws Exception {
        assertCode(577, PUT);
    }
    @Test
    public void test577_DELETE() throws Exception {
        assertCode(577, DELETE);
    }
    @Test
    public void test577_OPTIONS() throws Exception {
        assertCode(577, OPTIONS);
    }
    @Test
    public void test577_HEAD() throws Exception {
        assertCode(577, HEAD);
    }
    @Test
    public void test578_GET() throws Exception {
        assertCode(578, GET);
    }
    @Test
    public void test578_POST() throws Exception {
        assertCode(578, POST);
    }
    @Test
    public void test578_PUT() throws Exception {
        assertCode(578, PUT);
    }
    @Test
    public void test578_DELETE() throws Exception {
        assertCode(578, DELETE);
    }
    @Test
    public void test578_OPTIONS() throws Exception {
        assertCode(578, OPTIONS);
    }
    @Test
    public void test578_HEAD() throws Exception {
        assertCode(578, HEAD);
    }
    @Test
    public void test579_GET() throws Exception {
        assertCode(579, GET);
    }
    @Test
    public void test579_POST() throws Exception {
        assertCode(579, POST);
    }
    @Test
    public void test579_PUT() throws Exception {
        assertCode(579, PUT);
    }
    @Test
    public void test579_DELETE() throws Exception {
        assertCode(579, DELETE);
    }
    @Test
    public void test579_OPTIONS() throws Exception {
        assertCode(579, OPTIONS);
    }
    @Test
    public void test579_HEAD() throws Exception {
        assertCode(579, HEAD);
    }
    @Test
    public void test580_GET() throws Exception {
        assertCode(580, GET);
    }
    @Test
    public void test580_POST() throws Exception {
        assertCode(580, POST);
    }
    @Test
    public void test580_PUT() throws Exception {
        assertCode(580, PUT);
    }
    @Test
    public void test580_DELETE() throws Exception {
        assertCode(580, DELETE);
    }
    @Test
    public void test580_OPTIONS() throws Exception {
        assertCode(580, OPTIONS);
    }
    @Test
    public void test580_HEAD() throws Exception {
        assertCode(580, HEAD);
    }
    @Test
    public void test581_GET() throws Exception {
        assertCode(581, GET);
    }
    @Test
    public void test581_POST() throws Exception {
        assertCode(581, POST);
    }
    @Test
    public void test581_PUT() throws Exception {
        assertCode(581, PUT);
    }
    @Test
    public void test581_DELETE() throws Exception {
        assertCode(581, DELETE);
    }
    @Test
    public void test581_OPTIONS() throws Exception {
        assertCode(581, OPTIONS);
    }
    @Test
    public void test581_HEAD() throws Exception {
        assertCode(581, HEAD);
    }
    @Test
    public void test582_GET() throws Exception {
        assertCode(582, GET);
    }
    @Test
    public void test582_POST() throws Exception {
        assertCode(582, POST);
    }
    @Test
    public void test582_PUT() throws Exception {
        assertCode(582, PUT);
    }
    @Test
    public void test582_DELETE() throws Exception {
        assertCode(582, DELETE);
    }
    @Test
    public void test582_OPTIONS() throws Exception {
        assertCode(582, OPTIONS);
    }
    @Test
    public void test582_HEAD() throws Exception {
        assertCode(582, HEAD);
    }
    @Test
    public void test583_GET() throws Exception {
        assertCode(583, GET);
    }
    @Test
    public void test583_POST() throws Exception {
        assertCode(583, POST);
    }
    @Test
    public void test583_PUT() throws Exception {
        assertCode(583, PUT);
    }
    @Test
    public void test583_DELETE() throws Exception {
        assertCode(583, DELETE);
    }
    @Test
    public void test583_OPTIONS() throws Exception {
        assertCode(583, OPTIONS);
    }
    @Test
    public void test583_HEAD() throws Exception {
        assertCode(583, HEAD);
    }
    @Test
    public void test584_GET() throws Exception {
        assertCode(584, GET);
    }
    @Test
    public void test584_POST() throws Exception {
        assertCode(584, POST);
    }
    @Test
    public void test584_PUT() throws Exception {
        assertCode(584, PUT);
    }
    @Test
    public void test584_DELETE() throws Exception {
        assertCode(584, DELETE);
    }
    @Test
    public void test584_OPTIONS() throws Exception {
        assertCode(584, OPTIONS);
    }
    @Test
    public void test584_HEAD() throws Exception {
        assertCode(584, HEAD);
    }
    @Test
    public void test585_GET() throws Exception {
        assertCode(585, GET);
    }
    @Test
    public void test585_POST() throws Exception {
        assertCode(585, POST);
    }
    @Test
    public void test585_PUT() throws Exception {
        assertCode(585, PUT);
    }
    @Test
    public void test585_DELETE() throws Exception {
        assertCode(585, DELETE);
    }
    @Test
    public void test585_OPTIONS() throws Exception {
        assertCode(585, OPTIONS);
    }
    @Test
    public void test585_HEAD() throws Exception {
        assertCode(585, HEAD);
    }
    @Test
    public void test586_GET() throws Exception {
        assertCode(586, GET);
    }
    @Test
    public void test586_POST() throws Exception {
        assertCode(586, POST);
    }
    @Test
    public void test586_PUT() throws Exception {
        assertCode(586, PUT);
    }
    @Test
    public void test586_DELETE() throws Exception {
        assertCode(586, DELETE);
    }
    @Test
    public void test586_OPTIONS() throws Exception {
        assertCode(586, OPTIONS);
    }
    @Test
    public void test586_HEAD() throws Exception {
        assertCode(586, HEAD);
    }
    @Test
    public void test587_GET() throws Exception {
        assertCode(587, GET);
    }
    @Test
    public void test587_POST() throws Exception {
        assertCode(587, POST);
    }
    @Test
    public void test587_PUT() throws Exception {
        assertCode(587, PUT);
    }
    @Test
    public void test587_DELETE() throws Exception {
        assertCode(587, DELETE);
    }
    @Test
    public void test587_OPTIONS() throws Exception {
        assertCode(587, OPTIONS);
    }
    @Test
    public void test587_HEAD() throws Exception {
        assertCode(587, HEAD);
    }
    @Test
    public void test588_GET() throws Exception {
        assertCode(588, GET);
    }
    @Test
    public void test588_POST() throws Exception {
        assertCode(588, POST);
    }
    @Test
    public void test588_PUT() throws Exception {
        assertCode(588, PUT);
    }
    @Test
    public void test588_DELETE() throws Exception {
        assertCode(588, DELETE);
    }
    @Test
    public void test588_OPTIONS() throws Exception {
        assertCode(588, OPTIONS);
    }
    @Test
    public void test588_HEAD() throws Exception {
        assertCode(588, HEAD);
    }
    @Test
    public void test589_GET() throws Exception {
        assertCode(589, GET);
    }
    @Test
    public void test589_POST() throws Exception {
        assertCode(589, POST);
    }
    @Test
    public void test589_PUT() throws Exception {
        assertCode(589, PUT);
    }
    @Test
    public void test589_DELETE() throws Exception {
        assertCode(589, DELETE);
    }
    @Test
    public void test589_OPTIONS() throws Exception {
        assertCode(589, OPTIONS);
    }
    @Test
    public void test589_HEAD() throws Exception {
        assertCode(589, HEAD);
    }
    @Test
    public void test590_GET() throws Exception {
        assertCode(590, GET);
    }
    @Test
    public void test590_POST() throws Exception {
        assertCode(590, POST);
    }
    @Test
    public void test590_PUT() throws Exception {
        assertCode(590, PUT);
    }
    @Test
    public void test590_DELETE() throws Exception {
        assertCode(590, DELETE);
    }
    @Test
    public void test590_OPTIONS() throws Exception {
        assertCode(590, OPTIONS);
    }
    @Test
    public void test590_HEAD() throws Exception {
        assertCode(590, HEAD);
    }
    @Test
    public void test591_GET() throws Exception {
        assertCode(591, GET);
    }
    @Test
    public void test591_POST() throws Exception {
        assertCode(591, POST);
    }
    @Test
    public void test591_PUT() throws Exception {
        assertCode(591, PUT);
    }
    @Test
    public void test591_DELETE() throws Exception {
        assertCode(591, DELETE);
    }
    @Test
    public void test591_OPTIONS() throws Exception {
        assertCode(591, OPTIONS);
    }
    @Test
    public void test591_HEAD() throws Exception {
        assertCode(591, HEAD);
    }
    @Test
    public void test592_GET() throws Exception {
        assertCode(592, GET);
    }
    @Test
    public void test592_POST() throws Exception {
        assertCode(592, POST);
    }
    @Test
    public void test592_PUT() throws Exception {
        assertCode(592, PUT);
    }
    @Test
    public void test592_DELETE() throws Exception {
        assertCode(592, DELETE);
    }
    @Test
    public void test592_OPTIONS() throws Exception {
        assertCode(592, OPTIONS);
    }
    @Test
    public void test592_HEAD() throws Exception {
        assertCode(592, HEAD);
    }
    @Test
    public void test593_GET() throws Exception {
        assertCode(593, GET);
    }
    @Test
    public void test593_POST() throws Exception {
        assertCode(593, POST);
    }
    @Test
    public void test593_PUT() throws Exception {
        assertCode(593, PUT);
    }
    @Test
    public void test593_DELETE() throws Exception {
        assertCode(593, DELETE);
    }
    @Test
    public void test593_OPTIONS() throws Exception {
        assertCode(593, OPTIONS);
    }
    @Test
    public void test593_HEAD() throws Exception {
        assertCode(593, HEAD);
    }
    @Test
    public void test594_GET() throws Exception {
        assertCode(594, GET);
    }
    @Test
    public void test594_POST() throws Exception {
        assertCode(594, POST);
    }
    @Test
    public void test594_PUT() throws Exception {
        assertCode(594, PUT);
    }
    @Test
    public void test594_DELETE() throws Exception {
        assertCode(594, DELETE);
    }
    @Test
    public void test594_OPTIONS() throws Exception {
        assertCode(594, OPTIONS);
    }
    @Test
    public void test594_HEAD() throws Exception {
        assertCode(594, HEAD);
    }
    @Test
    public void test595_GET() throws Exception {
        assertCode(595, GET);
    }
    @Test
    public void test595_POST() throws Exception {
        assertCode(595, POST);
    }
    @Test
    public void test595_PUT() throws Exception {
        assertCode(595, PUT);
    }
    @Test
    public void test595_DELETE() throws Exception {
        assertCode(595, DELETE);
    }
    @Test
    public void test595_OPTIONS() throws Exception {
        assertCode(595, OPTIONS);
    }
    @Test
    public void test595_HEAD() throws Exception {
        assertCode(595, HEAD);
    }
    @Test
    public void test596_GET() throws Exception {
        assertCode(596, GET);
    }
    @Test
    public void test596_POST() throws Exception {
        assertCode(596, POST);
    }
    @Test
    public void test596_PUT() throws Exception {
        assertCode(596, PUT);
    }
    @Test
    public void test596_DELETE() throws Exception {
        assertCode(596, DELETE);
    }
    @Test
    public void test596_OPTIONS() throws Exception {
        assertCode(596, OPTIONS);
    }
    @Test
    public void test596_HEAD() throws Exception {
        assertCode(596, HEAD);
    }
    @Test
    public void test597_GET() throws Exception {
        assertCode(597, GET);
    }
    @Test
    public void test597_POST() throws Exception {
        assertCode(597, POST);
    }
    @Test
    public void test597_PUT() throws Exception {
        assertCode(597, PUT);
    }
    @Test
    public void test597_DELETE() throws Exception {
        assertCode(597, DELETE);
    }
    @Test
    public void test597_OPTIONS() throws Exception {
        assertCode(597, OPTIONS);
    }
    @Test
    public void test597_HEAD() throws Exception {
        assertCode(597, HEAD);
    }
    @Test
    public void test598_GET() throws Exception {
        assertCode(598, GET);
    }
    @Test
    public void test598_POST() throws Exception {
        assertCode(598, POST);
    }
    @Test
    public void test598_PUT() throws Exception {
        assertCode(598, PUT);
    }
    @Test
    public void test598_DELETE() throws Exception {
        assertCode(598, DELETE);
    }
    @Test
    public void test598_OPTIONS() throws Exception {
        assertCode(598, OPTIONS);
    }
    @Test
    public void test598_HEAD() throws Exception {
        assertCode(598, HEAD);
    }
    @Test
    public void test599_GET() throws Exception {
        assertCode(599, GET);
    }
    @Test
    public void test599_POST() throws Exception {
        assertCode(599, POST);
    }
    @Test
    public void test599_PUT() throws Exception {
        assertCode(599, PUT);
    }
    @Test
    public void test599_DELETE() throws Exception {
        assertCode(599, DELETE);
    }
    @Test
    public void test599_OPTIONS() throws Exception {
        assertCode(599, OPTIONS);
    }
    @Test
    public void test599_HEAD() throws Exception {
        assertCode(599, HEAD);
    }
}
