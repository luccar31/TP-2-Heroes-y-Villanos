package com.heroesvillanos.dominio;

import com.heroesvillanos.exception.IllegalMatchException;

public interface Competidor {
    boolean esGanador(Competidor competidor, Caracteristica caracteristica) throws IllegalMatchException;
    boolean esGanador(Competidor competidor);

    TipoCompetidor getTipo();
    public int getCaracteristica(Caracteristica caracteristica);

    String getNombreCompetidor();
}
