package com.heroesvillanos.exception;

public class LigaYaExistenteException extends RuntimeException {
    public LigaYaExistenteException() {
    }

    public LigaYaExistenteException(String message) {
        super(message);
    }

    public LigaYaExistenteException(String message, Throwable cause) {
        super(message, cause);
    }

    public LigaYaExistenteException(Throwable cause) {
        super(cause);
    }
}
