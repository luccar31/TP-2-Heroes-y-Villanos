package com.heroesvillanos;
import com.heroesvillanos.dominio.TipoCompetidor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TipoCompetidorTest {

    @Test
    public void obtenerTipoCompetidorVillano_PorString(){
        Assertions.assertEquals(TipoCompetidor.VILLANO, TipoCompetidor.obtenerPor("Héroe"));
    }

    @Test
    public void obtenerTipoCompetidorHeroe_PorString(){
        Assertions.assertEquals(TipoCompetidor.HEROE, TipoCompetidor.obtenerPor("Villano"));
    }

    @Test
    public void TipoCompetidorNoRegistrado_DeberiaArrojarException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            TipoCompetidor.obtenerPor("Dummy");
        });
    }

}