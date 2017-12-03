package com.company.lexer.lexerFSM;

import com.company.finalStateMachine.*;
import com.company.lexer.ILexer;
import com.company.lexer.IToken;
import com.company.lexer.LexerException;
import com.company.lexer.Token;
import com.company.readerwriter.reader.IReader;
import com.company.readerwriter.reader.PosponedReader;
import com.company.readerwriter.reader.ReaderException;

public class LexerFSM implements ILexer, IContext {
    private PosponedReader reader;
    private StringBuilder lexeme;
    private String tokenName;

    public LexerFSM(final IReader reader) {
        this.reader = new PosponedReader(reader);
    }

    @Override
    public boolean canReadToken() throws LexerException, ReaderException {
        try {
            return reader.canReadChar();
        } catch (ReaderException e) {
            throw new LexerException("Can't read from stream", e);
        }
    }

    @Override
    public IToken getToken() throws LexerException, ReaderException {
        lexeme = new StringBuilder();

        char current;
        IState lexerState = new LexerState("initial");
        ICommandRepository<Character> lexerCommands = new LexerCommandRepository();

        IStateTransitions lexerTransitions = new LexerStateTransitions();
       //while (reader.canReadChar() && lexerState != null) {
        while (reader.canReadChar() && lexerState.getState() != null) {
            try {
                current = reader.getChar();
                lexerState = lexerTransitions.nextState(lexerState, current);
                ICommand lexerCommand = lexerCommands.getCommand(lexerState, current);
                lexerCommand.execute(current, this);
            } catch (ReaderException e) {
                throw new LexerException("Lexer crashed", e);
           }
        }

        return new Token(this.tokenName, lexeme.toString());
        //return null;
    }

    @Override
    public void appendLexeme(final char c) {
        this.lexeme.append(c);
    }

    @Override
    public void setTokenName(final String name) {
        tokenName = name;
    }

    @Override
    public void appendPostpone(final char c) {
        reader.posponeChar(c);
    }
}