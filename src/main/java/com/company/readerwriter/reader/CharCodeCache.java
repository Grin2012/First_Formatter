package com.company.readerwriter.reader;

/**
 * Utility Class CharCodeCache
 */

public class CharCodeCache {
    private int charCode;

    /**
     * Check buffer for more chars
     * @return - boolean
     */
    public boolean isEmpty() {
        return this.charCode == -1;
    }

    /**
     * Put to buffer
     * @param charCode - integer
     */
    public void add(final int charCode) {
        this.charCode = charCode;
    }

    /**
     * Clean buffer
     */
    public void clean() {
        this.charCode = -1;
    }

    /**
     * Char from buffer
     * @return char
     */
    public char toChar() {
        return (char) this.charCode;
    }
}