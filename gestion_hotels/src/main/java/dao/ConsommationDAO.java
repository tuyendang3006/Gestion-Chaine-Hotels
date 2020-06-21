package dao;

import models.Consommation;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class ConsommationDAO {
    private static String url;
    private static String username;
    private static String password;

    public ConsommationDAO(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }


    // Prendre les consommations d'un client
    public void getConsommations() throws SQLException {
        Scanner sc = new Scanner(System.in);
        try {
            Connection conn = DriverManager.getConnection(url,username,password);
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM consommations WHERE idclients=?", Statement.RETURN_GENERATED_KEYS);

            System.out.print("Entrer ID client: ");
            int idClient = sc.nextInt();
            ps.setInt(1,idClient);

            ResultSet resultSet = ps.executeQuery();
            ArrayList<Consommation> listeConsommations = new ArrayList<>();

            while (resultSet.next()){
                Consommation consommation = new Consommation();
                consommation.setIdConsommation(resultSet.getInt(1));
                consommation.setDateConsommation(resultSet.getDate(2));
                consommation.setHeureConsommation(resultSet.getInt(3));
                consommation.setMontant(resultSet.getInt(4));
                consommation.setIdClient(resultSet.getInt(5));
                consommation.setIdPrestation(resultSet.getInt(6));
                listeConsommations.add(consommation);
            }
            if(listeConsommations.size() < 1){
                System.out.println("Ne pas trouver !");
            }
            for (Consommation consommation: listeConsommations){
                System.out.print("[ ID: " + consommation.getIdConsommation()+"| ");
                System.out.print("Date: "+ consommation.getDateConsommation() +"| ");
                System.out.print("Nombre d'heures: " + consommation.getHeureConsommation() +"| ");
                System.out.print("Momtant: "+ consommation.getMontant() +"| ");
                System.out.print("ID client: "+ consommation.getIdClient() +"| ");
                System.out.print("ID prestation: "+ consommation.getIdPrestation() );
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

    // Ajouter d'une facture
    public void addConsommation() throws SQLException {

        Scanner sc = new Scanner(System.in);

        try{
                Connection conn = DriverManager.getConnection(url, username, password);
                PreparedStatement ps = conn.prepareStatement("INSERT INTO consommations(idconsommations, dateConsommation, heureConsommation, montant, idclients, idprestations)"
                        + " VALUES(?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);


            // Entrer les informations de client
            System.out.print("Entrer ID consommations: ");
            int idCons = sc.nextInt();
            ps.setInt(1,idCons);

            System.out.print("Entrer la date: ");
            String date = sc.next();
            java.util.Date dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").parse(date);
            ps.setDate(2, new java.sql.Date(dateFormat.getTime()));

            System.out.print("Entrer le nombre d'heures: ");
            int nbheures = sc.nextInt();
            ps.setInt(3,nbheures);

            System.out.print("Entrer la montant: ");
            int montant = sc.nextInt();
            ps.setInt(4,montant);

            System.out.print("Entrer ID client: ");
            int idClient = sc.nextInt();
            ps.setInt(5,idClient);

            System.out.print("Entrer ID prestation: ");
            int idPrestation = sc.nextInt();
            ps.setInt(6,idPrestation);

            ps.executeUpdate();

            // Get generated key
            try (ResultSet rs = ps.getGeneratedKeys();) {
                if (rs.next()) {
                    idCons = rs.getInt(1);
                }
                System.out.println("Ajouter succèss ID: " + idCons);
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
            throw new SQLException("Entrée invalidé !");
        }
        System.out.println("-----------------------------------------------");
    }

    // Prendre la facture
    public void getFacture(){
        Scanner sc = new Scanner(System.in);
        try {
            Connection conn = DriverManager.getConnection(url,username,password);
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM consommations WHERE idclients=? AND dateConsommation<=?", Statement.RETURN_GENERATED_KEYS);

            System.out.print("Entrer ID client: ");
            int idClient = sc.nextInt();
            ps.setInt(1,idClient);

            ps.setDate(2,new java.sql.Date(System.currentTimeMillis())); // Prendre le temps actuel pour prendre la facture

            ResultSet resultSet = ps.executeQuery();
            ArrayList<Consommation> listeConsommations = new ArrayList<>();

            while (resultSet.next()){
                Consommation consommation = new Consommation();
                consommation.setIdConsommation(resultSet.getInt(1));
                consommation.setDateConsommation(resultSet.getDate(2));
                consommation.setHeureConsommation(resultSet.getInt(3));
                consommation.setMontant(resultSet.getInt(4));
                consommation.setIdClient(resultSet.getInt(5));
                consommation.setIdPrestation(resultSet.getInt(6));
                listeConsommations.add(consommation);
            }
            if(listeConsommations.size() < 1){
                System.out.println("Ne pas trouver !");
            }
            System.out.println("-----------------------------------------------------");
            System.out.println("                       FACTURE                       ");
            for (Consommation consommation: listeConsommations){
                System.out.print("[ ID: " + consommation.getIdConsommation()+"| ");
                System.out.print("Date: "+ consommation.getDateConsommation() +"| ");
                System.out.print("Nombre d'heures: " + consommation.getHeureConsommation() +"| ");
                System.out.print("Momtant: "+ consommation.getMontant() +"| ");
                System.out.print("ID client: "+ consommation.getIdClient() +"| ");
                System.out.print("ID prestation: "+ consommation.getIdPrestation() );
                System.out.println( " ]");
            }
            int total = 0;
            for (Consommation consommation:listeConsommations){
                total = total + consommation.getMontant();
            }

            System.out.println("-----------------------------------------------------");
            System.out.println("Total: " + total + "€");
            System.out.println("ID client de facture: " + idClient );

        } catch (SQLException e) {
            e.printStackTrace();
        }catch (java.util.InputMismatchException e)
        {
            sc.nextInt();
        }
        System.out.println("-----------------------------------------------------");
    }

}
