package com.heroesvillanos.dominio;

public interface Competidor {
    boolean esGanador(Competidor competidor, Caracteristica caracteristica);
    TipoCompetidor getTipo();
    int getCaracteristica(Caracteristica caracteristica);
    String getNombreCompetidor();
}
