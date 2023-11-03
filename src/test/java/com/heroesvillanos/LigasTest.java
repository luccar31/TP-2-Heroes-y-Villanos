package com.heroesvillanos;

import com.heroesvillanos.dominio.Caracteristica;
import com.heroesvillanos.dominio.Liga;
import com.heroesvillanos.dominio.Personaje;
import com.heroesvillanos.dominio.TipoCompetidor;
import com.heroesvillanos.exception.TipoCompetidorNoSoportado;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LigasTest {

    @Test
    public void dadaLigaVacia_entoncesToStringEsperado() {
        Liga liga = new Liga(TipoCompetidor.HEROE, "Liga vacia", 1);

        Assert.assertEquals("Liga vacia", liga.toString());
    }

    @Test
    @Ignore("solo funciona correctamente en modo debug (?????)")
    public void dadoDosPersonajesHeroe_cuandoLigaCreadaConPersonajes_entoncesToStringEsperado() {
        Map<Caracteristica, Integer> caracteristicas = new HashMap<>();
        Personaje personaje1 = new Personaje(1, "Nombre 1", "Alias 1", TipoCompetidor.HEROE, caracteristicas);
        Personaje personaje2 = new Personaje(1, "Nombre 2", "Alias 2", TipoCompetidor.HEROE, caracteristicas);
        Liga liga = new Liga(TipoCompetidor.HEROE, "Liga con personajes", 1, personaje1, personaje2);

        Assert.assertEquals("Liga con personajes, Alias 1, Alias 2", liga.toString());
    }

    @Test(expected = TipoCompetidorNoSoportado.class)
    public void dadoTipoCompetidorIncorrecto_cuandoSeConstruyeLiga_entoncesLanzaExcepcion(){
        Map<Caracteristica, Integer> caracteristicas = new HashMap<>();
        Personaje personaje1 = new Personaje(1, "Nombre 1", "Alias 1", TipoCompetidor.VILLANO, caracteristicas);

        Liga liga = new Liga(TipoCompetidor.HEROE, "Liga con personajes", 1, personaje1);
    }

    @Test(expected = TipoCompetidorNoSoportado.class)
    public void dadaLigaTipoHeroe_cuandoSeInsertaCompetidorVillano_entoncesSeLanzaExcepcion(){
        Map<Caracteristica, Integer> caracteristicas = new HashMap<>();
        Personaje personaje1 = new Personaje(1, "Nombre 1", "Alias 1", TipoCompetidor.VILLANO, caracteristicas);

        Liga liga = new Liga(TipoCompetidor.HEROE, "Liga con personajes", 1);
        liga.agregarCompetidor(personaje1);
    }
}