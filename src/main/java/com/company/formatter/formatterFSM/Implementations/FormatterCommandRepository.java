package com.company.formatter.formatterFSM.Implementations;

import com.company.Pair;
import com.company.formatter.FormatterException;
import com.company.formatter.formatterFSM.IFormatterCommand;
import com.company.formatter.formatterFSM.IFormatterCommandRepository;
import com.company.formatter.formatterFSM.IFormatterContext;
import com.company.formatter.formatterFSM.IFormatterState;
import com.company.lexer.IToken;
import java.util.HashMap;
import java.util.Map;

public class FormatterCommandRepository implements IFormatterCommandRepository {
    private final Map<Pair<IFormatterState, String>, IFormatterCommand> formatterCommands = new HashMap<>();

    public FormatterCommandRepository() {
        /* STATE DEFAULT COMMANDS */
        formatterCommands.put(new Pair<>(new FormatterState("default"), "char"),
                (token, ctx) ->  ctx.writeLexeme(token.getLexeme()));
        formatterCommands.put(new Pair<>(new FormatterState("default"), "semiColon"),
                (token, ctx) -> {
            ctx.writeLexeme(token.getLexeme());
            ctx.writeNewLine();
        });

        // STATE STARTNEWLINE COMMANDS
        formatterCommands.put(new Pair<>(new FormatterState("startNewLine"), "newLine"),
                (token, context) -> { });
        formatterCommands.put(new Pair<>(new FormatterState("startNewLine"), "space"),
                (token, context) -> { });
        formatterCommands.put(new Pair<>(new FormatterState("startNewLine"), "char"),
                (token, context) -> context.writeLexeme(token.getLexeme()));

         // STATE SPACING COMMANDS
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
