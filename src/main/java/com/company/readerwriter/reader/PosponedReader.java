package com.company.readerwriter.reader;

public class PosponedReader implements IReader {
    private String posponed;
    private IReader realtime;

    public PosponedReader(IReader realtime) {
        this.realtime = realtime;
        this.posponed = "";
    }

    public void posponeChar(char c) {
        this.posponed += c;
    }

    @Override
    public char getChar() throws ReaderException {
        if(posponReader().canReadChar()) {
            char next = posponReader().getChar();
            this.posponed = posponed.substring(1);
            return next;
        } else {
            return this.realtime.getChar();
        }
    }

    @Override
    public boolean canReadChar() throws ReaderException {
        return posponReader().canReadChar() || this.realtime.canReadChar();
    }

    private IReader posponReader() throws ReaderException {
        return new StringReader(this.posponed);
    }
}