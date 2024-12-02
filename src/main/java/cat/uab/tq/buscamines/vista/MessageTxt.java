package cat.uab.tq.buscamines.vista;

public class MessageTxt {
	public MessageTxt() {}
	
	public void presentacio(){
    	System.out.println("Benvingut al joc del buscamines!\n");
    }

	public void victory() {
		// TODO Auto-generated method stub
		System.out.println("Victoria!! Has conseguit revelar totes les caselles sense bombes.\n");
	}

	public void bomb() {
		// TODO Auto-generated method stub
		System.out.println("Oops.. Has topat amb una bomba :(\n" + "GAME OVER\n");
	}
}
