package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class First_Test {
    @Test
    public void test_1(){

        Response response = RestAssured.get("https://reqres.in/api/users?page=2");

        System.out.println(response.getStatusCode());
        System.out.println(response.getTime());
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeaders());

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    public void test_2(){
        RestAssured.baseURI = "https://reqres.in/api";
        given().
                get("/users?page=2")
                .then()
                .statusCode(200)
                .body("data[1].id", equalTo(8))
                .log().body();

    }
}
