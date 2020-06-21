package models;

/**
 * Represents a hotel in the hotel chain
 *
 * @author Tuyen Dang
 *
 */
public class Hotel {
    private int idHotel; // ID de l'Hotel
    private String nomHotel; //Nom de l'hotel
    private String adrHotel; //Adresse de l'Hotel
    private int cpHotel; // Code postal de l'hotel
    private String telHotel; //Numéro de téléphone de l'hotel
    private int nbetoile; // Classe de l'hotel selon le nombre l'étoile

    public Hotel() {
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    public String getNomHotel() {
        return nomHotel;
    }

    public void setNomHotel(String nomHotel) {
        this.nomHotel = nomHotel;
    }

    public String getAdrHotel() {
        return adrHotel;
    }

    public void setAdrHotel(String adrHotel) {
        this.adrHotel = adrHotel;
    }

    public int getCpHotel() {
        return cpHotel;
    }

    public void setCpHotel(int cpHotel) {
        this.cpHotel = cpHotel;
    }

    public String getTelHotel() {
        return telHotel;
    }

    public void setTelHotel(String telHotel) {
        this.telHotel = telHotel;
    }


    public int getNbetoile() {
        return nbetoile;
    }

    public void setNbetoile(int nbetoile) {
        this.nbetoile = nbetoile;
    }
}
