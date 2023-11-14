package com.heroesvillanos.servicios;

import com.heroesvillanos.dominio.*;
import com.heroesvillanos.exception.CompetidorNoEncontrado;
import com.heroesvillanos.exception.LigaYaExistenteException;
import com.heroesvillanos.exception.LigasYaCargadasException;
import com.heroesvillanos.exception.PersonajesNoCargadosException;
import com.heroesvillanos.menu.Utils;
import com.heroesvillanos.persistencia.Persistencia;
import com.heroesvillanos.repositorio.Repositorio;

import java.util.ArrayList;
import java.util.List;

public class ServicioLigas implements IServiciosLigas {

    private final Repositorio<Liga> repositorioLigas;
    private final Persistencia<RegistroLiga, Liga> persistencia;
    private final Repositorio<Personaje> repositorioPersonajes;

    public ServicioLigas(Repositorio<Liga> repositorioLigas, Repositorio<Personaje> repositorioPersonajes, Persistencia<RegistroLiga, Liga> persistencia) {
        this.repositorioLigas = repositorioLigas;
        this.persistencia = persistencia;
        this.repositorioPersonajes = repositorioPersonajes;
    }

    //devuelve una lista de ligas para poder testear
    @Override
    public List<Liga> cargar() {
        if (!repositorioLigas.listar().isEmpty()) {
            throw new LigasYaCargadasException("Las ligas ya fueron cargadas");
        }

        int id = 1;
        //si no se cargaron los personajes, excepcion porque se deben cargar primero los personajes
        //para poder realizar busquedas
        if (repositorioPersonajes.listar().isEmpty()) {
            throw new PersonajesNoCargadosException("Los personajes no están cargados. Deben cargarse previo a cargar las ligas");
        }

        List<RegistroLiga> dtos = persistencia.leerDatos();

        for (RegistroLiga dto : dtos) {

            //buscamos si ya existe el nombre de la liga en las ligas ya dadas de alta
            if (repositorioLigas.obtenerPorNombre(dto.getNombre()) != null) {
                //excepcion porque ya existe la liga en la lista de ligas hasta ahora cargadas
                throw new LigaYaExistenteException("La liga que se quiere crear ya existe");
            }

            TipoCompetidor tipoCompetidor = null;

            //para los nombres restantes buscamos si son ligas o son personajes,
            //y creamos una lista de competidores
            List<Competidor> competidores = new ArrayList<Competidor>();
            for (String nombreCompetidor : dto.getNombreCompetidores()) {
                Competidor c = obtenerCompetidor(nombreCompetidor);

                //si no se encuentra ningun competidor con tal nombre
                if (c == null) {
                    //excepcion porque no existe ningun competidor con tal nombre
                    throw new CompetidorNoEncontrado("No existe competidor con el nombre de " + nombreCompetidor);
                }

                //se setea el tipo de la liga con el tipo del primer competidor encontrado
                if (tipoCompetidor == null) {
                    tipoCompetidor = c.getTipo();
                }

                /* -- codigo comentado porque esto ya lo maneja la propia clase de liga --
                //si el competidor obtenido no es del tipo de la liga
                //entonces se lanza excepcion
                if (tipoCompetidor != null && c.getTipo() != tipoCompetidor) {
                    throw new IllegalArgumentException("El competidor no es compatible con la liga");
                }
                 */

                competidores.add(c);
            }

            repositorioLigas.guardar(
                    new Liga(tipoCompetidor, dto.getNombre(), id++,
                            competidores.toArray(competidores.toArray(new Competidor[0]))
                    )
            );
        }

        return repositorioLigas.listar();
    }

    //consideraciones
    //no se puede tener ligas y personajes que se llamen igual
    //los personajes deben estar previamente cargados, sino esto tira excepcion
    private Competidor obtenerCompetidor(String nombreCompetidor) {
        Competidor c;
        //verificamos lista de ligas ya creadas para ver si encontramos si ya estaba cargada
        c = repositorioLigas.obtenerPorNombre(nombreCompetidor);

        //si se encontro retorno la liga
        if (c != null) {
            return c;
        }

        //verificamos repositorio de personajes para comprobar
        // si hay un personaje que coincida con el nombre pasado
        c = repositorioPersonajes.obtenerPorNombre(nombreCompetidor);

        return c;
    }

    @Override
    public List<Liga> listar(TipoCompetidor... filtroTipo) {
    	List<Liga> copiaLocal = new ArrayList<Liga>(repositorioLigas.listar());
    	if (filtroTipo.length > 0) {
    		for (Liga p : repositorioLigas.listar()) {
    			if (p.getTipo() != filtroTipo[0])
    				copiaLocal.remove(p);
    		}    		
    	}
        return copiaLocal;
    }

    @Override
    public Liga crear(TipoCompetidor tipo, String nombre) {
        int ultimoId = repositorioLigas.listar().get(repositorioLigas.listar().size() - 1).getId();
        Liga liga = new Liga(tipo, nombre, ultimoId + 1);
        repositorioLigas.guardar(liga);
        return liga;
    }

    @Override
    public void persistir() {
        persistencia.guardar(repositorioLigas.listar());
    }

	@Override
	public void printLista(String header, TipoCompetidor... filtroTipo) {
		
		List<Liga> lista = listar(filtroTipo);
		System.out.println(header);
		if (lista.isEmpty()) {
			System.out.println("-----------------------------------------------");
			System.out.println("Nada que mostrar. Volviendo...");
			System.out.println("-----------------------------------------------");
			return;
		}
		
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("%-3s %-8s %-20s %-70s %-7s %-7s %-7s %-7s%n", "ID", "| Tipo", "| Nombre Liga", "| Alias Competidores", "| V", "| F", "| R", "| D");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
		for (Liga l : lista) {
			System.out.printf("%-3s %-8s %-20s %-70s %-7s %-7s %-7s %-7s%n", 	   l.getId(), "|"
																				+  l.getTipo(), "|" 
																				+  l.getNombre(), "|" 
																				+  l.getNombreCompetidor(), "|" 
																				+  l.getCaracteristica(Caracteristica.VELOCIDAD), "|" 
																				+  l.getCaracteristica(Caracteristica.FUERZA), "|" 
																				+  l.getCaracteristica(Caracteristica.RESISTENCIA), "|" 
																				+  l.getCaracteristica(Caracteristica.DESTREZA));
		}
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
	}
	
	public Liga GetPorID(int id) {
    	for (Liga p : repositorioLigas.listar()) {
    		if (p.getId() == id) return p;
    	}
    	throw new CompetidorNoEncontrado("ID liga: " + id);
    }
}
