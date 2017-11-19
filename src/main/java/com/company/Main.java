package com.company;
import com.company.formater.LexerBasedFormatter;
import com.company.formater.TreeBasedFormatter;
import com.company.lexer.ILexer;
import com.company.lexer.Lexer;
import com.company.readerwriter.reader.FileReader;
import com.company.readerwriter.reader.ReaderException;
import com.company.readerwriter.reader.StringReader;
import com.company.readerwriter.writer.FileWriter;
import com.company.readerwriter.writer.StringWriter;
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

//        FileReader reader = new FileReader(args[0]);

        ILexer lexer = new Lexer(new StringReader(fileContent));
        StringWriter writer = new StringWriter();
        LexerBasedFormatter formatter = new LexerBasedFormatter();
        formatter.format(lexer, writer);
        System.out.print(writer.getString());

        lexer = new Lexer(new StringReader(fileContent));
        while (lexer.hasMoreTokens()) {
        System.out.println(lexer.readToken());
        }



/*        FileWriter writer = new FileWriter(args[1]);
        TreeBasedFormatter formatter = new TreeBasedFormatter();
        formatter.format(reader, writer);
        reader.close();
        writer.close();
*/
    }
}


