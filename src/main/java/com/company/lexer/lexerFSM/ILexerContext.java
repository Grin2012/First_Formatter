package com.company.lexer.lexerFSM;

public interface ILexerContext {

    /**
     * Add char to lexeme
     * @param c - current char
     */
    void appendLexeme(Character c);

    /**
     * Set Token name from string
     * @param s - name of Token
     */
    void setTokenName(String s);

    /**
     * Add char to buffer "postpone"
     * @param c - current char
     */
    void appendPostpone(Character c);
}
