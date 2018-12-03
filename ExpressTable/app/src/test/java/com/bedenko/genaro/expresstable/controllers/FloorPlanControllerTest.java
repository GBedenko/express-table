package com.bedenko.genaro.expresstable.controllers;

/*
  Created by Genaro Bedenko for 300CEM Android Application Development Assignment
  Student ID 7060234
  @author bedenkog
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