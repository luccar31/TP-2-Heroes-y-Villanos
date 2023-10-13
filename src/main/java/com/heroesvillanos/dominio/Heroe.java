package com.heroesvillanos.dominio;

import java.util.Map;

public class Heroe extends Personaje<Heroe>{

    public Heroe(String nombreReal, String alias, Map<Caracteristica, Integer> caracteristicas) {
        super(nombreReal, alias, caracteristicas);
    }
}
