package com.heroesvillanos.exception;

public class LecturaDeArchivoException extends RuntimeException{
    public LecturaDeArchivoException() {
    }

    public LecturaDeArchivoException(String message) {
        super(message);
    }

    public LecturaDeArchivoException(String message, Throwable cause) {
        super(message, cause);
    }

    public LecturaDeArchivoException(Throwable cause) {
        super(cause);
    }
}
