package com.company.lexer;

import com.company.readerwriter.reader.ReaderException;

/**
 * Lexer Interface
 */

public interface ILexer {
    /**
     *
     * @return true if token has next
     * @throws LexerException - something wrong with Lexer
     * @throws ReaderException - something wrong with reader
     */
    boolean canReadToken() throws LexerException, ReaderException;

    /**
     *
     * @return token ("name", "Lexeme")
     * @throws LexerException - something wrong with reader
     * @throws ReaderException - something wrong with reader
     */
    IToken getToken() throws LexerException, ReaderException;
}