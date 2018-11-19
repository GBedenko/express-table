package com.bedenko.genaro.expresstable.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {

    @Test
    public void getCustomerID() {
        Customer customer = new Customer(1234, "test_username", "test_password");
        assertEquals(customer.getCustomerID(), 1234);
    }

    @Test
    public void setCustomerID() {
        Customer customer = new Customer(1234, "test_username", "test_password");
        customer.setCustomerID(4321);
        assertEquals(customer.getCustomerID(), 4321);
    }

    @Test
    public void getUsername() {
        Customer customer = new Customer(1234, "test_username", "test_password");
        assertEquals(customer.getUsername(), "test_username");
    }

    @Test
    public void setUsername() {
        Customer customer = new Customer(1234, "test_username", "test_password");
        customer.setUsername("new_username");
        assertEquals(customer.getUsername(), "new_username");
    }

    @Test
    public void getPasswordHash() {
        Customer customer = new Customer(1234, "test_username", "test_password");
        assertEquals(customer.getPasswordHash(), "test_password");
    }

    @Test
    public void setPasswordHash() {
        Customer customer = new Customer(1234, "test_username", "test_password");
        customer.setPasswordHash("new_password");
        assertEquals(customer.getPasswordHash(), "new_password");
    }
}