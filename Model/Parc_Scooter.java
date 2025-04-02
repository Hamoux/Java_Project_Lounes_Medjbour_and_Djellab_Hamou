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
}