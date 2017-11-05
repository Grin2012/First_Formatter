package com.company.ReaderWriter.IOfile;

import com.company.ReaderWriter.IClosable;
import com.company.ReaderWriter.IReader;
import com.company.ReaderWriter.IOexeption.ReaderException;

import java.io.*;
import java.nio.file.*;

public class FileReader implements IReader, IClosable {
    private Reader reader;
    private int charCode;

    public FileReader(final String pathString) throws ReaderException {
        FileSystem fileSystems = FileSystems.getDefault();
        Path path = fileSystems.getPath(pathString);
        try {
            reader = new InputStreamReader(Files.newInputStream(path), "utf-8");
        } catch (IOException e) {
            throw new ReaderException(e);
        }
    }

    @Override
    public void close() throws Exception {
        try {
            reader.close();
        } catch (IOException e) {
            throw new Exception(e);
        }
    }

    @Override
    public char readChar() throws ReaderException {
        try {
            if (charCode != -1) {
                return (char) charCode;
            } else {
                if (hasChar()) {
                    return (char) charCode;
                } else {
                    throw new ReaderException("stream_end");
                }
            }
        } finally {
            charCode = -1;
        }
    }

    @Override
    public boolean hasChar() throws ReaderException {
        try {
            charCode = reader.read();
            return charCode >= 0;
        } catch (IOException e) {
            throw new ReaderException(e);
        }
    }

}