package com.heroesvillanos;

import com.heroesvillanos.dominio.*;
import com.heroesvillanos.persistencia.Persistencia;
import com.heroesvillanos.persistencia.PersistenciaLigasEnArchivo;
import com.heroesvillanos.persistencia.PersistenciaPersonajesEnArchivo;
import com.heroesvillanos.repositorio.Repositorio;
import com.heroesvillanos.repositorio.RepositorioLigasEnMemoria;
import com.heroesvillanos.repositorio.RepositorioPersonajeEnMemoria;
import com.heroesvillanos.servicios.IServicioPersonajes;
import com.heroesvillanos.servicios.IServiciosLigas;
import com.heroesvillanos.servicios.ServicioLigas;
import com.heroesvillanos.servicios.ServicioPersonajes;

public class Principal {
    public static void main(String[] args) {

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
