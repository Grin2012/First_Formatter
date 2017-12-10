package com.company;

import com.company.lexer.ILexer;
import com.company.lexer.LexerException;
import com.company.lexer.Token;
import com.company.lexer.lexerFSM.implementations.LexerFSM;
import com.company.readerwriter.reader.ReaderException;
import com.company.readerwriter.reader.StringReader;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LexerFSMStringTest {
    private StringReader reader;
    private String lexerTest;
    private ILexer lexer;

    @Test
    public void spacing() throws LexerException, ReaderException {
        lexerTest = "   a";
        reader = new StringReader(lexerTest);
        lexer = new LexerFSM(reader);
        assertEquals(new Token("space", "   ").toString(), lexer.getToken().toString());
    }

    @Test
    public void newline() throws LexerException, ReaderException {
        lexerTest = "\n";
        reader = new StringReader(lexerTest);
        lexer = new LexerFSM(reader);
        assertEquals(new Token("newLine", "\n").toString(), lexer.getToken().toString());
    }

    @Test
    public void testRightBrace() throws LexerException, ReaderException {
        lexerTest = "}";
        reader = new StringReader(lexerTest);
        lexer = new LexerFSM(reader);
        assertEquals(new Token("rightBrace", lexerTest).toString(), lexer.getToken().toString());
    }

    @Test
    public void testLeftBrace() throws LexerException, ReaderException {
        lexerTest = "{";
        reader = new StringReader(lexerTest);
        lexer = new LexerFSM(reader);
        assertEquals(new Token("leftBrace", lexerTest).toString(), lexer.getToken().toString());
    }

    @Test
    public void testSemiColon() throws LexerException, ReaderException {
        lexerTest = ";";
        reader = new StringReader(lexerTest);
        lexer = new LexerFSM(reader);
        assertEquals(new Token("semiColon", lexerTest).toString(), lexer.getToken().toString());
    }

    @Test
    public void testStringLiteral() throws LexerException, ReaderException {
        lexerTest = "\"regrege\\\"{grgrg;}\"";
        reader = new StringReader(lexerTest);
        lexer = new LexerFSM(reader);
        assertEquals(new Token("stringLiteral", lexerTest).toString(), lexer.getToken().toString());
    }

    @Test
    public void testSingleLineComment() throws LexerException, ReaderException {
        lexerTest = "//And i say:\"regrege{grgrg;}\"";
        reader = new StringReader(lexerTest);
        lexer = new LexerFSM(reader);
        assertEquals(new Token("singleComment", lexerTest).toString(), lexer.getToken().toString());
    }

    @Test
    public void testMultiLineComment() throws LexerException, ReaderException {
        lexerTest = "/*And i say:\n" +
                "regrege*{grgrg;}\"*/";
        reader = new StringReader(lexerTest);
        lexer = new LexerFSM(reader);
        assertEquals(new Token("multiComment", lexerTest).toString(), lexer.getToken().toString());
    }

    @Test
    public void testChar() throws LexerException, ReaderException {
        lexerTest = "r";
        reader = new StringReader(lexerTest);
        lexer = new LexerFSM(reader);
        assertEquals(new Token("char", lexerTest).toString(), lexer.getToken().toString());
    }
}
