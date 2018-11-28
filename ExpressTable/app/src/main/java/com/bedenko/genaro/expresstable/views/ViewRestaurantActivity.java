package com.bedenko.genaro.expresstable.views;

/*
  Created by Genaro Bedenko for 300CEM Android Application Development Assignment
  Student ID 7060234
  @author bedenkog
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

    String restaurantIDBeingViewed;
    String restaurantNameBeingViewed;
    String currentCustomerLoggedInID;

    DatabaseHandler db = new DatabaseHandler(this);

    RestaurantController restaurantController = new RestaurantController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_restaurant);

        Intent intent = getIntent();
        setRestaurantNameBeingViewed(intent.getStringExtra("restaurant_name"));
        setRestaurantIDBeingViewed(intent.getStringExtra("restaurant_id"));
        setCurrentCustomerLoggedInID(intent.getStringExtra("customer_id"));
        TextView textView = findViewById(R.id.viewingRestaurantName);
        textView.setText(getRestaurantNameBeingViewed());

        ImageView floorPlanImageView = findViewById(R.id.floorPlanImageView);
        ImageView menuImageView = findViewById(R.id.menuImageView);

        Restaurant currentRestaurant = restaurantController.getRestaurantByIdFromDB(db, getRestaurantIDBeingViewed());

        floorPlanImageView.setImageBitmap(BitmapFactory.decodeByteArray(currentRestaurant.getFloorPlanImage(),0, currentRestaurant.getFloorPlanImage().length));
        menuImageView.setImageBitmap(BitmapFactory.decodeByteArray(currentRestaurant.getMenuImage(),0, currentRestaurant.getMenuImage().length));

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

        Intent intent = new Intent(ViewRestaurantActivity.this, BookRestaurantActivity.class);
        intent.putExtra("restaurant_name", getRestaurantNameBeingViewed());
        intent.putExtra("restaurant_id", getRestaurantIDBeingViewed());
        intent.putExtra("customer_id", getCurrentCustomerLoggedInID());

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
