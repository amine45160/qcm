package controller;


/**
 * Created by amineboufatah on 16/11/14.
 */
public interface QCMInterface {
    /**
     * This method allows us to skip to the next question of the QCM
     */
    void validerQuestion(String response) ;

    /**
     * This method will get the next question, then refreshes the view so the question
     * can be displayed
     */
    void displayNextQuestion();

    /**
     * This method is called when there's no more question to be displayed on the View
     */
    void closeQCMView();

    /**
     * This method will stop the chronometre
     */
    void stopChronometre();

    /**
     * This method will update the chronometre
     */
    void updateChronometre();
}
