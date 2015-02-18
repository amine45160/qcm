package qcmActions;

import com.opensymphony.xwork2.ActionSupport;
import dao.QuestionDAO;
import modele.*;
import java.util.ArrayList;
import java.util.List;

public class HomeAdmin  extends ActionSupport {

    private Qcm a = new Qcm();

    static Administrateur admin = new Administrateur();
    static List<Administrateur> listAdmin = new ArrayList<Administrateur>();

    public String execute() throws Exception {

        admin.setIdAdmin(3);
        admin.setIdentifiantAdmin("admin@admin.fr");
        admin.setPasswordAdmin("admin");
        admin.setNomAdmin("adminNom");
        admin.setPrenomAdmin("adminPrenom");
        listAdmin.add(admin);

        return super.execute();
    }

    public Qcm getA() {
        return a;
    }

    public void setA(Qcm a) {
        this.a = a;
    }
}
