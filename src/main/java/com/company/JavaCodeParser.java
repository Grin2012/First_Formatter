package com.company;

import com.company.Model.*;
import com.company.ReaderWriter.IOexeption.ReaderException;
import com.company.ReaderWriter.IReader;

import java.io.IOException;

public class JavaCodeParser {
    public CodeEntity Parse(IReader reader) throws IOException, ReaderException {
        CodeEntity root = new CodeEntity();
        Parse(root, reader);
        return root;
    }

    private void Parse(CodeEntity parentEntity, IReader reader) throws IOException, ReaderException {
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
                    Parse(currentEntity, reader);
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