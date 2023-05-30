package com.restful.booker.crudtest;

import com.restful.booker.model.BookingPojo;
import com.restful.booker.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class UserPatchTest extends TestBase {

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        RestAssured.basePath = "/booking";
    }

    @Test
    public void updateUserWithPatch(){
        HashMap<String,String> checkInOutDatesData=new HashMap<String,String>();
        checkInOutDatesData.put("checkin","2018-01-01");
        checkInOutDatesData.put("checkout","2019-01-01");
        BookingPojo bookingPojo=new BookingPojo();
        bookingPojo.setFirstname("Ramakant");

        Response response=given()
                .header("Content-Type","application/json")
                .auth().preemptive().basic("admin","password123")
                .body(bookingPojo)
                .pathParams("id",617)
                .when()
                .put("/{id}");
        response.prettyPrint();
        response.then().statusCode(200);
    }
}
