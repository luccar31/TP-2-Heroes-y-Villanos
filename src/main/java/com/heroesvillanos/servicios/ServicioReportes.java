package com.heroesvillanos.servicios;

import com.heroesvillanos.comparators.PersonajeCaracteristicaComparator;
import com.heroesvillanos.dominio.*;
import com.heroesvillanos.exception.CompetidorNoEncontrado;
import com.heroesvillanos.repositorio.Repositorio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ServicioReportes implements IServicioReportes {

    private final Repositorio<Personaje> repositorioPersonajes;
    private final Repositorio<Liga> repositorioLigas;

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

        if (personaje == null) {
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
    
    public void printLista (List<Personaje> lista) {

		if (lista.isEmpty()) {
			System.out.println("-----------------------------------------------");
			System.out.println("Nada que mostrar. Volviendo...");
			System.out.println("-----------------------------------------------");
			return;
		}
    	
    	System.out.println("-----------------------------------------------------------------------------------------------------");
		System.out.printf("%-3s %-8s %-20s %-20s %-7s %-7s %-7s %-7s%n", "ID", "| Tipo", "| Nombre Real", "| Alias", "| Velocidad", "| Fuerza", "| Resistencia", "|Destreza");
		System.out.println("-----------------------------------------------------------------------------------------------------");
		for (Personaje c : lista) {
			//String[] results = l.toString().split(","); 
			System.out.printf("%-3s %-8s %-20s %-20s %-11s %-8s %-13s %-7s%n", 	  c.getId(), "|"
																				+ c.getTipo(), "|" 
																				+ c.getNombreReal(), "|" 
																				+ c.getAlias(), "|" 
																				+ c.getCaracteristica(Caracteristica.VELOCIDAD), "|" 
																				+ c.getCaracteristica(Caracteristica.FUERZA), "|" 
																				+ c.getCaracteristica(Caracteristica.RESISTENCIA), "|" 
																				+ c.getCaracteristica(Caracteristica.DESTREZA));
		}
		System.out.println("-----------------------------------------------------------------------------------------------");
    }
    
    private boolean personajeValido(Personaje personaje, Competidor competidor) {
        return !competidor.equals(personaje) && competidor.getTipo() != personaje.getTipo();
    }
}
