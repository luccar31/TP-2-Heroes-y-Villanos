package com.heroesvillanos.utils;

import com.heroesvillanos.utils.Utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

	private final static String[] OPCIONES_MENU_PRINCIPAL = {
			"1 - Administración de Personajes",
            "2 - Administración de Ligas",
            "3 - Realización de combates",
            "4 - Reportes",
            "0 - Salir",
	};

	private final static String[] OPCIONES_MENU_PERSONAJES = {
			"1 - Carga desde archivo",
            "2 - Creación",
            "3 - Listado",
            "4 - Guardar en archivo",
            "0 - Volver al menu principal",
	};

	private final static String[] OPCIONES_MENU_LIGAS = {
			"1 - Carga desde archivo",
			"2 - Creación",
			"3 - Listado",
			"4 - Guardar en archivo",
			"0 - Volver al menu principal",
	};

	private final static String[] OPCIONES_MENU_COMBATES = {
			"1 - Personaje vs Personaje",
			"2 - Personaje vs Liga",
			"3 - Liga vs Liga",
			"0 - Volver al menu principal",
	};

	private final static String[] OPCIONES_MENU_REPORTES = {
			"1 - Listado por multiples caracteristicas",
            "2 - Competidores que venzan a un personaje dado en una caracteristica",
			"0 - Volver al menu principal",
	};

	public void desplegarMenu() {
		menuPrincipal();
	}

	private void imprimirMenu(String nombreMenu, String[] opciones) {
		Utils.limpiarConsola();
		StringBuilder builder = new StringBuilder();
		builder.append(Utils.repetirString(10, "*")).append("\n")
				.append("#").append(nombreMenu).append("#").append("\n")
				.append(Utils.repetirString(10, "*")).append("\n");

		for (String option : opciones){
            builder.append(option).append("\n");
        }
		builder.append("Elige una opción: ");

		System.out.print(builder);
	}


	private void menuPrincipal() {
        int opcion;
		do{
            imprimirMenu("Menu principal", OPCIONES_MENU_PRINCIPAL);

			opcion = leerOpcion();

			switch (opcion) {
				case 1:
					this.menuPersonajes();
					break;
				case 2:
					this.menuLigas();
					break;
				case 3:
					this.menuCombates();
					break;
				case 4:
					this.menuReportes();
					break;
				case 0:
					break;
				case -1:
					System.out.println("Input invalido!");
					break;
				default:
                    System.out.println("Opción invalida!");
			}
		}while (opcion != 0);
	}

    private void menuPersonajes() {
        int opcion;
        do{
            imprimirMenu("Menu de personajes", OPCIONES_MENU_PERSONAJES);

            opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    System.out.println("Ejecutando opción 1 del menu...");
                    break;
                case 2:
                    System.out.println("Ejecutando opción 2 del menu...");
                    break;
                case 3:
                    System.out.println("Ejecutando opción 3 del menu...");
                    break;
                case 4:
                    System.out.println("Ejecutando opción 4 del menu...");
                    break;
                case 0:
                    System.out.println("Volviendo al menu principal...");
                    break;
                case -1:
                    System.out.println("Input invalido!");
                    break;
                default:
                    System.out.println("Opción invalida!");
            }
        } while (opcion != 0);
    }

    private void menuLigas() {
        int opcion;
        do{
            imprimirMenu("Menu de ligas", OPCIONES_MENU_LIGAS);

            opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    System.out.println("Ejecutando opción 1 del menu...");
                    break;
                case 2:
                    System.out.println("Ejecutando opción 2 del menu...");
                    break;
                case 3:
                    System.out.println("Ejecutando opción 3 del menu...");
                    break;
                case 4:
                    System.out.println("Ejecutando opción 4 del menu...");
                    break;
                case 0:
                    System.out.println("Volviendo al menu principal...");
                    break;
                case -1:
                    System.out.println("Input invalido!");
                    break;
                default:
                    System.out.println("Opción invalida!");
            }
        } while (opcion != 0);
    }

    private void menuCombates() {
        int opcion;
        do{
            imprimirMenu("Menu de combates", OPCIONES_MENU_COMBATES);

            opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    System.out.println("Ejecutando opción 1 del menu...");
                    break;
                case 2:
                    System.out.println("Ejecutando opción 2 del menu...");
                    break;
                case 3:
                    System.out.println("Ejecutando opción 3 del menu...");
                    break;
                case 0:
                    System.out.println("Volviendo al menu principal...");
                    break;
                case -1:
                    System.out.println("Input invalido!");
                    break;
                default:
                    System.out.println("Opción invalida!");
            }
        } while (opcion != 0);
    }

    private void menuReportes() {
        int opcion;
        do{
            imprimirMenu("Menu de reportes", OPCIONES_MENU_REPORTES);

            opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    System.out.println("Ejecutando opción 1 del menu...");
                    break;
                case 2:
                    System.out.println("Ejecutando opción 2 del menu...");
                    break;
                case 0:
                    System.out.println("Volviendo al menu principal...");
                    break;
                case -1:
                    System.out.println("Input invalido!");
                    break;
                default:
                    System.out.println("Opción invalida!");
            }
        } while (opcion != 0);
    }



	private static int leerOpcion() {
        Scanner s = new Scanner(System.in);
        int opc;
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
