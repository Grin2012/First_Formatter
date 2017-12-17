package com.company.readerwriter.reader;

/**
 * Postponed Reader - the reader were we can add postpone char from input stream
 */
public class PostponedReader implements IReader {
    private String postponed;
    private IReader realtime;
    /**
     * Constructor create PostponedReader from input stream reader
     * @param realtime - current input stream reader
     */
    public PostponedReader(final IReader realtime) {
        this.realtime = realtime;
        this.postponed = "";
    }
    /**
     * Add postponed char to reader
     * @param c - postponed char
     */
    public void postponeChar(final char c) {
        this.postponed += c;
    }

    @Override
    public char getChar() throws ReaderException {
        if (postponedReader().canReadChar()) {
            char next = postponedReader().getChar();
            this.postponed = postponed.substring(1);
            return next;
        } else {
            return this.realtime.getChar();
        }
    }

    @Override
    public boolean canReadChar() throws ReaderException {
        return postponedReader().canReadChar() || this.realtime.canReadChar();
    }

    private IReader postponedReader() throws ReaderException {
        return new StringReader(this.postponed);
    }
}