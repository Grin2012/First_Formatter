package com.company.lexer;

import java.io.IOException;

/**
 * Reader exception class implemented IReader interface
 */

public class LexerException extends Throwable {
    /**
     * @param innerException - throws innerException
     */
    public LexerException(final Throwable innerException) {
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
    public LexerException(final String message, final Throwable innerException) {
        super(message, innerException);
    }
}