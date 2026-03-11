package controller;
import java.util.ArrayList;

import model.client;
import model.compteBancaire;
import model.compteCourant;
import model.epargne;

public class main {

    public static void main(String[] args) {

        ArrayList<compteBancaire> liste_comptes = new ArrayList<>();

        client Gravouil_Benjamin = new client("Gravouil", "Benjamin", 1, "01/01/1976", "Afrique", "Adresse inconnue", "01 02 03 04 05", "prof.gravouil@gmail.com", liste_comptes);
        
        compteCourant Gravouil_1 = new compteCourant(13245411324L, 2548200, "euros", Gravouil_Benjamin, "1234-5678-9012-3456", 1000);
        epargne Gravouil_2 = new epargne(32544771289L, 1000, "euros", Gravouil_Benjamin, 0.05f);
        compteCourant Gravouil_3 = new compteCourant(22544771289L, -214, "euros", Gravouil_Benjamin, "6543-2109-8765-4321", 1000);
        
        liste_comptes.add(Gravouil_1);
        liste_comptes.add(Gravouil_2);
        liste_comptes.add(Gravouil_3);
        
        Gravouil_Benjamin.infos_comptes();
        System.out.println();
        
        Gravouil_2.ajouter_interet();
        
        System.out.println("Après ajout des intérêts :");
        Gravouil_Benjamin.infos_comptes();
        
        System.out.println("Test des restrictions :");
        Gravouil_1.debiter(2549200);
        Gravouil_2.debiter(600);
    }
}