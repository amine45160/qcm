package controller;

import modele.*;
import modele_local.Chronometre;
import modele_local.ChronometreInterface;
import rmi.QcmServiceInterface;
import views.QcmView;
import views.QcmViewInterface;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by amineboufatah on 16/11/14.
 */
public class ControllerQCM implements QCMInterface {

    private QcmViewInterface qcmViewInterface ;
    private List<Question> questionsList ;
    private QcmServiceInterface service ;
    private ChronometreInterface chronometreInterface ;
    private static int position = 0 ;
    private int user_id ;


    /**
     * Constructor of the ControllerQCM
     */
    public ControllerQCM (QcmServiceInterface qcmServiceInterface , int thematique , int user_id){
        this.user_id = user_id;
        this.qcmViewInterface = new QcmView(this) ;
        this.service = qcmServiceInterface;

        try {

            //questionsList = service.getQCMbyTheme(thematique);
            questionsList = service.getQuestionsByThematique(thematique);

        } catch (RemoteException e) {
            e.printStackTrace();
        }

        displayNextQuestion();
    }

    /**
     * This method allows us to skip to the next question of the QCM
     */
    public void validerQuestion(String response) {
        Question currentQuestion = questionsList.get(position);
        int resp ;

        if(currentQuestion.isRightAnswer(response)){

            resp = 1 ;

        }else{

            resp = 0 ;

        }

        try {

            service.addScoreQuestion(user_id ,currentQuestion.getIdQcm(),currentQuestion.getIdQuestion(),resp);

        } catch (RemoteException e) {

            e.printStackTrace();
        }

        position++ ;

        if (position < questionsList.size()) {

            displayNextQuestion();

        }else{

            FinQcmInterface finQcmInterface = new ControllerFinQcm(service , user_id,questionsList.get(position-1).getIdQcm() ,false);
            this.closeQCMView();

        }
    }

    /**
     * This method will get the next question, then refreshes the view so the question
     * can be displayed with its values ( content , responses , time .. )
     */
    public void displayNextQuestion() {
        Question currentQuestion = questionsList.get(position);
        chronometreInterface  = new Chronometre(this);
        chronometreInterface.setTime(currentQuestion.getTime());
        chronometreInterface.initialiseChronometre();
        chronometreInterface.startChronometre();
        qcmViewInterface.newValues(currentQuestion.getContenuQuestion(), currentQuestion.getChoicesArray(),
                chronometreInterface.getChronometrePanel());
    }

    /**
     * This method closes the view
     */
    public void closeQCMView() {
       this.qcmViewInterface.shutDown();
    }

    /**
     * This method will order the view to stop the current Chronometre ( meaning stopping the Timer )
     */
    public void stopChronometre (){
        this.chronometreInterface.stopChronometre();
    }

    /**
     * This method will update the Chronometre with the new Value
     */
    public void updateChronometre() {
        this.qcmViewInterface.update();
    }
}
