package com.company.formatter.formatterFSM;

import com.company.lexer.IToken;

/**
 * FSM commands repository
 *
 */
public interface IFormatterCommandRepository {
    /**
     * @param state - current State
     * @param token - current Token
     * @return command from repo
     *
     */
 IFormatterCommand getCommand(IFormatterState state, IToken token);
}
