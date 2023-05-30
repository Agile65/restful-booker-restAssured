package com.restful.booker.crudtest;

import com.restful.booker.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserDeleteTest extends TestBase {

    String token = "99a320f95569095";
    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        RestAssured.basePath = "/booking";
    }

    @Test
    public void deleteUser() {
        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .auth().preemptive().basic("admin", "password123")
                .pathParam("id", 104)
                .when()
                .delete("/booking/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
