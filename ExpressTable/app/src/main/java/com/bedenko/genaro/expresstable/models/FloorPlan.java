package com.bedenko.genaro.expresstable.models;

/*
  Created by Genaro Bedenko for 300CEM Android Application Development Assignment
  Student ID 7060234
  @author bedenkog
 */

public class FloorPlan {

    private int floorPlanID = -1;
    private int restaurantID;
    private byte[] image;

    public FloorPlan() {

        // Can create a blank instance if no parameters passed
    }

    public FloorPlan(int floorPlanID, int restaurantID, byte[] image) {

        // Create a new instance when all parameters are passed
        this.floorPlanID = floorPlanID;
        this.restaurantID = restaurantID;
        this.image = image;
    }

    public int getFloorPlanID() {
        return floorPlanID;
    }

    public void setFloorPlanID(int floorPlanID) {
        this.floorPlanID = floorPlanID;
    }

    public int getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(int restaurantID) {
        this.restaurantID = restaurantID;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
