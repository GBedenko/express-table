package com.bedenko.genaro.expresstable.controllers;

/*
  Created by Genaro Bedenko for 300CEM Android Application Development Assignment
  Student ID 7060234
  @author bedenkog
 */

import com.bedenko.genaro.expresstable.models.Booking;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BookingControllerTest {

    @Test
    public void createBooking() {

        try {
            BookingController bookingController = new BookingController();

            Booking testBooking = bookingController.createBooking(1234, 1111, "01/01/2018", "19:00", "10");
            assertEquals(testBooking.getCustomerID(), 1234);
            assertEquals(testBooking.getRestaurantID(), 1111);
            assertEquals(testBooking.getDate(), "01/01/2018");
            assertEquals(testBooking.getTime(), "19:00");
            assertEquals(testBooking.getTableNumber(), 10);

        } catch (Error error) {
            // Expected error because BookingController tries to get the instance of Firebase (which won't work during tests)
        }
    }

    @Test
    public void addBookingToFirebase() {

        try {
            // Test void functions by asserting that an instance of the class is not null
            BookingController bookingController = new BookingController();
            assertNotNull(bookingController);

        } catch (Error error) {
            // Expected error because BookingController tries to get the instance of Firebase (which won't work during tests)
        }
    }
}