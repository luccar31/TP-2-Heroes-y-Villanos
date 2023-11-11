package com.heroesvillanos.dominio;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.heroesvillanos.comparators.CombateComparator;

public class Personaje implements Competidor {
    private final String nombreReal;
    private final String alias;
    private final TipoCompetidor tipo;
    private final Map<Caracteristica, Integer> caracteristicas;

    public Personaje(String nombreReal, String alias, TipoCompetidor tipo,
                     int velocidad, int fuerza, int resistencia, int destreza){
        Map<Caracteristica, Integer> caracteristicas = new HashMap<Caracteristica, Integer>();
        caracteristicas.put(Caracteristica.VELOCIDAD, velocidad);
        caracteristicas.put(Caracteristica.FUERZA, fuerza);
        caracteristicas.put(Caracteristica.RESISTENCIA, resistencia);
        caracteristicas.put(Caracteristica.DESTREZA, destreza);
        this.nombreReal = nombreReal;
        this.alias = alias;
        this.tipo = tipo;
        this.caracteristicas = Collections.unmodifiableMap(caracteristicas);
    }

    public Personaje(String nombreReal, String alias, TipoCompetidor tipo, Map<Caracteristica, Integer> caracteristicas) {
        this.nombreReal = nombreReal;
        this.alias = alias;
        this.tipo = tipo;
        this.caracteristicas = Collections.unmodifiableMap(caracteristicas);
    }

    public String getNombreReal() {
        return nombreReal;
    }

    public String getAlias() {
        return alias;
    }

    public boolean esGanador(Competidor competidor, Caracteristica caracteristicas) throws IllegalMatchException{
    	if(this.tipo.equals(competidor.getTipo())) {
    		throw new IllegalMatchException("No pueden competir personajes del mismo tipo.");
    	} else {
    		CombateComparator cc = new CombateComparator();
        	cc.Comparator(caracteristicas);
    		return cc.compare(this, competidor) > 0 ? true : false;
    	}
    }

    public TipoCompetidor getTipo() {
        return this.tipo;
    }

    @Override
    public String toString() {
    	return "Nombre del competidor: " + this.alias + 
    			", Nombre real del competidor: " + this.nombreReal +
    			", Caracteristicas: " + this.caracteristicas;
    }

    public int getCaracteristica(Caracteristica caracteristica) {
        Integer valor = caracteristicas.get(caracteristica);
        if (valor == null){
            return 0;
        }
        return valor;
    }
}
