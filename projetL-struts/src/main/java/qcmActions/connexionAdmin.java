package qcmActions;

import com.opensymphony.xwork2.ActionSupport;
import modele.Administrateur;
import java.io.InputStream;
import java.io.StringBufferInputStream;

public class connexionAdmin extends ActionSupport {

    private String identifiantAdmin;
    private String passwordAdmin;
    private int id;
    private InputStream inputStream;

    public String getPasswordAdmin() {
        return passwordAdmin;
    }

    public void setPasswordAdmin(String passwordAdmin) {
        this.passwordAdmin = passwordAdmin;
    }

    public String getIdentifiantAdmin() {
        return identifiantAdmin;
    }

    public void setIdentifiantAdmin(String identifiantAdmin) {
        this.identifiantAdmin = identifiantAdmin;
    }


    public Administrateur isAdminIn(String email , String password){

        for (Object adminOb : HomeAdmin.listAdmin){
           Administrateur admin = (Administrateur) adminOb;
            if (admin.getIdentifiantAdmin().equals(email) && admin.getPasswordAdmin().equals(password)) {
                return admin;
            }
        }
        return null ;
    }

    public String execute() throws Exception {

        if (isAdminIn(getIdentifiantAdmin(), getPasswordAdmin()) != null) {
            HomeAdmin.admin.setIdentifiantAdmin(getIdentifiantAdmin());
            HomeAdmin.admin.setPasswordAdmin(getPasswordAdmin());
            HomeAdmin.admin.setIdAdmin(this.isAdminIn(getIdentifiantAdmin(), getPasswordAdmin()).getIdAdmin());
            HomeAdmin.admin.setNomAdmin(this.isAdminIn(getIdentifiantAdmin(), getPasswordAdmin()).getNomAdmin());
            HomeAdmin.admin.setPrenomAdmin(this.isAdminIn(identifiantAdmin, passwordAdmin).getPrenomAdmin());
            inputStream = new StringBufferInputStream("connected");
       } else {
            inputStream = new StringBufferInputStream("notConnected");
        }
        return SUCCESS;
    }


    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
