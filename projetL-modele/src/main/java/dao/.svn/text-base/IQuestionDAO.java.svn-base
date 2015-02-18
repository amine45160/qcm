package dao;

import modele.Question;

import java.util.List;

/**
 * Created by amineboufatah on 11/01/15.
 */
public interface IQuestionDAO {

    /**
     * This method adds a Qcm to the DB
     * @param idEnseignant
     * @param thematique
     * @param questions
     */
    public void addQcm(int idEnseignant , int thematique , List<Question> questions);

    /**
     * Gets all the question according to the Thematique
     * @param thematique
     * @return list
     */
    public List<Question> getQuestionsByThematique(int thematique);

    /**
     * This method allows the Admin to launch the Qcm, ie : make it available for the students
     * @param idQcm
     */
    public void launchQcm(int idQcm);

    /**
     * Method that checks whether the user has already responded to the Qcm or not
     * @param idUser
     * @param idQcm
     * @return boolean
     */
    public boolean hasResponded(int idUser , int idQcm);
}
