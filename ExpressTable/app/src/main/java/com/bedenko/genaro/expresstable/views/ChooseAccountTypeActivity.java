package com.bedenko.genaro.expresstable.views;

/*
  Created by Genaro Bedenko
  
  @author gbedenko
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bedenko.genaro.expresstable.R;

public class ChooseAccountTypeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_account_type);

        // Retrieve the buttons used in this interface
        Button chooseCustomerButton = findViewById(R.id.chooseCustomerAccountButton);
        Button chooseRestaurantButton = findViewById(R.id.chooseRestaurantAccountButton);

        // Link button to the logic when it is clicked
        chooseCustomerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseCustomerButtonClicked();
            }
        });

        // Link button to the logic when it is clicked
        chooseRestaurantButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseRestaurantButtonClicked();
            }
        });
    }

    // When Customer option chosen, intent to move to NewCustomerActivity
    private void chooseCustomerButtonClicked() {
        startActivity(new Intent(getBaseContext(), NewCustomerActivity.class));
    }

    // When Restaurant option chosen, intent to move to NewRestaurantActivity
    private void chooseRestaurantButtonClicked() {
        startActivity(new Intent(getBaseContext(), NewRestaurantActivity.class));
    }
}
