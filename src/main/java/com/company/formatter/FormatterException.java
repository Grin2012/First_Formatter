package com.company.formatter;
/**
 *  Formatter Exceptions class
 */
public class FormatterException extends Exception {
         /**
         * Constructor
         * @param message - Exception method
         * @param cause - Exception cause
         *
         */
    public FormatterException(final String message, final Exception cause) {
            super(message, cause);
        }
}