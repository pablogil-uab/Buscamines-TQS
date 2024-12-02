package cat.uab.tq.buscamines.view;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MessageTxtMockTest {

    public static void main(String[] args) {
        // Crear una instancia del mock
        MessageTxtMock mock = new MessageTxtMock();

        // Llamar a los métodos simulados
        mock.presentacio();
        mock.victory();
        mock.bomb();

        // Verificar el contenido generado
        String output = mock.getOutput();
        System.out.println("Contenido del mock:");
        System.out.println(output);

        // Puedes usar assertions para validar
        assert output.contains("Benvingut al joc del buscamines!");
        assert output.contains("Victoria!! Has conseguit revelar totes les caselles sense bombes.");
        assert output.contains("Oops.. Has topat amb una bomba :(");
    }
}

