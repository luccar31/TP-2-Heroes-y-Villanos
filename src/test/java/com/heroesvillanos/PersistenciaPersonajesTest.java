package com.heroesvillanos;

import com.heroesvillanos.dominio.Caracteristica;
import com.heroesvillanos.dominio.Personaje;
import com.heroesvillanos.dominio.RegistroPersonaje;
import com.heroesvillanos.dominio.TipoCompetidor;
import com.heroesvillanos.exception.FormatoArchivoInvalidoException;
import com.heroesvillanos.persistencia.Persistencia;
import com.heroesvillanos.persistencia.PersistenciaPersonajesEnArchivo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersistenciaPersonajesTest {

    @Test
    public void dadoQueTenemosUnArchivoVacio_cuandoLeemos_noHayRegistros(){
        Persistencia<RegistroPersonaje, Personaje> persistencia = new PersistenciaPersonajesEnArchivo("C:\\Users\\Lucas\\Desktop\\TP-2-Heroes-y-Villanos\\src\\test\\resources\\archivos\\personajesVacioTest.in");
        List<RegistroPersonaje> registros = persistencia.leerDatos();

        Assertions.assertEquals(0, registros.size());
    }

    @Test
    public void dadoQueTenemosUnArchivoConPersonaje_cuandoLeemos_existeRegistroYEsCorrecto(){
        Persistencia<RegistroPersonaje, Personaje> persistencia = new PersistenciaPersonajesEnArchivo("C:\\Users\\Lucas\\Desktop\\TP-2-Heroes-y-Villanos\\src\\test\\resources\\archivos\\personajesCorrectosTest.in");
        List<RegistroPersonaje> registros = persistencia.leerDatos();

        Assertions.assertEquals(1, registros.size());
        Assertions.assertEquals(TipoCompetidor.HEROE, registros.get(0).getTipo());
        Assertions.assertEquals("Edward Blake", registros.get(0).getNombre());
        Assertions.assertEquals("The Comedian", registros.get(0).getAlias());
        Assertions.assertEquals(100, registros.get(0).getVel());
        Assertions.assertEquals(200, registros.get(0).getFue());
        Assertions.assertEquals(150, registros.get(0).getRes());
        Assertions.assertEquals(50, registros.get(0).getDes());
    }

    @Test
    public void dadoQueTenemosUnArchivoInvalido_cuandoLeemos_seLanzaExcepcionFormatoIncorrecto1(){
        Persistencia<RegistroPersonaje, Personaje> persistencia = new PersistenciaPersonajesEnArchivo("C:\\Users\\Lucas\\Desktop\\TP-2-Heroes-y-Villanos\\src\\test\\resources\\archivos\\personajesMalFormato1Test.in");
        Assertions.assertThrows(FormatoArchivoInvalidoException.class, () -> {
            persistencia.leerDatos();
        });
    }

    @Test
    public void dadoQueTenemosUnArchivoInvalido_cuandoLeemos_seLanzaExcepcionFormatoIncorrecto2(){
        Persistencia<RegistroPersonaje, Personaje> persistencia = new PersistenciaPersonajesEnArchivo("C:\\Users\\Lucas\\Desktop\\TP-2-Heroes-y-Villanos\\src\\test\\resources\\archivos\\personajesMalFormato2Test.in");
        Assertions.assertThrows(FormatoArchivoInvalidoException.class, () -> {
            persistencia.leerDatos();
        });
    }

    @Test
    public void dadoQueTenemosUnArchivoInvalido_cuandoLeemos_seLanzaExcepcionFormatoIncorrecto3(){
        Persistencia<RegistroPersonaje, Personaje> persistencia = new PersistenciaPersonajesEnArchivo("C:\\Users\\Lucas\\Desktop\\TP-2-Heroes-y-Villanos\\src\\test\\resources\\archivos\\personajesMalFormato3Test.in");
        Assertions.assertThrows(FormatoArchivoInvalidoException.class, () -> {
            persistencia.leerDatos();
        });
    }

    @Test
    public void dadaUnaListaDePersonajes_cuandoSeGuardanEnArchivo_seLeenCorrectamente() throws IOException {
        Map<Caracteristica, Integer> caracteristicas = new HashMap<>();
        caracteristicas.put(Caracteristica.VELOCIDAD, 100);
        caracteristicas.put(Caracteristica.FUERZA, 100);
        caracteristicas.put(Caracteristica.DESTREZA, 100);
        caracteristicas.put(Caracteristica.RESISTENCIA, 100);
        Personaje personaje1 = new Personaje(1, "Nombre 1", "Alias 1", TipoCompetidor.HEROE, caracteristicas);
        Personaje personaje2 = new Personaje(2, "Nombre 2", "Alias 2", TipoCompetidor.HEROE, caracteristicas);

        List<Personaje> personajes = new ArrayList<>();
        personajes.add(personaje1);
        personajes.add(personaje2);

        Persistencia<RegistroPersonaje, Personaje> persistencia = new PersistenciaPersonajesEnArchivo("C:\\Users\\Lucas\\Desktop\\TP-2-Heroes-y-Villanos\\src\\test\\resources\\archivos\\personajesGuardadoTest.in");
        persistencia.guardar(personajes);

        Path path = Paths.get("C:\\Users\\Lucas\\Desktop\\TP-2-Heroes-y-Villanos\\src\\test\\resources\\archivos\\personajesGuardadoTest.in");
        List<String> lineas = Files.readAllLines(path);

        Assertions.assertNotNull(lineas);
        Assertions.assertEquals(2, lineas.size());
        Assertions.assertEquals("Héroe, Nombre 1, Alias 1, 100, 100, 100, 100", lineas.get(0));
        Assertions.assertEquals("Héroe, Nombre 2, Alias 2, 100, 100, 100, 100", lineas.get(1));
    }


}