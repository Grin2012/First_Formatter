package com.company.lexer;

import com.company.readerwriter.reader.IReader;
import com.company.readerwriter.reader.ReaderException;


public class Lexer implements ILexer {

    private IReader reader;
    private TokenBuffer tokenBuffer;
   // private String endOfLexemeSymbols = " ;}{\r\n\t";

    public Lexer(final IReader reader) {
        this.reader = reader;
        this.tokenBuffer = new TokenBuffer();
    }

    private void readToBuffer() throws ReaderException {
        StringBuilder lexeme = new StringBuilder();

        while (reader.hasChar()) {
            char c = reader.readChar();
            switch (c) {

                case ' ':
                case '\t':
                case '\n':
                case '\r':
                    if (lexeme.length() != 0) {
                        tokenBuffer.push(new Token("word", lexeme.toString()));
                        return;
                    }
                    break;

                case '}':
                    if (lexeme.length() != 0) {
                        tokenBuffer.push(new Token("word", lexeme.toString()));
                        lexeme = new StringBuilder();
                    }
                    lexeme.append(c);
                    tokenBuffer.push(new Token("rightBrace", lexeme.toString()));
                    return;

                case '{':
                    if (lexeme.length() != 0) {
                        tokenBuffer.push(new Token("word", lexeme.toString()));
                        lexeme = new StringBuilder();
                    }
                    lexeme.append(c);
                    tokenBuffer.push(new Token("leftBrace", lexeme.toString()));
                    return;

                case ';':
                    if (lexeme.length() != 0) {
                        tokenBuffer.push(new Token("word", lexeme.toString()));
                        lexeme = new StringBuilder();
                    }
                    lexeme.append(c);
                    tokenBuffer.push(new Token("semiColon", lexeme.toString()));
                    return;

                default:
                    lexeme.append(c);
                    break;
            }
        }
        if (lexeme.length() != 0) {
            tokenBuffer.push(new Token("word", lexeme.toString()));
        }
    }


    @Override
    public boolean hasMoreTokens() throws ReaderException {
        if (!tokenBuffer.isEmpty()) {
            return true;
        }
        readToBuffer();
        return !tokenBuffer.isEmpty();
    }

    @Override
    public IToken readToken() throws Exception, ReaderException {
        if (hasMoreTokens()) {
            return tokenBuffer.unshift();
        }
        throw new Exception("Can not read token");
    }
}