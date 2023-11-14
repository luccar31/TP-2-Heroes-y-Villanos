package com.heroesvillanos.persistencia;

import com.heroesvillanos.dominio.Personaje;
import com.heroesvillanos.dominio.RegistroPersonaje;
import com.heroesvillanos.exception.FormatoArchivoInvalidoException;
import com.heroesvillanos.exception.LecturaDeArchivoException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersistenciaPersonajesEnArchivo implements Persistencia<RegistroPersonaje, Personaje> {

    private final File file;

    public PersistenciaPersonajesEnArchivo(String filename) {
        file = new File(filename);
    }

    public List<RegistroPersonaje> leerDatos() {
        List<RegistroPersonaje> datos = new ArrayList<RegistroPersonaje>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                datos.add(crearDto(scanner.nextLine()));
            }
        } catch (IOException e) {
            throw new LecturaDeArchivoException(e);
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        return datos;
    }

    private RegistroPersonaje crearDto(String dato) {
        //si el formato de la linea es valido se puede demostrar con
        //esta expresion regular ^(Heroe|Villano),[^,]+,[^,]+,\d+,\d+,\d+,\d+$
        try {
            String[] partes = dato.split(",");

            for (int i = 0; i < partes.length; i++) {
                String trimmed = partes[i].trim();
                if (trimmed.isEmpty()) {
                    throw new RuntimeException("Cadena vacia");
                }
                partes[i] = trimmed;
            }

            String tipo = partes[0]; // Heroe o Villano?
            String nombreReal = partes[1]; // Nombre Real
            String nombrePersonaje = partes[2]; // Nombre Personaje
            int velocidad = Integer.parseInt(partes[3]); // Velocidad
            int fuerza = Integer.parseInt(partes[4]); // Fuerza
            int resistencia = Integer.parseInt(partes[5]); // Resistencia
            int destreza = Integer.parseInt(partes[6]); // Destreza

            return new RegistroPersonaje(nombreReal, nombrePersonaje, tipo, velocidad, fuerza, resistencia, destreza);
        } catch (Exception e) {
            throw new FormatoArchivoInvalidoException(e);
        }
    }

    public void guardar(List<Personaje> personajes) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(file);

            for (Personaje personaje : personajes) {
                writer.write(personaje.toString() + "\n");
            }
        } catch (IOException e) {
            throw new LecturaDeArchivoException(e);
        } finally {
            cerrarWriter(writer);
        }

    }

    private void cerrarWriter(FileWriter writer) {
        if (writer != null) {
            try {
                writer.close();
            } catch (IOException e) {
                throw new LecturaDeArchivoException(e);
            }
        }
    }
}
