package com.bedenko.genaro.expresstable.controllers;

import com.bedenko.genaro.expresstable.models.FloorPlan;
import com.bedenko.genaro.expresstable.models.Restaurant;

public class RestaurantController {

    public Restaurant createRestaurant(String aUsername, String aEmailAddress, String aPasswordHash, String aRestaurantName, FloorPlan aFloorPlan,
                                       int aNumberOfTables, String aPostcode, String aGpsLocation) {

        Restaurant restaurant = new Restaurant();

        restaurant.setUsername(aUsername);
        restaurant.setEmailAddress(aEmailAddress);
        restaurant.setPasswordHash(aPasswordHash);
        restaurant.setRestaurantName(aRestaurantName);
        restaurant.setFloorPlan(aFloorPlan);
        restaurant.setNumberOfTables(aNumberOfTables);
        restaurant.setPostcode(aPostcode);
        restaurant.setGpsLocation(aGpsLocation);

        // Function calls to write to database persistence
        // restaurantRepo.write(restaurant);

        return(restaurant);
    }
}
