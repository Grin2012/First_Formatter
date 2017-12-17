package com.company.lexer;

/**
 * Lexer Interface
 */

public interface ILexer {
    /**
     *
     * @return true if token has next
     * @throws LexerException - something wrong with Lexer
     *
     */
    boolean canReadToken() throws LexerException;

    /**
     *
     * @return token ("name", "Lexeme")
     * @throws LexerException - something wrong with reader
     *
     */
    IToken getToken() throws LexerException;
}