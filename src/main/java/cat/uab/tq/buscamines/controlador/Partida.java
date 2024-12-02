package controller;
import model.*;
import view.*;

public class Partida {
	
	private final static int maxFiles = 10;
	private final static int maxCol = 10;
	private final static int minFiles = 5;
	private final static int minCol = 5;
	
	private final static int minMines = 5;
	private final static int maxMines = 10;
	
	private static int moviment[] = null;
	private static MessageTxt message = new MessageTxt();
	private static entryData input = new entryData();
	private static VistaTauler vista = new VistaTauler();
	private static Tauler tauler = null;
	
	public Partida() {
	}
	
	public Partida(MessageTxt m, entryData i, VistaTauler v) { //constructor necessario para validar el test de testConfigurarPartidaNotNull()
		input = i;
		vista = v;
		message = m;
		tauler = null;
	}
	
	public Partida(Tauler t, MessageTxt m, entryData i, VistaTauler v) {
		message = m;
		input = i;
		vista = v;
		tauler = t;
	}
	
	public void startPartida() {
		
		message.presentacio();
		
		this.configurarPartida();
		
		tauler.setRandomBombs();
		
		
		do {
			
			vista.printTauler(tauler);
			
			vista.printStatus(tauler);

			validarInput();
			
			tauler.mostrarCasella(moviment[0], moviment[1]);
			
		}while(!tauler.isWon() && (!tauler.isBomb(moviment[0], moviment[1])));
		
		tauler.mostrarTaulell();
		
		vista.printTauler(tauler);
		
		if(tauler.isWon()) {
			message.victory();
		}else {
			message.bomb();
		}
	}
}
