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

import com.tomitribe.prototype.proxy.util.Chance;
import com.tomitribe.prototype.proxy.util.HashingInputStream;
import com.tomitribe.prototype.proxy.util.RandomInputStream;
import org.tomitribe.util.Size;
import org.tomitribe.util.SizeUnit;

import java.io.InputStream;

/**
 * Generates a random payload of a specific size or a particular range
 *
 * To ensure the payload transfers correctly a SHA-256 hash is created
 * from the generated data after the data has been fully read.
 */
public class Body {
    private final long length;
    private final HashingInputStream inputStream;

    public Body(final long length) {
        this.length = length;
        this.inputStream = new HashingInputStream(new RandomInputStream(length));
    }

    public static Body generate(final String min, final String max) {
        return generate(Size.parse(min), Size.parse(max));
    }

    public static Body generate(final Size min, final Size max) {
        final long minBytes = min.getSize(SizeUnit.BYTES);
        final long maxBytes = max.getSize(SizeUnit.BYTES);

        final long length = Chance.range(minBytes, maxBytes);
        return generate(length);
    }

    public static Body generate(final long length) {
        return new Body(length);
    }

    public long getLength() {
        return length;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    /**
     * Generates a hash from the generated data that has been read
     * from the InputStream.  Do not call this until all the InputStream
     * has been read (ie.e the body has been written).
     */
    public String getHash() {
        return inputStream.asHex();
    }
}
