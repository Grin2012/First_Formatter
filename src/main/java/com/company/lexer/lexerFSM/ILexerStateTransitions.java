package com.company.lexer.lexerFSM;

/**
 * Transition between states
 *
 */
public interface ILexerStateTransitions {
    /**
     * @param state - current State
     * @param in - input Data
     * @return -next FSM state
     *
     */

    ILexerState nextState(ILexerState state, Character in);
}


