package com.bedenko.genaro.expresstable.views;

/*
  Created by Genaro Bedenko for 300CEM Android Application Development Assignment
  Student ID 7060234
  @author bedenkog
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bedenko.genaro.expresstable.R;

public class RestaurantDashboardActivity extends AppCompatActivity {

    private String currentRestaurantLoggedInID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_dashboard);

        // Retrieve the intent from the Log In or Create Account Activity
        Intent intent = getIntent();

        // Set username to be shown to confirm which user is logged in
        TextView loggedInRestaurantUsernameText = findViewById(R.id.loggedInRestaurantUsername);
        loggedInRestaurantUsernameText.setText(intent.getStringExtra("restaurant_username") + " logged in");

        // Store the user id for use later to be passed to future activities
        setCurrentRestaurantLoggedInID(intent.getStringExtra("restaurant_id"));

        // Retrieve the button from the interface and link to its logic when it is clicked
        Button viewReservationsButton = findViewById(R.id.viewReservationsButton);
        viewReservationsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewReservationsButtonClicked();
            }
        });

    }

    private void viewReservationsButtonClicked() {

        // Intent to go to the RestaurantReservations activity
        Intent intent = new Intent(RestaurantDashboardActivity.this, RestaurantReservationsActivity.class);

        // Pass the restaurant's id to the next activity
        intent.putExtra("restaurant_id", getCurrentRestaurantLoggedInID());

        // Start intent
        startActivityForResult(intent, 1);
    }

    public String getCurrentRestaurantLoggedInID() {
        return currentRestaurantLoggedInID;
    }

    public void setCurrentRestaurantLoggedInID(String currentRestaurantLoggedInID) {
        this.currentRestaurantLoggedInID = currentRestaurantLoggedInID;
    }
}
