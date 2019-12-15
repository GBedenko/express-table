package com.bedenko.genaro.expresstable.views;

/*
  Created by Genaro Bedenko
  
  @author gbedenko
 */

import org.junit.Test;

import static org.junit.Assert.*;

public class NewCustomerActivityTest {

    @Test
    public void onCreate() {

        // Test void functions by asserting that an instance of the Activity is not null
        NewCustomerActivity newCustomerActivity = new NewCustomerActivity();
        assertNotNull(newCustomerActivity);
    }
}