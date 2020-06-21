package main;

import dao.*;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        // Connexion à SQL
        String url = "jdbc:mysql://localhost:3306/gestion_hotels?serverTimezone=UTC";
        String user = "root";
        String password = "tuyen1994";

        Scanner sc=new Scanner(System.in);

        ClientDAO clientDAO = new ClientDAO(url, user, password);
        ReservationDAO reservationDAO = new ReservationDAO(url, user, password);
        ChambreDAO chambreDAO = new ChambreDAO(url, user, password);
        ConsommationDAO consommationDAO = new ConsommationDAO(url, user, password);
        HotelDAO hotelDAO = new HotelDAO(url, user, password);
        OffreDAO offreDAO = new OffreDAO(url, user, password);
        TarifierDAO tarifierDAO = new TarifierDAO(url, user, password);


        while(true) {
            // Interface de choix la service
            System.out.println("Choisir d'une service: \n1) SERVICE RESERVATION  " +
                    "                                  \n2) SERVICE CLIENTELE  " +
                    "                                  \n3) SERVICE FACTURE " +
                    "                                  \n4) SERVICE ADMINISTRATION " + "" +
                    "                                  \n5) Quitter le système");

            // Taper pour choix
            int choix=sc.nextInt();

            /**  ********************************************************
             *                      Service Réservation
             *   *********************************************************/
            if(choix == 1) {
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


            /**  ********************************************************
             *                      Service Clientèle
             *   *********************************************************/
            else if(choix == 2)
            {
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
                        System.out.println("Ajouter d'un client, entrer des informations! ");
                        clientDAO.addClient();
                    }

                    else if(choix2 == 3){
                        System.out.println("Supprimer d'un client ");
                        clientDAO.deleteClient();
                    }

                    else if(choix2 == 4){
                        System.out.println("L'histoire de passages d'un client ");
                        reservationDAO.passReservations();
                    }

                    else if(choix2 == 5){
                        System.out.println("Liste de clients présente dans hotels ");
                        reservationDAO.presentDayHotel();
                    }

                    // Quitter le service clientèle
                    else {
                        //System.exit(0);
                        break;
                    }
                }
            }

            /**  ********************************************************
             *                      Service Facture
             *   *********************************************************/
            else if(choix == 3) {
                while (true) {
                    System.out.println("Entrer le choix: \n1) Liste des consommations " +
                            "                            \n2) Ajouter d'une consommation  " +
                            "                            \n3) Prendre la facture " +
                            "                            \n4) Quitter la service facture ");
                    int choix3 = sc.nextInt();
                    if (choix3 == 1) {
                        System.out.println("Liste des consommations d'un client");
                        consommationDAO.getConsommations();
                    }

                    else if (choix3 == 2) {
                        System.out.println("Ajouter d'une consommation");
                        consommationDAO.addConsommation();
                    }

                    else if (choix3 == 3) {
                        System.out.println("Prendre la facture ");
                        consommationDAO.getFacture();
                    } else {
                        //System.exit(0);
                        break;
                    }
                }
            }


            /**  ********************************************************
             *                      Service Administration
             *   *********************************************************/
            else if(choix == 4) {
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


            /**  ********************************************************
             *                      Quitter le système
             *   *********************************************************/
            else {
                System.exit(0);
                System.out.println("****************************************************************");
            }

            System.out.println("********************************************************************************************\n");
        }
    }

}
