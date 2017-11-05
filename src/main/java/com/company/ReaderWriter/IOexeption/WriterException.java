package com.company.ReaderWriter.IOexeption;

import java.io.IOException;

public class WriterException extends Throwable {

    public WriterException(final IOException innerException) {
        super(innerException);
    }

    public WriterException(final String message) {
        super(message);
    }
    public WriterException(final String message, Exception innerException) {
        super(message, innerException);
    }
}