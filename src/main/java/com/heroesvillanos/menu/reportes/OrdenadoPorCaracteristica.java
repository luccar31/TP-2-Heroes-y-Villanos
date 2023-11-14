package com.heroesvillanos.menu.reportes;

import java.util.List;
import java.util.Scanner;

import com.heroesvillanos.dominio.Caracteristica;
import com.heroesvillanos.dominio.Competidor;
import com.heroesvillanos.dominio.DireccionOrden;
import com.heroesvillanos.menu.MenuBase;
import com.heroesvillanos.menu.Utils;

public class OrdenadoPorCaracteristica extends MenuBase {
	public OrdenadoPorCaracteristica() {
		opciones = new String[] {
				"1 - Comenzar formulario",
	            "0 - Volver al menu principal",
		};
		titulo = "Competidores que vencen por caracteristica";
	}
	
	protected void desplegarOpciones(int opcion) {
		switch (opcion) {
	        case 1:
	            formularioReporte();
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
	
	private void formularioReporte() {
		DireccionOrden orden = null;
		String _orden = "";
		Caracteristica caracteristica = null;
		String _caracteristica = "";
		
		for (int i = 0 ; i < 2 ; ++i)
		{
			Scanner s = new Scanner(System.in);
			switch (i) {
				case 0:
					do {
						System.out.println("Introducir orden (A(Ascendente)/D(Descendente): ");
						_orden = s.nextLine();
					} while (!_orden.equals("A") && !_orden.equals("D"));
					orden = _orden == "A" || _orden == "a" ? DireccionOrden.ASCENDENTE : DireccionOrden.DESCENDENTE;
					continue;
				case 1:
					do {
						System.out.println("Introducir caracteristica (V(Velocidad)/F(Fuerza)/R(Resistencia)/D(Destreza): ");
						_caracteristica = s.nextLine();
					} while (!_caracteristica.equals("V") && !_caracteristica.equals("F") && !_caracteristica.equals("R") && !_caracteristica.equals("D"));
					caracteristica = Utils.GetCaracteristicaByString(_caracteristica);
			}
		}
		servicioReportes.printLista(servicioReportes.ordenarPersonajesPor(orden, caracteristica));
	}
}
