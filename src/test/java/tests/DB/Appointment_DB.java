package tests.DB;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.internal.RestAssuredResponseImpl;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.Appointment;
import pojos.AppointmentRequest;
import utilities.*;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import static io.restassured.RestAssured.given;
import static utilities.Authentication.generateToken;

public class Appointment_DB {

    Response response =new RestAssuredResponseImpl();
    AppointmentRequest request=new AppointmentRequest();

    @Test
    public void testName() throws IOException, SQLException {

// create with API and validate with JDBC used pojo

        request.setEmail("emir@qmail.com");
        request.setFirstName("emir");
        request.setLastName("ihsan");
        request.setSsn("333-02-2233");
        String tomorrow = DateUtil.todaysDate5();
        request.setStartDate(tomorrow);
        RequestSpecification spec =new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();
        spec.pathParams("1","api","2","appointments","3","request");
        response =  given().spec(spec).headers("Authorization","Bearer " + generateToken()).contentType(ContentType.JSON).body(request).when().post("{1}/{2}/{3}");
        response.prettyPrint();
        ObjectMapper obj =new ObjectMapper();


        DBUtils.createConnection();
       //DBUtils.executeQuery("select * from \"public\".appointment where id=4671");
      // ResultSet anAppointment = DBUtils.getResultset();
       List<Object> emirin_allappointment = DBUtils.getColumnData("select * from \"public\".appointment where patient_id=4861","id");


        // Appointment actualData = response.as(Appointment.class);
        Appointment actualData = obj.readValue(response.asString(),Appointment.class);
        //anAppointment.next();
        Assert.assertTrue(emirin_allappointment.toString().contains(String.valueOf(actualData.getId())));

    }

    @Test
    public void testAppointment() {

        DBUtils.createConnection();

        DBUtils.getResultset();

       List<List<Object>> allAppointment = DBUtils.getQueryResultList("select * from \"public\".appointment");
       for (Object w:allAppointment){
          // System.out.println(w);
       }
        WriteToTxt.saveAllObjectList("src/test/java/data/allPointments", Collections.singletonList(allAppointment));

      List<Object> appointmentIds = DBUtils.getColumnData("select * from \"public\".appointment where patient_id=3357","id");

     List<Object> allAppointmentIds = DBUtils.getColumnData("select * from \"public\".appointment","id");

     assert allAppointmentIds.containsAll(appointmentIds);



    }
}
