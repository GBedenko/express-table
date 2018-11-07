package com.bedenko.genaro.expresstable.models;

public class FloorPlan {

    private int floorPlanID;
    private int restaurantID;
    private int imageID;

    public FloorPlan() {

        // Can create a blank instance if no parameters passed
    }

    public FloorPlan(int floorPlanID, int restaurantID, int imageID) {

        // Create a new instance when all parameters are passed
        this.floorPlanID = floorPlanID;
        this.restaurantID = restaurantID;
        this.imageID = imageID;
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

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }
}
