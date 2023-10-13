package com.heroesvillanos;

public final class Menu {

    private static Menu INSTANCE;

    //patron singleton implementado para el objeto menu
    public static Menu getInstance(){
        if(INSTANCE == null){
            INSTANCE = new Menu();
        }
        return INSTANCE;
    }

    public void menu(){
        /*
        1: administracion de personajes
          a: Carga desde archivo cargarPersonajes(String nombreArchivo)
          b: Creación crearPersonaje(String nombreReal, String nombreSuper, )
          c: Listado
          d: Guardar en archivo todos los personajes
        2: administracion de ligas
          a: Carga desde archivo
          b: Creación
          c: Listado
          d: Guardar en archivo todos las ligas
        3: combates
          a: Personaje contra Personaje (definiendo característica)
          b: Personaje contra Liga (definiendo característica)
          c: Liga contra Liga (definiendo característica)
        4: reportes
          a: Todos los personajes o ligas que venzan a un personaje dado para cierta característica
          b: Listado ordenado de personajes por múltiples características
        */
    }

}
