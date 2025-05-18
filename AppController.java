import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppController {
    private AppModel model;
    private AppView view;
    private Client user;

    public AppController(AppModel model, AppView view) {
        this.model = model;
        this.view = view;

        // Initialize user
        user = initializeUser();

        // Add action listeners to buttons
        view.getRentScooterButton().addActionListener(new RentScooterListener());
        view.getReturnScooterButton().addActionListener(new ReturnScooterListener());
        view.getCheckScooterStatusButton().addActionListener(new CheckScooterStatusListener());
        view.getViewParcStatusButton().addActionListener(new ViewParcStatusListener());
        view.getSaisieParcButton().addActionListener(new SaisieParcListener());
        view.getExitButton().addActionListener(e -> {
            model.saveAllData();
            JOptionPane.showMessageDialog(view, "Données sauvegardées. Fermeture du programme.", "Quitter", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        });
    }

    private Client initializeUser() {
        while (true) {
            String input = JOptionPane.showInputDialog(view, "Entrez votre identifiant client :");
            try {
                int id = Integer.parseInt(input);
                for (Object obj : model.getAllObjects()) {
                    if (obj instanceof Client) {
                        Client client = (Client) obj;
                        if (client.getId() == id) {
                            view.getWelcomeLabel().setText("Bonjour, " + client.getNom() + " " + client.getPrenom() + "!");
                            return client;
                        }
                    }
                }
                JOptionPane.showMessageDialog(view, "Identifiant client introuvable. Réessayez.");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(view, "Entrée invalide. Veuillez entrer un identifiant valide.");
            }
        }
    }

    private class RentScooterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String input = JOptionPane.showInputDialog(view, "Entrez l'identifiant du scooter à louer :");
            try {
                int scooterId = Integer.parseInt(input);
                String result = user.LouerScooter(scooterId);
                // Show the result in a dialog box
                JOptionPane.showMessageDialog(view, result, "Résultat de la location", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(view, "Erreur : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class ReturnScooterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // First input dialog for the scooter ID
                String idInput = JOptionPane.showInputDialog(view, "Entrez l'identifiant du scooter :");
                int scooterId = Integer.parseInt(idInput);

                // Second input dialog for the kilometerage
                String kmInput = JOptionPane.showInputDialog(view, "Entrez le kilométrage effectué :");
                double km = Double.parseDouble(kmInput);

                // Use the output from the RetournerScooter method
                String result = user.RetournerScooter(scooterId, km);
                // Show the result in a dialog box
                JOptionPane.showMessageDialog(view, result, "Résultat du retour", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(view, "Entrée invalide. Veuillez entrer des valeurs valides.", "Erreur", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(view, "Erreur : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class CheckScooterStatusListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String input = JOptionPane.showInputDialog(view, "Entrez l'identifiant du scooter pour vérifier son état :");
            try {
                int scooterId = Integer.parseInt(input);
                String status = user.getParc().EtatScooter(scooterId);
                // Show the result in a dialog box
                JOptionPane.showMessageDialog(view, status, "État du scooter", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(view, "Entrée invalide. Veuillez entrer un identifiant valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(view, "Erreur : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class ViewParcStatusListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String parcStatus = user.getParc().EtatParc();
            JOptionPane.showMessageDialog(view, parcStatus, "État du parc", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private class SaisieParcListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String saisieParc = user.getParc().SaisiParc();
            JOptionPane.showMessageDialog(view, saisieParc, "Résumé du parc", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}