package com.company.lexer;

public final class Token implements IToken {

    private String name;
    private String lexeme;

    public Token () {
        this ("","");
    }

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
