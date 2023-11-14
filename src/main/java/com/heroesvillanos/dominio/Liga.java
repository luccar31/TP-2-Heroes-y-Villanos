package com.heroesvillanos.dominio;

import com.heroesvillanos.comparators.CombateComparator;
import com.heroesvillanos.exception.TipoCompetidorNoSoportado;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Liga implements Competidor {

    private final TipoCompetidor tipo;
    private final String nombre;
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
        // Cambie null por tipo
        if (competidor.getTipo() != tipo) {
            throw new TipoCompetidorNoSoportado("La liga soporta el tipo: " + this.tipo);
        }
        return this.competidores.add(competidor);
    }

    public boolean esGanador(Competidor competidor, Caracteristica caracteristica) {
        if (this.tipo.equals(competidor.getTipo())) {
            throw new TipoCompetidorNoSoportado("No pueden competir personajes del mismo tipo.");
        } else {
            CombateComparator cc = new CombateComparator(caracteristica);
            return cc.compare(this, competidor) > 0;
        }
    }

    public int getCaracteristica(Caracteristica caracteristica) {
        int suma = 0;
        for (Competidor competidor : this.competidores) {
            suma += competidor.getCaracteristica(caracteristica);
        }
        return suma / competidores.size();
    }

    @Override
    public String toString() {
        String builder = this.nombre +
                ", " +
                getNombreCompetidores();
        return builder;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    private StringBuilder getNombreCompetidores() {
        StringBuilder builder = new StringBuilder();
        int i = 0;
        for (Competidor competidor : competidores) {
            builder.append(competidor.getNombreCompetidor());
            if (i + 1 < competidores.size()) {
                builder.append(", ");
            }
            i++;
        }
        return builder;
    }

    @Override
    public String getNombreCompetidor() {
        return getNombreCompetidores().toString();
    }

    public int getId() {
        return id;
    }

    public Set<Competidor> getCompetidores() {
        return competidores;
    }

    public TipoCompetidor getTipo() {
        return this.tipo;
    }
}
