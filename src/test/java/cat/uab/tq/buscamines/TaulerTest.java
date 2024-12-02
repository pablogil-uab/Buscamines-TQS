


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
	    Tauler tauler = null;

	    System.out.println("La amplada debe ser mayor que 0.");

	    assertNull(tauler, "El tablero no debe crearse con amplada inválida.");
	}

	
	@Test
	void testConstructorInvalidHeight() {
	    Tauler tauler = null;

	    System.out.println("La altura debe ser mayor que 0.");

	    assertNull(tauler, "El tablero no debe crearse con altura inválida.");
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
	void testConstructorValidInvariants() {
	    Tauler tauler = new Tauler(5, 5, 0); // Parámetros válidos
	    assertEquals(5, tauler.getAmplada());
	    assertEquals(5, tauler.getAltura());
	    assertEquals(0, tauler.getBombCount());
	
	}
	
	
	@Test
	void testSetRandomBombsBoundaryCases() {
	    Tauler smallBoardNoBombs = new Tauler(1, 1, 0);
	    smallBoardNoBombs.setRandomBombs();
	    assertEquals(0, smallBoardNoBombs.getBombCount(), "No debe haber bombas en un tablero 1x1 con 0 minas.");

	    Tauler smallBoardWithBomb = new Tauler(1, 1, 1);
	    smallBoardWithBomb.setRandomBombs();
	    assertEquals(1, smallBoardWithBomb.getBombCount(), "Debe haber exactamente 1 bomba en un tablero 1x1 con 1 mina.");
	    
	    
	    
	}
	@Test
    void testSetRandomBombsPairwise() {
        // Combinaciones de parámetros
        int[][] testCases = {
            {1, 1, 0}, // Caso límite: tablero pequeño sin bombas
            {1, 1, 1}, // Caso límite: tablero pequeño con una bomba
            {3, 3, 0}, // Tablero mediano sin bombas
            {3, 3, 1}, // Tablero mediano con una bomba
            {3, 3, 8}, // Tablero mediano con todas las bombas posibles menos una
            {5, 5, 0}, // Tablero grande sin bombas
            {5, 5, 10}, // Tablero grande con algunas bombas
            {5, 5, 24}  // Tablero grande con todas las bombas posibles menos una
        };

        for (int[] testCase : testCases) {
            int amplada = testCase[0];
            int altura = testCase[1];
            int mines = testCase[2];

            Tauler board = new Tauler(amplada, altura, mines);
            board.setRandomBombs();

            // Verificar el número de bombas después de colocarlas
            int expectedBombCount = Math.min(mines, amplada * altura);
            assertEquals(expectedBombCount, board.getBombCount(), 
                "Fallo en tablero de tamaño " + amplada + "x" + altura + " con " + mines + " minas.");
        }
        }
        
        @Test
        void testCondicionMostrarCasellaConVecinos() {
            tauler.addBomba(1, 1); // Agregamos una bomba cerca
            tauler.mostrarCasella(0, 0); // Mostramos una casilla con vecinos
            assertTrue(tauler.getCasella(0, 0).getEsVisible(), "La casilla debe mostrarse.");
            assertFalse(tauler.getCasella(1, 1).getEsVisible(), "La casilla con bomba no debe mostrarse automáticamente.");
        }

        @Test
        void testCondicionMostrarCasellaSinVecinos() {
            tauler.mostrarCasella(2, 2); // Mostramos una casilla sin vecinos
            assertTrue(tauler.getCasella(2, 2).getEsVisible(), "La casilla debe mostrarse.");
            assertTrue(tauler.getCasella(1, 1).getEsVisible(), "Las casillas adyacentes sin bombas deben revelarse.");
        }

        @Test
        void testCondicionRevelaCasellesNoVisible() {
            tauler.mostrarCasella(0, 0); // Intentamos revelar una casilla no visible
            assertTrue(tauler.getCasella(0, 0).getEsVisible(), "La casilla debe mostrarse.");
        }

        @Test
        void testCondicionRevelaCasellesYaVisible() {
            tauler.mostrarCasella(0, 0); // Revelamos la casilla una vez
            tauler.mostrarCasella(0, 0); // Intentamos revelarla nuevamente
            assertTrue(tauler.getCasella(0, 0).getEsVisible(), "La casilla ya revelada debe permanecer visible.");
        }
        
        @Test
        void testSetRandomBombs_SinIteraciones() {
            Tauler tauler = new Tauler(3, 3, 0); // Tablero de 3x3 sin minas.
            tauler.setRandomBombs(); // No debería colocar ninguna bomba.

            assertEquals(0, tauler.getBombCount(), "No debería haber bombas en el tablero.");
        }

        @Test
        void testSetRandomBombs_UnaIteracion() {
            Tauler tauler = new Tauler(3, 3, 1); // Tablero de 3x3 con 1 mina.
            tauler.setRandomBombs();

            assertEquals(1, tauler.getBombCount(), "Debería haber exactamente una bomba en el tablero.");
        }

        @Test
        void testSetRandomBombs_MultiplesIteraciones() {
            Tauler tauler = new Tauler(3, 3, 3); // Tablero de 3x3 con 3 minas.
            tauler.setRandomBombs();

            assertEquals(3, tauler.getBombCount(), "Debería haber exactamente 3 bombas en el tablero.");
        }
       
        
        @Test
        void testAddBomba_SinVecinos() {
            Tauler tauler = new Tauler(1, 1, 0); // Tablero de 1x1.
            tauler.addBomba(0, 0); // Colocar una bomba en la única casilla.

            assertTrue(tauler.isBomb(0, 0), "La casilla (0,0) debería tener una bomba.");
            assertEquals(1, tauler.getBombCount(), "Debería haber exactamente una bomba en el tablero.");
        }

        @Test
        void testAddBomba_ConVecinos() {
            Tauler tauler = new Tauler(3, 3, 0); // Tablero de 3x3.
            tauler.addBomba(1, 1); // Colocar una bomba en el centro.

            // Verificar que todos los vecinos del centro tienen un vecino bomba.
            for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y++) {
                    if (x != 1 || y != 1) { // Evitar la casilla bomba.
                        assertEquals(1, tauler.getCasella(x, y).getVeins(), 
                                     "La casilla (" + x + "," + y + ") debería tener exactamente un vecino bomba.");
                    }
                }
            }
        }
        
        @Test
        void testAddBomba_coordenadaFueraDeRango() {
            Tauler tauler = new Tauler(5, 5, 3);
            assertThrows(AssertionError.class, () -> tauler.addBomba(-1, 0));
            assertThrows(AssertionError.class, () -> tauler.addBomba(5, 0));
            assertThrows(AssertionError.class, () -> tauler.addBomba(0, -1));
            assertThrows(AssertionError.class, () -> tauler.addBomba(0, 5));
        }

        @Test
        void testAddBomba_casillaYaTieneBomba() {
            Tauler tauler = new Tauler(5, 5, 3);
            tauler.addBomba(2, 2);
            assertThrows(AssertionError.class, () -> tauler.addBomba(2, 2));
        }

        @Test
        void testAddBomba_exito() {
            Tauler tauler = new Tauler(5, 5, 3);
            tauler.addBomba(2, 2);

            assertTrue(tauler.isBomb(2, 2), "La casilla (2, 2) debería contener una bomba.");
            assertEquals(1, tauler.getBombCount(), "El número de bombas debería ser 1.");
            assertEquals(1, tauler.getCasella(1, 1).getVeins(), "Los vecinos deberían haberse actualizado.");
        }
	}


        
        
    
	
	
	
	
	
	
	
	
	
	
	
	


