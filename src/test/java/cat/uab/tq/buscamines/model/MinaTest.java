package cat.uab.tq.buscamines.model;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;



class MinaTest {

	@Test
	void testIsBomb() {
		tipusCasella n = new Mina();
		assertTrue(n.isBomb());
	}

}
