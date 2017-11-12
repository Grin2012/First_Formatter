package com.company.readerwriter.writer;

/**
 * Writer contract.
 */
public interface IWriter {

    /**
     * Write one char
     * @param c - this char will be writer
     * @throws WriterException - something wrong
     */
    void writeChar(char c) throws WriterException;

}