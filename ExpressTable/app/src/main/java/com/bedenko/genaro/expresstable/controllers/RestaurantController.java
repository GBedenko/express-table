package com.bedenko.genaro.expresstable.controllers;

import android.content.ContentValues;

import com.bedenko.genaro.expresstable.models.Customer;
import com.bedenko.genaro.expresstable.models.Restaurant;
import com.bedenko.genaro.expresstable.persistence.DatabaseHandler;

public class RestaurantController {

    public Restaurant createRestaurant(String aUsername, String aEmailAddress, String aPasswordHash,
                                       String aRestaurantName, String aPostcode, String aGpsLocation) {

        Restaurant restaurant = new Restaurant();

        restaurant.setUsername(aUsername);
        restaurant.setEmailAddress(aEmailAddress);
        restaurant.setPasswordHash(aPasswordHash);
        restaurant.setRestaurantName(aRestaurantName);
        restaurant.setPostcode(aPostcode);
        restaurant.setGpsLocation(aGpsLocation);

        return(restaurant);
    }

    public void addRestaurantToDB(DatabaseHandler db, Restaurant restaurant) {

        ContentValues restaurantValues = new ContentValues();
        restaurantValues.put("username", restaurant.getUsername());
        restaurantValues.put("restaurant_name", restaurant.getRestaurantName());
        restaurantValues.put("email_address", restaurant.getEmailAddress());
        restaurantValues.put("password_hash", restaurant.getPasswordHash());
        restaurantValues.put("gps_location", restaurant.getGpsLocation());
        restaurantValues.put("postcode", restaurant.getPostcode());

        db.write("restaurants", restaurantValues);
    }

    public void getRestaurantFromDB(DatabaseHandler db, Customer customer) {

    }
}
