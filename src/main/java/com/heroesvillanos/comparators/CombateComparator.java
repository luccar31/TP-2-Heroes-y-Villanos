package com.heroesvillanos.comparators;

import com.heroesvillanos.dominio.Caracteristica;
import com.heroesvillanos.dominio.Competidor;

import java.util.Comparator;

public class CombateComparator implements Comparator<Competidor> {
    private Caracteristica c;

    public CombateComparator(Caracteristica c) {
        this.c = c;
    }

    public int compare(Competidor a, Competidor b) {
        String[] caracteristicas = {"VELOCIDAD", "FUERZA", "RESISTENCIA", "DESTREZA", "VELOCIDAD", "FUERZA", "RESISTENCIA"};
        int restaCaracteristica = -1;
        for (int i = 0; i < caracteristicas.length; i++) {
            if (restaCaracteristica == 0) {
                c = Caracteristica.valueOf(caracteristicas[i]);
            }
            if (c.name().equals(caracteristicas[i])) {
                restaCaracteristica = a.getCaracteristica(c) - b.getCaracteristica(c);
            }
        }
        return restaCaracteristica;
    }

}
