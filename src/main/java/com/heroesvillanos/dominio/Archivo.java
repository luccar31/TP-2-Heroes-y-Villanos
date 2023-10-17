package com.heroesvillanos.dominio;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Archivo {
	
	public static List<Personaje<?>> leerPersonajes() throws IOException {
		
		List<Personaje<?>> personajes = new ArrayList<Personaje<?>>();
		
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
					Heroe heroe = new Heroe(tipo, nombreReal, nombrePersonaje, caracteristicas);
					personajes.add(heroe);
					// Falta agregarlo a la lista de Heroes
				} else if ( tipo.equals("Villano")) {
					Villano villano = new Villano(tipo, nombreReal, nombrePersonaje, caracteristicas);
					personajes.add(villano);
					// Falta agregarlo a la lsita de Villanos
					}
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
		/*for (Personaje<?> personaje : personajes) {
			
			System.out.println(personaje);
		}*/
		return personajes;
	}
	
	public static void grabarPersonajes(List<Personaje<?>> personaje) {
		FileWriter file = null;
		PrintWriter printWriter = null;
		
		try {
			file = new FileWriter("src/main/resources/personajes.in");
			
			printWriter = new PrintWriter(file);
			for (Personaje<?> personajes : personaje) {
				printWriter.println(personajes.getTipo() + "," + personajes.getNombreReal() + "," + 
						personajes.getAlias() + "," + personajes.getCaracteristica(Caracteristica.VELOCIDAD) + 
						"," + personajes.getCaracteristica(Caracteristica.FUERZA) + "," + personajes.getCaracteristica(Caracteristica.RESISTENCIA) +
						"," + personajes.getCaracteristica(Caracteristica.RESISTENCIA) + "," + personajes.getCaracteristica(Caracteristica.DESTREZA));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (file != null) {
				try {
					file.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
