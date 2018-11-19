package com.bedenko.genaro.expresstable.controllers;

import android.content.ContentValues;

import com.bedenko.genaro.expresstable.models.Customer;
import com.bedenko.genaro.expresstable.persistence.DatabaseHandler;

import java.util.ArrayList;

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

    public boolean isCustomerInDB(DatabaseHandler db, Customer customer) {

        // From the database, retrieves an arraylist of all customers
        ArrayList<Customer> allCustomersInDB = db.readAllCustomers();

        // Loop through the list of customers, if username and password_has match, return true
        // Else, return false
        for(int i=0; i <= allCustomersInDB.size()-1; i++) {
            if(allCustomersInDB.get(i).getUsername().equals(customer.getUsername())) {
                if(allCustomersInDB.get(i).getPasswordHash().equals(customer.getPasswordHash())) {
                    return true;
                }
            }
        }

        return false;
    }
}
