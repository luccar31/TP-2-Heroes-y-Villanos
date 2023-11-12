package com.heroesvillanos.dominio;

import com.heroesvillanos.exception.IllegalMatchException;

public interface Competidor {
    boolean esGanador(Competidor competidor, Caracteristica caracteristica);
    TipoCompetidor getTipo();
    int getCaracteristica(Caracteristica caracteristica);
    String getNombreCompetidor();
}
