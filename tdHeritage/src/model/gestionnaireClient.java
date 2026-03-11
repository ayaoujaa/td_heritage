package model;

import java.util.ArrayList;

public class gestionnaireClient {
    private static ArrayList<client> listeClients = new ArrayList<>();
    
    public static void ajouterClient(client CLIENT) {
        listeClients.add(CLIENT);
    }
    
    public static ArrayList<client> getListeClients() {
        return listeClients;
    }
    
    public static void supprimerClient(client CLIENT) {
        listeClients.remove(CLIENT);
    }
}