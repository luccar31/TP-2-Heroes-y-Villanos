package com.heroesvillanos.dominio;

import java.util.Map;

public class Villano extends Personaje<Villano> {
    public Villano(String tipo, String nombreReal, String alias, Map<Caracteristica, Integer> caracteristicas) {
        super(tipo, nombreReal, alias, caracteristicas);
    }

}
