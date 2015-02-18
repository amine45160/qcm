package qcmActions;

import com.opensymphony.xwork2.ActionSupport;
import modele.Choice;
import modele.Question;
import modele.User;
import org.apache.struts2.interceptor.SessionAware;
import rmi.InitRemoteService;
import rmi.QcmServiceInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Qcm extends ActionSupport implements SessionAware {


    private static List<Question> listQuestion = new ArrayList<Question>();
    private List listChoice = new ArrayList<Choice>();
    private static List listReponse = new ArrayList<String>();
    private  List listReponse2 = new ArrayList<String>();
    private int idQuestion;
    private int id;
    private String question;
    private String reponse ;
    Map m;

    public  List getListReponse2() {
        return listReponse2;
    }

    public void setListReponse2(List listReponse2) {
        this.listReponse2 = listReponse2;
    }

    public  List getListReponse() {
        return listReponse;
    }

    public  void setListReponse(List listReponse) {
        this.listReponse = listReponse;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public List<Question> getListQuestion() {
        return listQuestion;
    }

    public void setListQuestion(List<Question> listQuestion) {
        this.listQuestion = listQuestion;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Choice> getListChoice() {
        return listChoice;
    }

    public void setListChoice(List<Choice> listChoice) {
        this.listChoice = listChoice;
    }

    public String execute() throws Exception {

        QcmServiceInterface serviceInterface = InitRemoteService.getService();
        listQuestion = serviceInterface.getQuestionsByThematique(id);

        this.question = listQuestion.get(0).getContenuQuestion();
        this.idQuestion = listQuestion.get(0).getIdQuestion();
        this.listChoice = listQuestion.get(0).getChoices();


        return super.execute();
    }

    public String next() throws Exception {


        listReponse.add(reponse);

        if (listQuestion.size() > 1) {
            listQuestion.remove(0);
            setQuestion(listQuestion.get(0).getContenuQuestion());
            setIdQuestion(listQuestion.get(0).getIdQuestion());
            this.listChoice = listQuestion.get(0).getChoices();
            return SUCCESS;
        } else {
           this.listReponse2 = Qcm.listReponse;
            return "finish";
        }
    }

    @Override
    public void setSession(Map<String, Object> session) {

    }
}
