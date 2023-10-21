package com.heroesvillanos.dominio;

import java.util.ArrayList;
import java.util.List;

public class RepositorioLigas implements Repositorio<Liga> {

	private final List<Liga> liga;

	public RepositorioLigas() {
		this.liga = new ArrayList<Liga>();
	}

	public List<Liga> listar() {	
		return liga;
	}

	public void guardar(Liga entidad) {
		liga.add(entidad);
	}

}
