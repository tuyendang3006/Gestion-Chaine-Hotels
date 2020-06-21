package main;

import dao.ChambreDAO;
import dao.ClientDAO;
import dao.ReservationDAO;

import java.sql.SQLException;
import java.util.Scanner;

public class ServiceClientele {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/gestion_hotels?serverTimezone=UTC";
        String user = "root";
        String password = "tuyen1994";

        Scanner sc=new Scanner(System.in);
        ClientDAO clientDAO = new ClientDAO(url, user, password);
        ReservationDAO client = new ReservationDAO(url, user, password);
        ChambreDAO clientCh = new ChambreDAO(url, url, password);

        while(true) {
            System.out.println("Entrer le choix:  \n1) Voir l'information de client  " +
                    "                             \n2) Ajouter d'un client  " +
                    "                             \n3) Supprimer d'un client " +
                    "                             \n4) Histoire de passages d'un client " +
                    "                             \n5) Liste client présente dans un hotel " +
                    "                             \n6) Quitter la service clientèle");
            int choix2 = sc.nextInt();

            if( choix2 == 1){
                // Voir et valider d'un client
                System.out.print("Entrer id de client: ");
                int id = sc.nextInt();
                System.out.println(clientDAO.getClientById(id));
            }

            else if(choix2 == 2){
                System.out.println("Ajouter d'un client ");
                System.out.println("Ajouter d'un client, entrer des informations! ");
                clientDAO.addClient();
            }

            else if(choix2 == 3){
                System.out.println("Supprimer d'un client ");
                clientDAO.deleteClient();
            }

            else if(choix2 == 4){
                System.out.println("L'histoire de passages d'un client ");
                client.passReservations();
            }

            else if(choix2 == 5){
                System.out.println("Liste de clients présente dans hotels ");
                client.presentDayHotel();
            }

            // Quitter le service clientèle
            else {
                //System.exit(0);
                break;
            }
        }
    }


}
