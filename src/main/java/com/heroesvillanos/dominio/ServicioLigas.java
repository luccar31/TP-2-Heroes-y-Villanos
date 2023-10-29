package com.heroesvillanos.dominio;

import java.util.List;

public class ServicioLigas implements IServiciosLigas{
	
    private final Repositorio<Liga> repositorio;
    private final Persistencia<Liga> persistencia;
    private final Repositorio<Personaje> personajes;
    
    public ServicioLigas(Repositorio<Liga> repositorio, Persistencia<Liga> persistencia,Repositorio<Personaje> personajes){
        this.repositorio = repositorio;
        this.persistencia = persistencia;
        this.personajes = personajes;
    }
    
    public void cargarLiga() {
        for(Liga l : persistencia.cargar(personajes.listar())){
            repositorio.guardar(l);
        }
    }

    public List<Liga> listarLigas() {
        return repositorio.listar();
    }

    public Liga crearLiga(TipoCompetidor tipo, String nombre, int id) {
        Liga liga = new Liga(tipo,nombre,id);
        repositorio.guardar(liga);
        return liga;
    }

    public void guardarLigas() {
        persistencia.guardar(repositorio.listar());
    }
}
