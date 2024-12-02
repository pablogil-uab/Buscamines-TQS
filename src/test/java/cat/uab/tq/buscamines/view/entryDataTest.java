package cat.uab.tq.buscamines.view;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cat.uab.tq.buscamines.vista.entryData;


class entryDataTest {
	
	@Test
    void testEntryData() {
        entryData e = new entryData();
        assertNotNull(e.getScan());
    }
	@Test
	void testReadInputValid() {
		
		//Creamos un input valido simulado y lo guardamos en un ByteaArrayOutputStream
        String automatedInput = "2 3\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(automatedInput.getBytes());

        //Creamos una salida para detectar que los mensajes se impimen correctamente
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out; 
        System.setOut(new PrintStream(outputStream));

        
        entryData entry = new entryData(inputStream);

       
        int[] res = entry.readInput();


        System.setOut(originalOut);
        String output = outputStream.toString();
        
        assertNotNull(res);
        assertEquals(2, res.length);
        assertEquals(2, res[0]);
        assertEquals(3, res[1]);
        
        assertEquals(output.trim(), "Entra la coordenada X y Y separadas por un espacio:");
	}
	
	@Test 
	void testReadInputInvalid(){
		//Creamos un input simulado que sea invalido y lo guardamos en un ByteaArrayOutputStream
        String automatedInput = "c121A\n" + "1 2";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(automatedInput.getBytes());

        //Creamos una salida para detectar que los mensajes se impimen correctamente
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out; 
        System.setOut(new PrintStream(outputStream));

        
        entryData entry = new entryData(inputStream);

       
        int[] res = entry.readInput();


        System.setOut(originalOut);
        String output = outputStream.toString();
        
        assertNotNull(res);
        assertEquals(2, res.length);
        assertEquals(1, res[0]);
        assertEquals(2, res[1]);
        
        assertTrue(output.contains("Entra la coordenada X y Y separadas por un espacio:"));
        assertTrue(output.contains("Coordenada invalida.\n"));
	}
	
	@Test
	void testReadInputOneValid() {
		
		//Creamos un input simulado que sea solo con una coordinada valida y lo guardamos en un ByteaArrayOutputStream
        String automatedInput = "c 1\n" + "2 a\n" + "0 0";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(automatedInput.getBytes());

        //Creamos una salida para detectar que los mensajes se impimen correctamente
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out; 
        System.setOut(new PrintStream(outputStream));

        
        entryData entry = new entryData(inputStream);

       
        int[] res = entry.readInput();


        System.setOut(originalOut);
        String output = outputStream.toString();
        
        assertNotNull(res);
        assertEquals(2, res.length);
        assertEquals(0, res[0]);
        assertEquals(0, res[1]);
        
        assertTrue(output.contains("Entra la coordenada X y Y separadas por un espacio:"));
        assertTrue(output.contains("Coordenada invalida.\n"));

	}
	
	@Test
	void testReadInputOutOfRange() {
		
		//Creamos un input simulado que contenga valores fuera de rango y lo guardamos en un ByteaArrayOutputStream
        String automatedInput = "-1 50";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(automatedInput.getBytes());

        //Creamos una salida para detectar que los mensajes se impimen correctamente
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out; 
        System.setOut(new PrintStream(outputStream));

        
        entryData entry = new entryData(inputStream);

       
        int[] res = entry.readInput();


        System.setOut(originalOut);
        String output = outputStream.toString();
        
        assertNotNull(res);
        assertEquals(2, res.length);
        assertEquals(-1, res[0]);
        assertEquals(50, res[1]);
        
        assertTrue(output.contains("Entra la coordenada X y Y separadas por un espacio:"));

	}

	@Test
	void testConfigurarPartidaValid() {
		
		//Creamos un input simulado que sea valido y lo guardamos en un ByteaArrayOutputStream
        String automatedInput = "8 8\n6\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(automatedInput.getBytes());

        //Creamos una salida para detectar que los mensajes se impimen correctamente
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out; 
        System.setOut(new PrintStream(outputStream));

        
        entryData entry = new entryData(inputStream);

       
        int[] res = entry.configurarPartida(10, 5, 10, 5, 10, 5);


        System.setOut(originalOut);
        String output = outputStream.toString();
        
        assertNotNull(res);
        assertEquals(3, res.length);
        assertEquals(8, res[0]);
        assertEquals(8, res[1]);
        assertEquals(6, res[2]);
        
        assertTrue(output.contains("Entra las dimensiones deseadas del tablero, "
    			+ "el numero de filas y columnas separado por un espacio: "));
        
        assertTrue(output.contains("Entra el numero de minas deseado: "));
	}
	
	@Test
	void testConfigurarPartidaNoValid() {
		//Creamos un input simulado que sea valido y lo guardamos en un ByteaArrayOutputStream
        String automatedInput = "abfd12g\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(automatedInput.getBytes());

        //Creamos una salida para detectar que los mensajes se impimen correctamente
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out; 
        System.setOut(new PrintStream(outputStream));

        
        entryData entry = new entryData(inputStream);

       
        int[] res = entry.configurarPartida(10, 5, 10, 5, 10, 5);


        System.setOut(originalOut);
        String output = outputStream.toString();

        assertTrue(output.contains("Entra las dimensiones deseadas del tablero, "
    			+ "el numero de filas y columnas separado por un espacio: "));
	}
	


}
