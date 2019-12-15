package com.bedenko.genaro.expresstable.models;

/*
  Created by Genaro Bedenko
  
  @author gbedenko
 */

import org.junit.Test;

import static org.junit.Assert.*;

public class FloorPlanTest {

    @Test
    public void getFloorPlanID() {
        FloorPlan floorPlan = new FloorPlan(1234, 1111, new byte[]{(byte) 204, 29, (byte) 207, (byte) 217});
        assertEquals(floorPlan.getFloorPlanID(), 1234);
    }

    @Test
    public void setFloorPlanID() {
        FloorPlan floorPlan = new FloorPlan(1234, 1111, new byte[]{(byte) 204, 29, (byte) 207, (byte) 217});
        floorPlan.setFloorPlanID(2222);
        assertEquals(floorPlan.getFloorPlanID(), 2222);
    }

    @Test
    public void getRestaurantID() {
        FloorPlan floorPlan = new FloorPlan(1234, 1111, new byte[]{(byte) 204, 29, (byte) 207, (byte) 217});
        assertEquals(floorPlan.getRestaurantID(), 1111);
    }

    @Test
    public void setRestaurantID() {
        FloorPlan floorPlan = new FloorPlan(1234, 1111, new byte[]{(byte) 204, 29, (byte) 207, (byte) 217});
        floorPlan.setRestaurantID(3333);
        assertEquals(floorPlan.getRestaurantID(), 3333);
    }
}