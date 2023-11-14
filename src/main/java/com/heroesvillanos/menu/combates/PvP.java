package com.heroesvillanos.menu.combates;

import com.heroesvillanos.menu.Utils;

public class PvP extends CombatesBase {
	
	public PvP() {
		opciones = new String[] {
				"Seleccione por ID (0 para salir)",
		};
		titulo = "PvP";
		SetServicios(servicioPersonajes, servicioPersonajes);
	}
	
	@Override
	protected void desplegarOpciones(int opcion) {
		if (opcion == 0) DesplegarMenuPrincipal();
		switch (paso) {
			case 0:
				paso = primerSeleccion(opcion, "Personaje", "Personaje");
				break;
			case 1:
				segundaSeleccion(opcion);
				break;
		}
	}	
	
	
	
}
