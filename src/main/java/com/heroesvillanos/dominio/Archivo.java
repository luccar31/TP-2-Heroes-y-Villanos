package com.heroesvillanos.dominio;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;

public class Archivo implements EntradaDatos, SalidaDatos {

    private File archivo;

    public Archivo(String filename){
        ClassLoader classloader = this.getClass().getClassLoader();
        URL recurso = classloader.getResource("archivos" + File.separator + filename + ".in");
        if (recurso != null){
            this.archivo = new File(recurso.getPath());
        }
        else{
            throw new RuntimeException();
        }
    }

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

    public void guardarPersonajes(List<Personaje> personajes) {
        FileWriter file = null;

        try {
            file = new FileWriter("src/main/resources/personajes.in");

            for (Personaje personaje : personajes) {
                String linea = String.format("%s,%s,%s,%n,%d,%d,%d,%d\n",
                        personaje.getTipo(),
                        personaje.getNombreReal(),
                        personaje.getAlias(),
                        personaje.getCaracteristica(Caracteristica.VELOCIDAD),
                        personaje.getCaracteristica(Caracteristica.FUERZA),
                        personaje.getCaracteristica(Caracteristica.RESISTENCIA),
                        personaje.getCaracteristica(Caracteristica.DESTREZA)
                );
                file.write(linea);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (file != null) {
                try{
                    file.close();
                }
                catch (Exception e){
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
