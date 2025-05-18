import javax.swing.*;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppModel model = new AppModel();

            // Check if the data file exists
            File dataFile = new File("Data.txt");
            if (dataFile.exists()) {
                // Load data from the file
                model.loadAllData();
            } else {
                // Initialize objects and save them to the file
                model.initializeData();
                model.saveAllData();
            }

            AppView view = new AppView();
            new AppController(model, view);
            view.setVisible(true);
        });
    }
}


