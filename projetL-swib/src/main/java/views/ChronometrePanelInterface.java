package views;

/**
 * Created by amineboufatah on 29/11/14.
 */
public interface ChronometrePanelInterface {

    /**
     * Method that will set the time left
     * @param tempsRestant
     */
    void setTempsRestant(int tempsRestant);

    /**
     * Method that sets the visibility of the view
     * @param visibility
     */
    void setVisibility(boolean visibility);

    /**
     * Method that refreshes the View
     */
    void refresh();
}
