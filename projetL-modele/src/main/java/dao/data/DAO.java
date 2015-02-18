package dao.data;

import java.sql.Connection;

/**
 * Created by amineboufatah on 27/12/14.
 */
public interface DAO {

    /**
     * Method returns the Connection to the DB
     * @return Connection
     */
    public Connection getConnection();

}
