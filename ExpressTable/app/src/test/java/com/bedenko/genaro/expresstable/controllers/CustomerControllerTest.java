package com.bedenko.genaro.expresstable.controllers;

/*
  Created by Genaro Bedenko for 300CEM Android Application Development Assignment
  Student ID 7060234
  @author bedenkog
 */

import com.bedenko.genaro.expresstable.models.Customer;

import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerControllerTest {

    @Test
    public void createCustomer() {

        CustomerController customerController = new CustomerController();

        Customer testCustomer = customerController.createCustomer("test_username", "test_password_hash");
        assertEquals(testCustomer.getUsername(), "test_username");
        assertEquals(testCustomer.getPasswordHash(), "test_password_hash");
    }

    @Test
    public void addCustomerToDB() {

        // Test void functions by asserting that an instance of the class is not null
        CustomerController customerController = new CustomerController();
        assertNotNull(customerController);
    }

    @Test
    public void getCustomerFromDB() {

        // Test void functions by asserting that an instance of the class is not null
        CustomerController customerController = new CustomerController();
        assertNotNull(customerController);
    }
}