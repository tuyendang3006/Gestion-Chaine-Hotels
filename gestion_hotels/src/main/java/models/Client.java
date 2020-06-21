package models;

/**
 * Represents a Client for chain hotel
 * Required field: idClient
 * @author Tuyen Dang
 */
public class Client {
    private int idClient; //ID client
    private String nomClient; //Nom de client
    private String prenomClient; //Prenom de client
    private String adrClient; //Adresse de client
    private String ville; //Ville de client
    private int cpClient; // Code Postal de client
    private String paysClient; // Pays de client
    private String emailClient; //Adresse email de client
    private String  telClient; //Numéro de téléphone de client

    public Client(){}

    public Client(int idClient, String nomClient, String prenomClient, String adrClient, String ville, int cpClient, String paysClient, String telClient, String emailClient){
        this.idClient = idClient;
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.adrClient = adrClient;
        this.ville = ville;
        this.cpClient = cpClient;
        this.paysClient = paysClient;
        this.telClient = telClient;
        this.emailClient = emailClient;
    }

    public Client(int idClient) {
        this.idClient = idClient;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    public void setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient;
    }

    public String getAdrClient() {
        return adrClient;
    }

    public void setAdrClient(String adrClient) {
        this.adrClient = adrClient;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getCpClient() {
        return cpClient;
    }

    public void setCpClient(int cpClient) {
        this.cpClient = cpClient;
    }

    public String getPaysClient() {
        return paysClient;
    }

    public void setPaysClient(String paysClient) {
        this.paysClient = paysClient;
    }

    public String getEmailClient() {
        return emailClient;
    }

    public void setEmailClient(String emailClient) {
        this.emailClient = emailClient;
    }

    public String getTelClient() {
        return telClient;
    }

    public void setTelClient(String telClient) {
        this.telClient = telClient;
    }

    public String toString() {
        return "Information de client {"
                + "ID Client:" + idClient
                + ", nom de client: " + nomClient
                + ", prénom de client: " + prenomClient
                + ", Adresse de client: " + adrClient
                +", Code Postal, Ville et Pays: " + cpClient + " " + ville + " " + paysClient
                + ", Tél de client: " + telClient
                + ", email de client: " + emailClient
                + "}";
    }

}
