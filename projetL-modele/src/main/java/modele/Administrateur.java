package modele;

public class Administrateur {

    private int idAdmin ;
    private String nomAdmin ;
    private String prenomAdmin ;
    private String passwordAdmin ;
    private String identifiantAdmin ;

    /**
     * Getter Identifiant
     * @return int
     */
    public String getIdentifiantAdmin() {
        return identifiantAdmin;
    }

    /**
     * Setter IdentifiantAdmin
     * @param identifiantAdmin
     */
    public void setIdentifiantAdmin(String identifiantAdmin) {
        this.identifiantAdmin = identifiantAdmin;
    }

    /**
     * Getter PasswordAdmin
     * @return
     */
    public String getPasswordAdmin() {
        return passwordAdmin;
    }

    /**
     * Setter PasswordAdmin
     * @param passwordAdmin
     */
    public void setPasswordAdmin(String passwordAdmin) {
        this.passwordAdmin = passwordAdmin;
    }

    /**
     * Getter PrenomAdmin
     * @return StringAdmin
     */
    public String getPrenomAdmin() {
        return prenomAdmin;
    }

    /**
     * Setter PrenomAdmin
     * @param prenomAdmin
     */
    public void setPrenomAdmin(String prenomAdmin) {
        this.prenomAdmin = prenomAdmin;
    }

    /**
     * Getter NomAdmin
     * @return String
     */
    public String getNomAdmin() {
        return nomAdmin;
    }

    /**
     * Setter NomAdmin
     * @param nomAdmin
     */
    public void setNomAdmin(String nomAdmin) {
        this.nomAdmin = nomAdmin;
    }

    /**
     * Getter IdAdmin
     * @return int
     */
    public int getIdAdmin() {
        return idAdmin;
    }

    /**
     * Setter IdAdmin
     * @param idAdmin
     */
    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }
}
