package com.company;

import com.company.lexer.ILexer;
import com.company.lexer.Lexer;
import com.company.lexer.LexerException;
import com.company.lexer.Token;
import com.company.readerwriter.reader.ReaderException;
import com.company.readerwriter.reader.StringReader;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LexerStringTest {
    private StringReader reader;
    private String lexerTest;
    private ILexer lexer;

    @Test
    public void testRightBrace() throws LexerException, ReaderException {
        lexerTest = "}";
        reader = new StringReader(lexerTest);
        lexer = new Lexer(reader);
        assertEquals(new Token("rightBrace", lexerTest).toString(), lexer.getToken().toString());
    }
    @Test
    public void testLeftBrace() throws LexerException, ReaderException {
        lexerTest = "{";
        reader = new StringReader(lexerTest);
        lexer = new Lexer(reader);
        assertEquals(new Token("leftBrace", lexerTest).toString(), lexer.getToken().toString());
    }
    @Test
    public void testSemiColon() throws LexerException, ReaderException {
        lexerTest = ";";
        reader = new StringReader(lexerTest);
        lexer = new Lexer(reader);
        assertEquals(new Token("semiColon", lexerTest).toString(), lexer.getToken().toString());
    }
    @Test
    public void testStringLiteral() throws LexerException, ReaderException {
        lexerTest = "\"regrege\\\"{grgrg;}\"";
        reader = new StringReader(lexerTest);
        lexer = new Lexer(reader);
        assertEquals(new Token("stringLiteral", lexerTest).toString(), lexer.getToken().toString());
    }
    @Test
    public void testSingleLineComment() throws LexerException, ReaderException {
        lexerTest = "//And i say:\"regrege{grgrg;}\"";
        reader = new StringReader(lexerTest);
        lexer = new Lexer(reader);
        assertEquals(new Token("singleLineComment", lexerTest).toString(), lexer.getToken().toString());
    }

    @Test
    public void testMultiLineComment() throws LexerException, ReaderException {
        lexerTest = "/*And i say:\n" +
                "regrege*{grgrg;}\"*/";
        reader = new StringReader(lexerTest);
        lexer = new Lexer(reader);
        assertEquals(new Token("multiLineComment", lexerTest).toString(), lexer.getToken().toString());
    }

//    @Test
//    public void testMultiLineComment() throws LexerException, ReaderException {
//        lexerTest = "int i = 10; /*first*/";
//        reader = new StringReader(lexerTest);
//        lexer = new Lexer(reader);
//        assertEquals(new Token("multiLineComment", lexerTest).toString(), lexer.getToken().toString());
//    }

    @Test
    public void testWord() throws LexerException, ReaderException {
        lexerTest = "regregegrgrg";
        reader = new StringReader(lexerTest);
        lexer = new Lexer(reader);
        assertEquals(new Token("word", lexerTest).toString(), lexer.getToken().toString());
    }
}
