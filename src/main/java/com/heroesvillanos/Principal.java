package com.heroesvillanos;

import com.heroesvillanos.dominio.Liga;
import com.heroesvillanos.dominio.LigaDto;
import com.heroesvillanos.dominio.Personaje;
import com.heroesvillanos.dominio.PersonajeDto;
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

        Persistencia<PersonajeDto, Personaje> personajePersistencia = new PersistenciaPersonajesEnArchivo("src/main/resources/archivos/personajes.in");
        Persistencia<LigaDto, Liga> ligaPersistencia = new PersistenciaLigasEnArchivo("src/main/resources/archivos/ligas.in");

        IServicioPersonajes servicioPersonajes = new ServicioPersonajes(personajeRepositorio, personajePersistencia);
        IServiciosLigas serviciosLigas = new ServicioLigas(ligaRepositorio, personajeRepositorio, ligaPersistencia);

        //LIGAS
        serviciosLigas.cargar();
        serviciosLigas.listar();

    }
}
