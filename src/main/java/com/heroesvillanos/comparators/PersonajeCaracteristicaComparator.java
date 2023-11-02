package com.heroesvillanos.comparators;

import com.heroesvillanos.dominio.Caracteristica;
import com.heroesvillanos.dominio.DireccionOrden;
import com.heroesvillanos.dominio.Personaje;

import java.util.Arrays;
import java.util.Comparator;

public class PersonajeCaracteristicaComparator implements Comparator<Personaje> {

    private final DireccionOrden direccionOrden;
    private final Caracteristica[] caracteristicas;

    public PersonajeCaracteristicaComparator(DireccionOrden direccionOrden, Caracteristica... caracteristicas) {
        this.direccionOrden = direccionOrden;
        if (caracteristicas.length < 1) {
            throw new IllegalArgumentException("Debe haber al menos una característica para realizar el ordenamiento");
        }
        Arrays.sort(caracteristicas);
        this.caracteristicas = caracteristicas;
    }

    @Override
    public int compare(Personaje p1, Personaje p2) {
        for (Caracteristica c : caracteristicas) {
            int comparacion = Integer.compare(p1.getCaracteristica(c), p2.getCaracteristica(c));

            if (comparacion == 0) {
                continue;
            }

            return direccionOrden == DireccionOrden.ASCENDENTE ? comparacion : -comparacion;
        }
        return 0;
    }
}
