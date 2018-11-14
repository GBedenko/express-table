package com.bedenko.genaro.expresstable.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.bedenko.genaro.expresstable.R;

public class ViewRestaurantActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_restaurant);

        Intent intent = getIntent();
        String restaurantName = intent.getStringExtra("restaurant_name");
        TextView textView = findViewById(R.id.viewingRestaurantName);
        textView.setText(restaurantName);
    }
}
