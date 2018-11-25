package com.bedenko.genaro.expresstable.views;

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

    private ListView listView;
    private String[] restaurantNames;
    private String[] restaurantDetails;

    private static final String TAG = "SearchRestaurantsList";

    String currentCustomerLoggedInID;

    RestaurantController restaurantController = new RestaurantController();
    DatabaseHandler db = new DatabaseHandler(this);

    private ArrayList<Restaurant> restaurants = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_restaurants_list);

        Intent intent = getIntent();
        setCurrentCustomerLoggedInID(intent.getStringExtra("customer_id"));

        Log.d(TAG, "intent " + intent.getStringExtra("customer_id"));
        restaurantNames = getResources().getStringArray(R.array.default_restaurant_names);
        restaurantDetails = getResources().getStringArray(R.array.default_restaurant_details);

        restaurants = restaurantController.getAllRestaurantsFromDB(db);

        listView = findViewById(R.id.listViewComplex);
        listView.setAdapter(new RestaurantAdapter(this, R.layout.list_item, restaurants));
        listView.setOnItemClickListener(

                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(SearchRestaurantsListActivity.this, ViewRestaurantActivity.class);
                        intent.putExtra("restaurant_name", restaurants.get(position).getRestaurantName());
                        intent.putExtra("restaurant_id", restaurants.get(position).getRestaurantID());
                        intent.putExtra("customer_id", getCurrentCustomerLoggedInID());
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