package dao;

import modele.Score;

import java.util.List;

/**
 * Created by amineboufatah on 09/01/15.
 */
public interface IResultDAO {

    /**
     * Adds the score of the User
     * @param idEtudiant
     * @param idQcm
     * @param idQuestion
     * @param answer
     */
    public void addScoreQuestion(int idEtudiant , int idQcm , int idQuestion , int answer);

    /**
     * Method that gets Final Results for a Qcm
     * @param idQcm
     * @return
     */
    public List<Integer> getFinalResultQcm(int idQcm);

    /**
     * Gets the result for each Question By IdQcm
     * @param idQcm
     * @param idUser
     * @return
     */
    public List<Score> getScoreByQcm(int idQcm , int idUser);

}
