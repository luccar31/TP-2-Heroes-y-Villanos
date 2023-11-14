package com.heroesvillanos.menu.personajes;

import com.heroesvillanos.menu.MenuBase;

public class AdministracionPersonajes extends MenuBase {

    public AdministracionPersonajes() {
        opciones = new String[]{
                "1 - Carga desde archivo",
                "2 - Creacion",
                "3 - Listado",
                "4 - Guardar en archivo",
                "0 - Volver al menu principal",
        };
        titulo = "Menu de Personajes";
    }

    @Override
    protected void desplegarOpciones(int opcion) {
        switch (opcion) {
            case 1:
                servicioPersonajes.cargar();
                servicioPersonajes.printLista("Carga desde archivo");
                break;
            case 2:
                new CreacionPersonajes().loopOpciones();
                break;
            case 3:
                servicioPersonajes.printLista("Listado de Personajes");
                break;
            case 4:
                servicioPersonajes.persistir();
                break;
            case 0:
                desplegarMenuPrincipal();
                break;
            case -1:
                System.out.println("Input invalido!");
                break;
            default:
                System.out.println("Opcion invalida!");
        }
    }

}
