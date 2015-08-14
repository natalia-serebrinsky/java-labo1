package entidades;

public class Jugador {
	
	private String nombre;
	private String pais;
	private String rutaFoto;
	
	
	// Constructor
	public Jugador (String nombre, String pais, String rutaFoto) {
		this.nombre=nombre;
		this.pais=pais;
		this.rutaFoto=rutaFoto;
	}
	
	// Getters And Setters
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getRutaFoto() {
		return rutaFoto;
	}
	public void setRutaFoto(String rutaFoto) {
		this.rutaFoto = rutaFoto;
	}

	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", pais=" + pais + ", rutaFoto="
				+ rutaFoto + "]";
	}

}
