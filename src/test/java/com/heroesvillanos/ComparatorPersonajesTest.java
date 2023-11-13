package com.heroesvillanos;

import com.heroesvillanos.comparators.PersonajeCaracteristicaComparator;
import com.heroesvillanos.dominio.Caracteristica;
import com.heroesvillanos.dominio.DireccionOrden;
import com.heroesvillanos.dominio.Personaje;
import com.heroesvillanos.dominio.TipoCompetidor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorPersonajesTest {

    @Test
    public void comparacion_direccion_ascendente_caracteristicas_velocidad() {
        List<Personaje> personajes = new ArrayList<>();

        personajes.add(new Personaje(1, "A", "A", TipoCompetidor.HEROE, 800, 200, 400, 600));
        personajes.add(new Personaje(2, "B", "B", TipoCompetidor.HEROE, 300, 100, 700, 100));
        personajes.add(new Personaje(3, "C", "C", TipoCompetidor.HEROE, 600, 500, 100, 300));

        Comparator<Personaje> comparator = new PersonajeCaracteristicaComparator(DireccionOrden.ASCENDENTE, Caracteristica.VELOCIDAD);

        personajes.sort(comparator);

        Assertions.assertEquals(2, personajes.get(0).getId());
        Assertions.assertEquals(3, personajes.get(1).getId());
        Assertions.assertEquals(1, personajes.get(2).getId());
    }

    @Test
    public void comparacion_direccion_descendente_caracteristicas_velocidad() {
        List<Personaje> personajes = new ArrayList<>();

        personajes.add(new Personaje(1, "A", "A", TipoCompetidor.HEROE, 800, 200, 400, 600));
        personajes.add(new Personaje(2, "B", "B", TipoCompetidor.HEROE, 300, 100, 700, 100));
        personajes.add(new Personaje(3, "C", "C", TipoCompetidor.HEROE, 600, 500, 100, 300));

        Comparator<Personaje> comparator = new PersonajeCaracteristicaComparator(DireccionOrden.DESCENDENTE,
                Caracteristica.VELOCIDAD);

        personajes.sort(comparator);

        Assertions.assertEquals(1, personajes.get(0).getId());
        Assertions.assertEquals(3, personajes.get(1).getId());
        Assertions.assertEquals(2, personajes.get(2).getId());
    }

    @Test
    public void comparacion_direccion_ascendente_caracteristicas_fuerza() {
        List<Personaje> personajes = new ArrayList<>();

        personajes.add(new Personaje(1, "A", "A", TipoCompetidor.HEROE, 800, 200, 400, 600));
        personajes.add(new Personaje(2, "B", "B", TipoCompetidor.HEROE, 300, 100, 700, 100));
        personajes.add(new Personaje(3, "C", "C", TipoCompetidor.HEROE, 600, 500, 100, 300));

        Comparator<Personaje> comparator = new PersonajeCaracteristicaComparator(DireccionOrden.ASCENDENTE,
                Caracteristica.FUERZA);

        personajes.sort(comparator);

        Assertions.assertEquals(2, personajes.get(0).getId());
        Assertions.assertEquals(1, personajes.get(1).getId());
        Assertions.assertEquals(3, personajes.get(2).getId());
    }

    @Test
    public void comparacion_direccion_descendente_caracteristicas_fuerza() {
        List<Personaje> personajes = new ArrayList<>();

        personajes.add(new Personaje(1, "A", "A", TipoCompetidor.HEROE, 800, 200, 400, 600));
        personajes.add(new Personaje(2, "B", "B", TipoCompetidor.HEROE, 300, 100, 700, 100));
        personajes.add(new Personaje(3, "C", "C", TipoCompetidor.HEROE, 600, 500, 100, 300));

        Comparator<Personaje> comparator = new PersonajeCaracteristicaComparator(DireccionOrden.DESCENDENTE,
                Caracteristica.FUERZA);

        personajes.sort(comparator);

        Assertions.assertEquals(3, personajes.get(0).getId());
        Assertions.assertEquals(1, personajes.get(1).getId());
        Assertions.assertEquals(2, personajes.get(2).getId());
    }

    @Test
    public void comparacion_direccion_ascendente_caracteristicas_fuerza_y_destreza() {
        List<Personaje> personajes = new ArrayList<>();

        personajes.add(new Personaje(1, "L", "L", TipoCompetidor.HEROE, 500, 100, 100, 300));
        personajes.add(new Personaje(2, "M", "M", TipoCompetidor.HEROE, 600, 700, 600, 400));
        personajes.add(new Personaje(3, "N", "N", TipoCompetidor.HEROE, 200, 700, 300, 500));
        personajes.add(new Personaje(4, "O", "O", TipoCompetidor.HEROE, 300, 800, 700, 200));
        personajes.add(new Personaje(5, "P", "P", TipoCompetidor.HEROE, 100, 400, 200, 800));

        Comparator<Personaje> comparator = new PersonajeCaracteristicaComparator(DireccionOrden.ASCENDENTE,
                Caracteristica.FUERZA, Caracteristica.DESTREZA);

        personajes.sort(comparator);

        Assertions.assertEquals(1, personajes.get(0).getId());
        Assertions.assertEquals(5, personajes.get(1).getId());
        Assertions.assertEquals(2, personajes.get(2).getId());
        Assertions.assertEquals(3, personajes.get(3).getId());
        Assertions.assertEquals(4, personajes.get(4).getId());
    }

    @Test
    public void comparacion_direccion_descendente_caracteristicas_fuerza_y_destreza() {
        List<Personaje> personajes = new ArrayList<>();

        personajes.add(new Personaje(1, "L", "L", TipoCompetidor.HEROE, 500, 100, 100, 300));
        personajes.add(new Personaje(2, "M", "M", TipoCompetidor.HEROE, 600, 700, 600, 400));
        personajes.add(new Personaje(3, "N", "N", TipoCompetidor.HEROE, 200, 700, 300, 500));
        personajes.add(new Personaje(4, "O", "O", TipoCompetidor.HEROE, 300, 800, 700, 200));
        personajes.add(new Personaje(5, "P", "P", TipoCompetidor.HEROE, 100, 400, 200, 800));

        Comparator<Personaje> comparator = new PersonajeCaracteristicaComparator(DireccionOrden.DESCENDENTE,
                Caracteristica.FUERZA, Caracteristica.DESTREZA);

        personajes.sort(comparator);

        Assertions.assertEquals(4, personajes.get(0).getId());
        Assertions.assertEquals(3, personajes.get(1).getId());
        Assertions.assertEquals(2, personajes.get(2).getId());
        Assertions.assertEquals(5, personajes.get(3).getId());
        Assertions.assertEquals(1, personajes.get(4).getId());
    }

    @Test
    public void comparacion_todas_caracteristicas_iguales_queda_orden_de_lista() {
        List<Personaje> personajes = new ArrayList<>();

        personajes.add(new Personaje(1, "L", "L", TipoCompetidor.HEROE, 100, 100, 100, 100));
        personajes.add(new Personaje(2, "M", "M", TipoCompetidor.HEROE, 100, 100, 100, 100));
        personajes.add(new Personaje(3, "N", "N", TipoCompetidor.HEROE, 100, 100, 100, 50));

        Comparator<Personaje> comparator = new PersonajeCaracteristicaComparator(DireccionOrden.ASCENDENTE,
                Caracteristica.FUERZA, Caracteristica.DESTREZA);

        personajes.sort(comparator);

        Assertions.assertEquals(3, personajes.get(0).getId());
        Assertions.assertEquals(1, personajes.get(1).getId());
        Assertions.assertEquals(2, personajes.get(2).getId());
    }
}
