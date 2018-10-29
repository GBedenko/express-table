package com.bedenko.genaro.expresstable.models;

public class Restaurant {

    private String name;
    private String type;
    private int numberOfTables;
    private String city;
    private String coordinates;
    private String postcode;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public Restaurant(String name, String type, int numberOfTables, String postcode) {
        // Contain any variables assigned to all instances
        this.name = name;
        this.type = type;
        this.numberOfTables = numberOfTables;
        this.postcode = postcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public int getNumberOfTables() {
        return numberOfTables;
    }

    public void setNumberOfTables(int number_of_tables) {
        this.numberOfTables = number_of_tables;
    }
}
