package com.bedenko.genaro.expresstable.models;

public class FoodOrder {

    private int bookingID;
    private String[] foodOrderArray;

    public FoodOrder() {

        // Can create a blank instance if no parameters passed
    }

    public FoodOrder(int bookingID, String[] foodOrderArray) {

        // Create a new instance when all parameters are passed
        this.bookingID = bookingID;
        this.foodOrderArray = foodOrderArray;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public String[] getFoodOrderArray() {
        return foodOrderArray;
    }

    public void setFoodOrderArray(String[] foodOrderArray) {
        this.foodOrderArray = foodOrderArray;
    }
}
