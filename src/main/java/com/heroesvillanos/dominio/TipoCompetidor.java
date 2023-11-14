package com.heroesvillanos.dominio;

public enum TipoCompetidor {

    HEROE("Heroe"),
    VILLANO("Villano");
    private final String nombreEnArchivo;

    TipoCompetidor(String nombreEnArchivo) {
        this.nombreEnArchivo = nombreEnArchivo;
    }

    public static TipoCompetidor obtenerPor(String s) {
        if (s.equals(HEROE.nombreEnArchivo)) {
            return TipoCompetidor.HEROE;
        }
        if (s.equals(VILLANO.nombreEnArchivo)) {
            return TipoCompetidor.VILLANO;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String toString() {
        return this.nombreEnArchivo;
    }
}
