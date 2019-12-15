package com.bedenko.genaro.expresstable.controllers;

/*
  Created by Genaro Bedenko
  
  @author gbedenko
 */

import com.bedenko.genaro.expresstable.models.FloorPlan;

import org.junit.Test;

import static org.junit.Assert.*;

public class FloorPlanControllerTest {

    @Test
    public void createFloorPlan() {

        FloorPlanController floorPlanController = new FloorPlanController();

        FloorPlan testFloorPlan = floorPlanController.createFloorPlan(1234, new byte[]{});
        assertEquals(testFloorPlan.getRestaurantID(), 1234);
    }
}