package cat.uab.tq.buscamines.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NormalTest {

	@Test
	void testIsBomb() {
		tipusCasella p = new Normal();
		assertFalse(p.isBomb());
	}

}
