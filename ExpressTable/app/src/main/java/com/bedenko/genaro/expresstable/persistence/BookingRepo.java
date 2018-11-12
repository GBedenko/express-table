package com.bedenko.genaro.expresstable.persistence;

import android.content.ContentValues;

import com.bedenko.genaro.expresstable.models.Booking;

import java.util.ArrayList;

public class BookingRepo {

    public void addBookingToDB(DatabaseHandler db, Booking booking) {

        ContentValues bookingValues = new ContentValues();
        bookingValues.put("customer_id", booking.getCustomerID() );
        bookingValues.put("restaurant_id", booking.getRestaurantID());
        bookingValues.put("date", booking.getDate());
        bookingValues.put("time", booking.getTime());
        bookingValues.put("table_number", booking.getTableNumber());

        db.write("bookings", bookingValues);
    }

    public ArrayList<Booking> getAllBookings() {

        ArrayList<Booking> retrievedBooking = new ArrayList<Booking>();

        return retrievedBooking;
    }

    public Booking getBooking(Booking booking) {

        Booking retrievedBooking = new Booking();

        return retrievedBooking;
    }

    public void updateBooking(Booking booking) {

    }

    public void deleteBooking(Booking booking) {

    }
}
