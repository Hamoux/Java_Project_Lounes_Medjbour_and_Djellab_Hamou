import javax.swing.*;
import java.awt.*;

public class AppView extends JFrame {
    private JButton rentScooterButton;
    private JButton returnScooterButton;
    private JButton checkScooterStatusButton;
    private JButton viewParcStatusButton;
    private JButton saisieParcButton;
    private JButton exitButton;
    private JLabel welcomeLabel; // Add a label for the welcome message

    public AppView() {
        setTitle("Gestion de Location de Scooters");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window on the screen

        // Create a custom panel with a background image
        BackgroundPanel backgroundPanel = new BackgroundPanel("scooter.jpg");
        backgroundPanel.setLayout(new BorderLayout());

        // Create the welcome label
        welcomeLabel = new JLabel("Bonjour, [Nom du Client]!", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 30));
        welcomeLabel.setForeground(Color.WHITE); // Change text color to yellow for visibility
        backgroundPanel.add(welcomeLabel, BorderLayout.NORTH);

        // Create buttons
        rentScooterButton = new JButton("Louer un scooter");
        returnScooterButton = new JButton("Retour d'un scooter");
        checkScooterStatusButton = new JButton("État d'un scooter");
        viewParcStatusButton = new JButton("Affichage de l'état du parc");
        saisieParcButton = new JButton("Saisie du parc");
        exitButton = new JButton("Quitter");

        // Set a larger font for buttons
        Font buttonFont = new Font("Arial", Font.BOLD, 16);
        rentScooterButton.setFont(buttonFont);
        returnScooterButton.setFont(buttonFont);
        checkScooterStatusButton.setFont(buttonFont);
        viewParcStatusButton.setFont(buttonFont);
        saisieParcButton.setFont(buttonFont);
        exitButton.setFont(buttonFont);

        // Create a panel for buttons and arrange them vertically
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setOpaque(false); // Make the panel transparent to show the background

        // Add buttons to the panel with equal size
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 20, 10, 20); // Add spacing between buttons
        gbc.gridx = 0;
        gbc.gridy = 0;
        buttonPanel.add(rentScooterButton, gbc);
        gbc.gridy++;
        buttonPanel.add(returnScooterButton, gbc);
        gbc.gridy++;
        buttonPanel.add(checkScooterStatusButton, gbc);
        gbc.gridy++;
        buttonPanel.add(viewParcStatusButton, gbc);
        gbc.gridy++;
        buttonPanel.add(saisieParcButton, gbc);
        gbc.gridy++;
        buttonPanel.add(exitButton, gbc);

        // Add the button panel to the center of the background panel
        backgroundPanel.add(buttonPanel, BorderLayout.CENTER);

        // Add the background panel to the frame
        add(backgroundPanel);
    }

    public JButton getRentScooterButton() {
        return rentScooterButton;
    }

    public JButton getReturnScooterButton() {
        return returnScooterButton;
    }

    public JButton getCheckScooterStatusButton() {
        return checkScooterStatusButton;
    }

    public JButton getViewParcStatusButton() {
        return viewParcStatusButton;
    }

    public JButton getSaisieParcButton() {
        return saisieParcButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }

    public JLabel getWelcomeLabel() {
        return welcomeLabel; // Return the welcome label
    }
}

// Custom JPanel to display a background image
class BackgroundPanel extends JPanel {
    private Image backgroundImage;

    public BackgroundPanel(String imagePath) {
        try {
            backgroundImage = new ImageIcon(imagePath).getImage();
        } catch (Exception e) {
            System.err.println("Error loading background image: " + e.getMessage());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}