package com.bedenko.genaro.expresstable.models;

public class Restaurant {

    private String restaurantID;
    private String username;
    private String restaurantName;
    private String passwordHash;
    private byte[] logoImage;
    private byte[] menuImage;
    private byte[] floorPlanImage;
    private double restaurantLatitude;
    private double restaurantLongitude;
    private String restaurantAddress;

    public Restaurant() {

        // Can create a blank instance if no parameters passed
    }

    public Restaurant(String username, String passwordHash) {

        // Can create an instance based on just login credentials
        this.username = username;
        this.passwordHash = passwordHash;
    }

    public Restaurant(String restaurantName, String restaurantAddress, byte[] restaurantLogo) {

        // Constructor used for ListView of Restaurants
        this.restaurantName = restaurantName;
        this.restaurantAddress = restaurantAddress;
        this.logoImage = restaurantLogo;
    }

    public Restaurant(String restaurantID, String username, String restaurantName, String passwordHash, byte[] restaurantLogo, double restaurantLatitude, double restaurantLongitude, String restaurantAddress) {

        // Create a new instance when all parameters are passed
        this.restaurantID = restaurantID;
        this.username = username;
        this.restaurantName = restaurantName;
        this.passwordHash = passwordHash;
        this.logoImage = restaurantLogo;
        this.restaurantLatitude = restaurantLatitude;
        this.restaurantLongitude = restaurantLongitude;
        this.restaurantAddress = restaurantAddress;
    }

    public String getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(String restaurantID) {
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

    public byte[] getLogoImage() {
        return logoImage;
    }

    public void setLogoImage(byte[] logoImage) {
        this.logoImage = logoImage;
    }

    public byte[] getMenuImage() {
        return menuImage;
    }

    public void setMenuImage(byte[] menuImage) {
        this.menuImage = menuImage;
    }

    public byte[] getFloorPlanImage() {
        return floorPlanImage;
    }

    public void setFloorPlanImage(byte[] floorPlanImage) {
        this.floorPlanImage = floorPlanImage;
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

    public String getRestaurantAddress() {
        return restaurantAddress;
    }

    public void setRestaurantAddress(String restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }
}
