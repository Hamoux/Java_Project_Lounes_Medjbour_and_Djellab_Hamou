import java.io.*;
import java.util.*;
import java.io.Serializable;
public class Client implements Serializable {
    private static int inc = 1;
    private int id;
    private String nom;
    private int tel;
    private String prenom;
    private Date date_naissance;

    private List<Location> locations = new ArrayList<Location>();
    private List<Permis> permisses = new ArrayList<Permis>();
    private Parc_Scooter parc;

    public Client(String nom, int tel, String prenom, Date date_naissance, Parc_Scooter parc) {
        this.id = inc++;
        this.nom = nom;
        this.tel = tel;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.parc = parc;
    }

    public void addLocations(Location location){
        if (location == null) {
            System.err.println("La location que vous avez ajouté est null !");
        }
        
        locations.add(location);}



        public void addPermisses(Permis permis){
            if (permis == null) {
                System.err.println("Le permis que vous avez ajouté est null !");
            }
            
            permisses.add(permis);}


    public int getId() { return this.id; }
    public String getNom() { return this.nom; }
    public int getTel() { return this.tel; }
    public String getPrenom() { return this.prenom; }
    public Date getDate_naissance() { return this.date_naissance; }
    public Parc_Scooter getParc() { return this.parc; }



    public void setId(int id) { this.id = id; }
    public void setNom(String nom) { this.nom = nom; }
    public void setTel(int tel) { this.tel = tel; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public void setDate_naissance(Date date_naissance) { this.date_naissance = date_naissance; }
    public void setParc(Parc_Scooter parc) {  this.parc=parc; }

    public void printData() {
        System.out.println("Client [id: " + id + ", nom: " + nom + ", prenom: " + prenom + ", tel: " + tel + ", date_naissance: " + date_naissance + "]");
        System.out.print("Permisses: ");
        for (int i = 0; i < permisses.size(); i++) {
            System.out.print(permisses.get(i).getType_permis());
            if (i < permisses.size() - 1) System.out.print(", ");
        }
        System.out.println();
        System.out.print("Locations: ");
        for (int i = 0; i < locations.size(); i++) {
            System.out.print(locations.get(i).getId());
            if (i < locations.size() - 1) System.out.print(", ");
        }
        System.out.println();
    }
    public void LouerScooter(int idScoot){
        if (!parc.ScooterExist(idScoot)) {
            System.err.println("Le scooter n'existe pas!");
            return;
        }
    
        for (Scooter scooter : parc.getScooters()) {
            if (scooter.getId() == idScoot) {
                if (!scooter.isAvailable()) {
                    System.out.println("Le scooter est déjà en location.");
                } else {
                    Location location2 = new Location(
                        new Date(),
                        scooter,
                        this
                    );
                    this.addLocations(location2);
                    scooter.addLocations(location2);
                    System.out.println("La location est effectuée avec succès.");
                }
                return;
            }
        }
    }
    public void RetournerScooter(int idScoot, double kilometrage){
        if (!parc.ScooterExist(idScoot)) {
            System.err.println("Le scooter n'existe pas!");
            return;
        }
    
        for (Scooter scooter : parc.getScooters()) {
            if (scooter.getId() == idScoot) {
                if (scooter.isAvailable()) {
                    System.out.println("Le scooter n'etait pas en location.");
                } else {
                    Date date_de_fin = new Date();
                    scooter.getLocations().get(scooter.getLocations().size() - 1).setDate_fin(date_de_fin);
                    scooter.getLocations().get(scooter.getLocations().size() - 1).setKilometrage(kilometrage);
                    this.locations.get(this.locations.size() - 1).setDate_fin(date_de_fin);
                    this.locations.get(this.locations.size() - 1).setKilometrage(kilometrage);
                    System.out.println("Le retour est effectué avec succès.");
                    System.out.println("Le scooter est maintenant disponible pour la location.");
                }
                return;
            }
        }
    }
}

