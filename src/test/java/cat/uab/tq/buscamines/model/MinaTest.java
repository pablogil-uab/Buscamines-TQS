package test.java.cat.uab.tq.buscamines;
import main.java.cat.uab.tq.buscamines.model.Mina;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.java.cat.uab.tq.buscamines.model.tipusCasella;

class MinaTest {

	@Test
	void testIsBomb() {
		tipusCasella n = new Mina();
		assertTrue(n.isBomb());
	}

}
