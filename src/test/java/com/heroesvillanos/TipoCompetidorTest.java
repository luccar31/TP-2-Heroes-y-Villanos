package com.heroesvillanos;
import com.heroesvillanos.dominio.TipoCompetidor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TipoCompetidorTest {

    private final String tipoCompetidorHeroe = "Héroe";
    private final String tipoCompetidorVillano = "Villano";

    @Test
    public void obtenerTipoCompetidorVillano_PorString(){
        Assertions.assertEquals(TipoCompetidor.VILLANO, TipoCompetidor.obtenerPor(tipoCompetidorVillano));
    }

    @Test
    public void obtenerTipoCompetidorHeroe_PorString(){
        Assertions.assertEquals(TipoCompetidor.HEROE, TipoCompetidor.obtenerPor(tipoCompetidorHeroe));
    }

    @Test
    public void TipoCompetidorNoRegistrado_DeberiaArrojarException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            TipoCompetidor.obtenerPor("Dummy");
        });
    }

}