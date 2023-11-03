package com.heroesvillanos.exception;

public class CompetidorNoEncontrado extends RuntimeException{
    public CompetidorNoEncontrado() {
    }

    public CompetidorNoEncontrado(String message) {
        super(message);
    }

    public CompetidorNoEncontrado(String message, Throwable cause) {
        super(message, cause);
    }

    public CompetidorNoEncontrado(Throwable cause) {
        super(cause);
    }
}
