package com.heroesvillanos.servicios;

import com.heroesvillanos.dominio.Personaje;
import com.heroesvillanos.dominio.TipoCompetidor;

import java.util.List;

public interface IServicioPersonajes {
    void cargarPersonajes();
    List<Personaje> listarPersonajes();
    Personaje crearPersonaje(String nombreReal, String alias, TipoCompetidor tipo,
                             int vel, int fue, int res, int des);

    void guardarPersonajes();
}
