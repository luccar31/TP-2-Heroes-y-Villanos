package com.heroesvillanos.dominio;

import java.util.List;

public interface Persistencia<T> {
    List<T> cargar();
    void guardar(List<T> lista);
}
