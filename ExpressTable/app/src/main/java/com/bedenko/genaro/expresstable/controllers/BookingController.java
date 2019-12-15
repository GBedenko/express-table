package com.bedenko.genaro.expresstable.controllers;

/*
  Created by Genaro Bedenko
  
  @author gbedenko
 */

import com.bedenko.genaro.expresstable.models.Booking;
import com.bedenko.genaro.expresstable.persistence.FirebaseHandler;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class BookingController {

    // Save the instance of Firebase this application uses
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    // Also initialises an instance of FirebaseHandler which controls communication with the remote database
    FirebaseHandler firebaseHandler = new FirebaseHandler();

    // Reference to the Bookings collection in Firebase
    private CollectionReference bookingsCollection = db.collection("bookings");

    // Create a booking object by providing the required parameters
    // Used for the booking a restaurant screen
    public Booking createBooking(int aCustomerID, int aRestaurantID, String aDate, String aTime, String aTableNumber) {

        // Create new empty instance of Booking
        Booking booking = new Booking();

        // Populate the instance's attributes with the provided parameters
        booking.setCustomerID(aCustomerID);
        booking.setRestaurantID(aRestaurantID);
        booking.setDate(aDate);
        booking.setTime(aTime);
        booking.setTableNumber(aTableNumber);

        // Return populated Booking object
        return(booking);
    }

    // Retrieves all of the bookings for a given restaurant stored in Firebase
    // Returns a list of strings containing each booking's details
    // Used for displaying a restaurant's reservations
    public ArrayList<String> findBookings(String restaurantID) throws InterruptedException {

        // Declare array of strings which will be populated
        ArrayList<String> bookingsDetails = new ArrayList<>();

        // Call the FirebaseHandler to return all Booking objects which are for the given restaurant id
        ArrayList<Booking> bookingsMapsList = firebaseHandler.findBookings(db.collection("bookings"), restaurantID);

        // For each Booking object retrieved, create a string of its details in a useful way which will be displayed in the reservations screen
        for(int i=0; i <=bookingsMapsList.size()-1; i++) {
            bookingsDetails.add("Date: " + bookingsMapsList.get(i).getDate() + "  Time:  " +  bookingsMapsList.get(i).getTime() + "  Table:  " +  bookingsMapsList.get(i).getTableNumber());
        }

        // Return the populated string array
        return bookingsDetails;
    }

    // Calls the FirebaseHandler to store a Booking instance in Firebase
    // Void function that doesn't return anything after sending the new Booking to be stored
    public void addBookingToFirebase(Booking booking) {

        // Call the FirebaseHandler with the object and referencing the defined Firebase collection bookings are stored in
        firebaseHandler.addDocumentToFirebase(booking, bookingsCollection);
    }
}
