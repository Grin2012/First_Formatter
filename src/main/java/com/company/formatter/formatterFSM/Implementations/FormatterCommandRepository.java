package com.company.formatter.formatterFSM.Implementations;

import com.company.Util.Pair;
import com.company.formatter.formatterFSM.IFormatterCommand;
import com.company.formatter.formatterFSM.IFormatterCommandRepository;
import com.company.formatter.formatterFSM.IFormatterState;
import com.company.lexer.IToken;
import java.util.HashMap;
import java.util.Map;
/**
 * Commands repository of Formatter FSM
 */
public class FormatterCommandRepository implements IFormatterCommandRepository {
    private final Map<Pair<IFormatterState, String>, IFormatterCommand> formatterCommands = new HashMap<>();
    /**
     * Map of FSM Formatter commands
     */
    public FormatterCommandRepository() {
        FormatterState stateDefault =  new FormatterState("default");
        FormatterState stateNeedSpace =  new FormatterState("needSpace");
        FormatterState stateStartNewLine =  new FormatterState("startNewLine");
        FormatterState stateFor =  new FormatterState("for");
        FormatterState stateForStatement =  new FormatterState("forStatement");

        /* STATE DEFAULT COMMANDS */
        formatterCommands.put(new Pair<>(stateDefault, "char"),
                (token, context) ->  context.writeLexeme(token.getLexeme()));
        formatterCommands.put(new Pair<>(stateDefault, "semiColon"),
                (token, context) ->  context.writeLexeme(token.getLexeme()));
        formatterCommands.put(new Pair<>(stateDefault, "rightBrace"),
                (token, context) ->  {
                    context.decreaseIndentLevel();
                    context.writeLexeme(token.getLexeme());
                });
        formatterCommands.put(new Pair<>(stateDefault, "leftBrace"),
                (token, context) ->  {
                    context.increaseIndentLevel();
                    context.writeLexeme(token.getLexeme());
                });
        formatterCommands.put(new Pair<>(stateDefault, "space"),
                (token, context) ->  context.writeSpace());
        formatterCommands.put(new Pair<>(stateDefault, "singleComment"),
                (token, context) ->  {
                    context.writeLexeme(token.getLexeme());
                    context.writeNewLine();
                });
        formatterCommands.put(new Pair<>(stateDefault, "multiComment"),
                (token, context) ->  context.writeLexeme(token.getLexeme()));
        formatterCommands.put(new Pair<>(stateDefault, "newLine"),
                (token, context) -> { });
        formatterCommands.put(new Pair<>(stateDefault, "stringLiteral"),
                (token, context) ->  context.writeLexeme(token.getLexeme()));
        formatterCommands.put(new Pair<>(stateDefault, "leftParentheses"),
                (token, context) ->  context.writeLexeme(token.getLexeme()));
        formatterCommands.put(new Pair<>(stateDefault, "rightParentheses"),
                (token, context) ->  context.writeLexeme(token.getLexeme()));
        formatterCommands.put(new Pair<>(stateDefault, "for"),
                (token, context) ->  context.writeLexeme(token.getLexeme()));

        /* NEED SPACE OR NOT*/
        formatterCommands.put(new Pair<>(stateNeedSpace, "char"),
                (token, context) ->  context.writeLexeme(token.getLexeme()));
        formatterCommands.put(new Pair<>(stateNeedSpace, "semiColon"),
                (token, context) ->  context.writeLexeme(token.getLexeme()));
        formatterCommands.put(new Pair<>(stateNeedSpace, "rightBrace"),
                (token, context) ->  {
                    context.decreaseIndentLevel();
                    context.writeLexeme(token.getLexeme());
                });
        formatterCommands.put(new Pair<>(stateNeedSpace, "leftBrace"),
                (token, context) ->  {
                    context.writeSpace();
                    context.increaseIndentLevel();
                    context.writeLexeme(token.getLexeme());
                });
        formatterCommands.put(new Pair<>(stateNeedSpace, "space"),
                (token, context) ->  context.writeSpace());
        formatterCommands.put(new Pair<>(stateNeedSpace, "singleComment"),
                (token, context) ->  context.writeLexeme(token.getLexeme()));
        formatterCommands.put(new Pair<>(stateNeedSpace, "multiComment"),
                (token, context) ->  context.writeLexeme(token.getLexeme()));
        formatterCommands.put(new Pair<>(stateNeedSpace, "newLine"),
                (token, context) -> { });
        formatterCommands.put(new Pair<>(stateNeedSpace, "stringLiteral"),
                (token, context) ->  {
                    context.writeSpace();
                    context.writeLexeme(token.getLexeme());
                });
        formatterCommands.put(new Pair<>(stateNeedSpace, "leftParentheses"),
                (token, context) ->  context.writeLexeme(token.getLexeme()));
        formatterCommands.put(new Pair<>(stateNeedSpace, "rightParentheses"),
                (token, context) ->  context.writeLexeme(token.getLexeme()));
        formatterCommands.put(new Pair<>(stateNeedSpace, "for"),
                (token, context) ->  context.writeLexeme(token.getLexeme()));

        /* STATE START NEW LINE COMMANDS */
        formatterCommands.put(new Pair<>(stateStartNewLine, "char"),
                    (token, context) ->  {
                        context.writeNewLine();
                        context.writeIndent();
                    context.writeLexeme(token.getLexeme());
                });
        formatterCommands.put(new Pair<>(stateStartNewLine, "semiColon"),
                (token, context) ->  {
                    context.writeNewLine();
                    context.writeIndent();
                });
        formatterCommands.put(new Pair<>(stateStartNewLine, "rightBrace"),
                (token, context) ->  {
                    context.writeNewLine();
                    context.decreaseIndentLevel();
                    context.writeIndent();
                    context.writeLexeme(token.getLexeme());
                });
        formatterCommands.put(new Pair<>(stateStartNewLine, "leftBrace"),
                (token, context) ->  {
                    context.writeNewLine();
                    context.writeIndent();
                    context.writeLexeme(token.getLexeme());
                    context.increaseIndentLevel();
                });
        formatterCommands.put(new Pair<>(stateStartNewLine, "space"),
                (token, context) -> { });
        formatterCommands.put(new Pair<>(stateStartNewLine, "singleComment"),
                (token, context) ->  {
                    context.writeNewLine();
                    context.writeIndent();
                    context.writeLexeme(token.getLexeme());
                });
        formatterCommands.put(new Pair<>(stateStartNewLine, "multiComment"),
                (token, context) ->  {
                    context.writeNewLine();
                    context.writeIndent();
                    context.writeLexeme(token.getLexeme());
                });
        formatterCommands.put(new Pair<>(stateStartNewLine, "newLine"),
                (token, context) -> { });
        formatterCommands.put(new Pair<>(stateStartNewLine, "stringLiteral"),
                (token, context) ->  context.writeLexeme(token.getLexeme()));
        formatterCommands.put(new Pair<>(stateStartNewLine, "leftParentheses"),
                (token, context) ->  {
                    context.writeNewLine();
                    context.writeIndent();
                    context.writeLexeme(token.getLexeme());
                });
        formatterCommands.put(new Pair<>(stateStartNewLine, "rightParentheses"),
                (token, context) ->  {
                    context.writeNewLine();
                    context.writeIndent();
                    context.writeLexeme(token.getLexeme());
                });
        formatterCommands.put(new Pair<>(stateStartNewLine, "for"),
                (token, context) ->  {
                    context.writeNewLine();
                    context.writeIndent();
                    context.writeLexeme(token.getLexeme());
                });

         // STATE FOR COMMANDS
        formatterCommands.put(new Pair<>(stateFor, "char"),
                (token, context) ->  context.writeLexeme(token.getLexeme()));
        formatterCommands.put(new Pair<>(stateFor, "semiColon"),
                (token, context) ->  context.writeLexeme(token.getLexeme()));
        formatterCommands.put(new Pair<>(stateFor, "rightBrace"),
                (token, context) ->  {
                    context.decreaseIndentLevel();
                    context.writeLexeme(token.getLexeme());
                });
        formatterCommands.put(new Pair<>(stateFor, "leftBrace"),
                (token, context) ->  {
                    context.increaseIndentLevel();
                    context.writeLexeme(token.getLexeme());
                });
        formatterCommands.put(new Pair<>(stateFor, "space"),
                (token, context) ->  context.writeSpace());
        formatterCommands.put(new Pair<>(stateFor, "singleComment"),
                (token, context) ->  {
                    context.writeLexeme(token.getLexeme());
                    context.writeNewLine();
                });
        formatterCommands.put(new Pair<>(stateFor, "multiComment"),
                (token, context) ->  context.writeLexeme(token.getLexeme()));
        formatterCommands.put(new Pair<>(stateFor, "newLine"),
                (token, context) -> { });
        formatterCommands.put(new Pair<>(stateFor, "stringLiteral"),
                (token, context) ->  context.writeLexeme(token.getLexeme()));
        formatterCommands.put(new Pair<>(stateFor, "leftParentheses"),
                (token, context) ->  context.writeLexeme(token.getLexeme()));
        formatterCommands.put(new Pair<>(stateFor, "rightParentheses"),
                (token, context) ->  context.writeLexeme(token.getLexeme()));
        formatterCommands.put(new Pair<>(stateFor, "for"),
                (token, context) ->  context.writeLexeme(token.getLexeme()));

        // STATE FOR STATEMENT COMMANDS
        formatterCommands.put(new Pair<>(stateForStatement, "char"),
                (token, context) ->  context.writeLexeme(token.getLexeme()));
        formatterCommands.put(new Pair<>(stateForStatement, "semiColon"),
                (token, context) ->  context.writeLexeme(token.getLexeme()));
        formatterCommands.put(new Pair<>(stateForStatement, "rightBrace"),
                (token, context) ->  {
                    context.decreaseIndentLevel();
                    context.writeLexeme(token.getLexeme());
                });
        formatterCommands.put(new Pair<>(stateForStatement, "leftBrace"),
                (token, context) ->  {
                    context.increaseIndentLevel();
                    context.writeLexeme(token.getLexeme());
                });
        formatterCommands.put(new Pair<>(stateForStatement, "space"),
                (token, context) ->  context.writeSpace());
        formatterCommands.put(new Pair<>(stateForStatement, "singleComment"),
                (token, context) ->  {
                    context.writeLexeme(token.getLexeme());
                    context.writeNewLine();
                });
        formatterCommands.put(new Pair<>(stateForStatement, "multiComment"),
                (token, context) ->  context.writeLexeme(token.getLexeme()));
        formatterCommands.put(new Pair<>(stateForStatement, "newLine"),
                (token, context) -> { });
        formatterCommands.put(new Pair<>(stateForStatement, "stringLiteral"),
                (token, context) ->  context.writeLexeme(token.getLexeme()));
        formatterCommands.put(new Pair<>(stateForStatement, "leftParentheses"),
                (token, context) ->  context.writeLexeme(token.getLexeme()));
        formatterCommands.put(new Pair<>(stateForStatement, "rightParentheses"),
                (token, context) ->  context.writeLexeme(token.getLexeme()));
        formatterCommands.put(new Pair<>(stateForStatement, "for"),
                (token, context) ->  context.writeLexeme(token.getLexeme()));

    }

    @Override
    public IFormatterCommand getCommand(final IFormatterState state, final IToken token) {
        IFormatterCommand formatterCommand = formatterCommands.get(new Pair<>(state, token.getName()));
        if (formatterCommand == null) {
            formatterCommand = formatterCommands.get(new Pair<>(state, (String) null));
        }
        return formatterCommand;
    }
}
