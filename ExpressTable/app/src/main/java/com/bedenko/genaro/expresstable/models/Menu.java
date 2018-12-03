package com.bedenko.genaro.expresstable.models;

/*
  Created by Genaro Bedenko for 300CEM Android Application Development Assignment
  Student ID 7060234
  @author bedenkog
 */

public class Menu {

    private int menuID = -1;
    private int restaurantID;
    private byte[] image;

    public Menu() {

        // Can create a blank instance if no parameters passed
    }

    public Menu(int menuID, int restaurantID, byte[] image) {

        // Create a new instance when all parameters are passed
        this.menuID = menuID;
        this.restaurantID = restaurantID;
        this.image = image;
    }

    public int getMenuID() {
        return menuID;
    }

    public void setMenuID(int menuID) {
        this.menuID = menuID;
    }

    public int getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(int restaurantID) {
        this.restaurantID = restaurantID;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
