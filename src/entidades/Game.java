package entidades;

public class Game {
		
	private int puntajeTieBreakJugador1;
	private int puntajeTieBreakJugador2;
	private String puntajeJugador1;
	private String puntajeJugador2;
	private boolean enJuego;
	private boolean esTieBreak;
	private boolean sacaJugador1;
	
	
	public Game () {
		enJuego=true;
		sacaJugador1=true;
		esTieBreak=false;
		puntajeJugador1="0";
		puntajeJugador2="0";
	}
	
	// Getters And Setters
	
	public boolean isEsTieBreak() {
		return esTieBreak;
	}
	public void setEsTieBreak(boolean esTieBreak) {
		this.esTieBreak = esTieBreak;
	}
		
	public boolean isEnJuego() {
		return enJuego;
	}
	public void setEnJuego(boolean enJuego) {
		this.enJuego = enJuego;
	}
	public boolean isSacaJugador1() {
		return sacaJugador1;
	}
	public void setSacaJugador1(boolean sacaJugador1) {
		this.sacaJugador1 = sacaJugador1;
	}
	
	public int getPuntajeTieBreakJugador1() {
		return puntajeTieBreakJugador1;
	}

	public void setPuntajeTieBreakJugador1(int puntajeTieBreakJugador1) {
		this.puntajeTieBreakJugador1 = puntajeTieBreakJugador1;
	}

	public int getPuntajeTieBreakJugador2() {
		return puntajeTieBreakJugador2;
	}

	public void setPuntajeTieBreakJugador2(int puntajeTieBreakJugador2) {
		this.puntajeTieBreakJugador2 = puntajeTieBreakJugador2;
	}

	public void setPuntajeJugador1(String puntajeJugador1) {
		this.puntajeJugador1 = puntajeJugador1;
	}

	public void setPuntajeJugador2(String puntajeJugador2) {
		this.puntajeJugador2 = puntajeJugador2;
	}
	
	public String getPuntajeJugador1() {
		return puntajeJugador1;
	}

	public String getPuntajeJugador2() {
		return puntajeJugador2;
	}

	
	
	
}
