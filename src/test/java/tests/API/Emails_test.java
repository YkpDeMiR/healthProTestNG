package tests.API;



import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import org.testng.Assert;
import utilities.ConfigReader;
import utilities.WriteToTxt;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static utilities.Authentication.generateToken;


public class Emails_test {

    //Kullanici Email bilgilerini Api ile dogrulayabilmeli.

    RequestSpecification spec;

    @Test
    public void emailTest() {//api/user
        spec=new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();
        spec.pathParams("1", "api", "2", "users","3","horacio.gerlach");
       Response response = given().spec(spec).headers("Authorization","Bearer " + generateToken()).when().get("{1}/{2}/{3}");
       response.prettyPeek();


        response.then().assertThat().body("email",equalTo("marlin.price@gmail.com"));
        response.then().assertThat().contentType(ContentType.JSON).statusCode(200);
        response.then().assertThat().headers("Pragma","no-cache","Content-Encoding","gzip");
    }

    @Test
    public void emailTest2() {
        spec=new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();
        spec.pathParams("1", "api", "2", "users","3","horacio.gerlach");
        Response response = given().spec(spec).headers("Authorization","Bearer " + generateToken()).when().get("{1}/{2}/{3}");
        response.prettyPeek();
        JsonPath jsonPath=response.jsonPath();
        Assert.assertEquals("marlin.price@gmail.com",jsonPath.getString("email"));

    }
}
