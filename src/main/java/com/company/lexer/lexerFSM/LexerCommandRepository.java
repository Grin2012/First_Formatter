package com.company.lexer.lexerFSM;
import com.company.Pair;
import com.company.finalStateMachine.ICommand;
import com.company.finalStateMachine.ICommandRepository;
import com.company.finalStateMachine.IState;

import java.util.HashMap;
import java.util.Map;

public class LexerCommandRepository implements ICommandRepository<Character> {

    private StringBuilder lexeme = new StringBuilder();

    private Map<Pair<IState, Character>, ICommand> LexerCommandMap;

    LexerCommandRepository() {
        LexerCommandMap = new HashMap<>();
        LexerState stateInitial = new LexerState("initial");
        LexerState stateDefault = new LexerState("default");
        LexerState stateSpace = new LexerState("space");
        LexerState stateMaybeComment = new LexerState("maybeComment");
        LexerState stateSingleComment = new LexerState("singleComment");
        LexerState stateMultiComment = new LexerState("multiComment");
        LexerState stateMaybeEndMultiComment = new LexerState("maybeEndMultiComment");

        LexerCommandMap.put(new Pair<>(stateInitial,(Character) null), new LexerCommand("char"));

        LexerCommandMap.put(new Pair<>(stateInitial,(Character) null), new LexerCommand("char"));

        LexerCommandMap.put(new Pair<>(stateInitial,'\r'), new IgnoreCommand());
    }



    @Override
    public ICommand getCommand(IState state, Character in) {
        if (LexerCommandMap.containsKey(new Pair<>(state, in))) {
            return LexerCommandMap.get(new Pair<>(state, in));
        } else {
            return LexerCommandMap.get(new Pair<>(state, (Character) null));
        }
    }
}
