package com.bedenko.genaro.expresstable.views;

/*
  Created by Genaro Bedenko for 300CEM Android Application Development Assignment
  Student ID 7060234
  @author bedenkog
 */

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.bedenko.genaro.expresstable.R;
import com.bedenko.genaro.expresstable.controllers.RestaurantAdapter;
import com.bedenko.genaro.expresstable.controllers.RestaurantController;
import com.bedenko.genaro.expresstable.models.Restaurant;
import com.bedenko.genaro.expresstable.persistence.DatabaseHandler;

import java.util.ArrayList;

public class SearchRestaurantsListActivity extends AppCompatActivity {

    // Define class attributes used for this activity
    private ListView listView;
    private String[] restaurantNames;
    private String[] restaurantDetails;

    // Define TAG used for debugging purposes
    private static final String TAG = "SearchRestaurantsList";

    // Variable to store the current customer's id viewing the activity
    String currentCustomerLoggedInID;

    // Instances of controller and local database handler used for this activity
    RestaurantController restaurantController = new RestaurantController();
    DatabaseHandler db = new DatabaseHandler(this);

    // Array list which will be populated with all the restaurants to create list items
    private ArrayList<Restaurant> restaurants = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_restaurants_list);

        // Retrieve the customer id from the intent of the previous activity
        Intent intent = getIntent();
        setCurrentCustomerLoggedInID(intent.getStringExtra("customer_id"));

        // Log the customer id from previous activity to verify it was passed here
        Log.d(TAG, "intent " + intent.getStringExtra("customer_id"));

        // Retrieve all of the restaurants stored in the local sqlite database
        restaurants = restaurantController.getAllRestaurantsFromDB(db);

        // Log each restaurant retrieve to verify they are returned from the database
        for(int i=0; i <= restaurants.size()-1; i++) {
            Log.d(TAG, "address " + restaurants.get(i).getRestaurantAddress());
        }

        // Retrieve the list view in the interface
        listView = findViewById(R.id.listViewComplex);

        // Create new list items based on the restaurants list retrieved from the database
        listView.setAdapter(new RestaurantAdapter(this, R.layout.list_item, restaurants));
        listView.setOnItemClickListener(

                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        // When clicking on a restaurant in the listview, intent is to view that restaurant's details in ViewRestaurantActivity
                        Intent intent = new Intent(SearchRestaurantsListActivity.this, ViewRestaurantActivity.class);

                        // Send the restaurant and customer details to the next activity as well
                        intent.putExtra("restaurant_name", restaurants.get(position).getRestaurantName());
                        intent.putExtra("restaurant_id", restaurants.get(position).getRestaurantID());
                        intent.putExtra("customer_id", getCurrentCustomerLoggedInID());

                        // Start intent
                        startActivityForResult(intent, 1);
                    }
                }
        );
    }

    public String getCurrentCustomerLoggedInID() {
        return currentCustomerLoggedInID;
    }

    public void setCurrentCustomerLoggedInID(String currentCustomerLoggedInID) {
        this.currentCustomerLoggedInID = currentCustomerLoggedInID;
    }

}