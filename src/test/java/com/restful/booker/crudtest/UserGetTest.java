package com.restful.booker.crudtest;

import com.restful.booker.testbase.TestBase;
import org.junit.Test;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserGetTest extends TestBase {


    @Test
    public void getAllUserInfo(){

        Response response = given()
                .when()
                .get();
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getSingleUserInfo() {

        Response response = given()
                .pathParam("id", 617)
                .when()
                .get("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
