package modele;

import java.io.Serializable;

/**
 * Created by amineboufatah on 10/01/15.
 */
public class Score  implements Serializable ,ScoreInterface{

    private int idUser ;
    private int idQcm ;
    private int idQuestion ;
    private int response ;

    /**
     * Default Constructor
     */
    public Score(){

    }

    /**
     * Constructor Score
     * @param idQcm
     * @param idUser
     * @param idQuestion
     * @param response
     */
    public Score(int idQcm , int idUser , int idQuestion , int response){
        this.idQcm = idQcm ;
        this.idQuestion = idQuestion ;
        this.idUser = idUser ;
        this.response = response;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdQcm() {
        return idQcm;
    }

    public void setIdQcm(int idQcm) {
        this.idQcm = idQcm;
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public int getResponse() {
        return response;
    }

    public void setResponse(int response) {
        this.response = response;
    }

}
