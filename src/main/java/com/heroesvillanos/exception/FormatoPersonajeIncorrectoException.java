package com.heroesvillanos.exception;

public class FormatoPersonajeIncorrectoException extends RuntimeException{
    public FormatoPersonajeIncorrectoException() {
    }

    public FormatoPersonajeIncorrectoException(String message) {
        super(message);
    }

    public FormatoPersonajeIncorrectoException(String message, Throwable cause) {
        super(message, cause);
    }

    public FormatoPersonajeIncorrectoException(Throwable cause) {
        super(cause);
    }
}
