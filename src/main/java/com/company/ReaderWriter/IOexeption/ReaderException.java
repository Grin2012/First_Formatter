package com.company.ReaderWriter.IOexeption;

import java.io.IOException;

public class ReaderException extends Throwable {

    public ReaderException(IOException innerException) {
        super(innerException);
    }

    public ReaderException(String message) {
        super(message);
    }
    public ReaderException(String message, Exception innerException) {
        super(message, innerException);
    }
}


