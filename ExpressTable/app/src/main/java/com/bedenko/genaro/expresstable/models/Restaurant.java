package com.bedenko.genaro.expresstable.models;

public class Restaurant {

    private int restaurantID;
    private String username;
    private String restaurantName;
    private String emailAddress;
    private String passwordHash;
    private int numberOfTables;
    private String gpsLocation;
    private String postcode;

    public Restaurant() {

        // Can create a blank instance if no parameters passed
    }

    public Restaurant(String username, String restaurantName, String emailAddress, String passwordHash, int numberOfTables, String gpsLocation, String postcode) {

        // Create a new instance when all parameters are passed
        this.username = username;
        this.restaurantName = restaurantName;
        this.emailAddress = emailAddress;
        this.passwordHash = passwordHash;
        this.numberOfTables = numberOfTables;
        this.gpsLocation = gpsLocation;
        this.postcode = postcode;
    }

    public int getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(int restaurantID) {
        this.restaurantID = restaurantID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public int getNumberOfTables() {
        return numberOfTables;
    }

    public void setNumberOfTables(int numberOfTables) {
        this.numberOfTables = numberOfTables;
    }

    public String getGpsLocation() {
        return gpsLocation;
    }

    public void setGpsLocation(String gpsLocation) {
        this.gpsLocation = gpsLocation;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}
