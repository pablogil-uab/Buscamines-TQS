package main.java.cat.uab.tq.buscamines.model;
import java.util.ArrayList;
import java.util.List; 
import java.util.Random;


public class Tauler {
	private Casella[][] caselles;
    private int amplada, altura, nMines;
    private int bombCount, casellesMostrades;
    
    public Tauler(int amplada, int altura, int mines) {
    	
    	//precondiciones
    	assert amplada > 0 : "La amplada debe ser mayor que 0";
        assert altura > 0 : "La altura debe ser mayor que 0";
        assert mines >= 0 : "El número de minas debe ser no negativo";
        assert mines <= amplada * altura : "El número de minas no puede exceder el total de casillas";
    	
    	//implementacion
    	this.amplada = amplada;
        this.altura = altura;
        this.nMines = mines;
        
        caselles = new Casella[amplada][altura];
        
        for(int y = 0; y < altura; y++) {
            for(int x = 0; x < amplada; x++) {
            	caselles[x][y] = new Casella();
            }
        }
        
        bombCount = 0;
        
        casellesMostrades = 0;
        
        //postcondiciones
        assert invariants();
    }
    
    private boolean invariants() {
        return amplada > 0 &&
               altura > 0 &&
               nMines >= 0 &&
               bombCount <= amplada * altura &&
               casellesMostrades + bombCount <= amplada * altura;
    }
    
    
    public int getCasellesMostrades() {
    	return casellesMostrades;
    }
    
    public int getBombCount() {
    	return bombCount;
    }
    public Casella getCasella(int x, int y) {
    	return caselles[x][y];
    }
	
    public int getAltura() {
    	return altura;
    }
    
    public int getAmplada() {
    	return amplada;
    }
    
    public void mostrarCasella(int x, int y) {
    	
    	//precondiciones
    	assert x >= 0 && x < amplada : "Coordenada x fuera de rango";
        assert y >= 0 && y < altura : "Coordenada y fuera de rango";
        
      //implementacion
    	if(caselles[x][y].getVeins() != 0) {
    		casellesMostrades++;
        	caselles[x][y].mostrarCasella();
    	}else {
    		revelaCasellesAdjuntes(x, y);
    	}
    	
    	//postcondiciones
    	 assert caselles[x][y].getEsVisible() : "Postcondición fallida: La casilla no es visible";
    	 assert casellesMostrades + bombCount <= amplada * altura : "Postcondición fallida: Casillas mostradas exceden el límite";
    	 assert invariants() : "Invariantes fallidas tras mostrar casilla";
    }
    
    private void revelaCasellesAdjuntes(int x, int y) {
		// TODO Auto-generated method stub

    	int minX = Math.max(0, x-1);
        int maxX = Math.min(amplada - 1, x+1);
        int minY = Math.max(0, y-1);
        int maxY = Math.min(altura-1, y+1);
        
        for(int b = minY; b <= maxY; b++) {
            for(int a = minX; a <= maxX; a++) {
            	if(!caselles[a][b].getEsVisible()) {
            		
            		caselles[a][b].mostrarCasella();
            		casellesMostrades++;
            	}
            }
        }
	}

	public boolean casellaVisible(int x, int y) {
    	return caselles[x][y].getEsVisible();
    }
    
    public boolean isBomb(int x, int y) {
    	return caselles[x][y].isBomb();
    }
    
    public void addBomba(int x, int y) {
    	
    	//precondiciones
    	assert x >= 0 && x < amplada : "Coordenada x fuera de rango";
        assert y >= 0 && y < altura : "Coordenada y fuera de rango";
        assert !caselles[x][y].isBomb() : "La casilla ya contiene una bomba";
        
        
        //implementacio
    	int minX = Math.max(0, x-1);
        int maxX = Math.min(amplada - 1, x+1);
        int minY = Math.max(0, y-1);
        int maxY = Math.min(altura-1, y+1);
        
        for(int b = minY; b <= maxY; b++) {
            for(int a = minX; a <= maxX; a++) {
            	caselles[a][b].addVei();
            }
        }
       
        caselles[x][y].setBomb();
        bombCount++;
        
      //postcondiciones
        assert caselles[x][y].isBomb() : "Postcondición fallida: La casilla no tiene una bomba";
        assert bombCount <= amplada * altura : "Postcondición fallida: Demasiadas bombas";
        assert invariants() : "Invariantes fallidas tras añadir bomba";
        
    }
    
    public void setRandomBombs() {
    	
    	//precondiciones
    	assert nMines <= amplada * altura : "No hay suficiente espacio para las bombas";
    	
    	//implementacio
    	Random rand = new Random();
    	int x, y;
    	for(int i = 0; i < nMines; i++) {
    		do {
    			x = rand.nextInt(amplada);
        		y = rand.nextInt(altura);
    		}while(caselles[x][y].isBomb());
    		
    		addBomba(x, y);
    	}
    	
    	//postcondiciones
    	
    	assert bombCount == nMines : "Postcondición fallida: Número incorrecto de bombas";
        assert invariants() : "Invariantes fallidas tras colocar bombas";
    }
    
    public void mostrarTaulell() {
    	for(int y = 0; y < altura; y++) {
    		for (int x = 0; x < amplada; x++) {
    			caselles[x][y].mostrarCasella();
    		}
    	}
    }
    
    public boolean isWon() {
    	return casellesMostrades+ bombCount == amplada * altura;
    }
    
    
    
    
    
}
