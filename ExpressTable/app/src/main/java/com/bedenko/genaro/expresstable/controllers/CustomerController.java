package com.bedenko.genaro.expresstable.controllers;

import com.bedenko.genaro.expresstable.models.Customer;

public class CustomerController {

    public Customer createCustomer(String aName, String aUsername, String emailAddress, String aPasswordHash) {

        Customer customer = new Customer();

        // Set values for what a customer will store
        // customer.setCustomerID(aCustomerID);
        // Rest to follow

        return(customer);
    }
}
