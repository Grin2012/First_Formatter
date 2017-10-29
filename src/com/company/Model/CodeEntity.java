package com.company.Model;
import java.util.ArrayList;

public class CodeEntity {
    private String charValue;
    private ArrayList<CodeEntity> nestedEntities;

    public CodeEntity() {
        this.charValue = "";
        this.nestedEntities = new ArrayList<CodeEntity>();
    }

    protected CodeEntity(char charValue) {
        this.charValue = String.valueOf(charValue);
        this.nestedEntities = new ArrayList<CodeEntity>();
    }

    public void nest(CodeEntity nestedEntity) {
        this.nestedEntities.add(nestedEntity);
    }

    public String print() {
        return print(0);
    }

    protected String print(int nestLevel) {
        String output = String.valueOf(this.charValue);

        CodeEntity prev = null;
        for(CodeEntity nestedEntity : nestedEntities) {
            output = output + newLine(prev);
            output = output + tab(nestLevel, prev, nestedEntity);
            output = output + space(prev, nestedEntity);
            output = output + nestedEntity.print(nestLevel + 1);

            prev = nestedEntity;
        }

        //System.out.println(output);

        return output;
    }

    protected String tab(int nestLevel) {
        return new String(new char[4 * nestLevel]).replace("\0", " ");
    }

    private String tab(int nestLevel, CodeEntity prev, CodeEntity current) {
        if(prev == null && current instanceof CodeWordEntity) {
            return tab(nestLevel);
        }

        if(prev instanceof CodeScopeEntity) {
            return tab(nestLevel);
        }

        if(prev instanceof CodeLineEndEntity) {
            return tab(nestLevel);
        }

        return "";
    }

    private String space(CodeEntity prev, CodeEntity current) {
        if(prev instanceof CodeWordEntity
                && current instanceof CodeWordEntity) {
            return " ";
        }

        if(prev instanceof CodeWordEntity
                && current instanceof CodeScopeEntity) {
            return " ";
        }

        if(prev instanceof CodeWordEntity
                && current instanceof CodeStringEntity) {
            return " ";
        }

        return "";
    }

    private String newLine(CodeEntity prev) {
        if(prev instanceof CodeLineEndEntity) {
            return "\n";
        }

        if(prev instanceof CodeScopeEntity) {
            return "\n";
        }

        return "";
    }
}