package com.heroesvillanos.dominio;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

import java.io.File;

public class Archivo {
	
	public static List<Competidor<?>> leerPersonajes() throws IOException {
		
		List<Competidor<?>> competidores = new ArrayList<Competidor<?>>();
		
		Scanner scanner = null;
		
		try {
			File file = new File("src/main/resources/personajes.in");
			scanner = new Scanner(file);
			scanner.useLocale(Locale.ENGLISH);
			String linea;
			
			while (scanner.hasNextLine()) {
				linea = scanner.nextLine();
				String[] partes = linea.split("\\,");
				
				for (int i = 0; i < partes.length; i++)
				    partes[i] = partes[i].trim();

				String tipo = partes[0]; // Heroe o Villano?
				String nombreReal = partes[1]; // Nombre Real
				String nombrePersonaje = partes[2]; // Nombre Personaje
				int velocidad = Integer.parseInt(partes[3]); // Velocidad
				int fuerza = Integer.parseInt(partes[4]); // Fuerza
				int resistencia = Integer.parseInt(partes[5]); // Resistencia
				int destreza = Integer.parseInt(partes[6]); // Destreza
				
				Map<Caracteristica, Integer> caracteristicas = new HashMap<Caracteristica, Integer>();
				caracteristicas.put(Caracteristica.VELOCIDAD, velocidad);
				caracteristicas.put(Caracteristica.FUERZA, fuerza);				
				caracteristicas.put(Caracteristica.RESISTENCIA, resistencia);				
				caracteristicas.put(Caracteristica.DESTREZA, destreza);			
				
				if( tipo.equals("Héroe")) {
					Heroe heroe = new Heroe(nombreReal, nombrePersonaje, caracteristicas);
					competidores.add(heroe);
				} else if ( tipo.equals("Villano")) {
					Villano villano = new Villano(nombreReal, nombrePersonaje, caracteristicas);
					competidores.add(villano);
					}
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
		/*for (Competidor<?> competidor : competidores) {
			
			System.out.println(competidor);
		}*/
		return competidores;
	}

}
