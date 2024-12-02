package cat.uab.tq.buscamines.controlador;

import cat.uab.tq.buscamines.model.Tauler;
import cat.uab.tq.buscamines.vista.MessageTxt;
import cat.uab.tq.buscamines.vista.VistaTauler;
import cat.uab.tq.buscamines.vista.entryData;

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
	
	public void configurarPartida() {

		if(tauler == null) {
			int[] parametres;
			parametres = input.configurarPartida(maxFiles, minFiles, maxCol, minCol, maxMines, minMines);
			tauler = new Tauler(parametres[0], parametres[1], parametres[2]);
		}
		
		
	}
	
	public void validarInput() {
		
		do{
			moviment = input.readInput();

		}while(!vista.validarPosicio(tauler, moviment[0], moviment[1]));
		
	}
	
}
