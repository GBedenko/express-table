package com.bedenko.genaro.expresstable.views;

import org.junit.Test;

import static org.junit.Assert.*;

public class ViewRestaurantActivityTest {

    @Test
    public void onCreate() {
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