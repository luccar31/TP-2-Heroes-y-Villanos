package com.heroesvillanos.servicios;

import com.heroesvillanos.comparators.PersonajeCaracteristicaComparator;
import com.heroesvillanos.dominio.*;
import com.heroesvillanos.repositorio.Repositorio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ServicioReportes implements IServicioReportes{

    private Repositorio<Personaje> repositorioPersonajes;
    private Repositorio<Liga> repositorioLigas;

    public ServicioReportes(Repositorio<Personaje> repositorioPersonajes, Repositorio<Liga> repositorioLigas){
        this.repositorioPersonajes = repositorioPersonajes;
        this.repositorioLigas = repositorioLigas;
    }

    public List<Personaje> ordenarPersonajesPor(DireccionOrden direccionOrden, Caracteristica... caracteristicas){
        List<Personaje> personajes = new ArrayList<>(repositorioPersonajes.listar());
        Comparator<Personaje> comparator = new PersonajeCaracteristicaComparator(direccionOrden, caracteristicas);
        personajes.sort(comparator);
        return personajes;
    }

    public List<Competidor> competidoresQueVenzan(int id){
        Personaje personaje = repositorioPersonajes.obtenerPorIdentificador(id);
        List<Competidor> competidores = new ArrayList<>();
        competidores.addAll(repositorioPersonajes.listar());
        competidores.addAll(repositorioLigas.listar());

        for (Competidor c : competidores){
            if(!c.esGanador(personaje)){
                competidores.remove(c);
            }
        }

        return competidores;
    }
}
