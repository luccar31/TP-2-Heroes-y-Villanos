package com.heroesvillanos;

import com.heroesvillanos.dominio.Caracteristica;
import com.heroesvillanos.dominio.Personaje;
import com.heroesvillanos.dominio.TipoCompetidor;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class PersonajesTest {

    @Test
    public void dadoDeterminadosDatos_cuandoConstruyePersonaje_entoncesToStringFunciona(){
        Map<Caracteristica, Integer> caracteristicas = new HashMap<>();
        caracteristicas.put(Caracteristica.VELOCIDAD, 100);
        caracteristicas.put(Caracteristica.FUERZA, 100);
        caracteristicas.put(Caracteristica.DESTREZA, 100);
        caracteristicas.put(Caracteristica.RESISTENCIA, 100);
        Personaje personaje1 = new Personaje(1, "Nombre 1", "Alias 1", TipoCompetidor.HEROE, caracteristicas);

        Assert.assertEquals("Héroe, Nombre 1, Alias 1, 100, 100, 100, 100", personaje1.toString());
    }
}
