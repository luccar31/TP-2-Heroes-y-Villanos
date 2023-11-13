package com.heroesvillanos;

import com.heroesvillanos.dominio.Caracteristica;
import com.heroesvillanos.dominio.Personaje;
import com.heroesvillanos.dominio.TipoCompetidor;
import com.heroesvillanos.repositorio.Repositorio;
import com.heroesvillanos.repositorio.RepositorioPersonajeEnMemoria;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class RepositorioPersonajesTest {
    @Test
    public void al_guardar_un_personaje_en_repositorio_se_puede_listar(){
        //DADO
        Map<Caracteristica, Integer> caracteristicas = new HashMap<>();
        caracteristicas.put(Caracteristica.VELOCIDAD, 100);
        caracteristicas.put(Caracteristica.FUERZA, 100);
        caracteristicas.put(Caracteristica.DESTREZA, 100);
        caracteristicas.put(Caracteristica.RESISTENCIA, 100);
        Personaje personaje1 = new Personaje(1, "Nombre 1", "Alias 1", TipoCompetidor.HEROE, caracteristicas);

        Repositorio<Personaje> repositorioPersonajes = new RepositorioPersonajeEnMemoria();

        //CUANDO
        repositorioPersonajes.guardar(personaje1);

        //ENTONCES
        Assertions.assertEquals(1, repositorioPersonajes.listar().size());
    }

    @Test
    public void al_guardar_un_personaje_en_repositorio_se_guarda_correctamente(){
        Map<Caracteristica, Integer> caracteristicas = new HashMap<>();
        caracteristicas.put(Caracteristica.VELOCIDAD, 100);
        caracteristicas.put(Caracteristica.FUERZA, 100);
        caracteristicas.put(Caracteristica.DESTREZA, 100);
        caracteristicas.put(Caracteristica.RESISTENCIA, 100);
        Personaje personaje1 = new Personaje(1, "Nombre 1", "Alias 1", TipoCompetidor.HEROE, caracteristicas);

        Repositorio<Personaje> repositorioPersonajes = new RepositorioPersonajeEnMemoria();
        repositorioPersonajes.guardar(personaje1);

        Assertions.assertNotNull(repositorioPersonajes.listar());
        Assertions.assertEquals(1, repositorioPersonajes.listar().get(0).getId());
    }

    @Test
    public void al_guardar_un_personaje_en_repositorio_se_puede_obtener_por_nombre(){
        Map<Caracteristica, Integer> caracteristicas = new HashMap<>();
        caracteristicas.put(Caracteristica.VELOCIDAD, 100);
        caracteristicas.put(Caracteristica.FUERZA, 100);
        caracteristicas.put(Caracteristica.DESTREZA, 100);
        caracteristicas.put(Caracteristica.RESISTENCIA, 100);
        Personaje personaje1 = new Personaje(1, "Nombre 1", "Alias 1", TipoCompetidor.HEROE, caracteristicas);


        Repositorio<Personaje> repositorioPersonajes = new RepositorioPersonajeEnMemoria();
        repositorioPersonajes.guardar(personaje1);

        Assertions.assertNotNull(repositorioPersonajes.obtenerPorNombreCompetidor("Nombre 1"));
        Assertions.assertEquals(1, repositorioPersonajes.obtenerPorNombreCompetidor("Nombre 1").getId());
    }

    @Test
    public void al_guardar_un_personaje_en_repositorio_se_puede_obtener_su_nombre_por_identificador(){
        Map<Caracteristica, Integer> caracteristicas = new HashMap<>();
        caracteristicas.put(Caracteristica.VELOCIDAD, 100);
        caracteristicas.put(Caracteristica.FUERZA, 100);
        caracteristicas.put(Caracteristica.DESTREZA, 100);
        caracteristicas.put(Caracteristica.RESISTENCIA, 100);
        Personaje personaje1 = new Personaje(1, "Nombre 1", "Alias 1", TipoCompetidor.HEROE, caracteristicas);


        Repositorio<Personaje> repositorioPersonajes = new RepositorioPersonajeEnMemoria();
        repositorioPersonajes.guardar(personaje1);

        Assertions.assertNotNull(repositorioPersonajes.obtenerPorIdentificador(1));
        Assertions.assertEquals("Nombre 1", repositorioPersonajes.obtenerPorIdentificador(1).getNombreReal());
    }

}
