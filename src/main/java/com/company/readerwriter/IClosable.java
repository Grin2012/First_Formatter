package com.company.readerwriter;

/**
 *  Closeable interface.
 */
public interface IClosable extends AutoCloseable {

    @Override
    void close() throws CloseException;
}