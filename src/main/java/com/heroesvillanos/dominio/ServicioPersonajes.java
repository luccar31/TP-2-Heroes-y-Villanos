package com.heroesvillanos.dominio;

import java.util.List;

public class ServicioPersonajes implements IServicioPersonajes {

    private final Repositorio<Personaje> repositorio;
    private final Persistencia<Personaje> persistencia;

    public ServicioPersonajes(Repositorio<Personaje> repositorio, Persistencia<Personaje> persistencia){
        this.repositorio = repositorio;
        this.persistencia = persistencia;
    }

    public void cargarPersonajes() {
        for(Personaje p : persistencia.cargar()){
            repositorio.guardar(p);
        }
    }

    public List<Personaje> listarPersonajes() {
        return repositorio.listar();
    }

    public Personaje crearPersonaje(String nombreReal, String alias, TipoCompetidor tipo, int vel, int fue, int res, int des) {
        int id = repositorio.listar().get(repositorio.listar().size()).getId() + 1;
        Personaje personaje = new Personaje(id, nombreReal, alias, tipo, vel, fue, res, des);
        repositorio.guardar(personaje);
        return personaje;
    }

    public void guardarPersonajes() {
        persistencia.guardar(repositorio.listar());
    }
}
