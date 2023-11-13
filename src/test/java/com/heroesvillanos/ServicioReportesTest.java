package com.heroesvillanos;


import com.heroesvillanos.dominio.*;
import com.heroesvillanos.exception.CompetidorNoEncontrado;
import com.heroesvillanos.repositorio.Repositorio;
import com.heroesvillanos.repositorio.RepositorioLigasEnMemoria;
import com.heroesvillanos.repositorio.RepositorioPersonajeEnMemoria;
import com.heroesvillanos.servicios.ServicioReportes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

public class ServicioReportesTest {

    private Repositorio<Personaje> repositorioPersonajes;
    private Repositorio<Liga> repositorioLigas;
    private ServicioReportes servicioReportes;
    
    @BeforeEach
    public void setUp() {
        repositorioPersonajes = Mockito.mock(RepositorioPersonajeEnMemoria.class);
        repositorioLigas = Mockito.mock(RepositorioLigasEnMemoria.class);
        servicioReportes = new ServicioReportes(repositorioPersonajes, repositorioLigas);
    }

    @Test
    public void dado_personajes_debe_ordenar_por_velocidad_ascendente() {
        //DADO
        List<Personaje> personajes = dadoPersonajes();
        when(repositorioPersonajes.listar()).thenReturn(personajes);
        
        //CUANDO
        List<Personaje> personajesOrdenados = servicioReportes.ordenarPersonajesPor(DireccionOrden.ASCENDENTE, Caracteristica.VELOCIDAD);
        
        //ENTONCES
        assertEquals(1, personajesOrdenados.get(0).getId());
        assertEquals(2, personajesOrdenados.get(1).getId());
        assertEquals(3, personajesOrdenados.get(2).getId());

    }

    @Test
    public void dado_nombre_competidor_noexistente_cuando_se_llama_servicio_arroja_excepcion(){
        when(repositorioPersonajes.obtenerPorNombre(anyString())).thenReturn(null);
        Assertions.assertThrows(CompetidorNoEncontrado.class, () -> {
            servicioReportes.competidoresQueVenzan("cualquierNombre", Caracteristica.FUERZA);
        });
    }

    @Test
    public void dado_competidores_cuando_competidores_que_vencen_entonces_validacion(){
        //DADO
        List<Personaje> personajes = dadoPersonajes();
        when(repositorioPersonajes.listar()).thenReturn(personajes);
        Personaje pEncontrado = personajes.get(0);
        when(repositorioPersonajes.obtenerPorNombre(anyString())).thenReturn(pEncontrado);
        when(repositorioLigas.listar()).thenReturn(new ArrayList<>());
        //CUANDO
        List<Competidor> competidores = servicioReportes.competidoresQueVenzan("cualquierNombre", Caracteristica.VELOCIDAD);
        //ENTONCES
        assertEquals(1, competidores.size());
        Competidor c = competidores.get(0);
        assertNotEquals(c.getTipo(), pEncontrado.getTipo());
        assertTrue(c.getCaracteristica(Caracteristica.VELOCIDAD) > pEncontrado.getCaracteristica(Caracteristica.VELOCIDAD));

    }


    private static List<Personaje> dadoPersonajes(){
        List<Personaje> personajes = new ArrayList<>();
        Personaje p1 = new Personaje(1, "Nombre1", "Alias1", TipoCompetidor.HEROE, 10, 20, 30, 40);
        Personaje p2 = new Personaje(2, "Nombre2", "Alias2", TipoCompetidor.HEROE, 15, 25, 35, 45);
        Personaje p3 = new Personaje(3, "Nombre2", "Alias2", TipoCompetidor.VILLANO, 100, 25, 35, 45);

        personajes.add(p2);
        personajes.add(p1);
        personajes.add(p3);
        return personajes;
    }
}