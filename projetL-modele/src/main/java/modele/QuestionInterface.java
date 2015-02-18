package modele;

import java.util.List;

/**
 * Created by amineboufatah on 03/12/14.
 */
public interface QuestionInterface {

    String [] getChoicesArray();

    void setChoices(List choices);

    void setIdThematique(int idThematique) ;

    int getTime();

    void setTime(int time);

    int getIdQuestion();

    String getContenuQuestion();

    void setContenuQuestion(String contenuQuestion);
}
