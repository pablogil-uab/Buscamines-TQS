package cat.uab.tq.buscamines.view;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MessageTxtMockTest {
	
	@Test
    void MockTest() {
		 // Configurar para capturar el output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        
        // Crear una instancia del mock
        MessageTxtMock mock = new MessageTxtMock();

        // Llamar a los métodos simulados
        mock.presentacio();
        mock.victory();
        mock.bomb();

        // Verificar el contenido generado
        String output = mock.getOutput();
        System.out.println("Contenido del mock:");
        System.out.println(output);

        // Verificar el output
        assertTrue(output.contains("Benvingut al joc del buscamines!"));
        assertTrue(output.contains("Victoria!! Has conseguit revelar totes les caselles sense bombes."));
        assertTrue(output.contains("Oops.. Has topat amb una bomba :("));
        
     // Restaurar la salida estándar
        System.setOut(System.out);
    }
}

