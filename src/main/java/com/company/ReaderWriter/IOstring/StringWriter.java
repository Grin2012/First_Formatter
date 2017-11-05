package com.company.ReaderWriter.IOstring;

import com.company.ReaderWriter.IWriter;
import com.company.ReaderWriter.IOexeption.WriterException;

public class StringWriter implements IWriter {
    private StringBuilder stringBuilder;

    public StringWriter() {
        this.stringBuilder = new StringBuilder();
    }

    @Override
    public void writeChar(final char c) throws WriterException {
        stringBuilder.append(c);
    }

    public String getString() {
        return stringBuilder.toString();
    }
}