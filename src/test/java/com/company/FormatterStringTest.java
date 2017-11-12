package com.company;

import com.company.formater.*;
import com.company.readerwriter.reader.*;
import com.company.readerwriter.writer.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FormatterStringTest {

    @Test
    public void testMain_brace() throws Exception, ReaderException, WriterException {
        String test = "{}";
        String awaitingResult = "{\n\n}";
        StringReader reader = new StringReader(test);
        StringWriter writer = new StringWriter();
        Formater.formate(reader, writer);
        String testOut = writer.getString();
        assertEquals(awaitingResult, testOut);

    }

    @Test
    public void testMain_s() throws Exception, ReaderException, WriterException {
        String test = "regrege{grgrg}";

        String awaitingResult = "regrege {\n" +
                "    grgrg\n" +
                "}";
        StringReader reader = new StringReader(test);
        StringWriter writer = new StringWriter();
        Formater.formate(reader, writer);
        String testOut = writer.getString();
        assertEquals(awaitingResult, testOut);

    }

    @Test
    public void testMain() throws Exception, ReaderException, WriterException {
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
                "\n" +
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
                "\n" +
                "        }\n" +
                "    }\n" +
                "}";

        StringReader reader = new StringReader(test);
        StringWriter writer = new StringWriter();
        Formater.formate(reader, writer);
        String testOut = writer.getString();
        assertEquals(awaitingResult, testOut);
    }
}
