package cat.uab.tq.buscamines.model;

public class Casella {
	
	private boolean esVisible;
	private tipusCasella tipus;
	private int veins;
	
	public Casella() {
		reset();
	}
	
	public void reset() {
		esVisible = false;
		tipus = new Normal();
		veins = 0;
		assert !esVisible : "Postcondición fallida: esVisible debe ser false después de reset().";
		assert tipus instanceof Normal : "Postcondición fallida: tipus debe ser Normal después de reset().";
		assert veins == 0 : "Postcondición fallida: veins debe ser 0 después de reset().";
	}
	
	public void addVei() {
		veins++;
	}
	
	public int getVeins(){
		return veins;
	}
	
	public void setBomb() {
		tipus = new Mina();
		assert tipus instanceof Mina;
	}
	
	public boolean isBomb() {
		return tipus.isBomb();
	}
	
	public boolean getEsVisible() {
		return esVisible;
	}
	
	public void mostrarCasella() {
		esVisible = true;
		assert esVisible;
	}
	
	public String toString() {
		if(esVisible) {
			if(isBomb()) {
				return "B";
			}
			else {
				return ""+veins;
			}
		}
		else 
            return "*";
	}

	public tipusCasella getTipus() {
		// TODO Auto-generated method stub
		assert tipus != null;
		return tipus;
	}
	
	
	
}
