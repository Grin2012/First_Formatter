package com.company;

import com.company.Model.*;
import java.io.IOException;
import java.io.StringReader;


public class JavaCodeParser
{
    public CodeEntity Parse(StringReader reader) throws IOException {
        CodeEntity root = new CodeEntity();
        Parse(root, reader);
        return root;
    }


    private void Parse(CodeEntity parentEntity, StringReader reader) throws IOException {
        CodeEntity currentEntity = null;

        int charCode = -1;
        int prevCharCode = -1;
        while ((charCode = reader.read()) != -1) {
            char c = (char) charCode;

            switch (c) {
                case '}':
                    if (currentEntity != null) {
                        parentEntity.nest(currentEntity);
                    }
                    return;

                case ' ':
                case '\t':
                case '\n':
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
                    if(currentEntity == null) {
                        currentEntity = new CodeWordEntity();
                    }
                    currentEntity.nest(new CodeCharEntity(c));
                    break;
            }

            prevCharCode = charCode;
        }
    }
}