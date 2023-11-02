package com.heroesvillanos.dominio;

import java.util.Arrays;
import java.util.List;

public class RegistroLiga {
    private final String nombreLiga;

    public String getNombre() {
        return nombreLiga;
    }

    public List<String> getNombreCompetidores() {
        return nombreCompetidores;
    }

    private final List<String> nombreCompetidores;

    public RegistroLiga(String nombreLiga, String... nombreCompetidores) {
        this.nombreLiga = nombreLiga;
        this.nombreCompetidores = Arrays.asList(nombreCompetidores);
    }
}
