package com.company.formater;

import com.company.lexer.ILexer;
import com.company.lexer.IToken;
import com.company.lexer.LexerException;
import com.company.lexer.Token;
import com.company.readerwriter.reader.IReader;
import com.company.readerwriter.reader.ReaderException;
import com.company.readerwriter.reader.StringReader;
import com.company.readerwriter.writer.IWriter;
import com.company.readerwriter.writer.WriterException;

/**
 * LexerBasedFormatter format source code
 */
public class LexerBasedFormatter implements ILexerFormatter {
    private final int spaceInTab = 4;
    private void writeTab(final IWriter writer, final int tabs) throws WriterException {
        for (int i = 0; i < tabs * spaceInTab; i++) {
            writer.writeChar(' ');
        }
    }
    /**
     *
     * @param lexer - implements ILexer
     * @param writer - implements IWriter
     * @throws WriterException - writer Exception
     * @throws ReaderException - reader Exception
     * @throws LexerException - lexer Exception
     */
    @Override
    public void format(final ILexer lexer, final IWriter writer) throws WriterException, ReaderException, LexerException {
        int braceCount = 0;
        IToken prevToken = new Token();
        boolean newline = false;

        while (lexer.canReadToken()) {
            IToken token = lexer.getToken();
            String tokenName = token.getName();
            IReader reader = new StringReader(token.getLexeme());

            if (newline) {
                writer.writeChar('\n');
                if (token.getName().equals("rightBrace")) {
                    writeTab(writer, braceCount - 1);
                } else {
                    writeTab(writer, braceCount);
                }
                newline = false;
            }

            switch (tokenName) {
                case "rightBrace":
                    while (reader.canReadChar()) {
                        writer.writeChar(reader.getChar());
                    }
                    braceCount--;
                    newline = true;
                break;

                case "leftBrace":
                    if (!prevToken.getName().equals("leftBrace") && !prevToken.getLexeme().equals("")) {
                        writer.writeChar(' ');
                    }
                    while (reader.canReadChar()) {
                        writer.writeChar(reader.getChar());
                    }
                    newline = true;
                    braceCount++;
                    break;

                case "semiColon":
                    while (reader.canReadChar()) {
                        writer.writeChar(reader.getChar());
                    }
                    newline = true;
                    break;

                case "stringLiteral":
                    if (prevToken.getName().equals("word")) {
                        writer.writeChar(' ');
                    }
                    while (reader.canReadChar()) {
                        writer.writeChar(reader.getChar());
                    }
                    break;

                case "word":
                    if (prevToken.getName().equals("word")) {
                        writer.writeChar(' ');
                    }
                    while (reader.canReadChar()) {
                        writer.writeChar(reader.getChar());
                    }
                break;

                case "singleLineComment":
                case "multiLineComment":
                    while (reader.canReadChar()) {
                        writer.writeChar(reader.getChar());
                    }
                    newline = true;
                    break;
            }
            prevToken = token;
        }
    }
}