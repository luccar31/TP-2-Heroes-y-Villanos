package com.heroesvillanos.servicios;

import com.heroesvillanos.dominio.Personaje;
import com.heroesvillanos.dominio.PersonajeDto;
import com.heroesvillanos.dominio.TipoCompetidor;
import com.heroesvillanos.persistencia.Persistencia;
import com.heroesvillanos.repositorio.Repositorio;

import java.util.List;

public class ServicioPersonajes implements IServicioPersonajes {

    private final Repositorio<Personaje> repositorio;
    private final Persistencia<PersonajeDto, Personaje> persistencia;

    public ServicioPersonajes(Repositorio<Personaje> repositorioPersonajes, Persistencia<PersonajeDto, Personaje> persistencia) {
        this.repositorio = repositorioPersonajes;
        this.persistencia = persistencia;
    }

    public List<Personaje> cargar() {
        int id = 0;

        List<PersonajeDto> dtos = persistencia.leerDatos();

        for (PersonajeDto dto : dtos) {

            //si el nombre del personaje ya existe en el repo, entonces no se puede crear
            if (repositorio.obtenerPorNombre(dto.getAlias()) != null) {
                throw new IllegalArgumentException("El personaje que se quiere crear ya existe");
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
        int ultimoId = repositorio.listar().get(repositorio.listar().size()).getId();
        Personaje personaje = new Personaje(ultimoId + 1, nombreReal, alias, tipo, vel, fue, res, des);
        repositorio.guardar(personaje);
        return personaje;
    }

    public void persistir() {
        persistencia.guardar(repositorio.listar());
    }
}
