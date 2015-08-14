package gui;

import java.util.ArrayList;

import entidades.ExceptionTanteador;
import entidades.Jugador;
import entidades.Tanteador;

public class TableroConsola {
	
	public String dibujarTablero(Tanteador tanteador) throws ExceptionTanteador {
		
		String tablero;
		
		Jugador jugador1=tanteador.getPartido().getJugador1();
		Jugador jugador2=tanteador.getPartido().getJugador2();
		// Header
		if (tanteador.getPartido().isA3Sets()) {
			tablero="---------------------------------------------\n"+	
					"|                        | GAME | 1 | 2 | 3 | \n"+
					"---------------------------------------------\n";
					
		} else {
			tablero="-----------------------------------------------------\n"+	
					"|                        | GAME | 1 | 2 | 3 | 4 | 5 |\n"+
					"-----------------------------------------------------\n"
					;
		}
		
		ArrayList<Integer> tanteadorSets = tanteador.getTanteadorSETS();
		
		
		
		
		// Jugador1
		tablero+="| " + String.format("%1$-22s",jugador1.getNombre()) + " |";
		tablero+="  "+String.format("%1$-4s",tanteador.getTanteadorGameEnJuego()[0])+"|";
		int i1 = 0;
		for (Integer sets : tanteadorSets) {
			if (i1 % 2 == 0) {
				tablero+=" "+sets+" |";
			} 
			i1++;
		}
		
		
		if (tanteador.getPartido().isA3Sets()) {
			tablero+="\n-------------------------|------|---|---|---|\n";
		} else {
			tablero+="\n-------------------------|------|---|---|---|---|---|\n";
		}
		
		
		// Jugador 2
		tablero+="| " + String.format("%1$-22s",jugador2.getNombre()) + " |" ;
		tablero+="  "+String.format("%1$-4s",tanteador.getTanteadorGameEnJuego()[1])+"|";
		
		i1 = 0;
		for (Integer sets : tanteadorSets) {
			if (i1 % 2 != 0) {
				tablero+=" "+sets+" |";
			} 
			i1++;
		}
		
		
		if (tanteador.getPartido().isA3Sets()) {
			tablero+="\n---------------------------------------------\n";
		} else {
			tablero+="\n-------------------------------------------------------\n";
		}
			
		
		// Opciones
		
		if (tanteador.getPartido().isEnJuego()) {
		tablero+="Ingrese: \n"+
		"1 - punto Jugador 1\n"+
		"2 - punto Jugador 2\n";
		} else {
			tablero+=" PARTIDO TERMINADO\n"+
					"Desea comenzar uno nuevo? \n"+
					"Ingrese 'S' para iniciar: ";
		}
		
		return tablero;
	}
	

}
