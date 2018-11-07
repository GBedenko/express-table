package com.bedenko.genaro.expresstable.persistence;

import android.content.ContentValues;

import com.bedenko.genaro.expresstable.models.Customer;
import com.bedenko.genaro.expresstable.models.Restaurant;

import java.util.ArrayList;

public class RestaurantRepo {

    public void addRestaurantToDB(DatabaseHelper db, Restaurant restaurant) {

        ContentValues restaurantValues = new ContentValues();
        restaurantValues.put("username", restaurant.getUsername() );
        restaurantValues.put("restaurant_name", restaurant.getRestaurantName());
        restaurantValues.put("email_address", restaurant.getEmailAddress());
        restaurantValues.put("password_hash", restaurant.getPasswordHash());
        restaurantValues.put("gps_location", restaurant.getGpsLocation());
        restaurantValues.put("postcode", restaurant.getPostcode());

        db.write("restaurants", restaurantValues);
    }

    public ArrayList<Restaurant> getAllRestaurants() {

        ArrayList<Restaurant> retrievedRestaurants = new ArrayList<Restaurant>();

        return retrievedRestaurants;
    }

    public Restaurant getRestaurant(Restaurant restaurant) {

        Restaurant retrievedRestaurant = new Restaurant();

        return retrievedRestaurant;
    }

    public void updateRestaurant(Restaurant restaurant) {

    }

    public void deleteRestaurant(Restaurant restaurant) {

    }
}
