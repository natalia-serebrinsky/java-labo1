package entidades;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//levanta los datos de los jugadores del archivo txt separado por comas
public class ServiceJugador {

	private String ruta;
	private Jugador jugador1;
	private Jugador jugador2;
	
	ServiceJugador(String ruta)
	{
		this.ruta = ruta;	
		this.SetJugadores();
	}
	
	public void SetJugadores()
	{
		BufferedReader br = null;
		try{
		    br = new BufferedReader(new FileReader(this.ruta));
		    String linea = "";
			String separador = ";";	
		    String nombreJug1 = null, paisOrigJug1 = null, rutaJug1 = null;
		    String nombreJug2 = null, paisOrigJug2 = null, rutaJug2 = null;

		    while ((linea = br.readLine()) != null) {		    		        
		    	String[] jugadores = linea.split(separador);
		    	nombreJug1 =jugadores[0];
		    	paisOrigJug1 = jugadores[1];
		    	rutaJug1 = jugadores[2];
		    	nombreJug2 =jugadores[3];
		    	paisOrigJug2 = jugadores[4];
		    	rutaJug2 = jugadores[5];
		    	this.jugador1 = new Jugador(nombreJug1, paisOrigJug1, rutaJug1);
			    this.jugador2 = new Jugador(nombreJug2, paisOrigJug2, rutaJug2);
			}	    
		    
		  }catch(FileNotFoundException e){
		            System.out.println("El archivo no existe");
		        }catch(IOException e){
		            System.out.println("Error al leer");
		        }catch(Exception e){
		            System.out.println("Error: " + e.getMessage());    
		        }finally {
	        		if (br != null) {
	        			try {
	        				br.close();
	        			} catch (IOException e) {
	        				e.printStackTrace();
	        			}
	        		}
	        	}
	}
	
	public Jugador GetJugador1()
	{
		return this.jugador1;
	}
	
	public Jugador GetJugador2()
	{
		return this.jugador2;		
	}
	
}