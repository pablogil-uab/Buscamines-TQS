package cat.uab.tq.buscamines.view;

import cat.uab.tq.buscamines.vista.MessageTxt;

public class MessageTxtMock extends MessageTxt{
	private StringBuilder output;

    public MessageTxtMock() {
        this.output = new StringBuilder();
    }

    @Override
    public void presentacio() {
        output.append("Benvingut al joc del buscamines!\n");
    }

    @Override
    public void victory() {
        output.append("Victoria!! Has conseguit revelar totes les caselles sense bombes.\n");
    }

    @Override
    public void bomb() {
        output.append("Oops.. Has topat amb una bomba :(\n");
        output.append("GAME OVER\n");
    }

    // Método para acceder al contenido almacenado
    public String getOutput() {
        return output.toString();
    }

    // Método para resetear el contenido almacenado
    public void resetOutput() {
        output.setLength(0);
    }

}

