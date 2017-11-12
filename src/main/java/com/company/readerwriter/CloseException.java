package com.company.readerwriter;

/**
 *CloseException for IClose interface
 */
public class CloseException extends Exception {
    /**
     * CloseException
     * @param cause - cause CloseException
     */
    public CloseException(final Throwable cause) {
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
    public CloseException(final String message, final Throwable cause) {
        super(message, cause);

    }


}

