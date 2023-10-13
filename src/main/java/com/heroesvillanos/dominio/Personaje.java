package com.heroesvillanos.dominio;

import java.lang.reflect.ParameterizedType;

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
    
    @Override
	public void Show() {
		Class<T> genericClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		System.out.println(nombreReal + " - " + alias + " del tipo: " + genericClass.getSimpleName());
	}

}
