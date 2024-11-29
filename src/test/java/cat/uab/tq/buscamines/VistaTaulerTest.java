package test.java.cat.uab.tq.buscamines;
import org.junit.jupiter.api.Test;
import main.java.cat.uab.tq.buscamines.model.*;
import main.java.cat.uab.tq.buscamines.vista.VistaTauler;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class VistaTaulerTest {
	
	private ByteArrayOutputStream out = new ByteArrayOutputStream();
    private PrintStream flow = System.out;
    
	@Test
	void testPrintTaulerSenseMostrar() {
		
		Tauler mockTauler = new MockTauler(0, 0, 0);
		mockTauler.setMock(0);
		VistaTauler v = new VistaTauler();
		
		System.setOut(new PrintStream(out));

		v.printTauler(mockTauler);
		
		System.setOut(flow);
        String salida = out.toString().trim();
		
		assertEquals("* * * * * * * * * *  |0\r\n"
				+ "* * * * * * * * * *  |1\r\n"
				+ "* * * * * * * * * *  |2\r\n"
				+ "* * * * * * * * * *  |3\r\n"
				+ "* * * * * * * * * *  |4\r\n"
				+ "* * * * * * * * * *  |5\r\n"
				+ "* * * * * * * * * *  |6\r\n"
				+ "* * * * * * * * * *  |7\r\n"
				+ "* * * * * * * * * *  |8\r\n"
				+ "* * * * * * * * * *  |9\r\n"
				+ "_ _ _ _ _ _ _ _ _ _ \r\n"
				+ "0 1 2 3 4 5 6 7 8 9", salida);
		
	}
	
	@Test
	void testPrintTaulerBomba(){
		
		Tauler mockTauler = new MockTauler(0, 0, 0);
		mockTauler.setMock(1);
		VistaTauler v = new VistaTauler();
		
		System.setOut(new PrintStream(out));

		v.printTauler(mockTauler);
		
		System.setOut(flow);
        String salida = out.toString().trim();
		
		assertEquals("* * * * * * * * * *  |0\r\n"
				+ "* * * * * * * * * *  |1\r\n"
				+ "* * * * * * * * * *  |2\r\n"
				+ "* * * B * * * * * *  |3\r\n"
				+ "* * * * * * * * * *  |4\r\n"
				+ "* * * * * * * * * *  |5\r\n"
				+ "* * * * * * * * * *  |6\r\n"
				+ "* * * * * * * * * *  |7\r\n"
				+ "* * * * * * * * * *  |8\r\n"
				+ "* * * * * * * * * *  |9\r\n"
				+ "_ _ _ _ _ _ _ _ _ _ \r\n"
				+ "0 1 2 3 4 5 6 7 8 9", salida);
	}
	
	@Test
	void testPrintTaulerVeins() {
		Tauler mockTauler = new MockTauler(0, 0, 0);
		mockTauler.setMock(2);
		VistaTauler v = new VistaTauler();
		
		System.setOut(new PrintStream(out));

		v.printTauler(mockTauler);
		
		System.setOut(flow);
        String salida = out.toString().trim();
		
		assertEquals("* * * * * * * * * *  |0\r\n"
				+ "* * * * * * * * * *  |1\r\n"
				+ "* * * * B * * * * *  |2\r\n"
				+ "* * * 2 * * * * * *  |3\r\n"
				+ "* * * * * * * * * *  |4\r\n"
				+ "* * * * * * * * * *  |5\r\n"
				+ "* * * * * * * * * *  |6\r\n"
				+ "* * * * * * * * * *  |7\r\n"
				+ "* * * * * * * * * *  |8\r\n"
				+ "* * * * * * * * * *  |9\r\n"
				+ "_ _ _ _ _ _ _ _ _ _ \r\n"
				+ "0 1 2 3 4 5 6 7 8 9", salida);
	}

	@Test
	void testValidarPosicio() {
		
		VistaTauler v = new VistaTauler();
		
		MockTauler mockTauler = new MockTauler(0, 0, 0);
		mockTauler.setMock(1);
		mockTauler.setAltura(10);
		mockTauler.setAmplada(10);		
		assertTrue(v.validarPosicio(mockTauler, 0, 0));
		
		MockTauler mockTauler2 = new MockTauler(0, 0, 0);
		System.setOut(new PrintStream(out));
		mockTauler2.setMock(1);
		mockTauler2.setAltura(10);
		mockTauler2.setAmplada(10);	
		assertFalse(v.validarPosicio(mockTauler2, -1, -2));
		System.setOut(flow);
        String salida = out.toString().trim();
		assertEquals("Esta casilla no es correcta!", salida);
		out.reset();
		
		MockTauler mockTauler3 = new MockTauler(0, 0, 0);
		System.setOut(new PrintStream(out));
		mockTauler3.setMock(0);
		mockTauler3.setAltura(10);
		mockTauler3.setAmplada(10);		
		assertFalse(v.validarPosicio(mockTauler3, 1, 2));
		System.setOut(flow);
        String salida2 = out.toString().trim();
		assertEquals("Esta casilla ya esta destapada!", salida2);
		out.reset();
		
		MockTauler mockTauler4 = new MockTauler(0, 0, 0);
		System.setOut(new PrintStream(out));
		mockTauler4.setMock(1);
		mockTauler4.setAltura(10);
		mockTauler4.setAmplada(10);		
		assertFalse(v.validarPosicio(mockTauler4, 10, 0));
		System.setOut(flow);
        String salida3 = out.toString().trim();
		assertEquals("Esta casilla no es correcta!", salida3);
		out.reset();
		
		MockTauler mockTauler5 = new MockTauler(0, 0, 0);
		System.setOut(new PrintStream(out));
		mockTauler5.setMock(1);
		mockTauler5.setAltura(10);
		mockTauler5.setAmplada(10);		
		assertFalse(v.validarPosicio(mockTauler5, 0, 11));
		System.setOut(flow);
        String salida4 = out.toString().trim();
		assertEquals("Esta casilla no es correcta!", salida4);
		out.reset();
		
		
		MockTauler mockTauler6 = new MockTauler(0, 0, 0);
		System.setOut(new PrintStream(out));
		mockTauler6.setMock(1);
		mockTauler6.setAltura(10);
		mockTauler6.setAmplada(10);		
		assertFalse(v.validarPosicio(mockTauler6, -50, 0));
		System.setOut(flow);
        String salida5 = out.toString().trim();
		assertEquals("Esta casilla no es correcta!", salida5);
		out.reset();
		
	}

	@Test
	void testPrintStatus() {
		Tauler mockTauler = new MockTauler(0, 0, 0);
		VistaTauler v = new VistaTauler();
		
		System.setOut(new PrintStream(out));
		
		v.printStatus(mockTauler);
		
		System.setOut(flow);
        String salida = out.toString().trim();
        
        assertEquals("10 caselles mostrades de 92 caselles segures per desbloquejar.", salida);
		
	}

}
