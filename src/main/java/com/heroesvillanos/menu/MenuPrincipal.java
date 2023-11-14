package com.heroesvillanos.menu;

import com.heroesvillanos.menu.combates.CombatesBase;
import com.heroesvillanos.menu.ligas.AdministracionLigas;
import com.heroesvillanos.menu.personajes.AdministracionPersonajes;
import com.heroesvillanos.menu.reportes.ReportesBase;

public final class MenuPrincipal extends MenuBase {
    private static MenuPrincipal instance;

    public MenuPrincipal() {
        opciones = new String[]{
                "1 - Administracion de Personajes",
                "2 - Administracion de Ligas",
                "3 - Realizacion de combates",
                "4 - Reportes",
                "0 - Salir",
        };
        titulo = "Menu Principal";
    }

    public static MenuPrincipal getInstance() {
        if (instance == null) {
            instance = new MenuPrincipal();
        }
        return instance;
    }

    @Override
    public void desplegarOpciones(int opcion) {
        switch (opcion) {
            case 1:
                new AdministracionPersonajes().loopOpciones();
                break;
            case 2:
                new AdministracionLigas().loopOpciones();
                break;
            case 3:
                new CombatesBase().loopOpciones();
                break;
            case 4:
                new ReportesBase().loopOpciones();
                break;
            case 0:
                break;
            case -1:
                System.out.println("Input invalido!");
                break;
            default:
                System.out.println("Opcion invalida!");
        }
    }

}
