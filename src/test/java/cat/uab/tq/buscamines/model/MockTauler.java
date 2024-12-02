package cat.uab.tq.buscamines.model;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;



public class MockTauler extends Tauler{
	
	private String[] listC = {"0", "1", "2", "*", "B"};
	int a = 10, b = 10, mode = 0;

	public MockTauler(int amplada, int altura, int mines) {
		super(amplada, altura, mines);
		// TODO Auto-generated constructor stub
	}
	
	public void setMock(int x) {
		mode = x;
	}
	public int getAltura() {
		return a;
	}
	
	public int getAmplada() {
		return b;
	}
	
	public void setAmplada(int x) {
		x = b;
	}
	
	public void setAltura(int x) {
		x = a;
	}
	
	public Casella getCasella(int x, int y) {
		
		switch(mode) {
		
		case 0:
			return new Casella();
			
		case 1:
			if (x == 3 && y == 3) {
				Casella c = new Casella();
				c.mostrarCasella();
				c.setBomb();
				return c;
			}
			
			return new Casella();	
		
		case 2:
			if (x == 3 && y == 3) {
				Casella c = new Casella();
				c.mostrarCasella();
				c.addVei();
				c.addVei();
				return c;
			}
			if (x == 4 && y == 2) {
				Casella c = new Casella();
				c.mostrarCasella();
				c.setBomb();
				return c;
			}
			
			return new Casella();
			
			
		}
		return null;	
	}
	
	public boolean casellaVisible(int x, int y) {
		if(mode == 0) {
			return true;
		}
		
		return false;
	}
	
	public int getCasellesMostrades() {
		return 10;
	}
	
	public int getBombCount() {
		return 8;
	}
		
	
	
}
