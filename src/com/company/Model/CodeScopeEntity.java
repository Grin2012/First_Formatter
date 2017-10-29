package com.company.Model;

public class CodeScopeEntity extends CodeEntity {
    @Override
    public String print(int nestLevel) {
        String output = "{\n";
        output += super.print(nestLevel);
        output += "\n";
        output += tab(nestLevel - 1);
        output += "}";

        return output;
    }
}