package controller;


import modele.Score;
import modele_traitement.HandlerObject;
import rmi.QcmServiceInterface;
import views.FinQcmView;

import java.rmi.RemoteException;
import java.util.List;

public class ControllerFinQcm implements FinQcmInterface{

   private FinQcmView finQcmView ;
   private QcmServiceInterface qcmServiceInterface ;
   private double mean ;
   private int position ;
   private int totalUsers;


    /**
     * Constructor ControllerFinQcm
      */
   public ControllerFinQcm(QcmServiceInterface qcmServiceInterface ,int idUser , int idQcm , boolean responded){
       finQcmView= new FinQcmView(this);
       this.qcmServiceInterface = qcmServiceInterface;
       getsUserResults(idQcm , idUser , responded);
   }

    /**
     * Method that gets the Users Results
     * @param idQcm
     * @param idUser
     * @param responded
     */
    public void getsUserResults(int idQcm , int idUser , boolean responded) {
        try {
            List <Score> scoreList = qcmServiceInterface.getScoreByQcm(idQcm , idUser);

            HandlerObject handler = new HandlerObject();
            mean = handler.getMeanQcm(scoreList);
            int idSession = qcmServiceInterface.getIdSessionByQcm(idQcm);

            if(!responded) {

                qcmServiceInterface.addQcmResult(idSession, idUser, mean);

            }

            List<Integer> list = qcmServiceInterface.getFinalResultQcm(idSession);
            position = handler.getClassement(list , idUser);
            totalUsers = list.size();
            finQcmView.enableButton();

        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method will redirect to another View after loading score
     */
    public void redirect(){
        ScoreInterface scoreView =new ControllerScore(mean , position , totalUsers);
        this.closeQCMView();
    }
    /**
     * This method closes the view
     */
    public void closeQCMView() {
        this.finQcmView.shutDown();
    }

}
