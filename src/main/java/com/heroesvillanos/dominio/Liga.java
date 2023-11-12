package com.heroesvillanos.dominio;

import com.heroesvillanos.comparators.CombateComparator;
import com.heroesvillanos.exception.IllegalMatchException;
import com.heroesvillanos.exception.TipoCompetidorNoSoportado;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
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
    	// Cambie null por tipo
        if (competidor.getTipo() != tipo) {
            throw new TipoCompetidorNoSoportado("La liga soporta el tipo: " + this.tipo);
        }
        return this.competidores.add(competidor);
    }

    public TipoCompetidor getTipo() {
        return this.tipo;
    }

	public boolean esGanador(Competidor competidor, Caracteristica caracteristica) throws IllegalMatchException{
    	if(this.tipo.equals(competidor.getTipo())) {
    		throw new IllegalMatchException("No pueden competir personajes del mismo tipo.");
    	} else {
    		CombateComparator cc = new CombateComparator();
        	cc.Comparator(caracteristica);
    		return cc.compare(this, competidor) > 0 ? true : false;
    	}
	}

    @Override
    public boolean esGanador(Competidor competidor) {
        return false;
    }

    public int getCaracteristica(Caracteristica caracteristicas) {
    	int valor = 0;
    	for (Competidor competidor : competidores) {
    		valor += competidor.getCaracteristica(caracteristicas);
    	}
		return valor / competidores.size();
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
