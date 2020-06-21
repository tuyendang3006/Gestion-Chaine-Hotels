package models;

import java.util.Date;

/**
 * Represents a Reservation in the system
 * Required fields: customerID, hotelID, room number, and checkIn date
 * @author Tuyen Dang
 */
public class Reservation {
    private int idReservation; // ID d'une réservation
    private Date dateDebut; // Date d'arrivée
    private Date dateFin; // Date de départ
    private Date datePayeArrhes; // Date de paye d'arrhes
    private int montantArrhes; // Montant de paye d'arrhes
    private int idClient; // ID client a réservé
    private int idChambre; // ID Chambre est réservé

    public Reservation(){
    }


    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Date getDatePayeArrhes() {
        return datePayeArrhes;
    }

    public void setDatePayeArrhes(Date datePayeArrhes) {
        this.datePayeArrhes = datePayeArrhes;
    }

    public int getMontantArrhes() {
        return montantArrhes;
    }

    public void setMontantArrhes(int montantArrhes) {
        this.montantArrhes = montantArrhes;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdChambre() {
        return idChambre;
    }

    public void setIdChambre(int idChambre) {
        this.idChambre = idChambre;
    }


}

