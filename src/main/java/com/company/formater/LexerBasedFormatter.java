package com.company.formater;

import com.company.lexer.ILexer;
import com.company.lexer.IToken;
import com.company.lexer.Token;
import com.company.readerwriter.reader.IReader;
import com.company.readerwriter.reader.ReaderException;
import com.company.readerwriter.reader.StringReader;
import com.company.readerwriter.writer.IWriter;
import com.company.readerwriter.writer.WriterException;

public class LexerBasedFormatter {

    private void writeTab(final IWriter writer, final int tabs) throws WriterException {
        for (int i = 0; i < tabs * 4; i++) {
            writer.writeChar(' ');
        }
    }

    public void format(final ILexer lexer, final IWriter writer) throws WriterException, Exception, ReaderException {
        int braceCount = 0;
        IToken prevToken = new Token();
        boolean newline = false;

        while (lexer.hasMoreTokens()) {
            IToken token = lexer.readToken();
            String tokenName = token.getName();
            IReader reader = new StringReader(token.getLexeme());

            if (newline) {
                if (token.getName().equals("rightBrace")) {
                    writeTab(writer, braceCount - 1);
                } else {
                    writeTab(writer, braceCount);
                }
                newline = false;
            }

            switch (tokenName) {
                case "rightBrace":
                    while (reader.hasChar()) {
                        writer.writeChar(reader.readChar());
                    }
                    writer.writeChar('\n');
                    newline = true;
                    braceCount --;
                break;

                case "leftBrace":
                    if (!prevToken.getName().equals("leftBrace")) {
                        writer.writeChar(' ');
                    }
                    while (reader.hasChar()) {
                        writer.writeChar(reader.readChar());
                    }
                    writer.writeChar('\n');
                    newline = true;
                    braceCount ++;
                    break;

                case "semiColon":
                    while (reader.hasChar()) {
                        writer.writeChar(reader.readChar());
                    }
                    writer.writeChar('\n');
                    newline = true;
                    break;

                case "word":
                    if (prevToken.getName().equals("word")) {
                        writer.writeChar(' ');
                    }
                    while (reader.hasChar()) {
                        writer.writeChar(reader.readChar());
                    }
                break;
            }
            prevToken = token;
        }
    }
}