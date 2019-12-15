package com.bedenko.genaro.expresstable.controllers;

/*
  Created by Genaro Bedenko
  
  @author gbedenko
 */

import android.content.ContentValues;
import android.util.Log;

import com.bedenko.genaro.expresstable.models.Customer;
import com.bedenko.genaro.expresstable.persistence.DatabaseHandler;

import java.util.ArrayList;

public class CustomerController {

    // Define TAG used for debugging purposes
    private static final String TAG = "CustomerController";

    // Create a Customer object by providing the required parameters
    // Used for the create a new customer screen
    public Customer createCustomer(String aUsername, String aPasswordHash) {

        // Create new empty instance of Customer
        Customer customer = new Customer();

        // Populate the instance's attributes with the provided parameters
        customer.setUsername(aUsername);
        customer.setPasswordHash(aPasswordHash);

        // Return populated Customer object
        return(customer);
    }

    // Calls the DatabaseHandler to store a Customer instance in SQLite
    // Assigns the values from the input Customer object so that the receiving SQL statement will be able to use it
    // Void function that doesn't return anything after sending the new Customer to be stored
    public void addCustomerToDB(DatabaseHandler db, Customer customer) {

        ContentValues customerValues = new ContentValues();
        customerValues.put("username", customer.getUsername());
        customerValues.put("password_hash", customer.getPasswordHash());

        db.write("customers", customerValues);
    }

    // Calls DatabaseHandler to check whether the provided customer is already in the SQLite database or not
    // Check is done based on the Customer's username and password hash
    // If both of them match a record in SQLite, then it will return true, otherwise returns false
    public boolean isCustomerInDB(DatabaseHandler db, Customer customer) {

        // Log to see which customer the function will be looking for
        Log.d(TAG, "Checking if following customer details are stored in DB: " + customer.getUsername() + " " + customer.getPasswordHash());

        // From the database, retrieves an arraylist of all customers
        ArrayList<Customer> allCustomersInDB = db.readAllCustomers();

        // Loop through the list of customers, if username and password_hash match, return true
        for(int i=0; i <= allCustomersInDB.size()-1; i++) {
            if(allCustomersInDB.get(i).getUsername().equals(customer.getUsername())) {
                if(allCustomersInDB.get(i).getPasswordHash().equals(customer.getPasswordHash())) {
                    Log.d(TAG, "Customer details found in DB");
                    return true;
                }
            }
        }

        // If reached the end of the function, then the Customer details don't match any that are in SQLite
        // Therefore, return false
        Log.d(TAG, "Customer details not in DB");
        return false;
    }

    // Calls DatabaseHandler to return a Customer object stored in SQLite database that matches the provided one
    // Returns all of the customer's details instead of just confirming if they are in the database
    public Customer getCustomerFromDB(DatabaseHandler db, Customer customer) {

        // From the database, retrieves an arraylist of all customers
        ArrayList<Customer> allCustomersInDB = db.readAllCustomers();

        // Loop through the list of customers, if username and password_hash match, return the current Customer object
        for(int i=0; i <= allCustomersInDB.size()-1; i++) {
            if(allCustomersInDB.get(i).getUsername().equals(customer.getUsername())) {
                if(allCustomersInDB.get(i).getPasswordHash().equals(customer.getPasswordHash())) {
                    return allCustomersInDB.get(i);
                }
            }
        }

        // If reached the end of the function, then the Customer details don't match any that are in SQLite
        // Therefore, return the Customer object that was entered as a parameter
        return customer;
    }
}
