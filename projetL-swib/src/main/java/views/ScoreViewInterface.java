package views;

/**
 * Created by amineboufatah on 11/01/15.
 */
public interface ScoreViewInterface {

    /**
     * Sets the result on the view
     * @param result
     */
    public void setScore(String result);

    /**
     * Sets the rank on the view
     * @param classement
     */
    public void setClassement(String classement);

    /**
     * Sets total users on the view
     * @param classementTotal
     */
    public void setClassementTotal(String classementTotal);
}
