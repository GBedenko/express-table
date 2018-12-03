package com.bedenko.genaro.expresstable.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class RestaurantTest {

    byte[] testByteArray = new byte[0];

    @Test
    public void getRestaurantID() {
        Restaurant restaurant = new Restaurant("1234", "test_username",
                "test_restaurant_name", "test_password_hash", testByteArray, 50.0, 50.0,
                "test_restaurant_addres");
        assertEquals(restaurant.getRestaurantID(), 1234);
    }

    @Test
    public void setRestaurantID() {
        Restaurant restaurant = new Restaurant("1234", "test_username",
                "test_restaurant_name", "test_password_hash", testByteArray, 50.0, 50.0,
                "test_restaurant_addres");
        restaurant.setRestaurantID("2222");
        assertEquals(restaurant.getRestaurantID(), "2222");
    }

    @Test
    public void getUsername() {
        Restaurant restaurant = new Restaurant("1234", "test_username",
                "test_restaurant_name", "test_password_hash", testByteArray, 50.0, 50.0,
                "test_restaurant_addres");
        assertEquals(restaurant.getUsername(), "test_username");
    }

    @Test
    public void setUsername() {
        Restaurant restaurant = new Restaurant("1234", "test_username",
                "test_restaurant_name", "test_password_hash", testByteArray, 50.0, 50.0,
                "test_restaurant_addres");
        restaurant.setUsername("new_username");
        assertEquals(restaurant.getUsername(), "new_username");
    }

    @Test
    public void getRestaurantName() {
        Restaurant restaurant = new Restaurant("1234", "test_username",
                "test_restaurant_name", "test_password_hash", testByteArray, 50.0, 50.0,
                "test_restaurant_addres");
        assertEquals(restaurant.getRestaurantName(), "test_restaurant_name");
    }

    @Test
    public void setRestaurantName() {
        Restaurant restaurant = new Restaurant("1234", "test_username",
                "test_restaurant_name", "test_password_hash", testByteArray, 50.0, 50.0,
                "test_restaurant_addres");
        restaurant.setRestaurantName("new_restaurant_name");
        assertEquals(restaurant.getRestaurantName(), "new_restaurant_name");
    }

    @Test
    public void getPasswordHash() {
        Restaurant restaurant = new Restaurant("1234", "test_username",
                "test_restaurant_name", "test_password_hash", testByteArray, 50.0, 50.0,
                "test_restaurant_addres");
        assertEquals(restaurant.getPasswordHash(), "test_password_hash");
    }

    @Test
    public void setPasswordHash() {
        Restaurant restaurant = new Restaurant("1234", "test_username",
                "test_restaurant_name", "test_password_hash", testByteArray, 50.0, 50.0,
                "test_restaurant_addres");
        restaurant.setPasswordHash("new_password_hash");
        assertEquals(restaurant.getPasswordHash(), "new_password_hash");
    }
}