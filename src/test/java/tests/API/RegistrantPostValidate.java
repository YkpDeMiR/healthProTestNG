package tests.API;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.Registrant;
import pojos.User;
import utilities.ConfigReader;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static utilities.Authentication.generateToken;

public class RegistrantPostValidate {

    RequestSpecification spec;
    Response response;
    Registrant registrantPostBody =new Registrant();
    @Test
    public void testPost() throws IOException {
        spec=new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();
        spec.pathParams("1","api","2","users");

        registrantPostBody.setEmail("dfhhhk6t123@gmail.com");
        registrantPostBody.setLastName("romedo");
        registrantPostBody.setSsn("453-67-7564");
        registrantPostBody.setFirstName("pukayo");
        registrantPostBody.setActivated(true);
        registrantPostBody.setLogin("sallatoresso");
        registrantPostBody.setCreatedDate("2022-12-28T21:57:14.512Z");

      response = given().spec(spec).headers("Authorization","Bearer " + generateToken())
                .contentType(ContentType.JSON).body(registrantPostBody).when().post("{1}/{2}");
      response.prettyPrint();

    }

    @Test(dependsOnMethods = "testPost")
    public void testValidate() throws IOException {

        ObjectMapper obj =new ObjectMapper();
        User actualData =  obj.readValue(response.asString(),User.class);

        Assert.assertEquals(actualData.getEmail(),registrantPostBody.getEmail());
        Assert.assertEquals(actualData.getFirstName(),registrantPostBody.getFirstName());
        Assert.assertEquals(actualData.getLastName(),registrantPostBody.getLastName());

    }
}
