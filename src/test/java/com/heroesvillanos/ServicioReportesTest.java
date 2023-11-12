package com.heroesvillanos;


import com.heroesvillanos.dominio.Caracteristica;
import com.heroesvillanos.dominio.DireccionOrden;
import com.heroesvillanos.dominio.Liga;
import com.heroesvillanos.dominio.Personaje;
import com.heroesvillanos.dominio.TipoCompetidor;
import com.heroesvillanos.exception.CompetidorNoEncontrado;
import com.heroesvillanos.repositorio.Repositorio;
import com.heroesvillanos.repositorio.RepositorioLigasEnMemoria;
import com.heroesvillanos.repositorio.RepositorioPersonajeEnMemoria;
import com.heroesvillanos.servicios.ServicioReportes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    public void dadoPersonajes_DebeOrdenarPorVelocidadAscendente() {
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
    public void test1(){
        when(repositorioPersonajes.obtenerPorNombre(anyString())).thenReturn(null);
        Assertions.assertThrows(CompetidorNoEncontrado.class, () -> {
            servicioReportes.competidoresQueVenzan("cualquierNombre", Caracteristica.FUERZA);
        });
    }

    @Test
    public void test2(){
        //DADO
        List<Personaje> personajes = dadoPersonajes();
        when(repositorioPersonajes.listar()).thenReturn(personajes);
        when(repositorioPersonajes.obtenerPorNombre(anyString())).thenReturn(personajes.get(0));
        when(repositorioLigas.listar()).thenReturn(new ArrayList<>());
        //CUANDO
        servicioReportes.competidoresQueVenzan("cualquierNombre", Caracteristica.VELOCIDAD);
        //ENTONCES

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