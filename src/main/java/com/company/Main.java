package com.company;
import com.company.formater.Formater;
import com.company.readerwriter.reader.FileReader;
import com.company.readerwriter.reader.ReaderException;
import com.company.readerwriter.writer.FileWriter;
import com.company.readerwriter.writer.WriterException;

/**
 * Main method to format the source code
 */

public class Main {
    /**
     *
     * @param args - args 0 - input file, args 1 - output file
     * @throws Exception - general Exception
     * @throws ReaderException - reader exception
     * @throws WriterException - writer exception
     */
    public static void main(final String[] args) throws Exception, ReaderException, WriterException {

        String fileContent = "package com.company;\n" +
                "\n" +
                "import com.company.model.*;\n" +
                "import java.io.IOException;\n" +
                "import java.io.StringReader;\n" +
                "\n" +
                "\n" +
                "public class TestSyntaxJavaCodeParser\n" +
                "{\n" +
                "    public CodeEntity parseCode(StringReader reader) throws IOException {\n" +
                "        CodeEntity root = new CodeEntity();\n" +
                "        parseCode(root, reader);\n" +
                "        return root;\n" +
                "    }\n" +
                "\n" +
                "    private void parseCode(CodeEntity parentEntity, StringReader reader) throws IOException {\n" +
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
        Formater.formate(reader, writer);
        reader.close();
        writer.close();

    }
}


