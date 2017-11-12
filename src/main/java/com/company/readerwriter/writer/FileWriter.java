package com.company.readerwriter.writer;

import com.company.readerwriter.CloseException;
import com.company.readerwriter.IClosable;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Files;

/**
 * Write to file char by char
 */

public class FileWriter implements IWriter, IClosable {
    private Writer writer;

    /***
     * @param pathString - path to file location
     * @throws WriterException - trows when can't open file to write
     */
    public FileWriter(final String pathString) throws WriterException {
        FileSystem fileSystems = FileSystems.getDefault();
        Path path = fileSystems.getPath(pathString);
        try {
            writer = new OutputStreamWriter(Files.newOutputStream(path), "utf-8");
        } catch (IOException e) {
            throw new WriterException(e);
        }
    }

    @Override
    public void close() throws CloseException {
        try {
            writer.close();
        } catch (IOException e) {
            throw new CloseException("writer", e);
        }
    }

    @Override
    public void writeChar(final char c) throws WriterException {
        try {
            writer.write(c);
        } catch (IOException e) {
            throw new WriterException(e);
        }
    }
}