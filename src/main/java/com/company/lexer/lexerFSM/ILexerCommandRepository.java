package com.company.lexer.lexerFSM;

/**
 * FSM commands repository
 *
 */
public interface ILexerCommandRepository {
    /**
     * @param state - current State
     * @param c - current data
     * @return command from repo
     *
     */
 ILexerCommand getCommand(ILexerState state, Character c);
}
