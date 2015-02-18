package modele_traitement;

import modele.Score;
import modele.Thematique;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amineboufatah on 11/01/15.
 */

public class HandlerObject implements HandlerObjectInterface {

    /**
     * Default Constructor
     */
    public HandlerObject(){

    }

    public List getThematiquesContent(List<Thematique> thematiquesModele ) {
        List<String> contents = new ArrayList<String>();
        for (Thematique thematique : thematiquesModele) {
            contents.add(thematique.getNom());
        }
        return contents;
    }

    public int getIdThematiqueByContent(List<Thematique> thematiqueList, String content) {
        for(Thematique thematique : thematiqueList){
            if(thematique.getNom().equals(content)){
                return thematique.getLevel();
            }
        }
        return -1 ;
    }

    public double getMeanQcm(List<Score> scores) {
        double moyenne ;
        int nbGood = 0;
        int nbWrong = 0 ;
        for(Score score : scores){
            if(score.getResponse()==1){
                nbGood = nbGood +1 ;
            }
        }
        moyenne = (nbGood * 20) / scores.size();
        nbWrong = scores.size() - nbGood ;
        return moyenne ;
    }

    public int getClassement(List<Integer> finalResultQcm , int idUser) {
        for(int i = 0 ; i<finalResultQcm.size() ; i++){
            if(finalResultQcm.get(i)==idUser){
                return i + 1 ;
            }
        }
        return -1 ;
    }
}
