package com.company;
import com.company.Model.CodeEntity;

import com.company.ReaderWriter.IClosable;
import com.company.ReaderWriter.IOexeption.ReaderException;
import com.company.ReaderWriter.IOexeption.WriterException;
import com.company.ReaderWriter.IOfile.*;
import com.company.ReaderWriter.IOstring.StringReader;
import com.company.ReaderWriter.IOstring.StringWriter;
import com.company.ReaderWriter.IReader;


public class Main {

    public static void main(final String[] args) throws Exception, ReaderException, WriterException {

        String fileContent = "package com.company;\n" +
                "\n" +
                "import com.company.Model.*;\n" +
                "import java.io.IOException;\n" +
                "import java.io.StringReader;\n" +
                "\n" +
                "\n" +
                "public class TestSyntaxJavaCodeParser\n" +
                "{\n" +
                "    public CodeEntity Parse(StringReader reader) throws IOException {\n" +
                "        CodeEntity root = new CodeEntity();\n" +
                "        Parse(root, reader);\n" +
                "        return root;\n" +
                "    }\n" +
                "\n" +
                "    private void Parse(CodeEntity parentEntity, StringReader reader) throws IOException {\n" +
                "        CodeEntity currentEntity = null;\n" +
                "\n" +
                "        int charCode = -1;\n" +
                "        while((charCode = reader.read()) != -1) {\n" +
                "            \n" +
                "        }\n" +
                "    }\n" +
                "}";

        FileReader reader = new FileReader(args[0]);
        FileWriter writer = new FileWriter(args[1]);
//        StringWriter writer = new StringWriter();
        JavaCodeParser parser = new JavaCodeParser();
        CodeEntity root = parser.Parse(reader);
        root.write(writer);
        reader.close();
//        System.out.print(writer.getString());
        writer.close();

    }
}


