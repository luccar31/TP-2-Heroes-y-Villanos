package com.heroesvillanos.servicios;

import com.heroesvillanos.dominio.Personaje;
import com.heroesvillanos.dominio.TipoCompetidor;

import java.util.List;

public interface IServicioPersonajes {
    List<Personaje> cargar();
    List<Personaje> listar();
    Personaje crear(String nombreReal, String alias, TipoCompetidor tipo,
                    int vel, int fue, int res, int des);

    void persistir();
}
