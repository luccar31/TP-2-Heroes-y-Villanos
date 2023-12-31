package com.heroesvillanos;

import com.heroesvillanos.dominio.Liga;
import com.heroesvillanos.dominio.Personaje;
import com.heroesvillanos.dominio.RegistroLiga;
import com.heroesvillanos.dominio.RegistroPersonaje;
import com.heroesvillanos.menu.MenuBase;
import com.heroesvillanos.persistencia.Persistencia;
import com.heroesvillanos.persistencia.PersistenciaLigasEnArchivo;
import com.heroesvillanos.persistencia.PersistenciaPersonajesEnArchivo;
import com.heroesvillanos.repositorio.Repositorio;
import com.heroesvillanos.repositorio.RepositorioLigasEnMemoria;
import com.heroesvillanos.repositorio.RepositorioPersonajeEnMemoria;
import com.heroesvillanos.servicios.*;

public final class Principal {
    private static IServicioPersonajes servicioPersonajes;
    private static IServiciosLigas serviciosLigas;
    private static IServicioReportes servicioReportes;

    public static void main(String[] args) {

        Init();
        MenuBase menu = new MenuBase();
        menu.desplegarMenuPrincipal();
    }

    private static void Init() {

        Repositorio<Personaje> personajeRepositorio = new RepositorioPersonajeEnMemoria();
        Repositorio<Liga> ligaRepositorio = new RepositorioLigasEnMemoria();

        Persistencia<RegistroPersonaje, Personaje> personajePersistencia = new PersistenciaPersonajesEnArchivo("src/main/resources/archivos/personajes.in");
        Persistencia<RegistroLiga, Liga> ligaPersistencia = new PersistenciaLigasEnArchivo("src/main/resources/archivos/ligas.in");

        servicioPersonajes = new ServicioPersonajes(personajeRepositorio, personajePersistencia);
        serviciosLigas = new ServicioLigas(ligaRepositorio, personajeRepositorio, ligaPersistencia);
        servicioReportes = new ServicioReportes(personajeRepositorio, ligaRepositorio);
    }

    public static IServicioPersonajes getServicioPersonajesInstance() {
        if (servicioPersonajes == null) {
            Init();
        }
        return servicioPersonajes;
    }

    public static IServiciosLigas getServicioLigasInstance() {
        if (serviciosLigas == null) {
            Init();
        }
        return serviciosLigas;
    }

    public static IServicioReportes getServicioReportesInstance() {
        if (servicioReportes == null) {
            Init();
        }
        return servicioReportes;
    }
}
