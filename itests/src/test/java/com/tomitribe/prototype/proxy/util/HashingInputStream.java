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

import org.tomitribe.util.Hex;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashingInputStream extends FilterInputStream {
    private final MessageDigest digest;

    public HashingInputStream(final InputStream inputStream) {
        super(inputStream);
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
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
            digest.update((byte) read);
        }
        return read;
    }

    public String asHex() {
        final byte[] digest = this.digest.digest();
        return Hex.toString(digest);
    }

}
