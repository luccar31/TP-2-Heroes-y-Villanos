package com.heroesvillanos.dominio;

import java.util.List;

public interface IServicioReportes {
    List<Personaje> ordenarPersonajesPor(DireccionOrden direccionOrden, Caracteristica... caracteristicas);
    List<Competidor> competidoresQueVenzan(int id);
}
