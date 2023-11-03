package com.heroesvillanos;

import com.heroesvillanos.dominio.Liga;
import com.heroesvillanos.dominio.TipoCompetidor;
import com.heroesvillanos.repositorio.Repositorio;
import com.heroesvillanos.repositorio.RepositorioLigasEnMemoria;
import org.junit.Assert;
import org.junit.Test;

public class RepositorioLigasTest {

    @Test
    public void alGuardarUnaLigaEnRepositorio_SePuedeListar(){
        Liga liga = new Liga(TipoCompetidor.HEROE, "Liga vacia", 1);

        Repositorio<Liga> repositorioLigas = new RepositorioLigasEnMemoria();
        repositorioLigas.guardar(liga);

        Assert.assertEquals(1, repositorioLigas.listar().size());
    }

    @Test
    public void alGuardarUnaLigaEnRepositorio_SeGuardaCorrectamente(){
        Liga liga = new Liga(TipoCompetidor.HEROE, "Liga vacia", 1);

        Repositorio<Liga> repositorioLigas = new RepositorioLigasEnMemoria();
        repositorioLigas.guardar(liga);

        Assert.assertEquals(1, repositorioLigas.listar().get(0).getId());
    }

    @Test
    public void alGuardarUnaLigaEnRepositorio_SePuedeObtenerPorNombre(){
        Liga liga = new Liga(TipoCompetidor.HEROE, "Liga vacia", 1);

        Repositorio<Liga> repositorioLigas = new RepositorioLigasEnMemoria();
        repositorioLigas.guardar(liga);

        Assert.assertEquals(1, repositorioLigas.obtenerPorNombre("Liga vacia").getId());
    }

    @Test
    public void alGuardarUnaLigaEnRepositorio_SePuedeObtenerSuNombrePorIdentificador(){
        Liga liga = new Liga(TipoCompetidor.HEROE, "Liga vacia", 1);

        Repositorio<Liga> repositorioLigas = new RepositorioLigasEnMemoria();
        repositorioLigas.guardar(liga);

        Assert.assertEquals("Liga vacia", repositorioLigas.obtenerPorIdentificador(1).getNombre());
    }

}
