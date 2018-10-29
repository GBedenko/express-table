package com.bedenko.genaro.expresstable.models;

/**
 * Created by Genaro Bedenko for 300CEM Android Application Development Assignment
 * File first created on 22/10/2018
 *
 * @author bedenkog
 */

public class Owner extends User {

    private Restaurant restaurant;

    public Owner(String username, String emailAddress, String password_hash, Restaurant restaurant) {
        super(username, emailAddress, password_hash);
        this.restaurant = restaurant;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
