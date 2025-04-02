import java.io.*;
import java.util.*;

public class Client {

    private int id;
    private String nom;
    private int tel;
    private String prenom;
    private Date date_naissance;

    private List<Location> locations = new ArrayList<Location>();
    private List<Permis> permisses = new ArrayList<Permis>();
    private Parc_Scooter parc;

    public Client(int id, String nom, int tel, String prenom, Date date_naissance, Parc_Scooter parc) {
        this.id = id;
        this.nom = nom;
        this.tel = tel;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.parc = parc;
    }

    public void addLocations(Location location){
        if (location == null) {
            System.out.println("La location que vous avez ajouté est null !");
        }
        
        locations.add(location);}



        public void addPermisses(Permis permis){
            if (permis == null) {
                System.out.println("Le permis que vous avez ajouté est null !");
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

}
