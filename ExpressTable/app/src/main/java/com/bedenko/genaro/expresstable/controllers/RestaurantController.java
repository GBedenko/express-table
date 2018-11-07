package com.bedenko.genaro.expresstable.controllers;

import com.bedenko.genaro.expresstable.models.FloorPlan;
import com.bedenko.genaro.expresstable.models.Restaurant;

public class RestaurantController {

    public Restaurant createRestaurant(String aUsername,
                                       String emailAddress,
                                       String aPasswordHash,
                                       String aRestaurantName,
                                       FloorPlan aFloorPlan,
                                       int aNumberOfTables,
                                       String aPostcode,
                                       String aGpsLocation) {

        Restaurant restaurant = new Restaurant();

        // Set values for what a restaurant will store

        return(restaurant);
    }
}
