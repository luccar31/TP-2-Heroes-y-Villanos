package com.heroesvillanos.servicios;

import com.heroesvillanos.dominio.Caracteristica;
import com.heroesvillanos.dominio.Personaje;
import com.heroesvillanos.dominio.RegistroPersonaje;
import com.heroesvillanos.dominio.TipoCompetidor;
import com.heroesvillanos.exception.CompetidorNoEncontrado;
import com.heroesvillanos.exception.PersonajeYaExistenteException;
import com.heroesvillanos.persistencia.Persistencia;
import com.heroesvillanos.repositorio.Repositorio;

import java.util.ArrayList;
import java.util.List;


public class ServicioPersonajes implements IServicioPersonajes {

    private final Repositorio<Personaje> repositorio;
    private final Persistencia<RegistroPersonaje, Personaje> persistencia;

    public ServicioPersonajes(Repositorio<Personaje> repositorioPersonajes, Persistencia<RegistroPersonaje, Personaje> persistencia) {
        this.repositorio = repositorioPersonajes;
        this.persistencia = persistencia;
    }

    public List<Personaje> cargar() {
        int id = 1;

        List<RegistroPersonaje> dtos = persistencia.leerDatos();

        for (RegistroPersonaje dto : dtos) {

            //si el nombre del personaje ya existe en el repo, entonces no se puede crear
            Personaje p = repositorio.obtenerPorNombre(dto.getAlias());
            if (p != null) {
                throw new PersonajeYaExistenteException("El personaje que se quiere crear ya existe: " + p.getAlias());
            }

            repositorio.guardar(
                    new Personaje(id++,
                            dto.getNombre(), dto.getAlias(), dto.getTipo(),
                            dto.getVel(), dto.getFue(), dto.getRes(), dto.getDes()
                    )
            );
        }

        return repositorio.listar();
    }

    public List<Personaje> listar(TipoCompetidor... filtroTipo) {
        List<Personaje> copiaLocal = new ArrayList<Personaje>(repositorio.listar());
        if (filtroTipo.length > 0) {
            for (Personaje p : repositorio.listar()) {
                if (p.getTipo() != filtroTipo[0])
                    copiaLocal.remove(p);
            }
        }
        return copiaLocal;
    }

    @Override
    public void printLista(String header, TipoCompetidor... filtroTipo) {

        List<Personaje> lista = listar(filtroTipo);

        System.out.println(header);
        if (lista.isEmpty()) {
            System.out.println("-----------------------------------------------");
            System.out.println("Nada que mostrar. Volviendo...");
            System.out.println("-----------------------------------------------");
            return;
        }

        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.printf("%-3s %-8s %-20s %-20s %-7s %-7s %-7s %-7s%n", "ID", "| Tipo", "| Nombre Real", "| Alias", "| Velocidad", "| Fuerza", "| Resistencia", "|Destreza");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        for (Personaje c : lista) {
            //String[] results = l.toString().split(",");
            System.out.printf("%-3s %-8s %-20s %-20s %-11s %-8s %-13s %-7s%n", c.getId(), "|"
                    + c.getTipo(), "|"
                    + c.getNombreReal(), "|"
                    + c.getAlias(), "|"
                    + c.getCaracteristica(Caracteristica.VELOCIDAD), "|"
                    + c.getCaracteristica(Caracteristica.FUERZA), "|"
                    + c.getCaracteristica(Caracteristica.RESISTENCIA), "|"
                    + c.getCaracteristica(Caracteristica.DESTREZA));
        }
        System.out.println("-----------------------------------------------------------------------------------------------");
    }

    public Personaje crear(String nombreReal, String alias, TipoCompetidor tipo, int vel, int fue, int res, int des) {
        int ultimoId;
        if (repositorio.listar().isEmpty()) {
            ultimoId = 1;
        } else {
            ultimoId = repositorio.listar().size()+1;
        }
        Personaje personaje = new Personaje(ultimoId++, nombreReal, alias, tipo, vel, fue, res, des);
        repositorio.guardar(personaje);
        return personaje;
    }

    public void persistir() {
        persistencia.guardar(repositorio.listar());
    }

    @Override
    public Personaje getPorID(int id, TipoCompetidor... filtroTipo) {
        for (Personaje p : listar(filtroTipo)) {
            if (p.getId() == id) return p;
        }
        throw new CompetidorNoEncontrado("ID competidor invalido: " + id);
    }
}
