package com.heroesvillanos.dominio;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class PersistenciaLigasEnArchivo implements Persistencia<Liga> {

	private final Repositorio<Personaje> personajeRepositorio;

	public PersistenciaLigasEnArchivo(Repositorio<Personaje> personajeRepositorio) {
		this.personajeRepositorio = personajeRepositorio;
	}

	public List<Liga> cargar() {

		List<Liga> ligas = new ArrayList<Liga>();

		Scanner scanner = null;
		String fileName = "src/main/resources/archivos/ligas.in";
		File file;

		try {
			file = new File(fileName);
			scanner = new Scanner(file);

			//leer linea, buscar en la lista de ligas por si hay un nombre de liga que ya existe
			int id = 0;
			while (scanner.hasNextLine()) {
				LigaDto ligaDto = crearDto(scanner.nextLine());

				//buscamos si ya existe el nombre de la liga en las ligas ya dadas de alta
				for(Liga liga : ligas){
					if(liga.getNombre().equals(ligaDto.getNombre())){
						//excepcion porque ya existe la liga en la lista de ligas hasta ahora cargadas
						throw new IllegalArgumentException();
					}
				}

				TipoCompetidor tipoCompetidor = null;

				//para los nombres restantes buscamos si son ligas o son personajes,
				//y creamos una lista de competidores
				List<Competidor> competidores = new ArrayList<Competidor>();
				for(String nombreCompetidor : ligaDto.getNombreCompetidores()){
					Competidor c = obtenerCompetidor(nombreCompetidor, ligas);

					//si no se encuentra ningun competidor con tal nombre
					if(c == null){
						//excepcion porque no existe ningun competidor con tal nombre
						throw new NoSuchElementException();
					}

					competidores.add(c);
				}

				ligas.add(new Liga(competidores.get(0).getTipo(), ligaDto.getNombre(),
						id++, competidores.toArray(competidores.toArray(new Competidor[0]))));
			}

		}
		catch (IOException e) {
			ligas.clear();
		}
		finally {
			if (scanner != null) {
				scanner.close();
			}
		}
		return ligas;
	}

	//consideraciones
	//no se puede tener ligas y personajes que se llamen igual
	//los personajes deben estar previamente cargados, sino esto tira excepcion
	private Competidor obtenerCompetidor(String nombreCompetidor, List<Liga> ligas) {
		Competidor c = null;
		//verificamos lista de ligas ya creadas para ver si encontramos si ya estaba cargada
		c = obtenerLigaPorNombre(nombreCompetidor, ligas);

		//si se encontro retorno la liga
		if(c != null){
			return c;
		}

		//verificamos repositorio de personajes para comprobar
		// si hay un personaje que coincida con el nombre pasado
		c = personajeRepositorio.obtenerPorNombre(nombreCompetidor);

		return c;
	}

	private Liga obtenerLigaPorNombre(String nombreCompetidor, List<Liga> ligas) {
		Liga busqueda = null;
		for(Liga liga : ligas){
			if(liga.getNombre().equals(nombreCompetidor)){
				busqueda = liga;
			}
		}
		return busqueda;
	}

	private LigaDto crearDto(String linea) {
		String[] campos = linea.split(",");
		String[] competidores = new String[campos.length];
		for(int i = 1; i < campos.length;i++){
			competidores[i - 1] = campos[i].trim();
		}
		return new LigaDto(campos[0].trim(), competidores);
	}

	public void guardar(List<Liga> lista) {

	}
}
