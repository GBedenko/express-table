package com.bedenko.genaro.expresstable.models;

public class Booking {

    private int bookingID = -1;
    private int customerID;
    private int restaurantID;
    private String date;
    private String time;
    private int tableNumber;

    public Booking() {

        // Can create a blank instance if no parameters passed
    }

    public Booking(int bookingID, int customerID, int restaurantID, String date, String time, int tableNumber) {

        // Create a new instance when all parameters are passed
        this.bookingID = bookingID;
        this.customerID = customerID;
        this.restaurantID = restaurantID;
        this.date = date;
        this.time = time;
        this.tableNumber = tableNumber;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
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

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }
}
