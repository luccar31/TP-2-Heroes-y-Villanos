package com.heroesvillanos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.heroesvillanos.dominio.*;

public class EsGanadorPersonajesTest {
	
	private Personaje p1, p2, p3, p4;
	private Liga liga;

	@BeforeEach
	public void init() {
		p1 = new Personaje(1, "Loki Laufeyson", "Loki", TipoCompetidor.VILLANO, 100, 85, 80, 70);
		p3 = new Personaje(3, "Clark Ken", "Superman", TipoCompetidor.HEROE, 100, 70, 85, 80);
		p2 = new Personaje(2, "Thor Odinson", "Thor", TipoCompetidor.HEROE, 110, 80, 90, 75);
		p4 = new Personaje(4, "Tony Stark", "Ironman", TipoCompetidor.HEROE, 90, 60, 70, 65);
		liga = new Liga(TipoCompetidor.HEROE, "Liga Heroes", 1);
		liga.agregarCompetidor(p2);
		liga.agregarCompetidor(p3);
		liga.agregarCompetidor(p4);
	}

	@Test
	public void dado_personaje_cuando_pelea_es_ganador() {
		Assertions.assertEquals(p1.esGanador(p2, Caracteristica.FUERZA), true);
	}

	@Test
	public void dado_personaje_cuando_pelea_es_perdedor() {
		Assertions.assertEquals(p1.esGanador(p2, Caracteristica.VELOCIDAD), false);
	}

	@Test
	public void dado_personaje_cuando_pelea_contra_liga_es_ganador() {
		Assertions.assertEquals(p1.esGanador(liga, Caracteristica.VELOCIDAD), true);
	}

	@Test
	public void dado_personaje_cuando_pelea_contra_liga_es_perdedor() {
		Assertions.assertEquals(p1.esGanador(liga, Caracteristica.RESISTENCIA), false);
	}
}
