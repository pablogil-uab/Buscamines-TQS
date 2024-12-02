package test.java.cat.uab.tq.buscamines;
import main.java.cat.uab.tq.buscamines.model.Normal;
import main.java.cat.uab.tq.buscamines.model.tipusCasella;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NormalTest {

	@Test
	void testIsBomb() {
		tipusCasella p = new Normal();
		assertFalse(p.isBomb());
	}

}
