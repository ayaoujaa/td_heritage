package model;
public class epargne extends compteBancaire {
    protected float interet;

    public epargne(long numero, float solde, String devise, client titulaire, float interet) {
        super(numero, solde, devise, titulaire);
        this.interet = interet;
    }

    @Override
    public void debiter(float montant) {
        if (montant <= solde / 2) {
            solde = solde - montant;
        } else {
            System.out.println("Opération refusée : impossible de retirer plus de la moitié du solde");
        }
    }

    @Override
    public void Decrire() {
        System.out.println("Compte Epargne N° : " + numero + " - solde : " + solde + " " + devise + " - taux : " + interet * 100 + "%");
    }
    
    public void ajouter_interet() {
        if (solde > 0) {
            solde = solde + (solde * interet);
        } else {
            System.out.println("Solde négatif, l'opération est impossible.");
        }
    }
    
    public float getInteret() {
        return interet;
    }

    public void setInteret(float interet) {
        this.interet = interet;
    }
}