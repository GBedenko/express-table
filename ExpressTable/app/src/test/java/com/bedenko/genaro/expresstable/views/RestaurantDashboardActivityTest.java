package com.bedenko.genaro.expresstable.views;

/*
  Created by Genaro Bedenko for 300CEM Android Application Development Assignment
  Student ID 7060234
  @author bedenkog
 */

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