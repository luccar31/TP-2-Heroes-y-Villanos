package com.heroesvillanos.menu.combates;

import com.heroesvillanos.menu.Utils;

public class PvL extends CombatesBase {
	
	public PvL() {
		opciones = new String[] {
				"Seleccione por ID (0 para salir)",
		};
		titulo = "PvL";
		SetServicios(servicioPersonajes, servicioLigas);
	}
	
	@Override
	protected void desplegarOpciones(int opcion) {
		
		switch (paso) {
			case 0:
				paso = primerSeleccion(opcion, "Personaje", "Liga");
				break;
			case 1:
				segundaSeleccion(opcion);
				System.out.println("Volviendo al menu principal...");
				Utils.wait(1500);
				DesplegarMenuPrincipal();
		}
	}	
	
	
}
