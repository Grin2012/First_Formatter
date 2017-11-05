package com.company.Model;

import com.company.ReaderWriter.IOexeption.WriterException;
import com.company.ReaderWriter.IWriter;

import java.util.ArrayList;

public class CodeEntity {
    private Character letter;
    private ArrayList<CodeEntity> nestedEntities;

    public CodeEntity() {
        this.nestedEntities = new ArrayList<CodeEntity>();
    }

    protected CodeEntity(char charValue) {
        this.letter = charValue;
        this.nestedEntities = new ArrayList<CodeEntity>();
    }

    public void nest(CodeEntity nestedEntity) {
        this.nestedEntities.add(nestedEntity);
    }

    public void write(IWriter writer) throws WriterException {
        write(writer, 0);
    }

    protected void write(IWriter writer, int nestLevel) throws WriterException {

        if (this.letter != null) {
            writer.writeChar(this.letter);
        }
        CodeEntity prev = null;
        for (CodeEntity nestedEntity : nestedEntities) {
            writeNewLine(writer, prev);
            writeTab(writer, nestLevel, prev, nestedEntity);
            writeSpace(writer, prev, nestedEntity);
            nestedEntity.write(writer, nestLevel + 1);
            prev = nestedEntity;
        }
    }

    protected void writeTab(IWriter writer, int nestLevel) throws WriterException {
        int spacesInTab = 4;
        for (int i = 0; i < spacesInTab * nestLevel; i++) {
            writer.writeChar(' ');
        }
    }

    private void writeTab(IWriter writer, int nestLevel, CodeEntity prev, CodeEntity current) throws WriterException {
        if (prev == null && current instanceof CodeWordEntity) {
            writeTab(writer, nestLevel);
            return;
        }

        if (prev instanceof CodeScopeEntity) {
            writeTab(writer, nestLevel);
            return;
        }

        if (prev instanceof CodeLineEndEntity) {
            writeTab(writer, nestLevel);
            return;
        }
    }

    private void writeSpace(IWriter writer, CodeEntity prev, CodeEntity current) throws WriterException {
        if (prev instanceof CodeWordEntity
                && current instanceof CodeWordEntity) {
            writer.writeChar(' ');
        }
        if (prev instanceof CodeWordEntity
                && current instanceof CodeScopeEntity) {
            writer.writeChar(' ');
        }
        if (prev instanceof CodeWordEntity
                && current instanceof CodeStringEntity) {
            writer.writeChar(' ');
        }

    }

    private void writeNewLine(IWriter writer, CodeEntity prev) throws WriterException {
        if (prev instanceof CodeLineEndEntity) {
            writer.writeChar('\n');
            return;
        }
        if (prev instanceof CodeScopeEntity) {
            writer.writeChar('\n');
            return;
        }

    }
}