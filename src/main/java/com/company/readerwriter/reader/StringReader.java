package com.company.readerwriter.reader;

/**
 * This class read from String char by char
 */

public class StringReader implements IReader {

    private String sourceSring;
    private int n;

    /**
     * @param sourceSring - Source Stirng
     * @throws ReaderException - Thorws exception when String is null
     */
    public StringReader(final String sourceSring) throws ReaderException {
        this.sourceSring = sourceSring;
    }

    @Override
    public char readChar() throws ReaderException {
        try {
            return sourceSring.charAt(n);
        } catch (Exception e) {
            throw new ReaderException("Can not read char", e);
        } finally {
            n++;
        }
    }

    @Override
    public boolean hasChar() throws ReaderException {
        return n < sourceSring.length();
    }
}