package qcmActions;

import com.opensymphony.xwork2.ActionSupport;
import modele.Question;
import modele.Thematique;
import rmi.InitRemoteService;
import rmi.QcmService;
import rmi.QcmServiceInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class ThematiqueAction extends ActionSupport {

    private List<Question> listQuestion = new ArrayList<Question>();
    private String identifiant;
    private String nom;
    private String prenom;
    private String identifiantAdmin;
    private String nomAdmin;
    private String prenomAdmin;
    private int id;
    private int idAdmin;
    private int level;
    private QcmServiceInterface monService;


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    private List<Thematique> listOfThematic = new ArrayList<Thematique>();


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

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String execute() throws Exception {

        this.id = Home.user.getId();
        this.level = Home.user.getLevel();
        this.identifiant = Home.user.getIdentifiant();
        this.nom = Home.user.getNom();
        this.prenom = Home.user.getPrenom();

        this.idAdmin = HomeAdmin.admin.getIdAdmin();
        this.nomAdmin =  HomeAdmin.admin.getNomAdmin();
        this.prenomAdmin = HomeAdmin.admin.getPrenomAdmin();

        QcmServiceInterface qcmServiceInterface = InitRemoteService.getService();
        listOfThematic = qcmServiceInterface.getLaunchedThematiques(1);



        for(Question element : Home.listQuestion){
            this.listQuestion.add(element);
        }
        return super.execute();
    }

    public void setApplication(Map<String, Object> stringObjectMap) {
        this.monService =(QcmService)stringObjectMap.get("monService");

        if (this.monService == null) {
            this.monService = InitRemoteService.getService();
            stringObjectMap.put("monService",this.monService);
        }
    }

    public List<Thematique> getListOfThematic() {
        return listOfThematic;
    }

    public void setListOfThematic(List<Thematique> listOfThematics) {
        this.listOfThematic = listOfThematics;
    }

    public String getIdentifiantAdmin() {
        return identifiantAdmin;
    }

    public void setIdentifiantAdmin(String identifiantAdmin) {
        this.identifiantAdmin = identifiantAdmin;
    }

    public String getNomAdmin() {
        return nomAdmin;
    }

    public void setNomAdmin(String nomAdmin) {
        this.nomAdmin = nomAdmin;
    }

    public String getPrenomAdmin() {
        return prenomAdmin;
    }

    public void setPrenomAdmin(String prenomAdmin) {
        this.prenomAdmin = prenomAdmin;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }
}

