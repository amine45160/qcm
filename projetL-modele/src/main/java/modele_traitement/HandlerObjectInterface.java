package modele_traitement;

import modele.Score;
import modele.Thematique;

import java.util.List;

/**
 * Created by amineboufatah on 11/01/15.
 */
public interface HandlerObjectInterface {

    /**
     * Gets the id Thematique by its content
     * @param thematiqueList
     * @param content
     * @return int
     */
    int getIdThematiqueByContent(List<Thematique> thematiqueList, String content);

    /**
     * gets the mean result of the user
     * @param scores
     * @return double
     */
    double getMeanQcm(List<Score> scores) ;

    /**
     * Gets the users range
     * @param finalResultQcm
     * @param idUser
     * @return int
     */
    int getClassement(List<Integer> finalResultQcm ,  int idUser);

    /**
     * gets thematiques contents
     * @param thematiquesModele
     * @return List
     */
    public List getThematiquesContent(List<modele.Thematique> thematiquesModele);
}
