package com.heroesvillanos.servicios;

import com.heroesvillanos.dominio.Liga;
import com.heroesvillanos.dominio.TipoCompetidor;

import java.util.List;

public interface IServiciosLigas {
    void cargarLiga();
    List<Liga> listarLigas();
    Liga crearLiga(TipoCompetidor tipo);
    void guardarLigas();
}
