package app;

import entidades.ExceptionTanteador;
import entidades.Rutas;
import entidades.Tanteador;
import gui.Tablero;

public class InicioSwing {

	public static void main(String[] args) {
		
	Tanteador tanteador = new Tanteador();

	String ruta = Rutas.jugadores;
	
	//Inicio el Partido
	try {
		tanteador.iniciarPartido(ruta, true);
		Tablero tablero=new Tablero(tanteador);
		tablero.setVisible(true);
	} catch (ExceptionTanteador e) {
		System.out.println("Error en la aplicacion " + e.getMessage());
	} 
	
	
	}
	
}
