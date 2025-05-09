import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.io.Serializable;
public class Parc_Scooter implements Serializable {

    private static int inc = 1;
    private int idPark;
    private String nom;
    private int capacite;
    private List<Scooter> scooters = new ArrayList<Scooter>();
    private List<Marque> marques = new ArrayList<Marque>();
    private List<Client> clients = new ArrayList<Client>();

    public Parc_Scooter(String nom, int capacite) {
        this.idPark = inc++;
        this.nom = nom;
        this.capacite = capacite;
    }

    public int getId() {
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
            System.err.println("Le scooter que tu as ajouté est null");
        }
    }

    public void addMarque(Marque marque) {
        if (marque != null) {
            marques.add(marque);
        } else {
            System.err.println("La marque que tu as ajoutée est null");
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
        System.out.println("Parc_Scooter [id: " + idPark + ", nom: " + nom + ", capacite: " + capacite + "]");
        System.out.print("Marques: ");
        for (int i = 0; i < marques.size(); i++) {
            System.out.print(marques.get(i).getNomMark());
            if (i < marques.size() - 1) System.out.print(", ");
        }
        System.out.println();
        System.out.print("Scooters: ");
        for (int i = 0; i < scooters.size(); i++) {
            System.out.print(scooters.get(i).getId());
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
            if(scooter.getId() == idScoot)
                return true;
        }
        return false;
    }

    public void EtatScooter(int idScoot){
        if (!ScooterExist(idScoot)) {
            System.err.println("Le scooter n'existe pas!");
            return;
        }

    
        for (Scooter scooter : scooters) {
            if (scooter.getId() == idScoot) {
                System.out.println("Modele : "+scooter.getModele().getModeleNom());
                System.out.println(" Numero Identificaiton : "+ scooter.getId());
                System.out.println(" Kilometrage : "+scooter.getKilometrage() + "km");
                if (!scooter.isAvailable()) {
                    System.out.println("Etat de disponibilité : Non disponible");
                 }
                    
                else{
                        System.out.println("Etat de disponibilité : Disponible");
                }
                return;
           
            }
        }
    }
    public void EtatParc(){
        for( Scooter scooter : scooters){
            System.out.println("Id du scooter: "+scooter.getId()+" Modele: "+scooter.getModele().getModeleNom()+" kilometrage: "+scooter.getKilometrage()+"km"+ " Etat de disponibilite: "+scooter.isAvailable());
        }
    }


    public void SaisiParc(){
        int NbrScoots=0;
        int NbrScootsinLoc=0;
        int NbrScootsinDisp=0;
        float KilMoyen=0;
        for(Scooter scooter : scooters){
            NbrScoots++;
        }
         System.err.println("Le nombre totale de Scooters: "+NbrScoots);

        for(Scooter scooter : scooters){
            if(!scooter.isAvailable()){
                NbrScootsinLoc++;
                System.out.println("Identifiant du Scooter: "+scooter.getId());
            }
        }
        System.out.println("Le nombre totale de scooter en location: "+NbrScootsinLoc);

        for(Scooter scooter : scooters){
            if(scooter.isAvailable()){
                System.out.println("Identifiant du Scooter: "+scooter.getId());
            }
            KilMoyen+=scooter.getKilometrage();
        }
        NbrScootsinDisp = NbrScoots - NbrScootsinLoc;
        System.out.println("Le nombre totale de scooter disponible pour la location: "+NbrScootsinDisp);

        if (NbrScoots > 0) {
            KilMoyen /= NbrScoots;
            System.out.println("Le kilométrage moyen des scooters de ce parc est : " + KilMoyen + "km");
        } else {
            System.out.println("Aucun scooter dans ce parc pour calculer le kilometrage.");
        }

    }
}