package com.heroesvillanos.dominio;

import com.heroesvillanos.comparators.CombateComparator;
import com.heroesvillanos.exception.TipoCompetidorNoSoportado;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Liga implements Competidor {

    private final TipoCompetidor tipo;
    public Set<Competidor> competidores;

    public Liga(TipoCompetidor tipo){
        this.competidores = new HashSet<Competidor>();
        this.tipo = tipo;
    }

    public Liga(TipoCompetidor tipo, Competidor... competidores){
        for(Competidor competidor : competidores){
            if(competidor.getTipo() != tipo){
                throw new TipoCompetidorNoSoportado("La liga soporta el tipo: " + tipo);
            }
        }
        this.competidores = new HashSet<Competidor>(Arrays.asList(competidores));
        this.tipo = tipo;
    }

    public boolean agregarCompetidor(Competidor competidor){
        if(competidor.getTipo() != null){
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

	public int getCaracteristica(Caracteristica caracteristicas) {
		// TODO Auto-generated method stub
		return 0;
	}
}
