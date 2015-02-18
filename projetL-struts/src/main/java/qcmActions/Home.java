package qcmActions;

import com.opensymphony.xwork2.ActionSupport;
import dao.QuestionDAO;
import modele.*;

import java.util.ArrayList;
import java.util.List;


public class Home extends ActionSupport {


    static User user = new User();

    static List<modele.Question> listQuestion = new ArrayList<modele.Question>();

    public String execute() throws Exception {

        return super.execute();
    }
}
