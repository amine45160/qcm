package modele;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amineboufatah on 12/01/15.
 */
public class Questionnaire {
    int idQcm ;
    int idThematique ;

    public Questionnaire(int idQcm , int idThematique , ArrayList<Question> questions){
        this.idQcm = idQcm;
        this.idThematique = idThematique;
        this.mesQuestions = questions;
    }

    public int getIdQcm() {
        return idQcm;
    }

    public void setIdQcm(int idQcm) {
        this.idQcm = idQcm;
    }


    public List<Question> getMesQuestions() {
        return mesQuestions;
    }

    public int getIdThematique() {
        return idThematique;
    }

    public void setIdThematique(int idThematique) {
        this.idThematique = idThematique;
    }

    public void setMesQuestions(ArrayList<Question> mesQuestions) {
        this.mesQuestions = mesQuestions;
    }

    ArrayList<Question> mesQuestions = new ArrayList<Question>();
}
