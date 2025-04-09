import java.io.*;
import java.util.*;



public class Main {

    public static void main(String[] args) {

        // Création des marques, modèles, parcs et scooters
        Marque BMW = new Marque(0, "BMW");
        Modele MP40 = new Modele(1, "MP40", "v_twin", 150, BMW);
        BMW.addModels(MP40);
        Parc_Scooter parc1 = new Parc_Scooter(0, "Louvre", 200);
        parc1.addMarque(BMW);
        Scooter Scot1 = new Scooter(0, true, MP40, parc1);
        parc1.addScooter(Scot1);
        MP40.addScooter(Scot1);

        Marque Yamaha = new Marque(1, "Yamaha");
        Modele XMax = new Modele(2, "XMax", "parallel_twin", 180, Yamaha);
        Yamaha.addModels(XMax);
        Parc_Scooter parc2 = new Parc_Scooter(1, "Montparnasse", 150);
        parc2.addMarque(Yamaha);
        Scooter Scot2 = new Scooter(1, true, XMax, parc2);
        parc2.addScooter(Scot2);
        XMax.addScooter(Scot2);

        Marque Honda = new Marque(2, "Honda");
        Modele PCX = new Modele(3, "PCX", "single", 125, Honda);
        Honda.addModels(PCX);
        Parc_Scooter parc3 = new Parc_Scooter(2, "Châtelet", 100);
        parc3.addMarque(Honda);
        Scooter Scot3 = new Scooter(2, false, PCX, parc3);
        parc3.addScooter(Scot3);
        PCX.addScooter(Scot3);

        Marque Ducati = new Marque(3, "Ducati");
        Modele Monster = new Modele(4, "Monster", "v_twin", 200, Ducati);
        Ducati.addModels(Monster);
        Parc_Scooter parc4 = new Parc_Scooter(3, "La Défense", 250);
        parc4.addMarque(Ducati);
        Scooter Scot4 = new Scooter(3, true, Monster, parc4);
        parc4.addScooter(Scot4);
        Monster.addScooter(Scot4);

        // Création des permis
        Permis permisA = new Permis(0, "A");
        Permis permisB = new Permis(1, "B");

        // Création des clients et ajout manuel des permis
        Client client1 = new Client(0, "Djellab", 123456789, "Hamou", new Date(1995 - 1900, Calendar.JANUARY, 10), parc1);
        client1.addPermisses(permisA);
        parc1.addClient(client1);

        Client client2 = new Client(1, "Medjbour", 987654321, "Lounes", new Date(1990 - 1900, Calendar.MARCH, 25), parc2);
        client2.addPermisses(permisB);
        parc2.addClient(client2);

        Location location1 = new Location(
            1,
            new Date(2025 - 1900, Calendar.APRIL, 1),
            new Date(2025 - 1900, Calendar.APRIL, 5),
            120.5,
            Scot1,
            client1
        );
        client1.addLocations(location1);

        Location location2 = new Location(
            0,
            new Date(2025 - 1900, Calendar.APRIL, 3),
            new Date(2025 - 1900, Calendar.APRIL, 6),
            98.3,
            Scot2,
            client2
        );
        client2.addLocations(location2);
         // Impression des données
         System.out.println("\n--- Marques ---");
         BMW.printData();
         Yamaha.printData();
         Honda.printData();
         Ducati.printData();
 
         System.out.println("\n--- Modèles ---");
         MP40.printData();
         XMax.printData();
         PCX.printData();
         Monster.printData();
 
         System.out.println("\n--- Parcs ---");
         parc1.printData();
         parc2.printData();
         parc3.printData();
         parc4.printData();
 
         System.out.println("\n--- Scooters ---");
         Scot1.printData();
         Scot2.printData();
         Scot3.printData();
         Scot4.printData();
 
         System.out.println("\n--- Permis ---");
         permisA.printData();
         permisB.printData();
 
         System.out.println("\n--- Clients ---");
         client1.printData();
         client2.printData();
 
         System.out.println("\n--- Locations ---");
         location1.printData();
         location2.printData();
    }


}