import java.io.*;
import java.util.*;

public class Scooter {

    private int idScoot;
    private boolean disponibilite;
    private Modele modele;
    private Parc_Scooter parc;

    private List<Location> locations = new ArrayList<Location>();
    
    public Scooter(int idScoot, boolean disponibilite, Modele modele, Parc_Scooter parc) {
        this.disponibilite = disponibilite;
        this.idScoot = idScoot;
        this.modele = modele;
        this.parc = parc;
    }

    public void addLocations(Location location){
        if (location == null) {
            System.out.println("La location que vous avez ajouté est null !");
        }
        
        locations.add(location);}


    public int getIdScoot() { return this.idScoot; }
    public boolean isDisponibilite() { return this.disponibilite; } 
    public Parc_Scooter getParc(){return this.parc;} 
    public Modele getModele(){return this.modele;}

    
    public void setIdScoot(int idScoot) { this.idScoot = idScoot; }
    public void setDisponibilite(boolean disponibilite) { this.disponibilite = disponibilite; }
    public void setModele(Modele modele){this.modele = modele;}
    public void setParc(Parc_Scooter parc){this.parc = parc;}
}
