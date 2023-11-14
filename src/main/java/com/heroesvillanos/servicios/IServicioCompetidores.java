package com.heroesvillanos.servicios;


import com.heroesvillanos.dominio.TipoCompetidor;

import java.util.List;

public interface IServicioCompetidores<T> {
    List<T> cargar();

    List<T> listar(TipoCompetidor... filtroTipo);
    void printLista(String header, TipoCompetidor... filtroTipo);

    void persistir();
    public T GetPorID(int id, TipoCompetidor... filtroTipo);
}
