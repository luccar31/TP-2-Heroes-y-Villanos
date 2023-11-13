package com.heroesvillanos.menu.combates;

import com.heroesvillanos.menu.MenuBase;

public class CombatesBase extends MenuBase {

    public CombatesBase() {
        opciones = new String[]{
                "1 - Personaje vs Personaje",
                "2 - Personaje vs Liga",
                "3 - Liga vs Liga",
                "0 - Volver al menu principal",
        };
        titulo = "Menu de Combates";
    }

    @Override
    protected void desplegarOpciones(int opcion) {
        switch (opcion) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
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
