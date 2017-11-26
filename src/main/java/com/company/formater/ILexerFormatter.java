package com.company.formater;


import com.company.lexer.ILexer;
import com.company.lexer.LexerException;
import com.company.readerwriter.reader.ReaderException;
import com.company.readerwriter.writer.IWriter;
import com.company.readerwriter.writer.WriterException;


/**
 * LexerBasedFormatter interface.
 */

public interface ILexerFormatter {

    /**
     * Format the source code
     * @param lexer - implemented ILexer
     * @param writer - implemented IWriter
     * @throws WriterException - writer exceptions
     * @throws ReaderException - reader exceptions
     * @throws LexerException - lexer exceptions     *
     */

    void format(ILexer lexer, IWriter writer) throws WriterException, ReaderException, LexerException;

}