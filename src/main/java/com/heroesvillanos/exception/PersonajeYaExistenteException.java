package com.heroesvillanos.exception;

public class PersonajeYaExistenteException extends RuntimeException{
    public PersonajeYaExistenteException() {
    }

    public PersonajeYaExistenteException(String message) {
        super(message);
    }

    public PersonajeYaExistenteException(String message, Throwable cause) {
        super(message, cause);
    }

    public PersonajeYaExistenteException(Throwable cause) {
        super(cause);
    }
}
