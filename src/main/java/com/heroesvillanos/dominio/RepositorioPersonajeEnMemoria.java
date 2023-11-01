package com.heroesvillanos.dominio;

import java.util.ArrayList;
import java.util.List;

public class RepositorioPersonajeEnMemoria implements Repositorio<Personaje> {
    private final List<Personaje> personajes;

    public RepositorioPersonajeEnMemoria() {
        this.personajes = new ArrayList<Personaje>();
    }

    public List<Personaje> listar() {
        return personajes;
    }

    public void guardar(Personaje entidad) {
        this.personajes.add(entidad);
    }

    public Personaje obtenerPorNombre(String alias) {
        Personaje busqueda = null;
        for (Personaje personaje : personajes) {
            if (personaje.getAlias().equals(alias)) {
                busqueda = personaje;
            }
        }
        return busqueda;
    }

}
