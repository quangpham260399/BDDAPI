package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;


import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class GetaAndPostExamples {
    @Test
    public void testGetaAndPost(){
        baseURI = "https://reqres.in/api";
        given()
                .get("/users?page=2")
                .then()
                .statusCode(200)
                .body("data[2].first_name", equalTo("Tobias"))
                .body("data.first_name", hasItems("Michael","George","Lindsay","Byron"));
    }
    @Test
    public void testPost(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "morpheus");
        map.put("job", "leader");

        System.out.println(map);

        JSONObject request = new JSONObject(map);
        System.out.println(request.toJSONString());

        baseURI = "https://reqres.in/api";
        given()
                .body(request.toJSONString())
                .when()
                .post("/users");
    }
}
