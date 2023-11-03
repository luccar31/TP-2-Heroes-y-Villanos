package com.heroesvillanos;

import com.heroesvillanos.dominio.Caracteristica;
import com.heroesvillanos.dominio.Personaje;
import com.heroesvillanos.dominio.Personaje;
import com.heroesvillanos.dominio.TipoCompetidor;
import com.heroesvillanos.repositorio.Repositorio;
import com.heroesvillanos.repositorio.RepositorioPersonajeEnMemoria;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class RepositorioPersonajesTest {
    @Test
    public void alGuardarUnPersonajeEnRepositorio_SePuedeListar(){
        Map<Caracteristica, Integer> caracteristicas = new HashMap<>();
        caracteristicas.put(Caracteristica.VELOCIDAD, 100);
        caracteristicas.put(Caracteristica.FUERZA, 100);
        caracteristicas.put(Caracteristica.DESTREZA, 100);
        caracteristicas.put(Caracteristica.RESISTENCIA, 100);
        Personaje personaje1 = new Personaje(1, "Nombre 1", "Alias 1", TipoCompetidor.HEROE, caracteristicas);

        Repositorio<Personaje> repositorioPersonajes = new RepositorioPersonajeEnMemoria();
        repositorioPersonajes.guardar(personaje1);

        Assert.assertEquals(1, repositorioPersonajes.listar().size());
    }

    @Test
    public void alGuardarUnPersonajeEnRepositorio_SeGuardaCorrectamente(){
        Map<Caracteristica, Integer> caracteristicas = new HashMap<>();
        caracteristicas.put(Caracteristica.VELOCIDAD, 100);
        caracteristicas.put(Caracteristica.FUERZA, 100);
        caracteristicas.put(Caracteristica.DESTREZA, 100);
        caracteristicas.put(Caracteristica.RESISTENCIA, 100);
        Personaje personaje1 = new Personaje(1, "Nombre 1", "Alias 1", TipoCompetidor.HEROE, caracteristicas);

        Repositorio<Personaje> repositorioPersonajes = new RepositorioPersonajeEnMemoria();
        repositorioPersonajes.guardar(personaje1);

        Assert.assertNotNull(repositorioPersonajes.listar());
        Assert.assertEquals(1, repositorioPersonajes.listar().get(0).getId());
    }

    @Test
    public void alGuardarUnPersonajeEnRepositorio_SePuedeObtenerPorNombre(){
        Map<Caracteristica, Integer> caracteristicas = new HashMap<>();
        caracteristicas.put(Caracteristica.VELOCIDAD, 100);
        caracteristicas.put(Caracteristica.FUERZA, 100);
        caracteristicas.put(Caracteristica.DESTREZA, 100);
        caracteristicas.put(Caracteristica.RESISTENCIA, 100);
        Personaje personaje1 = new Personaje(1, "Nombre 1", "Alias 1", TipoCompetidor.HEROE, caracteristicas);


        Repositorio<Personaje> repositorioPersonajes = new RepositorioPersonajeEnMemoria();
        repositorioPersonajes.guardar(personaje1);

        Assert.assertNotNull(repositorioPersonajes.obtenerPorNombre("Nombre 1"));
        Assert.assertEquals(1, repositorioPersonajes.obtenerPorNombre("Nombre 1").getId());
    }

    @Test
    public void alGuardarUnPersonajeEnRepositorio_SePuedeObtenerSuNombrePorIdentificador(){
        Map<Caracteristica, Integer> caracteristicas = new HashMap<>();
        caracteristicas.put(Caracteristica.VELOCIDAD, 100);
        caracteristicas.put(Caracteristica.FUERZA, 100);
        caracteristicas.put(Caracteristica.DESTREZA, 100);
        caracteristicas.put(Caracteristica.RESISTENCIA, 100);
        Personaje personaje1 = new Personaje(1, "Nombre 1", "Alias 1", TipoCompetidor.HEROE, caracteristicas);


        Repositorio<Personaje> repositorioPersonajes = new RepositorioPersonajeEnMemoria();
        repositorioPersonajes.guardar(personaje1);

        Assert.assertNotNull(repositorioPersonajes.obtenerPorIdentificador(1));
        Assert.assertEquals("Nombre 1", repositorioPersonajes.obtenerPorIdentificador(1).getNombreReal());
    }

}
