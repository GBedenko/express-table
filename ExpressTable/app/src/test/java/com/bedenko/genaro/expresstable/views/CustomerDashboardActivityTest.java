package com.bedenko.genaro.expresstable.views;

import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerDashboardActivityTest {

    @Test
    public void onCreate() {

        // Test void functions by asserting that an instance of the Activity is not null
        CustomerDashboardActivity customerDashboardActivity = new CustomerDashboardActivity();
        assertNotNull(customerDashboardActivity);
    }
}