package com.bedenko.genaro.expresstable.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.bedenko.genaro.expresstable.R;
import com.bedenko.genaro.expresstable.controllers.BookingController;
import com.bedenko.genaro.expresstable.models.Booking;
import com.google.firebase.FirebaseApp;

public class BookRestaurantActivity extends AppCompatActivity {

    String restaurantIDBeingViewed;
    String restaurantNameBeingViewed;
    String currentCustomerLoggedInID;

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
        int bookingTable = Integer.parseInt(chooseTableSpinner.getSelectedItem().toString());

        // Convert the values for customer and restaurant id (passed from previous activity)
        int customerID = Integer.parseInt(getCurrentCustomerLoggedInID());
        int restaurantID = Integer.parseInt(getRestaurantIDBeingViewed());

        Booking newBooking = bookingController.createBooking(customerID, restaurantID, bookingDate, bookingTime, bookingTable);

        bookingController.addBookingToFirebase(newBooking);

        startActivity(new Intent(getBaseContext(), BookingConfirmationActivity.class));
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
