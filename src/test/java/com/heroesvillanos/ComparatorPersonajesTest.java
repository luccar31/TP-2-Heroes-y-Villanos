package com.heroesvillanos;

import com.heroesvillanos.comparators.PersonajeCaracteristicaComparator;
import com.heroesvillanos.dominio.Caracteristica;
import com.heroesvillanos.dominio.DireccionOrden;
import com.heroesvillanos.dominio.Personaje;
import com.heroesvillanos.dominio.TipoCompetidor;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorPersonajesTest {

    /*private List<Personaje> personajes;

    @Before
    public void before(){
        this.personajes = new ArrayList<>();
        personajes.add(new Personaje( 1,"A","A", TipoCompetidor.HEROE, 800, 200, 400, 600));
        personajes.add(new Personaje( 2,"B","B", TipoCompetidor.HEROE, 300, 100, 700, 100));
        personajes.add(new Personaje( 3,"C","C", TipoCompetidor.HEROE, 600, 500, 100, 300));
        personajes.add(new Personaje( 4,"D","D", TipoCompetidor.HEROE, 200, 700, 800, 400));
        personajes.add(new Personaje( 5,"E","E", TipoCompetidor.HEROE, 400, 300, 600, 500));
        personajes.add(new Personaje( 6,"F","F", TipoCompetidor.HEROE, 700, 100, 200, 200));
        personajes.add(new Personaje( 7,"G","G", TipoCompetidor.HEROE, 500, 600, 300, 100));
        personajes.add(new Personaje( 8,"H","H", TipoCompetidor.HEROE, 100, 300, 800, 100));
        personajes.add(new Personaje( 9,"I","I", TipoCompetidor.HEROE, 300, 400, 500, 800));
        personajes.add(new Personaje(10,"J","J", TipoCompetidor.HEROE, 100, 600, 400, 700));
        personajes.add(new Personaje(11,"K","K", TipoCompetidor.HEROE, 200, 800, 500, 200));
        personajes.add(new Personaje(12,"L","L", TipoCompetidor.HEROE, 500, 100, 100, 300));
        personajes.add(new Personaje(13,"M","M", TipoCompetidor.HEROE, 600, 700, 600, 400));
        personajes.add(new Personaje(14,"N","N", TipoCompetidor.HEROE, 200, 100, 300, 500));
        personajes.add(new Personaje(15,"O","O", TipoCompetidor.HEROE, 300, 800, 700, 200));
        personajes.add(new Personaje(16,"P","P", TipoCompetidor.HEROE, 100, 400, 200, 800));
        personajes.add(new Personaje(17,"Q","Q", TipoCompetidor.HEROE, 400, 500, 300, 600));
        personajes.add(new Personaje(18,"R","R", TipoCompetidor.HEROE, 800, 300, 800, 700));
        personajes.add(new Personaje(19,"S","S", TipoCompetidor.HEROE, 300, 100, 600, 100));
        personajes.add(new Personaje(20,"T","T", TipoCompetidor.HEROE, 500, 600, 500, 200));
        personajes.add(new Personaje(21,"U","U", TipoCompetidor.HEROE, 600, 200, 200, 100));
        personajes.add(new Personaje(22,"V","V", TipoCompetidor.HEROE, 100, 200, 100, 300));
        personajes.add(new Personaje(23,"W","W", TipoCompetidor.HEROE, 400, 700, 400, 600));
        personajes.add(new Personaje(24,"X","X", TipoCompetidor.HEROE, 700, 300, 500, 400));
        personajes.add(new Personaje(25,"Y","Y", TipoCompetidor.HEROE, 800, 500, 200, 500));

    }*/

    @Test
    public void comparacion_direccion_ascendente_caracteristicas_velocidad() {
        List<Personaje> personajes = new ArrayList<>();

        personajes.add(new Personaje(1, "A", "A", TipoCompetidor.HEROE, 800, 200, 400, 600));
        personajes.add(new Personaje(2, "B", "B", TipoCompetidor.HEROE, 300, 100, 700, 100));
        personajes.add(new Personaje(3, "C", "C", TipoCompetidor.HEROE, 600, 500, 100, 300));

        Comparator<Personaje> comparator = new PersonajeCaracteristicaComparator(DireccionOrden.ASCENDENTE, Caracteristica.VELOCIDAD);

        personajes.sort(comparator);

        Assert.assertEquals(2, personajes.get(0).getId());
        Assert.assertEquals(3, personajes.get(1).getId());
        Assert.assertEquals(1, personajes.get(2).getId());
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

        Assert.assertEquals(1, personajes.get(0).getId());
        Assert.assertEquals(3, personajes.get(1).getId());
        Assert.assertEquals(2, personajes.get(2).getId());
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

        Assert.assertEquals(2, personajes.get(0).getId());
        Assert.assertEquals(1, personajes.get(1).getId());
        Assert.assertEquals(3, personajes.get(2).getId());
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

        Assert.assertEquals(3, personajes.get(0).getId());
        Assert.assertEquals(1, personajes.get(1).getId());
        Assert.assertEquals(2, personajes.get(2).getId());
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

        Assert.assertEquals(1, personajes.get(0).getId());
        Assert.assertEquals(5, personajes.get(1).getId());
        Assert.assertEquals(2, personajes.get(2).getId());
        Assert.assertEquals(3, personajes.get(3).getId());
        Assert.assertEquals(4, personajes.get(4).getId());
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

        Assert.assertEquals(4, personajes.get(0).getId());
        Assert.assertEquals(3, personajes.get(1).getId());
        Assert.assertEquals(2, personajes.get(2).getId());
        Assert.assertEquals(5, personajes.get(3).getId());
        Assert.assertEquals(1, personajes.get(4).getId());
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

        Assert.assertEquals(3, personajes.get(0).getId());
        Assert.assertEquals(1, personajes.get(1).getId());
        Assert.assertEquals(2, personajes.get(2).getId());
    }
}
