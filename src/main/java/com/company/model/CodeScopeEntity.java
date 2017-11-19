package com.company.model;

import com.company.readerwriter.writer.IWriter;
import com.company.readerwriter.writer.WriterException;
/**
 * Write CodeScope Entity to Entities tree and override method "write" of CodeEntity class
 */
public class CodeScopeEntity extends CodeEntity {
    @Override
    public void write(final IWriter writer, final int nestLevel) throws WriterException {
        writer.writeChar('{');
        writer.writeChar('\n');
        if (!super.nestedEntities.isEmpty() && super.nestedEntities.get(0) instanceof CodeScopeEntity) {
            writeTab(writer, nestLevel);
        }
        if (!super.nestedEntities.isEmpty()) {
            super.write(writer, nestLevel);
            writer.writeChar('\n');
        }
        writeTab(writer, nestLevel - 1);
        writer.writeChar('}');
    }
}