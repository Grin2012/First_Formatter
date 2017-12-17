package com.company.app_lexer_based;

import com.company.formatter.LexerBasedFormatter;
import com.company.lexer.ILexer;
import com.company.lexer.Lexer;
import com.company.lexer.LexerException;
import com.company.readerwriter.reader.ReaderException;
import com.company.readerwriter.reader.StringReader;
import com.company.readerwriter.writer.StringWriter;
import com.company.readerwriter.writer.WriterException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LexerBasedFormatterStringTest {

    @Test
    public void test_newline() throws Exception, ReaderException, WriterException, LexerException {
        String test = "123;456;789";
        String awaitingResult = "123;\n456;\n789";
        StringReader reader = new StringReader(test);
        StringWriter writer = new StringWriter();
        ILexer lexer = new Lexer(reader);
        LexerBasedFormatter formatter = new LexerBasedFormatter();
        formatter.format(lexer, writer);
        String testOut = writer.getString();
        assertEquals(awaitingResult, testOut);
    }

    @Test
    public void testMain_brace() throws Exception, ReaderException, WriterException, LexerException {
        String test = "{}";
        String awaitingResult = "{\n}";
        StringReader reader = new StringReader(test);
        StringWriter writer = new StringWriter();
        ILexer lexer = new Lexer(reader);
        LexerBasedFormatter formatter = new LexerBasedFormatter();
        formatter.format(lexer, writer);
        String testOut = writer.getString();
        assertEquals(awaitingResult, testOut);
    }

    @Test
    public void testMain_mbrace() throws Exception, ReaderException, WriterException, LexerException {
        String test = "{{}}";
        String awaitingResult = "{\n    {\n    }\n}";
        StringReader reader = new StringReader(test);
        StringWriter writer = new StringWriter();
        ILexer lexer = new Lexer(reader);
        LexerBasedFormatter formatter = new LexerBasedFormatter();
        formatter.format(lexer, writer);
        String testOut = writer.getString();
        assertEquals(awaitingResult, testOut);
    }

    @Test
    public void testMain_string() throws Exception, ReaderException, WriterException, LexerException {
        String test = "regrege{grgrg;}";

        String awaitingResult = "regrege {\n" +
                "    grgrg;\n" +
                "}";
        StringReader reader = new StringReader(test);
        StringWriter writer = new StringWriter();
        ILexer lexer = new Lexer(reader);
        LexerBasedFormatter formatter = new LexerBasedFormatter();
        formatter.format(lexer, writer);
        String testOut = writer.getString();
        assertEquals(awaitingResult, testOut);
    }

    @Test
    public void testMain_stringLiteral() throws Exception, ReaderException, WriterException, LexerException {
        String test = "String test = \"regrege{grgrg;}\"";
        String awaitingResult = "String test = \"regrege{grgrg;}\"";
        StringReader reader = new StringReader(test);
        StringWriter writer = new StringWriter();
        ILexer lexer = new Lexer(reader);
        LexerBasedFormatter formatter = new LexerBasedFormatter();
        formatter.format(lexer, writer);
        String testOut = writer.getString();
        assertEquals(awaitingResult, testOut);
    }

    @Test
    public void testMain_stringWithStringLiteral() throws Exception, ReaderException, WriterException, LexerException {
        String test = "\"regrege \"fsfdasf\" {grgrg;}\"";
        String awaitingResult = "\"regrege \"fsfdasf\" {grgrg;}\"";
        StringReader reader = new StringReader(test);
        StringWriter writer = new StringWriter();
        ILexer lexer = new Lexer(reader);
        LexerBasedFormatter formatter = new LexerBasedFormatter();
        formatter.format(lexer, writer);
        String testOut = writer.getString();
        assertEquals(awaitingResult, testOut);
    }

    @Test
    public void testMain_singleLineComment() throws Exception, ReaderException, WriterException, LexerException {
        String test = "//test";
        String awaitingResult = "//test";
        StringReader reader = new StringReader(test);
        StringWriter writer = new StringWriter();
        ILexer lexer = new Lexer(reader);
        LexerBasedFormatter formatter = new LexerBasedFormatter();
        formatter.format(lexer, writer);
        String testOut = writer.getString();
        assertEquals(awaitingResult, testOut);
    }

    @Test
    public void testMain_singleLineCommentWithSemicolon_noNewLineReturned() throws Exception, ReaderException, WriterException, LexerException {
        String test = "//int prevCharCode = -1;\n" +
                "while (reader.canReadChar()) {\n" +
                " char c = reader.getChar();\n" +
                "}\n";

        String awaitingResult = "//int prevCharCode = -1;\n" +
                "while (reader.canReadChar()) {\n" +
                "    char c = reader.getChar();\n" +
                "}";

        StringReader reader = new StringReader(test);
        StringWriter writer = new StringWriter();
        ILexer lexer = new Lexer(reader);
        LexerBasedFormatter formatter = new LexerBasedFormatter();
        formatter.format(lexer, writer);
        String testOut = writer.getString();
        assertEquals(awaitingResult, testOut);
    }

    @Test
    public void testMain() throws Exception, ReaderException, WriterException, LexerException {
        String test = "package com.company;\n" +
                "import com.company.model.*;\n" +
                "import java.io.IOException;\n" +
                "import java.io.StringReader;\n" +
                "public class TestSyntaxJavaCodeParser {\n" +
                "    public CodeEntity parseCode(StringReader reader) throws IOException {\n" +
                "        CodeEntity root = new CodeEntity(); parseCode(root, reader);\n" +
                "        return root; }   private void parseCode(CodeEntity parentEntity, StringReader reader) throws IOException {\n" +
                "        CodeEntity currentEntity = null;\n" +
                "        int charCode = -1; while((charCode = reader.read()) != -1) {\n" +
                "        }\n" +
                "    }\n" +
                "}";

        String awaitingResult = "package com.company;\n" +
                "import com.company.model.*;\n" +
                "import java.io.IOException;\n" +
                "import java.io.StringReader;\n" +
                "public class TestSyntaxJavaCodeParser {\n" +
                "    public CodeEntity parseCode(StringReader reader) throws IOException {\n" +
                "        CodeEntity root = new CodeEntity();\n" +
                "        parseCode(root, reader);\n" +
                "        return root;\n" +
                "    }\n" +
                "    private void parseCode(CodeEntity parentEntity, StringReader reader) throws IOException {\n" +
                "        CodeEntity currentEntity = null;\n" +
                "        int charCode = -1;\n" +
                "        while((charCode = reader.read()) != -1) {\n" +
                "        }\n" +
                "    }\n" +
                "}";

        StringReader reader = new StringReader(test);
        StringWriter writer = new StringWriter();
        ILexer lexer = new Lexer(reader);
        LexerBasedFormatter formatter = new LexerBasedFormatter();
        formatter.format(lexer, writer);
        String testOut = writer.getString();
        assertEquals(awaitingResult, testOut);
    }

    @Test
    public void testMain2() throws Exception, ReaderException, WriterException, LexerException {
        String test = "import com.company.model.*;\n" +
                "import com.company.readerwriter.reader.ReaderException;\n" +
                "import com.company.readerwriter.reader.IReader;\n" +
                "\n" +
                "import java.io.IOException;\n" +
                "\n" +
                "/**\n" +
                " * parseCode source code\n" +
                " */\n" +
                "public class JavaCodeParser {\n" +
                "    /**\n" +
                "     * @param reader - reader result = char\n" +
                "     * @return - return conception\n" +
                "     * @throws IOException     - when something wrong\n" +
                "     * @throws ReaderException - when something wrong\n" +
                "     */\n" +
                "    public CodeEntity parseCode(final IReader reader) throws IOException, ReaderException {\n" +
                "        CodeEntity root = new CodeEntity();\n" +
                "        parseCode(root, reader);\n" +
                "        return root;\n" +
                "    }\n" +
                "\n" +
                "\n" +
                "    private void parseCode(final CodeEntity parentEntity, final IReader reader) throws IOException, ReaderException {\n" +
                "        CodeEntity currentEntity = null;\n" +
                "        //  int prevCharCode = -1;\n" +
                "        while (reader.canReadChar()) {\n" +
                "            char c = reader.getChar();\n" +
                "        }\n" +
                "    }\n" +
                "}";

        String awaitingResult = "import com.company.model.*;\n" +
                "import com.company.readerwriter.reader.ReaderException;\n" +
                "import com.company.readerwriter.reader.IReader;\n" +
                "import java.io.IOException;\n" +
                "/**\n" +
                " * parseCode source code\n" +
                " */\n" +
                "public class JavaCodeParser {\n" +
                "    /**\n" +
                "     * @param reader - reader result = char\n" +
                "     * @return - return conception\n" +
                "     * @throws IOException     - when something wrong\n" +
                "     * @throws ReaderException - when something wrong\n" +
                "     */\n" +
                "    public CodeEntity parseCode(final IReader reader) throws IOException, ReaderException {\n" +
                "        CodeEntity root = new CodeEntity();\n" +
                "        parseCode(root, reader);\n" +
                "        return root;\n" +
                "    }\n" +
                "    private void parseCode(final CodeEntity parentEntity, final IReader reader) throws IOException, ReaderException {\n" +
                "        CodeEntity currentEntity = null;\n" +
                "        //  int prevCharCode = -1;\n" +
                "        while (reader.canReadChar()) {\n" +
                "            char c = reader.getChar();\n" +
                "        }\n" +
                "    }\n" +
                "}";

        StringReader reader = new StringReader(test);
        StringWriter writer = new StringWriter();
        ILexer lexer = new Lexer(reader);
        LexerBasedFormatter formatter = new LexerBasedFormatter();
        formatter.format(lexer, writer);
        String testOut = writer.getString();
        assertEquals(awaitingResult, testOut);
    }
}