package com.bedenko.genaro.expresstable.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bedenko.genaro.expresstable.R;

public class CustomerDashboardActivity extends AppCompatActivity {

    String currentCustomerLoggedInID;

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

        Log.d(TAG, "intent " + intent.getStringExtra("customer_id"));

        // Store the user id for use later to be passed to future activities
        setCurrentCustomerLoggedInID(intent.getStringExtra("customer_id"));

        Button viewRestaurantsListButton = findViewById(R.id.viewRestaurantsListButton);
        Button viewRestaurantsByGpsButton = findViewById(R.id.viewRestaurantsByGpsButton);

        viewRestaurantsListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewRestaurantsListButtonClicked();
            }
        });

        viewRestaurantsByGpsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewRestaurantsByGpsButtonClicked();
            }
        });
    }

    private void viewRestaurantsListButtonClicked() {

        Intent intent = new Intent(CustomerDashboardActivity.this, SearchRestaurantsListActivity.class);
        intent.putExtra("customer_id", getCurrentCustomerLoggedInID());

        startActivityForResult(intent, 1);
    }

    private void viewRestaurantsByGpsButtonClicked() {

        Intent intent = new Intent(CustomerDashboardActivity.this, MapsActivity.class);
        intent.putExtra("customer_id", getCurrentCustomerLoggedInID());

        startActivityForResult(intent, 1);
    }

    public String getCurrentCustomerLoggedInID() {
        return currentCustomerLoggedInID;
    }

    public void setCurrentCustomerLoggedInID(String currentCustomerLoggedInID) {
        this.currentCustomerLoggedInID = currentCustomerLoggedInID;
    }
}
