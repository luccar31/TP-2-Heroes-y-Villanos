package com.heroesvillanos.comparators;

import java.util.Comparator;

import com.heroesvillanos.dominio.*;

public class CombateComparator implements Comparator<Personaje>{
	private Caracteristica c = null;
	
	public void Comparator(Caracteristica c) {
		this.c = c;
	}
	
	public int compare(Personaje a, Personaje b) {
		String[] caracteristicas = {"VELOCIDAD", "FUERZA", "RESISTENCIA", "DESTREZA", "VELOCIDAD", "FUERZA", "RESISTENCIA"}; 
		int restaCaracteristica = -1;
		for (int i = 0; i < caracteristicas.length; i++) {
			if(restaCaracteristica == 0) {
				c = Caracteristica.valueOf(caracteristicas[i]);
			}
			if(c.name().equals(caracteristicas[i])) {
				restaCaracteristica = a.getCaracteristica(c) - b.getCaracteristica(c);
			}
		}
		return restaCaracteristica;
	}

}
