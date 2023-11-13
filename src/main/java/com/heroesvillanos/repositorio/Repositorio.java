package com.heroesvillanos.repositorio;

import java.util.List;

public interface Repositorio<T> {
    List<T> listar();

    void guardar(T entidad);

    T obtenerPorNombre(String nombre);

    T obtenerPorIdentificador(int id);
}
