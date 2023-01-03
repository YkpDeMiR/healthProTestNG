package tests.API;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static utilities.Authentication.spec;


public class Authorization  {

    public  String getToken(){

        spec.pathParams("first","api","second","authenticate");

        Map<String,Object> postBodyToken=new HashMap<>();
        postBodyToken.put("username","Batch81");
        postBodyToken.put("rememberMe",true);
        postBodyToken.put("password","Batch81+");
      Response response= given().spec(spec).contentType(ContentType.JSON).body(postBodyToken).when().post("{first}/{second}");
        response.prettyPrint();
        return response.jsonPath().getString("id_token");

    }

    @Test
    public void name() {
        getToken();
    }
}
