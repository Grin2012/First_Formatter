package com.company.lexer;

/**
 * Reader exception class implemented IReader interface
 */

public class LexerException extends Exception {
    /**
     * @param innerException - throws innerException
     */
    public LexerException(final Exception innerException) {
        super(innerException);
    }

    /**
     *
     * @param message - exception with message
     */
    public LexerException(final String message) {
        super(message);
    }

    /**
     * @param message - exception with message
     * @param innerException - throws innerException
     */
    public LexerException(final String message, final Exception innerException) {
        super(message, innerException);
    }
}