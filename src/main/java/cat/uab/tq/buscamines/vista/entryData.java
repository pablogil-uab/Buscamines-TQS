package cat.uab.tq.buscamines.vista;


import java.io.InputStream;
import java.util.Scanner;

public class entryData {
	private Scanner scan = null;

	// Constructor que permite inyección de InputStream
    public entryData(InputStream inputStream) {
        scan = new Scanner(inputStream);
    }

    // Constructor por defecto para uso normal (utiliza System.in)
    public entryData() {
        this(System.in);
    }
    
    //Get auxiliar para realizar el test del constructor sin parametros
    public Scanner getScan() {
    	return scan;
    }
    
    public int[] readInput() {
    	
    	int num1 = 0, num2 = 0;
        boolean valid1 = false, valid2 = false;
        
        do {
        	
        	System.out.println("Entra la coordenada X y Y separadas por un espacio: ");
            String input = scan.nextLine().trim();

            Scanner lineScanner = new Scanner(input); // Escanea la línea para números

            if (lineScanner.hasNextInt()) {
                num1 = lineScanner.nextInt();
                valid1 = true;
            }

            if (lineScanner.hasNextInt()) {
                num2 = lineScanner.nextInt();
                valid2 = true;
            }
            

            if (!valid1 || !valid2) {
                System.out.println("Coordenada invalida.\n");
            }

            lineScanner.close(); // Cierra el scanner de la línea
           

        } while (!valid1 || !valid2);

        int[] inputCoordinates = {num1, num2};
        
        return inputCoordinates; 
        
    }
    
    
    public int[] configurarPartida(int maxFiles, int minFiles, int maxCol, int minCol, int maxMines, int minMines) {
    	
    	//precondicions
    	//assert(minFiles > 0 && maxFiles <= 10) : "El numero maximo o minimo de filas es incorrecto.";
    	//assert(minCol > 0 && maxCol <= 10) : "El numero maximo o minimo de columnas es incorrecto.";
    	//assert(minMines > 0 && maxMines <= 10) : "El numero maximo o minimo de minas es incorrecto.";
    	
    	System.out.println("Entra las dimensiones deseadas del tablero, "
    			+ "el numero de filas y columnas separado por un espacio: ");
    	
    	int num1 = getIntInput(scan);
        int num2 = getIntInput(scan);

        // Postcondiciones para filas y columnas
        //assert (num1 > minFiles && num1 < maxFiles) : "El número de filas debe estar entre los intervalos permitidos";
        //assert (num2 > minCol && num2 < maxCol) : "El número de columnas debe estar entre los intervalos permitidos";
        
        
        System.out.println("Entra el numero de minas deseado: ");
        
        int mines = getIntInput(scan);

        //postcondicio
        //assert (mines < maxMines && mines > minMines) : "El numero de minas debe estar entre los intervalos permitidos";
        
        int[] config = {num1, num2, mines};
        return config;
    }
    
    
    // Método auxiliar para leer un entero con un assert que valida el tipo
    private int getIntInput(Scanner scan) {
        //assert scan.hasNextInt() : "La entrada debe ser un número entero.";
        return scan.nextInt();
    }

}