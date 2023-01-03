package dataProviders;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvider1 {


    @DataProvider
    public  Object[][] invalidSsnLength(){

        Object[][] employeeCredentials = {
                {"123-23-12345"},
                {"123-23-123"},
                {"123-23-523"},
                {"123-23-12306"}
        };
        return employeeCredentials;
    }

    @Test(dataProvider = "invalidSsnLength")
    public void employeeLogin(String username){
        System.out.println(username);
    }

}
