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

public class HashingInputStreamTest extends Assert {

    /**
     * Test signature: read()
     * @throws Exception
     */
    @Test
    public void testRead() throws Exception {
        final String hex = "" +
                "440b3543f1635f1f2461032eadaea711f225863c3b03288943cbbccc8aa15c88" +
                "d6ed24c032dff04fffcd45d5f9ef0922f1ae444f2b078aae470fb680632453ba" +
                "0fe45d26c0671be3e06c98f9c70c4ad461116fb49878e4c4416618b57f05bd58" +
                "da91c0544594957fe3192663d3e7fff892a9662a27b3d3b03c054767f5c7bd14";
        final HashingInputStream in = new HashingInputStream(hexToStream(hex));
        final ByteArrayOutputStream out = new ByteArrayOutputStream();

        int i = 0;
        while ((i = in.read()) != -1) { out.write(i);}

        assertEquals("20c01f3ce77934bb142f7b3009957f98a83e8509b32ebc8a57abe63d83000080", in.asHex());
        assertEquals(hex, Hex.toString(out.toByteArray()));
    }

    /**
     * Test signature: read(byte[] b, int off, int len)
     * @throws Exception
     */
    @Test
    public void testRead1() throws Exception {
        final String hex = "" +
                "5ea3285143bfd9440469b7ab53e0181bb015a5ce6d0a170a9560e1480935aea3" +
                "8262e73eaf37a7ca9b6fcc85721217f3e24036bdfcfc983a2ada1bd2ca3a39da" +
                "f2d96a25724c1228ed114214be483de2adc471dd4e31fc07ceebf588a7189982" +
                "70387f37b287e8c2cfe50d22a3c63249a6289d8bae1504c0507eacbc6e5f5942";
        final HashingInputStream in = new HashingInputStream(hexToStream(hex));
        final ByteArrayOutputStream out = new ByteArrayOutputStream();

        int length = 0;
        final byte[] bytes = new byte[101];
        while ((length = in.read(bytes, 3, 76)) != -1) {
            out.write(bytes, 3, length);
        }

        // Assert hash is as expected
        assertEquals("b8c1fe7e151c568eef029517590454e18c5979c2219ddfd61a40ab85a5e45aee", in.asHex());

        // Assert input made it through
        assertEquals(hex, Hex.toString(out.toByteArray()));
    }

    /**
     * Test signature: read(byte b[])
     * @throws Exception
     */
    @Test
    public void testRead2() throws Exception {
        final String hex = "" +
                "f84661f4c8c1ddba73be43a0ac486a4a5eaa48b2750640f07b6f6f8027a386f7" +
                "0005391ff1921d61719f6298444e85182c6b0319ffc3917b0d244b661643ab6f" +
                "dd27538ca408090c000870091ad67f4807cbbbeb18cc683549538d846d47fc28" +
                "2eae13a5a5b2507d6ab0e10cf687d1d86b51f0501c419bb27031ec4425a18752";
        final HashingInputStream in = new HashingInputStream(hexToStream(hex));
        final ByteArrayOutputStream out = new ByteArrayOutputStream();

        int length = 0;
        final byte[] bytes = new byte[12];
        while ((length = in.read(bytes)) != -1) {
            out.write(bytes, 0, length);
        }

        assertEquals("f8260c0fe8e518f76bb246946f49294a6bb961184c55b859bbc72ecad307263b", in.asHex());
        assertEquals(hex, Hex.toString(out.toByteArray()));
    }


    public static InputStream hexToStream(String hex) throws IOException {
        final byte[] buf = Hex.fromString(hex);
        return new ByteArrayInputStream(buf);
    }
}