package com.heroesvillanos.menu.ligas;

import com.heroesvillanos.menu.MenuBase;
import com.heroesvillanos.menu.Utils;
import com.heroesvillanos.menu.ligas.CreacionLigas;

public class AdministracionLigas extends MenuBase {
	
	public AdministracionLigas() {
		opciones = new String[] {
				"1 - Carga desde archivo",
	            "2 - Creación",
	            "3 - Listado",
	            "4 - Guardar en archivo",
	            "0 - Volver al menu principal",
		};
		titulo = "Menu de Ligas";
	}
	
	@Override
	protected void desplegarOpciones(int opcion) {
		switch (opcion) {
	        case 1:
	        	Utils.PrintLista(servicioLigas.cargar(), "Carga desde Archivo");
	            break;
	        case 2:
	            new CreacionLigas().loopOpciones();
	            break;
	        case 3:
	        	Utils.PrintLista(servicioLigas.listar(), "Listado de Ligas");
	            break;
	        case 4:
	        	servicioLigas.persistir();
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
