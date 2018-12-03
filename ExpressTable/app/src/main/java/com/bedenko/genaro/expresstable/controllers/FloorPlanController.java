package com.bedenko.genaro.expresstable.controllers;

/*
  Created by Genaro Bedenko for 300CEM Android Application Development Assignment
  Student ID 7060234
  @author bedenkog
 */

import com.bedenko.genaro.expresstable.models.FloorPlan;

public class FloorPlanController {

    public FloorPlan createFloorPlan(int aRestaurantID, byte[] aFloorPlanImage) {

        FloorPlan floorPlan = new FloorPlan();

        floorPlan.setRestaurantID(aRestaurantID);
        floorPlan.setImage(aFloorPlanImage);

        return(floorPlan);
    }
}
