package tests.API;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.App;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.internal.RestAssuredResponseImpl;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.Appointment;
import pojos.AppointmentRequest;
import utilities.ConfigReader;
import utilities.DateUtil;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static utilities.Authentication.generateToken;

public class AppointmentTest {

    Response response =new RestAssuredResponseImpl();
    AppointmentRequest request=new AppointmentRequest();
    @Test
    public void testAppointment() throws IOException {



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


    }

    @Test(dependsOnMethods = "testAppointment")
    public void testValidate() throws IOException {
        ObjectMapper obj =new ObjectMapper();
       // Appointment actualData = response.as(Appointment.class);
        Appointment actualData = obj.readValue(response.asString(),Appointment.class);
        Assert.assertEquals(actualData.getPatient().firstName,request.getFirstName());
    }

}
