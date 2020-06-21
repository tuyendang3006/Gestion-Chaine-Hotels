package dao;

import models.Client;

import java.sql.*;
import java.util.Scanner;

public class ClientDAO {
    private String url;
    private String username;
    private String password;

    public ClientDAO(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    // Prendre l'information d'un client par idClient
    public Client getClientById(int id){
        try {
            Connection conn = DriverManager.getConnection(url,username,password);
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM clients WHERE idclients=?");
            ps.setInt(1,id);

            ResultSet resultSet = ps.executeQuery();

            Client client = new Client();

            while (resultSet.next()){
                client.setIdClient(resultSet.getInt("idclients"));
                client.setNomClient(resultSet.getString("nomClient"));
                client.setPrenomClient(resultSet.getString("prenomClient"));
                client.setAdrClient(resultSet.getString("adrClient"));
                client.setVille(resultSet.getString("villeClient"));
                client.setCpClient(resultSet.getInt("cpClient"));
                client.setPaysClient(resultSet.getString("paysClient"));
                client.setTelClient(resultSet.getString("telClient"));
                client.setEmailClient(resultSet.getString("emailClient"));
                showClientInfo(resultSet);
            }
            return client;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addClient() {
        Scanner sc = new Scanner(System.in);
        try (
                Connection conn = DriverManager.getConnection(url, username, password);
                PreparedStatement ps = conn.prepareStatement(" INSERT INTO clients(idclients, nomClient, prenomCLient, adrClient, villeClient, CPClient, paysClient, telClient, emailClient)"
                        + " VALUES(?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        ) {
            // Entrer les informations de client
            System.out.print("Entrer ID client: ");
            int i1 = sc.nextInt();
            System.out.print("Entrer le nom du client: ");
            String str1 = sc.next();
            System.out.print("Entrer le prénom du client: ");
            String str2 = sc.next();
            System.out.print("Entrer l'adresse du client: ");
            String str3 = sc.next();
            System.out.print("Entrer la ville: ");
            String str4 = sc.next();
            System.out.print("Entrer la code postal: ");
            int i2 = sc.nextInt();
            System.out.print("Entrerle pays du client: ");
            String str5 = sc.next();
            System.out.print("Entrer le numéro de téléphone: ");
            String str6 = sc.next();
            System.out.print("Entrer l'adresse d'émail: ");
            String str7 = sc.next();

            // prendre les valeurs paramètres
            ps.setInt(1,i1);
            ps.setString(2, str1);
            ps.setString(3, str2);
            ps.setString(4,str3);
            ps.setString(5, str4);
            ps.setInt(6, i2);
            ps.setString(7, str5);
            ps.setString(8,str6);
            ps.setString(9, str7);

            // Executer le SQL statement
            ps.execute();

            // Prendre le clé général
            try (ResultSet rs = ps.getGeneratedKeys();) {
                int idValue = 0;
                if (rs.next()) {
                    idValue = rs.getInt(1);
                }
                System.out.println("Ajouter succèss id: " + idValue);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Supprimer d'un client
    public void deleteClient(){

        Scanner sc = new Scanner(System.in);
        int id=0;
        try (
                Connection conn = DriverManager.getConnection(url, username, password);
                PreparedStatement ps = conn.prepareStatement("DELETE FROM clients WHERE idclients=?", Statement.RETURN_GENERATED_KEYS);
        ) {
            System.out.print("Entrer ID client: "); id = sc.nextInt();
            ps.setInt(1,id);

            // Exécuter le SQL statement
            ps.executeUpdate();

            // Prendre la clé général
            try (ResultSet rs = ps.getGeneratedKeys();) {
                int idValue = 0;
                if (rs.next()) {
                    idValue = rs.getInt(1);
                }
                System.out.println("Supprimer succèss ! ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void showClientInfo(ResultSet rs) throws SQLException {
        System.out.println("Id Client: " + rs.getInt(1));
        System.out.println("Nom: " + rs.getString(2));
        System.out.println("Prénom: " + rs.getString(3));
        System.out.println("Adresse: " + rs.getString(4));
        System.out.println("Ville: " + rs.getString(5));
        System.out.println("Code Postal: " + rs.getInt(6));
        System.out.println("Pays: " + rs.getString(7));
        System.out.println("Téléphone: " + rs.getString(8));
        System.out.println("Email: " + rs.getString(9));
        System.out.println("---");
    }
}
