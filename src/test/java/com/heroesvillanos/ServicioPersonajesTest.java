package com.heroesvillanos;

import com.heroesvillanos.dominio.Caracteristica;
import com.heroesvillanos.dominio.Personaje;
import com.heroesvillanos.dominio.RegistroPersonaje;
import com.heroesvillanos.dominio.TipoCompetidor;
import com.heroesvillanos.persistencia.Persistencia;
import com.heroesvillanos.persistencia.PersistenciaPersonajesEnArchivo;
import com.heroesvillanos.repositorio.Repositorio;
import com.heroesvillanos.repositorio.RepositorioPersonajeEnMemoria;
import com.heroesvillanos.servicios.IServicioPersonajes;
import com.heroesvillanos.servicios.ServicioPersonajes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServicioPersonajesTest {

    @Test
    public void dado_archivo_de_personajes_cuando_servicio_carga_entonces_lista_no_vacia(){
        //DADO
        Map<Caracteristica, Integer> caracteristicas = new HashMap<>();
        caracteristicas.put(Caracteristica.VELOCIDAD, 100);
        caracteristicas.put(Caracteristica.FUERZA, 100);
        caracteristicas.put(Caracteristica.DESTREZA, 100);
        caracteristicas.put(Caracteristica.RESISTENCIA, 100);
        Personaje personaje1 = new Personaje(1, "Nombre 1", "Alias 1", TipoCompetidor.HEROE, caracteristicas);
        RegistroPersonaje registro = new RegistroPersonaje("Nombre 1", "Alias 1", "Héroe", 100,100,100,100);

        Repositorio<Personaje> repositorio = new RepositorioPersonajeEnMemoria();
        Persistencia<RegistroPersonaje, Personaje> persistencia = new PersistenciaPersonajesEnArchivo("C:\\Users\\Lucas\\Desktop\\TP-2-Heroes-y-Villanos\\src\\test\\resources\\archivos\\servicioPersonaje\\personajes.in");
        IServicioPersonajes servicioPersonajes = new ServicioPersonajes(repositorio, persistencia);

        //CUANDO
        List<Personaje> lista = servicioPersonajes.cargar();

        //ENTONCES
        Assertions.assertEquals(4, lista.size());
    }

    @Test
    public void dado_personaje_cuando_servicio_lista_entonces_lista_correctamente(){
        //DADO
        Map<Caracteristica, Integer> caracteristicas = new HashMap<>();
        caracteristicas.put(Caracteristica.VELOCIDAD, 100);
        caracteristicas.put(Caracteristica.FUERZA, 100);
        caracteristicas.put(Caracteristica.DESTREZA, 100);
        caracteristicas.put(Caracteristica.RESISTENCIA, 100);
        Repositorio<Personaje> repositorio = new RepositorioPersonajeEnMemoria();
        Persistencia<RegistroPersonaje, Personaje> persistencia = new PersistenciaPersonajesEnArchivo("");
        Personaje personaje1 = new Personaje(1, "Nombre 1", "Alias 1", TipoCompetidor.HEROE, caracteristicas);

        repositorio.guardar(personaje1);

        IServicioPersonajes servicioPersonajes = new ServicioPersonajes(repositorio, persistencia);
        //CUANDO
        List<Personaje> lista = servicioPersonajes.listar();

        //ENTONCES
        Assertions.assertEquals(1, lista.size());
        Assertions.assertEquals("Alias 1", lista.get(0).getNombreCompetidor());
    }

    @Test
    public void dado_datos_cuando_servicio_crea_personaje_entonces_personaje_creado_correctamente(){
        //DADO
        Repositorio<Personaje> repositorio = new RepositorioPersonajeEnMemoria();
        Persistencia<RegistroPersonaje, Personaje> persistencia = new PersistenciaPersonajesEnArchivo("");

        IServicioPersonajes servicioPersonajes = new ServicioPersonajes(repositorio, persistencia);

        //CUANDO
        Personaje personaje = servicioPersonajes.crear("Nombre 1", "Alias 1", TipoCompetidor.HEROE, 100, 100, 100, 100);

        List<Personaje> lista = servicioPersonajes.listar();

        //ENTONCES
        Assertions.assertEquals(1, lista.size());
        Assertions.assertEquals("Nombre 1", personaje.getNombreReal());
    }
}
