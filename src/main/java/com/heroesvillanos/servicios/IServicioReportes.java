package com.heroesvillanos.servicios;

import com.heroesvillanos.dominio.Caracteristica;
import com.heroesvillanos.dominio.Competidor;
import com.heroesvillanos.dominio.DireccionOrden;
import com.heroesvillanos.dominio.Personaje;

import java.util.List;

public interface IServicioReportes {
    List<Personaje> ordenarPersonajesPor(DireccionOrden direccionOrden, Caracteristica... caracteristicas);

    List<Competidor> competidoresQueVenzan(String nombre, Caracteristica caracteristica);

    void printLista(List<Personaje> lista);
}
