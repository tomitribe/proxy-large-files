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

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashingOutputStream extends FilterOutputStream {
    private final MessageDigest digest;

    public HashingOutputStream(OutputStream out) {
        super(out);
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void write(int b) throws IOException {
        digest.update((byte) b);
        out.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        digest.update(b);
        out.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        digest.update(b, off, len);
        out.write(b, off, len);
    }

    @Override
    public void flush() throws IOException {
        out.flush();
    }

    @Override
    public void close() throws IOException {
        out.close();
    }

    public String asHex() {
        final byte[] digest = this.digest.digest();
        return Hex.toString(digest);
    }

}
