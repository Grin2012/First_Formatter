package com.company.lexer.lexerFSM.implementations;

import com.company.Pair;
import com.company.lexer.lexerFSM.ILexerState;
import com.company.lexer.lexerFSM.ILexerStateTransitions;
import java.util.HashMap;
import java.util.Map;

/**
 * Lexer state transitions implements ILexerStateTransitions
 */

public class LexerStateTransitions implements ILexerStateTransitions {

    private final Map<Pair<ILexerState, Character>, ILexerState> lexerSates = new HashMap<>();

    /**
     * Map of Lexer state transitions
     */

    public LexerStateTransitions() {
        LexerState stateDefault = new LexerState("default");
        LexerState stateSpacing = new LexerState("spacing");
        LexerState stateStringLiteral = new LexerState("stringLiteral");
        LexerState stateMaybeComment = new LexerState("maybeComment");
        LexerState stateSingleComment = new LexerState("singleComment");
        LexerState stateMultiComment = new LexerState("multiComment");
        LexerState stateMaybeEndMultiComment = new LexerState("maybeEndMultiComment");

         /*FOR DEFAULT*/
        lexerSates.put(new Pair<>(stateDefault, ' '), stateSpacing);
        lexerSates.put(new Pair<>(stateDefault, '"'), stateStringLiteral);
        lexerSates.put(new Pair<>(stateDefault, '/'), stateMaybeComment);

        /*FOR SPACING*/
        lexerSates.put(new Pair<>(stateSpacing, ' '), stateSpacing);
        lexerSates.put(new Pair<>(stateSpacing, null), null);

        /*FOR STRING_LITERAL*/
        lexerSates.put(new Pair<>(stateStringLiteral, null), stateStringLiteral);
        lexerSates.put(new Pair<>(stateStringLiteral, '"'), null);

        /*FOR MAY_BE_COMMENT*/
        lexerSates.put(new Pair<>(stateMaybeComment, null), null);
        lexerSates.put(new Pair<>(stateMaybeComment, '/'), stateSingleComment);
        lexerSates.put(new Pair<>(stateMaybeComment, '*'), stateMultiComment);

        /*FOR SINGLE_COMMENT*/
        lexerSates.put(new Pair<>(stateSingleComment, null), stateSingleComment);
        lexerSates.put(new Pair<>(stateSingleComment, '\n'), null);

        /*FOR MULTI_COMMENT*/
        lexerSates.put(new Pair<>(stateMultiComment, null), stateMultiComment);
        lexerSates.put(new Pair<>(stateMultiComment, '*'), stateMaybeEndMultiComment);

        /*FOR MAY_BE_END_MULTICOMMENT*/
        lexerSates.put(new Pair<>(stateMaybeEndMultiComment, null), stateMultiComment);
        lexerSates.put(new Pair<>(stateMaybeEndMultiComment, '/'), null);

    }
    @Override
    public ILexerState nextState(final ILexerState state, final Character in) {
        ILexerState nextState = lexerSates.get(new Pair<>(state, in));
        if (nextState == null) {
            nextState = lexerSates.get(new Pair<>(state, (Character) null));
        }
        return nextState;
    }
}