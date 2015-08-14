package entidades;

import java.util.ArrayList;


public class Tanteador {

	static final String[] PUNTAJE_TENIS = { "0", "15", "30", "40", "AV" };
	
	private Partido partido;
		
	// Iniciar el Partido
	public void iniciarPartido (String ruta, boolean a3Sets) throws ExceptionTanteador  {
		
		ServiceJugador serviceJs = new ServiceJugador(ruta);
		Jugador jug1 = serviceJs.GetJugador1();
		Jugador jug2 = serviceJs.GetJugador2();	

		// creo el partido
		partido = new Partido(jug1, jug2, a3Sets, false);
		Puntuacion.iniciarPuntuacion(partido);
		
		GuardaJuego.recuperarPartido(partido);
		
		// inicializo el primer game del set
		if (! partido.isEnJuego()) {
			ArrayList<Game> games = new ArrayList<Game>();
			Game game1 = new Game();
			games.add(game1);

			Set set1 = new Set();
			set1.setGames(games);
			set1.setGameEnJuego(game1);

			ArrayList<Set> sets = new ArrayList<Set>();
			sets.add(set1);

			partido.setSets(sets);
			partido.setSetEnJuego(set1);
			partido.setEnJuego(true);
		}
	
		
	}

	// getTanteadorGameEnJuego
	public String[] getTanteadorGameEnJuego() {
		String[] tanteador = { "", "" };
		ArrayList<Set> sets = partido.getSets();
		for (Set s : sets) {
			if (s.isEnJuego()) {
				ArrayList<Game> games = s.getGames();
				for (Game g : games) {
					if (g.isEnJuego()) {
						if (g.isEsTieBreak()) {
							tanteador[0] = "" + g.getPuntajeTieBreakJugador1();
							tanteador[1] = "" + g.getPuntajeTieBreakJugador2();
						} else {
							tanteador[0] = g.getPuntajeJugador1();
							tanteador[1] = g.getPuntajeJugador2();
						}
					}
				}
			}
		}
		return tanteador;
	}

	// getTanteadorSETS
	public ArrayList<Integer> getTanteadorSETS() {
		ArrayList<Integer> tanteador = new ArrayList<Integer>();
		ArrayList<Set> sets = partido.getSets();
		for (Set s : sets) {
			tanteador.add(s.getPuntajeJugador1());
			tanteador.add(s.getPuntajeJugador2());
		}
		return tanteador;
	}

	// punto Jugador
	public void puntoJugador(Jugador jugador) {

		boolean puntoJugador1 = false;

		int cantidadSets = partido.getSets().size();

		Set s = partido.getSetEnJuego();
		Game g = s.getGameEnJuego();

		if (s.isEnJuego()) {
			// Pregunto si el punto fue para el jugador 1
			if (jugador == partido.getJugador1()) {
				puntoJugador1 = true;
			}

			if (g.isEsTieBreak()) 
			{
				int jug1 = g.getPuntajeTieBreakJugador1();
				int jug2 = g.getPuntajeTieBreakJugador2();

				if (puntoJugador1) 
				{
					if (((jug1 - jug2) < 1) || jug1 < 6) 
					{
						jug1++;
						g.setPuntajeTieBreakJugador1(jug1);
					}else if ((jug1 >= 6) && (jug1 - jug2) > 0) {
						jug1++;
						g.setPuntajeTieBreakJugador1(jug1);
						// gano hay que crear un nuevo set
						s.setPuntajeJugador1(s.getPuntajeJugador1() + 1);
						s.setEnJuego(false);

						if ((partido.isA3Sets() && (cantidadSets == 3))
								|| (!partido.isA3Sets() && (cantidadSets == 5))) {
							// Termino Partido
							partido.setEnJuego(false); // Termino
														// Partido
						} else {
							// nuevo set
							crearSet();
						}
					}
				} else {
					if (((jug2 - jug1) < 1) || jug2 < 6) {
						jug2++;
						g.setPuntajeTieBreakJugador2(jug2);
					} else if ((jug2 >= 6) && (jug2 - jug1) > 0) {
						jug2++;
						g.setPuntajeTieBreakJugador2(jug2);
						// gano hay que crear un nuevo set
						s.setPuntajeJugador2(s.getPuntajeJugador2() + 1);
						s.setEnJuego(false);

						if ((partido.isA3Sets() && (cantidadSets == 3))
								|| (!partido.isA3Sets() && (cantidadSets == 5))) {
							// Termino Partido
							partido.setEnJuego(false); // Termino
														// Partido
						} else {
							// nuevo set
							crearSet();
						}
					}
				}				
				

			} else {
				String[] puntaje = Puntuacion.obtenerPuntaje(jugador,
						g.getPuntajeJugador1(), g.getPuntajeJugador2());
//				System.out.println(puntoJugador1+" Puntajes Actuales: ["+g.getPuntajeJugador1()+ "] ["+g.getPuntajeJugador2()+"]");
				
				g.setPuntajeJugador1(puntaje[0]);
				g.setPuntajeJugador2(puntaje[1]);

				if (g.getPuntajeJugador1().compareTo("Gano") == 0
						|| g.getPuntajeJugador2().compareTo("Gano") == 0) {
					g.setEnJuego(false); // Termino el game
					// Obtengo el puntaje en SET
					int puntajeJugador1 = s.getPuntajeJugador1();
					int puntajeJugador2 = s.getPuntajeJugador2();
					//
					if (puntoJugador1
							&& ((puntajeJugador1 < 5) || (puntajeJugador1 == 5 && puntajeJugador2 == 5))) {
						puntajeJugador1++;
						s.setPuntajeJugador1(puntajeJugador1);

						crearGame(g.isSacaJugador1());
						// new game;

					} else if (!puntoJugador1
							&& ((puntajeJugador2 < 5) || (puntajeJugador1 == 5 && puntajeJugador2 == 5))) {
						puntajeJugador2++;
						s.setPuntajeJugador2(puntajeJugador2);
						// new game
						crearGame(g.isSacaJugador1());

					} else if ((puntoJugador1 && puntajeJugador1 == 5)
							|| (!puntoJugador1 && puntajeJugador2 == 5)) { // Puede
																			// haber
																			// ganado
																			// el
																			// Set
						if ((puntoJugador1 && puntajeJugador2 == 6)
								|| (!puntoJugador1 && puntajeJugador1 == 6)) {
							// // Gano el Set
							if (puntoJugador1) {
								puntajeJugador1++;
								s.setPuntajeJugador1(puntajeJugador1);
							} else {
								puntajeJugador2++;
								s.setPuntajeJugador2(puntajeJugador2);
							}
							// new game is tiebreak;
							crearGame(g.isSacaJugador1());
							partido.getSetEnJuego().getGameEnJuego()
									.setEsTieBreak(true);
						} else {
							// // Gano el Set
							if (puntoJugador1) {
								puntajeJugador1++;
								s.setPuntajeJugador1(puntajeJugador1);
							} else {
								puntajeJugador2++;
								s.setPuntajeJugador2(puntajeJugador2);
							}
							s.setEnJuego(false);
							//
							if ((partido.isA3Sets() && (cantidadSets == 3))
									|| (!partido.isA3Sets() && (cantidadSets == 5))) {
								// // Termino Partido
								partido.setEnJuego(false); // Termino
								// // Partido
							} else {
								// nuevo set
								crearSet();
							}
						}
					}

				}

			}

		GuardaJuego.guardarPartido(partido);

		} else {
			System.out.println("Juego Terminado");
		}

	}
 	
	// crearGame
	void crearGame (boolean quienSaca) {
		Set set=partido.getSetEnJuego();
		ArrayList<Game> games=set.getGames();
		
		Game newGame = new Game();
		newGame.setSacaJugador1(!quienSaca);
		games.add(newGame);
		set.setGameEnJuego(newGame);
	}

	// crearSet
	void crearSet () {
		boolean quienSaca=partido.getSetEnJuego().getGameEnJuego().isSacaJugador1();
		ArrayList<Set> sets=partido.getSets();
		Set newSet = new Set();
		newSet.setGames(new ArrayList<Game>());
		sets.add(newSet);
		partido.setSetEnJuego(newSet);
		// Creo un game para el nuevo Set
		crearGame(quienSaca);
	}
	

	// Getters and Setters
	
	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}
	
	
}

	
