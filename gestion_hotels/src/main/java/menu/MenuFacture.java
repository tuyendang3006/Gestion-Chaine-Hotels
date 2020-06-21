package menu;

import dao.ConsommationDAO;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuFacture {
    private static String username;
    private static String url;
    private static String password;

    public MenuFacture(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void serviceFacture() throws SQLException {
        Scanner sc=new Scanner(System.in);
        ConsommationDAO consommationDAO = new ConsommationDAO(url, username, password);

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
