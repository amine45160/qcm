package dao;

import dao.data.ConnectivityData;
import dao.data.CreateDataBase;
import dao.data.HandlerDataBase;
import dao.data.ICreateDataBase;
import modele.User;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by amineboufatah on 05/12/14.
 */
public class UserDAO extends ConnectivityData implements IUsersDAO {


   private static UserDAO userDaoInstance ;
   private Connection connection ;
   private PreparedStatement preparedStatement ;
    private static List<User> users = testing();

    private static List<User> testing() {
        User user = new User(1,"Alberto","Milano","etudiantl1","etudiant1@etu.fr");
        User user2 = new User(2,"Aminos","Milano","etudiantl2","etudiant1@etu.fr");
        User user3 = new User(1,"Alberto","Milano","etudiantl11","etudiant1@etu.fr");
        List<User> userList = new ArrayList<User>();
        userList.add(user);
        userList.add(user2);
        userList.add(user3);
        return userList;

    }

    public User logIn(String a , String b){
        for(int i = 0 ; i<users.size() ; i++){
            if(users.get(i).getIdentifiant().equals(a) && users.get(i).getPassword().equals(b)){
                return users.get(i);
            }
        }
        return null;
    }

    /**
     * Private Constructor
     */
    private UserDAO(){
        connection = super.getConnection();
    }

    /**
     * return an instance of the userDAO
     * @return UserDAO
     */
    public static UserDAO getInstance(){

        if(userDaoInstance==null)
        {
            userDaoInstance = new UserDAO();
        }
        return userDaoInstance;
    }


    /**
     * Method that returns a User by identifiant/password
     * @param identifiant
     * @param password
     * @return User
     */
    public User getUserByInfo(String identifiant, String password) {
        int cp = 0 , idUser = 0 ;
        ResultSet resultSet  ;
        String nom = null, prenom = null , mdp = null ;
        String ident = null;
        int level = 0 ;
        User userLog = new User();

        ICreateDataBase cr = new CreateDataBase();

        try {
          cr = CreateDataBase.getInstance();
          cr.truncate();
          //HandlerDataBase.startApp();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String query = "SELECT * FROM QUESTIONNAIRES.ETUDIANT natural join QUESTIONNAIRES.UTILISATEUR WHERE identifiantEtudiant = ? AND motDePasse = ? " ;

        try {

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1 , identifiant);
            preparedStatement.setString(2 , password);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

            cp++;
            idUser = resultSet.getInt("idUtilisateurEt");
            ident = resultSet.getString("identifiantEtudiant");
            nom = resultSet.getString("nomUtilisateur");
            prenom = resultSet.getString("prenomUtilisateur");
            mdp = resultSet.getString("motDePasse");
            level = resultSet.getInt("idFormation");

            }

            if (cp>0){
                userLog.setNom(nom);
                userLog.setId(idUser);
                userLog.setPrenom(prenom);
                userLog.setLevel(level);
                userLog.setPassword(mdp);
                userLog.setIdentifiant(ident);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
            return userLog;

    }


    /**
     * This method adds the user to the DB
     * @param nom
     * @param prenom
     * @param mdp
     * @param level
     */
    public void addUser (String nom , String prenom , String mdp , int level){

        String query = "INSERT INTO QUESTIONNAIRES.UTILISATEUR (nomUtilisateur , prenomUtilisateur , motDePasse , idFormation) values (? , ? , ? , ?) ;";

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1 , nom);
            preparedStatement.setString(2 , prenom);
            preparedStatement.setString(3 , mdp);
            preparedStatement.setInt(4, level);
            preparedStatement.executeUpdate();
        }

        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * This method adds an Enseignant to the DB
     * @param identifiant
     */
    public void addEnseignant ( String identifiant){
        int id = getLastUserAdded();
        String query = "INSERT INTO QUESTIONNAIRES.ENSEIGNANT (idUtilisateurEn,identifiantEnseignant) VALUES ( ? , ? ) " ;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, identifiant);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method adds a Student to the DB
     * @param identifiant
     */
    public void addEtudiant( String identifiant){
        int id = getLastUserAdded();

        String query = "INSERT INTO QUESTIONNAIRES.ETUDIANT (idUtilisateurEt , identifiantEtudiant) " +
                " VALUES ( ? , ? );";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1 , id);
            preparedStatement.setString(2 , identifiant);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method returns the last User that has been added to the DATABASE
     * @return int
     */
    public int getLastUserAdded(){
        String query = "SELECT MAX(idUtilisateur) FROM Questionnaires.Utilisateur";
        Statement statement ;
        ResultSet resultSet ;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                System.out.println("LE DERNIER USER ADDED "+resultSet.getInt(1));
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1 ;
    }

    /**
     * Gets the Last Enseignant Id
     * @return int
     */
    public int getMax(){
        PreparedStatement preparedStatement1 ;
        connection = super.getConnection();
        String query = "SELECT MAX(idUtilisateurEn) from Questionnaires.Enseignant";
        ResultSet resultSet ;
        try {
            preparedStatement1 = connection.prepareStatement(query);
            resultSet = preparedStatement1.executeQuery();
            while(resultSet.next()){
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1 ;
    }


    /**
     * Gets the Id User According to it name
     * @param content
     * @return int
     */
    public int getIdUserByName(String content){
        String query = "SELECT idUtilisateur FROM Questionnaires.Utilisateur where nomUtilisateur ='"+content+"'";
        ResultSet resultSet;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
