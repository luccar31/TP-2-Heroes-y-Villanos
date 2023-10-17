package com.heroesvillanos;

import com.heroesvillanos.dominio.*;
import java.util.ArrayList;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Menu menu = Menu.getInstance();
        //menu.menu();
    	
    	try {
    		List<Personaje<?>> personaje = new ArrayList<Personaje<?>>(); 
    		personaje = Archivo.leerPersonajes();
			
			//Personaje.crearPersonaje(personaje);
			Personaje.listarPersonajes(personaje);
			//Archivo.grabarPersonajes(personaje);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	/*System.out.println("------------------------------------");
        System.out.println("Caso Funcional: ");
        System.out.println("------------------------------------");
    	EjemploFuncional();
    	System.out.println("------------------------------------");
    	
    	System.out.println("Caso de error:");
    	System.out.println("------------------------------------");
    	EjemploError();
    	System.out.println("------------------------------------");

    }
    
    private static void EjemploError() {
    	
    	Competidor heroe1 = new Heroe("Edward Blake", "The Comedian");
        Competidor heroe2 = new Heroe("Prueba Heroe", "Rorschach");
        
        Competidor villano1 = new Villano("Adrian Veidt", "Villano en liga de heroes");
        
        Liga<Heroe> ligaHeroes = new Liga<Heroe>();
        ligaHeroes.agregarCompetidor(heroe1);
        ligaHeroes.agregarCompetidor(heroe2);
        ligaHeroes.agregarCompetidor(villano1); // No da error de tipo y lo agrega aunque el tipo de liga sea Heroes.
        
        System.out.println("Liga Heroes con villano: ");
        ligaHeroes.Show();
        System.out.println();
    }
    
    private static void EjemploFuncional() {
    	
        Heroe heroe1 = new Heroe("Edward Blake", "The Comedian");
        Heroe heroe2 = new Heroe("Prueba Heroe", "Rorschach");
        
        Villano villano1 = new Villano("Adrian Veidt", "Ozymandias");
        Villano villano2 = new Villano("Prueba Villano", "Captain Metropoli");
        
        Liga<Heroe> ligaHeroes = new Liga<Heroe>();
        Liga<Villano> ligaVillanos = new Liga<Villano>();
        
        ligaHeroes.agregarCompetidor(heroe1);
        ligaHeroes.agregarCompetidor(heroe2);
        //ligaHeroes.agregarCompetidor(villano1); --> Correcto, error de tipo 
        
        ligaVillanos.agregarCompetidor(villano1);
        ligaVillanos.agregarCompetidor(villano2);
        //ligaVillanos.agregarCompetidor(heroe1); --> Correcto, error de tipo
        
        Liga<Heroe> superLigaHeroes = new Liga<Heroe>();
        Heroe heroe3 = new Heroe("Prueba Heroe", "heroe individual en super liga");
        superLigaHeroes.agregarCompetidor(ligaHeroes);
        superLigaHeroes.agregarCompetidor(heroe3);
        
        
        System.out.println("Liga Heroes");
        ligaHeroes.Show();
        System.out.println();
        
        System.out.println("Liga Villanos");
        ligaVillanos.Show();
        System.out.println();
        
        System.out.println("Super liga de heroes: ");
        superLigaHeroes.Show();
        System.out.println();*/
    }
}