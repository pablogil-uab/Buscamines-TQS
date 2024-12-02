package cat.uab.tq.buscamines.vista;

import cat.uab.tq.buscamines.model.Tauler;

public class VistaTauler {
	
	
	public VistaTauler() { }
	
	public void printTauler(Tauler tauler) {
        for(int y = 0; y < tauler.getAltura(); y++) {
            for(int x = 0; x < tauler.getAmplada(); x++) {
                System.out.print(tauler.getCasella(x, y) + " ");
            }
            System.out.println(" |"+ y);
        }
        
        for(int x = 0; x < tauler.getAmplada(); x++) {
        	System.out.print("_ ");
        }
        System.out.println();
        
        for(int x = 0; x < tauler.getAmplada(); x++) {
        	System.out.print(x);
        	if(x+1 < 10) {
        		System.out.print(" ");
        	}
        }
        System.out.println("\n");
        
    }
	
	public boolean validarPosicio(Tauler tauler, int x, int y) {
		if((x < 0 || x >= tauler.getAmplada()) || (y < 0 || y >= tauler.getAltura())) {
			System.out.println("Esta casilla no es correcta!\n");
			return false;
		}
		
		if(tauler.casellaVisible(x, y)) {
			System.out.println("Esta casilla ya esta destapada!\n");
			return false;
		}
		
		return true; 
	}
	
	public void printStatus(Tauler tauler) {
		int a = tauler.getCasellesMostrades();
		int b = tauler.getBombCount();
		int c = tauler.getAmplada() * tauler.getAltura();
		System.out.println(a + " caselles mostrades de " + (c-b) + 
				" caselles segures per desbloquejar.\n");
	}

}
