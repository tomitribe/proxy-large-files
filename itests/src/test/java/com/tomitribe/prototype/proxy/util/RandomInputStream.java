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

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class RandomInputStream extends InputStream {

    private long remaining;
    private final byte[] generated;
    private final Random random;

    public RandomInputStream(final long length) {
        this.remaining = length;
        this.random = new Random();
        this.generated = new byte[(int) Math.min(length, 1024 * 8)];

        for (int i = 0; i < generated.length; i++) {
            generated[i] = (byte) random.nextInt();
        }
    }

    @Override
    public int read(byte[] b) throws IOException {
        return read(b, 0, b.length);
    }

    @Override
    public int read(byte[] b, int offset, int length) throws IOException {
        if (remaining <= 0) return -1;

        // we can't write more bytes than we've generated
        length = Math.min(generated.length, length);

        // we can't write more bytes than are remaining
        length = (int) Math.min(remaining, length);

        // copy what we can into the buffer
        System.arraycopy(generated, 0, b, offset, length);

        remaining -= length;
        return length;
    }

    public int read() throws IOException {
        if (remaining <= 0) return -1;
        remaining--;
        return random.nextInt();
    }
}
