package qcmActions;

import com.opensymphony.xwork2.ActionSupport;
import modele.Choice;
import modele.Question;
import modele.Thematique;

import java.util.ArrayList;
import java.util.List;

public class QcmAction extends ActionSupport {

    private List<Question> listQuestion = new ArrayList<Question>();

    private int idQuestion ;
    private int level ;
    private String contenuQuestion ;
    private int time ;
    private List choices = new ArrayList<Choice>() ;
    private int idThematique ;


    public String execute() throws Exception {

        for(Question element : Home.listQuestion){
            this.listQuestion.add(element);
            System.out.println(element);
        }
        return super.execute();
    }

    public List getChoices() {
        return choices;
    }

    public void setChoices(List choices) {
        this.choices = choices;
    }

    public String getContenuQuestion() {
        return contenuQuestion;
    }

    public void setContenuQuestion(String contenuQuestion) {
        this.contenuQuestion = contenuQuestion;
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public List<Question> getListQuestion() {
        return listQuestion;
    }

    public void setListQuestion(List<Question> listQuestion) {
        this.listQuestion = listQuestion;
    }

    public int getIdThematique() {
        return idThematique;
    }

    public void setIdThematique(int idThematique) {
        this.idThematique = idThematique;
    }
}
