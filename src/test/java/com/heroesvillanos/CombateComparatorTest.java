package com.heroesvillanos;

import com.heroesvillanos.comparators.CombateComparator;
import com.heroesvillanos.dominio.Caracteristica;
import com.heroesvillanos.dominio.Personaje;
import com.heroesvillanos.dominio.TipoCompetidor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CombateComparatorTest {

    private Personaje p1;
    private Personaje p2;

    @BeforeEach
    void init(){
        p1 = new Personaje(1, "Nombre1", "Alias1", TipoCompetidor.HEROE, 10, 20, 30, 40);
        p2 = new Personaje(2, "Nombre2", "Alias2", TipoCompetidor.HEROE, 15, 25, 35, 45);
    }
    @Test
    public void compararVelocidad_P1MasLentoQueP2() {
        CombateComparator comparator = new CombateComparator(Caracteristica.VELOCIDAD);
        assertTrue(comparator.compare(p1, p2) < 0);
    }

    @Test
    public void compararFuerza_P1MasDebilQueP2() {
        CombateComparator comparator = new CombateComparator(Caracteristica.FUERZA);
        assertTrue(comparator.compare(p1, p2) < 0);
    }

    @Test
    public void compararResistencia_P1MenosResistenteQueP2() {
        CombateComparator comparator = new CombateComparator(Caracteristica.RESISTENCIA);
        assertTrue(comparator.compare(p1, p2) < 0);
    }

    @Test
    public void compararDestrza_P1MenosAgilQueP2() {
        CombateComparator comparator = new CombateComparator(Caracteristica.RESISTENCIA);
        assertTrue(comparator.compare(p1, p2) < 0);
    }
}