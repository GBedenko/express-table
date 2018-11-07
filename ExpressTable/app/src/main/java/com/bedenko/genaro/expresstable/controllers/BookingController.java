package com.bedenko.genaro.expresstable.controllers;

import com.bedenko.genaro.expresstable.models.Booking;
import com.bedenko.genaro.expresstable.persistence.BookingRepo;

public class BookingController {

    BookingRepo bookingRepo = new BookingRepo();

    public Booking createBooking(int aCustomerID, int aRestaurantID, String aDate, String aTime, int aTableNumber) {

        Booking booking = new Booking();

        booking.setCustomerID(aCustomerID);
        booking.setRestaurantID(aRestaurantID);
        booking.setDate(aDate);
        booking.setTime(aTime);
        booking.setTableNumber(aTableNumber);

        // Function calls to write to database persistence
        // bookingRepo.write(booking);

        return(booking);
    }
}
