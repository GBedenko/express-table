package com.bedenko.genaro.expresstable.controllers;

import com.bedenko.genaro.expresstable.models.Restaurant;

import org.junit.Test;

import static org.junit.Assert.*;

public class RestaurantControllerTest {

    @Test
    public void createRestaurant() {

        RestaurantController restaurantController = new RestaurantController();

        Restaurant testRestaurant = restaurantController.createRestaurant("test_username", "test_restaurant_name",
                                                                        "test_password_hash", "test_gps_location");
        assertEquals(testRestaurant.getUsername(), "test_username");
        assertEquals(testRestaurant.getRestaurantName(), "test_restaurant_name");
        assertEquals(testRestaurant.getPasswordHash(), "test_password_hash");
        assertEquals(testRestaurant.getGpsLocation(), "test_gps_location");
    }

    @Test
    public void addRestaurantToDB() {

        // Test void functions by asserting that an instance of the class is not null
        RestaurantController restaurantController = new RestaurantController();
        assertNotNull(restaurantController);
    }

    @Test
    public void getRestaurantFromDB() {
        assertEquals("todo", "fake_result");
    }
}