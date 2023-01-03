package tests.API;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import pojos.Patient;
import utilities.ConfigReader;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static utilities.Authentication.generateToken;

public class Patient_API {

    Patient[] allpatient;


    @Test
    public void testPatient() throws IOException {

        RequestSpecification spec=new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();
        spec.pathParams("1","api","2","in-patients");

       Response response = given().spec(spec).headers("Authorization","Bearer " + generateToken()).contentType(ContentType.JSON).when().get("{1}/{2}");
       // response.prettyPrint();

        ObjectMapper obj = new ObjectMapper();
     // allpatient =  response.as(Patient[].class);

        response.then().assertThat().contentType(ContentType.JSON).statusCode(200);

    }
}
