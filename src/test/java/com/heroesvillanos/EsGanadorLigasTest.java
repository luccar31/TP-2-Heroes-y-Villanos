package com.heroesvillanos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.heroesvillanos.dominio.Caracteristica;
import com.heroesvillanos.dominio.Liga;
import com.heroesvillanos.dominio.Personaje;
import com.heroesvillanos.dominio.TipoCompetidor;

public class EsGanadorLigasTest {
		
		private Personaje p1, p2, p3, p4, p5, p6;
		private Liga ligaHeroe, ligaJusticiera;
		
		@BeforeEach
	    public void init() {
			ligaHeroe = new Liga(TipoCompetidor.HEROE, "Liga Heroes", 1);
			p1 = new Personaje(1, "Black Panther", "BP", TipoCompetidor.HEROE,   100, 90, 80, 70);
			p2 = new Personaje(2, "Thor Odinson", "Thor", TipoCompetidor.HEROE,  110, 80, 90, 75);
			p3 = new Personaje(3, "Clark Ken", "Superman", TipoCompetidor.HEROE, 100, 75, 85, 80);
			ligaHeroe.agregarCompetidor(p1);
			ligaHeroe.agregarCompetidor(p2);
			ligaHeroe.agregarCompetidor(p3);
			ligaJusticiera = new Liga(TipoCompetidor.VILLANO, "Liga Villanos", 2);
			p4 = new Personaje(4, "Peter Parker", "Spiderman", TipoCompetidor.VILLANO,       120, 90, 70, 65);
			p5 = new Personaje(5, "Steve Rogers", "Captain America", TipoCompetidor.VILLANO, 115, 70, 95, 68);
			p6 = new Personaje(6, "Clinton Barton", "Hawkeye", TipoCompetidor.VILLANO,       100, 80, 80, 70);
			ligaJusticiera.agregarCompetidor(p4);
			ligaJusticiera.agregarCompetidor(p5);
			ligaJusticiera.agregarCompetidor(p6);
		}
		
		@Test
		public void liga_es_ganador() {
			Assertions.assertEquals(ligaHeroe.esGanador(ligaJusticiera, Caracteristica.FUERZA), true);
		}
		
		@Test
		public void liga_es_perdedor() {
			Assertions.assertEquals(ligaHeroe.esGanador(ligaJusticiera, Caracteristica.VELOCIDAD), false);
		}
		
		@Test
		public void liga_es_ganador_contra_personaje() {
			Assertions.assertEquals(ligaHeroe.esGanador(p6, Caracteristica.VELOCIDAD), true);
		}
		
		@Test
		public void liga_es_perdedor_contra_personaje() {
			Assertions.assertEquals(ligaHeroe.esGanador(p4, Caracteristica.VELOCIDAD), false);
		}
}
