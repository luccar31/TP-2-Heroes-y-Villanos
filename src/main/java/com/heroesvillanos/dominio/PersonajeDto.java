package com.heroesvillanos.dominio;

public class PersonajeDto {
    private final String nombre;
    private final String alias;
    private final TipoCompetidor tipo;
    private final int vel;
    private final int fue;
    private final int res;
    private final int des;

    public String getNombre() {
        return nombre;
    }

    public String getAlias() {
        return alias;
    }

    public TipoCompetidor getTipo() {
        return tipo;
    }

    public int getVel() {
        return vel;
    }

    public int getFue() {
        return fue;
    }

    public int getRes() {
        return res;
    }

    public int getDes() {
        return des;
    }

    public PersonajeDto(String nombre, String alias, String tipo, int vel, int fue, int res, int des) {
        this.nombre = nombre;
        this.alias = alias;
        this.tipo = TipoCompetidor.obtenerPor(tipo);
        this.vel = vel;
        this.fue = fue;
        this.res = res;
        this.des = des;
    }
}
