package com.bedenko.genaro.expresstable.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bedenko.genaro.expresstable.R;

public class RestaurantDashboardActivity extends AppCompatActivity {

    String currentRestaurantLoggedIn;

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
        setCurrentRestaurantLoggedIn(intent.getStringExtra("restaurant_id"));

        Button viewReservationsButton = findViewById(R.id.viewReservationsButton);

        viewReservationsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewReservationsButtonClicked();
            }
        });

    }

    private void viewReservationsButtonClicked() {
        startActivity(new Intent(getBaseContext(), RestaurantReservationsActivity.class));
    }

    public String getCurrentRestaurantLoggedIn() {
        return currentRestaurantLoggedIn;
    }

    public void setCurrentRestaurantLoggedIn(String currentRestaurantLoggedIn) {
        this.currentRestaurantLoggedIn = currentRestaurantLoggedIn;
    }
}
