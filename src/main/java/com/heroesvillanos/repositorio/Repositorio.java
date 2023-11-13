package com.heroesvillanos.repositorio;

import java.util.List;

public interface Repositorio<T> {
    List<T> listar();

    void guardar(T entidad);

    T obtenerPorNombreCompetidor(String nombreCompetidor);

    T obtenerPorIdentificador(int id);
}
