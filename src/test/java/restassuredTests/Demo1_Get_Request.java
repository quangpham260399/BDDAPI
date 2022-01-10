package restassuredTests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Demo1_Get_Request {
    @Test
    public void getValidation(){
        given()

        .when()
                .get("https://reqres.in/api/users/2")
        .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .assertThat().body("data.email", equalTo("janet.weaver@reqres.in"))
                .header("Content-Type","application/json; charset=utf-8");
    }
}
