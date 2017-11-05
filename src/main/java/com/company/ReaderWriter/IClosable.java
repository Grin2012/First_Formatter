package com.company.ReaderWriter;

public interface IClosable extends AutoCloseable {

    @Override
    void close() throws Exception;
}