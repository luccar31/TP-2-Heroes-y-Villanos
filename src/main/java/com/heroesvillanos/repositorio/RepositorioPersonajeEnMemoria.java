package com.heroesvillanos.repositorio;

import com.heroesvillanos.dominio.Personaje;

import java.util.ArrayList;
import java.util.List;

public class RepositorioPersonajeEnMemoria implements Repositorio<Personaje> {
    private final List<Personaje> personajes;

    public RepositorioPersonajeEnMemoria() {
        this.personajes = new ArrayList<Personaje>();
    }

    @Override
    public List<Personaje> listar() {
        return personajes;
    }

    @Override
    public void guardar(Personaje entidad) {
        this.personajes.add(entidad);
    }

    public Personaje obtenerPorNombre(String nombre) {
        Personaje busqueda = null;
        for (Personaje personaje : personajes) {
            if (personaje.getNombreReal().equals(nombre)) {
                busqueda = personaje;
            }
        }
        return busqueda;
    }

    @Override
    public Personaje obtenerPorIdentificador(int id) {
        Personaje encontrado = null;
        for (Personaje p : this.personajes) {
            if (p.getId() == id) {
                encontrado = p;
            }
        }
        return encontrado;
    }

}
