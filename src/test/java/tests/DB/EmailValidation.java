package tests.DB;

import org.testng.annotations.Test;
import utilities.DBUtils;
import utilities.TXTReader;
import utilities.WriteToTxt;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmailValidation {

    @Test
    public void testEmailValidate() throws SQLException {
        //Registration should be successful using email and username and validate them with Backend (API and DB)
        DBUtils.createConnection();
        /* 1. yol
        DBUtils.executeQuery("select email from \"public\".jhi_user");
     ResultSet rs = DBUtils.getResultset();
        List<Object> allEmails=new ArrayList<>();
     while (rs.next()){
        allEmails.add(rs.getObject(1)) ;
        //System.out.println(rs.getObject(1));

         */
                //2.yol
       List<Object> emailler = DBUtils.getColumnData("select * from \"public\".jhi_user","email");
        //System.out.println(emailler);
        //WriteToTxt.saveAllObjectList("src/test/java/data/allemails",emailler);
       List<Object> birId = DBUtils.getColumnData("select * from \"public\".jhi_user where id=3334" ,"email");
        System.out.println("birId = " + birId.toString());
        // assert TXTReader.readFileElementExist("src/test/java/data/allemails", "walter.kris@yahoo.com");
      assert TXTReader.readFileElementExist("src/test/java/data/allemails", birId.get(0).toString());
    }


    }

