package com.bedenko.genaro.expresstable.controllers;

/*
  Created by Genaro Bedenko for 300CEM Android Application Development Assignment
  Student ID 7060234
  @author bedenkog
 */

import android.content.ContentValues;
import android.graphics.Bitmap;
import android.util.Log;

import com.bedenko.genaro.expresstable.models.Restaurant;
import com.bedenko.genaro.expresstable.persistence.DatabaseHandler;

import java.util.ArrayList;

public class RestaurantController {

    // Define TAG used for debugging purposes
    private static final String TAG = "RestaurantController";

    // Create a Restaurant object by providing the required parameters
    // Used for the create a new restaurant screen
    public Restaurant createRestaurant(String aUsername, String aRestaurantName, String aPasswordHash, byte[] aRestaurantLogo, byte[] aRestaurantMenu, byte[] aRestaurantFloorPlan, double aRestaurantLatitude, double aRestaurantLongitude, String aRestaurantAddress) {

        // Create new empty instance of Restaurant
        Restaurant restaurant = new Restaurant();

        // Populate the instance's attributes with the provided parameters
        restaurant.setUsername(aUsername);
        restaurant.setRestaurantName(aRestaurantName);
        restaurant.setPasswordHash(aPasswordHash);
        restaurant.setLogoImage(aRestaurantLogo);
        restaurant.setMenuImage(aRestaurantMenu);
        restaurant.setFloorPlanImage(aRestaurantFloorPlan);
        restaurant.setRestaurantLatitude(aRestaurantLatitude);
        restaurant.setRestaurantLongitude(aRestaurantLongitude);
        restaurant.setRestaurantAddress(aRestaurantAddress);

        // Return populated Customer object
        return(restaurant);
    }

    // Calls the DatabaseHandler to store a Restaurant instance in SQLite
    // Assigns the values from the input Restaurant object so that the receiving SQL statement will be able to use it
    // Void function that doesn't return anything after sending the new Restaurant to be stored
    public void addRestaurantToDB(DatabaseHandler db, Restaurant restaurant) {

        ContentValues restaurantValues = new ContentValues();
        restaurantValues.put("username", restaurant.getUsername());
        restaurantValues.put("restaurant_name", restaurant.getRestaurantName());
        restaurantValues.put("password_hash", restaurant.getPasswordHash());
        restaurantValues.put("logo", restaurant.getLogoImage());
        restaurantValues.put("menu_image", restaurant.getMenuImage());
        restaurantValues.put("floorplan_image", restaurant.getFloorPlanImage());
        restaurantValues.put("latitude", restaurant.getRestaurantLatitude());
        restaurantValues.put("longitude", restaurant.getRestaurantLongitude());
        restaurantValues.put("address", restaurant.getRestaurantAddress());

        db.write("restaurants", restaurantValues);
    }

    // Calls DatabaseHandler to check whether the provided restaurant is already in the SQLite database or not
    // Check is done based on the restaurant's username and password hash
    // If both of them match a record in SQLite, then it will return true, otherwise returns false
    public boolean isRestaurantInDB(DatabaseHandler db, Restaurant restaurant) {

        // Log to see which restaurant the function will be looking for
        Log.d(TAG, "Checking if following restaurant details are stored in DB: " + restaurant.getUsername() + " " + restaurant.getPasswordHash());

        // From the database, retrieves an arraylist of all restaurants
        ArrayList<Restaurant> allRestaurantsInDB = db.readAllRestaurants();

        // Loop through the list of restaurants, if username and password_hash match, return true
        for(int i=0; i <= allRestaurantsInDB.size()-1; i++) {
            if(allRestaurantsInDB.get(i).getUsername().equals(restaurant.getUsername())) {
                if(allRestaurantsInDB.get(i).getPasswordHash().equals(restaurant.getPasswordHash())) {
                    Log.d(TAG, "Restaurant details found in DB");
                    return true;
                }
            }
        }

        // Log if the restaurant was not in the list return from db
        Log.d(TAG, "Restaurant details not in DB");

        // If reached the end of the function, then the Restaurant details don't match any that are in SQLite
        return false;
    }

    public Restaurant getRestaurantFromDB(DatabaseHandler db, Restaurant restaurant) {

        // From the database, retrieves an arraylist of all restaurants
        ArrayList<Restaurant> allRestaurantsInDB = db.readAllRestaurants();

        // Loop through the list of restaurants, if username and password_hash match, return true
        // Else, return false
        for(int i=0; i <= allRestaurantsInDB.size()-1; i++) {
            if(allRestaurantsInDB.get(i).getUsername().equals(restaurant.getUsername())) {
                if(allRestaurantsInDB.get(i).getPasswordHash().equals(restaurant.getPasswordHash())) {
                    return allRestaurantsInDB.get(i);
                }
            }
        }
        return restaurant;
    }

    // Calls DatabaseHandler to return a Restaurant object stored in SQLite database that matches the provided one
    // Returns all of the restaurant's details instead of just confirming if they are in the database
    public Restaurant getRestaurantByIdFromDB(DatabaseHandler db, String restaurant_id) {

        // From the database, retrieves an arraylist of all restaurants
        ArrayList<Restaurant> allRestaurantsInDB = db.readAllRestaurants();

        for(int i=0; i <= allRestaurantsInDB.size()-1; i++) {
            if(allRestaurantsInDB.get(i).getRestaurantID().equals(restaurant_id)) {
                return allRestaurantsInDB.get(i);
            }
        }
        return new Restaurant();
    }

    // Calls DatabaseHandler to return all Restaurant objects stored in SQLite database
    public ArrayList<Restaurant> getAllRestaurantsFromDB(DatabaseHandler db) {

        // From the database, retrieves an arraylist of all restaurants
        ArrayList<Restaurant> allRestaurantsInDB = db.readAllRestaurants();

        return allRestaurantsInDB;
    }
}
