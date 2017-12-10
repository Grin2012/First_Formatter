package com.company.formatter.formatterFSM.Implementations;

import com.company.formatter.FormatterException;
import com.company.formatter.formatterFSM.IFormatterContext;
import com.company.readerwriter.reader.IReader;
import com.company.readerwriter.reader.ReaderException;
import com.company.readerwriter.reader.StringReader;
import com.company.readerwriter.writer.IWriter;
import com.company.readerwriter.writer.WriterException;

class FormatterContext implements IFormatterContext {
    private final IWriter writer;

    public FormatterContext(final IWriter writer) {
        this.writer = writer;
    }

    @Override
    public void writeLexeme(final String lexeme) throws FormatterException {
        try {
            IReader reader = new StringReader(lexeme);
            while (reader.canReadChar()) {
                writer.writeChar(reader.getChar());
            }
        } catch (ReaderException e) {
            throw new FormatterException("Formatter failed with lexeme string reader", e);
        } catch (WriterException e) {
            throw new FormatterException("Formatter failed with lexeme writer", e);
        }
    }

    @Override
    public void writeNewLine() throws FormatterException {
        try {
            writer.writeChar('\n');
        } catch (WriterException e) {
            throw new FormatterException("Formatter failed with lexeme writer", e);
        }
    }
}
