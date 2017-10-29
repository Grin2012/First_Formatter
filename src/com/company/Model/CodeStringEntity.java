package com.company.Model;

public class CodeStringEntity extends CodeEntity {
    @Override
    public String print(int nestLevel) {
        String output = "\"";
        output += super.print(nestLevel);
        output += "\"";

        return output;
    }
}