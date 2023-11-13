package com.heroesvillanos.exception;

public class FormatoArchivoInvalidoException extends RuntimeException {
    public FormatoArchivoInvalidoException() {
    }

    public FormatoArchivoInvalidoException(String message) {
        super(message);
    }

    public FormatoArchivoInvalidoException(String message, Throwable cause) {
        super(message, cause);
    }

    public FormatoArchivoInvalidoException(Throwable cause) {
        super(cause);
    }
}
