package com.heroesvillanos.dominio;

import java.util.List;

public class ServicioLigas implements IServiciosLigas{
	
    private final Repositorio<Liga> repositorio;
    private final Persistencia<Liga> persistencia;
    
    
    public ServicioLigas(Repositorio<Liga> repositorio, Persistencia<Liga> persistencia){
        this.repositorio = repositorio;
        this.persistencia = persistencia;
    }
    
    public void cargarLiga() {
        for(Liga l : persistencia.cargar()){
            repositorio.guardar(l);
        }
    }

    public List<Liga> listarLigas() {
        return repositorio.listar();
    }

    public Liga crearLiga(TipoCompetidor tipo) {
        Liga liga = new Liga(tipo);
        repositorio.guardar(liga);
        return liga;
    }

    public void guardarLigas() {
        persistencia.guardar(repositorio.listar());
    }
}
