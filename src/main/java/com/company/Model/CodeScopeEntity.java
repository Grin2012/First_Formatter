package com.company.Model;

import com.company.ReaderWriter.IOexeption.WriterException;
import com.company.ReaderWriter.IWriter;

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