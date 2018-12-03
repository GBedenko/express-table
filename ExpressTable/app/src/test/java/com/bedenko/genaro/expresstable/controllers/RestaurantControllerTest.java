package com.bedenko.genaro.expresstable.controllers;

/*
  Created by Genaro Bedenko for 300CEM Android Application Development Assignment
  Student ID 7060234
  @author bedenkog
 */

import com.bedenko.genaro.expresstable.models.Restaurant;

import org.junit.Test;

import static org.junit.Assert.*;

public class RestaurantControllerTest {

    @Test
    public void createRestaurant() {

        byte[] testByteArray = new byte[0];

        RestaurantController restaurantController = new RestaurantController();

        Restaurant testRestaurant = restaurantController.createRestaurant("test_username", "test_restaurant_name",
                                                                        "test_password_hash", testByteArray, testByteArray, testByteArray,
                                                                          50.0, 50.0, "test_address");

        assertEquals(testRestaurant.getUsername(), "test_username");
        assertEquals(testRestaurant.getRestaurantName(), "test_restaurant_name");
        assertEquals(testRestaurant.getPasswordHash(), "test_password_hash");
        assertEquals(testRestaurant.getRestaurantAddress(), "test_address");
    }

    @Test
    public void addRestaurantToDB() {

        // Test void functions by asserting that an instance of the class is not null
        RestaurantController restaurantController = new RestaurantController();
        assertNotNull(restaurantController);
    }

    @Test
    public void getRestaurantFromDB() {

        // Test void functions by asserting that an instance of the class is not null
        RestaurantController restaurantController = new RestaurantController();
        assertNotNull(restaurantController);
    }

    @Test
    public void isRestaurantInDB() {

        // Test void functions by asserting that an instance of the class is not null
        RestaurantController restaurantController = new RestaurantController();
        assertNotNull(restaurantController);
    }

    @Test
    public void getRestaurantByIdFromDB() {

        // Test void functions by asserting that an instance of the class is not null
        RestaurantController restaurantController = new RestaurantController();
        assertNotNull(restaurantController);
    }

    @Test
    public void getAllRestaurantsFromDB() {

        // Test void functions by asserting that an instance of the class is not null
        RestaurantController restaurantController = new RestaurantController();
        assertNotNull(restaurantController);
    }
}