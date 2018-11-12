package com.bedenko.genaro.expresstable.persistence;

import android.content.ContentValues;

import com.bedenko.genaro.expresstable.models.Customer;

import java.util.ArrayList;

public class CustomerRepo {

    public void addCustomerToDB(DatabaseHandler db, Customer customer) {

        ContentValues customerValues = new ContentValues();
        customerValues.put("name", customer.getName() );
        customerValues.put("username", customer.getUsername());
        customerValues.put("email_address", customer.getEmailAddress());
        customerValues.put("password_hash", customer.getPasswordHash());

        db.write("customers", customerValues);
    }

    public ArrayList<Customer> getAllCustomers() {

        ArrayList<Customer> retrievedCustomers = new ArrayList<>();

        return retrievedCustomers;
    }

    public Customer getCustomer(Customer customer) {

        Customer retrievedCustomer = new Customer();

        return retrievedCustomer;
    }

    public void updateCustomer(Customer customer) {

    }

    public void deleteCustomer(Customer customer) {

    }
}
