package com.heroesvillanos.menu.combates;

public class PvP extends CombatesBase {

    public PvP() {
        opciones = new String[]{
                "Seleccione por ID (0 para salir)",
        };
        titulo = "PvP";
        setServicios(servicioPersonajes, servicioPersonajes);
    }

    @Override
    protected void desplegarOpciones(int opcion) {
        if (opcion == 0) desplegarMenuPrincipal();
        switch (paso) {
            case 0:
                paso = primerSeleccion(opcion, "Personaje", "Personaje");
                break;
            case 1:
                segundaSeleccion(opcion);
                break;
        }
    }


}
