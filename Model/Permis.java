import java.io.*;
import java.util.*;

public class Permis {

    public int id_permis;
    public String type_permis;
    private List<Client> clients = new ArrayList<Client>();
    private List<Modele> modeles = new ArrayList<Modele>();

    public Permis(int id, String type) {
        this.id_permis = id;
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
            System.out.println("Le modele que tu as ajoutée est null");
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
