package controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import model.Tauler;
import view.MessageTxt;
import view.VistaTauler;
import view.entryData;

class PartidaTest {

	@Mock
    private entryData mockInput;

    @Mock
    private VistaTauler mockVista;

    @Mock
    private MessageTxt mockMessage;

    @Mock
    private Tauler mockTauler;

    @InjectMocks
    private Partida partida; // Usa los mocks anteriores para inicializar Partida

    
    @BeforeEach
    public void setUp(){
    	// Inicializar los mocks
        MockitoAnnotations.openMocks(this);
        
        // Crear la instancia de Partida usando los mocks
        partida = new Partida(mockTauler, mockMessage, mockInput, mockVista);
       
    }
    @Test
    void testPartida() {
    	Partida p = new Partida();
    }
    @Test
    void testStartPartidaVictory() { 

        // Configurar los valores simulados para input.readInput()
        when(mockInput.readInput()).thenReturn(new int[]{1, 1});

        // Configurar mockVista.validarPosicio() para siempre devolver true
        when(mockVista.validarPosicio(any(Tauler.class), anyInt(), anyInt())).thenReturn(true);

        // Configurar el comportamiento de tauler
        when(mockTauler.isWon()).thenReturn(false).thenReturn(false).thenReturn(true); // Gana en la tercera iteración
        when(mockTauler.isBomb(anyInt(), anyInt())).thenReturn(false); // Nunca pisa una bomba

        // Ejecutar el método a probar
        partida.startPartida();

        // Verificar las interacciones
        verify(mockMessage, times(1)).presentacio(); // Verifica que se muestre el mensaje de presentación
        verify(mockInput, atLeastOnce()).readInput(); // Verifica que se lea la entrada
        verify(mockTauler, times(1)).setRandomBombs(); // Verifica que se generen bombas
        verify(mockVista, atLeastOnce()).printTauler(mockTauler); // Verifica que se imprima el tablero
        verify(mockVista, atLeastOnce()).printStatus(mockTauler);
        verify(mockTauler, atLeastOnce()).mostrarCasella(anyInt(), anyInt());
        verify(mockTauler, times(1)).mostrarTaulell();
        verify(mockMessage, times(1)).victory(); // Verifica que se muestre el mensaje de victoria
    }
     
    @Test
    void testStartPartidaDefeat() { 

        // Configurar los valores simulados para input.readInput()
        when(mockInput.readInput()).thenReturn(new int[]{0, 0});

        // Configurar mockVista.validarPosicio() para siempre devolver true
        when(mockVista.validarPosicio(any(Tauler.class), anyInt(), anyInt())).thenReturn(true);

        // Configurar el comportamiento de tauler
        when(mockTauler.isWon()).thenReturn(false); 
        when(mockTauler.isBomb(anyInt(), anyInt())).thenReturn(true); //Pisa una bomba en la primera iteracion

        // Ejecutar el método a probar
        partida.startPartida();

        // Verificar las interacciones
        verify(mockMessage, times(1)).presentacio(); // Verifica que se muestre el mensaje de presentación
        verify(mockInput, atLeastOnce()).readInput(); // Verifica que se lea la entrada
        verify(mockTauler, times(1)).setRandomBombs(); // Verifica que se generen bombas
        verify(mockVista, atLeastOnce()).printTauler(mockTauler); // Verifica que se imprima el tablero
        verify(mockVista, atLeastOnce()).printStatus(mockTauler);
        verify(mockTauler, atLeastOnce()).mostrarCasella(anyInt(), anyInt());
        verify(mockTauler, times(1)).mostrarTaulell();
        verify(mockMessage, times(1)).bomb(); // Verifica que se muestre el mensaje de victoria
    }
    
    
	@Test
	void testConfigurarPartidaNull() {
		when(mockInput.configurarPartida(anyInt(), anyInt(), anyInt(), anyInt(), anyInt(), 
				anyInt())).thenReturn(new int[] {0,0,0});
		partida.configurarPartida();
		
		verify(mockInput, times(0)).configurarPartida(anyInt(), anyInt(), anyInt(), 
				anyInt(), anyInt(), anyInt());
	}
	