package com.company.lexer;

import com.company.readerwriter.reader.IReader;
import com.company.readerwriter.reader.ReaderException;

/**
 * Lexer class implements ILexer build tokens from source code
 */

public class Lexer implements ILexer {

    private IReader reader;
    private TokenBuffer tokenBuffer;
    //private String endOfLexemeSymbols = " ;}{\r\n\t\"";

    /**
     * Lexer default constructor
     * @param reader - implements IReader
     */
    public Lexer(final IReader reader) {
        this.reader = reader;
        this.tokenBuffer = new TokenBuffer();
    }

    private void readToBuffer() throws LexerException {
        StringBuilder lexeme = new StringBuilder();
        try {
            while (reader.canReadChar()) {
                char c = reader.getChar();
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

                    case '"':
                        lexeme.append(c);
                        Character prevLiteralChar = null;
                        while (reader.canReadChar()) {
                            c = reader.getChar();
                            lexeme.append(c);
                            if (c == '"' && prevLiteralChar != '\\') {
                                break;
                            }
                            prevLiteralChar = c;
                        }
                        tokenBuffer.push(new Token("stringLiteral", lexeme.toString()));
                        return;

                    case '/':
                        lexeme.append(c);
                        c = reader.getChar();

                        if (c == '/') {
                            lexeme.append(c);
                            while (reader.canReadChar()) {
                                c = reader.getChar();
                                if (c == '\n') {
                                    break;
                                }
                                lexeme.append(c);
                            }
                            tokenBuffer.push(new Token("singleLineComment", lexeme.toString()));
                            return;
                        }

                        if (c == '*') {
                            lexeme.append(c);

                            Character prevCommentChar = null;
                            while (reader.canReadChar()) {
                                c = reader.getChar();
                                lexeme.append(c);
                                //End comment.
                                if (c == '/' && prevCommentChar == '*') {
                                    tokenBuffer.push(new Token("multiLineComment", lexeme.toString()));
                                    return;
                                }
                                prevCommentChar = c;
                            }
                            //Case if multiline comment is not closed.
                            tokenBuffer.push(new Token("multiLineComment", lexeme.toString()));
                        }
                        return;

                    default:
                        lexeme.append(c);
                        break;
                }
            }
        } catch (ReaderException e) {
            throw new LexerException("Lexer crash at reader from stream", e);
        }

        //Word is not closed.
        if (lexeme.length() != 0) {
            tokenBuffer.push(new Token("word", lexeme.toString()));
        }
    }


    @Override
    public boolean canReadToken() throws LexerException {
        if (!tokenBuffer.isEmpty()) {
            return true;
        }
        readToBuffer();
        return !tokenBuffer.isEmpty();
    }

    @Override
    public IToken getToken() throws LexerException {
        if (canReadToken()) {
            return tokenBuffer.unShift();
        }
        throw new LexerException("Can not read token");
    }
}