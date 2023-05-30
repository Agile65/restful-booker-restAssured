package com.restful.booker.model;

import java.util.HashMap;

public class BookingPojo {
    private String firstname;
    private String lastname;
    private long totalPrice;
    private boolean depositPaid;
    private String additionalNeeds;
    private HashMap<String,String> bookingdates;

    public HashMap<String,String> getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(HashMap<String,String> bookingdates) {
        this.bookingdates = bookingdates;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean isDepositPaid() {
        return depositPaid;
    }

    public void setDepositPaid(boolean depositPaid) {
        this.depositPaid = depositPaid;
    }

    public String getAdditionalNeeds() {
        return additionalNeeds;
    }

    public void setAdditionalNeeds(String additionalNeeds) {
        this.additionalNeeds = additionalNeeds;
    }
}
