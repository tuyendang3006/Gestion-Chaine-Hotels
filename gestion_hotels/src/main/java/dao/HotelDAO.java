package dao;

import models.Hotel;

import java.sql.*;
import java.util.ArrayList;

public class HotelDAO {
    private String url;
    private String username;
    private String password;

    public HotelDAO(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    // Liste des hotels d'une chain hôtelière
    public void loadHotels(){
        try {
            Connection conn = DriverManager.getConnection(url,username,password);
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM hotels");

            ResultSet resultSet = ps.executeQuery();

            ArrayList<Hotel> listeHotels = new ArrayList<>();

            while (resultSet.next()){
                Hotel hotel = new Hotel();
                hotel.setIdHotel(resultSet.getInt(1));
                hotel.setNomHotel(resultSet.getString(2));
                hotel.setAdrHotel(resultSet.getString(3));
                hotel.setCpHotel(resultSet.getInt(4));
                hotel.setTelHotel(resultSet.getString(5));
                hotel.setNbetoile(resultSet.getInt(6));
                listeHotels.add(hotel);
            }
            for (Hotel hotel: listeHotels){
                System.out.print("[ ID: " + hotel.getIdHotel()+"| ");
                System.out.print("Nom: "+ hotel.getNomHotel() +"| ");
                System.out.print("Adresse: " + hotel.getAdrHotel() +"| ");
                System.out.print("Code Postal: "+ hotel.getCpHotel() + " |");
                System.out.print("Tél: "+ hotel.getCpHotel() + " |");
                System.out.print("Class: " + hotel.getNbetoile() + "*");
                System.out.println( " ]");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("-----------------------------------------------");
    }
}
