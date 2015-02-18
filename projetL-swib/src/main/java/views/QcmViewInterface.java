package views;

/**
 * Created by amineboufatah on 29/11/14.
 */
public interface QcmViewInterface {
    /**
     * Method that shuts down the View
     */
    void shutDown();

    /**
     * Method that updates the View
     */
    void update();

    /**
     * Method that catches the new values ( Question , responses ..) that will be displayed in the view
     * @param question
     * @param choices
     * @param chrono
     */
    void newValues(String question , String [] choices , ChronometrePanel chrono);

    /**
     * Method that displays the user name on the view
     * @param name
     */
    public void setUserInfo(String name);
}
