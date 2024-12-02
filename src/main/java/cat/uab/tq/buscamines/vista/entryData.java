package view;
import java.util.Scanner;

public class entryData {
	private Scanner scan;

    public entryData() {
        scan = new Scanner(System.in);
    }

    public int[] readInput() {
    	
        int num1 = 0, num2 = 0;
        boolean valid1 = false, valid2 = false;
        
        do {
        	String input = scan.nextLine().trim();
        	if(input.equalsIgnoreCase("quit")) {
                System.out.println("Gracias por jugar!");
                System.exit(0);
            }
            
        	System.out.println("Entra la coordenada X y Y separadas por un espacio: ");
            
            if(scan.hasNextInt()) {
            	num1 = scan.nextInt();
            	valid1 = true;
            }
            
            if(scan.hasNextInt()) {
            	num2 = scan.nextInt();
            	valid2 = true;
            }
            
            if(!valid1 || !valid2) {
            	System.out.println("Coordenada invalida.\n");
            }
            
        	
        }while(!valid1 || !valid2);
        
        
        int[] input = {num2, num1};
        return input;
    }
    
    
    public int[] configurarPartida(int maxFiles, int minFiles, int maxCol, int minCol, int maxMines, int minMines) {
    	
    	int num1, num2, mines;
    	
    	System.out.println("Entra las dimensiones deseadas del tablero, "
    			+ "el numero de filas y columnas separado por un espacio: ");
    	num1 = scan.nextInt();
        num2 = scan.nextInt(); 
        assert (num1 > minFiles && num1 < maxFiles) : "El numero de filas debe estar entre los intervalos permitidos";
        assert(num2 > minCol && num2 < maxCol) : "El numero de columnas debe estar entre los intervalos permitidos";

        
        
        System.out.println("Entra el numero de minas deseado: ");
        mines = scan.nextInt();
        System.out.println();
        assert (mines < maxMines && mines > minMines) : "El numero de minas debe estar entre los intervalos permitidos";
        
        int[] input = {num2, num1, mines};
        return input;
    }

}
