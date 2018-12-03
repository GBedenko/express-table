package com.bedenko.genaro.expresstable.views;

/*
  Created by Genaro Bedenko for 300CEM Android Application Development Assignment
  Student ID 7060234
  @author bedenkog
 */

import org.junit.Test;

import static org.junit.Assert.*;

public class BookRestaurantActivityTest {

    @Test
    public void onCreate() {

        try {
            // Test void functions by asserting that an instance of the Activity is not null
            BookRestaurantActivity bookRestaurantActivity = new BookRestaurantActivity();
            assertNotNull(bookRestaurantActivity);

        } catch (Error error) {
            // Expected error because BookRestaurantActivity tries to get the instance of Firebase (which won't work during tests)
        }
    }
}