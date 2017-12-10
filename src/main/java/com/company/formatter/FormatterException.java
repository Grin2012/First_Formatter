package com.company.formatter;

import java.io.IOException;

public class FormatterException extends Throwable {
         /**
         * Cunstructor
         * @param message - Exception method
         * @param cause - Exception cause
         *
         */
    public FormatterException(final String message, final Throwable cause) {
            super(message, cause);
        }
}
