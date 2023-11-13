package com.heroesvillanos;
import com.heroesvillanos.dominio.TipoCompetidor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TipoCompetidorTest {

    @Test
    public void obtener_tipo_competidor_villano_por_string(){
        Assertions.assertEquals(TipoCompetidor.VILLANO, TipoCompetidor.obtenerPor("Héroe"));
    }

    @Test
    public void obtener_tipo_competidor_heroe_por_string(){
        Assertions.assertEquals(TipoCompetidor.HEROE, TipoCompetidor.obtenerPor("Villano"));
    }

    @Test
    public void tipo_competidor_no_registrado_deberia_arrojar_exception(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            TipoCompetidor.obtenerPor("Dummy");
        });
    }

}