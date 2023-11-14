package com.heroesvillanos.menu.combates;

public class PvL extends CombatesBase {

    public PvL() {
        opciones = new String[]{
                "Seleccione por ID (0 para salir)",
        };
        titulo = "PvL";
        setServicios(servicioPersonajes, servicioLigas);
    }

    @Override
    protected void desplegarOpciones(int opcion) {
        if (opcion == 0) desplegarMenuPrincipal();
        switch (paso) {
            case 0:
                paso = primerSeleccion(opcion, "Personaje", "Liga");
                break;
            case 1:
                segundaSeleccion(opcion);
                break;
        }
    }


}
