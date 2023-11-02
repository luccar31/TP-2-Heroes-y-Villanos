package com.heroesvillanos.persistencia;

import com.heroesvillanos.dominio.Personaje;
import com.heroesvillanos.dominio.PersonajeDto;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersistenciaPersonajesEnArchivo implements Persistencia<PersonajeDto, Personaje> {

    private final File file;
    public PersistenciaPersonajesEnArchivo(String filename) {
        file = new File(filename);
    }

    public List<PersonajeDto> leerDatos() {
        List<PersonajeDto> datos = new ArrayList<PersonajeDto>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                datos.add(crearDto(scanner.nextLine()));
            }
        }
        catch (IOException | IllegalStateException e) {
            e.printStackTrace();
        }
        finally {
            if(scanner != null){
                scanner.close();
            }
        }

        return datos;
    }

    private PersonajeDto crearDto(String dato) {
        String[] partes = dato.split(",");

        String tipo = partes[0].trim(); // Heroe o Villano?
        String nombreReal = partes[1].trim(); // Nombre Real
        String nombrePersonaje = partes[2].trim(); // Nombre Personaje
        int velocidad = Integer.parseInt(partes[3].trim()); // Velocidad
        int fuerza = Integer.parseInt(partes[4].trim()); // Fuerza
        int resistencia = Integer.parseInt(partes[5].trim()); // Resistencia
        int destreza = Integer.parseInt(partes[6].trim()); // Destreza

        return new PersonajeDto(nombreReal, nombrePersonaje, tipo, velocidad, fuerza, resistencia, destreza);
    }

    public void guardar(List<Personaje> personajes) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(file);

            for (Personaje personaje : personajes) {
                writer.write(personaje.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try{
                    writer.close();
                }
                catch (Exception e){
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
