package main;

import dao.*;
import models.Hotel;

import javax.swing.text.TabableView;
import java.sql.SQLException;
import java.util.Scanner;

public class ServiceAdministration {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/gestion_hotels?serverTimezone=UTC";
        String user = "root";
        String password = "tuyen1994";

        Scanner sc = new Scanner(System.in);
        OffreDAO offreDAO = new OffreDAO(url, user, password);
        HotelDAO hotelDAO = new HotelDAO(url, user, password);
        TarifierDAO tarifierDAO = new TarifierDAO(url, user, password);
        ReservationDAO reservationDAO = new ReservationDAO(url, user, password);

        while (true) {
            System.out.println("Entrer le choix: \n1) Liste de l'offre d'un hotel " +
                    "                            \n2) Liste de l'hotel de la chain  " +
                    "                            \n3) Liste du tarif d'un hotel " +
                    "                            \n4) Le nombre de client est départi dans un jour " +
                    "                            \n5) Quitter la service administration ");
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
            else {
                //System.exit(0);
                break;
            }
        }

    }

}
