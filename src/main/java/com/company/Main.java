package com.company;
import com.company.formatter.FormatterException;
import com.company.formatter.ILexerFormatter;
import com.company.formatter.LexerBasedFormatter;
import com.company.lexer.ILexer;
import com.company.lexer.Lexer;
import com.company.lexer.LexerException;
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
     * @throws LexerException - lexer exception
     */
    public static void main(final String[] args) throws Exception, ReaderException, WriterException, LexerException, FormatterException {

        FileReader reader = new FileReader(args[0]);
        FileWriter writer = new FileWriter(args[1]);
        ILexer lexer = new Lexer(reader);
        ILexerFormatter formatter = new LexerBasedFormatter();
        formatter.format(lexer, writer);
        reader.close();
        writer.close();

//        System.out.print(writer.getString());
//        lexer = new Lexer(new StringReader(fileContent));
//        while (lexer.canReadToken()) {
//        System.out.println(lexer.getToken());
//        }
//        TreeBasedFormatter formatter = new TreeBasedFormatter();
//        formatter.format(reader, writer);
//        reader.close();
//        writer.close();
//
    }
}


