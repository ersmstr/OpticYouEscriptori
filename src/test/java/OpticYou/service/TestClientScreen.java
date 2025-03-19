package OpticYou.service;



import opticyou.OpticYou.ui.ClientScreen;
import javax.swing.SwingUtilities;

public class TestClientScreen {
    public static void main(String[] args) {
        // Ejecutamos la pantalla ClientScreen con un token de prueba
        SwingUtilities.invokeLater(() -> new ClientScreen("TOKEN_PRUEBA"));
    }
}
