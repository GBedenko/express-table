package com.bedenko.genaro.expresstable.controllers;

import android.content.ContentValues;

import com.bedenko.genaro.expresstable.models.Customer;
import com.bedenko.genaro.expresstable.models.Restaurant;
import com.bedenko.genaro.expresstable.persistence.DatabaseHandler;

public class RestaurantController {

    public Restaurant createRestaurant(String aUsername, String aRestaurantName, String aPasswordHash, double aRestaurantLatitude, double aRestaurantLongitude) {

        Restaurant restaurant = new Restaurant();

        restaurant.setUsername(aUsername);
        restaurant.setRestaurantName(aRestaurantName);
        restaurant.setPasswordHash(aPasswordHash);
        restaurant.setRestaurantLatitude(aRestaurantLatitude);
        restaurant.setRestaurantLongitude(aRestaurantLongitude);

        return(restaurant);
    }

    public void addRestaurantToDB(DatabaseHandler db, Restaurant restaurant) {

        ContentValues restaurantValues = new ContentValues();
        restaurantValues.put("username", restaurant.getUsername());
        restaurantValues.put("restaurant_name", restaurant.getRestaurantName());
        restaurantValues.put("password_hash", restaurant.getPasswordHash());
        restaurantValues.put("latitude", restaurant.getRestaurantLatitude());
        restaurantValues.put("longitude", restaurant.getRestaurantLongitude());

        db.write("restaurants", restaurantValues);
    }

    public String getRestaurantFromDB(DatabaseHandler db, Restaurant restaurant) {

        return "";
    }
}
