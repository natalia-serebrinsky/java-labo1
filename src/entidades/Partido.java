package entidades;

import java.util.ArrayList;

public class Partido {

	private Jugador jugador1;
	private Jugador jugador2;
	private boolean a3Sets;
	private ArrayList<Set> sets;
	private Set setEnJuego;
	private boolean enJuego;
	

	

	// Constructor
	Partido(Jugador jugador1, Jugador jugador2, boolean a3Sets, boolean enJuego) {
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
		this.a3Sets = a3Sets;
		this.enJuego = enJuego;
	}

	// Getters and Setters
	public Set getSetEnJuego() {
		return setEnJuego;
	}

	public void setSetEnJuego(Set setEnJuego) {
		this.setEnJuego = setEnJuego;
	}
	
	public Jugador getJugador1() {
		return jugador1;
	}

	public void setJugador1(Jugador jugador1) {
		this.jugador1 = jugador1;
	}

	public Jugador getJugador2() {
		return jugador2;
	}

	public void setJugador2(Jugador jugador2) {
		this.jugador2 = jugador2;
	}

	public boolean isA3Sets() {
		return a3Sets;
	}

	public void setA3Sets(boolean a3Sets) {
		this.a3Sets = a3Sets;
	}

	public ArrayList<Set> getSets() {
		return sets;
	}

	public void setSets(ArrayList<Set> sets) {
		this.sets = sets;
	}

	public boolean isEnJuego() {
		return enJuego;
	}

	public void setEnJuego(boolean enJuego) {
		this.enJuego = enJuego;
	}

}
