package com.bedenko.genaro.expresstable.views;

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

    private static final String TAG = "RestaurantReservations";

    String restaurantLoggedInID;

    BookingController bookingController = new BookingController();

    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_reservations);

        Intent intent = getIntent();
        setRestaurantLoggedInID(intent.getStringExtra("restaurant_id"));

        ArrayList<String> restaurantBookings = null;
        try {
            restaurantBookings = bookingController.findBookings(getRestaurantLoggedInID());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Log.d(TAG, "Restaurant Bookings: " + restaurantBookings);

        lv = findViewById(R.id.reservationsListView);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                restaurantBookings);

        lv.setAdapter(arrayAdapter);
    }

    public String getRestaurantLoggedInID() {
        return restaurantLoggedInID;
    }

    public void setRestaurantLoggedInID(String restaurantLoggedInID) {
        this.restaurantLoggedInID = restaurantLoggedInID;
    }

}
