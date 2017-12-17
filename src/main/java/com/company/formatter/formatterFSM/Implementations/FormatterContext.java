package com.company.formatter.formatterFSM.Implementations;

import com.company.formatter.FormatterException;
import com.company.formatter.formatterFSM.IFormatterContext;
import com.company.readerwriter.reader.IReader;
import com.company.readerwriter.reader.ReaderException;
import com.company.readerwriter.reader.StringReader;
import com.company.readerwriter.writer.IWriter;
import com.company.readerwriter.writer.WriterException;

/**
 * class FormatterContext contains formatter actions, when we format code
 */

public class FormatterContext implements IFormatterContext {
    private final IWriter writer;
    private final int spacesInTab = 4;
    private int indentLevel = 0;

    /**
     * Constructor with writer
     * @param writer - writer
     */
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

    @Override
    public void writeIndent() throws FormatterException {
        try {
            for (int i = 0; i < indentLevel * spacesInTab; i++) {
                writer.writeChar(' ');
            }
        } catch (WriterException e) {
            throw new FormatterException("Formatter failed with indent writer", e);
        }
    }

    @Override
    public void writeSpace() throws FormatterException {
        try {
            writer.writeChar(' ');
        } catch (WriterException e) {
            throw new FormatterException("Formatter failed with lexeme writer", e);
        }
    }

    @Override
    public void increaseIndentLevel() {
        indentLevel++;
    }

    @Override
    public void decreaseIndentLevel() {
        indentLevel--;
    }
}
