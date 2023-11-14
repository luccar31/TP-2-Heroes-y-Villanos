package com.heroesvillanos.menu.combates;

import com.heroesvillanos.menu.Utils;

public class LvL extends CombatesBase {
	
	public LvL() {
		opciones = new String[] {
				"Seleccione por ID (0 para salir)",
		};
		titulo = "LvL";
		SetServicios(servicioLigas, servicioLigas);
	}
	
	@Override
	protected void desplegarOpciones(int opcion) {
		switch (paso) {
			case 0:
				paso = primerSeleccion(opcion, "Liga", "Liga");
				break;
			case 1:
				segundaSeleccion(opcion);
				break;
		}
	}	
	
	
	
}
