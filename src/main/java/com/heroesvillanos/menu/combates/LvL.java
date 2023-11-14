package com.heroesvillanos.menu.combates;

public class LvL extends CombatesBase {

    public LvL() {
        opciones = new String[]{
                "Seleccione por ID (0 para salir)",
        };
        titulo = "LvL";
        setServicios(servicioLigas, servicioLigas);
    }

    @Override
    protected void desplegarOpciones(int opcion) {
        if (opcion == 0) desplegarMenuPrincipal();
        switch (paso) {
            case 0:
                paso = primerSeleccion(opcion, "Liga", "Liga");
                break;
            case 1:
                segundaSeleccion(opcion);
                break;
        }
    }


}
