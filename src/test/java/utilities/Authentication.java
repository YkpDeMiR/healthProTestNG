package utilities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;


public class Authentication {
    public static RequestSpecification spec;
    public static String generateToken(){
    // set the base url and pathParams
        spec=new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();
        spec.pathParams("first","api","second","authenticate");

    // set the expected data
        Map<String,Object> expectedData=new HashMap<>();
        expectedData.put("password","Batch81+");
        expectedData.put("rememberMe",true);
        expectedData.put("username","Batch81");

        // "password": "Batch81+",
        //    "rememberMe": true,
        //    "username": "Batch81"

        // send the request & get the response
        Response response= given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}/{second}");
        response.prettyPrint();
        JsonPath json=response.jsonPath();
        return json.getString("id_token");
    }
    public static String generateTokenWithUsernamePassword(String username,String password) {

        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        map.put("password", password);
        map.put("rememberMe", "true");

        String endPoint = "https://www.medunna.com/api/authenticate";

        Response response1 = given().contentType(ContentType.JSON).body(map).when().post(endPoint);

        JsonPath token = response1.jsonPath();

        return token.getString("id_token");
    }
}
