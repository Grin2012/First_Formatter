package com.company.model;

import com.company.readerwriter.writer.IWriter;
import com.company.readerwriter.writer.WriterException;
import java.util.ArrayList;

/**
 * Class codeEntity
 */

public class CodeEntity {
    private Character letter;
    protected ArrayList<CodeEntity> nestedEntities;

    /**
     * default constructor CodeEntity
     */
    public CodeEntity() {
        this.nestedEntities = new ArrayList<CodeEntity>();
    }

    /**
     * constructor CodeEntity
     * @param charValue - char
     */
    protected CodeEntity(final char charValue) {
        this.letter = charValue;
        this.nestedEntities = new ArrayList<CodeEntity>();
    }

    /**
     * Nest Entity
     * @param nestedEntity - entity
     */
    public void nest(final CodeEntity nestedEntity) {
        this.nestedEntities.add(nestedEntity);
    }

    /**
     * Method write - write char to writer
     * @param writer - source writer
     * @throws WriterException - writer exception
     */
    public void write(final IWriter writer) throws WriterException {
        write(writer, 0);
    }

    /**
     * Method write - write char to writer
     * @param writer - source writer
     * @param nestLevel - level of nest
     * @throws WriterException - writer exception
     */
    protected void write(final IWriter writer, final int nestLevel) throws WriterException {
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

    /**
     * Method writeTab - write tab before text
     * @param writer - source writer
     * @param nestLevel - level of nest
     * @throws WriterException - writer exception
     */
    protected void writeTab(final IWriter writer, final int nestLevel) throws WriterException {
        final int spacesInTab = 4;
        for (int i = 0; i < spacesInTab * nestLevel; i++) {
            writer.writeChar(' ');
        }
    }

    private void writeTab(final IWriter writer, final int nestLevel, final CodeEntity prev, final CodeEntity current) throws WriterException {
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

    private void writeSpace(final IWriter writer, final CodeEntity prev, final CodeEntity current) throws WriterException {
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

    private void writeNewLine(final IWriter writer, final CodeEntity prev) throws WriterException {
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