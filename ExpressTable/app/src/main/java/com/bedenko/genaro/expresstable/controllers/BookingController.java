package com.bedenko.genaro.expresstable.controllers;

import com.bedenko.genaro.expresstable.models.Booking;
import com.bedenko.genaro.expresstable.persistence.FirebaseHandler;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class BookingController {

    private static final String TAG = "BookingController";

    private ArrayList<Booking> currentReservationsView;

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

    public ArrayList<Booking> findBookings(String restaurantID) throws InterruptedException {

        ArrayList<Booking> bookingsMapsList = firebaseHandler.findBookings(db.collection("bookings"), restaurantID);

        return bookingsMapsList;
    }

    public void addBookingToFirebase(Booking booking) {

        firebaseHandler.addDocumentToFirebase(booking, bookingsCollection);

    }

    public ArrayList<Booking> getCurrentReservationsView() {
        return currentReservationsView;
    }

    public void setCurrentReservationsView(ArrayList<Booking> currentReservationsView) {
        this.currentReservationsView = currentReservationsView;
    }

}
