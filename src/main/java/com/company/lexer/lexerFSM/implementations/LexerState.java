package com.company.lexer.lexerFSM.implementations;

import com.company.lexer.lexerFSM.ILexerState;

/**
 * Implementation of ILexerState
 */

public final class LexerState implements ILexerState {
    private final String state;

    /**
     * Defult constructor
     * @param state - current state
     */
    public LexerState(final String state) {
        this.state = state;
    }

    @Override
    public String getState() {
        return this.state;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        LexerState that = (LexerState) o;

        return state.equals(that.state);
    }

    @Override
    public int hashCode() {
        return state.hashCode();
    }

    @Override
    public String toString() {
        return "LexerState{" + state + "}";
    }
}
