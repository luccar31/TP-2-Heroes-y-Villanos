package com.heroesvillanos.dominio;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.Scanner;

import java.lang.reflect.ParameterizedType;

public abstract class Personaje<T> implements Competidor<T>{
	private final String tipo;
    private final String nombreReal;
    private final String alias;
    private final Map<Caracteristica, Integer> caracteristicas;

    protected Personaje(String tipo, String nombreReal, String alias, Map<Caracteristica, Integer> caracteristica) {
        this.tipo = tipo;
		this.nombreReal = nombreReal;
        this.alias = alias;
        this.caracteristicas = caracteristica;
    }
    
    public String getTipo() {
        return tipo;
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
    public String toString() {
    	return this.tipo +
    			", Nombre Personaje: " + this.alias + 
    			", Nombre Real: " + this.nombreReal +
    			", Caracteristicas: " + this.caracteristicas;
    }
    
    public static void crearPersonaje(List<Personaje<?>> personajes) {
    	String tipo, nombreReal, nombreAlias;
    	int fuerza, velocidad, resistencia, destreza;
    	Map<Caracteristica, Integer> caracteristicas = new HashMap<Caracteristica, Integer>();
    	@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
    	System.out.println("Es un Héroe o Villano?: ");
    	tipo = scanner.nextLine();
    	System.out.println("Ingrese el nombre Real del personaje: ");
    	nombreReal = scanner.nextLine();
    	System.out.println("Ingrese el nombre de Personaje: ");
    	nombreAlias = scanner.nextLine();
    	System.out.println("Ingrese la fuerza del personaje: ");
    	fuerza = Integer.parseInt(scanner.next());
    	System.out.println("Ingrese la velocidad del personaje: ");
    	velocidad = Integer.parseInt(scanner.next());
    	System.out.println("Ingrese la resistencia del personaje: ");
    	resistencia = Integer.parseInt(scanner.next());
    	System.out.println("Ingrese la destreza del personaje: ");
    	destreza = Integer.parseInt(scanner.next());
    	
		caracteristicas.put(Caracteristica.VELOCIDAD, velocidad);
		caracteristicas.put(Caracteristica.FUERZA, fuerza);				
		caracteristicas.put(Caracteristica.RESISTENCIA, resistencia);				
		caracteristicas.put(Caracteristica.DESTREZA, destreza);
    	
    	personajes.add(new Heroe(tipo, nombreReal, nombreAlias, caracteristicas));
    	//Esta es una lista general, falta agregarlo a la lista de Heroe o Villano dependiendo el tipo
    	
    }
    
    public static void listarPersonajes(List<Personaje<?>> personajes) {
    	for (Personaje<?> personaje : personajes) {
		System.out.println(personaje);
		}
    }

    public int getCaracteristica(Caracteristica caracteristica) {
         return caracteristicas.getOrDefault(caracteristica, 0);
    }
	public void Show() {
		Class<T> genericClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		System.out.println(nombreReal + " - " + alias + " del tipo: " + genericClass.getSimpleName());
	}

}
