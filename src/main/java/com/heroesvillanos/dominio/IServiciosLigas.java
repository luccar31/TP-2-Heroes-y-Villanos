package com.heroesvillanos.dominio;

import java.util.List;

public interface IServiciosLigas {
    void cargarLiga();
    List<Liga> listarLigas();
    Liga crearLiga(TipoCompetidor tipo);
    void guardarLigas();
}
