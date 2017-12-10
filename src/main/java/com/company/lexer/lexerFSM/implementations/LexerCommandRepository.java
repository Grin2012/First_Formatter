package com.company.lexer.lexerFSM.implementations;

import com.company.Pair;

import com.company.lexer.lexerFSM.ILexerCommand;
import com.company.lexer.lexerFSM.ILexerCommandRepository;
import com.company.lexer.lexerFSM.ILexerState;
import java.util.HashMap;
import java.util.Map;

/**
 * Commands repository of Lexer FSM
 */
public class LexerCommandRepository implements ILexerCommandRepository {

    private StringBuilder lexeme = new StringBuilder();

    private final Map<Pair<ILexerState, Character>, ILexerCommand> lexerCommands = new HashMap<>();

    /**
     * Map of FSM Lexer commands
     */

    LexerCommandRepository() {
        LexerState stateDefault = new LexerState("default");
        LexerState stateSpacing = new LexerState("spacing");
        LexerState stateStringLiteral = new LexerState("stringLiteral");
        LexerState stateMaybeComment = new LexerState("maybeComment");
        LexerState stateSingleComment = new LexerState("singleComment");
        LexerState stateMultiComment = new LexerState("multiComment");
        LexerState stateMaybeEndMultiComment = new LexerState("maybeEndMultiComment");

        /* STATE DEFAULT COMMANDS */
        lexerCommands.put(new Pair<>(stateDefault, null),
                (c, context) -> { context.setTokenName("char"); context.appendLexeme(c); });
        lexerCommands.put(new Pair<>(stateDefault, ';'),
                (c, context) -> { context.setTokenName("semiColon"); context.appendLexeme(c); });
        lexerCommands.put(new Pair<>(stateDefault, ' '),
                (c, context) -> { context.setTokenName("space"); context.appendLexeme(c); });
        lexerCommands.put(new Pair<>(stateDefault, '}'),
                (c, context) -> { context.setTokenName("rightBrace"); context.appendLexeme(c); });
        lexerCommands.put(new Pair<>(stateDefault, '{'),
                (c, context) -> { context.setTokenName("leftBrace"); context.appendLexeme(c); });
        lexerCommands.put(new Pair<>(stateDefault, '\n'),
                (c, context) -> { context.setTokenName("newLine"); context.appendLexeme(c); });
        lexerCommands.put(new Pair<>(stateDefault, '\r'),
                (c, context) -> { });
        lexerCommands.put(new Pair<>(stateDefault, '\t'),
                (c, context) -> { });
        lexerCommands.put(new Pair<>(stateDefault, '"'),
                (c, context) -> { context.setTokenName("stringLiteral"); context.appendLexeme(c); });
        lexerCommands.put(new Pair<>(stateDefault, '/'),
                (c, context) -> { context.setTokenName("char"); context.appendLexeme(c); });

         /* STATE SPACING COMMANDS */
        lexerCommands.put(new Pair<>(stateSpacing, ' '),
                (c, context) -> { context.setTokenName("space"); context.appendLexeme(c); });
        lexerCommands.put(new Pair<>(stateSpacing, null),
                (c, context) -> { context.appendPostpone(c); });

        /* STATE STRING COMMANDS */
        lexerCommands.put(new Pair<>(stateStringLiteral, null),
                (c, context) -> context.appendLexeme(c));

        /* STATE MAYBECOMMENT COMMANDS */
        lexerCommands.put(new Pair<>(stateMaybeComment, null),
                (c, context) -> { context.appendPostpone(c); });
        lexerCommands.put(new Pair<>(stateMaybeComment, '/'),
                (c, context) -> { context.setTokenName("singleComment"); context.appendLexeme(c); });
        lexerCommands.put(new Pair<>(stateMaybeComment, '*'),
                (c, context) -> { context.setTokenName("multiComment"); context.appendLexeme(c); });

        /* STATE SINGLECOMMENT COMMANDS */
        lexerCommands.put(new Pair<>(stateSingleComment, null),
                (c, context) -> { context.appendLexeme(c); });

         /* STATE MULTICOMMENT COMMANDS */
        lexerCommands.put(new Pair<>(stateMultiComment, null),
                (c, context) -> { context.appendLexeme(c); });
        lexerCommands.put(new Pair<>(stateMaybeEndMultiComment, null),
                (c, context) -> { context.appendLexeme(c); });

    }

    @Override
    public ILexerCommand getCommand(final ILexerState state, final Character in) {
        ILexerCommand lexerCommand = lexerCommands.get(new Pair<>(state, in));
        if (lexerCommand == null) {
            lexerCommand = lexerCommands.get(new Pair<>(state, (Character) null));
        }
        return lexerCommand;

    }
}
