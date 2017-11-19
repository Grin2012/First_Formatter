package com.company.model;

import com.company.readerwriter.writer.WriterException;
import com.company.readerwriter.writer.IWriter;
/**
 * Write CodeString Entity to Entities tree and override method "write" of CodeEntity class
 */
public class CodeStringEntity extends CodeEntity {
    @Override
    public void write(final IWriter writer, final int nestLevel) throws WriterException {
        writer.writeChar('\"');
        super.write(writer, nestLevel);
        writer.writeChar('\"');
    }
}