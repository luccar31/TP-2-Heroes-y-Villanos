package com.heroesvillanos.dominio;

public enum TipoCompetidor {
    HEROE,
    VILLANO;

    public static TipoCompetidor obtenerPor(String s){
        if(s.equals("Héroe")){
            return TipoCompetidor.HEROE;
        }
        if(s.equals("Villano")){
            return TipoCompetidor.VILLANO;
        }
        throw new IllegalArgumentException();
    }
}
