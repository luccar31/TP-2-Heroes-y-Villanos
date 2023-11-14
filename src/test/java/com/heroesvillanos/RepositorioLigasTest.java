package com.heroesvillanos;

import com.heroesvillanos.dominio.Liga;
import com.heroesvillanos.dominio.TipoCompetidor;
import com.heroesvillanos.repositorio.Repositorio;
import com.heroesvillanos.repositorio.RepositorioLigasEnMemoria;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RepositorioLigasTest {

    @Test
    public void al_guardar_una_liga_en_repositorio_se_puede_listar(){
        Liga liga = new Liga(TipoCompetidor.HEROE, "Liga vacia", 1);

        Repositorio<Liga> repositorioLigas = new RepositorioLigasEnMemoria();
        repositorioLigas.guardar(liga);

        Assertions.assertEquals(1, repositorioLigas.listar().size());
    }

    @Test
    public void al_guardar_una_liga_en_repositorio_se_guarda_correctamente(){
        Liga liga = new Liga(TipoCompetidor.HEROE, "Liga vacia", 1);

        Repositorio<Liga> repositorioLigas = new RepositorioLigasEnMemoria();
        repositorioLigas.guardar(liga);

        Assertions.assertEquals(1, repositorioLigas.listar().get(0).getId());
    }

    @Test
    public void al_guardar_una_liga_en_repositorio_se_puede_obtener_su_nombre_por_identificador(){
        Liga liga = new Liga(TipoCompetidor.HEROE, "Liga vacia", 1);

        Repositorio<Liga> repositorioLigas = new RepositorioLigasEnMemoria();
        repositorioLigas.guardar(liga);

        Assertions.assertEquals("Liga vacia", repositorioLigas.obtenerPorIdentificador(1).getNombre());
    }

}
