package com.heroesvillanos.dominio;

import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class PersistenciaPersonajesEnArchivo implements Persistencia<Personaje> {

    public PersistenciaPersonajesEnArchivo() {
    }

    public List<Personaje> cargar() {
        List<Personaje> personajes = new ArrayList<Personaje>();
        Scanner scanner = null;
        String fileName = "src/main/resources/archivos/personajes.in";
		File file = null; 
        int id = 0;
        try {
        	file = new File(fileName);
            scanner = new Scanner(file);
            String linea;

            while (scanner.hasNextLine()) {
                linea = scanner.nextLine();
                String[] partes = linea.split(",");

                for (int i = 0; i < partes.length; i++)
                    partes[i] = partes[i].trim();

                String tipo = partes[0]; // Heroe o Villano?
                String nombreReal = partes[1]; // Nombre Real
                String nombrePersonaje = partes[2]; // Nombre Personaje
                int velocidad = Integer.parseInt(partes[3]); // Velocidad
                int fuerza = Integer.parseInt(partes[4]); // Fuerza
                int resistencia = Integer.parseInt(partes[5]); // Resistencia
                int destreza = Integer.parseInt(partes[6]); // Destreza

                personajes.add(new Personaje(id, nombreReal, nombrePersonaje, TipoCompetidor.obtenerPor(tipo),
                        velocidad, fuerza, resistencia, destreza));
                id++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(scanner != null){
                scanner.close();
            }
        }

        return personajes;
    }

    public void guardar(List<Personaje> personajes) {
        String fileName = "src/main/resources/archivos/personajes.in";
        FileWriter file = null;

        try {
            file = new FileWriter(fileName);

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
