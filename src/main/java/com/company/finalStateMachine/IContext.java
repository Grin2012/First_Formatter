package com.company.finalStateMachine;

public interface IContext {

    void appendLexeme(char c);

    void setTokenName(String s);

    void appendPostpone(char c);
}
