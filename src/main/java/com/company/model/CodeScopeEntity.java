package com.company.model;

import com.company.readerwriter.writer.IWriter;
import com.company.readerwriter.writer.WriterException;
/**
 * Write CodeScope Entity to Entities tree and override method "write" of CodeEntity class
 */
public class CodeScopeEntity extends CodeEntity {
    @Override
    public void write(IWriter writer, int nestLevel) throws WriterException {
        writer.writeChar('{');
        writer.writeChar('\n');
        super.write(writer, nestLevel);
        writer.writeChar('\n');
        writeTab(writer, nestLevel - 1);
        writer.writeChar('}');
    }
}