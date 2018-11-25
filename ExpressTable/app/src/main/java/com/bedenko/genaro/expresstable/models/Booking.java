package com.bedenko.genaro.expresstable.models;

public class Booking {

    private int customerID;
    private int restaurantID;
    private String date;
    private String time;
    private String tableNumber;

    public Booking() {

        // Can create a blank instance if no parameters passed
    }

    public Booking(int customerID, int restaurantID, String date, String time, String tableNumber) {

        // Create a new instance when all parameters are passed
        this.customerID = customerID;
        this.restaurantID = restaurantID;
        this.date = date;
        this.time = time;
        this.tableNumber = tableNumber;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(int restaurantID) {
        this.restaurantID = restaurantID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(String tableNumber) {
        this.tableNumber = tableNumber;
    }
}
