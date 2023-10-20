package com.heroesvillanos;

import com.heroesvillanos.dominio.*;

public class Principal {
    public static void main(String[] args) {
        Menu menu = Menu.getInstance();
        menu.menu();

        Persistencia<Personaje> persistencia = new PersistenciaPersonajesEnArchivo("personaje1");
        Repositorio<Personaje> repositorio = new RepositorioPersonajeEnMemoria();
        IServicioPersonajes servicioPersonajes = new ServicioPersonajes(repositorio, persistencia);
        servicioPersonajes.cargarPersonajes();
        servicioPersonajes.listarPersonajes();
    }
}
