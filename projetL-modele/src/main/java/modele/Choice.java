package modele;

import java.io.Serializable;

public class Choice implements ChoiceInterface , Serializable {

    private int id;
    private int idQuestion;
    private String contenuChoice;
    private boolean isGoodAnswer;

    public Choice(){

    }

    public Choice (int i ,String s, boolean a){
        this.idQuestion = i;
        this.contenuChoice = s;
        this.isGoodAnswer = a ;
    }

    /**
     * Getter id
     * @return int
     */
    public int getIdQuestion() {
        return idQuestion;
    }

    /**
     * Setter
     * @param idQuestion
     */
    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    /**
     * Setter
     * @param isGoodAnswer
     */
    public void setGoodAnswer(boolean isGoodAnswer) {
        this.isGoodAnswer = isGoodAnswer;
    }

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
     * Getter ContenuChoice
     * @return String
     */
    public String getContenuChoice() {
        return this.contenuChoice;
    }

    /**
     * Setter ContenuChoice
     * @param contenuChoice
     */
    public void setContenuChoice(String contenuChoice) {
        this.contenuChoice = contenuChoice;
    }

    /**
     * Getter isGoodAnswer
     * @return boolean
     */
    public boolean getIsGoodAnswer() {
        return isGoodAnswer;
    }

    /**
     * Setter isGoodAnswer
     * @param isGoodAnswer
     */
    public void setIsGoodAnswer(boolean isGoodAnswer) {
        this.isGoodAnswer = isGoodAnswer;
    }
}
