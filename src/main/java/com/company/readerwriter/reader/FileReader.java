package com.company.readerwriter.reader;

import com.company.readerwriter.CloseException;
import com.company.readerwriter.IClosable;

import java.io.InputStreamReader;
import java.io.Reader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
/**
 * Read from file char by char
 */
public class FileReader implements IReader, IClosable {
    private Reader reader;
    private CharCodeCache charCodeCache;
    /**
     * @param pathString - path to file
     * @throws ReaderException - this exception appear when we can't open reader
     */
    public FileReader(final String pathString) throws ReaderException {
        this.charCodeCache = new CharCodeCache();
        FileSystem fileSystems = FileSystems.getDefault();
        Path path = fileSystems.getPath(pathString);
        try {
            reader = new InputStreamReader(Files.newInputStream(path), "utf-8");
        } catch (IOException e) {
            throw new ReaderException(e);
        }
    }

    @Override
    public void close() throws CloseException {
        try {
            reader.close();
        } catch (IOException e) {
            throw new CloseException("fault", e);
        }
    }

    @Override
    public char readChar() throws ReaderException {
        try {
            if (hasChar()) {
                return this.charCodeCache.toChar();
            }
            throw new ReaderException("stream_end");
        } finally {
            this.charCodeCache.clean();
        }
    }

    @Override
    public boolean hasChar() throws ReaderException {
        try {
            if (!this.charCodeCache.isEmpty()) {
                return true;
            }
            this.charCodeCache.add(reader.read());
            return !this.charCodeCache.isEmpty();
        } catch (IOException e) {
            throw new ReaderException(e);
        }
    }
}