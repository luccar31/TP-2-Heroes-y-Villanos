package com.heroesvillanos.servicios;

import com.heroesvillanos.dominio.Liga;
import com.heroesvillanos.dominio.TipoCompetidor;

import java.util.List;

public interface IServiciosLigas {
    List<Liga> cargar();

    List<Liga> listar();

    Liga crear(TipoCompetidor tipo, String nombre);

    void persistir();
}
