package com.heroesvillanos.dominio;

import java.util.Arrays;
import java.util.List;

public class LigaDto {
    private final String nombreLiga;

    public String getNombre() {
        return nombreLiga;
    }

    public List<String> getNombreCompetidores() {
        return nombreCompetidores;
    }

    private final List<String> nombreCompetidores;

    public LigaDto(String nombreLiga, String... nombreCompetidores) {
        this.nombreLiga = nombreLiga;
        this.nombreCompetidores = Arrays.asList(nombreCompetidores);
    }
}
