package com.heroesvillanos.menu.personajes;

import com.heroesvillanos.dominio.Personaje;
import com.heroesvillanos.dominio.TipoCompetidor;
import com.heroesvillanos.menu.MenuBase;

import java.util.Scanner;

public class CreacionPersonajes extends MenuBase {

    public CreacionPersonajes() {
        opciones = new String[]{
                "1 - Comenzar con el formualario",
                "0 - Volver al menu principal",
        };
        titulo = "Creacion de Personajes";
    }

    @Override
    protected void desplegarOpciones(int opcion) {
        switch (opcion) {
            case 1:
                formularioCreacion();
                break;
            case 0:
                desplegarMenuPrincipal();
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
        int vel = 0;
        int fue = 0;
        int res = 0;
        int des = 0;

        for (int i = 0; i < 7; ++i) {
            switch (i) {
                case 0:
                    nombreReal = validacionTexto("nombre real");
                    continue;
                case 1:
                    alias = validacionTexto("alias");
                    continue;
                case 2:
                    tipo = validacionCaracter("tipo");
                    continue;
                case 3:
                    vel = validacionNumerica("velocidad");
                    continue;
                case 4:
                    fue = validacionNumerica("fuerza");
                    continue;
                case 5:
                    res = validacionNumerica("resistencia");
                    continue;
                case 6:
                    des = validacionNumerica("destreza");
                    continue;
            }
        }

        Personaje p = servicioPersonajes.crear(nombreReal, alias, tipo, vel, fue, res, des);

        System.out.println();
        System.out.println("-----------------------------------------------");
        System.out.println("Personaje creado!");
        System.out.println("-----------------------------------------------");
        System.out.println(p.toString());
        System.out.println("-----------------------------------------------");
        System.out.println();
    }

    public int validacionNumerica(String caracteristica) {
        int res;
        Scanner s = new Scanner(System.in);
        System.out.println("Introducir " + caracteristica + ": ");
        while (true) {
            try {
                res = Integer.parseInt(s.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese una " + caracteristica + " con valor numerico: ");
            }
        }
        return res;
    }

    public String validacionTexto(String prop) {
        String res;
        Scanner s = new Scanner(System.in);
        System.out.println("Introducir el " + prop + ": ");
        while (true) {
            try {
                res = s.nextLine();
                if (res.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\\s]+$")) {
                    break;
                } else {
                    throw new IllegalArgumentException("Por favor, ingrese un " + prop + " con formato de texto: ");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return res;
    }

    public TipoCompetidor validacionCaracter(String prop) {
        TipoCompetidor _tipo;
        String caracter;
        Scanner s = new Scanner(System.in);
        System.out.println("Introducir tipo (H/V): ");
        while (true) {
            try {
                caracter = s.nextLine().toUpperCase();
                if (caracter.equals("H") || caracter.equals("V")) {
                    _tipo = TipoCompetidor.obtenerPor(caracter.equals("H") ? "Heroe" : "Villano");
                    break;
                } else {
                    throw new IllegalArgumentException("Por favor, ingrese un " + prop + " de un solo caracter (H/V): ");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return _tipo;
    }

}
