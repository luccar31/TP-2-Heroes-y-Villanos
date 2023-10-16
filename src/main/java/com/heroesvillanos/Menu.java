package com.heroesvillanos;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
	
	public void desplegarMenu() {
		Scanner entrada = new Scanner(System.in);
		int opcion = -1;
		
		this.imprimirMenuPrincipal();
		
		try {
			opcion =  entrada.nextInt();
			
			while (opcion != 0){
				switch(opcion) {
				case 1:
					this.imprimirMenuPersonajes();
					
					
					
				}
				
				
				this.imprimirMenuPrincipal();
				opcion =  entrada.nextInt();
				}
			}
			catch (InputMismatchException e) {
				System.out.println("Ingrese un valor valido");
	            opcion.nextLine();
			
		}
		
		
		
		
	}
	
	
	public void imprimirMenuPrincipal(){
		System.out.println(
				"1 Administración de Personajes\n"
				+ "2 Administración de Ligas\n"
				+ "3 Realización de combates\n"
				+ "4 Reportes\n"
				+ "0. Salir");
		}
	
	public void imprimirMenuPersonajes() {
		System.out.println(
			"1. Carga desde archivo\n"
			+ "2. Creación\n"
			+ "3. Listado\n"
			+ "4. Guardar en archivo todos los personajes\n"
			+ "0. Salir");
	}
	
	public void imprimirMenuLigas() {
		System.out.println(
				"1. Carga desde archivo\n"
				+ "2. Creación\n"
				+ "3. Listado\n"
				+ "4. Guardar en archivo todas las ligas\n"
				+ "0. Salir");
	}
	
	public void imprimirMenuCombate() {
		System.out.println(
				"1. Personaje contra Liga (definiendo característica)\n"
				+ "2. ○ Liga contra Liga (definiendo característica)\n"
				+ "0. Salir");
	}
	
	public void imprimirMenuReportes() {
		System.out.println(
				"1. Todos los personajes o ligas que venzan a un personaje dado para cierta característica\n"
				+ "2. Listado ordenado de personajes por múltiples características\r\n"
				+ "0. Salir");
	}
}
