package tests.DB;

import org.testng.annotations.Test;
import utilities.DBUtils;


import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;


public class RegistrantValidation {

    //Registration should be available using SSN, Firstname and Lastname
    //There should be api and DB validation


    @Test
    public void testUser() throws SQLException {

        DBUtils.createConnection();
        DBUtils.executeQuery("select * from \"public\".jhi_user where id=3334");
        ResultSet rs = DBUtils.getResultset();

        List<Object> ssn = DBUtils.getColumnData("select * from \"public\".jhi_user", "ssn");
        List<Object> first_name = DBUtils.getColumnData("select * from \"public\".jhi_user", "first_name");
        List<Object> last_name = DBUtils.getColumnData("select * from \"public\".jhi_user", "last_name");
        rs.next();
        assert ssn.contains(rs.getObject("ssn"));
        assert first_name.contains(rs.getObject("first_name"));
        assert last_name.contains(rs.getObject("last_name"));


        DBUtils.closeConnection();
    }


}