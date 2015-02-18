package controller;

import modele.Thematique;
import modele.User;
import modele_traitement.HandlerObject;
import modele_traitement.HandlerObjectInterface;
import rmi.QcmServiceInterface;

import java.rmi.RemoteException;
import java.util.List;

public class ControllerThematique implements ThematiqueInterface {

    private QcmServiceInterface qcmServiceInterface ;
    private views.ThematiqueInterface thematiqueView;
    private HandlerObjectInterface handlerObjectInterface ;
    private List<Thematique> thematiqueList ;
    private int current_id ;

    /**
     * Controller Constructor
     */
    public ControllerThematique(QcmServiceInterface qcmServiceInterface , User currentUser) {
        this.thematiqueView = new views.Thematique(this);
        this.qcmServiceInterface = qcmServiceInterface;
        this.handlerObjectInterface = new HandlerObject();
        current_id = currentUser.getId();

        try {

           // thematiqueList = qcmServiceInterface.getMyThemes(currentUser.getLevel());
            System.out.println("CURRENT ID USER "+current_id);
            thematiqueList = qcmServiceInterface.getLaunchedThematiques(currentUser.getLevel());
  //          List allThems =  qcmServiceInterface.getAllThematiques(currentUser.getLevel());

//            qcmServiceInterface.getNotLaunchedThematiques(allThems,thematiqueList);

        } catch (RemoteException e) {

            e.printStackTrace();

        }
        constructViewThematique(currentUser.getLevel());
    }

    /**
     * This method will construct the Thematique View with its values
     */
    public void constructViewThematique(int level){
        List thems ;
        thems = handlerObjectInterface.getThematiquesContent(thematiqueList);
        thematiqueView.constructorButtons(thems);
    }

    /**
     * this Temporary Method will change the view when anyButton is clicked
     */
    public void changeView(String content) {


        closeThematiqueView();

        try {

            int id = qcmServiceInterface.getIdThematiqueByContent(content);
            System.out.println("id thematique "+id);
            int idLastQcm = qcmServiceInterface.getMaxQcmByLevel(id);
            System.out.println(idLastQcm);
            boolean done = qcmServiceInterface.hasResponded(current_id , idLastQcm);
            System.out.println("LAST ID QCM"+idLastQcm);

            if(done==false) {

                QCMInterface qcmInterface = new ControllerQCM(qcmServiceInterface, id, current_id);

            }else{

                FinQcmInterface finQcmInterface = new ControllerFinQcm(qcmServiceInterface,current_id,idLastQcm , done);

            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

    /**
     * Method that closes the actual view
     */
    public void closeThematiqueView() {
        this.thematiqueView.shutDown();
    }

}
