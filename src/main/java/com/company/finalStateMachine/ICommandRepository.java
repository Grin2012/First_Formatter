package com.company.finalStateMachine;

/**
 * FSM commands repository
 * @param <I> - input Data
 */
public interface ICommandRepository<I> {
    /**
     * @param state - current State
     * @param in - input Data
     * @return command from repo
     */
 ICommand getCommand(IState state, I in);
}
