import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.border.EmptyBorder;
import java.util.List;
import java.util.Date;

public class AppInterface extends JFrame {
    private List<Object> allObjects;
    private Client currentUser;

    public AppInterface() {
        // Charger les données
        allObjects = Main.loadAllData();

        // Configuration de la fenêtre principale
        setTitle("Uber_Scoots 🚵");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        try {
            setIconImage(new ImageIcon("scooter.png").getImage());
        } catch (Exception e) {
            System.err.println("Icon image not found");
        }

        // Panel principal
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(new Color(240, 240, 240));

        // Header
        JLabel header = new JLabel("Uber Scooter c'est les meilleur !", SwingConstants.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 24));
        header.setForeground(new Color(0, 102, 204));
        mainPanel.add(header, BorderLayout.NORTH);

        // Panel de connexion
        JPanel loginPanel = createLoginPanel();
        mainPanel.add(loginPanel, BorderLayout.CENTER);

        // Footer
        JLabel footer = new JLabel("© 2025 Gestion Scooter - Version 1.0", SwingConstants.CENTER);
        footer.setFont(new Font("Arial", Font.ITALIC, 12));
        footer.setForeground(Color.GRAY);
        mainPanel.add(footer, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }

    private JPanel createLoginPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(240, 240, 240));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblId = new JLabel("ID Utilisateur:");
        lblId.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(lblId, gbc);

        JTextField txtId = new JTextField(15);
        txtId.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(txtId, gbc);

        JButton btnLogin = createStyledButton("Se connecter");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        panel.add(btnLogin, gbc);

        btnLogin.addActionListener(e -> {
            try {
                int userId = Integer.parseInt(txtId.getText());
                for (Object obj : allObjects) {
                    if (obj instanceof Client) {
                        Client client = (Client) obj;
                        if (client.getId() == userId) {
                            currentUser = client;
                            showMainMenu();
                            return;
                        }
                    }
                }
                JOptionPane.showMessageDialog(this, "ID utilisateur non trouvé", "Erreur", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Veuillez entrer un ID valide", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        });

        return panel;
    }

    private void showMainMenu() {
        getContentPane().removeAll();

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(new Color(240, 240, 240));

        JLabel header = new JLabel("Bienvenue, " + currentUser.getPrenom() + " " + currentUser.getNom(), SwingConstants.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 20));
        header.setForeground(new Color(0, 102, 204));
        mainPanel.add(header, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(6, 1, 10, 15));
        buttonPanel.setBorder(new EmptyBorder(20, 50, 20, 50));
        buttonPanel.setBackground(new Color(240, 240, 240));

        String[] buttonLabels = {
            "Louer un scooter",
            "Retourner un scooter",
            "État d'un scooter",
            "État du parc",
            "Statistiques du parc",
            "Quitter"
        };

        for (String label : buttonLabels) {
            JButton button = createStyledButton(label);
            buttonPanel.add(button);
            button.addActionListener(this::handleMainMenuAction);
        }

        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        JLabel footer = new JLabel("© 2025 Gestion Scooter - Version 1.0", SwingConstants.CENTER);
        footer.setFont(new Font("Arial", Font.ITALIC, 12));
        footer.setForeground(Color.GRAY);
        mainPanel.add(footer, BorderLayout.SOUTH);

        add(mainPanel);
        revalidate();
        repaint();
    }

    private void handleMainMenuAction(ActionEvent e) {
        String command = ((JButton)e.getSource()).getText();

        switch(command) {
            case "Louer un scooter":
                showRentScooterDialog();
                break;
            case "Retourner un scooter":
                showReturnScooterDialog();
                break;
            case "État d'un scooter":
                showScooterStatusDialog();
                break;
            case "État du parc":
                showParcStatus();
                break;
            case "Statistiques du parc":
                showParcStatistics();
                break;
            case "Quitter":
                Main.saveAllData(allObjects);
                System.exit(0);
                break;
        }
    }

    private void showRentScooterDialog() {
        JDialog dialog = new JDialog(this, "Louer un scooter", true);
        dialog.setLayout(new BorderLayout());
        dialog.setSize(400, 300);
        dialog.setLocationRelativeTo(this);

        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JLabel lblId = new JLabel("ID du scooter:");
        JTextField txtId = new JTextField();
        JButton btnSubmit = createStyledButton("Louer");

        panel.add(lblId);
        panel.add(txtId);
        panel.add(btnSubmit);

        btnSubmit.addActionListener(e -> {
            try {
                int scooterId = Integer.parseInt(txtId.getText());
                currentUser.LouerScooter(scooterId);
                JOptionPane.showMessageDialog(dialog, "Location effectuée avec succès", "Succès", JOptionPane.INFORMATION_MESSAGE);
                dialog.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(dialog, "Veuillez entrer un ID valide", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        });

        dialog.add(panel);
        dialog.setVisible(true);
    }

    private void showReturnScooterDialog() {
        JDialog dialog = new JDialog(this, "Retourner un scooter", true);
        dialog.setLayout(new BorderLayout());
        dialog.setSize(400, 350);
        dialog.setLocationRelativeTo(this);

        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JLabel lblId = new JLabel("ID du scooter:");
        JTextField txtId = new JTextField();
        JLabel lblKm = new JLabel("Kilométrage effectué:");
        JTextField txtKm = new JTextField();
        JButton btnSubmit = createStyledButton("Retourner");

        panel.add(lblId);
        panel.add(txtId);
        panel.add(lblKm);
        panel.add(txtKm);
        panel.add(btnSubmit);

        btnSubmit.addActionListener(e -> {
            try {
                int scooterId = Integer.parseInt(txtId.getText());
                double km = Double.parseDouble(txtKm.getText());
                currentUser.RetournerScooter(scooterId, km);
                JOptionPane.showMessageDialog(dialog, "Retour effectué avec succès", "Succès", JOptionPane.INFORMATION_MESSAGE);
                dialog.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(dialog, "Veuillez entrer des valeurs valides", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        });

        dialog.add(panel);
        dialog.setVisible(true);
    }

    private void showScooterStatusDialog() {
        JDialog dialog = new JDialog(this, "État d'un scooter", true);
        dialog.setLayout(new BorderLayout());
        dialog.setSize(400, 300);
        dialog.setLocationRelativeTo(this);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JLabel lblId = new JLabel("ID du scooter:");
        JTextField txtId = new JTextField();
        JButton btnSubmit = createStyledButton("Vérifier");
        JTextArea txtResult = new JTextArea();
        txtResult.setEditable(false);

        JPanel inputPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        inputPanel.add(lblId);
        inputPanel.add(txtId);
        inputPanel.add(btnSubmit);

        btnSubmit.addActionListener(e -> {
            try {
                int scooterId = Integer.parseInt(txtId.getText());
                String status = getScooterStatus(scooterId);
                txtResult.setText(status);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(dialog, "Veuillez entrer un ID valide", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        });

        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(new JScrollPane(txtResult), BorderLayout.CENTER);

        dialog.add(panel);
        dialog.setVisible(true);
    }

    private String getScooterStatus(int scooterId) {
        for (Object obj : allObjects) {
            if (obj instanceof Scooter) {
                Scooter scooter = (Scooter) obj;
                if (scooter.getId() == scooterId) {
                    return "Modèle: " + scooter.getModele().getModeleNom() + "\n" +
                           "Kilométrage: " + scooter.getKilometrage() + " km\n" +
                           "Disponible: " + (scooter.isAvailable() ? "Oui" : "Non");
                }
            }
        }
        return "Scooter non trouvé";
    }

    private void showParcStatus() {
        JDialog dialog = new JDialog(this, "État du parc", true);
        dialog.setLayout(new BorderLayout());
        dialog.setSize(500, 400);
        dialog.setLocationRelativeTo(this);

        JTextArea txtResult = new JTextArea();
        txtResult.setEditable(false);

        StringBuilder status = new StringBuilder();
        for (Object obj : allObjects) {
            if (obj instanceof Parc_Scooter) {
                Parc_Scooter parc = (Parc_Scooter) obj;
                status.append("Parc: ").append(parc.getNom()).append("\n");
                status.append("Capacité: ").append(parc.getCapacite()).append("\n");
                status.append("Scooters:\n");

                for (Scooter scooter : parc.getScooters()) {
                    status.append("- ID: ").append(scooter.getId())
                          .append(", Modèle: ").append(scooter.getModele().getModeleNom())
                          .append(", Disponible: ").append(scooter.isAvailable() ? "Oui" : "Non")
                          .append("\n");
                }
                status.append("\n");
            }
        }

        txtResult.setText(status.toString());

        dialog.add(new JScrollPane(txtResult), BorderLayout.CENTER);
        dialog.setVisible(true);
    }

    private void showParcStatistics() {
        JDialog dialog = new JDialog(this, "Statistiques du parc", true);
        dialog.setLayout(new BorderLayout());
        dialog.setSize(500, 400);
        dialog.setLocationRelativeTo(this);

        JTextArea txtResult = new JTextArea();
        txtResult.setEditable(false);

        StringBuilder stats = new StringBuilder();
        for (Object obj : allObjects) {
            if (obj instanceof Parc_Scooter) {
                Parc_Scooter parc = (Parc_Scooter) obj;
                int total = parc.getScooters().size();
                int available = 0;
                double totalKm = 0;

                for (Scooter scooter : parc.getScooters()) {
                    if (scooter.isAvailable()) available++;
                    totalKm += scooter.getKilometrage();
                }

                stats.append("Parc: ").append(parc.getNom()).append("\n");
                stats.append("Total scooters: ").append(total).append("\n");
                stats.append("Scooters disponibles: ").append(available).append("\n");
                stats.append("Scooters en location: ").append(total - available).append("\n");
                stats.append("Kilométrage moyen: ").append(total > 0 ? String.format("%.2f km", totalKm/total) : "N/A").append("\n\n");
            }
        }

        txtResult.setText(stats.toString());

        dialog.add(new JScrollPane(txtResult), BorderLayout.CENTER);
        dialog.setVisible(true);
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.PLAIN, 16));
        button.setBackground(new Color(200, 200, 200));
        button.setForeground(Color.BLACK);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(120, 120, 120), 2),
            BorderFactory.createEmptyBorder(10, 25, 10, 25)
        ));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(160, 160, 160));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(200, 200, 200));
            }
        });

        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            new AppInterface();
        });
    }
}
