package com.heroesvillanos.dominio;

import com.heroesvillanos.exception.TipoCompetidorNoSoportado;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Liga implements Competidor {

    private final TipoCompetidor tipo;
    private final String nombre;

    public String getNombre() {
        return nombre;
    }

    @Override
    public String getNombreCompetidor() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public Set<Competidor> getCompetidores() {
        return competidores;
    }

    private final int id;
    private final Set<Competidor> competidores;

    public Liga(TipoCompetidor tipo, String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
        this.competidores = new HashSet<Competidor>();
        this.tipo = tipo;
    }

    public Liga(TipoCompetidor tipo, String nombre, int id, Competidor... competidores) {
        for (Competidor competidor : competidores) {
            if (competidor.getTipo() != tipo) {
                throw new TipoCompetidorNoSoportado("La liga soporta el tipo: " + tipo);
            }
        }
        this.nombre = nombre;
        this.id = id;
        this.competidores = new HashSet<Competidor>(Arrays.asList(competidores));
        this.tipo = tipo;
    }

    public boolean agregarCompetidor(Competidor competidor) {
        if (competidor.getTipo() != null) {
            throw new TipoCompetidorNoSoportado("La liga soporta el tipo: " + this.tipo);
        }
        return this.competidores.add(competidor);
    }

    public boolean esGanador(Competidor competidor) {
        return false;
    }

    public TipoCompetidor getTipo() {
        return this.tipo;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.nombre);
        int i = 0;
        for (Competidor competidor : competidores) {
            if (i < competidores.size()) {
                builder.append(", ");
            }
            builder.append(competidor.getNombreCompetidor());
            i++;
        }

        return builder.toString();
    }
}
