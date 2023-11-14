package com.heroesvillanos.servicios;

import com.heroesvillanos.dominio.Personaje;
import com.heroesvillanos.dominio.TipoCompetidor;

import java.util.List;

public interface IServicioPersonajes extends IServicioCompetidores<Personaje> {
    List<Personaje> cargar();

    List<Personaje> listar(TipoCompetidor... filtroTipo);

    void printLista(String header, TipoCompetidor... filtroTipo);

    Personaje crear(String nombreReal, String alias, TipoCompetidor tipo,
                    int vel, int fue, int res, int des);

    void persistir();

    Personaje getPorID(int id, TipoCompetidor... filtroTipo);
}
