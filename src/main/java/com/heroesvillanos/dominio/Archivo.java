package com.heroesvillanos.dominio;

import java.io.File;
import java.util.*;

public class Archivo implements EntradaDatos {
    public List<Personaje> cargarPersonajes() {
        List<Personaje> personajes = new ArrayList<Personaje>();

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

                personajes.add(new Personaje(nombreReal, nombrePersonaje, TipoCompetidor.obtenerPor(tipo),
                        caracteristicas));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }

        return personajes;
    }
}
