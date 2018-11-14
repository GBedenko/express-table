package com.bedenko.genaro.expresstable.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bedenko.genaro.expresstable.R;

public class CustomerDashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_dashboard);

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
}
