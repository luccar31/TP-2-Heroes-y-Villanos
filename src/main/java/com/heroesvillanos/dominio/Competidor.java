package com.heroesvillanos.dominio;

public interface Competidor<T> {
    <X extends Competidor<X>> boolean esGanador(Competidor<X> competidor);
}
