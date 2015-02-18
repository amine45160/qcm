package dao;

/**
 * Created by amineboufatah on 11/01/15.
 */
public interface IFormationDAO {

    /**
     * Method that adds formation
     * @param myInsertion
     */
    public void insertFormation(String myInsertion);

    /**
     * This method will return the formations id according to it content
     * @param content
     * @return
     */
    public int getIdFormationByContent(String content);
}
