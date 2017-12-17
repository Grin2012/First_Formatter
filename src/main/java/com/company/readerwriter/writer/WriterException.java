package com.company.readerwriter.writer;

/**
 * Writer exception class implemented IWriter interface
 */
public class WriterException extends Exception {
    /**
     * @param innerException - throws innerException
     */
    public WriterException(final Exception innerException) {
        super(innerException);
    }

    /**
     *
     * @param message - exception with message
     */
    public WriterException(final String message) {
        super(message);
    }
    /**
     * @param message - exception with message
     * @param innerException - throws innerException
     */
    public WriterException(final String message, final Exception innerException) {
        super(message, innerException);
    }
}