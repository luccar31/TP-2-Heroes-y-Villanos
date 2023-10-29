package com.heroesvillanos;

import java.io.File;

import com.heroesvillanos.dominio.*;

public class Principal {
    public static void main(String[] args) {
        Menu menu = Menu.getInstance();
        menu.menu();
        
		
        Persistencia<Personaje> persistencia = new PersistenciaPersonajesEnArchivo("personajes");
        Repositorio<Personaje> repositorio = new RepositorioPersonajeEnMemoria();
        IServicioPersonajes servicioPersonajes = new ServicioPersonajes(repositorio, persistencia);
        servicioPersonajes.cargarPersonajes();
        servicioPersonajes.listarPersonajes();
        
        //LIGAS
        Persistencia<Liga> persistenciaLigas = new PersistenciaLigasEnArchivo("ligas");
        Repositorio<Liga> repositorioLigas = new RepositorioLigasEnMemoria();
        IServiciosLigas servicioLigas = new ServicioLigas(repositorioLigas, persistenciaLigas);
        servicioLigas.cargarLiga();
        servicioLigas.listarLigas();
        
    }
}
