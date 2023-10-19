package com.heroesvillanos.exception;

public class TipoCompetidorNoSoportado extends IllegalArgumentException{
    public TipoCompetidorNoSoportado() {
    }

    public TipoCompetidorNoSoportado(String s) {
        super(s);
    }

    public TipoCompetidorNoSoportado(String message, Throwable cause) {
        super(message, cause);
    }

    public TipoCompetidorNoSoportado(Throwable cause) {
        super(cause);
    }
}
