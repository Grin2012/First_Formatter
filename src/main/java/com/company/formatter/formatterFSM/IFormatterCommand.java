package com.company.formatter.formatterFSM;

import com.company.formatter.FormatterException;
import com.company.lexer.IToken;
import com.company.readerwriter.writer.WriterException;

public interface IFormatterCommand {

    void execute(IToken token, IFormatterContext context) throws FormatterException, WriterException;
}