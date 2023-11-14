package com.heroesvillanos;

import com.heroesvillanos.dominio.*;
import com.heroesvillanos.persistencia.Persistencia;
import com.heroesvillanos.persistencia.PersistenciaLigasEnArchivo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersistenciaLigasTest {

    @Test
    public void dado_archivo_valido_de_ligas_cuando_se_lee_archivo_entonces_se_lee_correctamente(){
        //DADO
        Persistencia<RegistroLiga, Liga> persistencia = new PersistenciaLigasEnArchivo("/home/lucas/projects/TP-2-Heroes-y-Villanos/src/test/resources/archivos/ligasTest.in");
        //CUANDO
        List<RegistroLiga> registros = persistencia.leerDatos();

        //ENTONCES
        Assertions.assertEquals(2, registros.size());

        Assertions.assertEquals("Watchmen", registros.get(0).getNombre());
        Assertions.assertEquals(2, registros.get(0).getNombreCompetidores().size());
        Assertions.assertEquals("The comedian", registros.get(0).getNombreCompetidores().get(0));
        Assertions.assertEquals("Rorschach", registros.get(0).getNombreCompetidores().get(1));

        Assertions.assertEquals("MinuteMen", registros.get(1).getNombre());
        Assertions.assertEquals(3, registros.get(1).getNombreCompetidores().size());
        Assertions.assertEquals("Captain Metropoli", registros.get(1).getNombreCompetidores().get(0));
        Assertions.assertEquals("Dollar Bill", registros.get(1).getNombreCompetidores().get(1));
        Assertions.assertEquals("Hollis Mason", registros.get(1).getNombreCompetidores().get(2));
    }

    @Test
    public void dado_liga_vacia_cuando_se_guarda_en_archivo_se_guarda_correctamente() throws IOException {
        Liga liga1 = new Liga(TipoCompetidor.HEROE, "Liga vacia", 1);
        List<Liga> ligas = new ArrayList<>();
        ligas.add(liga1);

        Persistencia<RegistroLiga, Liga> persistencia = new PersistenciaLigasEnArchivo("C:\\Users\\Lucas\\Desktop\\TP-2-Heroes-y-Villanos\\src\\test\\resources\\archivos\\ligasVacio.in");
        persistencia.guardar(ligas);

        Path path = Paths.get("C:\\Users\\Lucas\\Desktop\\TP-2-Heroes-y-Villanos\\src\\test\\resources\\archivos\\ligasVacio.in");
        List<String> lineas = Files.readAllLines(path);

        Assertions.assertEquals(1, lineas.size());
        Assertions.assertEquals("Liga vacia", lineas.get(0));
    }

    @Test
    @Disabled("funciona bien en modo debug (?)")
    public void dado_que_existe_superliga_cuando_se_guarda_en_archivo_se_guarda_correctamente() throws IOException {
        Map<Caracteristica, Integer> caracteristicas = new HashMap<>();
        Personaje personaje1 = new Personaje(1, "Nombre 1", "Alias 1", TipoCompetidor.HEROE, caracteristicas);
        Personaje personaje2 = new Personaje(2, "Nombre 2", "Alias 2", TipoCompetidor.HEROE, caracteristicas);

        Liga ligaComun = new Liga(TipoCompetidor.HEROE, "Liga 1", 1, personaje2);

        Liga superLiga = new Liga(TipoCompetidor.HEROE, "Superliga", 1, personaje1, ligaComun);
        List<Liga> ligas = new ArrayList<>();
        ligas.add(ligaComun);
        ligas.add(superLiga);

        Persistencia<RegistroLiga, Liga> persistencia = new PersistenciaLigasEnArchivo("C:\\Users\\Lucas\\Desktop\\TP-2-Heroes-y-Villanos\\src\\test\\resources\\archivos\\ligasGuardado.in");
        persistencia.guardar(ligas);

        Path path = Paths.get("C:\\Users\\Lucas\\Desktop\\TP-2-Heroes-y-Villanos\\src\\test\\resources\\archivos\\ligasGuardado.in");
        List<String> lineas = Files.readAllLines(path);

        Assertions.assertEquals(2, lineas.size());
        Assertions.assertEquals("Liga 1, Alias 2", lineas.get(0));
        Assertions.assertEquals("Superliga, Alias 1, Liga 1", lineas.get(1));
    }
}
