package com.company.formatter.formatterFSM.Implementations;

import com.company.formatter.FormatterException;
import com.company.formatter.formatterFSM.*;
import com.company.formatter.ILexerFormatter;
import com.company.lexer.ILexer;
import com.company.lexer.IToken;
import com.company.lexer.LexerException;
import com.company.readerwriter.reader.ReaderException;
import com.company.readerwriter.writer.IWriter;
import com.company.readerwriter.writer.WriterException;

/**
 * Final State machine formatter
 */

public class FormatterFSM implements ILexerFormatter {
    private IFormatterCommandRepository formatterCommands = new FormatterCommandRepository();
    private IFormatterStateTransitions formatterStates = new FormatterStateTransitions();

    @Override
    public void format(final ILexer lexer, final IWriter writer) throws WriterException, ReaderException,
            LexerException, FormatterException {
        IFormatterContext formatterContext = new FormatterContext(writer);
        IFormatterState formatterState = new FormatterState("default");
        while (lexer.canReadToken() && formatterState != null) {
            IToken token = lexer.getToken();
            IFormatterCommand formatterCommand = formatterCommands.getCommand(formatterState, token);
            formatterCommand.execute(token, formatterContext);
            formatterState = formatterStates.nextState(formatterState, token);
        }
    }
}