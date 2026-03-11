package model;
import java.util.ArrayList;

public class client {
    protected String nom;
    protected String prenom;
    protected int genre;
    protected String dateN;
    protected String categ;
    protected String adresse;
    protected String tel;
    protected String email;
    protected ArrayList<compteBancaire> liste_comptes;

    public client(String nom, String prenom, int genre, String dateN, String categ, String adresse, String tel,
            String email, ArrayList<compteBancaire> liste_comptes) {
        this.nom = nom;
        this.prenom = prenom;
        this.genre = genre;
        this.dateN = dateN;
        this.categ = categ;
        this.adresse = adresse;
        this.tel = tel;
        this.email = email;
        this.liste_comptes = liste_comptes;
    }

    public void infos_comptes() {
        String var;
        if (genre == 1) {
            var = "M. ";
        } else {
            var = "Mme ";
        }
        System.out.println("Liste des comptes de " + var + nom + " " + prenom + " :");
        for (int i = 0; i != liste_comptes.size(); i++) {
            liste_comptes.get(i).Decrire();
        }
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public int getGenre() {
        return genre;
    }
    public void setGenre(int genre) {
        this.genre = genre;
    }
    public String getDateN() {
        return dateN;
    }
    public void setDateN(String dateN) {
        this.dateN = dateN;
    }
    public String getCateg() {
        return categ;
    }
    public void setCateg(String categ) {
        this.categ = categ;
    }
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public ArrayList<compteBancaire> getListe_comptes() {
        return liste_comptes;
    }
    public void setListe_comptes(ArrayList<compteBancaire> liste_comptes) {
        this.liste_comptes = liste_comptes;
    }
}