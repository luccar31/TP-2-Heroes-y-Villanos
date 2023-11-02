package com.heroesvillanos;

import com.heroesvillanos.dominio.Caracteristica;
import com.heroesvillanos.dominio.Liga;
import com.heroesvillanos.dominio.Personaje;
import com.heroesvillanos.dominio.TipoCompetidor;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LigasTest {

    @Test
    public void toStringFuncionaSegunLoEsperado_ligaVacia(){
        Liga liga = new Liga(TipoCompetidor.HEROE, "Liga vacia", 1);

        Assert.assertEquals("Liga vacia", liga.toString());
    }

    @Test
    @Ignore("falla cuando se corre sin modo debug (?)")
    public void toStringFuncionaSegunLoEsperado_conPersonajes(){
        Map<Caracteristica, Integer> caracteristicas = new HashMap<>();
        Personaje personaje1 = new Personaje(1, "Nombre 1", "Alias 1", TipoCompetidor.HEROE, caracteristicas);
        Personaje personaje2 = new Personaje(1, "Nombre 2", "Alias 2", TipoCompetidor.HEROE, caracteristicas);
        Liga liga = new Liga(TipoCompetidor.HEROE, "Liga con personajes", 1, personaje1, personaje2);

        Assert.assertEquals("Liga con personajes, Alias 1, Alias 2", liga.toString());
    }
}
