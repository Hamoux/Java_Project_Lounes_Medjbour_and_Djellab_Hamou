
import java.io.*;
import java.util.*;
public class Modele {
    private int idModele;
    private String modeleNom;
    private String cylinder;
    private float vitesseMax;
    private Marque marque;
    private List<Scooter> scooters = new ArrayList<Scooter>();
    private List<Permis> permisses = new ArrayList<Permis>();

    public Modele(int id, String modelName, String cylinder, float vitesseMax, Marque marque) {
        this.idModele = id;
        this.modeleNom = modelName;
        this.cylinder = cylinder;
        this.vitesseMax = vitesseMax;
        this.marque = marque;
    }

    public int getIdModele() {
        return idModele;
    }

    public void setIdModele(int idModele) {
        this.idModele = idModele;
    }

    public String getModeleNom() {
        return modeleNom;
    }

    public void setModeleNom(String modeleNom) {
        this.modeleNom = modeleNom;
    }

    public String getCylinder() {
        return cylinder;
    }

    public void setCylinder(String cylinder) {
        this.cylinder = cylinder;
    }

    public float getVitesseMax() {
        return vitesseMax;
    }

    public void setVitesseMax(float vitesseMax) {
        this.vitesseMax = vitesseMax;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public List<Scooter> getScooters() {
        return scooters;
    }

    public void setScooters(List<Scooter> scooters) {
        this.scooters = scooters;
    }

    public List<Permis> getPermises() {
        return permisses;
    }
    public void setPermises(List<Permis> permises) {
        this.permisses = permises;
    }

    public void addScooter(Scooter scooter) {
        if (scooter != null) {
            scooters.add(scooter);
        } else {
            System.out.println("Le scooter que tu as ajouté est null");
        }
    }

    public void addPermis(Permis permis) {
        if (permis != null) {
            permisses.add(permis);
        } else {
            System.out.println("Le permis que tu as ajouté est null");
        }
    }
}
