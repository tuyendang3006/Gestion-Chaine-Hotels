package menu;

import dao.ClientDAO;
import dao.ReservationDAO;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws SQLException {

        // Connexion à SQL
        String url = "jdbc:mysql://localhost:3306/gestion_hotels?serverTimezone=UTC";
        String user = "root";
        String password = "tuyen1994";

        Scanner sc = new Scanner(System.in);

        MenuReservation menuReservation = new MenuReservation(url, user, password);
        MenuAdministration menuAdministration = new MenuAdministration(url, user, password);
        MenuClientele menuClientele = new MenuClientele(url, user, password);
        MenuFacture menuFacture = new MenuFacture(url, user, password);

        while(true) {
            // Interface de choix la service
            System.out.println("Choisir d'une service: \n1) SERVICE RESERVATION  " +
                    "                                  \n2) SERVICE CLIENTELE  " +
                    "                                  \n3) SERVICE FACTURE " +
                    "                                  \n4) SERVICE ADMINISTRATION " + "" +
                    "                                  \n5) Quitter le système");

            // Taper pour choix
            int choix = sc.nextInt();

            switch (choix){
                case 1: menuReservation.serviceReservation();
                        break;
                case 2:
                        menuClientele.serviceClientele();
                        break;
                case 3:
                        menuFacture.serviceFacture();
                        break;
                case 4:
                        menuAdministration.serviceAdministration();
                        break;
                case 5:
                        System.exit(0);
                        break;
            }
        }

    }

}
