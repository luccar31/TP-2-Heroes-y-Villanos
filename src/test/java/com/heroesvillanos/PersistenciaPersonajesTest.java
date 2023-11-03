package com.heroesvillanos;

import com.heroesvillanos.dominio.Caracteristica;
import com.heroesvillanos.dominio.Personaje;
import com.heroesvillanos.dominio.RegistroPersonaje;
import com.heroesvillanos.dominio.TipoCompetidor;
import com.heroesvillanos.exception.FormatoPersonajeIncorrectoException;
import com.heroesvillanos.persistencia.Persistencia;
import com.heroesvillanos.persistencia.PersistenciaPersonajesEnArchivo;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
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

        Assert.assertEquals(0, registros.size());
    }

    @Test
    public void dadoQueTenemosUnArchivoConPersonaje_cuandoLeemos_existeRegistroYEsCorrecto(){
        Persistencia<RegistroPersonaje, Personaje> persistencia = new PersistenciaPersonajesEnArchivo("C:\\Users\\Lucas\\Desktop\\TP-2-Heroes-y-Villanos\\src\\test\\resources\\archivos\\personajesCorrectosTest.in");
        List<RegistroPersonaje> registros = persistencia.leerDatos();

        Assert.assertEquals(1, registros.size());
        Assert.assertEquals(TipoCompetidor.HEROE, registros.get(0).getTipo());
        Assert.assertEquals("Edward Blake", registros.get(0).getNombre());
        Assert.assertEquals("The Comedian", registros.get(0).getAlias());
        Assert.assertEquals(100, registros.get(0).getVel());
        Assert.assertEquals(200, registros.get(0).getFue());
        Assert.assertEquals(150, registros.get(0).getRes());
        Assert.assertEquals(50, registros.get(0).getDes());
    }

    @Test(expected = FormatoPersonajeIncorrectoException.class)
    public void dadoQueTenemosUnArchivoInvalido_cuandoLeemos_seLanzaExcepcionFormatoIncorrecto1(){
        Persistencia<RegistroPersonaje, Personaje> persistencia = new PersistenciaPersonajesEnArchivo("C:\\Users\\Lucas\\Desktop\\TP-2-Heroes-y-Villanos\\src\\test\\resources\\archivos\\personajesMalFormato1Test.in");
        persistencia.leerDatos();
    }

    @Test(expected = FormatoPersonajeIncorrectoException.class)
    public void dadoQueTenemosUnArchivoInvalido_cuandoLeemos_seLanzaExcepcionFormatoIncorrecto2(){
        Persistencia<RegistroPersonaje, Personaje> persistencia = new PersistenciaPersonajesEnArchivo("C:\\Users\\Lucas\\Desktop\\TP-2-Heroes-y-Villanos\\src\\test\\resources\\archivos\\personajesMalFormato2Test.in");
        persistencia.leerDatos();
    }

    @Test(expected = FormatoPersonajeIncorrectoException.class)
    public void dadoQueTenemosUnArchivoInvalido_cuandoLeemos_seLanzaExcepcionFormatoIncorrecto3(){
        Persistencia<RegistroPersonaje, Personaje> persistencia = new PersistenciaPersonajesEnArchivo("C:\\Users\\Lucas\\Desktop\\TP-2-Heroes-y-Villanos\\src\\test\\resources\\archivos\\personajesMalFormato3Test.in");
        persistencia.leerDatos();
    }

    @Test
    public void test() throws IOException {
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

        Assert.assertNotNull(lineas);
        Assert.assertEquals(2, lineas.size());
        Assert.assertEquals("Héroe, Nombre 1, Alias 1, 100, 100, 100, 100", lineas.get(0));
        Assert.assertEquals("Héroe, Nombre 2, Alias 2, 100, 100, 100, 100", lineas.get(1));

    }
}
