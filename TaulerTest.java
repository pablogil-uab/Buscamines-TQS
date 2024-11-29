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

	@Test
	void testAddBombaIncrementNeighbours() {
	    tauler.addBomba(2, 2);
	    assertEquals(1, tauler.getCasella(1, 1).getVeins(), "El vecino (1, 1) debe tener 1 bomba cercana.");
	    assertEquals(1, tauler.getCasella(3, 3).getVeins(), "El vecino (3, 3) debe tener 1 bomba cercana.");
	    
	    tauler.addBomba(0, 0);
	    assertEquals(2, tauler.getCasella(1, 1).getVeins(), "El vecino (1, 1) debe tener 2 bomba cercana.");
	    assertEquals(1, tauler.getCasella(0, 1).getVeins(), "El vecino (0, 1) debe tener 1 bomba cercana.");
	    
	    tauler.addBomba(4, 4);
	    assertEquals(2, tauler.getCasella(3, 3).getVeins(), "El vecino (3, 3) debe tener 2 bomba cercana.");
	    
	    
	    tauler.addBomba(4, 3);
	    assertEquals(3, tauler.getCasella(3, 3).getVeins(), "El vecino (3, 3) debe tener 3 bomba cercana.");
	    
	    
	    tauler.addBomba(3, 4);
	    assertEquals(4, tauler.getCasella(3, 3).getVeins(), "El vecino (3, 3) debe tener 4 bomba cercana.");
	 
	    tauler.addBomba(0, 1);
	    assertEquals(1, tauler.getCasella(0, 2).getVeins(), "El vecino (0, 2) debe tener 1 bomba cercana.");
	   
	    
	    tauler.addBomba(1, 0);
	    assertEquals(4, tauler.getCasella(1, 1).getVeins(), "El vecino (1, 1) debe tener 4 bomba cercana.");
	    assertEquals(0, tauler.getCasella(0, 4).getVeins(), "El vecino (0, 4) debe tener 0 bomba cercana.");
	    
	   
	}
	
	
	@Test
	void testMostrarCasellaNoNeighbours() {
	    tauler.mostrarCasella(2, 2);
	    assertTrue(tauler.getCasella(2, 2).getEsVisible(), "La casilla (2, 2) debe mostrarse.");
	    
	    tauler.mostrarCasella(0, 0);
	    assertTrue(tauler.getCasella(0, 0).getEsVisible(), "La casilla (0, 0) debe mostrarse.");
	    
	    tauler.mostrarCasella(0, 1);
	    assertTrue(tauler.getCasella(0, 1).getEsVisible(), "La casilla (0, 1) debe mostrarse.");
	    
	    tauler.mostrarCasella(1, 0);
	    assertTrue(tauler.getCasella(1, 0).getEsVisible(), "La casilla (1, 0) debe mostrarse.");
	    
	    tauler.mostrarCasella(3, 3);
	    assertTrue(tauler.getCasella(3, 3).getEsVisible(), "La casilla (3, 3) debe mostrarse.");
	    
	    tauler.mostrarCasella(4, 4);
	    assertTrue(tauler.getCasella(4, 4).getEsVisible(), "La casilla (4, 4) debe mostrarse.");
	    
	    tauler.mostrarCasella(3, 4);
	    assertTrue(tauler.getCasella(3, 4).getEsVisible(), "La casilla (3, 4) debe mostrarse.");
	    
	    
	    tauler.mostrarCasella(4, 3);
	    assertTrue(tauler.getCasella(4, 3).getEsVisible(), "La casilla (4, 3) debe mostrarse.");
	  
	   
	    
	}

	@Test
	void testMostrarCasellaWithNeighbours() {
	    tauler.addBomba(1, 1);
	    tauler.mostrarCasella(0, 0);
	    assertTrue(tauler.getCasella(0, 0).getEsVisible(), "La casilla (0, 0) debe mostrarse.");
	    assertFalse(tauler.getCasella(1, 1).getEsVisible(), "La casilla (1, 1) no debe mostrarse automáticamente.");
	    
	    
	    tauler.addBomba(2, 2); 
	    tauler.mostrarCasella(3, 3);
	    assertTrue(tauler.getCasella(3, 3).getEsVisible(), "La casilla (3, 3) debe mostrarse.");
	    assertFalse(tauler.getCasella(2, 2).getEsVisible(), "La casilla (2, 2) no debe mostrarse si tiene una bomba.");
	    
	    
	}
	
	@Test
	void testRevelaCasellesAdjuntesBuides() {
	    tauler.mostrarCasella(2, 2);
	    assertTrue(tauler.getCasella(1, 1).getEsVisible(), "La casilla adyacente (1, 1) debe mostrarse.");
	    assertTrue(tauler.getCasella(3, 3).getEsVisible(), "La casilla adyacente (3, 3) debe mostrarse.");
	}
	
	
	@Test
	void testRevelaCasellesAdjuntesEsquina() {
	    tauler.mostrarCasella(0, 0);
	    assertTrue(tauler.getCasella(0, 0).getEsVisible(), "La casilla (0, 0) debe mostrarse.");
	    assertTrue(tauler.getCasella(1, 1).getEsVisible(), "La casilla (1, 1) debe mostrarse si está vacía.");
	}

	@Test
	void testRevelaCasellesAdjuntesCentre() {
	    tauler.mostrarCasella(2, 2);
	    assertTrue(tauler.getCasella(1, 1).getEsVisible(), "La casilla (1, 1) debe mostrarse.");
	    assertTrue(tauler.getCasella(3, 3).getEsVisible(), "La casilla (3, 3) debe mostrarse.");
	    assertFalse(tauler.getCasella(4, 4).getEsVisible(), "Casillas no adyacentes no deben mostrarse.");
	}

	@Test
	void testRevelaCasellesAdjuntesBombesProperes() {
	    tauler.addBomba(2, 2);
	    tauler.mostrarCasella(3, 3);
	    assertTrue(tauler.getCasella(3, 3).getEsVisible(), "La casilla (3, 3) debe mostrarse.");
	    assertFalse(tauler.getCasella(2, 2).getEsVisible(), "La casilla (2, 2) no debe revelarse automáticamente si tiene una bomba.");
	}
	@Test
	void testRevelaCasellesAdjuntesAmbBombes() {
	    tauler.addBomba(1, 1);
	    tauler.mostrarCasella(0, 0);
	    assertTrue(tauler.getCasella(0, 0).getEsVisible(), "La casilla (0, 0) debe mostrarse.");
	    assertFalse(tauler.getCasella(1, 1).getEsVisible(), "La casilla (1, 1) no debe mostrarse automáticamente.");
	}
	
	
	@Test
	void testIsWonTotesCasellesMostrades() {
	    for (int y = 0; y < tauler.getAltura(); y++) {
	        for (int x = 0; x < tauler.getAmplada(); x++) {
	            if (!tauler.getCasella(x, y).isBomb()) {
	                tauler.mostrarCasella(x, y);
	            }
	        }
	    }
	    assertTrue(tauler.isWon(), "El juego debe ser ganado si todas las casillas seguras están reveladas.");
	}

	@Test
	void testNotWon() {
	    tauler.mostrarCasella(0, 0);
	    assertFalse(tauler.isWon(), "El juego no debe ser ganado si quedan casillas seguras sin revelar.");
	}
	
	
	void testRevelaCasellesPropagacioMultiple() {
	    tauler.mostrarCasella(0, 0);
	    assertTrue(tauler.getCasella(0, 0).getEsVisible(), "La casilla inicial debe mostrarse.");
	    assertTrue(tauler.getCasella(1, 1).getEsVisible(), "Las casillas vacías adyacentes deben propagarse.");
	    assertTrue(tauler.getCasella(2, 2).getEsVisible(), "La propagación debe continuar si no hay bombas cercanas.");
	}
	
	@Test
	void testGetCasellesMostradesInitial() {
	    assertEquals(0, tauler.getCasellesMostrades(), "Inicialmente no debe haber casillas mostradas.");
	}

	@Test
	void testGetCasellesMostradesAfterRevealing() {
	    tauler.mostrarCasella(0, 0);
	    assertTrue(tauler.getCasella(0, 0).getEsVisible(), "La casilla debe estar visible.");
	    assertEquals(4, tauler.getCasellesMostrades(), "Debe contar correctamente las casillas mostradas.");
	}
	
	
	void testGetBombCountInitial() {
	    assertEquals(0, tauler.getBombCount(), "Inicialmente no debe haber bombas colocadas.");
	}

	
	
	
	@Test
	void testCasellaVisibleInitial() {
	    assertFalse(tauler.casellaVisible(0, 0), "Inicialmente la casilla no debe estar visible.");
	}

	@Test
	void testCasellaVisibleAfterShowing() {
	    tauler.mostrarCasella(0, 0);
	    assertTrue(tauler.casellaVisible(0, 0), "La casilla debe estar visible después de mostrarla.");
	}
	
	
	@Test
	void testIsBombInitial() {
	    assertFalse(tauler.isBomb(0, 0), "Inicialmente ninguna casilla debe ser una bomba.");
	}

	@Test
	void testIsBombAfterAdding() {
	    tauler.addBomba(0, 0);
	    assertTrue(tauler.isBomb(0, 0), "La casilla debe ser una bomba después de añadirla.");
	}
	
	@Test
	void testSetRandomBombsCount() {
	    tauler.setRandomBombs();
	    assertEquals(10, tauler.getBombCount(), "Debe haber exactamente 10 bombas.");
	}

	@Test
	void testSetRandomBombsNoOverlap() {
	    tauler.setRandomBombs();
	    int bombCount = 0;
	    for (int y = 0; y < tauler.getAltura(); y++) {
	        for (int x = 0; x < tauler.getAmplada(); x++) {
	            if (tauler.isBomb(x, y)) bombCount++;
	        }
	    }
	    assertEquals(10, bombCount, "Las bombas no deben superponerse.");
	}
	
	@Test
	void testMostrarTaulellAllVisible() {
	    tauler.mostrarTaulell();
	    for (int y = 0; y < tauler.getAltura(); y++) {
	        for (int x = 0; x < tauler.getAmplada(); x++) {
	            assertTrue(tauler.casellaVisible(x, y), "Todas las casillas deben estar visibles.");
	        }
	    }
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
