package Vista;

import Model.Tauler;


public class VistaTauler {

    public VistaTauler() { }

    public void mostrarTablero(Tauler tablero) {
        for (int y = 0; y < tablero.getAltura(); y++) {
            for (int x = 0; x < tablero.getAnchura(); x++) {
                System.out.print(tablero.obtenerCasilla(x, y) + " ");
            }
            System.out.println(" |" + y);
        }

        imprimirLineasInferiores(tablero);
        imprimirNumerosInferiores(tablero);
    }

    private void imprimirLineasInferiores(Tauler tablero) {
        for (int x = 0; x < tablero.getAnchura(); x++) {
            System.out.print("_ ");
        }
        System.out.println();
    }

    private void imprimirNumerosInferiores(Tauler tablero) {
        for (int x = 0; x < tablero.getAnchura(); x++) {
            System.out.print(x + " ");
        }
        System.out.println("\n");
    }

    public boolean validarMovimiento(Tauler tablero, int x, int y) {
        if (!estaDentroDelTablero(tablero, x, y)) {
            System.out.println("Movimiento fuera del tablero!\n");
            return false;
        }

        if (tablero.esCasillaVisible(x, y)) {
            System.out.println("Esta casilla ya está destapada!\n");
            return false;
        }

        return true;
    }

    private boolean estaDentroDelTablero(Tauler tablero, int x, int y) {
        return x >= 0 && x < tablero.getAnchura() && y >= 0 && y < tablero.getAltura();
    }

    public void mostrarEstado(Tauler tablero) {
        int mostradas = tablero.getCasillasMostradas();
        int seguras = tablero.getTotalSeguras();
        System.out.println(mostradas + " casillas mostradas de " + seguras + " disponibles.\n");
    }
}
