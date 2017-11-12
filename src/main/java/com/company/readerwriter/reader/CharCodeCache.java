package com.company.readerwriter.reader;

public class CharCodeCache {
    private int charCode;

    public boolean isEmpty() {
        return this.charCode == -1;
    }

    public void add (int charCode) {
        this.charCode = charCode;
    }

    public void clean () {
        this.charCode = -1;
    }

    public char toChar () {
        return (char) this.charCode;
    }
}