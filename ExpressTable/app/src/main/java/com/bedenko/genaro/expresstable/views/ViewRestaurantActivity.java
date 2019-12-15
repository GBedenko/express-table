package com.bedenko.genaro.expresstable.views;

/*
  Created by Genaro Bedenko
  
  @author gbedenko
 */

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bedenko.genaro.expresstable.R;
import com.bedenko.genaro.expresstable.controllers.RestaurantController;
import com.bedenko.genaro.expresstable.models.Restaurant;
import com.bedenko.genaro.expresstable.persistence.DatabaseHandler;

public class ViewRestaurantActivity extends AppCompatActivity {

    // Variables to store restaurant and customer details for this activity
    String restaurantIDBeingViewed;
    String restaurantNameBeingViewed;
    String currentCustomerLoggedInID;

    // Instance of database and controller this activity uses
    DatabaseHandler db = new DatabaseHandler(this);
    RestaurantController restaurantController = new RestaurantController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_restaurant);

        // Retrieve values from the intent passed from previous activity
        Intent intent = getIntent();
        setRestaurantNameBeingViewed(intent.getStringExtra("restaurant_name"));
        setRestaurantIDBeingViewed(intent.getStringExtra("restaurant_id"));
        setCurrentCustomerLoggedInID(intent.getStringExtra("customer_id"));

        // Set restaurant name as value passed by intent
        TextView textView = findViewById(R.id.viewingRestaurantName);
        textView.setText(getRestaurantNameBeingViewed());

        // Retrieve floor plan image element from interface
        ImageView floorPlanImageView = findViewById(R.id.floorPlanImageView);

        // Retrieve menu image element from interface
        ImageView menuImageView = findViewById(R.id.menuImageView);

        // Get all the restaurant's details from the database based on the restaurant id passed to this activity
        Restaurant currentRestaurant = restaurantController.getRestaurantByIdFromDB(db, getRestaurantIDBeingViewed());

        // Convert the image element's Bitmaps from the byte arrays to Image Views
        floorPlanImageView.setImageBitmap(BitmapFactory.decodeByteArray(currentRestaurant.getFloorPlanImage(),0, currentRestaurant.getFloorPlanImage().length));
        menuImageView.setImageBitmap(BitmapFactory.decodeByteArray(currentRestaurant.getMenuImage(),0, currentRestaurant.getMenuImage().length));

        // Button for booking this restaurant and its logic
        Button bookThisRestaurantButton = findViewById(R.id.bookThisRestaurantButton);
        bookThisRestaurantButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookThisRestaurantButtonClicked();
            }
        });
    }

    private void bookThisRestaurantButtonClicked() {

        TextView restaurantTheyClicked = findViewById(R.id.viewingRestaurantName);

        // Intent to go to BookRestaurantActivity for the restaurant the user clicked on
        Intent intent = new Intent(ViewRestaurantActivity.this, BookRestaurantActivity.class);

        // Pass the restaurant and customer details onto the next activity
        intent.putExtra("restaurant_name", getRestaurantNameBeingViewed());
        intent.putExtra("restaurant_id", getRestaurantIDBeingViewed());
        intent.putExtra("customer_id", getCurrentCustomerLoggedInID());

        // Start intent
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
