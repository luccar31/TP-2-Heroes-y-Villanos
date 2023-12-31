package com.heroesvillanos.menu.combates;

import com.heroesvillanos.dominio.Caracteristica;
import com.heroesvillanos.dominio.Competidor;
import com.heroesvillanos.dominio.TipoCompetidor;
import com.heroesvillanos.menu.MenuBase;
import com.heroesvillanos.menu.Utils;
import com.heroesvillanos.servicios.IServicioCompetidores;

import java.util.Scanner;

public class CombatesBase extends MenuBase {
    Competidor p1;
    Competidor p2;

    IServicioCompetidores<Competidor> servicio1;
    IServicioCompetidores<Competidor> servicio2;

    int paso = 0;

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
                new PvP().loopOpciones();
                break;
            case 2:
                new PvL().loopOpciones();
                break;
            case 3:
                new LvL().loopOpciones();
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

    // De que forma podemos evitar el warning de un cast que estamos seguros que funciona?
    @SuppressWarnings("unchecked")
    protected <T, E extends Competidor> void setServicios(IServicioCompetidores<T> servicio1, IServicioCompetidores<E> servicio2) {
        this.servicio1 = (IServicioCompetidores<Competidor>) servicio1;
        this.servicio2 = (IServicioCompetidores<Competidor>) servicio2;

        servicio1.printLista("");
    }

    protected int primerSeleccion(int opcion, String tipoCompetidor1, String tipoCompetidor2) {
        try {
            p1 = servicio1.getPorID(opcion);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            loopOpciones();
        }
        System.out.println("----------------------------------------------------");
        System.out.println(tipoCompetidor1 + " seleccionado:");
        System.out.println(p1.toString());
        System.out.println("----------------------------------------------------");
        System.out.println();
        Utils.wait(1000);

        servicio2.printLista("Seleccione " + tipoCompetidor2 + " contra quien competir: ", getTipoEnemigo(p1));
        return 1;
    }

    protected void segundaSeleccion(int opcion) {
        try {
            p2 = servicio2.getPorID(opcion, getTipoEnemigo(p1));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            loopOpciones();
        }
        System.out.println("----------------------------------------------------");
        System.out.println("Competidores seleccionados:");
        System.out.println(p1.toString());
        System.out.println("VS");
        System.out.println(p2.toString());
        System.out.println("----------------------------------------------------");
        Utils.wait(500);
        pelea();
    }

    protected void pelea() {
        Scanner s = new Scanner(System.in);
        Caracteristica caracteristica = null;
        String _caracteristica = "";
        do {
            System.out.println("Elegir caracteristica (V(Velocidad)/F(Fuerza)/R(Resistencia)/D(Destreza): ");
            _caracteristica = s.nextLine();
        } while (!_caracteristica.equals("V") && !_caracteristica.equals("F") && !_caracteristica.equals("R") && !_caracteristica.equals("D"));
        caracteristica = Utils.getCaracteristicaByString(_caracteristica);

        String formato = p1.esGanador(p2, caracteristica) ? "ha vencido a" : "ha perdido contra";
        System.out.println(p1.getNombre() + " " + formato + " " + p2.getNombre());
        System.out.println("----------------------------------------------------");

        System.out.println("Volviendo al menu principal...");
        Utils.wait(1500);
        desplegarMenuPrincipal();
    }

    // Retorna Heroe si es Villano y viceversa.
    private TipoCompetidor getTipoEnemigo(Competidor p) {
        return TipoCompetidor.HEROE.equals(p.getTipo()) ? TipoCompetidor.VILLANO : TipoCompetidor.HEROE;
    }
}
