package com.company.lexer;

import java.util.LinkedList;
import java.util.Queue;

public class TokenBuffer {
    private Queue<IToken> tokens;

    public TokenBuffer() {
        this.tokens = new LinkedList<IToken>();
    }

    public void push(final IToken token) {
        this.tokens.add(token);
    }

    public IToken unshift() {
        return this.tokens.remove();
    }

    public boolean isEmpty() {
        return this.tokens.isEmpty();
    }
}