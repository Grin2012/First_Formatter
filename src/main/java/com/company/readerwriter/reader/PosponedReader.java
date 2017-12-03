package com.company.readerwriter.reader;

public class PosponedReader implements IReader {
    private StringBuilder posponed;
    private IReader realtime;

    public PosponedReader(IReader realtime) {
        this.realtime = realtime;
        this.posponed = new StringBuilder();
    }

    public void posponeChar(char c) {
        this.posponed.append(c);
    }

    @Override
    public char getChar() throws ReaderException {
        if(posponReader().canReadChar()) {
            return posponReader().getChar();
        } else {
            return this.realtime.getChar();
        }
    }

    @Override
    public boolean canReadChar() throws ReaderException {
        return posponReader().canReadChar() || this.canReadChar();
    }

    private IReader posponReader() throws ReaderException {
        return new StringReader(this.posponed.toString());
    }
}