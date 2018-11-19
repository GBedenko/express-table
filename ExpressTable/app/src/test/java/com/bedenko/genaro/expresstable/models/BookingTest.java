package com.bedenko.genaro.expresstable.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookingTest {

    @Test
    public void getBookingID() {
        Booking booking = new Booking(1234, 1111, 2222, "01/01/2018", "19:00", 10);
        assertEquals(booking.getBookingID(), 1234);
    }

    @Test
    public void setBookingID() {
        Booking booking = new Booking(1234, 1111, 2222, "01/01/2018", "19:00", 10);
        booking.setBookingID(4321);
        assertEquals(booking.getBookingID(), 4321);
    }

    @Test
    public void getCustomerID() {
        Booking booking = new Booking(1234, 1111, 2222, "01/01/2018", "19:00", 10);
        assertEquals(booking.getCustomerID(), 1111);
    }

    @Test
    public void setCustomerID() {
        Booking booking = new Booking(1234, 1111, 2222, "01/01/2018", "19:00", 10);
        booking.setCustomerID(3333);
        assertEquals(booking.getCustomerID(), 3333);
    }

    @Test
    public void getRestaurantID() {
        Booking booking = new Booking(1234, 1111, 2222, "01/01/2018", "19:00", 10);
        assertEquals(booking.getRestaurantID(), 2222);
    }

    @Test
    public void setRestaurantID() {
        Booking booking = new Booking(1234, 1111, 2222, "01/01/2018", "19:00", 10);
        booking.setRestaurantID(4444);
        assertEquals(booking.getRestaurantID(), 4444);
    }

    @Test
    public void getDate() {
        Booking booking = new Booking(1234, 1111, 2222, "01/01/2018", "19:00", 10);
        assertEquals(booking.getDate(), "01/01/2018");
    }

    @Test
    public void setDate() {
        Booking booking = new Booking(1234, 1111, 2222, "01/01/2018", "19:00", 10);
        booking.setDate("02/02/2017");
        assertEquals(booking.getDate(), "02/02/2017");
    }

    @Test
    public void getTime() {
        Booking booking = new Booking(1234, 1111, 2222, "01/01/2018", "19:00", 10);
        assertEquals(booking.getTime(), "19:00");
    }

    @Test
    public void setTime() {
        Booking booking = new Booking(1234, 1111, 2222, "01/01/2018", "19:00", 10);
        booking.setTime("21:00");
        assertEquals(booking.getTime(), "21:00");
    }

    @Test
    public void getTableNumber() {
        Booking booking = new Booking(1234, 1111, 2222, "01/01/2018", "19:00", 10);
        assertEquals(booking.getTableNumber(), 10);
    }

    @Test
    public void setTableNumber() {
        Booking booking = new Booking(1234, 1111, 2222, "01/01/2018", "19:00", 10);
        booking.setTableNumber(20);
        assertEquals(booking.getTableNumber(), 20);
    }
}