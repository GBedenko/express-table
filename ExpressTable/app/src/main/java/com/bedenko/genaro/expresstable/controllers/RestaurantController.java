package com.bedenko.genaro.expresstable.controllers;

import android.content.ContentValues;

import com.bedenko.genaro.expresstable.models.Customer;
import com.bedenko.genaro.expresstable.models.Restaurant;
import com.bedenko.genaro.expresstable.persistence.DatabaseHandler;

public class RestaurantController {

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

    public void getRestaurantFromDB(DatabaseHandler db, Customer customer) {

    }
}
