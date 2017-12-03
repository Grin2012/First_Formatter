package com.company.lexer.lexerFSM;

import com.company.finalStateMachine.ICommand;
import com.company.finalStateMachine.IContext;

public class LexerCommand implements ICommand {
    private String tokenName;

    public LexerCommand(String tokenName ) {
        this.tokenName = tokenName;
    }

    @Override
    public void execute(char c, IContext ctx) {
        ctx.appendLexeme(c);
        ctx.setTokenName(tokenName);

    }
}