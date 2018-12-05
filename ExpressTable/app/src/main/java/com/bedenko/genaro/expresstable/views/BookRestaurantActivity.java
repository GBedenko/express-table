package com.bedenko.genaro.expresstable.views;

/*
  Created by Genaro Bedenko for 300CEM Android Application Development Assignment
  Student ID 7060234
  @author bedenkog
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.bedenko.genaro.expresstable.R;
import com.bedenko.genaro.expresstable.controllers.BookingController;
import com.bedenko.genaro.expresstable.models.Booking;

public class BookRestaurantActivity extends AppCompatActivity {

    // Define the elements in the interface
    String restaurantIDBeingViewed;
    String restaurantNameBeingViewed;
    String currentCustomerLoggedInID;

    // Define TAG used for debugging purpose
    private static final String TAG = "BookRestaurantActivity";

    // Instance of BookingController used for interactions from this activity
    BookingController bookingController = new BookingController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_restaurant);

        // Get values passed from ViewRestaurantActivity
        Intent intent = getIntent();
        setRestaurantNameBeingViewed(intent.getStringExtra("restaurant_name"));
        setRestaurantIDBeingViewed(intent.getStringExtra("restaurant_id"));
        setCurrentCustomerLoggedInID(intent.getStringExtra("customer_id"));

        // Set the current restaurant name to the one they just viewed
        TextView textView = findViewById(R.id.bookingRestaurantTextView);
        textView.setText(getRestaurantNameBeingViewed());

        // Define button and link to its logic when it is clicked
        Button enterBookingButton = findViewById(R.id.enterBookingButton);
        enterBookingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterBookingButtonClicked();
            }
        });
    }

    private void enterBookingButtonClicked() {

        // Get values from field the user entered in
        EditText enterDateTextField = findViewById(R.id.enterDateTextField);
        EditText enterTimeTextField = findViewById(R.id.enterTimeTextField);
        Spinner chooseTableSpinner = findViewById(R.id.chooseTableSpinner);

        // Convert values entered by the user
        String bookingDate = enterDateTextField.getText().toString();
        String bookingTime = enterTimeTextField.getText().toString();
        String bookingTable = chooseTableSpinner.getSelectedItem().toString();

        // Convert the values for customer and restaurant id (passed from previous activity)
        int customerID = Integer.parseInt(getCurrentCustomerLoggedInID());
        int restaurantID = Integer.parseInt(getRestaurantIDBeingViewed());

        // Create a new Booking object based on the values the user entered
        Booking newBooking = bookingController.createBooking(customerID, restaurantID, bookingDate, bookingTime, bookingTable);

        // Add the new Booking object to remote database/Firebase
        bookingController.addBookingToFirebase(newBooking);

        // Intent to move to the Booking Confirmation and send the entered values to the next activity
        Intent intent = new Intent(BookRestaurantActivity.this, BookingConfirmationActivity.class);
        intent.putExtra("restaurant_name", getRestaurantNameBeingViewed());
        intent.putExtra("booking_date", bookingDate);
        intent.putExtra("booking_time", bookingTime);
        intent.putExtra("booking_table", bookingTable);

        // Logging values to check what values are being sent with the intent
        Log.d(TAG, "intent " + getRestaurantNameBeingViewed());
        Log.d(TAG, "intent " + bookingDate);
        Log.d(TAG, "intent " + bookingTime);
        Log.d(TAG, "intent " + bookingTable);

        // Start the intent
        startActivityForResult(intent, 1);
    }

    public String getRestaurantIDBeingViewed() {
        return restaurantIDBeingViewed;
    }

    public void setRestaurantIDBeingViewed(String restaurantIDBeingViewed) {
        this.restaurantIDBeingViewed = restaurantIDBeingViewed;
    }

    public String getRestaurantNameBeingViewed() {
        return restaurantNameBeingViewed;
    }

    public void setRestaurantNameBeingViewed(String restaurantNameBeingViewed) {
        this.restaurantNameBeingViewed = restaurantNameBeingViewed;
    }

    public String getCurrentCustomerLoggedInID() {
        return currentCustomerLoggedInID;
    }

    public void setCurrentCustomerLoggedInID(String currentCustomerLoggedInID) {
        this.currentCustomerLoggedInID = currentCustomerLoggedInID;
    }
}
