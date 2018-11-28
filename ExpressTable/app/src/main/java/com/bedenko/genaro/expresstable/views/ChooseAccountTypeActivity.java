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

import com.bedenko.genaro.expresstable.R;

public class ChooseAccountTypeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_account_type);

        Button chooseCustomerButton = findViewById(R.id.chooseCustomerAccountButton);
        Button chooseRestaurantButton = findViewById(R.id.chooseRestaurantAccountButton);

        chooseCustomerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseCustomerButtonClicked();
            }
        });

        chooseRestaurantButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseRestaurantButtonClicked();
            }
        });
    }


    private void chooseCustomerButtonClicked() {
        startActivity(new Intent(getBaseContext(), NewCustomerActivity.class));
    }

    private void chooseRestaurantButtonClicked() {
        startActivity(new Intent(getBaseContext(), NewRestaurantActivity.class));
    }
}
