package com.company.formatter.formatterFSM;

import com.company.formatter.FormatterException;
import com.company.lexer.IToken;
import com.company.readerwriter.writer.WriterException;

/**
 * Formatter Command interface
 */
public interface IFormatterCommand {
    /**
     * Formatter Command
     * @param token - current token
     * @param context - formatter context
     * @throws FormatterException - Formatter Exception
     * @throws WriterException - Writer Exception
     */
    void execute(IToken token, IFormatterContext context) throws FormatterException, WriterException;
}