package com.heroesvillanos.menu;

import com.heroesvillanos.dominio.Caracteristica;

import java.util.List;

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

    public static Caracteristica GetCaracteristicaByString(String c) {
        switch (c) {
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

    public static <T> void PrintLista(List<T> lista, String... header) {
        if (header.length > 0) {
            System.out.println(header[0]);
        }
        if (lista.isEmpty()) {
            System.out.println("-----------------------------------------------");
            System.out.println("Nada que mostrar. Volviendo...");
            System.out.println("-----------------------------------------------");
            return;
        }

        System.out.println("-----------------------------------------------");
        for (T l : lista) {
            System.out.println(l.toString());
        }
        System.out.println("-----------------------------------------------");
    }
}
