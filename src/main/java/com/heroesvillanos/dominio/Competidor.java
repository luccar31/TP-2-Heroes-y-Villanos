package com.heroesvillanos.dominio;

public interface Competidor {
    boolean esGanador(Competidor competidor, Caracteristica caracteristica) throws IllegalMatchException;
    TipoCompetidor getTipo();
    public int getCaracteristica(Caracteristica caracteristica);
}
