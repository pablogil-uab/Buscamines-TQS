package Controlador;

import Model.Tauler;
import Vista.MessageTxt;
import Vista.VistaTauler;
import Vista.entryData;

public class Partida {
    private static final int MAX_FILAS = 15;
    private static final int MIN_FILAS = 5;
    private static final int MAX_COLUMNAS = 15;
    private static final int MIN_COLUMNAS = 5;
    private static final int MIN_MINAS = 5;
    private static final int MAX_MINAS = 15;

    private static int[] movimiento;
    private static MessageTxt mensajes;
    private static entryData entrada;
    private static VistaTauler vistaTablero;
    private static Tauler tablero;

    public Partida() {
        mensajes = new MessageTxt();
        entrada = new entryData();
        vistaTablero = new VistaTauler();
    }

    public void startPartida() {
    	assert mensajes != null : "mensajes no puede ser null";
        assert entrada != null : "entrada no puede ser null";
        assert vistaTablero != null : "vistaTablero no puede ser null";
        mensajes.presentacio();
        configurarJuego();
        assert tablero != null : "tablero debe estar configurado después de configurarJuego";
        tablero.colocarBombasAleatorias();

        do {
            vistaTablero.mostrarTablero(tablero);
            vistaTablero.mostrarEstado(tablero);
            obtenerMovimientoValido();
            tablero.revelarCasilla(movimiento[0], movimiento[1]);
        } while (!tablero.estaGanado() && !tablero.comprobarBomba(movimiento[0], movimiento[1]));

        vistaTablero.mostrarTablero(tablero);

        if (tablero.estaGanado()) {
            mensajes.victory();
        } else {
            mensajes.bomb();
        }
    }

    private void configurarJuego() {
        int[] parametros = entrada.configurarPartida(MAX_FILAS, MIN_FILAS, MAX_COLUMNAS, MIN_COLUMNAS, MAX_MINAS, MIN_MINAS);
        
        assert parametros.length == 3 : "configurarPartida debe retornar un arreglo de tamaño 3";
        assert parametros[0] >= MIN_FILAS && parametros[0] <= MAX_FILAS : "El número de filas está fuera del rango permitido";
        assert parametros[1] >= MIN_COLUMNAS && parametros[1] <= MAX_COLUMNAS : "El número de columnas está fuera del rango permitido";
        assert parametros[2] >= MIN_MINAS && parametros[2] <= MAX_MINAS : "El número de minas está fuera del rango permitido";
        
        tablero = new Tauler(parametros[0], parametros[1], parametros[2]);
        
        assert tablero != null : "tablero no puede ser null después de la configuración";
    }

    private void obtenerMovimientoValido() {
        do {
            movimiento = entrada.leerMovimiento();
            
        } while (!vistaTablero.validarMovimiento(tablero, movimiento[0], movimiento[1]));
    }
}
