package com.company.lexer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Create Queue from Tokens
 */

public class TokenBuffer {
    private Queue<IToken> tokens;

    /**
     * Create TokenBuffer
     */
    public TokenBuffer() {
        this.tokens = new LinkedList<IToken>();
    }

    /**
     * Write Token to TokenBuffer
     * @param token - Token
     */
    public void push(final IToken token) {
        this.tokens.add(token);
    }

    /**
     * Take Token from Buffer
     * @return Token from buffer
     */
    public IToken unShift() {
        return this.tokens.remove();
    }

    /**
     * Check Buffer for more Tokens
     * @return - boolean
     */
    public boolean isEmpty() {
        return this.tokens.isEmpty();
    }
}