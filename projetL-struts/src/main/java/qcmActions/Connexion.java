package qcmActions;

import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import modele.User;
import rmi.InitRemoteService;
import rmi.QcmServiceInterface;
import org.apache.struts2.interceptor.SessionAware;

public class Connexion extends ActionSupport implements SessionAware {

    private String identifiant;
    private String password;
    private int id;
    private int level;
    private InputStream inputStream;
    Map m;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public String execute() throws Exception {

        QcmServiceInterface service = InitRemoteService.getService();
        User user = service.getUserByInformations(getIdentifiant() , getPassword());

        if (user.getLevel()!=0){

            m.put("user",user);
            inputStream = new StringBufferInputStream("connected");

        } else {

            inputStream = new StringBufferInputStream("notConnected");

        }
        return SUCCESS;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public void setSession(Map m) {
        {
            this.m=m;
        }
    }
}

