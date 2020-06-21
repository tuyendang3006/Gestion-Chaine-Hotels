package dao;

import models.Tarifier;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TarifierDAO {
    private String url;
    private String username;
    private String password;

    public TarifierDAO(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    // Afficher d'un tarif de chaque type de chambre d'une classe d'hotel
    public void getTarifsHotel(){
        Scanner sc = new Scanner(System.in);
        try {
            Connection conn = DriverManager.getConnection(url,username,password);
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM tarifier WHERE nbetoile=?", Statement.RETURN_GENERATED_KEYS);

            System.out.print("Entrer la classe de l'hotel (*): ");
            int nbEtoile = sc.nextInt();
            ps.setInt(1, nbEtoile);

            ResultSet resultSet = ps.executeQuery();

            ArrayList<Tarifier> listeTarifs = new ArrayList<>();

            while (resultSet.next()){
                Tarifier tarifier = new Tarifier();
                tarifier.setIdCategories(resultSet.getInt(1));
                tarifier.setNbetoile(resultSet.getInt(2));
                tarifier.setTarifUnitaire(resultSet.getInt(3));
                listeTarifs.add(tarifier);
            }
            for (Tarifier tarifier: listeTarifs){
                System.out.print("[ ID categories: " + tarifier.getIdCategories()+"| ");
                System.out.print("Numbre d'étoile: "+ tarifier.getNbetoile() +"| ");
                System.out.print("Tarif d'unitaire: " + tarifier.getTarifUnitaire());
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
