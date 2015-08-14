package entidades;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GuardaJuego{

	
	static String archivoPartido=Rutas.juegoGuardado;
	
	public static void guardarPartido(Partido partido){

		borrarArchivo();
		
		BufferedWriter bw = null;
		try {
			String linea = "";
			ArrayList<Set> sets = partido.getSets();
			bw = new BufferedWriter(new FileWriter(archivoPartido, true));
			for (Set s : sets) {
				linea = Integer.toString(s.getPuntajeJugador1()) + ","
						+ Integer.toString(s.getPuntajeJugador2());

				ArrayList<Game> games = s.getGames();
				for (Game g : games) {
					if (g.isEsTieBreak()) {
						linea += ","+Integer.toString(g
								.getPuntajeTieBreakJugador1())
								+ ","
								+ Integer.toString(g
										.getPuntajeTieBreakJugador2());

					} else {
						linea += ","+g.getPuntajeJugador1() + ","
								+ g.getPuntajeJugador2();
					}
				}
				bw.write(linea);
				bw.write("\n");
			}

			
			

		} catch (IOException e) {
			System.out.println("Error al escribir" + e.getMessage());
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					System.out.println("No se puede cerrar el archivo");
				}
			}
		}
	}

	private static void borrarArchivo() {
		BufferedWriter bw=null;
		try {
			bw = new BufferedWriter(new FileWriter(archivoPartido));
			bw.write("");
			bw.close();
		} catch (IOException e) {
			System.out.println("Error al escribir" + e.getMessage());
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					System.out.println("No se puede cerrar el archivo");
				}
			}
		}
		
	}

	public static void recuperarPartido(Partido partido) {
		
		// TODO Auto-generated method stub
		BufferedReader br = null;
		try{
		    br = new BufferedReader(new FileReader(archivoPartido));
		    String linea = "";
			String separador = ",";	
		    
		    Set set=null;
			ArrayList<Set> sets = new ArrayList<Set>();
		    while ((linea = br.readLine()) != null) {		    		        
		    	String[] puntajes = linea.split(separador);
		    	// Los dos primeros son los sets
		    
		    	ArrayList<Game> games = new ArrayList<Game>();
		    	
		    	int puntajeSetJugador1;
		    	int puntajeSetJugador2;
		    	set=new Set();
		    	
		    	Game game = null ;
		    	for (int i=0; i < puntajes.length; i+=2) {

					if (i == 0) {
						puntajeSetJugador1 = Integer.parseInt(puntajes[i]);
						puntajeSetJugador2 = Integer.parseInt(puntajes[i + 1]);
						set.setPuntajeJugador1(puntajeSetJugador1);
						set.setPuntajeJugador2(puntajeSetJugador2);
					} else {
						game = new Game();
						game.setPuntajeJugador1(puntajes[i]);
						game.setPuntajeJugador2(puntajes[i+1]);
						games.add(game);
					}
//					System.out.println("Puntajes:"+puntajes[i]+ " | "+puntajes[i+1]);
		    	}
		    	
				set.setGames(games);
				if ((set.getPuntajeJugador1() == 6 && set.getPuntajeJugador2() < 5)
						|| (set.getPuntajeJugador2() == 6 && set
								.getPuntajeJugador1() < 5)
						|| set.getPuntajeJugador1() == 7
						|| set.getPuntajeJugador2() == 7) {
					set.setGameEnJuego(null);
				} else {
					set.setGameEnJuego(game);
				}
				sets.add(set);
			}
		    if (set != null) {
		    	partido.setSets(sets);
		    	partido.setSetEnJuego(set);
		    	partido.setEnJuego(true);
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

}