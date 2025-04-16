import java.io.*;
import java.util.*;

public class Scooter {

    private int idScoot;
 
    private Modele modele;
    private Parc_Scooter parc;

    private List<Location> locations = new ArrayList<Location>();
    
    public Scooter(int idScoot, Modele modele, Parc_Scooter parc) {
        this.idScoot = idScoot;
        this.modele = modele;
        this.parc = parc;
    }

    public void addLocations(Location location){
        if (location == null) {
            System.out.println("La location que vous avez ajouté est null !");
        }
        else{
            locations.add(location);
        }
        }
        


    public int getIdScoot() { return this.idScoot; }
    public Parc_Scooter getParc(){return this.parc;} 
    public Modele getModele(){return this.modele;}

    
    public void setIdScoot(int idScoot) { this.idScoot = idScoot; }
    public void setModele(Modele modele){this.modele = modele;}
    public void setParc(Parc_Scooter parc){this.parc = parc;}
    public void printData() {
        System.out.println("Scooter [id: " + idScoot + ", Parc: " + parc.getNom() +", modele: " + modele.getModeleNom() + "]");
        System.out.print("Locations: ");
        for (int i = 0; i < locations.size(); i++) {
            System.out.print(locations.get(i).getIdLoc());
            if (i < locations.size() - 1) System.out.print(", ");
        }
        System.out.println(); 
    }
    public boolean isAvailable() {
        Date currentDate = new Date(); //la date actuelle
        for (Location location : locations) {
            if (location.getDate_debut().compareTo(currentDate) <= 0 &&
                location.getDate_fin().compareTo(currentDate) >= 0) {
                return false;
            }
        }
        return true;
    }
    
}
