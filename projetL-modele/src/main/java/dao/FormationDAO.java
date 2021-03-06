package dao;

import dao.data.ConnectivityData;


import java.sql.*;
import java.util.List;

/**
 * Created by amineboufatah on 23/12/14.
 */
public class FormationDAO extends ConnectivityData implements IFormationDAO{
    Statement statement ;
    PreparedStatement preparedStatement ;
    Connection connection ;
    private static FormationDAO formationDaoInstance ;



    /**
     * Private Constructor
     */
    private FormationDAO() {
        connection = super.getConnection();
    }

    /**
     * Returns an instance
     * @return FormationDAO
     */
    public static FormationDAO getInstance(){

        if(formationDaoInstance==null)
        {
            formationDaoInstance = new FormationDAO();
        }
        return formationDaoInstance;
    }

    /**
     * Method that adds formation
     * @param myInsertion
     */
    public void insertFormation(String myInsertion) {

        try {
            String query = "INSERT INTO Questionnaires.Formation (intituleFormation) VALUES ( ? );";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, myInsertion);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method that returns 1 if the Formation exists and 0 else
     * @return int
     */
    public int existFormations(){

        String query = "SELECT * FROM QUESTIONNAIRES.FORMATION;";
        ResultSet resultSet ;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
             return 1 ;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1 ;
    }

    /**
     * This method will return the formations id according to it content
     * @param content
     * @return
     */
    public int getIdFormationByContent(String content){
        String query = "SELECT idFormation FROM Questionnaires.Formation where intituleFormation = ?";
        ResultSet resultSet ;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1 , content);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1 ;
    }
}

