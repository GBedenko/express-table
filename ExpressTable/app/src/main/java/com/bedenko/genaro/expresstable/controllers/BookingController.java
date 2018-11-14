package com.bedenko.genaro.expresstable.controllers;

import com.bedenko.genaro.expresstable.models.Booking;

public class BookingController {

    public Booking createBooking(int aCustomerID, int aRestaurantID, String aDate, String aTime, int aTableNumber) {

        Booking booking = new Booking();

        booking.setCustomerID(aCustomerID);
        booking.setRestaurantID(aRestaurantID);
        booking.setDate(aDate);
        booking.setTime(aTime);
        booking.setTableNumber(aTableNumber);

        return(booking);
    }

}