package com.company.formatter.formatterFSM;

import com.company.lexer.IToken;

/**
 * Transition between states
 *
 */
public interface IFormatterStateTransitions {
    /**
     * @param state - current State
     * @param token - current Token
     * @return -next FSM state
     *
     */

    IFormatterState nextState(IFormatterState state, IToken token);
}