package com.company.formatter.formatterFSM.Implementations;

import com.company.formatter.formatterFSM.IFormatterState;

/**
 * FormatterState implements interface IFormatterState
 */

public final class FormatterState implements IFormatterState {
    private final String state;

    /**
     * State constructor
     * @param state - state
     */

    public FormatterState(final String state) {
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

        FormatterState that = (FormatterState) o;

        return state.equals(that.state);
    }

    @Override
    public int hashCode() {
        return state.hashCode();
    }

    @Override
    public String toString() {
        return "FormatterState{" + state + "}";
    }
}
