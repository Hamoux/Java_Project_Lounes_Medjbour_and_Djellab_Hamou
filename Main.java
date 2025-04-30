import java.io.*;
import java.util.*;

public class Main {
    public static void saveAllData(List<Object> allObjects) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Data.txt"))) {
            out.writeObject(allObjects);
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving data: " + e.getMessage());
        }
    }

    public static List<Object> loadAllData() {
        List<Object> loadedObjects = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Data.txt"))) {
            Object obj = in.readObject();
            if (obj instanceof List) {
                loadedObjects = (List<Object>) obj;
            } else {
                System.err.println("Error: Data in file is not a List<Object>.");
            }
            System.out.println("Data loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading data: " + e.getMessage());
        }
        return loadedObjects;
    }

    public static <T> T findOrCreate(List<Object> allObjects, T newObject, int id) {
        for (Object obj : allObjects) {
            if (obj.getClass() == newObject.getClass()) {
                try {
                    // Check if the IDs match
                    int existingId = (int) obj.getClass().getMethod("getId").invoke(obj);
                    if (existingId == id) {
                        return (T) obj; // Return the existing object
                    }
                } catch (Exception e) {
                    System.err.println("Error comparing objects: " + e.getMessage());
                }
            }
        }
        // If not found, add the new object to the list and return it
        allObjects.add(newObject);
        return newObject;
    }

    public static void main(String[] args) {
        List<Object> allObjects;

        // Load existing data if available
        File dataFile = new File("Data.txt");
        if (dataFile.exists()) {
            allObjects = loadAllData();
        } else {
            allObjects = new ArrayList<>();
        }

        // Create or update objects dynamically
        Marque BMW = findOrCreate(allObjects, new Marque("BMW"), 1);
        Modele MP40 = findOrCreate(allObjects, new Modele("MP40", "v_twin", 150, BMW), 1);
        Parc_Scooter parc1 = findOrCreate(allObjects, new Parc_Scooter("Louvre", 200), 1);
        Scooter Scot1 = findOrCreate(allObjects, new Scooter(MP40, parc1), 1);

        Marque Yamaha = findOrCreate(allObjects, new Marque("Yamaha"), 2);
        Modele XMax = findOrCreate(allObjects, new Modele("XMax", "parallel_twin", 180, Yamaha), 2);
        Parc_Scooter parc2 = findOrCreate(allObjects, new Parc_Scooter("Montparnasse", 150), 2);
        Scooter Scot2 = findOrCreate(allObjects, new Scooter(XMax, parc1), 2);

        Marque Honda = findOrCreate(allObjects, new Marque("Honda"), 3);
        Modele PCX = findOrCreate(allObjects, new Modele("PCX", "single", 125, Honda), 3);
        Parc_Scooter parc3 = findOrCreate(allObjects, new Parc_Scooter("Châtelet", 100), 3);
        Scooter Scot3 = findOrCreate(allObjects, new Scooter(PCX, parc1), 3);

        Marque Ducati = findOrCreate(allObjects, new Marque("Ducati"), 4);
        Modele Monster = findOrCreate(allObjects, new Modele("Monster", "v_twin", 200, Ducati), 4);
        Parc_Scooter parc4 = findOrCreate(allObjects, new Parc_Scooter("La Défense", 250), 4);
        Scooter Scot4 = findOrCreate(allObjects, new Scooter(Monster, parc1), 4);

        Permis permisA = findOrCreate(allObjects, new Permis("A"), 1);
        Permis permisB = findOrCreate(allObjects, new Permis("B"), 2);

        Client client1 = findOrCreate(allObjects, new Client("Djellab", 123456789, "Hamou", new Date(1995 - 1900, Calendar.JANUARY, 10), parc1), 1);
        Client client2 = findOrCreate(allObjects, new Client("Medjbour", 987654321, "Lounes", new Date(1990 - 1900, Calendar.MARCH, 25), parc2), 2);

        // Add objects to their respective collections
        if(!dataFile.exists()){
        parc1.addMarque(BMW);
        parc1.addScooter(Scot1);
        parc1.addClient(client1);

        parc2.addMarque(Yamaha);
        parc1.addScooter(Scot2);
        parc2.addClient(client2);

        parc3.addMarque(Honda);
        parc1.addScooter(Scot3);

        parc4.addMarque(Ducati);
        parc1.addScooter(Scot4);

        BMW.addModels(MP40);
        Yamaha.addModels(XMax);
        Honda.addModels(PCX);
        Ducati.addModels(Monster);

        MP40.addScooter(Scot1);
        XMax.addScooter(Scot2);
        PCX.addScooter(Scot3);
        Monster.addScooter(Scot4);

        permisA.addClient(client1);
        permisB.addClient(client2);

        permisA.addMarque(MP40);
        permisB.addMarque(XMax);
        }

        // Perform operations on objects
        Client user = null;
        Scanner sc = new Scanner(System.in);
        while (user == null) {
            System.out.println("Veuillez entrer votre identifiant :");
            int idUser = sc.nextInt();

            for (Object obj : allObjects) {
                if (obj instanceof Client) {
                    Client client = (Client) obj;
                    if (client.getId() == idUser) {
                        user = client;
                        break; // Exit the for-loop early once found
                    }
                }
            }

            if (user == null) {
                System.out.println("Identifiant non reconnu, veuillez réessayer.");
            }
        }
        while (true) {
            System.out.println("=== MENU PRINCIPAL ===");
            System.out.println("Veuillez sélectionner une option dans le menu ci-dessous :");
            System.out.println("1. Louer un scooter\r\n" + //
                    "2. Retour d'un scooter\r\n" + //
                    "3. État d'un scooter\r\n" + //
                    "4. Affichage de l'état du parc de scooters\r\n" + //
                    "5. Saisie du parc des scooters\r\n" + //
                    "6. Quitter le programme give me a message to wrtie above this");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Veuillez entrer l'identifiant du scooter :");
                    int scooterId = sc.nextInt();
                    user.LouerScooter(scooterId);
                    break;
                case 2:
                    System.out.println("Veuillez entrer l'identifiant du scooter :");
                    int scootId = sc.nextInt();
                    System.out.println("Veuillez entrer le kilometrage effectué :");
                    double km = sc.nextDouble();
                    user.RetournerScooter(scootId, km);
                    break;
                case 3:
                    System.out.println("Veuillez entrer l'identifiant du scooter :");
                    int id = sc.nextInt();
                    user.getParc().EtatScooter(id);
                    break;
                case 4:
                    user.getParc().EtatParc();
                    break;
                case 5:
                    user.getParc().SaisiParc();
                    break;
                case 6:
                    saveAllData(allObjects);
                    sc.close();
                    return;
                default:
                    break;
            }
        }
    }
}

