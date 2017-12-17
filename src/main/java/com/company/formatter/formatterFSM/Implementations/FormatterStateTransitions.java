package com.company.formatter.formatterFSM.Implementations;

import com.company.Util.Pair;
import com.company.formatter.formatterFSM.IFormatterState;
import com.company.formatter.formatterFSM.IFormatterStateTransitions;
import com.company.lexer.IToken;

import java.util.HashMap;
import java.util.Map;

/**
 * implementation of IFormatterStateTransitions
 */

public class FormatterStateTransitions implements IFormatterStateTransitions {

    private Map<Pair<IFormatterState, String>, IFormatterState> formatterStates = new HashMap<>();

    /**
     * Map of Formatter state transitions
     */

    public FormatterStateTransitions() {
        FormatterState stateDefault =  new FormatterState("default");
        FormatterState stateNeedSpace =  new FormatterState("needSpace");
        FormatterState stateStartNewLine =  new FormatterState("startNewLine");
        FormatterState stateFor =  new FormatterState("for");
        FormatterState stateForStatement =  new FormatterState("forStatement");

        /*DEFAULT STATE*/
        formatterStates.put(new Pair<>(stateDefault, null), stateDefault);
        formatterStates.put(new Pair<>(stateDefault, "char"), stateNeedSpace);
        formatterStates.put(new Pair<>(stateDefault, "space"), stateDefault);
        formatterStates.put(new Pair<>(stateDefault, "singleComment"), stateDefault);
        formatterStates.put(new Pair<>(stateDefault, "multiComment"), stateDefault);
        formatterStates.put(new Pair<>(stateDefault, "newLine"), stateDefault);
        formatterStates.put(new Pair<>(stateDefault, "leftParentheses"), stateDefault);
        formatterStates.put(new Pair<>(stateDefault, "rightParentheses"), stateDefault);
        formatterStates.put(new Pair<>(stateDefault, "semiColon"), stateStartNewLine);
        formatterStates.put(new Pair<>(stateDefault, "rightBrace"), stateStartNewLine);
        formatterStates.put(new Pair<>(stateDefault, "leftBrace"), stateStartNewLine);
        formatterStates.put(new Pair<>(stateDefault, "for"), stateFor);

        /* NEED SPACE OR NOT*/
        formatterStates.put(new Pair<>(stateNeedSpace, null), stateNeedSpace);
        formatterStates.put(new Pair<>(stateNeedSpace, "char"), stateNeedSpace);
        formatterStates.put(new Pair<>(stateNeedSpace, "space"), stateDefault);
        formatterStates.put(new Pair<>(stateNeedSpace, "singleComment"), stateDefault);
        formatterStates.put(new Pair<>(stateNeedSpace, "multiComment"), stateDefault);
        formatterStates.put(new Pair<>(stateNeedSpace, "newLine"), stateNeedSpace);
        formatterStates.put(new Pair<>(stateNeedSpace, "leftParentheses"), stateDefault);
        formatterStates.put(new Pair<>(stateNeedSpace, "rightParentheses"), stateDefault);
        formatterStates.put(new Pair<>(stateNeedSpace, "semiColon"), stateStartNewLine);
        formatterStates.put(new Pair<>(stateNeedSpace, "rightBrace"), stateStartNewLine);
        formatterStates.put(new Pair<>(stateNeedSpace, "leftBrace"), stateStartNewLine);
        formatterStates.put(new Pair<>(stateNeedSpace, "for"), stateFor);

        /*START NEW LINE STATE*/
        formatterStates.put(new Pair<>(stateStartNewLine, null), stateStartNewLine);
        formatterStates.put(new Pair<>(stateStartNewLine, "char"), stateDefault);
        formatterStates.put(new Pair<>(stateStartNewLine, "space"), stateStartNewLine);
        formatterStates.put(new Pair<>(stateStartNewLine, "singleComment"), stateStartNewLine);
        formatterStates.put(new Pair<>(stateStartNewLine, "multiComment"), stateStartNewLine);
        formatterStates.put(new Pair<>(stateStartNewLine, "newLine"), stateStartNewLine);
        formatterStates.put(new Pair<>(stateStartNewLine, "leftParentheses"), stateDefault);
        formatterStates.put(new Pair<>(stateStartNewLine, "rightParentheses"), stateDefault);
        formatterStates.put(new Pair<>(stateStartNewLine, "semiColon"), stateStartNewLine);
        formatterStates.put(new Pair<>(stateStartNewLine, "rightBrace"), stateStartNewLine);
        formatterStates.put(new Pair<>(stateStartNewLine, "leftBrace"), stateStartNewLine);
        formatterStates.put(new Pair<>(stateStartNewLine, "for"), stateFor);

        /*FOR STATE*/
        formatterStates.put(new Pair<>(stateFor, null), stateFor);
        formatterStates.put(new Pair<>(stateFor, "char"), stateDefault);
        formatterStates.put(new Pair<>(stateFor, "space"), stateFor);
        formatterStates.put(new Pair<>(stateFor, "singleComment"), stateFor);
        formatterStates.put(new Pair<>(stateFor, "multiComment"), stateFor);
        formatterStates.put(new Pair<>(stateFor, "newLine"), stateFor);
        formatterStates.put(new Pair<>(stateFor, "leftParentheses"), stateForStatement);
        formatterStates.put(new Pair<>(stateFor, "rightParentheses"), stateDefault);
        formatterStates.put(new Pair<>(stateFor, "semiColon"), stateStartNewLine);
        formatterStates.put(new Pair<>(stateFor, "rightBrace"), stateStartNewLine);
        formatterStates.put(new Pair<>(stateFor, "leftBrace"), stateStartNewLine);

        /*FOR STATEMENT STATE*/
        formatterStates.put(new Pair<>(stateForStatement, null), stateForStatement);
        formatterStates.put(new Pair<>(stateForStatement, "char"), stateForStatement);
        formatterStates.put(new Pair<>(stateForStatement, "space"), stateForStatement);
        formatterStates.put(new Pair<>(stateForStatement, "singleComment"), stateForStatement);
        formatterStates.put(new Pair<>(stateForStatement, "multiComment"), stateForStatement);
        formatterStates.put(new Pair<>(stateForStatement, "newLine"), stateForStatement);
        formatterStates.put(new Pair<>(stateForStatement, "leftParentheses"), stateForStatement);
        formatterStates.put(new Pair<>(stateForStatement, "rightParentheses"), stateDefault);
        formatterStates.put(new Pair<>(stateForStatement, "semiColon"), stateForStatement);
        formatterStates.put(new Pair<>(stateForStatement, "rightBrace"), stateStartNewLine);
        formatterStates.put(new Pair<>(stateForStatement, "leftBrace"), stateStartNewLine);

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
