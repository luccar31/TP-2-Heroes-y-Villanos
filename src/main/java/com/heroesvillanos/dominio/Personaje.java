package com.heroesvillanos.dominio;
import java.util.Map;

import java.lang.reflect.ParameterizedType;

public abstract class Personaje<T> implements Competidor<T>{
    private final String nombreReal;
    private final String alias;
    private final Map<Caracteristica, Integer> caracteristicas;

    protected Personaje(String nombreReal, String alias, Map<Caracteristica, Integer> caracteristica) {
        this.nombreReal = nombreReal;
        this.alias = alias;
        this.caracteristicas = caracteristica;
    }

    public String getNombreReal() {
        return nombreReal;
    }

    public String getAlias() {
        return alias;
    }

    public <X extends Competidor<X>> boolean esGanador(Competidor<X> competidor){
        return false;
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
