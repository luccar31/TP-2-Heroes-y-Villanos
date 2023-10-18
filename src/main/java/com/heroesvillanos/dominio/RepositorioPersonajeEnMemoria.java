package com.heroesvillanos.dominio;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

import java.io.File;

public class RepositorioPersonajeEnMemoria implements RepositorioPersonaje{

    private final EntradaDatos entradaDatos;
    private List<Personaje> personajes;

    public RepositorioPersonajeEnMemoria(EntradaDatos entradaDatos){
        this.entradaDatos = entradaDatos;
        personajes = entradaDatos.cargarPersonajes();
    }

    public List<Personaje> obtenerTodosLosPersonajes() {
        return personajes;
    }

}
