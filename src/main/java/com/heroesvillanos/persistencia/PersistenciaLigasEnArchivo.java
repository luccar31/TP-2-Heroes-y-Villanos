package com.heroesvillanos.persistencia;

import com.heroesvillanos.dominio.Liga;
import com.heroesvillanos.dominio.RegistroLiga;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersistenciaLigasEnArchivo implements Persistencia<RegistroLiga, Liga> {

    private final File file;

    public PersistenciaLigasEnArchivo(String filepath) {
        file = new File(filepath);
    }

    @Override
    public List<RegistroLiga> leerDatos() {
        List<RegistroLiga> datos = new ArrayList<>();
        Scanner scanner = null;

        try {
            scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                datos.add(crearDto(scanner.nextLine()));
            }

        } catch (IOException | IllegalStateException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        return datos;
    }

    private RegistroLiga crearDto(String linea) {
        String[] campos = linea.split(",");
        String[] competidores = new String[campos.length];
        for (int i = 1; i < campos.length; i++) {
            competidores[i - 1] = campos[i].trim();
        }
        return new RegistroLiga(campos[0].trim(), competidores);
    }

    @Override
    public void guardar(List<Liga> ligas) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(file);

            for (Liga liga : ligas) {
                writer.write(liga.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
