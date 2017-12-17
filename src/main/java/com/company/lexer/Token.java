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
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Token token = (Token) o;

        return name != null ? name.equals(token.name) : token.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Token{\n" +
                "name = " + name + "\n" +
                "lexeme = " + lexeme + '\n' +
                '}';
    }
}