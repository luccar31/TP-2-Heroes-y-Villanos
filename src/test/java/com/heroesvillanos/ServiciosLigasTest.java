package com.heroesvillanos;

import com.heroesvillanos.dominio.Liga;
import com.heroesvillanos.dominio.Personaje;
import com.heroesvillanos.dominio.RegistroLiga;
import com.heroesvillanos.dominio.TipoCompetidor;
import com.heroesvillanos.persistencia.Persistencia;
import com.heroesvillanos.repositorio.Repositorio;
import com.heroesvillanos.servicios.ServicioLigas;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class ServiciosLigasTest {

    private Repositorio<Liga> repositorio;

    @InjectMocks
    private ServicioLigas servicioLigas;

    private TipoCompetidor tipoCompetidor;
    private String nombreLiga;

    private final List<Liga> list = new ArrayList<>();

    @BeforeEach
    public void init() {
        tipoCompetidor = TipoCompetidor.HEROE;
        nombreLiga = "dummyNombreLiga";
        Repositorio<Personaje> repositorioPersonajes = Mockito.mock(Repositorio.class);
        repositorio = Mockito.mock(Repositorio.class);
        Persistencia<RegistroLiga, Liga> ligaPersistencia = Mockito.mock(Persistencia.class);
        servicioLigas = new ServicioLigas(repositorio, repositorioPersonajes, ligaPersistencia);
        Liga liga = new Liga(TipoCompetidor.HEROE, "Primera Liga", 1);
        list.add(liga);
    }

    @Test
    public void dadoNombreYTipoCompetidor_DebeCrearLigaConIdCorrespondiente() {
        when(repositorio.listar()).thenReturn(list);
        doNothing().when(repositorio).guardar(any(Liga.class));
        Liga outputLiga = servicioLigas.crear(tipoCompetidor, nombreLiga);
        Assertions.assertEquals(list.get(0).getId() + 1, outputLiga.getId());
    }
}