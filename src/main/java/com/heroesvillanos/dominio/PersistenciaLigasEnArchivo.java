package com.heroesvillanos.dominio;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.heroesvillanos.dominio.Archivo.TipoArchivo;

public class PersistenciaLigasEnArchivo implements Persistencia<Liga> {

	private final Archivo archivo;

	public PersistenciaLigasEnArchivo(String nombreArchivo) {
		this.archivo = new Archivo(nombreArchivo);
	}

	public List<Liga> cargar(List<Personaje> personajes) {
		List<Liga> ligas = new ArrayList<Liga>();
		Scanner scanner = null;
		String fileName = "src/main/resources/archivos/ligas.in";
		File file = null;

		try {
			file = new File(fileName);
			scanner = new Scanner(file);
			String linea;
			ArrayList<String> nombreLigas = new ArrayList<String>();
			String tipo;

			while (scanner.hasNextLine()) {
				linea = scanner.nextLine();
				String[] partes = linea.split(",");

				for (int i = 0; i < partes.length; i++) {
					partes[i] = partes[i].trim();

					// Preguntar si hay que validar si un personaje esta en una liga antes o
					// despues.
					if (!nombreLigas.isEmpty()) {
						for (String string : nombreLigas) {
							if (!string.equals(partes[i])) {
								nombrePersonaje = partes[i];
							}
						}
					}

				}
				nombreLigas.add(partes[0]);
				;
				ligas.add(new Liga(nombreReal, nombrePersonaje, TipoCompetidor.obtenerPor(tipo), velocidad, fuerza,
						resistencia, destreza));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
		for (Liga liga : ligas) {
			System.out.println(liga);
		}
		return ligas;
	}

	public void guardar(List<Liga> lista) {
		// TODO Auto-generated method stub

	}
}
