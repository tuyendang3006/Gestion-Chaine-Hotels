package models;

/**
 * Represents a room in a hotel
 * Required fields: idHotel and number
 *
 * @author Tuyen Dang
 *
 */
public class Chambre {
    private int idChambre; // ID/numéro de chambre
    private String telChambre; // numéro de téléphone de chambre
    private String etatChambre; // état de chambre
    private int idHotel; // ID de l'hotel possède cette chambre
    private int idCategorie; // ID de categorie de chambre

    public Chambre() {
    }
    public Chambre(int idChambre){
        this.idChambre = idChambre;
    }

    public Chambre(int idChambre, int idHotel){
        this.idChambre = idChambre;
        this.idChambre = idHotel;
    }

    public int getIdChambre() {
        return idChambre;
    }

    public void setIdChambre(int idChambre) {
        this.idChambre = idChambre;
    }

    public String getTelChambre() {
        return telChambre;
    }

    public void setTelChambre(String telChambre) {
        this.telChambre = telChambre;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getEtatChambre() {
        return etatChambre;
    }

    public void setEtatChambre(String etatChambre) {
        this.etatChambre = etatChambre;
    }

    public String toString() {
        return "Chambre{ "
                + "ID Chambre: " + idChambre
                + ", Tél Chambre: " + telChambre
                + ", Etat Chambre: " + etatChambre
                + ", ID Hotel: " + idHotel
                +", ID Catégorie: " + idCategorie +" }";
    }
}
