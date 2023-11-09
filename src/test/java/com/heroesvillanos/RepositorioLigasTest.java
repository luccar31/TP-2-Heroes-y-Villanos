package com.heroesvillanos;

import com.heroesvillanos.dominio.Liga;
import com.heroesvillanos.dominio.TipoCompetidor;
import com.heroesvillanos.repositorio.Repositorio;
import com.heroesvillanos.repositorio.RepositorioLigasEnMemoria;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RepositorioLigasTest {

    @Test
    public void alGuardarUnaLigaEnRepositorio_SePuedeListar(){
        Liga liga = new Liga(TipoCompetidor.HEROE, "Liga vacia", 1);

        Repositorio<Liga> repositorioLigas = new RepositorioLigasEnMemoria();
        repositorioLigas.guardar(liga);

        Assertions.assertEquals(1, repositorioLigas.listar().size());
    }

    @Test
    public void alGuardarUnaLigaEnRepositorio_SeGuardaCorrectamente(){
        Liga liga = new Liga(TipoCompetidor.HEROE, "Liga vacia", 1);

        Repositorio<Liga> repositorioLigas = new RepositorioLigasEnMemoria();
        repositorioLigas.guardar(liga);

        Assertions.assertEquals(1, repositorioLigas.listar().get(0).getId());
    }

    @Test
    public void alGuardarUnaLigaEnRepositorio_SePuedeObtenerPorNombre(){
        Liga liga = new Liga(TipoCompetidor.HEROE, "Liga vacia", 1);

        Repositorio<Liga> repositorioLigas = new RepositorioLigasEnMemoria();
        repositorioLigas.guardar(liga);

        Assertions.assertEquals(1, repositorioLigas.obtenerPorNombre("Liga vacia").getId());
    }

    @Test
    public void alGuardarUnaLigaEnRepositorio_SePuedeObtenerSuNombrePorIdentificador(){
        Liga liga = new Liga(TipoCompetidor.HEROE, "Liga vacia", 1);

        Repositorio<Liga> repositorioLigas = new RepositorioLigasEnMemoria();
        repositorioLigas.guardar(liga);

        Assertions.assertEquals("Liga vacia", repositorioLigas.obtenerPorIdentificador(1).getNombre());
    }

}
