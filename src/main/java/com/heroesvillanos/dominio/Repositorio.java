package com.heroesvillanos.dominio;

import java.util.List;

public interface Repositorio<T> {
    List<T> listar();
    void guardar(T entidad);
}
