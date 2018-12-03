package com.bedenko.genaro.expresstable.views;

/*
  Created by Genaro Bedenko for 300CEM Android Application Development Assignment
  Student ID 7060234
  @author bedenkog
 */

import org.junit.Test;

import static org.junit.Assert.*;

public class ViewRestaurantActivityTest {

    @Test
    public void onCreate() {

        // Test void functions by asserting that an instance of the Activity is not null
        ViewRestaurantActivity viewRestaurantActivity = new ViewRestaurantActivity();
        assertNotNull(viewRestaurantActivity);
    }

    @Test
    public void getRestaurantIDBeingViewed() {

        ViewRestaurantActivity viewRestaurantActivity = new ViewRestaurantActivity();
        viewRestaurantActivity.setRestaurantIDBeingViewed("1");
        assertEquals(viewRestaurantActivity.getRestaurantIDBeingViewed(), "1");
    }

    @Test
    public void setRestaurantIDBeingViewed() {

        ViewRestaurantActivity viewRestaurantActivity = new ViewRestaurantActivity();
        viewRestaurantActivity.setRestaurantIDBeingViewed("1");
        assertEquals(viewRestaurantActivity.getRestaurantIDBeingViewed(), "1");
    }

    @Test
    public void getRestaurantNameBeingViewed() {

        ViewRestaurantActivity viewRestaurantActivity = new ViewRestaurantActivity();
        viewRestaurantActivity.setRestaurantNameBeingViewed("test_restaurant_name");
        assertEquals(viewRestaurantActivity.getRestaurantNameBeingViewed(), "test_restaurant_name");
    }

    @Test
    public void setRestaurantNameBeingViewed() {

        ViewRestaurantActivity viewRestaurantActivity = new ViewRestaurantActivity();
        viewRestaurantActivity.setRestaurantNameBeingViewed("test_restaurant_name");
        assertEquals(viewRestaurantActivity.getRestaurantNameBeingViewed(), "test_restaurant_name");
    }
}