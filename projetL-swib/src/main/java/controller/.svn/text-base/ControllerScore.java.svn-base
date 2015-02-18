package controller;

import views.ScoreView;
import views.ScoreViewInterface;

public class ControllerScore implements ScoreInterface{

    private ScoreViewInterface scoreView;


    /**
     * Constructor
     */
    public ControllerScore(double mean, int classement , int totalClassement){
        scoreView = new ScoreView(this);
        displayResultOnView(mean , classement , totalClassement);
    }

    /**
     * This method will display the Result on the view
     * @param mean
     */
    public void displayResultOnView(double mean , int classement , int totalClassement){
        scoreView.setScore(String.valueOf(mean));
        scoreView.setClassement(String.valueOf(classement));
        scoreView.setClassementTotal(String.valueOf(totalClassement));
    }

}
