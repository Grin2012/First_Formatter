package com.company.readerwriter.writer;

/**
 * Write to file char by char
 */
public class StringWriter implements IWriter {
    private StringBuilder stringBuilder;

    /**
     * Create StringBuilder
     */
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