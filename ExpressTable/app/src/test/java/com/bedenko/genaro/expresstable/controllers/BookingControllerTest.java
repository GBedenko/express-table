package com.bedenko.genaro.expresstable.controllers;

import com.bedenko.genaro.expresstable.models.Booking;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookingControllerTest {

    @Test
    public void createBooking() {

        BookingController bookingController = new BookingController();

        Booking testBooking = bookingController.createBooking(1234, 1111, "01/01/2018", "19:00", 10);
        assertEquals(testBooking.getCustomerID(), 1234);
        assertEquals(testBooking.getRestaurantID(), 1111);
        assertEquals(testBooking.getDate(), "01/01/2018");
        assertEquals(testBooking.getTime(), "19:00");
        assertEquals(testBooking.getTableNumber(), 10);
    }
}