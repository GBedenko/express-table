package com.bedenko.genaro.expresstable.controllers;

import com.bedenko.genaro.expresstable.models.Customer;

public class CustomerController {

    public Customer createCustomer(String aName, String aUsername, String aEmailAddress, String aPasswordHash) {

        Customer customer = new Customer();

        customer.setName(aName);
        customer.setUsername(aUsername);
        customer.setEmailAddress(aEmailAddress);
        customer.setPasswordHash(aPasswordHash);

        // Function calls to write to database persistence
        // customerRepo.write(customer);

        return(customer);
    }
}
