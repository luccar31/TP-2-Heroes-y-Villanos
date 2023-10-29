package com.heroesvillanos.dominio;

import com.heroesvillanos.exception.TipoCompetidorNoSoportado;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Liga implements Competidor {

    private final TipoCompetidor tipo;
    private final String nombre;
    private final int id;
    public Set<Competidor> competidores;

    public Liga(TipoCompetidor tipo, String nombre, int id){
        this.nombre = nombre;
        this.id = id;
    	this.competidores = new HashSet<Competidor>();
        this.tipo = tipo;
    }

    public Liga(TipoCompetidor tipo, String nombre, int id,Competidor... competidores){
        for(Competidor competidor : competidores){
            if(competidor.getTipo() != tipo){
                throw new TipoCompetidorNoSoportado("La liga soporta el tipo: " + tipo);
            }
        }
        this.nombre = nombre;
        this.id = id;
        this.competidores = new HashSet<Competidor>(Arrays.asList(competidores));
        this.tipo = tipo;
    }

    public boolean agregarCompetidor(Competidor competidor){
        if(competidor.getTipo() != null){
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
}
