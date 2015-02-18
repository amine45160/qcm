package views;

/**
 * Created by amineboufatah on 29/11/14.
 */
public interface ConnexionViewInterface {

    /**
     * This method will shut down the view
     */
    void shutDown();

    /**
     * This method will display the errors on the Connexion View
     */
    void displayError(String error);
}
