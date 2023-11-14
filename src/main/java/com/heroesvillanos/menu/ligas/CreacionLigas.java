package com.heroesvillanos.menu.ligas;

import com.heroesvillanos.dominio.Liga;
import com.heroesvillanos.dominio.TipoCompetidor;
import com.heroesvillanos.menu.MenuBase;

import java.util.Scanner;

public class CreacionLigas extends MenuBase {

    public CreacionLigas() {
        opciones = new String[]{
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
        String nombreLiga = "";
        TipoCompetidor tipo = null;
        String _tipo = "";

        for (int i = 0; i < 2; ++i) {
            Scanner s = new Scanner(System.in);
            switch (i) {
                case 0:
                    System.out.println("Introducir nombre de la liga: ");
                    nombreLiga = s.nextLine();
                    continue;
                case 1:
                    do {
                        System.out.println("Introducir tipo de liga (H/V): ");
                        _tipo = s.nextLine();
                    } while (!_tipo.equals("H") && !_tipo.equals("V"));
                    tipo = TipoCompetidor.obtenerPor(_tipo == "H" ? "Heroe" : "Villano");
                    continue;
            }
        }

        Liga l = servicioLigas.crear(tipo, nombreLiga);

        System.out.println();
        System.out.println("---------------------");
        System.out.println("Liga " + l.getNombre() + " creada!");
        System.out.println("---------------------");
        System.out.println();
    }

}
