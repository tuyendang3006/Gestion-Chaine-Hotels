package menu;

import dao.ReservationDAO;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuReservation {
    private static String username;
    private static String url;
    private static String password;

    public MenuReservation(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void serviceReservation() throws SQLException {
        Scanner sc=new Scanner(System.in);
        ReservationDAO reservationDAO = new ReservationDAO(url, username, password);

        while(true) {
            System.out.println("Entrer la choix: \n1) Voir l'information d'une réservation  " +
                    "                            \n2) Ajouter d'une réservation " +
                    "                            \n3) Annuler une reservation " +
                    "                            \n4) Liste de réservations " +
                    "                            \n5) Liste de date d'arrivée d'un client " +
                    "                            \n6) Quitter la service Réservation");
            int choix1 = sc.nextInt();

            if( choix1 == 1){
                System.out.print("Entrer id de réservation: ");
                int id = sc.nextInt();
                System.out.println(ReservationDAO.getReservationById(id));
            }

            else if(choix1 == 2){
                System.out.println("Ajouter d'une réservation, entrer des informations! ");
                reservationDAO.addReservation();
            }

            else if(choix1 == 3){
                System.out.println("Annuler d'une reservation ");
                reservationDAO.deleteReservation();
            }

            else if(choix1 == 4){
                System.out.println("Liste de tous les réservations ");
                reservationDAO.loadReservations();
            }

            else if(choix1 == 5){
                System.out.println("Liste de date d'arrivée d'un client ");
                reservationDAO.dateCheckIn();
            }

            // Quitter le système de service réservation
            else {
                //System.exit(0);
                break;
            }

        }
    }
}
