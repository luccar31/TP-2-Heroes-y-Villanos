package com.heroesvillanos.exception;

public class LigasYaCargadasException extends RuntimeException {
    public LigasYaCargadasException() {
    }

    public LigasYaCargadasException(String message) {
        super(message);
    }

    public LigasYaCargadasException(String message, Throwable cause) {
        super(message, cause);
    }

    public LigasYaCargadasException(Throwable cause) {
        super(cause);
    }
}
