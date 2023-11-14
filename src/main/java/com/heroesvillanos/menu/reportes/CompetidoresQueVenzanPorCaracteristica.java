package com.heroesvillanos.menu.reportes;

import com.heroesvillanos.dominio.Caracteristica;
import com.heroesvillanos.dominio.Competidor;
import com.heroesvillanos.menu.MenuBase;
import com.heroesvillanos.menu.Utils;

import java.util.List;
import java.util.Scanner;

public class CompetidoresQueVenzanPorCaracteristica extends MenuBase {
    public CompetidoresQueVenzanPorCaracteristica() {
        opciones = new String[]{
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
                desplegarMenuPrincipal();
                break;
            case -1:
                System.out.println("Input invalido!");
                break;
            default:
                System.out.println("Opción invalida!");
        }
    }

    private void formularioReporte() {
        String nombre = "";
        Caracteristica caracteristica = null;
        String _caracteristica = "";

        for (int i = 0; i < 2; ++i) {
            Scanner s = new Scanner(System.in);
            switch (i) {
                case 0:
                    System.out.println("Introducir nombre: ");
                    nombre = s.nextLine();
                    continue;
                case 1:
                    do {
                        System.out.println("Introducir caracteristica (V(Velocidad)/F(Fuerza)/R(Resistencia)/D(Destreza): ");
                        _caracteristica = s.nextLine();
                    } while (!_caracteristica.equals("V") && !_caracteristica.equals("F") && !_caracteristica.equals("R") && !_caracteristica.equals("D"));
                    caracteristica = Utils.getCaracteristicaByString(_caracteristica);
            }
        }
        List<Competidor> result = servicioReportes.competidoresQueVenzan(nombre, caracteristica);
        System.out.println("-----------------------------------------------");
        System.out.println("Personajes que vencen a: " + nombre);
        System.out.println("-----------------------------------------------");
        System.out.printf("%-7s %-20s %-20s %-7s %-7s %-7s %-7s%n", "Tipo", "| Nombre Real", "| Alias", "| Velocidad", "| Fuerza", "| Resistencia", "|Destreza");
        for (Competidor c : result) {
            String[] results = c.toString().split(",");
            System.out.printf("%-7s %-20s %-20s %-11s %-8s %-13s %-7s%n", results[0], "|" + results[1], "|" + results[2], "|" + results[3], "|" + results[4], "|" + results[5], "|" + results[6]);
        }
        System.out.println("-----------------------------------------------");
    }
}
