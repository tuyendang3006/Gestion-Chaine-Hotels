package main;

import dao.ConsommationDAO;

import java.sql.SQLException;
import java.util.Scanner;

public class ServiceFacture {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/gestion_hotels?serverTimezone=UTC";
        String user = "root";
        String password = "tuyen1994";

        Scanner sc=new Scanner(System.in);
        ConsommationDAO consommationDAO = new ConsommationDAO(url, user, password);

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
}
