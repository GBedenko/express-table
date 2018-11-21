package com.bedenko.genaro.expresstable.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bedenko.genaro.expresstable.R;

public class CustomerDashboardActivity extends AppCompatActivity {

    String currentCustomerLoggedIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_dashboard);

        // Retrieve the intent from the Log In or Create Account Activity
        Intent intent = getIntent();

        // Set username to be shown to confirm which user is logged in
        TextView loggedInCustomerNameText = findViewById(R.id.loggedInCustomerName);
        loggedInCustomerNameText.setText(intent.getStringExtra("customer_username") + " logged in");

        // Store the user id for use later to be passed to future activities
        setCurrentCustomerLoggedIn(intent.getStringExtra("customer_id"));

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
        startActivity(new Intent(getBaseContext(), SearchRestaurantsListActivity.class));
    }

    private void viewRestaurantsByGpsButtonClicked() {
        startActivity(new Intent(getBaseContext(), SearchRestaurantsGpsActivity.class));
    }

    public String getCurrentCustomerLoggedIn() {
        return currentCustomerLoggedIn;
    }

    public void setCurrentCustomerLoggedIn(String currentCustomerLoggedIn) {
        this.currentCustomerLoggedIn = currentCustomerLoggedIn;
    }
}
