
import java.io.*;
import java.util.*;


public class Marque {

    private int idMark;

    private String nomMark;

    private List<Parc_Scooter> parcs_Scooters = new ArrayList<Parc_Scooter>();
    private List<Modele> modeles = new ArrayList<Modele>();


    public Marque(int idMark, String nomMark) {
        this.idMark = idMark;
        this.nomMark = nomMark;
    }


    public void addParc_scooter(Parc_Scooter parc){
        if (parc == null) {
            System.out.println("La parc que vous avez ajouté est null !");
        }
        parcs_Scooters.add(parc);
    }
    
    public void addModels(Modele modele){
        if (modele == null) {
            System.out.println("Le modele que vous avez ajouté est null !");
        }
        modeles.add(modele);}


    public int getIdMark (){ return this.idMark;}
    public String getNomMark (){ return this.nomMark;}

    public void setNomMark(int mark){this.idMark = mark;}
    public void setIdMark(String nomMark){this.nomMark = nomMark;}




}