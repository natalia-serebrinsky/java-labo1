package entidades;

import java.util.ArrayList;


public class Set {

	private int puntajeJugador1;
	private int puntajeJugador2;
	private boolean enJuego;
	private ArrayList<Game> games;
	private Game gameEnJuego;
	
	
	public Game getGameEnJuego() {
		return gameEnJuego;
	}


	public void setGameEnJuego(Game gameEnJuego) {
		this.gameEnJuego = gameEnJuego;
	}


	public ArrayList<Game> getGames() {
		return games;
	}


	public void setGames(ArrayList<Game> games) {
		this.games = games;
	}


	// Constructor
	public Set() {
		enJuego=true;
	}
	
	
	// Getters and Setters
	
	public int getPuntajeJugador1() {
		return puntajeJugador1;
	}
	public void setPuntajeJugador1(int puntajeJugador1) {
		this.puntajeJugador1 = puntajeJugador1;
	}
	public int getPuntajeJugador2() {
		return puntajeJugador2;
	}
	public void setPuntajeJugador2(int puntajeJugador2) {
		this.puntajeJugador2 = puntajeJugador2;
	}
	public boolean isEnJuego() {
		return enJuego;
	}
	public void setEnJuego(boolean enJuego) {
		this.enJuego = enJuego;
	}
	
	
	
}
