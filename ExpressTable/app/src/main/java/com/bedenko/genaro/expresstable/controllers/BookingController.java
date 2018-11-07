package com.bedenko.genaro.expresstable.controllers;

import com.bedenko.genaro.expresstable.models.Booking;

public class BookingController {

    public Booking createBooking(int aCustomerID, int aRestaurantID, String aDate, String aTime, int aTableNumber) {

        Booking booking = new Booking();

        // Set values for what a booking will store
        // booking.setCustomerID(aCustomerID);
        // Rest to follow

        return(booking);
    }
}
