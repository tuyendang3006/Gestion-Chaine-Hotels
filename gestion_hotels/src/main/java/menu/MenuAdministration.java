package menu;

import dao.*;
import main.ServiceAdministration;
import models.Chambre;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuAdministration {
    private static String username;
    private static String url;
    private static String password;

    public MenuAdministration(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void serviceAdministration() throws SQLException {
        Scanner sc=new Scanner(System.in);

        OffreDAO offreDAO = new OffreDAO(url, username, password);
        HotelDAO hotelDAO = new HotelDAO(url, username, password);
        TarifierDAO tarifierDAO = new TarifierDAO(url, username, password);
        ReservationDAO reservationDAO = new ReservationDAO(url, username, password);
        ChambreDAO chambreDAO = new ChambreDAO(url, username, password);

        while (true) {
            System.out.println("Entrer le choix: \n1) Liste de l'offre d'un hotel " +
                    "                            \n2) Liste de l'hotel de la chain  " +
                    "                            \n3) Liste du tarif d'un hotel " +
                    "                            \n4) Le nombre de client est départi dans un jour " +
                    "                            \n5) Liste de chambres disponipbles d'un hotel " +
                    "                            \n6) Quitter la service administration ");
            int choix4 = sc.nextInt();
            if (choix4 == 1) {
                System.out.println("Liste de l'offre d'un hotel");
                offreDAO.getOffresHotel();
            }

            else if (choix4 == 2) {
                System.out.println("Liste de l'hotel de la chain");
                hotelDAO.loadHotels();
            }

            else if (choix4 == 3) {
                System.out.println("Liste du tarif d'un hotel");
                tarifierDAO.getTarifsHotel();
            }

            else if (choix4 == 4){
                System.out.println(("Le nombre de client est départi dans un jour"));
                reservationDAO.numberCheckout();
            }

            else if (choix4 == 5){
                System.out.println(("Liste de chambres disponipbles d'un hotel"));
                chambreDAO.getChambresDisponibles();
            }
            else {
                //System.exit(0);
                break;
            }
        }
    }
}
