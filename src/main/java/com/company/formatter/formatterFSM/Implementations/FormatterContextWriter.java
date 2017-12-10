package com.company.formatter.formatterFSM.Implementations;

import com.company.formatter.formatterFSM.IFormatterContextWriter;

public class FormatterContextWriter implements IFormatterContextWriter {
    private StringBuilder content = new StringBuilder();

    @Override
    public void write(String string) {
        content.append(string);
    }

    @Override
    public String toString() {
        return content.toString();
    }

}
