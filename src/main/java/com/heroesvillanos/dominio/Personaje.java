package com.heroesvillanos.dominio;
import java.util.Collections;
import java.util.Map;

public class Personaje implements Competidor {
    private final String nombreReal;
    private final String alias;
    private final TipoCompetidor tipo;
    private final Map<Caracteristica, Integer> caracteristicas;


    protected Personaje(String nombreReal, String alias, TipoCompetidor tipo, Map<Caracteristica, Integer> caracteristica) {
        this.nombreReal = nombreReal;
        this.alias = alias;
        this.tipo = tipo;
        this.caracteristicas = Collections.unmodifiableMap(caracteristica);
    }

    public String getNombreReal() {
        return nombreReal;
    }

    public String getAlias() {
        return alias;
    }

    public boolean esGanador(Competidor competidor){
        return false;
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
