package com.bedenko.genaro.expresstable.controllers;

import com.bedenko.genaro.expresstable.models.Booking;
import com.bedenko.genaro.expresstable.persistence.FirebaseHandler;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class BookingController {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseHandler firebaseHandler = new FirebaseHandler();

    private CollectionReference bookingsCollection = db.collection("bookings");

    public Booking createBooking(int aCustomerID, int aRestaurantID, String aDate, String aTime, String aTableNumber) {

        Booking booking = new Booking();

        booking.setCustomerID(aCustomerID);
        booking.setRestaurantID(aRestaurantID);
        booking.setDate(aDate);
        booking.setTime(aTime);
        booking.setTableNumber(aTableNumber);

        return(booking);
    }

    public Booking findBooking(String customerID, String restaurantID) {

        Booking foundBooking = firebaseHandler.findBooking(db.collection("bookings"), customerID, restaurantID);

        return foundBooking;
    }

    public void addBookingToFirebase(Booking booking) {

        firebaseHandler.addDocumentToFirebase(booking, bookingsCollection);

    }

}
