package dao;

import dao.data.ConnectivityData;
import modele.Score;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by amineboufatah on 09/01/15.
 */
public class ResultDAO extends ConnectivityData implements IResultDAO {

    Connection connection ;
    private static ResultDAO resultDaoInstance ;
    PreparedStatement preparedStatement ;

    /**
     * Private Constructor
     */
    private ResultDAO () {
        connection = super.getConnection();
    }

    /**
     * gives the instance of the DAO
     * @return ResultDAO
     */
    public static ResultDAO getInstance(){
        if(resultDaoInstance==null)
        {
            resultDaoInstance = new ResultDAO();
        }
        return resultDaoInstance;
    }

    /**
     * This method adds answer of the user
     * @param idEtudiant
     * @param idQcm
     * @param idQuestion
     * @param answer
     */
    public void addScoreQuestion(int idEtudiant , int idQcm , int idQuestion , int answer){
        String query = "INSERT INTO Questionnaires.Score(idUtilisateurEt,idQcm,idQuestion,goodAnswer) VALUES(?," +
                "? , ? , ? );";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,idEtudiant);
            preparedStatement.setInt(2,idQcm);
            preparedStatement.setInt(3,idQuestion);
            preparedStatement.setInt(4,answer);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * Gets the result for each Question By IdQcm
     * @param idQcm
     * @param idUser
     * @return
     */
    public List<Score> getScoreByQcm(int idQcm , int idUser){
        String query = "SELECT * FROM Questionnaires.Score where idUtilisateurEt=? and idQcm =? ;";
        ResultSet resultSet ;
        List<Score> scoreList = new ArrayList<Score>();
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,idUser);
            preparedStatement.setInt(2,idQcm);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int idQuestion = resultSet.getInt("idQuestion");
                int response = resultSet.getInt("goodAnswer");
                Score score = new Score(idQcm,idUser,idQuestion,response);
                scoreList.add(score);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scoreList;
    }

    /**
     * Gets the IdSession By Qcm
     * @param idQcm
     * @return int
     */
    public int getIdSessionByQcm(int idQcm){
        String query = "SELECT idSessionQCM from Questionnaires.SessionQCM where idQcm = ?";
        ResultSet resultSet;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,idQcm);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                return resultSet.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1 ;
    }

    /**
     * Method that adds the users final result to the DB
     * @param idSession
     * @param idUser
     * @param resultat
     */
    public void addQcmResult(int idSession , int idUser , double resultat){
        String query = "INSERT INTO Questionnaires.ResultatSessionQCM(idSessionQCM , idUtilisateurEt , resultat) VALUES ( ? , ? , ? );";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,idSession);
            preparedStatement.setInt(2,idUser);
            preparedStatement.setDouble(3,resultat);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets UsersId order by Resultat
     * @param idQcm
     * @return List
     */
    public List<Integer> getFinalResultQcm(int idQcm){
        String query = "SELECT * FROM Questionnaires.ResultatSessionQCM where idSessionQCM ='"+idQcm+"' order by resultat desc";
        ResultSet resultSet;
        Statement statement ;
        List<Integer> list = new ArrayList<Integer>();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()){
             list.add(resultSet.getInt("idUtilisateurEt"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
