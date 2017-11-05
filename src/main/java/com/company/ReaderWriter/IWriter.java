package com.company.ReaderWriter;

import com.company.ReaderWriter.IOexeption.WriterException;

public interface IWriter {

    void writeChar(char c) throws WriterException;
}