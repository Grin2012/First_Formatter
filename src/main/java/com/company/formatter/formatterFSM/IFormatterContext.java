package com.company.formatter.formatterFSM;

import com.company.formatter.FormatterException;

/**
 * interface IFormatterContext contains contract actions with content
 */
public interface IFormatterContext {
    /**
     * Write lexeme to output
     * @param lexeme - the part of source code
     * @throws FormatterException - Formatter Exception
     */
    void writeLexeme(String lexeme) throws FormatterException;
    /**
     * Write New line to formatting code
     * @throws FormatterException - Formatter Exception
     */
    void writeNewLine() throws FormatterException;
    /**
     * Write Indent to formatting code
     * @throws FormatterException - Formatter Exception
     */
    void writeIndent() throws FormatterException;
    /**
     * Write Space to formatting code
     * @throws FormatterException - Formatter Exception
     */
    void writeSpace() throws FormatterException;
    /**
     * Increase Indent
     */
    void increaseIndentLevel();
    /**
     * Decrease Indent
     */
    void decreaseIndentLevel();
}

