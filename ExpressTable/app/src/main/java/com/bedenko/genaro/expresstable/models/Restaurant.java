package com.bedenko.genaro.expresstable.models;

public class Restaurant {

    private int restaurantID = -1;
    private String username;
    private String restaurantName;
    private String passwordHash;
    private String restaurantType;
    private int restaurantPhoto;
    private double restaurantLatitude;
    private double restaurantLongitude;

    public Restaurant() {

        // Can create a blank instance if no parameters passed
    }

    public Restaurant(String username, String passwordHash) {

        // Can create an instance based on just login credentials
        this.username = username;
        this.passwordHash = passwordHash;
    }

    public Restaurant(String restaurantName, String restaurantType, int restaurantPhoto) {

        // Constructor used for ListView of Restaurants
        this.restaurantName = restaurantName;
        this.restaurantType = restaurantType;
        this.restaurantPhoto = restaurantPhoto;
    }

    public Restaurant(int restaurantID, String username, String restaurantName, String passwordHash, String restaurantType, int restaurantPhoto, double restaurantLatitude, double restaurantLongitude) {

        // Create a new instance when all parameters are passed
        this.restaurantID = restaurantID;
        this.username = username;
        this.restaurantName = restaurantName;
        this.passwordHash = passwordHash;
        this.restaurantType = restaurantType;
        this.restaurantPhoto = restaurantPhoto;
        this.restaurantLatitude = restaurantLatitude;
        this.restaurantLongitude = restaurantLongitude;
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

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getRestaurantType() {
        return restaurantType;
    }

    public void setRestaurantType(String restaurantType) {
        this.restaurantType = restaurantType;
    }

    public int getRestaurantPhoto() {
        return restaurantPhoto;
    }

    public void setRestaurantPhoto(int restaurantPhoto) {
        this.restaurantPhoto = restaurantPhoto;
    }

    public double getRestaurantLatitude() {
        return restaurantLatitude;
    }

    public void setRestaurantLatitude(double restaurantLatitude) {
        this.restaurantLatitude = restaurantLatitude;
    }

    public double getRestaurantLongitude() {
        return restaurantLongitude;
    }

    public void setRestaurantLongitude(double restaurantLongitude) {
        this.restaurantLongitude = restaurantLongitude;
    }
}
