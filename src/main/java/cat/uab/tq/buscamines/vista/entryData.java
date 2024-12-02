package Vista;

import java.util.Scanner;

public class entryData {
    private final Scanner scanner;

    public entryData() {
        scanner = new Scanner(System.in);
    }

    public int[] leerMovimiento() {
        int fila, columna;
        while (true) {
            System.out.println("Introduce fila y columna separadas por un espacio: ");
            try {
                String[] entrada = scanner.nextLine().trim().split(" ");
                fila = Integer.parseInt(entrada[0]);
                columna = Integer.parseInt(entrada[1]);
                return new int[] { fila, columna };
            } catch (Exception e) {
                System.out.println("Entrada inválida. Inténtalo de nuevo.\n");
            }
        }
    }

    public int[] configurarPartida(int maxFiles, int minFiles, int maxCol, int minCol, int maxMines, int minMines) {
    	
    	int num1, num2, mines;
    	
    	System.out.println("Entra las dimensiones deseadas del tablero, "
    			+ "el numero de filas y columnas separado por un espacio: ");
    	num1 = scanner.nextInt();
        num2 = scanner.nextInt(); 
        assert (num1 > minFiles && num1 < maxFiles) : "El numero de filas debe estar entre los intervalos permitidos";
        assert(num2 > minCol && num2 < maxCol) : "El numero de columnas debe estar entre los intervalos permitidos";

        
        
        System.out.println("Entra el numero de minas deseado: ");
        mines = scanner.nextInt();
        System.out.println();
        assert (mines < maxMines && mines > minMines) : "El numero de minas debe estar entre los intervalos permitidos";
        
        int[] input = {num2, num1, mines};
        return input;
    }

}

