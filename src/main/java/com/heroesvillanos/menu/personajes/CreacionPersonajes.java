package com.heroesvillanos.menu.personajes;

import java.util.Scanner;

import com.heroesvillanos.dominio.Personaje;
import com.heroesvillanos.dominio.TipoCompetidor;
import com.heroesvillanos.menu.MenuBase;
import com.heroesvillanos.menu.MenuPrincipal;

public class CreacionPersonajes extends MenuBase {

	public CreacionPersonajes() {
		opciones = new String[] {
				"1 - Comenzar con el formualario",
	            "0 - Volver al menu principal",
		};
		titulo = "Creacion de Ligas";
	}

	@Override
	protected void desplegarOpciones(int opcion) {		
		switch (opcion) {
		case 1:
			formularioCreacion();
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
	
	private void formularioCreacion() {
		String nombreReal = "";
		String alias = "";
		TipoCompetidor tipo = null;
		String _tipo = "";
		int vel = 0;
		int fue = 0;
		int res = 0;
		int des = 0;
		
		for (int i = 0 ; i < 7 ; ++i)
		{
			Scanner s = new Scanner(System.in);
			switch (i) {
				case 0:
					System.out.println("Introducir nombre real: ");
					nombreReal = s.nextLine();
					continue;
				case 1:
					System.out.println("Introducir alias: ");
					alias = s.nextLine();
					continue;
				case 2:
					do {
						System.out.println("Introducir tipo (H/V): ");
						_tipo = s.nextLine();
					} while (!_tipo.equals("H") && !_tipo.equals("V"));
					tipo = TipoCompetidor.obtenerPor(_tipo == "H" ? "Heroe" : "Villano");
					continue;
				case 3:
					System.out.println("Introducir velocidad: ");
					vel = s.nextInt();
					continue;
				case 4:
					System.out.println("Introducir fuerza: ");
					fue = s.nextInt();
					continue;
				case 5:
					System.out.println("Introducir resistencia: ");
					res = s.nextInt();
					continue;
				case 6:
					System.out.println("Introducir destreza: ");
					des = s.nextInt();
					continue;	
			}
		}
		
		Personaje p = servicioPersonajes.crear(nombreReal, alias, tipo, vel, fue, res, des);
		
		System.out.println("");
		System.out.println("---------------------");
		System.out.println("Personaje creado!");
		System.out.println("---------------------");
		System.out.println(p.toString());
		System.out.println("---------------------");
		System.out.println("");
	}

}
