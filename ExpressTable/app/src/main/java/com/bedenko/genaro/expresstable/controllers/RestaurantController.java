package com.bedenko.genaro.expresstable.controllers;

import android.content.ContentValues;
import android.graphics.Bitmap;
import android.util.Log;

import com.bedenko.genaro.expresstable.models.Restaurant;
import com.bedenko.genaro.expresstable.persistence.DatabaseHandler;

import java.util.ArrayList;

public class RestaurantController {

<<<<<<< HEAD
    private static final String TAG = "RestaurantController";

    public Restaurant createRestaurant(String aUsername, String aRestaurantName, String aPasswordHash, byte[] aRestaurantLogo, byte[] aRestaurantMenu, byte[] aRestaurantFloorPlan, String aGpsLocation) {
=======
    public Restaurant createRestaurant(String aUsername, String aRestaurantName, String aPasswordHash, double aRestaurantLatitude, double aRestaurantLongitude) {
>>>>>>> google_maps_and_gps

        Restaurant restaurant = new Restaurant();

        restaurant.setUsername(aUsername);
        restaurant.setRestaurantName(aRestaurantName);
        restaurant.setPasswordHash(aPasswordHash);
<<<<<<< HEAD
        restaurant.setLogoImage(aRestaurantLogo);
        restaurant.setMenuImage(aRestaurantMenu);
        restaurant.setFloorPlanImage(aRestaurantFloorPlan);
        restaurant.setGpsLocation(aGpsLocation);
=======
        restaurant.setRestaurantLatitude(aRestaurantLatitude);
        restaurant.setRestaurantLongitude(aRestaurantLongitude);
>>>>>>> google_maps_and_gps

        return(restaurant);
    }

    public void addRestaurantToDB(DatabaseHandler db, Restaurant restaurant) {

        ContentValues restaurantValues = new ContentValues();
        restaurantValues.put("username", restaurant.getUsername());
        restaurantValues.put("restaurant_name", restaurant.getRestaurantName());
        restaurantValues.put("password_hash", restaurant.getPasswordHash());
<<<<<<< HEAD
        restaurantValues.put("logo", restaurant.getLogoImage());
        restaurantValues.put("menu_image", restaurant.getMenuImage());
        restaurantValues.put("floorplan_image", restaurant.getFloorPlanImage());
        restaurantValues.put("gps_location", restaurant.getGpsLocation());
=======
        restaurantValues.put("latitude", restaurant.getRestaurantLatitude());
        restaurantValues.put("longitude", restaurant.getRestaurantLongitude());
>>>>>>> google_maps_and_gps

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

    public ArrayList<Restaurant> getAllRestaurantsFromDB(DatabaseHandler db) {

        // From the database, retrieves an arraylist of all restaurants
        ArrayList<Restaurant> allRestaurantsInDB = db.readAllRestaurants();

        return allRestaurantsInDB;
    }
}
