package com.company.readerwriter.reader;

/**
* Reader contract.
 */
public interface IReader {
    /**
     * @return readed char
     * @throws ReaderException when something wrong
     */
    char getChar() throws ReaderException;

    /**
     *
     * @return true, when we have next char form input
     * @throws ReaderException when something wrong
     */
    boolean canReadChar() throws ReaderException;
}