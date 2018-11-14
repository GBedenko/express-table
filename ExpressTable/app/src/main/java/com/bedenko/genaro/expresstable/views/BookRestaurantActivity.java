package com.bedenko.genaro.expresstable.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bedenko.genaro.expresstable.R;

public class BookRestaurantActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_restaurant);

        Intent intent = getIntent();
        String restaurantName = intent.getStringExtra("restaurant_name");
        TextView textView = findViewById(R.id.bookingRestaurantTextView);
        textView.setText(restaurantName);

        Button enterBookingButton = findViewById(R.id.enterBookingButton);

        enterBookingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterBookingButtonClicked();
            }
        });
    }

    private void enterBookingButtonClicked() {
        startActivity(new Intent(getBaseContext(), BookingConfirmationActivity.class));
    }
}
