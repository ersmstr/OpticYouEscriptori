package opticyou.OpticYou.ui;

import opticyou.OpticYou.service.LogoutService;

import javax.swing.*;
import java.awt.*;

public class AdminPanelScreen {
    private static final String APP_NAME = "OpticYou";
    private String token;

    public AdminPanelScreen(String token) {
        JFrame frame = new JFrame(APP_NAME + " PANELL ADMINISTRADOR ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());

        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(4, 1, 10, 10));

        // Elementos de la pantalla de admin (puedes agregar más según tus necesidades)
        JLabel welcomeLabel = new JLabel("Pantalla Administrador", SwingConstants.CENTER);

        menuPanel.add(welcomeLabel);

        // Botón de logout
        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(e -> {
            // Lógica de logout al hacer click en el botón
            System.out.println("Logout presionado.");

            // Aquí es donde se llama a la clase LogoutService para hacer el logout
            LogoutService logoutService = new LogoutService(); // Creamos una instancia de LogoutService
            logoutService.logout(token); // Llamamos al método logout y le pasamos el token


            // Si quieres cerrar la aplicación tras el logout
            frame.dispose();
        });

        // Agregar el botón de logout al panel
        menuPanel.add(logoutButton);

        frame.add(menuPanel, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}