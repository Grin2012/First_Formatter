package com.company.lexer.lexerFSM.implementations;

import com.company.Util.Pair;

import com.company.lexer.lexerFSM.ILexerCommand;
import com.company.lexer.lexerFSM.ILexerCommandRepository;
import com.company.lexer.lexerFSM.ILexerState;
import java.util.HashMap;
import java.util.Map;

/**
 * Commands repository of Lexer FSM
 */
public class LexerCommandRepository implements ILexerCommandRepository {
    private final Map<Pair<ILexerState, Character>, ILexerCommand> lexerCommands = new HashMap<>();
    /**
     * Map of FSM Lexer commands
     */
    LexerCommandRepository() {
        LexerState stateDefault = new LexerState("default");
        LexerState stateSpacing = new LexerState("spacing");
        LexerState stateStringLiteral = new LexerState("stringLiteral");
        LexerState stateEscapeSymbol = new LexerState("escapeSymbol");
        LexerState stateMaybeComment = new LexerState("maybeComment");
        LexerState stateSingleComment = new LexerState("singleComment");
        LexerState stateMultiComment = new LexerState("multiComment");
        LexerState stateMaybeEndMultiComment = new LexerState("maybeEndMultiComment");
        LexerState stateMaybeFo = new LexerState("maybeFo");
        LexerState stateMaybeFor = new LexerState("maybeFor");
        LexerState stateFor = new LexerState("for");

        /* STATE DEFAULT COMMANDS */
        lexerCommands.put(new Pair<>(stateDefault, null),
                (c, context) -> {
            context.setTokenName("char"); context.appendLexeme(c); });
        lexerCommands.put(new Pair<>(stateDefault, ';'),
                (c, context) -> {
            context.setTokenName("semiColon"); context.appendLexeme(c); });
        lexerCommands.put(new Pair<>(stateDefault, ' '),
                (c, context) -> {
            context.setTokenName("space"); context.appendLexeme(c); });
        lexerCommands.put(new Pair<>(stateDefault, '}'),
                (c, context) -> {
            context.setTokenName("rightBrace"); context.appendLexeme(c); });
        lexerCommands.put(new Pair<>(stateDefault, '{'),
                (c, context) -> {
            context.setTokenName("leftBrace"); context.appendLexeme(c); });
        lexerCommands.put(new Pair<>(stateDefault, '('),
                (c, context) -> {
                    context.setTokenName("leftParentheses"); context.appendLexeme(c); });
        lexerCommands.put(new Pair<>(stateDefault, ')'),
                (c, context) -> {
                    context.setTokenName("rightParentheses"); context.appendLexeme(c); });
        lexerCommands.put(new Pair<>(stateDefault, '\n'),
                (c, context) -> {
            context.setTokenName("newLine"); context.appendLexeme(c); });
        lexerCommands.put(new Pair<>(stateDefault, '\r'),
                (c, context) -> { });
        lexerCommands.put(new Pair<>(stateDefault, '\t'),
                (c, context) -> { });
        lexerCommands.put(new Pair<>(stateDefault, '"'),
                (c, context) -> {
            context.setTokenName("stringLiteral"); context.appendLexeme(c); });
        lexerCommands.put(new Pair<>(stateDefault, '/'),
                (c, context) -> {
            context.setTokenName("char"); context.appendLexeme(c); });
        lexerCommands.put(new Pair<>(stateDefault, 'f'),
                (c, context) -> {
                    context.setTokenName("char");
                    context.appendLexeme(c);
                });

         /* STATE SPACING COMMANDS */
        lexerCommands.put(new Pair<>(stateSpacing, ' '),
                (c, context) -> {
            context.setTokenName("space"); context.appendLexeme(c); });
        lexerCommands.put(new Pair<>(stateSpacing, null),
                (c, context) ->  context.appendPostpone(c));

        /* STATE STRING COMMANDS */
        lexerCommands.put(new Pair<>(stateStringLiteral, null),
                (c, context) -> context.appendLexeme(c));

        /* STATE ESCAPE SYMBOL COMMANDS */
        lexerCommands.put(new Pair<>(stateEscapeSymbol, '"'),
                (c, context) -> context.appendLexeme(c));
        lexerCommands.put(new Pair<>(stateEscapeSymbol, null),
                (c, context) -> context.appendPostpone(c));

        /* STATE MAYBECOMMENT COMMANDS */
        lexerCommands.put(new Pair<>(stateMaybeComment, null),
                (c, context) -> context.appendPostpone(c));
        lexerCommands.put(new Pair<>(stateMaybeComment, '/'),
                (c, context) -> {
            context.setTokenName("singleComment"); context.appendLexeme(c); });
        lexerCommands.put(new Pair<>(stateMaybeComment, '*'),
                (c, context) -> {
            context.setTokenName("multiComment"); context.appendLexeme(c); });

        /* STATE SINGLECOMMENT COMMANDS */
        lexerCommands.put(new Pair<>(stateSingleComment, null),
                (c, context) -> context.appendLexeme(c));
        lexerCommands.put(new Pair<>(stateSingleComment, '\r'),
                (c, context) -> { });
        lexerCommands.put(new Pair<>(stateSingleComment, '\n'),
                (c, context) -> { });

         /* STATE MULTICOMMENT COMMANDS */
        lexerCommands.put(new Pair<>(stateMultiComment, null),
                (c, context) -> context.appendLexeme(c));
        lexerCommands.put(new Pair<>(stateMaybeEndMultiComment, null),
                (c, context) -> context.appendLexeme(c));

        /* STATE MAY_BE_FO COMMANDS */
        lexerCommands.put(new Pair<>(stateMaybeFo, 'o'),
                (c, context) -> { });
        lexerCommands.put(new Pair<>(stateMaybeFo, null),
                (c, context) ->  context.appendPostpone(c));

        /* STATE MAY_BE_FOR COMMANDS */
        lexerCommands.put(new Pair<>(stateMaybeFor, 'r'),
                (c, context) -> { });
        lexerCommands.put(new Pair<>(stateMaybeFor, null),
                (c, context) -> {
                    context.appendPostpone('o');
                    context.appendPostpone(c);
                });

        /* STATE FOR COMMANDS */
        lexerCommands.put(new Pair<>(stateFor, ' '),
                (c, context) -> {
                    context.appendLexeme('o'); context.appendLexeme('r');
                    context.setTokenName("for"); context.appendPostpone(c);
                });
        lexerCommands.put(new Pair<>(stateFor, '('),
                (c, context) -> {
                    context.appendLexeme('o'); context.appendLexeme('r');
                    context.setTokenName("for"); context.appendPostpone(c);
                });
        lexerCommands.put(new Pair<>(stateFor, null),
                (c, context) -> {
                    context.appendPostpone('o'); context.appendPostpone('r'); context.appendPostpone(c);
                });

    }

    @Override
    public ILexerCommand getCommand(final ILexerState state, final Character in) {
        if (lexerCommands.containsKey(new Pair<>(state, in))) {
            return lexerCommands.get(new Pair<>(state, in));
        } else {
            return lexerCommands.get(new Pair<>(state, (Character) null));
        }
    }
}