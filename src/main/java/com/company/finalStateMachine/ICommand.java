package com.company.finalStateMachine;

/**
 * Command of FSM state
 */
public interface ICommand {
    /**
     * Command method
     */
    void execute(char c, IContext ctx);
}