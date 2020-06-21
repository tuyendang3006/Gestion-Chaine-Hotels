package models;

import java.util.Date;

/**
 * Represents the consommation of client
 *
 * @author Tuyen Dang
 */
public class Consommation {
    private int idConsommation; // ID de consommation de client
    private Date dateConsommation; // Nombre de date de consommation de client
    private int heureConsommation; // Nombre d'heure de consommation de client
    private int montant; // Montant de cette consommation
    private int idClient; // ID de client charge cette consommation
    private int idPrestation; // ID de prestation de service


    /**
     * Consommation class constructor method
     */
    public Consommation(int idConsommation, Date dateConsommation, int heureConsommation, int montant, int idClient, int idPrestation){
        this.idConsommation = idConsommation;
        this.dateConsommation = dateConsommation;
        this.heureConsommation = heureConsommation;
        this.montant = montant;
        this.idClient = idClient;
        this.idPrestation = idPrestation;
    }

    /**
     * Consommation class constructor method
     */
    public Consommation(int idConsommation, int idClient, int idPrestation){
        this.setIdConsommation(idConsommation);
        this.setIdClient(idClient);
        this.setIdPrestation(idPrestation);
        dateConsommation = null;
        heureConsommation = 0;
        montant = 0;
    }

    /**
     * Null constructor for the Consommation class
     */
    public Consommation(){
        idConsommation = 0;
        idClient = 0;
        idPrestation = 0;
    }

    public int getIdConsommation() {
        return idConsommation;
    }

    public void setIdConsommation(int idConsommation) {
        this.idConsommation = idConsommation;
    }

    public Date getDateConsommation() {
        return dateConsommation;
    }

    public void setDateConsommation(Date dateConsommation) {
        this.dateConsommation = dateConsommation;
    }

    public int getHeureConsommation() {
        return heureConsommation;
    }

    public void setHeureConsommation(int heureConsommation) {
        this.heureConsommation = heureConsommation;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }


    public int getIdPrestation() {
        return idPrestation;
    }

    public void setIdPrestation(int idPrestation) {
        this.idPrestation = idPrestation;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }
}
