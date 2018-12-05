package com.bedenko.genaro.expresstable.views;

/*
  Created by Genaro Bedenko for 300CEM Android Application Development Assignment
  Student ID 7060234
  @author bedenkog
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.bedenko.genaro.expresstable.R;
import com.bedenko.genaro.expresstable.controllers.BookingController;
import com.bedenko.genaro.expresstable.models.Booking;

import java.util.ArrayList;

public class RestaurantReservationsActivity extends AppCompatActivity {

    // Define TAG used for debugging purposes
    private static final String TAG = "RestaurantReservations";

    // Used to store id of restaurant currently logged in
    String restaurantLoggedInID;

    // Instance of controller this activity uses
    BookingController bookingController = new BookingController();

    // This activity will display a listview of items, each item being a booking for the given restaurant
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_reservations);

        // Get values from the intent and retrieve the restaurant id
        Intent intent = getIntent();
        setRestaurantLoggedInID(intent.getStringExtra("restaurant_id"));

        // Array list which will contain all the bookings for the current restaurant
        ArrayList<String> restaurantBookings = null;

        try {
            // Call the controller to retrieve all the bookings for this restaurant from Firebase
            restaurantBookings = bookingController.findBookings(getRestaurantLoggedInID());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Log the list of bookings to verify they are retrieved from Firebase
        Log.d(TAG, "Restaurant Bookings: " + restaurantBookings);

        // Retrieve the listview from the interface
        lv = findViewById(R.id.reservationsListView);

        // Populate the listview with items created from the retrieved bookings
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                restaurantBookings);

        // Set the values of the list view to be the new list items
        lv.setAdapter(arrayAdapter);
    }

    public String getRestaurantLoggedInID() {
        return restaurantLoggedInID;
    }

    public void setRestaurantLoggedInID(String restaurantLoggedInID) {
        this.restaurantLoggedInID = restaurantLoggedInID;
    }

}
