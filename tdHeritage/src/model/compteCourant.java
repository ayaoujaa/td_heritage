package model;
public class compteCourant extends compteBancaire {
    private String numeroCarte;
    private float decouvertMax;

    public compteCourant(long numero, float solde, String devise, client titulaire, String numeroCarte, float decouvertMax) {
        super(numero, solde, devise, titulaire);
        this.numeroCarte = numeroCarte;
        this.decouvertMax = decouvertMax;
    }

    
    public void debiter(float montant) {
        if (solde - montant >= -decouvertMax) {
            solde = solde - montant;
        } else {
            System.out.println("Opération refusée : dépassement du découvert autorisé");
        }
    }

   
    public void Decrire() {
        System.out.println("Compte Courant N° : " + numero + " - solde : " + solde + " " + devise + " - découvert autorisé : " + decouvertMax + " - Carte : " + numeroCarte);
    }

    public String getNumeroCarte() {
        return numeroCarte;
    }

    public void setNumeroCarte(String numeroCarte) {
        this.numeroCarte = numeroCarte;
    }

    public float getDecouvertMax() {
        return decouvertMax;
    }

    public void setDecouvertMax(float decouvertMax) {
        this.decouvertMax = decouvertMax;
    }
}