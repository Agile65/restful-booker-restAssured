package com.restful.booker.crudtest;

import com.restful.booker.model.BookingPojo;
import com.restful.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class UserPutTest extends TestBase {
    @Test
    public void updateUserWithPut(){
        HashMap<String,String> checkInOutDatesData = new HashMap<String,String>();
        checkInOutDatesData.put("checkin", "2018-01-01");
        checkInOutDatesData.put("checkout", "2019-01-01");
        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname("Jimmy");
        bookingPojo.setLastname("Brown");
        bookingPojo.setTotalPrice(111);
        bookingPojo.setDepositPaid(true);
        bookingPojo.setBookingdates(checkInOutDatesData);
        bookingPojo.setAdditionalNeeds("Veg");

        Response response = given()
                .header("Content-Type","application/json")
                .auth().preemptive().basic("admin","password123")
                .body(bookingPojo)
                .pathParam("id",1512)
                .when()
                .put("/{id}");
        response.prettyPrint();
        response.then().statusCode(200);

    }
}
