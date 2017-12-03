package com.company.lexer.lexerFSM;

import com.company.Pair;
import com.company.finalStateMachine.IState;
import com.company.finalStateMachine.IStateTransitions;

import java.util.HashMap;
import java.util.Map;

public class LexerStateTransitions implements IStateTransitions<Character> {

    private static LexerState stateInitial = new LexerState("initial");

    private Map<Pair<IState, Character>, IState> transitions;

    LexerStateTransitions() {
        transitions = new HashMap<>();
        LexerState stateDefault = new LexerState("default");
        LexerState stateSpace = new LexerState("space");
        LexerState stateMaybeComment = new LexerState("maybeComment");
        LexerState stateSingleComment = new LexerState("singleComment");
        LexerState stateMultiComment = new LexerState("multiComment");
        LexerState stateMaybeEndMultiComment = new LexerState("maybeEndMultiComment");

        transitions.put(new Pair<>(stateInitial, (Character) null), stateDefault);

        transitions.put(new Pair<>(stateInitial, ';'), stateDefault);
        transitions.put(new Pair<>(stateInitial, '{'), stateDefault);
        transitions.put(new Pair<>(stateInitial, '}'), stateDefault);
        transitions.put(new Pair<>(stateInitial, '\n'), stateDefault);
        transitions.put(new Pair<>(stateInitial, '\t'), stateDefault);
        transitions.put(new Pair<>(stateInitial, ' '), stateSpace);
        transitions.put(new Pair<>(stateInitial, '/'), stateMaybeComment);

        transitions.put(new Pair<>(stateInitial, '\r'), stateInitial);
        transitions.put(new Pair<>(stateMaybeComment, '\r'), stateMaybeComment);

//t;
        //transitions.put(new Pair(stateInitial, (Character) null), stateFinish);
        //transitions.put(new Pair(state, (Character) null), stateFinish);

        transitions.put(new Pair<>(stateDefault, (Character) null), stateDefault);
        transitions.put(new Pair<>(stateDefault, ';'), stateDefault);
        transitions.put(new Pair<>(stateDefault, '{'), stateDefault);
        transitions.put(new Pair<>(stateDefault, '}'), stateDefault);
        transitions.put(new Pair<>(stateDefault, '\n'), stateDefault);
        transitions.put(new Pair<>(stateDefault, '\r'), stateDefault);
        transitions.put(new Pair<>(stateDefault, '\t'), stateDefault);
        transitions.put(new Pair<>(stateDefault, ' '), stateSpace);
        transitions.put(new Pair<>(stateDefault, '/'), stateMaybeComment);

        transitions.put(new Pair<>(stateSpace, (Character) null), stateDefault);
        transitions.put(new Pair<>(stateSpace, ' '), stateSpace);
        transitions.put(new Pair<>(stateSpace, '/'), stateMaybeComment);

        transitions.put(new Pair<>(stateMaybeComment, (Character) null), stateDefault);
        transitions.put(new Pair<>(stateMaybeComment, '/'), stateSingleComment);
        transitions.put(new Pair<>(stateMaybeComment, '*'), stateMultiComment);

        transitions.put(new Pair<>(stateSingleComment, (Character) null), stateSingleComment);
        transitions.put(new Pair<>(stateSingleComment, '\n'), stateDefault);

        transitions.put(new Pair<>(stateMultiComment, (Character) null), stateMultiComment);
        transitions.put(new Pair<>(stateSingleComment, '*'), stateMaybeEndMultiComment);
        transitions.put(new Pair<>(stateMaybeEndMultiComment, (Character) null), stateMultiComment);
        transitions.put(new Pair<>(stateMaybeEndMultiComment, '/'), stateDefault);

        transitions.put(new Pair<>(stateMaybeEndMultiComment, '/'), null);
    }
    @Override
    public IState nextState(final IState state, final Character in) {
        if (transitions.containsKey(new Pair<>(state, in))) {
            return transitions.get(new Pair<>(state, in));
        } else {
            return transitions.get(new Pair<>(state, (Character) null));
        }
    }
}