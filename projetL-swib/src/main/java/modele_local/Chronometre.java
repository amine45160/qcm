package modele_local;

import controller.QCMInterface;
import views.ChronometrePanel;
import views.ChronometrePanelInterface;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by amineboufatah on 28/11/14.
 */
public class Chronometre implements ChronometreInterface {

    private int time ;
    private Timer myTimer;

    private ChronometrePanel chronometrePanel ;
    private QCMInterface qcmInterface ;
    private ChronometrePanelInterface chronometrePanelInterface;

    private static final String NO_VALIDATION_DONE = " _NONE_" ;

    /**
     * Constructor
     * @param qcmInterface
     */
    public Chronometre(QCMInterface qcmInterface){
        this.qcmInterface = qcmInterface ;
    }

    /**
     * Method will initialise the Chronometre
     */
    public void initialiseChronometre(){
        myTimer = createTimer();

        chronometrePanel = new ChronometrePanel(time);
       // chronometrePanelInterface = new ChronometrePanel(time);
    }

    /**
     * This method will start the Chronometre
     */
    public void startChronometre(){
        myTimer.start();
        chronometrePanel.setVisibility(true);
        chronometrePanel.refresh();
//        chronometrePanelInterface.setVisibility(true);
  //      chronometrePanelInterface.refresh();
    }

    /**
     * Getter ChronometrePanel
     * @return ChronometrePanel
     */
    public ChronometrePanel getChronometrePanel() {
        return chronometrePanel;
    }

    /**
     * Creates Timer
     * @return Timer
     */
    public Timer createTimer(){
        ActionListener action = new ActionListener (){
            public void actionPerformed (ActionEvent event){
                if(time>0)
                {
                    time--;
                 chronometrePanel.setTempsRestant(time);
                    chronometrePanel.refresh();
       //               chronometrePanelInterface.setTempsRestant(time);
         //             chronometrePanelInterface.refresh();
                }
                else
                {
                    myTimer.stop();
                    chronometrePanel.setVisibility(false);
                    qcmInterface.validerQuestion(NO_VALIDATION_DONE);
                    //chronometrePanelInterface.setVisibility(false);
                    //qcmInterface.validerQuestion(NO_VALIDATION_DONE);
                }
            }
        };
        return new Timer (1000, action);
    }

    /**
     * Setter Time
     * @param time
     */
    public void setTime(int time) {
        this.time = time;
    }

    /**
     * This method will stop the chronometre
     */
    public void stopChronometre() {
        this.myTimer.stop();
    }

    /**
     * Getter for ChronometrePanelInterface
     * @return ChronometrePanelInterface
     */
    public ChronometrePanelInterface getChronometrePanelInterface() {
        return chronometrePanelInterface;
    }
}
