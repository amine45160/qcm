package dao;

import modele.User;

/**
 * Created by amineboufatah on 05/12/14.
 */
public interface IUsersDAO {

    /**
     * This method allows to gets the user from the DB using their identifiant and password
     * @param identifiant
     * @param password
     * @return User
     */
    User getUserByInfo(String identifiant , String password) ;

    /**
     * This method adds a Student to the DB
     * @param identifiant
     */
    public void addEtudiant( String identifiant);

    /**
     * This method adds an Enseignant to the DB
     * @param identifiant
     */
    public void addEnseignant ( String identifiant);


    /**
     * This method adds the user to the DB
     * @param nom
     * @param prenom
     * @param mdp
     * @param level
     */
    public void addUser (String nom , String prenom , String mdp , int level);

    /**
     * Gets the Id User According to it name
     * @param content
     * @return int
     */
    public int getIdUserByName(String content);
    }
