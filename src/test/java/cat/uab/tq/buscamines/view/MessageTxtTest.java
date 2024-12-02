package cat.uab.tq.buscamines.view;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import cat.uab.tq.buscamines.vista.MessageTxt;

;

class MessageTxtTest {
	private ByteArrayOutputStream out = new ByteArrayOutputStream();
    private PrintStream flow = System.out;
    
	@Test
	void testPresentacio() {
        System.setOut(new PrintStream(out));

        // Imprimim el missatge
        MessageTxt m = new MessageTxt();
        m.presentacio();

        // Restaurem el fluxe original
        System.setOut(flow);

        // Verifiquem la sortida capturada
        String salida = out.toString().trim(); // Convertim a string i eliminem els espais
        assertEquals("Benvingut al joc del buscamines!", salida);
	}

	@Test
	void testVictory() {
        System.setOut(new PrintStream(out));

        // Imprimim el missatge
        MessageTxt m = new MessageTxt();
        m.victory();

        // Restaurem el fluxe original
        System.setOut(flow);

        // Verifiquem la sortida capturada
        String salida = out.toString().trim(); // Convertim a string i eliminem els espais
        assertEquals("Victoria!! Has conseguit revelar totes les caselles sense bombes.", salida);
	}

	@Test
	void testBomb() {
		System.setOut(new PrintStream(out));

        // Imprimim el missatge
        MessageTxt m = new MessageTxt();
        m.bomb();

        // Restaurem el fluxe original
        System.setOut(flow);

        // Verifiquem la sortida capturada
        String salida = out.toString().trim(); // Convertim a string i eliminem els espais
        assertEquals("Oops.. Has topat amb una bomba :(\n" + "GAME OVER", salida);

	}

}
