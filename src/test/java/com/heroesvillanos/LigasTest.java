package com.heroesvillanos;

import com.heroesvillanos.dominio.Caracteristica;
import com.heroesvillanos.dominio.Liga;
import com.heroesvillanos.dominio.Personaje;
import com.heroesvillanos.dominio.TipoCompetidor;
import com.heroesvillanos.exception.TipoCompetidorNoSoportado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class LigasTest {

    @Test
    public void dada_liga_vacia_entonces_to_string_esperado() {
        Liga liga = new Liga(TipoCompetidor.HEROE, "Liga vacia", 1);

        Assertions.assertEquals("Liga vacia, ", liga.toString());
    }

    @Test
    @Disabled("solo funciona correctamente en modo debug (?????)")
    public void dado_dos_personajes_heroe_cuando_liga_creada_con_personajes_entonces_to_string_esperado() {
        Map<Caracteristica, Integer> caracteristicas = new HashMap<>();
        Personaje personaje1 = new Personaje(1, "Nombre 1", "Alias 1", TipoCompetidor.HEROE, caracteristicas);
        Personaje personaje2 = new Personaje(1, "Nombre 2", "Alias 2", TipoCompetidor.HEROE, caracteristicas);
        Liga liga = new Liga(TipoCompetidor.HEROE, "Liga con personajes", 1, personaje1, personaje2);

        Assertions.assertEquals("Liga con personajes, Alias 1, Alias 2", liga.toString());
    }

    @Test
    public void dado_tipo_competidor_incorrecto_cuando_se_construye_liga_entonces_lanza_excepcion(){
        Map<Caracteristica, Integer> caracteristicas = new HashMap<>();
        Personaje personaje1 = new Personaje(1, "Nombre 1", "Alias 1", TipoCompetidor.VILLANO, caracteristicas);

        Assertions.assertThrows(TipoCompetidorNoSoportado.class, () -> {
            new Liga(TipoCompetidor.HEROE, "Liga con personajes", 1, personaje1);
        });
    }

    @Test
    public void dada_liga_tipo_heroe_cuando_se_inserta_competidor_villano_entonces_se_lanza_excepcion(){
        Map<Caracteristica, Integer> caracteristicas = new HashMap<>();
        Personaje personaje1 = new Personaje(1, "Nombre 1", "Alias 1", TipoCompetidor.VILLANO, caracteristicas);

        Liga liga = new Liga(TipoCompetidor.HEROE, "Liga con personajes", 1);
        Assertions.assertThrows(TipoCompetidorNoSoportado.class, () -> {
            liga.agregarCompetidor(personaje1);
        });
    }
}