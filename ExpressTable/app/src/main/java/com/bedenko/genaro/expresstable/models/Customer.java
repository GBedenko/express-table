package com.bedenko.genaro.expresstable.models;

/*
  Created by Genaro Bedenko
  
  @author gbedenko
 */

public class Customer {

    private String customerID;
    private String username;
    private String passwordHash;

    public Customer() {

        // Can create a blank instance if no parameters passed
    }

    public Customer(String username, String passwordHash) {

        // Can create an instance based on just login credentials
        this.username = username;
        this.passwordHash = passwordHash;
    }

    public Customer(String customerID, String username, String passwordHash) {

        // Create a new instance when all parameters are passed
        this.customerID = customerID;
        this.username = username;
        this.passwordHash = passwordHash;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}
