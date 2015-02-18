package modele_local;

/**
 * Created by amineboufatah on 29/11/14.
 */
public class ValidationForm implements ValidationFormInterface {


    private static final int LENGTH_MIN_PASSWORD = 2;

    public boolean validateEmail(String email) {

       if (email != null && email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)"))
            {
                return true ;
            }
        else
        {
            return false;
        }
    }

    public boolean validatePassword(String password){

        if ( password != null && password.length() >= LENGTH_MIN_PASSWORD)
        {
            return true ;
        }
        else
        {
            return false;
        }
    }
}
