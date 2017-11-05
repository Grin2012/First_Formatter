package com.company;

import com.company.Model.CodeEntity;
import com.company.ReaderWriter.IOexeption.ReaderException;
import com.company.ReaderWriter.IOexeption.WriterException;
import com.company.ReaderWriter.IOstring.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FormatterStringTest {

    @Test
    public void testMain() throws Exception, ReaderException, WriterException {
        String test = "package com.company;\n" +
                "import com.company.Model.*;\n" +
                "import java.io.IOException;\n" +
                "import java.io.StringReader;\n" +
                "public class TestSyntaxJavaCodeParser {\n" +
                "    public CodeEntity Parse(StringReader reader) throws IOException {\n" +
                "        CodeEntity root = new CodeEntity(); Parse(root, reader);\n" +
                "        return root; }   private void Parse(CodeEntity parentEntity, StringReader reader) throws IOException {\n" +
                "        CodeEntity currentEntity = null;\n" +
                "        int charCode = -1; while((charCode = reader.read()) != -1) {\n" +
                "\n" +
                "        }\n" +
                "    }\n" +
                "}";

        String awaitingResult = "package com.company;\n" +
                "import com.company.Model.*;\n" +
                "import java.io.IOException;\n" +
                "import java.io.StringReader;\n" +
                "public class TestSyntaxJavaCodeParser {\n" +
                "    public CodeEntity Parse(StringReader reader) throws IOException {\n" +
                "        CodeEntity root = new CodeEntity();\n" +
                "        Parse(root, reader);\n" +
                "        return root;\n" +
                "    }\n" +
                "    private void Parse(CodeEntity parentEntity, StringReader reader) throws IOException {\n" +
                "        CodeEntity currentEntity = null;\n" +
                "        int charCode = -1;\n" +
                "        while((charCode = reader.read()) != -1) {\n" +
                "\n" +
                "        }\n" +
                "    }\n" +
                "}";

        StringReader reader = new StringReader(test);
        StringWriter writer = new StringWriter();
        JavaCodeParser parser = new JavaCodeParser();
        CodeEntity root = parser.Parse(reader);
        root.write(writer);
        String testOut = writer.getString();
        assertEquals(awaitingResult, testOut);
    }
}
