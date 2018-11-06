package com.bedenko.genaro.expresstable.models;

/**
 * Created by Genaro Bedenko for 300CEM Android Application Development Assignment
 * File first created on 06/11/2018
 *
 * @author bedenkog
 */
public class Candidate {

    private String name;
    private String detail;
    private int photo;

    public Candidate(String name, String detail, int photo) {
        this.name = name;
        this.detail = detail;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public String getDetail() {
        return detail;
    }

    public int getPhoto() {
        return photo;
    }

    @Override
    public String toString() {
        return detail;
    }
}
