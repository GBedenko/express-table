package com.bedenko.genaro.expresstable.models;

/**
 * Created by Genaro Bedenko for 300CEM Android Application Development Assignment
 * File first created on 22/10/2018
 *
 * @author bedenkog
 */

public class User {

    private String username;
    private String emailAddress;
    private String password_hash;

    public User(String username, String emailAddress, String password_hash) {
        // Contain any variables assigned to all instances
        this.username = username;
        this.emailAddress = emailAddress;
        this.password_hash = password_hash;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return emailAddress;
    }

    public void setEmail(String email) {
        this.emailAddress = email;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }
}
