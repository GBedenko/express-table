package com.bedenko.genaro.expresstable.models;

/*
  Created by Genaro Bedenko for 300CEM Android Application Development Assignment
  Student ID 7060234
  @author bedenkog
 */

public class FoodOrder {

    private int foodOrderID = -1;
    private int bookingID;
    private String foodOrder;

    public FoodOrder() {

        // Can create a blank instance if no parameters passed
    }

    public FoodOrder(int foodOrderID, int bookingID, String foodOrder) {

        // Create a new instance when all parameters are passed
        this.foodOrderID = foodOrderID;
        this.bookingID = bookingID;
        this.foodOrder = foodOrder;
    }

    public int getFoodOrderID() {
        return foodOrderID;
    }

    public void setFoodOrderID(int foodOrderID) {
        this.foodOrderID = foodOrderID;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public String getFoodOrder() {
        return foodOrder;
    }

    public void setFoodOrder(String foodOrder) {
        this.foodOrder = foodOrder;
    }
}
