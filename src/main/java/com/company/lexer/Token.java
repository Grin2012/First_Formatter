package com.company.lexer;

/**
 * Class Token implements IToken
 */
public final class Token implements IToken {

    private String name;
    private String lexeme;

    /**
     * Default Token constructor
     */
    public Token() {
        this ("", "");
    }

    /**
     * Token constructor
     * @param name - Name as string
     * @param lexeme - lexeme as string
     */
    public Token(final String name, final String lexeme) {
        this.name = name;
        this.lexeme = lexeme;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getLexeme() {
        return lexeme;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + " Lexeme: " + getLexeme();
    }
}