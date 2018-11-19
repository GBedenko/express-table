package com.bedenko.genaro.expresstable.views;

import org.junit.Test;

import static org.junit.Assert.*;

public class RestaurantDashboardActivityTest {

    @Test
    public void onCreate() {

        // Test void functions by asserting that an instance of the Activity is not null
        RestaurantDashboardActivity restaurantDashboardActivity = new RestaurantDashboardActivity();
        assertNotNull(restaurantDashboardActivity);
    }
}