package com.company.Model;

import com.company.ReaderWriter.IOexeption.WriterException;
import com.company.ReaderWriter.IWriter;

public class CodeStringEntity extends CodeEntity {
    @Override
    public void write(IWriter writer,int nestLevel) throws WriterException {
        writer.writeChar('\"');
        super.write(writer, nestLevel);
        writer.writeChar('\"');
    }
}