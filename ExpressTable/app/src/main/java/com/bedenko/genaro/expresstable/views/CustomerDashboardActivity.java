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
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bedenko.genaro.expresstable.R;

public class CustomerDashboardActivity extends AppCompatActivity {

    // Define element from the interface
    String currentCustomerLoggedInID;

    // Define TAG used for debugging purpose
    private static final String TAG = "CustomerDashboard";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_dashboard);

        // Retrieve the intent from the Log In or Create Account Activity
        Intent intent = getIntent();

        // Set username to be shown to confirm which user is logged in
        TextView loggedInCustomerNameText = findViewById(R.id.loggedInCustomerName);
        loggedInCustomerNameText.setText(intent.getStringExtra("customer_username") + " logged in");

        // Log the customer id retrieve from intent of either login or new customer screens
        Log.d(TAG, "intent " + intent.getStringExtra("customer_id"));

        // Store the user id for use later to be passed to future activities
        setCurrentCustomerLoggedInID(intent.getStringExtra("customer_id"));

        // Retrieve the buttons used in this interface
        Button viewRestaurantsListButton = findViewById(R.id.viewRestaurantsListButton);
        Button viewRestaurantsByGpsButton = findViewById(R.id.viewRestaurantsByGpsButton);

        // Link button to the logic when it is clicked
        viewRestaurantsListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewRestaurantsListButtonClicked();
            }
        });

        // Link button to the logic when it is clicked
        viewRestaurantsByGpsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewRestaurantsByGpsButtonClicked();
            }
        });
    }

    private void viewRestaurantsListButtonClicked() {

        // Intent to go to viewing restaurants list activity
        Intent intent = new Intent(CustomerDashboardActivity.this, SearchRestaurantsListActivity.class);

        // Pass the customer's id to the next activity
        intent.putExtra("customer_id", getCurrentCustomerLoggedInID());

        // Start intent
        startActivityForResult(intent, 1);
    }

    private void viewRestaurantsByGpsButtonClicked() {

        // Intent to go to viewing restaurants on Google Maps activity
        Intent intent = new Intent(CustomerDashboardActivity.this, MapsActivity.class);

        // Pass the customer's id to the next activity
        intent.putExtra("customer_id", getCurrentCustomerLoggedInID());

        // Start intent
        startActivityForResult(intent, 1);
    }

    public String getCurrentCustomerLoggedInID() {
        return currentCustomerLoggedInID;
    }

    public void setCurrentCustomerLoggedInID(String currentCustomerLoggedInID) {
        this.currentCustomerLoggedInID = currentCustomerLoggedInID;
    }
}
