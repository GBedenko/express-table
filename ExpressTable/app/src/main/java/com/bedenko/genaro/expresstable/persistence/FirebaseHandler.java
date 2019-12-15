package com.bedenko.genaro.expresstable.persistence;

/*
  Created by Genaro Bedenko
  
  @author gbedenko
 */

import android.support.annotation.NonNull;
import android.util.Log;

import com.bedenko.genaro.expresstable.models.Booking;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Map;

import javax.security.auth.callback.Callback;

public class FirebaseHandler {

    // Define TAG used for debugging purpose
    private static final String TAG = "FirebaseHandler";

    // Class variables used for status of Firebase queries
    private boolean addedToFirebase = false;
    private boolean documentExists = false;
    private Map<String, Object> foundBookings;
    private ArrayList<Booking> bookingsList = new ArrayList<>();

    // Using an object of any type, store it in Firebase in the provided CollectionReference
    public void addDocumentToFirebase(Object object, CollectionReference collectionReference) {

        // Get the Firebase collection and add the provided object to it
        // If successful, change the boolean to reflect it was successfully added
        collectionReference.document()
                .set(object)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "Document added to Firebase successfully");
                        setAddedToFirebase(true);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error writing document to Firebase", e);
                        setAddedToFirebase(false);
                    }
                });
    }

    // Function to run a given query and return true if the document being queried exists
    public boolean queryIfDocumentExists(Query query) {

        // Ensures false as default before running query
        setDocumentExists(false);

        // Using the provided query, run it and if successful the boolean
        // stating if it exists will be true
        query.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        if (document.exists()) {
                            setDocumentExists(true);
                        }
                    }
                }
            }
        });

        // Return the value of the boolean after running the query
        return isDocumentExists();
    }

    // Using the collection provided and a restaurant name
    // Returns an array of all bookings assigned to the given restaurant
    public ArrayList<Booking> findBookings(CollectionReference collectionReference, String restaurantID) throws InterruptedException {

        // Create a Firebase query which will find all bookings where the restaurantID matches the provided one
        Task<QuerySnapshot> snapshots = collectionReference.whereEqualTo("restaurantID", Integer.parseInt(restaurantID)).get();

        // Sleep to ensure result of query is received by the device
        Thread.sleep(3000);

        // For every booking record in the collection, add it to the array list of bookings
        for (QueryDocumentSnapshot document : snapshots.getResult()) {

            // Log to be able to view which booking was found
            Log.d(TAG, "Data: " + document.getData());

            // Append Booking object from Firebase to the array list
            bookingsList.add(document.toObject(Booking.class));
        }

        // Return the array list of retrieved bookings
        return getBookingsList();
    }

    public boolean isAddedToFirebase() {
        return addedToFirebase;
    }

    public void setAddedToFirebase(boolean addedToFirebase) {
        this.addedToFirebase = addedToFirebase;
    }

    public boolean isDocumentExists() {
        return documentExists;
    }

    public void setDocumentExists(boolean documentExists) {
        this.documentExists = documentExists;
    }


    public Map<String, Object> getFoundBookings() {
        return foundBookings;
    }

    public void setFoundBookings(Map<String, Object> foundBookings) {
        this.foundBookings = foundBookings;
    }

    public ArrayList<Booking> getBookingsList() {
        return bookingsList;
    }

    public void setBookingsList(ArrayList<Booking> bookingsList) {
        this.bookingsList = bookingsList;
    }
}
