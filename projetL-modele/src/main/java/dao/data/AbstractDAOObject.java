package dao.data;


import dao.data.CreateDataBase;
import dao.data.ICreateDataBase;

import java.sql.SQLException;


public class AbstractDAOObject {

        ICreateDataBase bd;

    public AbstractDAOObject() throws SQLException {
        bd= CreateDataBase.getInstance();
    }

    public ICreateDataBase getBd() {
        return bd;
    }

    public void setBd(ICreateDataBase bd) {
        this.bd = bd;
    }


}
