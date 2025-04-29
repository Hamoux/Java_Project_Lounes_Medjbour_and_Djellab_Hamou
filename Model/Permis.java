import java.io.*;
import java.util.*;

public class Permis {

    private static int inc = 1;
    private int id_permis;
    private String type_permis;
    private List<Client> clients = new ArrayList<Client>();
    private List<Modele> modeles = new ArrayList<Modele>();

    public Permis(String type) {
        this.id_permis = inc++;
        this.type_permis = type;
    }

    public int getId_permis() {
        return id_permis;
    }

    public void setId_permis(int id_permis) {
        this.id_permis = id_permis;
    }

    public String getType_permis() {
        return type_permis;
    }

    public void setType_permis(String type_permis) {
        this.type_permis = type_permis;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Modele> getModeles() {
        return modeles;
    }

    public void setModeles(List<Modele> modeles) {
        this.modeles = modeles;
    }

    public void addMarque(Modele modele) {
        if (modele != null) {
            modeles.add(modele);
        } else {
            System.err.println("Le modele que tu as ajoutée est null");
        }
    }

    public void addClient(Client client) {
        if (client != null) {
            clients.add(client);
        } else {
            System.err.println("Le client que tu as ajouté est null");
        }

    }
    public void printData() {
        System.out.println("Permis [id: " + id_permis + ", type: " + type_permis + "]");
    
        System.out.print("Clients: ");
        for (int i = 0; i < clients.size(); i++) {
            System.out.print(clients.get(i).getNom() + " " + clients.get(i).getPrenom());
            if (i < clients.size() - 1) System.out.print(", ");
        }
        System.out.println();
    
        System.out.print("Modèles: ");
        for (int i = 0; i < modeles.size(); i++) {
            System.out.print(modeles.get(i).getModeleNom());
            if (i < modeles.size() - 1) System.out.print(", ");
        }
        System.out.println();
    }
    
    
    
}
