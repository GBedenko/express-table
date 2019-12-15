package com.bedenko.genaro.expresstable.views;

/*
  Created by Genaro Bedenko
  
  @author gbedenko
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bedenko.genaro.expresstable.R;

public class BookingConfirmationActivity extends AppCompatActivity {

    // Define the elements in the interface
    String bookingRestaurantName;
    String bookingTime;
    String bookingDate;
    String bookingTableNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_confirmation);

        // Get values passed from BookRestaurantActivity
        Intent intent = getIntent();
        setBookingRestaurantName(intent.getStringExtra("restaurant_name"));
        setBookingTime(intent.getStringExtra("booking_time"));
        setBookingDate(intent.getStringExtra("booking_date"));
        setBookingTableNumber(intent.getStringExtra("booking_table"));

        // Assign restaurant name provided from BookRestaurantActivity
        TextView bookingRestaurantValueTextView = findViewById(R.id.bookingRestaurantValueTextView);
        bookingRestaurantValueTextView.setText(getBookingRestaurantName());

        // Assign booking time provided from BookRestaurantActivity
        TextView bookingTimeValueTextView = findViewById(R.id.bookingTimeValueTextView);
        bookingTimeValueTextView.setText(getBookingTime());

        // Assign booking date provided from BookRestaurantActivity
        TextView bookingTableNumberValueTextView = findViewById(R.id.bookingTableNumberValueTextView);
        bookingTableNumberValueTextView.setText(getBookingTableNumber());

        // Assign booking table number provided from BookRestaurantActivity
        TextView bookingDateValueTextView = findViewById(R.id.bookingDateValueTextView);
        bookingDateValueTextView.setText(getBookingDate());

        // Confirm to the user that the booking was created, this is the final screen and displays booking details
        Toast.makeText(getApplicationContext(), "Your booking has been successfully created", Toast.LENGTH_LONG).show();
    }

    public String getBookingRestaurantName() {
        return bookingRestaurantName;
    }

    public void setBookingRestaurantName(String bookingRestaurantName) {
        this.bookingRestaurantName = bookingRestaurantName;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getBookingTableNumber() {
        return bookingTableNumber;
    }

    public void setBookingTableNumber(String bookingTableNumber) {
        this.bookingTableNumber = bookingTableNumber;
    }
}
