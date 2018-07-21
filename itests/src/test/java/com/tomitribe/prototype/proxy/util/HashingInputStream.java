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

import io.airlift.slice.XxHash64;
import org.tomitribe.util.Longs;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class HashingInputStream extends FilterInputStream {
    private final XxHash64 digest;

    public HashingInputStream(final InputStream inputStream) {
        super(inputStream);
        digest = new XxHash64();
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        final int read = super.read(b, off, len);
        if (read > 0) {
            digest.update(b, off, read);
        }
        return read;
    }

    @Override
    public int read() throws IOException {
        final int read = super.read();
        if (read > -1) {
            digest.update(new byte[]{(byte) read});
        }
        return read;
    }

    public String asHex() {
        return Longs.toHex(digest.hash());
    }

}
