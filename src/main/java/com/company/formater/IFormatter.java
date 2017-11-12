package com.company.formater;

import com.company.readerwriter.reader.IReader;
import com.company.readerwriter.writer.IWriter;
import com.company.readerwriter.reader.ReaderException;
import com.company.readerwriter.writer.WriterException;

import java.io.IOException;

/**
 * Formatter interface.
 */

public interface IFormatter {

    /**
     * Format the source code
     * @param reader - implemented IReader
     * @param writer - implemented IWriter
     * @throws WriterException - writer exceptions
     * @throws IOException - IO exceptions
     * @throws ReaderException - reader exceptions
     */
    void format (IReader reader, IWriter writer) throws WriterException, IOException, ReaderException;
}