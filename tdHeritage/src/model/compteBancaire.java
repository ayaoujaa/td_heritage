package model;
public abstract class compteBancaire {
    protected long numero;
    protected float solde;
    protected String devise;
    protected client titulaire;

    public compteBancaire(long numero, float solde, String devise, client titulaire) {
        this.numero = numero;
        this.solde = solde;
        this.devise = devise;
        this.titulaire = titulaire;
    }

    public void debiter(float montant) {
        solde = solde - montant;
    }

    public void crediter(float montant) {
        solde = solde + montant;
    }

    public abstract void Decrire();

    public long getNumero() {
        return numero;
    }
    public void setNumero(long numero) {
        this.numero = numero;
    }
    public float getSolde() {
        return solde;
    }
    public void setSolde(float solde) {
        this.solde = solde;
    }
    public String getDevise() {
        return devise;
    }
    public void setDevise(String devise) {
        this.devise = devise;
    }
    public client getTitulaire() {
        return titulaire;
    }
    public void setTitulaire(client titulaire) {
        this.titulaire = titulaire;
    }
}