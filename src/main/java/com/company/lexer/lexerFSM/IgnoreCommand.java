package com.company.lexer.lexerFSM;

import com.company.finalStateMachine.ICommand;
import com.company.finalStateMachine.IContext;

/**
 * LexerCommand inplements IComand
 */

public class IgnoreCommand implements ICommand {
    @Override
    public void execute(char c, IContext ctx) {
        //Do nothing.
    }
}
