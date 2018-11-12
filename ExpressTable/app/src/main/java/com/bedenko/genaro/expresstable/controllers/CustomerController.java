package com.bedenko.genaro.expresstable.controllers;

import android.content.ContentValues;

import com.bedenko.genaro.expresstable.models.Customer;
import com.bedenko.genaro.expresstable.persistence.DatabaseHandler;

public class CustomerController {

    public Customer createCustomer(String aUsername, String aPasswordHash) {

        Customer customer = new Customer();

        customer.setUsername(aUsername);
        customer.setPasswordHash(aPasswordHash);

        return(customer);
    }

    public void addCustomerToDB(DatabaseHandler db, Customer customer) {

        ContentValues customerValues = new ContentValues();
        customerValues.put("username", customer.getUsername());
        customerValues.put("password_hash", customer.getPasswordHash());

        db.write("customers", customerValues);
    }

    public String getCustomerFromDB(DatabaseHandler db, Customer customer) {

        String query = "SELECT username FROM customers WHERE username=" + customer.getUsername();

        String queryResult = db.readCustomerRecord(query);

        return queryResult;
    }
}
