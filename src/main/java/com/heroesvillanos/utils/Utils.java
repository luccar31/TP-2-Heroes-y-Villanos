package com.heroesvillanos.utils;

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
}
