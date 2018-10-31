package com.bedenko.genaro.expresstable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

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
