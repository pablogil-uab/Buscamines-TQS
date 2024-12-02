
package test.java.cat.uab.tq.buscamines;
import main.java.cat.uab.tq.buscamines.model.Casella;
import main.java.cat.uab.tq.buscamines.model.Mina;
import main.java.cat.uab.tq.buscamines.model.Normal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CasellaTest {

	@Test
	void testCasella() {
		Casella c = new Casella();
		assertEquals(c.getVeins(), 0);
		assertFalse(c.getEsVisible());
		assertTrue((c.getTipus() instanceof Normal));
	}

	@Test
	void testReset() {
		Casella c = new Casella();
		c.reset();
		
		assertEquals(c.getVeins(), 0);
		assertFalse(c.getEsVisible());
		assertTrue((c.getTipus() instanceof Normal));
	}

	@Test
	void testAddVei() {
		Casella c1 = new Casella();
		c1.addVei();
		assertEquals(c1.getVeins(), 1);
		
		
		Casella c2 = new Casella();
		c2.addVei();
		c2.addVei();
		assertEquals(c2.getVeins(), 2);
		
		
		Casella c3 = new Casella();
		for(int i = 0; i < 7; i++) {
			c3.addVei();
		}
		assertEquals(c3.getVeins(), 7);
		
		
		Casella c4 = new Casella();
		for(int i = 0; i < 8; i++) {
			c4.addVei();
		}
		assertEquals(c4.getVeins(), 8);
		
		
		Casella c5 = new Casella();
		for(int i = 0; i < 9; i++) {
			c5.addVei();
		}
		assertEquals(c5.getVeins(), 9);
		
		
		Casella c6 = new Casella();
		for(int i = 0; i < 50; i++) {
			c6.addVei();
		}
		assertEquals(c6.getVeins(), 50);
	}

	@Test
	void testSetBomb() {
		Casella c = new Casella();
		c.setBomb();
		assertTrue(c.getTipus() instanceof Mina);
	}

	@Test
	void testIsBomb() {
		Casella c = new Casella();
		c.setBomb();
		assertTrue(c.isBomb());
		
		Casella c2 = new Casella();
		assertFalse(c2.isBomb());
		
	}

	@Test
	void testMostrarCasella() {
		Casella c = new Casella();
		c.mostrarCasella();
		assertTrue(c.getEsVisible());
		
		Casella c2 = new Casella();
		assertFalse(c2.getEsVisible());
	}

	@Test
	void testToString() {
		Casella c1 = new Casella();
		c1.setBomb();
		c1.mostrarCasella();
		assertEquals("B", c1.toString());
		
		Casella c2 = new Casella();
		assertEquals("*", c2.toString());
		
		Casella c3 = new Casella();
		c3.mostrarCasella();
		assertEquals("0", c3.toString());
		
		Casella c4 = new Casella();
		c4.addVei();
		c4.mostrarCasella();
		assertEquals("1", c4.toString());
		
		Casella c5 = new Casella();
		for(int i = 0; i < 8;i++) {
			c5.addVei();
		}
		c5.mostrarCasella();
		assertEquals("8", c5.toString());
		
	}
	
	@Test
    void testToString_esVisibleFalse() {
        Casella casella = new Casella();
        casella.reset();
        assertEquals("*", casella.toString(), "Cuando esVisible es false, debe devolver '*'.");
    }

    @Test
    void testToString_esVisibleTrue_isBombTrue() {
        Casella casella = new Casella();
        casella.reset();
        casella.setBomb();
        casella.mostrarCasella();
        assertEquals("B", casella.toString(), "Cuando esVisible es true y es una bomba, debe devolver 'B'.");
    }

    @Test
    void testToString_esVisibleTrue_isBombFalse() {
        Casella casella = new Casella();
        casella.reset();
        casella.addVei(); // Simula que tiene 1 vecino.
        casella.mostrarCasella();
        assertEquals("1", casella.toString(), "Cuando esVisible es true y no es una bomba, debe devolver el número de vecinos.");
    }

}
