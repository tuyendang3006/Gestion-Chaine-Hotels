package models;

public class Tarifier {
    private int idCategories;
    private int nbetoile;
    private int tarifUnitaire;

    public Tarifier(){}

    public int getIdCategories() {
        return idCategories;
    }

    public void setIdCategories(int idCategories) {
        this.idCategories = idCategories;
    }

    public int getNbetoile() {
        return nbetoile;
    }

    public void setNbetoile(int nbetoile) {
        this.nbetoile = nbetoile;
    }

    public int getTarifUnitaire() {
        return tarifUnitaire;
    }

    public void setTarifUnitaire(int tarifUnitaire) {
        this.tarifUnitaire = tarifUnitaire;
    }
}
