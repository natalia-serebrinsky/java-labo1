package test;

import org.junit.Test;

import junit.framework.TestCase;
import entidades.Game;

public class TestGame extends TestCase {
	private Game game = new Game();

	protected void setUp() throws Exception {
		super.setUp();
		game.setPuntajeTieBreakJugador1(15);
		game.setPuntajeTieBreakJugador2(16);
		game.setEnJuego(true);
		game.setEsTieBreak(true);
		game.setSacaJugador1(false);
	}
	
	@Test
	public void test() {
		assertTrue(this.game.isEnJuego());
		assertEquals(15, this.game.getPuntajeTieBreakJugador1());
	}

}
