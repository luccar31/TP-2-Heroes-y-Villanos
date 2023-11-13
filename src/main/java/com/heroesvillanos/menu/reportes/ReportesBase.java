package com.heroesvillanos.menu.reportes;

import com.heroesvillanos.menu.MenuBase;

public class ReportesBase extends MenuBase {
    public ReportesBase() {
        opciones = new String[]{
                "1 - Listado por multiples caracteristicas",
                "2 - Competidores que venzan a un personaje dado en una caracteristica",
                "0 - Volver al menu principal",
        };
        titulo = "Menu de Reportes";
    }

    protected void desplegarOpciones(int opcion) {
        switch (opcion) {
            case 1:
                //
                break;
            case 2:
                new CompetidoresQueVenzanPorCaracteristica().loopOpciones();
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
}
