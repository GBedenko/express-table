package com.bedenko.genaro.expresstable.controllers;

import com.bedenko.genaro.expresstable.models.FloorPlan;

public class FloorPlanController {

    public FloorPlan createFloorPlan(int aRestaurantID, byte[] aFloorPlanImage) {

        FloorPlan floorPlan = new FloorPlan();

        floorPlan.setRestaurantID(aRestaurantID);
        floorPlan.setImage(aFloorPlanImage);

        return(floorPlan);
    }
}
