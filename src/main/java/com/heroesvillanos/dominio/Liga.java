package com.heroesvillanos.dominio;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Liga<T> implements Competidor<T> {

    public Set<Competidor<T>> competidores;

    public Liga(){
        this.competidores = new HashSet<Competidor<T>>();
    }

    public Liga(Competidor<T>... competidores){
        this.competidores = new HashSet<Competidor<T>>(Arrays.asList(competidores));
    }

    public boolean agregarCompetidor(Competidor<T> competidor){
        return this.competidores.add(competidor);
    }

    public <X extends Competidor<X>> boolean esGanador(Competidor<X> competidor) {
        return false;
    }
       
    public void Show() {
    	for (Competidor<T> competidor : competidores)
    	{
    		competidor.Show();
    	}
	}
}
