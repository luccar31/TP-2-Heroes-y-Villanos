package com.heroesvillanos.dominio;

public interface Competidor {
    boolean esGanador(Competidor competidor);
    TipoCompetidor getTipo();
}
