package com.heroesvillanos.exception;

public class PersonajesNoCargadosException extends RuntimeException {
    public PersonajesNoCargadosException() {
    }

    public PersonajesNoCargadosException(String message) {
        super(message);
    }

    public PersonajesNoCargadosException(String message, Throwable cause) {
        super(message, cause);
    }

    public PersonajesNoCargadosException(Throwable cause) {
        super(cause);
    }
}
