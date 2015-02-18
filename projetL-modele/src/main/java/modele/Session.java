package modele;

import java.util.Date;

/**
 * Created by amineboufatah on 15/11/14.
 */
public class Session implements SessionInterface{

    private int id ;
    private int idThematique ;
    private int idUser ;
    private Date dateSession ;

    /**
     * Getter Id
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * Setter Id
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter idThematique
     * @return
     */
    public int getIdThematique() {
        return idThematique;
    }

    /**
     * Setter IdThematique
     * @param idThematique
     */
    public void setIdThematique(int idThematique) {
        this.idThematique = idThematique;
    }

    /**
     * Getter idUser
     * @return int
     */
    public int getIdUser() {
        return idUser;
    }

    /**
     * Setter IdUser
     * @param idUser
     */
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    /**
     * Getter DateSession
     * @return Date
     */
    public Date getDateSession() {
        return dateSession;
    }

    /**
     * Setter DateSession
     * @param dateSession
     */
    public void setDateSession(Date dateSession) {
        this.dateSession = dateSession;
    }
}
