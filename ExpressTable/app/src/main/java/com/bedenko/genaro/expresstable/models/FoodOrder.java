package com.bedenko.genaro.expresstable.models;

public class FoodOrder {

    private int floorPlanID = -1;
    private int bookingID;
    private String[] foodOrder;

    public FoodOrder() {

        // Can create a blank instance if no parameters passed
    }

    public FoodOrder(int bookingID, String[] foodOrder) {

        // Create a new instance when all parameters are passed
        this.bookingID = bookingID;
        this.foodOrder = foodOrder;
    }

    public int getFloorPlanID() {
        return floorPlanID;
    }

    public void setFloorPlanID(int floorPlanID) {
        this.floorPlanID = floorPlanID;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public String[] getFoodOrder() {
        return foodOrder;
    }

    public void setFoodOrder(String[] foodOrder) {
        this.foodOrder = foodOrder;
    }
}
