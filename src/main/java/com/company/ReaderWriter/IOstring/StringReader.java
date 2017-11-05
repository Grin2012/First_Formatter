package com.company.ReaderWriter.IOstring;


import com.company.ReaderWriter.IReader;
import com.company.ReaderWriter.IOexeption.ReaderException;

public class StringReader implements IReader {

    private String sourceSring;
    private int n;

    public StringReader(String sourceSring) throws ReaderException {
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