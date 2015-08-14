package app;

import entidades.ExceptionTanteador;
import entidades.Rutas;
import entidades.Tanteador;
import gui.TableroConsola;

import java.util.Scanner;

public class InicioConsola {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
		Tanteador tanteador = new Tanteador();
		TableroConsola tablero=new TableroConsola();
		
		String ruta = Rutas.jugadores;
				
		// Inicio el Partido
		tanteador.iniciarPartido(ruta, true);		
		
		String entradaTeclado = "";
		do {
			
			try {
				final String os = System.getProperty("os.name");
				if (os.contains("Windows")) {
					Runtime.getRuntime().exec("cls");
				} else {
					Runtime.getRuntime().exec("clear");
				}
			} catch (final Exception e) {
				// Handle any exceptions.
			}

			System.out.println(tablero.dibujarTablero(tanteador));
			Scanner entradaEscaner = new Scanner(System.in); 
			entradaTeclado = entradaEscaner.nextLine(); 
			
			if (entradaTeclado.compareTo("1") == 0) {
				tanteador.puntoJugador(tanteador.getPartido().getJugador1());
			} else if (entradaTeclado.compareTo("2") == 0) {
				tanteador.puntoJugador(tanteador.getPartido().getJugador2());
			} else if (!tanteador.getPartido().isEnJuego() && 
					entradaTeclado.toUpperCase().compareTo("S") == 0) {
				tanteador.iniciarPartido(ruta, true);
			}
				
			
		} while (entradaTeclado.toUpperCase().compareTo("T") != 0);
		} catch (ExceptionTanteador e) {
			System.out.println("Error en la aplicacion " + e.getMessage());
		} 	
			
	}
}
