package com.heroesvillanos.menu.ligas;

import com.heroesvillanos.menu.MenuBase;

public class AdministracionLigas extends MenuBase {

    public AdministracionLigas() {
        opciones = new String[]{
                "1 - Carga desde archivo",
                "2 - Creación",
                "3 - Listado",
                "4 - Guardar en archivo",
                "0 - Volver al menu principal",
        };
        titulo = "Menu de Ligas";
    }

    @Override
    protected void desplegarOpciones(int opcion) {
        switch (opcion) {
            case 1:
                servicioLigas.cargar();
                servicioLigas.printLista("Carga desde Archivo");
                break;
            case 2:
                new CreacionLigas().loopOpciones();
                break;
            case 3:
                servicioLigas.printLista("Listado de Ligas");
                break;
            case 4:
                servicioLigas.persistir();
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
