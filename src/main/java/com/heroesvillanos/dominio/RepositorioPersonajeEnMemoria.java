package com.heroesvillanos.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

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

    @Override
    public Personaje obtenerPorIdentificador(int id) {
        Personaje encontrado = null;
        for(Personaje p : this.personajes){
            if(p.getId() == id){
                encontrado = p;
            }
        }
        if(encontrado == null){
            throw new NoSuchElementException("No se encontró el personaje con id: " + id);
        }
        return encontrado;
    }

}
