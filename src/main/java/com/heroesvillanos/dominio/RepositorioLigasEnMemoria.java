package com.heroesvillanos.dominio;

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

}
