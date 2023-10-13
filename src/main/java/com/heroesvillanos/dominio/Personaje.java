package com.heroesvillanos.dominio;

public abstract class Personaje<T> implements Competidor<T>{
    private final String nombreReal;
    private final String alias;

    protected Personaje(String nombreReal, String alias) {
        this.nombreReal = nombreReal;
        this.alias = alias;
    }

    public String getNombreReal() {
        return nombreReal;
    }

    public String getAlias() {
        return alias;
    }

    public <X extends Competidor<X>> boolean esGanador(Competidor<X> competidor){
        return false;
    }

}
