package com.company.lexer.lexerFSM.implementations;

import com.company.lexer.ILexer;
import com.company.lexer.IToken;
import com.company.lexer.LexerException;
import com.company.lexer.Token;
import com.company.lexer.lexerFSM.*;
import com.company.readerwriter.reader.IReader;
import com.company.readerwriter.reader.PostponedReader;
import com.company.readerwriter.reader.ReaderException;

/**
 * Final State Machine (FSM) Lexer
 */

public final class LexerFSM implements ILexer, ILexerContext {
    private PostponedReader reader;
    private StringBuilder lexeme;
    private String tokenName;

    /**
     * Default constructor
     * @param reader - input reading
     */

    public LexerFSM(final IReader reader) {
        this.reader = new PostponedReader(reader);
    }

    @Override
    public boolean canReadToken() throws LexerException {
        try {
            return reader.canReadChar();
        } catch (ReaderException e) {
            throw new LexerException("Can't read from stream", e);
        }
    }

    @Override
    public IToken getToken() throws LexerException {
        lexeme = new StringBuilder();
        char current;
        ILexerCommandRepository lexerCommands = new LexerCommandRepository();
        ILexerState lexerState = new LexerState("default");
        ILexerStateTransitions lexerStates = new LexerStateTransitions();
        try {
            while (reader.canReadChar() && lexerState != null) {
                current = reader.getChar();
                //System.out.println("Char: " + current);
                //System.out.println(lexerState.getState());
                ILexerCommand lexerCommand = lexerCommands.getCommand(lexerState, current);
                lexerCommand.execute(current, this);
                lexerState = lexerStates.nextState(lexerState, current);
            }
        } catch (ReaderException e) {
            throw new LexerException("Lexer crashed", e);
        }
        return new Token(this.tokenName, lexeme.toString());
    }

    @Override
    public void appendLexeme(final Character c) {
        this.lexeme.append(c);
    }

    @Override
    public void setTokenName(final String name) {
        tokenName = name;
    }

    @Override
    public void appendPostpone(final Character c) {
        reader.postponeChar(c);
    }
}