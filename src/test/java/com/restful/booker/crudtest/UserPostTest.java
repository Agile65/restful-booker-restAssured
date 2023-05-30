package com.restful.booker.crudtest;

import com.restful.booker.model.BookingPojo;
import com.restful.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class UserPostTest extends TestBase {
    @Test
    public void createUser(){

        HashMap<String,String> checkInOutDatesData = new HashMap<String,String>();
        checkInOutDatesData.put("checkin","2018-01-01");
        checkInOutDatesData.put("checkout","2019-01-01");

        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname("Jim");
        bookingPojo.setLastname("Brown");
        bookingPojo.setTotalPrice(111);
        bookingPojo.setDepositPaid(true);
        bookingPojo.setBookingdates(checkInOutDatesData);
        bookingPojo.setAdditionalNeeds("Breakfast");

        Response response = given()
                .header("Content-Type","application/json")
                .header("Accept", "application/json")
                .body(bookingPojo)
                .when()
                .post("/booking");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
