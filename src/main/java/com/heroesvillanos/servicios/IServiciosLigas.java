package com.heroesvillanos.servicios;

import com.heroesvillanos.dominio.Liga;
import com.heroesvillanos.dominio.TipoCompetidor;

import java.util.List;

public interface IServiciosLigas extends IServicioCompetidores<Liga> {
    List<Liga> cargar();

    List<Liga> listar(TipoCompetidor... filtroTipo);
    void printLista(String header, TipoCompetidor... filtroTipo);

    Liga crear(TipoCompetidor tipo, String nombre);
    void persistir();
    public Liga GetPorID(int id);
}
