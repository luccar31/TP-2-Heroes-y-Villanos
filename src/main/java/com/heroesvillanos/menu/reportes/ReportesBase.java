package com.heroesvillanos.menu.reportes;

import com.heroesvillanos.menu.MenuBase;
import com.heroesvillanos.menu.MenuPrincipal;
import com.heroesvillanos.menu.personajes.CreacionPersonajes;

public class ReportesBase extends MenuBase {
	public ReportesBase() {
		opciones = new String[] {
				"1 - Listado ordenado por caracteristica",
	            "2 - Competidores que venzan a un personaje dado en una caracteristica",
	            "0 - Volver al menu principal",
		};
		titulo = "Menu de Reportes";
	}
	
	protected void desplegarOpciones(int opcion) {
		switch (opcion) {
	        case 1:
	            new OrdenadoPorCaracteristica().loopOpciones();
	            break;
	        case 2:
	            new CompetidoresQueVenzanPorCaracteristica().loopOpciones();
	            break;
	        case 0:
	        	DesplegarMenuPrincipal();
	            break;
	        case -1:
	            System.out.println("Input invalido!");
	            break;
	        default:
	            System.out.println("Opción invalida!");
		}
	}
}
