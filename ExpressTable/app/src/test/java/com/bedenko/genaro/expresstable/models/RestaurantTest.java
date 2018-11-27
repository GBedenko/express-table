package com.bedenko.genaro.expresstable.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class RestaurantTest {

    @Test
    public void getRestaurantID() {
        Restaurant restaurant = new Restaurant(1234, "test_username",
                "test_restaurant_name", "test_password_hash",
                "test_restaurant_type", 10);
        assertEquals(restaurant.getRestaurantID(), 1234);
    }

    @Test
    public void setRestaurantID() {
        Restaurant restaurant = new Restaurant(1234, "test_username",
                "test_restaurant_name", "test_password_hash",
                "test_restaurant_type", 10);
        restaurant.setRestaurantID(2222);
        assertEquals(restaurant.getRestaurantID(), 2222);
    }

    @Test
    public void getUsername() {
        Restaurant restaurant = new Restaurant(1234, "test_username",
                "test_restaurant_name", "test_password_hash",
                "test_restaurant_type",  10);
        assertEquals(restaurant.getUsername(), "test_username");
    }

    @Test
    public void setUsername() {
        Restaurant restaurant = new Restaurant(1234, "test_username",
                "test_restaurant_name", "test_password_hash",
                "test_restaurant_type", 10);
        restaurant.setUsername("new_username");
        assertEquals(restaurant.getUsername(), "new_username");
    }

    @Test
    public void getRestaurantName() {
        Restaurant restaurant = new Restaurant(1234, "test_username",
                "test_restaurant_name", "test_password_hash",
                "test_restaurant_type", 10);
        assertEquals(restaurant.getRestaurantName(), "test_restaurant_name");
    }

    @Test
    public void setRestaurantName() {
        Restaurant restaurant = new Restaurant(1234, "test_username",
                "test_restaurant_name", "test_password_hash",
                "test_restaurant_type", 10);
        restaurant.setRestaurantName("new_restaurant_name");
        assertEquals(restaurant.getRestaurantName(), "new_restaurant_name");
    }

    @Test
    public void getPasswordHash() {
        Restaurant restaurant = new Restaurant(1234, "test_username",
                "test_restaurant_name", "test_password_hash",
                "test_restaurant_type", 10);
        assertEquals(restaurant.getPasswordHash(), "test_password_hash");
    }

    @Test
    public void setPasswordHash() {
        Restaurant restaurant = new Restaurant(1234, "test_username",
                "test_restaurant_name", "test_password_hash",
                "test_restaurant_type", 10);
        restaurant.setPasswordHash("new_password_hash");
        assertEquals(restaurant.getPasswordHash(), "new_password_hash");
    }

    @Test
    public void getGpsLocation() {
        Restaurant restaurant = new Restaurant(1234, "test_username",
                "test_restaurant_name", "test_password_hash",
                "test_restaurant_type", 10);
        assertEquals(restaurant.getGpsLocation(), "test_GPS");
    }

    @Test
    public void setGpsLocation() {
        Restaurant restaurant = new Restaurant(1234, "test_username",
                "test_restaurant_name", "test_password_hash",
                "test_restaurant_type", 10);
        restaurant.setGpsLocation("new_GPS");
        assertEquals(restaurant.getGpsLocation(), "new_GPS");
    }

    @Test
    public void getRestaurantPhoto() {
        Restaurant restaurant = new Restaurant(1234, "test_username",
                "test_restaurant_name", "test_password_hash",
                "test_restaurant_type", 10);
        assertEquals(restaurant.getRestaurantPhoto(), 10);
    }

    @Test
    public void setRestaurantPhoto() {
        Restaurant restaurant = new Restaurant(1234, "test_username",
                "test_restaurant_name", "test_password_hash",
                "test_restaurant_type", 10);
        restaurant.setRestaurantPhoto(20);
        assertEquals(restaurant.getRestaurantPhoto(), 20);
    }
}