package com.heroesvillanos.persistencia;

import java.util.List;

public interface Persistencia<Dto, Entidad> {
    List<Dto> leerDatos();
    void guardar(List<Entidad> datos);
}
