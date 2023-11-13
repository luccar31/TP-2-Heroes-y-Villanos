package com.heroesvillanos.servicios;

import com.heroesvillanos.comparators.PersonajeCaracteristicaComparator;
import com.heroesvillanos.dominio.*;
import com.heroesvillanos.exception.CompetidorNoEncontrado;
import com.heroesvillanos.repositorio.Repositorio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ServicioReportes implements IServicioReportes {

    private Repositorio<Personaje> repositorioPersonajes;
    private Repositorio<Liga> repositorioLigas;

    public ServicioReportes(Repositorio<Personaje> repositorioPersonajes, Repositorio<Liga> repositorioLigas) {
        this.repositorioPersonajes = repositorioPersonajes;
        this.repositorioLigas = repositorioLigas;
    }

    public List<Personaje> ordenarPersonajesPor(DireccionOrden direccionOrden, Caracteristica... caracteristicas) {
        List<Personaje> personajes = new ArrayList<>(repositorioPersonajes.listar());
        Comparator<Personaje> comparator = new PersonajeCaracteristicaComparator(direccionOrden, caracteristicas);
        personajes.sort(comparator);
        return personajes;
    }

    public List<Competidor> competidoresQueVenzan(String nombre, Caracteristica caracteristica) {
        Personaje personaje = repositorioPersonajes.obtenerPorNombre(nombre);

        if(personaje == null){
            throw new CompetidorNoEncontrado();
        }

        List<Competidor> leGanan = new ArrayList<>();

        List<Competidor> competidores = new ArrayList<>();
        competidores.addAll(repositorioPersonajes.listar());
        competidores.addAll(repositorioLigas.listar());

        for (Competidor competidor : competidores) {
            if (personajeValido(personaje, competidor))
                if (competidor.esGanador(personaje, caracteristica)) {
                    leGanan.add(competidor);
                }
        }

        return leGanan;
    }

    private boolean personajeValido(Personaje personaje, Competidor competidor) {
        return !competidor.equals(personaje) && competidor.getTipo() != personaje.getTipo();
    }
}
