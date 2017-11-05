package com.company.ReaderWriter;

import com.company.ReaderWriter.IOexeption.ReaderException;

public interface IReader {

    char readChar() throws ReaderException;
    boolean hasChar() throws ReaderException;

}