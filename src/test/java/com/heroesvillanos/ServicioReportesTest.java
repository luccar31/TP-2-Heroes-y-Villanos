package com.heroesvillanos;


import com.heroesvillanos.dominio.Caracteristica;
import com.heroesvillanos.dominio.DireccionOrden;
import com.heroesvillanos.dominio.Liga;
import com.heroesvillanos.dominio.Personaje;
import com.heroesvillanos.dominio.TipoCompetidor;
import com.heroesvillanos.repositorio.Repositorio;
import com.heroesvillanos.repositorio.RepositorioLigasEnMemoria;
import com.heroesvillanos.repositorio.RepositorioPersonajeEnMemoria;
import com.heroesvillanos.servicios.ServicioReportes;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioReportesTest {

    private Repositorio<Personaje> repositorioPersonajes;
    private Repositorio<Liga> repositorioLigas;
    private ServicioReportes servicioReportes;
    private final List<Personaje> personajes = new ArrayList<>();
    Personaje p1;
    Personaje p2;

    @BeforeEach
    public void setUp() {
        repositorioPersonajes = Mockito.mock(RepositorioPersonajeEnMemoria.class);
        repositorioLigas = new RepositorioLigasEnMemoria();
        servicioReportes = new ServicioReportes(repositorioPersonajes, repositorioLigas);
        p1 = new Personaje(1, "Nombre1", "Alias1", TipoCompetidor.HEROE, 10, 20, 30, 40);
        p2 = new Personaje(2, "Nombre2", "Alias2", TipoCompetidor.HEROE, 15, 25, 35, 45);
    }

    @Test
    public void dadoPersonajes_DebeOrdenarPorVelocidadAscendente() {
        personajes.add(p2);
        personajes.add(p1);
        when(repositorioPersonajes.listar()).thenReturn(personajes);
        List<Personaje> personajesOrdenados = servicioReportes.ordenarPersonajesPor(DireccionOrden.ASCENDENTE, Caracteristica.VELOCIDAD);
        assertEquals(p1, personajesOrdenados.get(0));
        assertEquals(p2, personajesOrdenados.get(1));
    }

}