package com.company.readerwriter.reader;

import java.io.IOException;

/**
 * Reader exception class implemented IReader interface
 */

public class ReaderException extends Exception {
    /**
     * @param innerException - throws innerException
     */
    public ReaderException(final IOException innerException) {
        super(innerException);
    }

    /**
     *
     * @param message - exception with message
     */
    public ReaderException(final String message) {
        super(message);
    }

    /**
     * @param message - exception with message
     * @param innerException - throws innerException
     */
    public ReaderException(final String message, final Exception innerException) {
        super(message, innerException);
    }
}


