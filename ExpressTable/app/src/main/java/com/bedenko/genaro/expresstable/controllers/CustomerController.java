package com.bedenko.genaro.expresstable.controllers;

import android.content.ContentValues;

import com.bedenko.genaro.expresstable.models.Customer;
import com.bedenko.genaro.expresstable.persistence.CustomerRepo;

public class CustomerController {

    public Customer createCustomer(String aName, String aUsername, String aEmailAddress, String aPasswordHash) {

        Customer customer = new Customer();

        customer.setName(aName);
        customer.setUsername(aUsername);
        customer.setEmailAddress(aEmailAddress);
        customer.setPasswordHash(aPasswordHash);

        return(customer);
    }
}
