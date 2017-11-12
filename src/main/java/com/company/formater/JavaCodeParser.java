package com.company.formater;

import com.company.model.*;
import com.company.readerwriter.reader.ReaderException;
import com.company.readerwriter.reader.IReader;

import java.io.IOException;

/**
 * parseCode source code
 */
public class JavaCodeParser {
    /**
     *
     * @param reader - reader result = char
     * @return - return conception
     * @throws IOException - when something wrong
     * @throws ReaderException - when something wrong
     */
    public CodeEntity parseCode(final IReader reader) throws IOException, ReaderException {
        CodeEntity root = new CodeEntity();
        parseCode(root, reader);
        return root;
    }


    private void parseCode(final CodeEntity parentEntity, final IReader reader) throws IOException, ReaderException {
        CodeEntity currentEntity = null;
        //  int prevCharCode = -1;
        while (reader.hasChar()) {
            char c = reader.readChar();

            switch (c) {
                case '}':
                    if (currentEntity != null) {
                        parentEntity.nest(currentEntity);
                    }
                    return;

                case ' ':
                case '\t':
                case '\n':
                case '\r':
                    if (currentEntity == null) {
                        break;
                    }

                    if (currentEntity instanceof CodeStringEntity) {
                        currentEntity.nest(new CodeCharEntity(c));
                        break;
                    }

                    parentEntity.nest(currentEntity);
                    currentEntity = null;

                    break;

                case '{':
                    if (currentEntity != null) {
                        parentEntity.nest(currentEntity);
                    }

                    currentEntity = new CodeScopeEntity();
                    parentEntity.nest(currentEntity);
                    parseCode(currentEntity, reader);
                    currentEntity = null;
                    break;

                case ';':
                    if (currentEntity != null) {
                        parentEntity.nest(currentEntity);
                    }
                    parentEntity.nest(new CodeLineEndEntity());
                    currentEntity = null;
                    break;

                case '"':

                    if (currentEntity instanceof CodeStringEntity) {
                        currentEntity = null;
                        break;
                    }

                    currentEntity = new CodeStringEntity();
                    parentEntity.nest(currentEntity);
                    currentEntity = new CodeStringEntity();
                    parentEntity.nest(currentEntity);
                    break;

                default:
                    if (currentEntity == null) {
                        currentEntity = new CodeWordEntity();
                    }
                    currentEntity.nest(new CodeCharEntity(c));
                    break;
            }

         //   prevCharCode = charCode;
        }
    }

}

