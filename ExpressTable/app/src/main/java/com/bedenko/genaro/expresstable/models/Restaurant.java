package com.bedenko.genaro.expresstable.models;

import android.graphics.Bitmap;

public class Restaurant {

    private int restaurantID = -1;
    private String username;
    private String restaurantName;
    private String passwordHash;
    private Bitmap logoImage;
    private Bitmap menuImage;
    private Bitmap floorPlanImage;
    private String gpsLocation;
    private String restaurantType;

    public Restaurant() {

        // Can create a blank instance if no parameters passed
    }

    public Restaurant(String username, String passwordHash) {

        // Can create an instance based on just login credentials
        this.username = username;
        this.passwordHash = passwordHash;
    }

    public Restaurant(String restaurantName, String restaurantType, Bitmap restaurantLogo) {

        // Constructor used for ListView of Restaurants
        this.restaurantName = restaurantName;
        this.restaurantType = restaurantType;
        this.logoImage = restaurantLogo;
    }

    public Restaurant(int restaurantID, String username, String restaurantName, String passwordHash, String gpsLocation, String restaurantType, Bitmap restaurantLogo) {

        // Create a new instance when all parameters are passed
        this.restaurantID = restaurantID;
        this.username = username;
        this.restaurantName = restaurantName;
        this.passwordHash = passwordHash;
        this.gpsLocation = gpsLocation;
        this.restaurantType = restaurantType;
        this.logoImage = restaurantLogo;
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

    public String getGpsLocation() {
        return gpsLocation;
    }

    public void setGpsLocation(String gpsLocation) {
        this.gpsLocation = gpsLocation;
    }

    public String getRestaurantType() {
        return restaurantType;
    }

    public void setRestaurantType(String restaurantType) {
        this.restaurantType = restaurantType;
    }

    public Bitmap getLogoImage() {
        return logoImage;
    }

    public void setLogoImage(Bitmap logoImage) {
        this.logoImage = logoImage;
    }

    public Bitmap getMenuImage() {
        return menuImage;
    }

    public void setMenuImage(Bitmap menuImage) {
        this.menuImage = menuImage;
    }

    public Bitmap getFloorPlanImage() {
        return floorPlanImage;
    }

    public void setFloorPlanImage(Bitmap floorPlanImage) {
        this.floorPlanImage = floorPlanImage;
    }

}
