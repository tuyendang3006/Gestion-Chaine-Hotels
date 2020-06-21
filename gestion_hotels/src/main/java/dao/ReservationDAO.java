package dao;

import models.Reservation;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ReservationDAO {
    private static String username;
    private static String url;
    private static String password;

    public ReservationDAO(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    // Prendre l'information d'une réservation par ID réservation
    public static Reservation getReservationById(int id){
        try {
            Connection conn = DriverManager.getConnection(url,username,password);
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM reservations WHERE idreservations=?");
            ps.setInt(1,id);

            ResultSet resultSet = ps.executeQuery();

            Reservation reservation = new Reservation();

            while (resultSet.next()){
                showReservationInfo(resultSet);
            }
            return reservation;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ne pas trouver !");
            return null;
        }
    }

    // Ajouter d'une reservation qui est validée
    public void addReservation() throws SQLException {

        Scanner sc = new Scanner(System.in);

        try(
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement ps = conn.prepareStatement("INSERT INTO reservations(idreservations, dateDebut, dateFin, datePayeArrhes, montantArrhes, idclients, idchambres)"
                    + " VALUES(?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
        ){

            // Entrer les informations de client
            System.out.print("Entrer ID réservation: ");
            int idRe = sc.nextInt();
            ps.setInt(1,idRe);

            System.out.print("Entrer la date d'arrivée: ");
            String dateD = sc.next();
            Date dateFormatD = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").parse(dateD);
            ps.setDate(2, new java.sql.Date(dateFormatD.getTime()));

            System.out.print("Entrer la date de départ: ");
            String dateF = sc.next();
            Date dateFormatF = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").parse(dateF);
            ps.setDate(3, new java.sql.Date(dateFormatF.getTime()));

            System.out.print("Entrer la date de paye d'arrhes: ");
            String datePA = sc.next();
            Date dateFormatPA = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").parse(datePA);
            ps.setDate(4, new java.sql.Date(dateFormatPA.getTime()));

            System.out.print("Entrer la montant du paye d'arrhes: ");
            int montant = sc.nextInt();
            ps.setInt(5,montant);

            System.out.print("Entrer ID client: ");
            int idClient = sc.nextInt();
            ps.setInt(6,idClient);

            System.out.print("Entrer ID chambre: ");
            int idChambre = sc.nextInt();
            ps.setInt(7,idChambre);

            ps.executeUpdate();

            PreparedStatement ps2 = conn.prepareStatement("UPDATE chambres SET etatchambre='Confirmée' WHERE idchambres=?");
            ps2.setInt(1, idChambre);
            ps2.executeUpdate();

            // Get generated key
            try (ResultSet rs = ps.getGeneratedKeys();) {
                if (rs.next()) {
                    idRe = rs.getInt(1);
                }
                System.out.println("Ajouter succèss ID: " + idRe);
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
            throw new SQLException("Entrée invalidé !");
        }
        System.out.println("-----------------------------------------------");
    }

    // Supprimer d'une réservation
    public void deleteReservation(){
        Scanner sc = new Scanner(System.in);
        int id=0;
        try (
                Connection conn = DriverManager.getConnection(url, username, password);
                PreparedStatement ps = conn.prepareStatement("DELETE FROM reservations WHERE idreservations=?", Statement.RETURN_GENERATED_KEYS);
        ) {

            System.out.print("Entrer ID reservation: ");
            id = sc.nextInt();
            ps.setInt(1,id);
            getReservationById(id);

            ps.executeUpdate();

            System.out.print("Déjà supprimé. \nEntrer le ID de cette chambre pour mettre à jour l'état: ");
            int idChambre = sc.nextInt();
            PreparedStatement ps2 = conn.prepareStatement("UPDATE chambres SET etatchambre='En_vente' WHERE idchambres = ?", Statement.RETURN_GENERATED_KEYS);
            ps2.setInt(1, idChambre);
            ps2.executeUpdate();

            // Get generated key
            try (ResultSet rs = ps.getGeneratedKeys();) {
                int idValue = 0;
                if (rs.next()) {
                    idValue = rs.getInt(1);
                }
                System.out.println("Supprimer succèss ! ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (java.util.InputMismatchException e)
        {
            sc.nextInt();
        }
        System.out.println("-----------------------------------------------");
    }

    // Enregistrer et Afficher toutes les réservations
    public void loadReservations(){
        try {
            Connection conn = DriverManager.getConnection(url,username,password);
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM reservations");

            ResultSet resultSet = ps.executeQuery();

            ArrayList<Reservation> listeReservations = new ArrayList<>();

            while (resultSet.next()){
                Reservation reservation = new Reservation();
                reservation.setIdReservation(resultSet.getInt(1));
                reservation.setDateDebut(resultSet.getDate(2));
                reservation.setDateFin(resultSet.getDate(3));
                reservation.setDatePayeArrhes(resultSet.getDate(4));
                reservation.setMontantArrhes(resultSet.getInt(5));
                reservation.setIdClient(resultSet.getInt(6));
                reservation.setIdChambre(resultSet.getInt(7));
                listeReservations.add(reservation);
            }
            for (Reservation reservation: listeReservations){
                System.out.print("[ ID: " + reservation.getIdReservation()+"| ");
                System.out.print("Début: "+ reservation.getDateDebut() +"| ");
                System.out.print("Fin: " + reservation.getDateFin() +"| ");
                System.out.print("Date d'Arrhes: "+ reservation.getDatePayeArrhes() +"| ");
                System.out.print("Montant d'Arrhes: "+ reservation.getMontantArrhes() +"| ");
                System.out.print("ID client: "+ reservation.getIdClient() + " |");
                System.out.print("ID chambre: " + reservation.getIdChambre());
                System.out.println( " ]");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("-----------------------------------------------");
    }

    // Afficher la date d'arrivée d'une client
    public void dateCheckIn(){
        Scanner sc = new Scanner(System.in);
        int idClient = 0;
        try {
            Connection conn = DriverManager.getConnection(url,username,password);
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM reservations WHERE idclients=?", Statement.RETURN_GENERATED_KEYS);

            System.out.print("Entrer le ID client: ");
            idClient = sc.nextInt();
            ps.setInt(1,idClient);

            ResultSet resultSet = ps.executeQuery();

            ArrayList<Reservation> listeReservations = new ArrayList<>();

            while (resultSet.next()){
                Reservation reservation = new Reservation();
                reservation.setIdReservation(resultSet.getInt(1));
                reservation.setDateDebut(resultSet.getDate(2));
                reservation.setDateFin(resultSet.getDate(3));
                reservation.setDatePayeArrhes(resultSet.getDate(4));
                reservation.setMontantArrhes(resultSet.getInt(5));
                reservation.setIdClient(resultSet.getInt(6));
                reservation.setIdChambre(resultSet.getInt(7));
                listeReservations.add(reservation);
            }
            if(listeReservations.size() < 1){
                System.out.println("Ne pas trouver ID client: " + idClient);
            }
            for (Reservation reservation: listeReservations){
                System.out.print("[ ID client: "+ reservation.getIdClient() + " |");
                System.out.print("Date d'arrivée: "+ reservation.getDateDebut() );
                System.out.println( " ]");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }catch (java.util.InputMismatchException e)
        {
            sc.nextInt();
        }
        System.out.println("-----------------------------------------------");
    }

    // Afficher l'histoire d'un client de ses passages dans la chaîne d'hôtels
    public void passReservations(){
        Scanner sc = new Scanner(System.in);
        try {
            Connection conn = DriverManager.getConnection(url,username,password);
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM reservations WHERE idclients=? AND dateDebut<=?", Statement.RETURN_GENERATED_KEYS);

            System.out.print("Entrer le ID client: ");
            int idClient = sc.nextInt();
            ps.setInt(1,idClient);
            ps.setDate(2,new java.sql.Date(System.currentTimeMillis())); // Prendre le temps actuel

            ResultSet resultSet = ps.executeQuery();

            ArrayList<Reservation> listeReservations = new ArrayList<>();

            while (resultSet.next()){
                Reservation reservation = new Reservation();
                reservation.setIdReservation(resultSet.getInt(1));
                reservation.setDateDebut(resultSet.getDate(2));
                reservation.setDateFin(resultSet.getDate(3));
                reservation.setDatePayeArrhes(resultSet.getDate(4));
                reservation.setMontantArrhes(resultSet.getInt(5));
                reservation.setIdClient(resultSet.getInt(6));
                reservation.setIdChambre(resultSet.getInt(7));
                listeReservations.add(reservation);
            }
            if(listeReservations.size() < 1){
                System.out.println("Ne pas trouver !");
            }

            System.out.println("Liste de passages d'un client à la chaine hotelièle:");
            for (Reservation reservation: listeReservations){
                System.out.print("[ID : " + reservation.getIdReservation()+"| ");
                System.out.print("Début: "+ reservation.getDateDebut() +"| ");
                System.out.print("Fin: " + reservation.getDateFin() +"| ");
                System.out.print("Date d'Arrhes: "+ reservation.getDatePayeArrhes() +"| ");
                System.out.print("Montant d'Arrhes: "+ reservation.getMontantArrhes() +"| ");
                System.out.print("ID client: "+ reservation.getIdClient() + " |");
                System.out.print("ID chambre: " + reservation.getIdChambre());
                System.out.println( " ]");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }catch (java.util.InputMismatchException e)
        {
            sc.nextInt();
        }
        System.out.println("-----------------------------------------------");
    }

    // Liste de clients présentent d'un hotel actuellement
    public void presentDayHotel(){
        Scanner sc = new Scanner(System.in);
        try {
            Connection conn = DriverManager.getConnection(url,username,password);
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM reservations WHERE dateDebut<=? AND dateFin>=? ", Statement.RETURN_GENERATED_KEYS);
            ps.setDate(1,new java.sql.Date(System.currentTimeMillis()));
            ps.setDate(2,new java.sql.Date(System.currentTimeMillis()));

            ResultSet resultSet = ps.executeQuery();

            ArrayList<Reservation> listeReservations = new ArrayList<>();

            while (resultSet.next()){
                Reservation reservation = new Reservation();
                reservation.setIdReservation(resultSet.getInt(1));
                reservation.setDateDebut(resultSet.getDate(2));
                reservation.setDateFin(resultSet.getDate(3));
                reservation.setDatePayeArrhes(resultSet.getDate(4));
                reservation.setMontantArrhes(resultSet.getInt(5));
                reservation.setIdClient(resultSet.getInt(6));
                reservation.setIdChambre(resultSet.getInt(7));
                listeReservations.add(reservation);
            }
            if(listeReservations.size() < 1){
                System.out.println("Ne pas trouver !");
            }

            //System.out.println("Entrer le ID hotel: " );
            //int idHotel = sc.nextInt();

            for (Reservation reservation: listeReservations){
                int idclient = reservation.getIdClient();
                System.out.println("ID client: " + reservation.getIdClient());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }catch (java.util.InputMismatchException e)
        {
            sc.nextInt();
        }
        System.out.println("-----------------------------------------------");
    }

    // Compter le nombre de client est départi ( prendre la facture et quitter) dans un jour
    public void numberCheckout(){
        Scanner sc = new Scanner(System.in);
        try {
            Connection conn = DriverManager.getConnection(url,username,password);
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM reservations WHERE dateFin=?", Statement.RETURN_GENERATED_KEYS);

            System.out.print("Entrer la date pour vérifier: ");
            String date = sc.next();
            Date dateFormat = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            ps.setDate(1, new java.sql.Date(dateFormat.getTime()));

            ResultSet resultSet = ps.executeQuery();

            ArrayList<Reservation> listeReservations = new ArrayList<>();

            while (resultSet.next()){
                Reservation reservation = new Reservation();
                reservation.setIdReservation(resultSet.getInt(1));
                reservation.setDateDebut(resultSet.getDate(2));
                reservation.setDateFin(resultSet.getDate(3));
                reservation.setDatePayeArrhes(resultSet.getDate(4));
                reservation.setMontantArrhes(resultSet.getInt(5));
                reservation.setIdClient(resultSet.getInt(6));
                reservation.setIdChambre(resultSet.getInt(7));
                listeReservations.add(reservation);
            }
            for (Reservation reservation: listeReservations){
                System.out.print("[ ID: " + reservation.getIdReservation()+"| ");
                System.out.print("Début: "+ reservation.getDateDebut() +"| ");
                System.out.print("Fin: " + reservation.getDateFin() +"| ");
                System.out.print("Date d'Arrhes: "+ reservation.getDatePayeArrhes() +"| ");
                System.out.print("Montant d'Arrhes: "+ reservation.getMontantArrhes() +"| ");
                System.out.print("ID client: "+ reservation.getIdClient() + " |");
                System.out.print("ID chambre: " + reservation.getIdChambre());
                System.out.println( " ]");
            }

            System.out.println("-----------------------------------------------");
            System.out.println("[ Il y a: " + listeReservations.size()+" clients départ. ");

        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
        System.out.println("-----------------------------------------------");
    }

    private static void showReservationInfo(ResultSet rs) throws SQLException {
        System.out.println("Id réservation: " + rs.getInt(1));
        System.out.println("Date d'arrivée: " + rs.getDate(2));
        System.out.println("Date de départ: " + rs.getDate(3));
        System.out.println(("Date de paye d'arrhes: ") + rs.getDate(4));
        System.out.println("Montant de paye d'arrhes: " + rs.getInt(5));
        System.out.println("Id Client: " + rs.getInt(6));
        System.out.println("Id Chambre: " + rs.getInt(7));
    }

}
