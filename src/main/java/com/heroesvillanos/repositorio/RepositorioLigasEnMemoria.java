package com.heroesvillanos.repositorio;

import com.heroesvillanos.dominio.Liga;

import java.util.ArrayList;
import java.util.List;

public class RepositorioLigasEnMemoria implements Repositorio<Liga>{
	private final List<Liga> ligas;
	
	public RepositorioLigasEnMemoria() {
        this.ligas = new ArrayList<Liga>();
    }

	public List<Liga> listar() {
		return ligas;
	}

	public void guardar(Liga entidad) {
		this.ligas.add(entidad);
	}

	public Liga obtenerPorNombre(String nombre) {
		Liga busqueda = null;
		for(Liga liga : ligas){
			if(liga.getNombreCompetidor().equals(nombre)){
				busqueda = liga;
			}
		}
		return busqueda;
	}

	@Override
	public Liga obtenerPorIdentificador(int id) {
		return null;
	}

}
