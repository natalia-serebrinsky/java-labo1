package test;

import org.junit.Test;

import junit.framework.TestCase;
import entidades.Set;

public class TestSet extends TestCase {
	
	protected Set set = new Set();

	protected void setUp() throws Exception {
		super.setUp();		
	}
	
	@Test
	public void test() {
		assertTrue(set.isEnJuego());
	}

}
