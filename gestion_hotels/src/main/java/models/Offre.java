package models;

public class Offre {
    private int idPrestation;
    private int idHotel;
    private int prixPrestation;

    public Offre(int idPrestation, int idHotel){
        this.idPrestation = idPrestation;
        this.idHotel = idHotel;
    }

    public Offre(){}

    public int getIdPrestation() {
        return idPrestation;
    }

    public void setIdPrestation(int idPrestation) {
        this.idPrestation = idPrestation;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    public int getPrixPrestation() {
        return prixPrestation;
    }

    public void setPrixPrestation(int prixPrestation) {
        this.prixPrestation = prixPrestation;
    }
}
