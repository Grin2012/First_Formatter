package com.company.lexer;

/**
 * Itoken interface
 */
public interface IToken {

    /**
     * @return Token name as string
     */
    String getName();

    /**
     * @return Token Lexeme as string
     */
    String getLexeme();
}