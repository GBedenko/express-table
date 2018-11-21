package com.bedenko.genaro.expresstable.controllers;

import android.content.ContentValues;
import android.util.Log;

import com.bedenko.genaro.expresstable.models.Customer;
import com.bedenko.genaro.expresstable.models.Restaurant;
import com.bedenko.genaro.expresstable.persistence.DatabaseHandler;

import java.util.ArrayList;

public class RestaurantController {

    private static final String TAG = "RestaurantController";

    public Restaurant createRestaurant(String aUsername, String aRestaurantName, String aPasswordHash, String aGpsLocation) {

        Restaurant restaurant = new Restaurant();

        restaurant.setUsername(aUsername);
        restaurant.setRestaurantName(aRestaurantName);
        restaurant.setPasswordHash(aPasswordHash);
        restaurant.setGpsLocation(aGpsLocation);

        return(restaurant);
    }

    public void addRestaurantToDB(DatabaseHandler db, Restaurant restaurant) {

        ContentValues restaurantValues = new ContentValues();
        restaurantValues.put("username", restaurant.getUsername());
        restaurantValues.put("restaurant_name", restaurant.getRestaurantName());
        restaurantValues.put("password_hash", restaurant.getPasswordHash());
        restaurantValues.put("gps_location", restaurant.getGpsLocation());

        db.write("restaurants", restaurantValues);
    }

    public boolean isRestaurantInDB(DatabaseHandler db, Restaurant restaurant) {

        Log.d(TAG, "Checking if following restaurant details are stored in DB: " + restaurant.getUsername() + " " + restaurant.getPasswordHash());

        // From the database, retrieves an arraylist of all restaurants
        ArrayList<Restaurant> allRestaurantsInDB = db.readAllRestaurants();

        // Loop through the list of restaurants, if username and password_hash match, return true
        // Else, return false
        for(int i=0; i <= allRestaurantsInDB.size()-1; i++) {
            if(allRestaurantsInDB.get(i).getUsername().equals(restaurant.getUsername())) {
                if(allRestaurantsInDB.get(i).getPasswordHash().equals(restaurant.getPasswordHash())) {
                    Log.d(TAG, "Restaurant details found in DB");
                    return true;
                }
            }
        }

        Log.d(TAG, "Restaurant details not in DB");
        return false;
    }

    public Restaurant getRestaurantFromDB(DatabaseHandler db, Restaurant restaurant) {

        // From the database, retrieves an arraylist of all restaurants
        ArrayList<Restaurant> allRestaurantsIDB = db.readAllRestaurants();

        // Loop through the list of restaurants, if username and password_hash match, return true
        // Else, return false
        for(int i=0; i <= allRestaurantsIDB.size()-1; i++) {
            if(allRestaurantsIDB.get(i).getUsername().equals(restaurant.getUsername())) {
                if(allRestaurantsIDB.get(i).getPasswordHash().equals(restaurant.getPasswordHash())) {
                    return allRestaurantsIDB.get(i);
                }
            }
        }
        return restaurant;
    }
}
