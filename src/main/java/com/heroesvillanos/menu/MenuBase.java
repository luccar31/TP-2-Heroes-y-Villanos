package com.heroesvillanos.menu;

import com.heroesvillanos.Principal;
import com.heroesvillanos.servicios.IServicioPersonajes;
import com.heroesvillanos.servicios.IServicioReportes;
import com.heroesvillanos.servicios.IServiciosLigas;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuBase {

    public IServicioPersonajes servicioPersonajes;
    public IServiciosLigas servicioLigas;
    public IServicioReportes servicioReportes;
    protected String[] opciones = {"Falta declarar opciones en el menu "};
    protected String titulo = "Falta declarar el titulo en el menu";

    public MenuBase() {
        servicioPersonajes = Principal.getServicioPersonajesInstance();
        servicioLigas = Principal.getServicioLigasInstance();
        servicioReportes = Principal.getServicioReportesInstance();
    }

    protected static int leerOpcion() {
        Scanner s = new Scanner(System.in);
        int opc;
        try {
            opc = s.nextInt();
        } catch (InputMismatchException e) {
            opc = -1;
        } finally {
            s.nextLine();
        }
        //s.close();
        return opc;
    }

    public void desplegarMenuPrincipal() {
        MenuPrincipal.getInstance().loopOpciones();
    }

    public void loopOpciones() {
        int opcion;
        do {
            imprimir();
            opcion = leerOpcion();
            desplegarOpciones(opcion);

        } while (opcion != 0);
        System.out.println("Saliendo...");
        System.exit(0);
    }

    private void imprimir() {
        Utils.limpiarConsola();
        StringBuilder builder = new StringBuilder();
        builder.append(Utils.repetirString(10, "*")).append("\n")
                .append("#").append(titulo).append("#").append("\n")
                .append(Utils.repetirString(10, "*")).append("\n");

        for (String option : opciones) {
            builder.append(option).append("\n");
        }
        builder.append("Elige una opción: ");

        System.out.print(builder);
    }

    protected void desplegarOpciones(int opcion) {
    }
}
