package com.bedenko.genaro.expresstable.models;

/**
 * Created by Genaro Bedenko for 300CEM Android Application Development Assignment
 * Student ID 7060234
 * @author bedenkog
 */

public class Customer {

    private int customerID;
    private String name;
    private String username;
    private String emailAddress;
    private String passwordHash;

    public Customer() {

        // Can create a blank instance if no parameters passed
    }

    public Customer(int customerID, String name, String username, String emailAddress, String passwordHash) {

        // Create a new instance when all parameters are passed
        this.customerID = customerID;
        this.name = name;
        this.username = username;
        this.emailAddress = emailAddress;
        this.passwordHash = passwordHash;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}
