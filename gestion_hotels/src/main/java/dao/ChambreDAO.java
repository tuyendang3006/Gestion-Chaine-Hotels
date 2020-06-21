package dao;

import models.Chambre;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ChambreDAO {
    private String url;
    private String username;
    private String password;

    public ChambreDAO(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    // Prendre l'information d'une chambre par idChambre
    public Chambre getChambreById(int id){
        try {
            Connection conn = DriverManager.getConnection(url,username,password);
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM chambres WHERE idchambres = ?");
            ps.setInt(1,id);

            ResultSet resultSet = ps.executeQuery();

            Chambre chambre = new Chambre();

            while (resultSet.next()){
                chambre.setIdChambre(resultSet.getInt("idchambres"));
                chambre.setTelChambre(resultSet.getString("telchambre"));
                chambre.setEtatChambre(resultSet.getString("etatchambre"));
                chambre.setIdHotel(resultSet.getInt("idhotels"));
                chambre.setIdCategorie(resultSet.getInt("idcategories"));
            }
            return chambre;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Afficher les chambres disponibles d'un hotel
    public void getChambresDisponibles() throws SQLException {
        Scanner sc = new Scanner(System.in);
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM chambres WHERE idhotels=? AND etatChambre='En_vente' ");

            System.out.print("Entrer le ID hotel: ");
            int idHotel = sc.nextInt();
            ps.setInt(1,idHotel);

            ResultSet resultSet = ps.executeQuery();

            ArrayList<Chambre> listeChambres = new ArrayList<>();

            while (resultSet.next()){
                Chambre chambre = new Chambre();
                chambre.setIdChambre(resultSet.getInt(1));
                chambre.setTelChambre(resultSet.getString(2));
                chambre.setEtatChambre(resultSet.getString(3));
                chambre.setIdCategorie(resultSet.getInt(4));
                chambre.setIdHotel(resultSet.getInt(5));
                listeChambres.add(chambre);
            }
            if(listeChambres.size() < 1){
                System.out.println("Ne pas trouver !");
            }
            for (Chambre chambre: listeChambres){
                System.out.print("[ ID: " + chambre.getIdChambre()+"| ");
                System.out.print("Tél: "+ chambre.getTelChambre() +"| ");
                System.out.print("Etat: " + chambre.getEtatChambre() +"| ");
                System.out.print("ID Hotel: "+ chambre.getIdHotel() +"| ");
                System.out.print("ID Categories: "+ chambre.getIdCategorie());
                System.out.println( " ]");
            }

            System.out.println("-----------------------------------------------");
            System.out.println( "Nombre de chambre disponible: " + listeChambres.size());

        } catch (SQLException e) {
            e.printStackTrace();
        }catch (java.util.InputMismatchException e)
        {
            sc.nextInt();
        }
        System.out.println("-----------------------------------------------");
    }

}
