package test.java.cat.uab.tq.buscamines;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.cat.uab.tq.buscamines.model.Tauler;

class TaulerTest {
	
	private Tauler tauler;
	
	
	@BeforeEach
    void setUp() {
        tauler = new Tauler(5, 5, 10); // Tablero 5x5 con 10 minas
    }

	@Test
	void testAddBombaValid() {
	    tauler.addBomba(2, 2);
	    assertTrue(tauler.getCasella(2, 2).isBomb(), "La casilla (2, 2) debe contener una bomba.");
	    
	    tauler.addBomba(0, 0);
	    assertTrue(tauler.getCasella(0, 0).isBomb(),"La casilla (0, 0) debe contener una bomba.");
	    
	    tauler.addBomba(4, 4);
	    assertTrue(tauler.getCasella(4, 4).isBomb(),"La casilla (4, 4) debe contener una bomba.");
	    
	    tauler.addBomba(4, 3);
	    assertTrue(tauler.getCasella(4, 3).isBomb(),"La casilla (4, 4) debe contener una bomba.");
	    
	    tauler.addBomba(3, 4);
	    assertTrue(tauler.getCasella(3, 4).isBomb(),"La casilla (4, 4) debe contener una bomba.");
	    
	    tauler.addBomba(0, 1);
	    assertTrue(tauler.getCasella(0, 1).isBomb(),"La casilla (4, 4) debe contener una bomba.");
	    
	    tauler.addBomba(1, 0);
	    assertTrue(tauler.getCasella(0, 1).isBomb(),"La casilla (4, 4) debe contener una bomba.");
	    
	   
	
	
}
