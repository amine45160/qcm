package modele;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Question implements QuestionInterface , Serializable{

    private int idQuestion ;
    private int level ;
    private String contenuQuestion ;
    private int time ;
    private List choices = new ArrayList<Choice>() ;
    private int idThematique ;
    private int idQcm ;

    public Question(){}

    public Question(int i , int j ,int t,String s , List<Choice> a ){
        this.idThematique = t;
        this.idQuestion = i;
        this.level = j;
        this.choices = a;
    }
    public int getIdQcm() {
        return idQcm;
    }

    public void setIdQcm(int idQcm) {
        this.idQcm = idQcm;
    }

    /**
     * Method that returns the choices for the current Question
     * @return List
     */
    public List getChoices() {
        return choices;
    }

    /**
     * Method that returns the content of the choices using an array
     * @return String [] of choices
     */
    public String [] getChoicesArray(){
        String [] choicesArray = new String [4];
        for (int i = 0 ; i<choices.size() ; i++){
            choicesArray[i] = ((Choice)choices.get(i)).getContenuChoice();
        }
        return choicesArray;
    }

    /**
     * Setter Choice
     * @param choices
     */
    public void setChoices(List choices) {
        this.choices = choices;
    }

    /**
     * Getter IdThematique
     * @return idThematique
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
     * Method that returns the level of the question meaninig
     * which type of students is this question for
     * @return level of the Question
     */
    public int getLevel() {
        return level;
    }

    /**
     * Setter Level
     * @param level
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Getter Time
     * @return the time defined for the question
     */
    public int getTime() {
        return time;
    }

    /**
     * Setter Time Question
     * @param time
     */
    public void setTime(int time) {
        this.time = time;
    }

    /**
     * Getter IdQuestion
     * @return idQuestion
     */
    public int getIdQuestion() {
        return idQuestion;
    }

    /**
     * Setter IdQuestion
     * @param id
     */
    public void setIdQuestion(int id) {
        this.idQuestion = id;
    }

    /**
     * Method that returns a string
     * @return content of the question
     */
    public String getContenuQuestion() {
        return contenuQuestion;
    }

    /**
     * Setter Content Question
     * @param contenuQuestion
     */
    public void setContenuQuestion(String contenuQuestion) {
        this.contenuQuestion = contenuQuestion;
    }

    public boolean isRightAnswer(String answer){
        List<Choice> choiceList = this.getChoices();
        for(Choice choice : choiceList){
            if(choice.getIsGoodAnswer()){
                if(choice.getContenuChoice().equals(answer)){
                    return true ;
                }else{
                    return false ;
                }
            }
        }
        return false;
    }

}
