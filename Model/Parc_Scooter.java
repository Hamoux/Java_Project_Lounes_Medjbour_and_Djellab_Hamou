import java.util.ArrayList;
import java.util.List;

public class Parc_Scooter {

    private int idPark;
    private String nom;
    private int capacite;
    private List<Scooter> scooters = new ArrayList<Scooter>();
    private List<Marque> marques = new ArrayList<Marque>();
    private List<Client> clients = new ArrayList<Client>();

    public Parc_Scooter(int id, String nom, int capacite) {
        this.idPark = id;
        this.nom = nom;
        this.capacite = capacite;
    }

    public int getIdPark() {
        return idPark;
    }

    public void setIdPark(int idPark) {
        this.idPark = idPark;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public List<Scooter> getScooters() {
        return scooters;
    }

    public void setScooters(List<Scooter> scooters) {
        this.scooters = scooters;
    }

    public List<Marque> getMarques() {
        return marques;
    }

    public void setMarques(List<Marque> marques) {
        this.marques = marques;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public void addScooter(Scooter scooter) {
        if (scooter != null) {
            scooters.add(scooter);
        } else {
            System.out.println("Le scooter que tu as ajouté est null");
        }
    }

    public void addMarque(Marque marque) {
        if (marque != null) {
            marques.add(marque);
        } else {
            System.out.println("La marque que tu as ajoutée est null");
        }
    }

    public void addClient(Client client) {
        if (client != null) {
            clients.add(client);
        } else {
            System.out.println("Le client que tu as ajouté est null");
        }
    }
    public void printData() {
        System.out.println("Parc_Scooter [id: " + idPark + ", nom: " + nom + ", capacite: " + capacite + "]");
        System.out.print("Marques: ");
        for (int i = 0; i < marques.size(); i++) {
            System.out.print(marques.get(i).getNomMark());
            if (i < marques.size() - 1) System.out.print(", ");
        }
        System.out.println();
        System.out.print("Scooters: ");
        for (int i = 0; i < scooters.size(); i++) {
            System.out.print(scooters.get(i).getIdScoot());
            if (i < scooters.size() - 1) System.out.print(", ");
        }
        System.out.println();
        System.out.print("Clients: ");
        for (int i = 0; i < clients.size(); i++) {
            System.out.print(clients.get(i).getNom() + " " + clients.get(i).getPrenom());
            if (i < clients.size() - 1) System.out.print(", ");
        }
        System.out.println();
    }
    public boolean ScooterExist(int idScoot){
        for(Scooter scooter : scooters){
            if(scooter.getIdScoot() == idScoot)
                return true;
        }
        return false;
    }
    public void LoueScooter(int idScoot){
        if (!ScooterExist(idScoot)) {
            System.out.println("Le scooter n'existe pas!");
            return;
        }
    
        for (Scooter scooter : scooters) {
            if (scooter.getIdScoot() == idScoot) {
                if (!scooter.isAvailable()) {
                    System.out.println("Le scooter est déjà en location.");
                } else {
                    System.out.println("Le scooter est disponible pour la location.");
                }
                return;
            }
        }
    }
}