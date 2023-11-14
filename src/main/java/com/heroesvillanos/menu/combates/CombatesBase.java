package com.heroesvillanos.menu.combates;

import com.heroesvillanos.dominio.Caracteristica;
import com.heroesvillanos.dominio.Competidor;
import com.heroesvillanos.dominio.TipoCompetidor;
import com.heroesvillanos.menu.MenuBase;
import com.heroesvillanos.menu.Utils;
import com.heroesvillanos.menu.ligas.CreacionLigas;
import com.heroesvillanos.servicios.IServicioCompetidores;

public class CombatesBase extends MenuBase {
	Competidor p1;
	Competidor p2;
	
	IServicioCompetidores<Competidor> servicio1;
	IServicioCompetidores<Competidor> servicio2;
	
	int paso = 0;
	
	public CombatesBase() {
		opciones = new String[] {
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
	        	DesplegarMenuPrincipal();
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
	protected <T,E extends Competidor>void SetServicios(IServicioCompetidores<T> servicio1, IServicioCompetidores<E> servicio2) {
		this.servicio1 = (IServicioCompetidores<Competidor>) servicio1;
		this.servicio2 = (IServicioCompetidores<Competidor>) servicio2;
		
		servicio1.printLista("");
	}
	
	protected int primerSeleccion(int opcion, String tipoCompetidor1, String tipoCompetidor2) {
		p1 = servicio1.GetPorID(opcion);
		System.out.println("--------------------------");
		System.out.println(tipoCompetidor1 + " seleccionado:");
		System.out.println(p1.toString());
		System.out.println("--------------------------");
		System.out.println();
		Utils.wait(1000);
		TipoCompetidor tipoEnemigo = TipoCompetidor.HEROE.equals(p1.getTipo()) ? TipoCompetidor.VILLANO : TipoCompetidor.HEROE;
		servicio2.printLista("Seleccione " + tipoCompetidor2 + " contra quien competir: ", tipoEnemigo);
		return 1;
	}
	
	protected void segundaSeleccion(int opcion) {		
		p2 = servicio2.GetPorID(opcion);
		System.out.println("--------------------------");
		System.out.println("Competidores seleccionados:");
		System.out.println(p1.toString());
		System.out.println("VS");
		System.out.println(p2.toString());
		System.out.println("--------------------------");
		Utils.wait(500);
		pelea();
	}
	
	protected void pelea() { 
		String formato = p1.esGanador(p2, Caracteristica.VELOCIDAD) ? "ha vencido a" : "ha perdido contra";
		System.out.println(p1.getNombre() + " " + formato + " " + p2.getNombre());
	}
	
	
}
