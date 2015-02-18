package modele_local;

/**
 * Created by amineboufatah on 29/11/14.
 */
public interface ValidationFormInterface {
    /**
     * This method will test whether the email entered is valide or not
     * @param email
     * @return boolean
     */
    boolean validateEmail(String email);

    /**
     * This method will test whether the password entered is valide or not
     * @param password
     * @return
     */
    boolean validatePassword(String password);
}
