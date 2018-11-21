package com.bedenko.genaro.expresstable.controllers;

import com.bedenko.genaro.expresstable.models.Booking;
import com.bedenko.genaro.expresstable.persistence.FirebaseHandler;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class BookingController {

    FirebaseHandler firebaseHandler = new FirebaseHandler();
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference bookingsCollection = db.collection("bookings");

    public Booking createBooking(int aCustomerID, int aRestaurantID, String aDate, String aTime, int aTableNumber) {

        Booking booking = new Booking();

        booking.setCustomerID(aCustomerID);
        booking.setRestaurantID(aRestaurantID);
        booking.setDate(aDate);
        booking.setTime(aTime);
        booking.setTableNumber(aTableNumber);

        return(booking);
    }

    public void addBookingToFirebase(Booking booking) {

        firebaseHandler.addDocumentToFirebase(booking, bookingsCollection);

    }

}
