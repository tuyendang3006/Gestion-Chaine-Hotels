package dao;

import models.Offre;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class OffreDAO {
    private String url;
    private String username;
    private String password;

    public OffreDAO(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    // Liste de l'offre d'un hotel
    public void getOffresHotel(){
        Scanner sc = new Scanner(System.in);
        try {
            Connection conn = DriverManager.getConnection(url,username,password);
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM offre WHERE idhotels=?", Statement.RETURN_GENERATED_KEYS);

            System.out.print("Entrer ID hotel: ");
            int idHotel = sc.nextInt();
            ps.setInt(1, idHotel);

            ResultSet resultSet = ps.executeQuery();

            ArrayList<Offre> listeOffres = new ArrayList<>();

            while (resultSet.next()){
                Offre offre = new Offre();
                offre.setIdPrestation(resultSet.getInt(1));
                offre.setIdHotel(resultSet.getInt(2));
                offre.setPrixPrestation(resultSet.getInt(3));
                listeOffres.add(offre);
            }
            for (Offre offre: listeOffres){
                System.out.print("[ ID prestation: " + offre.getIdPrestation()+"| ");
                System.out.print("ID hotel: "+ offre.getIdHotel() +"| ");
                System.out.print("Prix: " + offre.getPrixPrestation());
                System.out.println( " ]");
            }

        }  catch (SQLException e) {
            e.printStackTrace();
        }catch (java.util.InputMismatchException e)
        {
            sc.nextInt();
        }
        System.out.println("-----------------------------------------------");
    }
}
