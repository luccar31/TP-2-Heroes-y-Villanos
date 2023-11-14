package com.heroesvillanos.menu;

import java.util.List;

import com.heroesvillanos.dominio.Caracteristica;
import com.heroesvillanos.dominio.Competidor;
import com.heroesvillanos.dominio.Personaje;

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
	
	public static void wait(int ms)
	{
	    try
	    {
	        Thread.sleep(ms);
	    }
	    catch(InterruptedException ex)
	    {
	        Thread.currentThread().interrupt();
	    }
	}
}
