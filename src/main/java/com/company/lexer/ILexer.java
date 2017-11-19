package com.company.lexer;

import com.company.readerwriter.reader.ReaderException;

public interface ILexer {

    boolean hasMoreTokens() throws ReaderException;

    IToken readToken() throws Exception, ReaderException;
}