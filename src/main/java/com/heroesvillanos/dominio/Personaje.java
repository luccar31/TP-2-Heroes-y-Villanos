package com.heroesvillanos.dominio;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.heroesvillanos.comparators.CombateComparator;

public class Personaje implements Competidor {
    private final int id;
    private final String nombreReal;
    private final String alias;
    private final TipoCompetidor tipo;
    private final Map<Caracteristica, Integer> caracteristicas;

    public int getId() {
        return id;
    }

    public Personaje(int id, String nombreReal, String alias, TipoCompetidor tipo,
                     int velocidad, int fuerza, int resistencia, int destreza) {
        this.id = id;
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

    public Personaje(int id, String nombreReal, String alias, TipoCompetidor tipo, Map<Caracteristica, Integer> caracteristicas) {
        this.id = id;
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

    public boolean esGanador(Competidor competidor, Caracteristica caracteristicas) throws IllegalMatchException {
        if (this.tipo.equals(competidor.getTipo())) {
            throw new IllegalMatchException("No pueden competir personajes del mismo tipo.");
        } else {
            CombateComparator cc = new CombateComparator();
            cc.Comparator(caracteristicas);
            return cc.compare(this, competidor) > 0 ? true : false;
        }
    }

    public boolean esGanador(Competidor competidor) {
        return false;
    }

    public TipoCompetidor getTipo() {
        return this.tipo;
    }

    @Override
    public String getNombreCompetidor() {
        return this.alias;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %d, %d, %d, %d",
                this.tipo.toString(), this.nombreReal, this.alias,
                this.caracteristicas.get(Caracteristica.VELOCIDAD),
                this.caracteristicas.get(Caracteristica.FUERZA),
                this.caracteristicas.get(Caracteristica.RESISTENCIA),
                this.caracteristicas.get(Caracteristica.DESTREZA));
    }

    public int getCaracteristica(Caracteristica caracteristica) {
        return caracteristicas.getOrDefault(caracteristica, 0);
    }

}
