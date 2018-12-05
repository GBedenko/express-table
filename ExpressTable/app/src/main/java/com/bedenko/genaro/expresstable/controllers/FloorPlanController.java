package com.bedenko.genaro.expresstable.controllers;

/*
  Created by Genaro Bedenko for 300CEM Android Application Development Assignment
  Student ID 7060234
  @author bedenkog
 */

import com.bedenko.genaro.expresstable.models.FloorPlan;

public class FloorPlanController {

    // Create a FloorPlan object by providing the required parameters
    public FloorPlan createFloorPlan(int aRestaurantID, byte[] aFloorPlanImage) {

        // Create new empty instance of FloorPlan
        FloorPlan floorPlan = new FloorPlan();

        // Populate the instance's attributes with the provided parameters
        floorPlan.setRestaurantID(aRestaurantID);
        floorPlan.setImage(aFloorPlanImage);

        // Return populated FloorPlan object
        return(floorPlan);
    }
}
