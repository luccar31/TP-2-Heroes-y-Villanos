package com.heroesvillanos.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.heroesvillanos.dominio.Archivo.TipoArchivo;

public class PersistenciaLigasEnArchivo implements Persistencia<Liga> {

	private final Archivo archivo;

	public PersistenciaLigasEnArchivo(String nombreArchivo) {
		this.archivo = new Archivo(nombreArchivo);
	}

	public List<Liga> cargar() {
		List<Liga> ligas = new ArrayList<Liga>();
		Scanner scanner = null;

		try {
			scanner = new Scanner(archivo.crearFile(TipoArchivo.ENTRADA));
			String linea;

			while (scanner.hasNextLine()) {
				linea = scanner.nextLine();
				String[] partes = linea.split(",");

				for (int i = 0; i < partes.length; i++)
					partes[i] = partes[i].trim();

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
		return ligas;
	}

	public void guardar(List<Liga> lista) {
		// TODO Auto-generated method stub

	}
}
