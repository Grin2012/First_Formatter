package com.company.app_FSM;

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
        assertEquals(new Token("char", "a").toString(), lexer.getToken().toString());
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
    public void testSingleLineCommentWithOther() throws LexerException, ReaderException {
        lexerTest = "//And i say:\"regrege{grgrg;}\"\n" +
                "hero";
        reader = new StringReader(lexerTest);
        lexer = new LexerFSM(reader);
        assertEquals(new Token("singleComment", "//And i say:\"regrege{grgrg;}\"").toString(), lexer.getToken().toString());
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
    public void testMultiLineCommentWithOther() throws LexerException, ReaderException {
        lexerTest = "/*And i say:\n" +
                "regrege*{grgrg;}\"*/ fdsdf";
        reader = new StringReader(lexerTest);
        lexer = new LexerFSM(reader);
        assertEquals(new Token("multiComment", "/*And i say:\n" +
                "regrege*{grgrg;}\"*/").toString(), lexer.getToken().toString());
    }

    @Test
    public void testChar() throws LexerException, ReaderException {
        lexerTest = "r";
        reader = new StringReader(lexerTest);
        lexer = new LexerFSM(reader);
        assertEquals(new Token("char", lexerTest).toString(), lexer.getToken().toString());
    }

    @Test
    public void testFor() throws LexerException, ReaderException {
        lexerTest = "for (int i = 0; i < indentLevel * spacesInTab; i++)";
        reader = new StringReader(lexerTest);
        lexer = new LexerFSM(reader);
        assertEquals(new Token("for", "for").toString(), lexer.getToken().toString());
    }

    @Test
    public void testFor1() throws LexerException, ReaderException {
        lexerTest = "forr (int i = 0; i < indentLevel * spacesInTab; i++)";
        reader = new StringReader(lexerTest);
        lexer = new LexerFSM(reader);
        assertEquals(new Token("char", "f").toString(), lexer.getToken().toString());
        assertEquals(new Token("char", "o").toString(), lexer.getToken().toString());
        assertEquals(new Token("char", "r").toString(), lexer.getToken().toString());
        assertEquals(new Token("char", "r").toString(), lexer.getToken().toString());
    }

    @Test
    public void testLeftParentheses() throws LexerException, ReaderException {
        lexerTest = "(in";
        reader = new StringReader(lexerTest);
        lexer = new LexerFSM(reader);
        assertEquals(new Token("leftParentheses", "(").toString(), lexer.getToken().toString());
    }

    @Test
    public void testRightParentheses() throws LexerException, ReaderException {
        lexerTest = ")in";
        reader = new StringReader(lexerTest);
        lexer = new LexerFSM(reader);
        assertEquals(new Token("rightParentheses", ")").toString(), lexer.getToken().toString());
    }
}
