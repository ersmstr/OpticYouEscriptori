package opticyou.OpticYou.ui;

import opticyou.OpticYou.service.LogoutService;
import javax.swing.*;
import java.awt.*;

public class ClientScreen {
    private static final String APP_NAME = "OpticYou";
    private String token;

    public ClientScreen(String token) {
        this.token = token;

        // Crear el JFrame principal
        JFrame frame = new JFrame(APP_NAME + " - Pantalla NEGOCI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        // 🔹 1. Crear el panell central (Menú d'opcions')
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(5, 1, 10, 10)); // Disposició 5 files, 1 columna
        menuPanel.setBackground(new Color(50, 50, 50)); // Color de fond

        // Crear botons del menú
        JButton btnPerfil = new JButton("Gestió de clients");
        JButton btnHistorial = new JButton("Gestió de cites");
        JButton btnAjustes = new JButton("Gestió de Prescripcions");


        // Aplicar estils als botons
        JButton[] menuButtons = {btnPerfil, btnHistorial, btnAjustes};
        for (JButton btn : menuButtons) {
            btn.setFont(new Font("Arial", Font.BOLD, 14));
            btn.setFocusPainted(false);
            btn.setBackground(new Color(70, 70, 70));
            btn.setForeground(Color.WHITE);
            btn.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            menuPanel.add(btn);
        }

        //  Accions per a cada botó
        btnPerfil.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Gestió Clients"));
        btnHistorial.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Obrir cites"));
        btnAjustes.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Obrir prescripcions"));


        //  Botó logout
        JButton logoutButton = new JButton("Tancar Sesió");
        logoutButton.setFont(new Font("Arial", Font.BOLD, 14));
        logoutButton.setBackground(new Color(200, 50, 50));
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setFocusPainted(false);
        logoutButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        logoutButton.addActionListener(e -> {
            LogoutService logoutService = new LogoutService();
            logoutService.logout(token);
            frame.dispose();
        });

        menuPanel.add(logoutButton); // afegir el botó al menú


        // Crear el panell principal centrat
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.add(menuPanel);

        // Afegir els panells al frame
        frame.add(mainPanel, BorderLayout.CENTER); // Centrar el menú a la finestra

        // Mostrar la finestra a
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
