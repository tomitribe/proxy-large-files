/*
 * Tomitribe Confidential
 *
 * Copyright Tomitribe Corporation. 2018
 *
 * The source code for this program is not published or otherwise divested 
 * of its trade secrets, irrespective of what has been deposited with the 
 * U.S. Copyright Office.
 */
package com.tomitribe.tribestream.proxy;

import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class LoggingServletOutputStream extends ServletOutputStream {
    private final ServletOutputStream servlet;
    private final PrintStream logger;

    public LoggingServletOutputStream(final ServletOutputStream servlet, final PrintStream logger) {
        this.servlet = servlet;
        this.logger = logger;
    }

    @Override
    public void print(String s) throws IOException {
        logger.print(s);
        servlet.print(s);
    }

    @Override
    public void print(boolean b) throws IOException {
        logger.print(b);
        servlet.print(b);
    }

    @Override
    public void print(char c) throws IOException {
        logger.print(c);
        servlet.print(c);
    }

    @Override
    public void print(int i) throws IOException {
        logger.print(i);
        servlet.print(i);
    }

    @Override
    public void print(long l) throws IOException {
        logger.print(l);
        servlet.print(l);
    }

    @Override
    public void print(float f) throws IOException {
        logger.print(f);
        servlet.print(f);
    }

    @Override
    public void print(double d) throws IOException {
        logger.print(d);
        servlet.print(d);
    }

    @Override
    public void println() throws IOException {
        logger.println();
        servlet.println();
    }

    @Override
    public void println(String s) throws IOException {
        logger.println(s);
        servlet.println(s);
    }

    @Override
    public void println(boolean b) throws IOException {
        logger.println(b);
        servlet.println(b);
    }

    @Override
    public void println(char c) throws IOException {
        logger.println(c);
        servlet.println(c);
    }

    @Override
    public void println(int i) throws IOException {
        logger.println(i);
        servlet.println(i);
    }

    @Override
    public void println(long l) throws IOException {
        logger.println(l);
        servlet.println(l);
    }

    @Override
    public void println(float f) throws IOException {
        logger.println(f);
        servlet.println(f);
    }

    @Override
    public void println(double d) throws IOException {
        logger.println(d);
        servlet.println(d);
    }

    @Override
    public void write(int b) throws IOException {
        logger.write(b);
        servlet.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        logger.write(b);
        servlet.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        logger.write(b, off, len);
        servlet.write(b, off, len);
    }

    @Override
    public void flush() throws IOException {
        logger.flush();
        servlet.flush();
    }

    @Override
    public void close() throws IOException {
//            log.close();
        servlet.close();
    }
}
