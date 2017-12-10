package com.company.lexer.lexerFSM;

/**
 * Command of FSM state
 */
public interface ILexerCommand {
    /**
     * Command method implementation of ILexerCommand
     * @param c - current char
     * @param context - current context
     */
    void execute(Character c, ILexerContext context);
}