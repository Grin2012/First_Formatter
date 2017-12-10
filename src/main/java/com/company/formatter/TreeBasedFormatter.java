package com.company.formatter;

import com.company.model.CodeEntity;
import com.company.readerwriter.reader.IReader;
import com.company.readerwriter.reader.ReaderException;
import com.company.readerwriter.writer.IWriter;
import com.company.readerwriter.writer.WriterException;
import java.io.IOException;

/**
 * TreeBasedFormatter format sourse
 */
public class TreeBasedFormatter implements IFormatter {
    /**
     * Format the source code
     * @param reader - implemented IReader
     * @param writer - implemented IWriter
     * @throws WriterException - writer exceptions
     * @throws IOException - IO exceptions
     * @throws ReaderException - reader exceptions
     */

    public void format(final IReader reader, final IWriter writer) throws WriterException, IOException, ReaderException {
        JavaCodeParser parser = new JavaCodeParser();
        CodeEntity root = parser.parseCode(reader);
        root.write(writer);
    }
}