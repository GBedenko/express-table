package com.bedenko.genaro.expresstable.controllers;

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
    }

    @Test
    public void getCustomerFromDB() {

        CustomerController customerController = new CustomerController();

//        Customer testCustomer = customerController.getCustomerFromDB();
        assertEquals("todo", "fake_result");
    }
}