package com.company.readerwriter;

/**
 *CloseException for IClose interface
 */
public class CloseException extends Exception {
    /**
     * CloseException
     * @param cause - cause CloseException
     */
    public CloseException(final Exception cause) {
        super(cause);
    }
    /**
     * CloseException
     * @param message - message CloseException
     */
    public CloseException(final String message) {
        super(message);
    }

    /**
     * CloseException
     * @param message - message CloseException
     * @param cause - cause CloseException
     */
    public CloseException(final String message, final Exception cause) {
        super(message, cause);

    }


}

