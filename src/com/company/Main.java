package com.company;
import com.company.Model.CodeEntity;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
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
        StringReader reader = new StringReader(fileContent);
        JavaCodeParser parser = new JavaCodeParser();
        CodeEntity root = parser.Parse(reader);
        System.out.print(root.print());
    }
}


