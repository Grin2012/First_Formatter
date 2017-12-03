package com.company.finalStateMachine;

/**
 * Transition between states
 * @param <I> - input Data
 */
public interface IStateTransitions<I> {
    /**
     * @param state - current State
     * @param in - input Data
     * @return -next FSM state
     */

    IState nextState(IState state, I in);
}


