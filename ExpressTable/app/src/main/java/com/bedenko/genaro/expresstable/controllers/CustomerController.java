package com.bedenko.genaro.expresstable.controllers;

import android.content.ContentValues;

import com.bedenko.genaro.expresstable.models.Customer;
import com.bedenko.genaro.expresstable.persistence.DatabaseHandler;

public class CustomerController {

    public Customer createCustomer(String aName, String aUsername, String aEmailAddress, String aPasswordHash) {

        Customer customer = new Customer();

        customer.setName(aName);
        customer.setUsername(aUsername);
        customer.setEmailAddress(aEmailAddress);
        customer.setPasswordHash(aPasswordHash);

        return(customer);
    }

    public void addCustomerToDB(DatabaseHandler db, Customer customer) {

        ContentValues customerValues = new ContentValues();
        customerValues.put("name", customer.getName() );
        customerValues.put("username", customer.getUsername());
        customerValues.put("email_address", customer.getEmailAddress());
        customerValues.put("password_hash", customer.getPasswordHash());

        db.write("customers", customerValues);
    }

    public String getCustomerFromDB(DatabaseHandler db, Customer customer) {

        String query = "SELECT username FROM customers WHERE username=" + customer.getUsername();

        String queryResult = db.readCustomerRecord(query);

        return queryResult;
    }
}
