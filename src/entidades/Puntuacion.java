package entidades;

import java.util.HashMap;


public class Puntuacion {
	
	private Jugador jugador;
	private String puntajeJugador1;
	private String puntajeJugador2;
	static private HashMap<Puntuacion, String[]> puntuacion;
	
	public Puntuacion(Jugador jugador, String puntajeJugador1, String puntajeJugador2) {
		super();
		this.jugador = jugador;
		this.puntajeJugador1 = puntajeJugador1;
		this.puntajeJugador2 = puntajeJugador2;
	}
	
	static void iniciarPuntuacion(Partido partido) {
		puntuacion=new HashMap<Puntuacion, String[]>();

//	    2 "0-0"-> "0-15";
		puntuacion.put(new Puntuacion(partido.getJugador2(), "0", "0"),new String[]{"0","15"});
//	    2 "0"Gano"5" -> "0-30";
		puntuacion.put(new Puntuacion(partido.getJugador2(), "0", "15"),new String[]{"0","30"});
//	    2 "0-30" -> "0-40";
		puntuacion.put(new Puntuacion(partido.getJugador2(), "0", "30"),new String[]{"0","40"});
//	    2 "0-40" -> "Gano2";
		puntuacion.put(new Puntuacion(partido.getJugador2(), "0", "40"),new String[]{"","Gano"});
		
//	    2 "0-40" -> "Gano2";
		puntuacion.put(new Puntuacion(partido.getJugador1(), "0", "40"),new String[]{"15","40"});

//	    1 "0-0"-> "15-0";
		puntuacion.put(new Puntuacion(partido.getJugador1(), "0", "0"),new String[]{"15","0"});
		
//	    1 "15-0" -> "30-0";
		puntuacion.put(new Puntuacion(partido.getJugador1(), "15", "0"),new String[]{"30","0"});
		
//	    1 "30-0" -> "40-0";
		puntuacion.put(new Puntuacion(partido.getJugador1(), "30", "0"),new String[]{"40","0"});
		
//	    2 "15-0" -> "15"Gano"5";
		puntuacion.put(new Puntuacion(partido.getJugador2(), "15", "0"),new String[]{"15","15"});
		
//	    2 "30-0" -> "30"Gano"5"
		puntuacion.put(new Puntuacion(partido.getJugador2(), "30", "0"),new String[]{"30","15"});
		
//	    1 "0"Gano"5" -> "15"Gano"5";
		puntuacion.put(new Puntuacion(partido.getJugador1(), "0", "15"),new String[]{"15","15"});
		
//	    1 "15"Gano"5" -> "30"Gano"5";
		puntuacion.put(new Puntuacion(partido.getJugador1(), "15", "15"),new String[]{"30","15"});
		
//	    2 "15"Gano"5" -> "15-30";
		puntuacion.put(new Puntuacion(partido.getJugador2(), "15", "15"),new String[]{"15","30"});
		
//	    1 "30"Gano"5" -> "40"Gano"5" ;
		puntuacion.put(new Puntuacion(partido.getJugador1(), "30", "15"),new String[]{"40","15"});
		
//	    2 "30"Gano"5" -> "30-30";
		puntuacion.put(new Puntuacion(partido.getJugador2(), "30", "15"),new String[]{"30","30"});
		
//	    1 "40"Gano"5" -> "Gano1";
		puntuacion.put(new Puntuacion(partido.getJugador1(), "40", "15"),new String[]{"Gano",""});

//	    2 "40"Gano"5" -> "Gano1";
		puntuacion.put(new Puntuacion(partido.getJugador2(), "40", "15"),new String[]{"40","30"});

		
//	    1 "0-30" -> "15-30";
		puntuacion.put(new Puntuacion(partido.getJugador1(), "0", "30"),new String[]{"15","30"});
		
//	    1 "15-30" -> "30-30";
		puntuacion.put(new Puntuacion(partido.getJugador1(), "15", "30"),new String[]{"30","30"});
		
//	    2 "15-30" -> "15-40";
		puntuacion.put(new Puntuacion(partido.getJugador2(), "15", "30"),new String[]{"15","40"});
		
//	    2 "15-40" -> "Gano2";
		puntuacion.put(new Puntuacion(partido.getJugador2(), "15", "40"),new String[]{"","Gano"});
		
//	    1 "15-40" -> "30-40";
		puntuacion.put(new Puntuacion(partido.getJugador1(), "15", "40"),new String[]{"30","40"});
		
//	    2 "30-40" -> "Gano2";
		puntuacion.put(new Puntuacion(partido.getJugador2(), "30", "40"),new String[]{"","Gano"});
		
//	    1 "30-40" -> "40-40";
		puntuacion.put(new Puntuacion(partido.getJugador1(), "30", "40"),new String[]{"40","40"});
		
//	    1 "30-30" -> "40-30";
		puntuacion.put(new Puntuacion(partido.getJugador1(), "30", "30"),new String[]{"40","30"});
		
//	    2 "30-30" -> "30-40";
		puntuacion.put(new Puntuacion(partido.getJugador2(), "30", "30"),new String[]{"30","40"});
		
//	    2 "40-30" -> "40-40";
		puntuacion.put(new Puntuacion(partido.getJugador2(), "40", "30"),new String[]{"40","40"});
		
//	    1 "40-30" -> "Gano1";
		puntuacion.put(new Puntuacion(partido.getJugador1(), "40", "30"),new String[]{"Gano",""});
		
//	    1 "40-0" -> "Gano1";
		puntuacion.put(new Puntuacion(partido.getJugador1(), "40", "0"),new String[]{"Gano",""});
		
//	    2 "40-0" -> "40-15";
		puntuacion.put(new Puntuacion(partido.getJugador2(), "40", "0"),new String[]{"40","15"});
		
//	    1 "40-40" -> "AV- ";
		puntuacion.put(new Puntuacion(partido.getJugador1(), "40", "40"),new String[]{"AV" ,""});
		
//	    2 "40-40" -> " -AV";
		puntuacion.put(new Puntuacion(partido.getJugador2(), "40", "40"),new String[]{ "" ,"AV"});
		
//	    2 "AV- " -> "40-40";
		puntuacion.put(new Puntuacion(partido.getJugador2(), "AV", ""),new String[]{"Deuce","Deuce"});
		
		puntuacion.put(new Puntuacion(partido.getJugador2(), "Deuce", "Deuce"),new String[]{"","AV"});
		
		puntuacion.put(new Puntuacion(partido.getJugador1(), "Deuce", "Deuce"),new String[]{"AV",""});
		
//	    1 "AV- " -> "Gano1";
		puntuacion.put(new Puntuacion(partido.getJugador1(), "AV", ""),new String[]{"Gano",""});
		
//	    1 " -AV" -> "40-40";
		puntuacion.put(new Puntuacion(partido.getJugador1(), "", "AV"),new String[]{"Deuce","Deuce"});
		
		puntuacion.put(new Puntuacion(partido.getJugador1(), "Deuce", "Deuce"),new String[]{"AV",""});
		
		puntuacion.put(new Puntuacion(partido.getJugador2(), "Deuce", "Deuce"),new String[]{"","AV"});
		
//	    2 " -AV" -> "Gano2";
		puntuacion.put(new Puntuacion(partido.getJugador2(), "", "AV"),new String[]{"","Gano"});
		
	}
	
	static public String[] obtenerPuntaje(Jugador jugador, String puntajeJugador1, String puntajeJugador2) {
		
		return puntuacion.get(new Puntuacion(jugador, puntajeJugador1, puntajeJugador2));
	}
	
	
	
	public boolean equals(Object o) {
		if ((o instanceof Puntuacion) && 
					(((Puntuacion) o).getJugador() == this.jugador)
					&& (((Puntuacion) o).getPuntajeJugador1().compareTo(this.puntajeJugador1) == 0)
					&& (((Puntuacion) o).getPuntajeJugador2().compareTo(this.puntajeJugador2) == 0 )) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.jugador == null) ? 0 : this.jugador.hashCode());
        result = prime * result + ((this.puntajeJugador1 == null) ? 0 : this.puntajeJugador1.hashCode());
        result = prime * result + ((this.puntajeJugador2 == null) ? 0 : this.puntajeJugador2.hashCode());
        return result;
    }
	
	
	
	// Getters and Setters
	public String getPuntajeJugador1() {
		return puntajeJugador1;
	}
	public void setPuntajeJugador1(String puntajeJugador1) {
		this.puntajeJugador1 = puntajeJugador1;
	}
	public String getPuntajeJugador2() {
		return puntajeJugador2;
	}
	public void setPuntajeJugador2(String puntajeJugador2) {
		this.puntajeJugador2 = puntajeJugador2;
	}
	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

}