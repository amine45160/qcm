package dao.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by amineboufatah on 26/12/14.
 */
public class ConnectivityData implements DAO {

    Connection connection ;

    private final String PATH_DRIVER = "org.h2.Driver" ;
    private final String PATH_MANAGER = "jdbc:h2:src/db/ProjectLDataBase" ;
    private final String USERNAME_DB = "admin" ;
    private final String USERPASS_DB = "admin" ;

    /**
     * This method return the Connection to the DB that will be used for queries
     * @return Connection
     */
    public Connection getConnection() {
        if(connection == null){
            try {
                Class.forName(PATH_DRIVER);
                connection = DriverManager.getConnection(PATH_MANAGER, USERNAME_DB, USERPASS_DB);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                System.err.println("La connection à la BDD a échoué !");
                e.printStackTrace();
            }
        }
        return connection ;
    }
}
