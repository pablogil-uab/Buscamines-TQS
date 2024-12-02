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
	void testConstructorInvalidWidth() {
	    assertThrows(AssertionError.class, () -> new Tauler(0, 5, 10), "La amplada debe ser mayor que 0");
	}

	@Test
	void testConstructorInvalidHeight() {
	    assertThrows(AssertionError.class, () -> new Tauler(5, 0, 10), "La altura debe ser mayor que 0");
	}

	@Test
	void testConstructorInvalidMinesNegative() {
	    assertThrows(AssertionError.class, () -> new Tauler(5, 5, -1), "El número de minas debe ser no negativo");
	}

	@Test
	void testConstructorInvalidMinesExceeding() {
	    assertThrows(AssertionError.class, () -> new Tauler(5, 5, 30), "El número de minas no puede exceder el total de casillas");
	}

	
	
	@Test
	void testConstructorValid() {
	    Tauler tauler = new Tauler(5, 5, 0); // Dimensiones válidas
	    assertEquals(5, tauler.getAmplada());
	    assertEquals(5, tauler.getAltura());
	    assertEquals(0, tauler.getBombCount());
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
	
	
	@Test
	void testSetRandomBombsZeroIterations() {
	    Tauler emptyTauler = new Tauler(5, 5, 0); // Tablero sin minas
	    emptyTauler.setRandomBombs();
	    assertEquals(0, emptyTauler.getBombCount(), "No debe haber bombas colocadas.");
	}
	
	@Test
	void testSetRandomBombsOneIteration() {
	    Tauler singleBombTauler = new Tauler(5, 5, 1); // Tablero con 1 mina
	    singleBombTauler.setRandomBombs();
	    assertEquals(1, singleBombTauler.getBombCount(), "Debe haber exactamente 1 bomba colocada.");
	}
	@Test
	void testSetRandomBombsMultipleIterations() {
	    tauler.setRandomBombs(); // El tablero inicial es 5x5 con 10 minas
	    assertEquals(10, tauler.getBombCount(), "Debe haber exactamente 10 bombas colocadas.");
	    
	    // Validamos que las minas estén en posiciones diferentes
	    int bombCount = 0;
	    for (int y = 0; y < tauler.getAltura(); y++) {
	        for (int x = 0; x < tauler.getAmplada(); x++) {
	            if (tauler.isBomb(x, y)) bombCount++;
	        }
	    }
	    assertEquals(10, bombCount, "Las minas no deben superponerse.");
	}
	
	@Test
	void testSetRandomBombsMaxIterations() {
	    Tauler fullBombTauler = new Tauler(5, 5, 25); // Tablero completamente lleno de minas
	    fullBombTauler.setRandomBombs();
	    assertEquals(25, fullBombTauler.getBombCount(), "Debe haber exactamente 25 bombas, una por cada casilla.");
	    
	    // Validamos que todas las casillas son bombas
	    for (int y = 0; y < fullBombTauler.getAltura(); y++) {
	        for (int x = 0; x < fullBombTauler.getAmplada(); x++) {
	            assertTrue(fullBombTauler.isBomb(x, y), "Cada casilla debe ser una bomba.");
	        }
	    }
	}

	@Test
	void testMostrarCasellaValid() {
	    Tauler tauler = new Tauler(5, 5, 0);
	    tauler.mostrarCasella(2, 2);
	    assertTrue(tauler.casellaVisible(2, 2));
	}
	
	@Test
	void testMostrarCasellaOutOfBounds() {
	    Tauler tauler = new Tauler(5, 5, 0);
	    assertThrows(AssertionError.class, () -> tauler.mostrarCasella(5, 2), "Coordenada x fuera de rango");
	    assertThrows(AssertionError.class, () -> tauler.mostrarCasella(2, 5), "Coordenada y fuera de rango");
	}
	
	
	@Test
	void testAddBombaValid2() {
	    Tauler tauler = new Tauler(5, 5, 0);
	    tauler.addBomba(1, 1);
	    assertTrue(tauler.isBomb(1, 1));
	}
	
	@Test
	void testAddBombaOutOfBounds() {
	    Tauler tauler = new Tauler(5, 5, 0);
	    assertThrows(AssertionError.class, () -> tauler.addBomba(-1, 0), "Coordenada x fuera de rango");
	    assertThrows(AssertionError.class, () -> tauler.addBomba(0, -1), "Coordenada y fuera de rango");
	}

	@Test
	void testAddBombaAlreadyBomb() {
	    Tauler tauler = new Tauler(5, 5, 0);
	    tauler.addBomba(1, 1);
	    assertThrows(AssertionError.class, () -> tauler.addBomba(1, 1), "La casilla ya contiene una bomba");
	}
	
	
	@Test
	void testSetRandomBombsValid() {
	    Tauler tauler = new Tauler(5, 5, 10);
	    tauler.setRandomBombs();
	    assertEquals(10, tauler.getBombCount());
	}
	
	@Test
	void testInvariantsAfterOperations() {
	    Tauler tauler = new Tauler(5, 5, 10);
	    tauler.setRandomBombs();
	    tauler.mostrarCasella(2, 2);
	    assertTrue(tauler.casellaVisible(2, 2));
	    assertTrue(tauler.getCasellesMostrades() + tauler.getBombCount() <= tauler.getAmplada() * tauler.getAltura());
	}
	
	@Test
	void testAddBombaPrecondicionXValida() {
	    Tauler tauler = new Tauler(5, 5, 0);
	    tauler.addBomba(2, 2); // Coordenada válida
	    assertTrue(tauler.isBomb(2, 2), "La casilla (2, 2) debe contener una bomba.");
	}

	@Test
	void testAddBombaPrecondicionXInvalida() {
	    Tauler tauler = new Tauler(5, 5, 0);
	    assertThrows(AssertionError.class, () -> tauler.addBomba(-1, 2), "Coordenada x fuera de rango");
	    assertThrows(AssertionError.class, () -> tauler.addBomba(5, 2), "Coordenada x fuera de rango");
	}
	

	
}
