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

        Button searchRestaurantsButton = findViewById(R.id.searchRestaurantsButton);

        searchRestaurantsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchRestaurantsButtonClicked();
            }
        });
    }


    private void searchRestaurantsButtonClicked() {
        startActivity(new Intent(getBaseContext(), SearchRestaurantsGpsActivity.class));
    }
}
