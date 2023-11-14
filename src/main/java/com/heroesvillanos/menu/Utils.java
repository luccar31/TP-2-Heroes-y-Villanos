package com.heroesvillanos.menu;

import java.util.List;

import com.heroesvillanos.dominio.Caracteristica;

public final class Utils {
    public static String repetirString(int n, String s) {
        return String.format("%0" + n + "d", 0).replace("0", s);
    }

    public static void limpiarConsola() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        try {
            String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (Exception e) {
            // Handle any exceptions.
        }
    }
    
	public static Caracteristica GetCaracteristicaByString (String c) {
		switch (c)
		{
			case "V":
				return Caracteristica.VELOCIDAD;
			case "F":
				return Caracteristica.FUERZA;
			case "R":
				return Caracteristica.RESISTENCIA;
			case "D":
				return Caracteristica.DESTREZA;
		}
		return null;
	}
	
	public static <T> void PrintLista(List<T> lista, String... header)
	{
		if (header.length > 0) {
			System.out.println(header[0]);
		}
		if (lista.isEmpty()) {
			System.out.println("-----------------------------------------------");
			System.out.println("Nada que mostrar. Volviendo...");
			System.out.println("-----------------------------------------------");
			return;
		}

		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.printf("%-7s %-20s %-20s %-7s %-7s %-7s %-7s%n", "Tipo", "| Nombre Real", "| Alias", "| Velocidad", "| Fuerza", "| Resistencia", "|Destreza");
		for (T l : lista) {
			String[] results = l.toString().split(","); 
			System.out.printf("%-7s %-20s %-20s %-11s %-8s %-13s %-7s%n", results[0], "|" + results[1], "|" + results[2], "|" + results[3], "|" + results[4], "|" + results[5], "|" + results[6]);
		}
		System.out.println("-----------------------------------------------------------------------------------------------");
	}
}
