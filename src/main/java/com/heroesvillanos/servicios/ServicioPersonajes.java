package com.heroesvillanos.servicios;

import com.heroesvillanos.dominio.Personaje;
import com.heroesvillanos.dominio.RegistroPersonaje;
import com.heroesvillanos.dominio.TipoCompetidor;
import com.heroesvillanos.exception.PersonajeYaExistenteException;
import com.heroesvillanos.persistencia.Persistencia;
import com.heroesvillanos.repositorio.Repositorio;

import java.util.List;



public class ServicioPersonajes implements IServicioPersonajes {

    private final Repositorio<Personaje> repositorio;
    private final Persistencia<RegistroPersonaje, Personaje> persistencia;

    public ServicioPersonajes(Repositorio<Personaje> repositorioPersonajes, Persistencia<RegistroPersonaje, Personaje> persistencia) {
        this.repositorio = repositorioPersonajes;
        this.persistencia = persistencia;
    }

    public List<Personaje> cargar() {
        int id = 0;

        List<RegistroPersonaje> dtos = persistencia.leerDatos();

        for (RegistroPersonaje dto : dtos) {

            //si el nombre del personaje ya existe en el repo, entonces no se puede crear
        	Personaje p = repositorio.obtenerPorNombre(dto.getNombre());
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

    public List<Personaje> listar() {
        return repositorio.listar();
    }

    public Personaje crear(String nombreReal, String alias, TipoCompetidor tipo, int vel, int fue, int res, int des) {
        int ultimoId;
        if (repositorio.listar().isEmpty()) {
            ultimoId = 0;
        } else {
            ultimoId = repositorio.listar().get(repositorio.listar().size()).getId() + 1;
        }
        Personaje personaje = new Personaje(ultimoId, nombreReal, alias, tipo, vel, fue, res, des);
        repositorio.guardar(personaje);
        return personaje;
    }

    public void persistir() {
        persistencia.guardar(repositorio.listar());
    }
}
