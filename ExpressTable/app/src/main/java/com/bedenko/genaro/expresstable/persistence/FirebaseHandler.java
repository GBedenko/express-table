package com.bedenko.genaro.expresstable.persistence;

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

    private static final String TAG = "FirebaseHandler";
    private boolean addedToFirebase = false;
    private boolean documentExists = false;

    private Map<String, Object> foundBookings;

    private ArrayList<Booking> bookingsList = new ArrayList<>();

    public void addDocumentToFirebase(Object object, CollectionReference collectionReference) {

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

    public boolean queryIfDocumentExists(Query query) {

        // Ensures false as default before running query
        setDocumentExists(false);

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

        return isDocumentExists();
    }

    public ArrayList<Booking> findBookings(CollectionReference collectionReference, String restaurantID) throws InterruptedException {

        Task<QuerySnapshot> snapshots = collectionReference.whereEqualTo("restaurantID", Integer.parseInt(restaurantID)).get();

        Thread.sleep(1000);

        for (QueryDocumentSnapshot document : snapshots.getResult()) {
            Log.d(TAG, "Data: " + document.getData());
            bookingsList.add(document.toObject(Booking.class));
        }

//        Log.d(TAG, "bookings: " + getBookingsList());
//
//                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                        if (task.isSuccessful()) {
//
//                            for (QueryDocumentSnapshot document : task.getResult()) {
//                                Log.d(TAG, "Data: " + document.getData());
//                                bookingsList.add(document.toObject(Booking.class));
//                            }
//                            Log.d(TAG, "bookings: " + getBookingsList());
//                        } else {
//                            Log.d(TAG, "Error getting documents: ", task.getException());
//                        }
//                    }
//
//                });


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
