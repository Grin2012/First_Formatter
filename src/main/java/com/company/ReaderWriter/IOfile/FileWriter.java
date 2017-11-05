package com.company.ReaderWriter.IOfile;

import com.company.ReaderWriter.IClosable;
import com.company.ReaderWriter.IWriter;
import com.company.ReaderWriter.IOexeption.WriterException;

import java.io.*;
import java.nio.file.*;


public class FileWriter implements IWriter, IClosable {
    private Writer writer;

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
    public void close() throws Exception {
        writer.close();
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