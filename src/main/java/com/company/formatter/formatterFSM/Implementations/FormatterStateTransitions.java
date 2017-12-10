package com.company.formatter.formatterFSM.Implementations;

import com.company.Pair;
import com.company.formatter.formatterFSM.IFormatterState;
import com.company.formatter.formatterFSM.IFormatterStateTransitions;
import com.company.lexer.IToken;
import java.util.HashMap;
import java.util.Map;

/**
 * implementation of IFormatterStateTransitions
 */

public class FormatterStateTransitions implements IFormatterStateTransitions {

    private Map<Pair<IFormatterState, String>, IFormatterState> formatterStates;

    /**
     * Transition map of FSM formatter
     */

    public FormatterStateTransitions(Map<Pair<IFormatterState, String>, IFormatterState> formatterStates) {
        this.formatterStates = formatterStates;
    }

    public FormatterStateTransitions() {
        formatterStates.put(new Pair<>(new FormatterState("default"), "char"), new FormatterState("default"));
        formatterStates.put(new Pair<>(new FormatterState("default"), "semicolon"), new FormatterState("startNewLine"));
        formatterStates.put(new Pair<>(new FormatterState("startNewLine"), "newLine"), new FormatterState("startNewLine"));
        formatterStates.put(new Pair<>(new FormatterState("startNewLine"), "space"), new FormatterState("startNewLine"));
        formatterStates.put(new Pair<>(new FormatterState("startNewLine"), "char"), new FormatterState("default"));
    }

    @Override
    public IFormatterState nextState(final IFormatterState state, final IToken token) {
        IFormatterState formatterState = formatterStates.get(new Pair<>(state, token.getName()));
        if (formatterState == null) {
            formatterState = formatterStates.get(new Pair<>(state, (String) null));
        }
        return formatterState;
    }
}
