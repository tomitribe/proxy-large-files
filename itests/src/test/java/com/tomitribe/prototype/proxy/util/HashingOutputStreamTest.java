/*
 * Tomitribe Confidential
 *
 * Copyright Tomitribe Corporation. 2017
 *
 * The source code for this program is not published or otherwise divested
 * of its trade secrets, irrespective of what has been deposited with the
 * U.S. Copyright Office.
 */
package com.tomitribe.prototype.proxy.util;

import org.junit.Assert;
import org.junit.Test;
import org.tomitribe.util.Hex;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class HashingOutputStreamTest extends Assert {

    @Test
    public void testWrite() throws Exception {
        final String expectedHex = "" +
                "d134fbb591c8739800b61668e7b5008b9c3995fac8a7c1798d0e44c7103efee2" +
                "1d4eb55a2bd86edc84601c7a380aa426233b29d89f2b074a0b9982cdcf7c12ae" +
                "3771af56a7479ac4b8bd29512292f7afd29aa05db410a3f38e6a9829c3f95196" +
                "0108ec2ebba10e122125f8466aaebe8fb22b944aedf52d2cdca6cd35241991f3";

        final InputStream in = hexToStream(expectedHex);
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        final HashingOutputStream hash = new HashingOutputStream(baos);

        int i = 0;
        while ((i = in.read()) != -1) {
            hash.write(i);
        }

        assertEquals("c0f7ea4926e517ae688bca7ee7f7a51f9e10a4b6806195e357a8150308528bfb", hash.asHex());
        assertEquals(expectedHex, Hex.toString(baos.toByteArray()));
    }

    @Test
    public void testWrite1() throws Exception {
        final String expectedHex = "" +
                "b6d5f5f96cc4cc251640219b67e57c8c36bae6968ddb89fc4bd84380cbb77ee8" +
                "2bb946844c02cba9e6ba2c80f56886a67ea951c14b576a3b7e0c8f2b365e468b" +
                "c76ecab961ef5c66435e7171eb83d84236aacb3aad68cd40b6f511005ca0b188" +
                "218ba86b34713a87053001dc4af3886f6834b4996a439e1b425da036816ea083";

        final InputStream in = hexToStream(expectedHex);
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        final HashingOutputStream hash = new HashingOutputStream(baos);


        final byte[] buffer = new byte[12];
        int length;
        while ((length = in.read(buffer, 3, 5)) != -1) {
            hash.write(buffer, 3, length);
        }

        assertEquals("af10013bc362420088e2ec29fe0d747e3c78c9aa2e40646054ae055fde54d81e", hash.asHex());
        assertEquals(expectedHex, Hex.toString(baos.toByteArray()));
    }

    @Test
    public void testWrite2() throws Exception {
        final String expectedHex = "" +
                "9c0e7135dbf0c93cabe3ac1768e7c4ff9c1c3107088751093b4590ec0f7868ff" +
                "1b37f5cac92dea4886efbbaa74d5c74da3b766b51bdec45592009255a1fd603c" +
                "65f316eb456edceb567576774c1d6d4140c5941c7fd8a718db9f6a6e222ad649" +
                "4eceaf06d070c2aa3f96cfef76ded33cacf987a5a07761ebe74efbdaa7669c51";

        final InputStream in = hexToStream(expectedHex);
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        final HashingOutputStream hash = new HashingOutputStream(baos);


        final byte[] buffer = new byte[17];
        int length;
        while ((length = in.read(buffer)) != -1) {
            final byte[] read = new byte[length];
            System.arraycopy(buffer, 0, read, 0, length);
            hash.write(read);
        }

        assertEquals("5970904d1068b5cfeb2365c671eb54c436bf4b7498991b8b7dde981a3827e20e", hash.asHex());
        assertEquals(expectedHex, Hex.toString(baos.toByteArray()));
    }

    public static InputStream hexToStream(String hex) throws IOException {
        final byte[] buf = Hex.fromString(hex);
        return new ByteArrayInputStream(buf);
    }


}