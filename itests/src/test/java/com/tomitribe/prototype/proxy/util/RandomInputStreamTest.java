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

import org.apache.commons.io.output.CountingOutputStream;
import org.apache.commons.io.output.NullOutputStream;
import org.junit.Assert;
import org.junit.Test;
import org.tomitribe.util.IO;
import org.tomitribe.util.SizeUnit;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class RandomInputStreamTest extends Assert {

    @Test
    public void testSizeIsAsExpected() throws Exception {
        assertSize(123);
        assertSize(234123);
        assertSize(SizeUnit.MEGABYTES.toBytes(1234));
    }

    @Test
    public void testContentIsFairlyRandom() throws IOException {
        // Assert each stream we create has unique content
        final Set<String> seen = new HashSet<>();

        for (int i = 0; i < 1000; i++) {
            final HashingInputStream in = new HashingInputStream(new RandomInputStream(10000));
            IO.copy(in, new NullOutputStream());
            assertTrue(seen.add(in.asHex()));
        }
    }

    private static void assertSize(long expected) throws IOException {
        final RandomInputStream in = new RandomInputStream(expected);

        final CountingOutputStream out = new CountingOutputStream(new NullOutputStream());
        IO.copy(in, out);

        assertEquals(expected, out.getCount());
    }

}