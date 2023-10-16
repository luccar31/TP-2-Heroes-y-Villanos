package com.heroesvillanos;

import java.util.InputMismatchException;
import java.util.Scanner;
import static java.lang.System.exit;

public class Menu {
	
	final static String[] opcionesMenuPrincipal = {
			"-------------------------------",
			"# Menu Principal:             #",
			"-------------------------------",
			"1- Administración de Personajes",
            "2- Administración de Ligas",
            "3- Realización de combates",
            "4- Reportes",
            "",
            "0- Salir",
            ""
	};
	
	final static String[] opcionesPersonajes = {
			"-------------------------------",
			"# Menu Personajes:            #",
			"-------------------------------",
			"1- Carga desde archivo",
            "2- Creación",
            "3- Listado",
            "4- Guardar en archivo todos los personajes",
            "",
            "0- Salir",
            ""
	};
	
	public void desplegarMenu() {
		menuPrincipal();
	}

	
	private void imprimirMenu(String[] options) {
		clearConsole();
		for (String option : options){
            System.out.println(option);
        }
        System.out.print("Elige una opción: ");
	}
	
	private void menuPrincipal() {
		
		imprimirMenu(opcionesMenuPrincipal);
		
		// Investigar Scanner - Tomar un solo input y procesar
		while (true) {
			try {
				int opcion = leerOpcion();
				
				switch (opcion) {
				case 1:
					this.menuPersonajes();
					break;
				case 2:
					this.imprimirMenuLigas();
					break;
				case 3:
					this.imprimirMenuCombate();
					break;
				case 4:
					this.imprimirMenuReportes();
					break;
				case 0:
					System.out.println("Saliendo...");
					// Delay
					exit(0);
				default:
					System.out.println("Opción incorrecta");
					// Delay para poder leer "Opción incorrecta"
					imprimirMenu(opcionesMenuPrincipal);
					break;
					//opcion = entrada.nextInt();
				}
			} catch (Exception e) {
				System.out.println("Ingrese un valor valido");
				imprimirMenu(opcionesMenuPrincipal);
			}
			
		}
	}

	private void menuPersonajes() {
		imprimirMenu(opcionesPersonajes);
		
		while (true) {
			try {
				int opcion = leerOpcion();
				
				switch (opcion) {
				case 1:
					this.menuPersonajes();
					break;
				case 2:
					this.imprimirMenuLigas();
					break;
				case 3:
					this.imprimirMenuCombate();
					break;
				case 4:
					this.imprimirMenuReportes();
					break;
				case 0:
					System.out.println("Volviendo...");
					// Delay
					menuPrincipal();
					break;
				default:
					System.out.println("Opción incorrecta");
					// Delay para poder leer "Opción incorrecta"
					imprimirMenu(opcionesPersonajes);
					break;
				}
			} catch (Exception e) {
				System.out.println("Ingrese un valor valido");
				imprimirMenu(opcionesPersonajes);
			}
			
		}
	}


	public void imprimirMenuLigas() {
		System.out.println("1. Carga desde archivo\n" + "2. Creación\n" + "3. Listado\n"
				+ "4. Guardar en archivo todas las ligas\n" + "0. Salir");
	}

	public void imprimirMenuCombate() {
		System.out.println("1. Personaje contra Liga (definiendo característica)\n"
				+ "2. ○ Liga contra Liga (definiendo característica)\n" + "0. Salir");
	}

	public void imprimirMenuReportes() {
		System.out.println("1. Todos los personajes o ligas que venzan a un personaje dado para cierta característica\n"
				+ "2. Listado ordenado de personajes por múltiples características\r\n" + "0. Salir");
	}

	private final static void clearConsole() {
		
	   System.out.print("\033[H\033[2J");  
	   System.out.flush();  
		try {
			final String os = System.getProperty("os.name");
			
			if (os.contains("Windows")) {
				Runtime.getRuntime().exec("cls");
			} else {
				Runtime.getRuntime().exec("clear");
			}
		} catch (final Exception e) {
			// Handle any exceptions.
		}
	}
	
	private static int leerOpcion() {
        Scanner s = new Scanner(System.in);
        int opc;
        //System.out.print("Seleccione la opcion: ");
        try{
            opc = s.nextInt();
        }
        catch (InputMismatchException e){
            opc = -1;
        }
        finally {
            s.nextLine();
        }
        return opc;
    }
}
