package com.heroesvillanos;

import java.io.File;

import com.heroesvillanos.dominio.*;

public class Principal {
    public static void main(String[] args) {
        Menu menu = Menu.getInstance();
        menu.menu();

        Repositorio<Personaje> personajeRepositorio = new RepositorioPersonajeEnMemoria();
        Repositorio<Liga> ligaRepositorio = new RepositorioLigasEnMemoria();
		
        Persistencia<Personaje> personajePersistencia = new PersistenciaPersonajesEnArchivo();
        Persistencia<Liga> ligaPersistencia = new PersistenciaLigasEnArchivo(personajeRepositorio);

        IServicioPersonajes servicioPersonajes = new ServicioPersonajes(personajeRepositorio, personajePersistencia);
        IServiciosLigas serviciosLigas = new ServicioLigas(ligaRepositorio, ligaPersistencia, personajeRepositorio);

        //LIGAS
        serviciosLigas.cargarLiga();
        serviciosLigas.listarLigas();
        
    }
}
