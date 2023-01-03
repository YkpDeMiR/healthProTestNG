package tests.DB;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DBUtils;

import java.util.Map;

public class Patient_DB {

    @Test
    public void testPatient() {

        DBUtils.createConnection();

      Map<String,Object> hasta =DBUtils.getRowMap("select * from \"public\".patient where id=4862");
        //System.out.println(hasta);

        for (Object w: hasta.values()){
            System.out.println(w);
        }
        System.out.println(hasta.containsValue("Omer"));
        Assert.assertEquals(hasta.get("email"),"elroy.mitchell@gmail.com");


    }
}
