package com.company.formatter.formatterFSM;

import com.company.formatter.FormatterException;
import com.company.readerwriter.reader.ReaderException;
import com.company.readerwriter.writer.IWriter;
import com.company.readerwriter.writer.WriterException;

public interface IFormatterContext {

    void writeLexeme(String lexeme) throws FormatterException;

    void writeNewLine() throws WriterException, FormatterException;
}

